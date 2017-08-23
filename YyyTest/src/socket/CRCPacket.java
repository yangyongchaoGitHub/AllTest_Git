package socket;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.ByteBuffer;

public class CRCPacket {	
	private Integer sessionId;
	private Byte target;
	private Integer rsn;
	private Integer length;
	private ByteBuffer dtu;

	public CRCPacket() {
		sessionId = 0;
		target = 0;
		length = 0;
		rsn = 0;
		dtu = null;
	}

	private void init(Integer sessionId, Byte target, Boolean isResponse, Integer sn, ByteBuffer dtu) {
		this.sessionId = sessionId;
		this.target = target;
		this.rsn = CRCProtocol.mkrsn(isResponse, sn);
		this.dtu = dtu;
		this.length = dtu.capacity();
	}
	
	public CRCPacket(Integer sessionId, Byte target, Boolean isResponse, Integer sn, Object obj) {
		init(sessionId, target, isResponse, sn, serializer(obj));
	}

	public Integer getSessionId() {
		return sessionId;
	}

	public void setSessionId(Integer sessionId) {
		this.sessionId = sessionId;
	}

	public Byte getTarget() {
		return target;
	}

	public void setTarget(Byte target) {
		this.target = target;
	}

	public Boolean getIsResponse() {
		return CRCProtocol.isResponse(rsn) ;
	}

	public void setIsResponse(Boolean isResponse) {
		this.rsn = CRCProtocol.mkrsn(isResponse, rsn);
	}

	public Integer getSN() {
		return CRCProtocol.sn(rsn);
	}

	public void setSN(Integer sn) {
		this.rsn = CRCProtocol.mkrsn(CRCProtocol.isResponse(rsn), sn);
	}
	
	public void setRSN(int rsn) {
		this.rsn = rsn;
	}
	
	public int getRSN() {
		return rsn;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public ByteBuffer getDtu() {
		return dtu;
	}

	public void setDtu(ByteBuffer dtu) {
		this.dtu = dtu;
	}
	
	public void deserializer(ByteBuffer hdr, ByteBuffer dtu) {
		this.sessionId = CRCProtocol.sessionId(hdr);
		this.target = CRCProtocol.target(hdr);
		this.rsn = CRCProtocol.rsn(hdr);
		this.length = CRCProtocol.length(hdr);
		this.dtu = dtu;
	}

	public ByteBuffer serializer(){
		return CRCProtocol.encode(sessionId, target, rsn, length, dtu);
	}
	
	/**
	 * get object from dtu which was received from network
	 * @return
	 */
	public static Object deserializer(Class<?> clazz, ByteBuffer bb) {
		try {
			return new ObjectMapper().readValue(bb.toString(), clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * set object to dtu which will be sent to network
	 */
	public static ByteBuffer serializer(Object object) {
		try {
			return ByteBuffer.wrap(
					new ObjectMapper().writeValueAsString(object).getBytes()
			);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return null;
	}
}

package socket;

import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.Arrays;


/**
 * Cloud Research Company's Protocol
 * header + data transfer unit(DTU)
 * @header: 
 * session id(int) + target(1 byte) + response flag(1 bit) + 
 * serial number(23 bit) + DTU length(int) 
 * @DTU:
 * 	TODO: make it able to package mulit diffent kind objects
 */

public class CRCProtocol {
	public enum Content {
		HDR,
		DTU;
	}
	/**
	 * protocol header contract
	 */
	final public static int HDR_SIZE = 12;
	final public static int HDR_OS_SESSIONID = 0;
	final public static int HDR_OS_LENGTH = 8;
	final public static int HDR_OS_TARGET = 4;
	final public static int HDR_OS_RSN = 5;
	
	/**
	 * row configure
	 */
	final public static byte GET_CONFIG = 0x70;
	final public static byte PUT_CONFIG = 0x71;
	final public static byte NEW_CONFIG = 0x72;
	
	/**
	 * action define
	 */
	final class Action {
		final public static byte CREATE = 0x0;
		final public static byte GETONE = 0x1;
		final public static byte SEARCH = 0x2;
		final public static byte UPDATE = 0x3;
		final public static byte DELETE = 0x4;
		final public static byte INJECT = 0x5;
		final public static byte REJECT = 0x6;
		final public static byte LOGIN = 0x7;
		
		/*public Request.Action toRequestAction(Action action) {
			
			return null;
		}*/
	}
	/**
	 * target define
	 */
	final class Target {
		final public static byte CONCENTRATOR = 0x00;
		final public static byte ACTUATOR = 0x01;
		final public static byte HEATMETER = 0x02;
		final public static byte EVENT = 0x03;
		final public static byte HOUSE = 0x4;
		final public static byte OWNER = 0x5;
		final public static byte LOG = 0x06;
		final public static byte COLLECT = 0x07;
	}
		
	final public static byte action(byte type) {
		return (byte) ((type&0xF0)>>4);
	}
	
	final public static byte target(byte type) {
		return (byte)(type&0x0F);
	}
	
	final public static Boolean isResponse(int rsn) {
		return (rsn & 0x800000) != 0 ? true : false;
	}
	
	final public static int mkrsn(boolean isResponse, int v) {
		return isResponse ? (0x800000|v) : sn(v);
	}
	
	final public static int sn(int rsn) {
		return rsn & 0x7fffff;
	}

	final public static int length(ByteBuffer bb) {	
		return bb.getInt(HDR_OS_LENGTH);
	}

	final public static int sessionId(ByteBuffer hdr) {
		return hdr.getInt(HDR_OS_SESSIONID);
	}

	final public static byte target(ByteBuffer hdr) {
		return hdr.get(HDR_OS_TARGET);
	}

	final public static int rsn(ByteBuffer hdr){
		return (hdr.get(HDR_OS_RSN)<<16) | (hdr.get(HDR_OS_RSN+1)<<8) | hdr.get(HDR_OS_RSN+2);
	}
	
	final public static byte mktype(byte target, byte action) {
		return (byte)((action << 4) | target);
	}
	
	final public static ByteBuffer encode(int sessionId, byte target, int rsn, int size, ByteBuffer dtu) {
		ByteBuffer bb = ByteBuffer.allocate(HDR_SIZE + size);
		
		bb.putInt(sessionId);
		
		bb.put(target);
		
		bb.put((byte) ((rsn >> 16) & 0xFF));
		bb.put((byte) ((rsn >>  8) & 0xFF));
		bb.put((byte) ((rsn >>  0) & 0xFF));
		
		bb.putInt(size);
		
		bb.put(dtu);
		
		return bb;
	}
}

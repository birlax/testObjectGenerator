package com.birlax.traversal;

import java.util.ArrayList;
import java.util.List;

public class ObjectWithPrimitiveFields {

	/**
	 * Primitive Boolean
	 */
	private boolean primitiveBoolean;
	private byte primitiveByte;
	private short primitiveShort;
	private int primitiveInt;

    private Double bigDouble;

    private ObjectWithPrimitiveFields generalRefTypeClass;

    private List rawGenericTypeList;

    private ArrayList<String> concreateGenericType;

    private ObjectWithPrimitiveFields[] arrayClass;

	private long primitiveLong;
	private char primitiveChar;
	private float primitiveFloat;
	private double primitivedouble;

    private List[] rawListArray;

    private List<String>[] listArray;

    private Object op;

	public boolean isPrimitiveBoolean() {
		return primitiveBoolean;
	}

	public void setPrimitiveBoolean(boolean primitiveBoolean) {
		this.primitiveBoolean = primitiveBoolean;
	}

	public byte getPrimitiveByte() {
		return primitiveByte;
	}

	public void setPrimitiveByte(byte primitiveByte) {
		this.primitiveByte = primitiveByte;
	}

	public short getPrimitiveShort() {
		return primitiveShort;
	}

	public void setPrimitiveShort(short primitiveShort) {
		this.primitiveShort = primitiveShort;
	}

	public int getPrimitiveInt() {
		return primitiveInt;
	}

	public void setPrimitiveInt(int primitiveInt) {
		this.primitiveInt = primitiveInt;
	}

	public long getPrimitiveLong() {
		return primitiveLong;
	}

	public void setPrimitiveLong(long primitiveLong) {
		this.primitiveLong = primitiveLong;
	}

	public char getPrimitiveChar() {
		return primitiveChar;
	}

	public void setPrimitiveChar(char primitiveChar) {
		this.primitiveChar = primitiveChar;
	}

	public float getPrimitiveFloat() {
		return primitiveFloat;
	}

	public void setPrimitiveFloat(float primitiveFloat) {
		this.primitiveFloat = primitiveFloat;
	}

	public double getPrimitivedouble() {
		return primitivedouble;
	}

	public void setPrimitivedouble(double primitivedouble) {
		this.primitivedouble = primitivedouble;
	}

}

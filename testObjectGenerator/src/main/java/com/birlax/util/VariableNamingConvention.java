package com.birlax.util;

public interface VariableNamingConvention {
	/**
	 * Returns Camel casing string with the convention of keeping the first
	 * letter of the string in lower case
	 * 
	 * @param name
	 * @return
	 */
	String simpleName(String name);
}

package com.birlax.util.impl;

import java.util.Random;

import com.birlax.util.VariableNamingConvention;

public class VariableNamingConventionImpl implements VariableNamingConvention {

	private static int randomNamedFieldsCount = 0;
	private static final int GENERATEDVARIABLENAMELENGTH = 6;
	/*
	 * This is lower range for desired character while generating the variable
	 * or field name using randome characters, this represent lower 'a' in ASCII
	 * character set
	 */
	private static final int DESIREDCHARLOWERBOUND = 97;
	/*
	 * This is upper range for desired character while generating the variable
	 * or field name using random characters, this represent lower 'z' in ASCII
	 * character set
	 */

	private static final int DESIREDCHSRUPPERBOUND = 122;

	@Override
    public String getSimpleVariableName(String name) {
        if (name == null || name.isEmpty())
			return randomFieldNameGenerator();
		if (name.length() == 1) {
			return name.toLowerCase();
		}

		return name.substring(0, 1).toLowerCase() + name.substring(1);
	}


	private String randomFieldNameGenerator() {

		char randomName[] = new char[GENERATEDVARIABLENAMELENGTH];
		Random random = new Random();
		// Set this value to -1 so that random characters are always generated
		int randomNo = -1;
		for (int i = 0; i < GENERATEDVARIABLENAMELENGTH; i++, randomNo = -1) {
			while (randomNo < DESIREDCHARLOWERBOUND
					|| randomNo > DESIREDCHSRUPPERBOUND) {
				randomNo = random.nextInt(127);
			}
			randomName[i] = (char) randomNo;
		}
		randomNamedFieldsCount++;
		return new String(randomName) + "" + randomNamedFieldsCount;
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSimpleSetterName(String name) {
        if (name == null || name.isEmpty())
            return "";
        if (name.length() == 1) {
            return "get" + name.toUpperCase();
        }

        return "get" + name.substring(0, 1).toUpperCase() + name.substring(1);

    }

}

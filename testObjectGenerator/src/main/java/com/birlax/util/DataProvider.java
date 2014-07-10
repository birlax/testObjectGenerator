package com.birlax.util;

import java.lang.reflect.Field;

public interface DataProvider {

    /**
     * Provide random data based on dataType works only for 8 primitive types and their wrapper classes,
     * java.lang.String
     */

    String provideDataBasedOnDataType(Field field);

}

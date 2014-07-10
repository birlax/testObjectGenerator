package com.birlax.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractDataProvider implements DataProvider {

    private Map<String, Object> mapOfPrimitivesToValues = new HashMap<String, Object>();

    private void init() {
        mapOfPrimitivesToValues.put(boolean.class.getTypeName(), true);
        mapOfPrimitivesToValues.put(int.class.getTypeName(), 2);
        mapOfPrimitivesToValues.put(char.class.getTypeName(), 'c');
        mapOfPrimitivesToValues.put(long.class.getTypeName(), 35545);
    }

    @Override
    public String provideDataBasedOnDataType(Field field) {
        init();
        String genericTypeName = field.getGenericType().toString();
        if (field.getType().isPrimitive()) {
            // Is a primitive type
            return "" + mapOfPrimitivesToValues.get(field.getGenericType().toString());
        } else {
            // Is a ref type.
        }
        return "xx";
    }

}

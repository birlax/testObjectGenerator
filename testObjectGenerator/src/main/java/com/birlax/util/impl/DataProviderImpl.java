/**
 * 
 */
package com.birlax.util.impl;

import java.lang.reflect.Field;

import com.birlax.util.AbstractDataProvider;
import com.birlax.util.DataProvider;

/**
 * @author Birlax
 */
public class DataProviderImpl extends AbstractDataProvider implements DataProvider {

    /*
     * (non-Javadoc)
     * 
     * @see com.birlax.util.DataProvider#provideDataBasedOnDataType(java.lang.reflect.Field)
     */
    @Override
    public String provideDataBasedOnDataType(Field field) {
        return super.provideDataBasedOnDataType(field);

    }

}


package com.birlax.traversal;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.birlax.util.VariableNamingConvention;
import com.birlax.util.impl.VariableNamingConventionImpl;

public class TraverseObjectGraph {

    VariableNamingConvention variableNamingConvention = new VariableNamingConventionImpl();

    /* private zero parameter constructor */
    private TraverseObjectGraph() {
    }

    private static final String typeNameInterface = "interface";

    private static final String typeNameClass = "class";

    /**
     * Method return Engine to be used to traverse the object to generate the TestObjects.
     * 
     * @return
     */
    public static TraverseObjectGraph getTestObjectGenerator() {
        TraverseObjectGraph traverseObjectGraph = new TraverseObjectGraph();
        return traverseObjectGraph;
    }

    public void generate(List<String> fullyQualifiedJavaBeansInClassPath) {
        if (fullyQualifiedJavaBeansInClassPath == null || fullyQualifiedJavaBeansInClassPath.isEmpty())
            return;
        Map<String, String> warningsAndErrors = new HashMap<>();
        for (String className : fullyQualifiedJavaBeansInClassPath) {
            try {
                Class<?> clazz = Class.forName(className);
                dfsTraversal(clazz, "com.birlax", "a");
            } catch (ClassNotFoundException exception) {
                warningsAndErrors.put(className, exception.toString());
                exception.printStackTrace();
            }
        }
        printWarningAndErors(warningsAndErrors);
    }

    private void printWarningAndErors(Map<String, String> warningsAndErrors) {
        if (warningsAndErrors.isEmpty()) {
            System.out.println("Done!! with out any issues");
            return;
        }
        for (Map.Entry<String, String> mapEntrySet : warningsAndErrors.entrySet()) {
            System.out.println(mapEntrySet.getKey() + " :: " + mapEntrySet.getValue());
        }
    }

    private void dfsTraversal(Class<?> clazz, String packageToStop, String currentVariable) {
        Field[] declareFields = clazz.getDeclaredFields();
        // Field[] sortedByPrimitiveFirst = new Field[declareFields.length];
        int[] newLocations = new int[declareFields.length];
        int orderIndex = 0;
        for (Field field : declareFields) {

            if (toBeSkipped(field)) {
                newLocations[orderIndex] = -1;
            } else {
                newLocations[orderIndex] = orderIndex;

            }
            orderIndex++;

        }
        int i = 0;
        for (Field field : declareFields) {
            if (newLocations[i] == -1) {
                i++;
                continue;
            } else {
                System.out.println(currentVariable + "."
                        + variableNamingConvention.getSimpleSetterName(field.getName()) + "();  " + newLocations[i]);
                i++;
            }
        }
    }

    private boolean toBeSkipped(Field field) {
        /*
         * Skip interfaces
         */
        if (field.getGenericType().toString().contains(typeNameInterface))
            return true;
        /*
         * Arrays are always classType ignore then as well
         */
        if (field.getGenericType().toString().contains("["))
            return true;
        /*
         * Skip concrete & raw parameterised types
         */
        if (field.getGenericType().toString().contains("<"))
            return true;

        return false;
    }
}

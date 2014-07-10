package com.birlax.traversal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.birlax.util.DataProvider;
import com.birlax.util.TraversalConfig;
import com.birlax.util.VariableNamingConvention;
import com.birlax.util.impl.DataProviderImpl;
import com.birlax.util.impl.TraversalState;
import com.birlax.util.impl.VariableNamingConventionImpl;

/**
 * Class traversal to spit the Test Objects always give preferences to Fields declared in the Class, then Inherited
 * Fields and then Field that are them-self Classes;
 * 
 * @author Birlax
 */
public class TraverseObjectGraph {

    private VariableNamingConvention variableNamingConvention = new VariableNamingConventionImpl();
    private DataProvider dataProvider = new DataProviderImpl();

    private TraversalConfig config;

    /*
     * private zero parameter constructor return defualt configuration traversal Engine
     */
    private TraverseObjectGraph() {
        config = new TraversalConfig();
        config.setClassesToSkipWhileTraversalInheritedPath(new ArrayList<String>());
        // config.setDfsDepthToStopAt(TraversalConfig.MAXDFSDEPTH);
        config.setDfsDepthToStopAt(0);
        config.setInheritedFieldsToBeTraversed(TraversalConfig.INHERITANCEPATHTOTRAVERSE);
        config.setInitializeObject(TraversalConfig.INSTANTIATEOBJECT);
        config.setMaxInheritedHeightToBeTraversed(TraversalConfig.MAXINHERITANCEDEPTH);
        config.setPackageLevelMaxDFSDepthToStopAt("java.lang");
        config.setPackageLevelMaxInheritedHeightToStopAt("java.lang");

    }

    private TraverseObjectGraph(TraversalConfig config) {
        this.config = config;
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
                System.out.println(clazz.getName() + "a1 = new XC();");
                TraversalState traversalState = new TraversalState();
                traversalState.setCurrentDfsDepth(0);
                traversalState.setCurrentInheritanceHeight(0);
                traversalState.setCurrentVairableName("df");
                dfsTraversal(clazz, traversalState);
                /*
                 * if (config.isInheritedFieldsToBeTraversed()) { dfsTraversal(clazz.getSuperclass(), 0); }
                 */
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

    private void dfsTraversal(Class<?> clazz, TraversalState traversalState) {

        if (clazz.getPackage().getName().contains(config.getPackageLevelMaxInheritedHeightToStopAt())) {
            return;
        }

        if (clazz.getPackage().getName().contains(config.getPackageLevelMaxDFSDepthToStopAt())) {
            return;
        }

        if (config.getDfsDepthToStopAt() != 0 && traversalState.getCurrentDfsDepth() >= config.getDfsDepthToStopAt())
            return;

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

                System.out.println(traversalState.getCurrentVairableName() + "."
                        + variableNamingConvention.getSimpleSetterName(field.getName()) + "("
                        + dataProvider.provideDataBasedOnDataType(field) + ");");
                if (field.getGenericType().toString().contains(typeNameClass)) {
                    System.out.println("Entering into ::  " + field.getGenericType().toString());
                    traversalState.setCurrentDfsDepth(traversalState.getCurrentDfsDepth() + 1);
                    dfsTraversal(field.getType(), traversalState);
                    traversalState.setCurrentDfsDepth(traversalState.getCurrentDfsDepth() - 1);
                }
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

        System.out.println(field.getName());
        return false;
    }
}

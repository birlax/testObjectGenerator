/**
 * 
 */
package com.birlax.util.impl;

import com.birlax.util.TraversalConfig;

/**
 * Class abstracts the various runtime parameters to be stored on the Stack for traversal
 * 
 * @author Birlax
 */
public class TraversalState {

    /**
     * Records current distance traverse in inherited path use to halt traversal post limit has reach as specified by
     * {@link TraversalConfig#MAXINHERITANCEDEPTH}
     */
    private int currentInheritanceHeight;
    /**
     * Records current distance traverse in inherited path use to halt traversal post limit has reach as specified by
     * {@link TraversalConfig#MAXDFSDEPTH}
     */
    private int currentDfsDepth;
    /**
     * Records current variableName to be used in getter/setters
     */
    private String currentVairableName;

    public int getCurrentInheritanceHeight() {
        return currentInheritanceHeight;
    }

    public void setCurrentInheritanceHeight(int currentInheritanceHeight) {
        this.currentInheritanceHeight = currentInheritanceHeight;
    }

    public int getCurrentDfsDepth() {
        return currentDfsDepth;
    }

    public void setCurrentDfsDepth(int currentDfsDepth) {
        this.currentDfsDepth = currentDfsDepth;
    }

    public String getCurrentVairableName() {
        return currentVairableName;
    }

    public void setCurrentVairableName(String currentVairableName) {
        this.currentVairableName = currentVairableName;
    }
}

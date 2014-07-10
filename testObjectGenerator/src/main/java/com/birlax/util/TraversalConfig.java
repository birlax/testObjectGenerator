package com.birlax.util;

import java.util.List;

/**
 * Class to hold traversal configurations
 * 
 */
public class TraversalConfig {

	public static final int MAXDFSDEPTH = 4;

	public static final int MAXINHERITANCEDEPTH = 4;

	public static final boolean INHERITANCEPATHTOTRAVERSE = true;

	public static final boolean INSTANTIATEOBJECT = false;

	/**
	 * Traversal Field into Field will be stopped post total current depth so
	 * far traversed is greater than equal to this value
	 * 
	 * Always defined : Default 4
	 * 
	 * If set to 0 only declaredMembers are initialized, references are
	 * initialized to non-null but they are not enriched further
	 */

	/**
	 * Default depth to traverse before stopping going further in, while doing
	 * Object traversal. Mostly the case of classes which hold reference to
	 * it-self like Graph Node{} or any Class having Child and Parent relations.
	 */

	private int dfsDepthToStopAt;
	/**
	 * Similar to that of dfsDepthToStopAt where traversal is stop in
	 * Field->Field basis this parameter prevents too much of traversal in
	 * parent Hierarchy, reaching till java.lang.Object, we need to avoid that.
	 */

	private int maxInheritedHeightToBeTraversed;

	/**
	 * Same as dfsDepthToStopAt but rather than stopping after fixed # of steps
	 * in the depth, this parameter if set stops traversal if current reference
	 * type is defined in this package, has no impact if type it' a primitive,
	 * or dfsDepthToStopAt is already reached. Default : Not defined, traversal
	 * will reach max-package-depth <= dfsDepthToStopAt
	 */
	private String packageLevelMaxDFSDepthToStopAt;

	/**
	 * Exactly same as fullyQualifiedPackageDFSStopDepth but rather than
	 * stopping at package it stop at the class. Which so ever is first
	 * depth/package/class
	 * 
	 * Default : Not defined, traverse max-depth <= <= dfsDepthToStopAt
	 */
	private String classLevelMaxDFSDepthToStopAt;

	/*
	 * Default true, if set false Objects inherited methods will not be
	 * instantiated and they will be set to NULL for reference fields and
	 * primitive fields will take values as per JLS rules.
	 */
	private boolean inheritedFieldsToBeTraversed;

	/**
	 * Same as packageLevelMaxDFSDepthToStopAt with diff only that this stop
	 * traversal on inherited path up before reaching java.lang.Object
	 */
	private String packageLevelMaxInheritedHeightToStopAt;

	/*
	 * Same as packageLevelMaxInheritedHeightToStopAt with diff only that this
	 * stop traversal on inherited path up before reaching specified class This
	 * is fullyQualifiedClass
	 */
	private String classLevelMaxInheritedHeightToStopAt;

	List<String> classesToSkipWhileTraversalInheritedPath;

	/**
	 * Default value is false, if set to true rather than dumping the
	 * text/string getter/setter for object it will create an object and return.
	 * Useful for Adhoc testing and get to see the object before getting the
	 * actual object dump. This should be set to false where developer wants the
	 * objects to be dumped as text getter/setters and can move that to real
	 * javaTest classes.
	 * 
	 */
	private boolean initializeObject;

	public int getDfsDepthToStopAt() {
		return dfsDepthToStopAt;
	}

	public void setDfsDepthToStopAt(int dfsDepthToStopAt) {
		this.dfsDepthToStopAt = dfsDepthToStopAt;
	}

	public int isMaxInheritedHeightToBeTraversed() {
		return maxInheritedHeightToBeTraversed;
	}

	public void setMaxInheritedHeightToBeTraversed(
			int maxInheritedHeightToBeTraversed) {
		this.maxInheritedHeightToBeTraversed = maxInheritedHeightToBeTraversed;
	}

	public String getPackageLevelMaxDFSDepthToStopAt() {
		return packageLevelMaxDFSDepthToStopAt;
	}

	public void setPackageLevelMaxDFSDepthToStopAt(
			String packageLevelMaxDFSDepthToStopAt) {
		this.packageLevelMaxDFSDepthToStopAt = packageLevelMaxDFSDepthToStopAt;
	}

	public String getClassLevelMaxDFSDepthToStopAt() {
		return classLevelMaxDFSDepthToStopAt;
	}

	public void setClassLevelMaxDFSDepthToStopAt(
			String classLevelMaxDFSDepthToStopAt) {
		this.classLevelMaxDFSDepthToStopAt = classLevelMaxDFSDepthToStopAt;
	}

	public boolean isInheritedFieldsToBeTraversed() {
		return inheritedFieldsToBeTraversed;
	}

	public void setInheritedFieldsToBeTraversed(
			boolean inheritedFieldsToBeTraversed) {
		this.inheritedFieldsToBeTraversed = inheritedFieldsToBeTraversed;
	}

	public String getPackageLevelMaxInheritedHeightToStopAt() {
		return packageLevelMaxInheritedHeightToStopAt;
	}

	public void setPackageLevelMaxInheritedHeightToStopAt(
			String packageLevelMaxInheritedHeightToStopAt) {
		this.packageLevelMaxInheritedHeightToStopAt = packageLevelMaxInheritedHeightToStopAt;
	}

	public String getClassLevelMaxInheritedHeightToStopAt() {
		return classLevelMaxInheritedHeightToStopAt;
	}

	public void setClassLevelMaxInheritedHeightToStopAt(
			String classLevelMaxInheritedHeightToStopAt) {
		this.classLevelMaxInheritedHeightToStopAt = classLevelMaxInheritedHeightToStopAt;
	}

	public List<String> getClassesToSkipWhileTraversalInheritedPath() {
		return classesToSkipWhileTraversalInheritedPath;
	}

	public void setClassesToSkipWhileTraversalInheritedPath(
			List<String> classesToSkipWhileTraversalInheritedPath) {
		this.classesToSkipWhileTraversalInheritedPath = classesToSkipWhileTraversalInheritedPath;
	}

	public boolean isInitializeObject() {
		return initializeObject;
	}

	public void setInitializeObject(boolean initializeObject) {
		this.initializeObject = initializeObject;
	}

}

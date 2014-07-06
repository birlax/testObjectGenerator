package com.birlax.traversal;

import java.util.Collections;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.birlax.util.VariableNamingConvention;
import com.birlax.util.impl.VariableNamingConventionImpl;

public class TraverseObjectGraphTest {

    TraverseObjectGraph traverseObjectGraph = TraverseObjectGraph.getTestObjectGenerator();
	
	VariableNamingConvention fieldOrVariableNamingConvention = new VariableNamingConventionImpl();
	private static Logger LOG = LoggerFactory
			.getLogger(TraverseObjectGraph.class);

	@Test
	public void test() {
        traverseObjectGraph.generate(Collections.singletonList("com.birlax.traversal.ObjectWithPrimitiveFields"));
	}
}

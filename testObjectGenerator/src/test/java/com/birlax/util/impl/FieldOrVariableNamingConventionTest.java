package com.birlax.util.impl;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.birlax.traversal.TraverseObjectGraph;
import com.birlax.util.VariableNamingConvention;

public class FieldOrVariableNamingConventionTest {

	private static final Logger LOG = LoggerFactory
			.getLogger(TraverseObjectGraph.class);

	VariableNamingConvention field = new VariableNamingConventionImpl();
	
	@Test
	public void testSimpleName() {
        LOG.info(field.getSimpleVariableName(null));
		LOG.info(field.getSimpleVariableName(""));
		LOG.info(field.getSimpleVariableName("FieldOrVariableNamingConventionImpl"));
		LOG.info(field.getSimpleVariableName(""));
        LOG.info(field.getSimpleVariableName("234"));
	}
}

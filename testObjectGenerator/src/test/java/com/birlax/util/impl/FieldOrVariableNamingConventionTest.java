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
		LOG.info(field.simpleName(""));
		LOG.info(field.simpleName(""));
		LOG.info(field.simpleName("FieldOrVariableNamingConventionImpl"));
		LOG.info(field.simpleName(""));
		LOG.info(field.simpleName(""));
	}
}

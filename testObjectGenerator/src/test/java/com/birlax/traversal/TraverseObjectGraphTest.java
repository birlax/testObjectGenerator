package com.birlax.traversal;

import java.lang.reflect.Field;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TraverseObjectGraphTest {

	TraverseObjectGraph traverseObjectGraph = new TraverseObjectGraph();
	private static Logger LOG = LoggerFactory
			.getLogger(TraverseObjectGraph.class);

	@Test
	public void test() {
		LOG.info(TraverseObjectGraph.class.getCanonicalName());
		LOG.info(TraverseObjectGraph.class.getName());
		LOG.info(TraverseObjectGraph.class.getSimpleName());
		ObjectWithPrimitiveFields objectWithPrimitiveFields = new ObjectWithPrimitiveFields();
		for (Field field : objectWithPrimitiveFields.getClass()
				.getDeclaredFields()) {
			LOG.info(field.toGenericString());
		}

	}
}

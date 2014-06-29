package com.birlax.traversal;

import java.lang.reflect.Field;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.birlax.util.VariableNamingConvention;
import com.birlax.util.impl.VariableNamingConventionImpl;

public class TraverseObjectGraphTest {

	TraverseObjectGraph traverseObjectGraph = new TraverseObjectGraph();
	
	VariableNamingConvention fieldOrVariableNamingConvention = new VariableNamingConventionImpl();
	private static Logger LOG = LoggerFactory
			.getLogger(TraverseObjectGraph.class);

	@Test
	public void test() {
		LOG.info(TraverseObjectGraph.class.getSimpleName());
		String classSimplerName = TraverseObjectGraph.class.getSimpleName();
		String variableNameForClass =  fieldOrVariableNamingConvention.simpleName("");
		LOG.info(variableNameForClass);
		LOG.info(" = new ");
		LOG.info(classSimplerName);
		LOG.info("();");
		ObjectWithPrimitiveFields objectWithPrimitiveFields = new ObjectWithPrimitiveFields();
		
		for (Field field : objectWithPrimitiveFields.getClass()
				.getDeclaredFields()) {
			LOG.info(variableNameForClass + ".set"+field.getName()+"(45);");
		}

	}
}

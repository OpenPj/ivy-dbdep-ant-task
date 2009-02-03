package com.sourcesense.ant.dbdep.task.parser;

/*
 * Copyright 2008 Sourcesense
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under 
 * the License is distributed on an 
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and limitations under the License. 
 */

import java.util.Vector;

import junit.framework.TestCase;

import com.sourcesense.ant.dbdep.task.parser.DbDepIvyParser;
import com.sourcesense.ant.dbdep.task.parser.ivy.vo.IvyDependencies;
import com.sourcesense.ant.dbdep.task.parser.ivy.vo.IvyDependency;

/**
 * 
 * @author Piergiorgio Lucidi
 *
 */
public class DbDepIvyParserTest extends TestCase {

	private static final String IVY_TEST_FILE_PATH = "src/test/resources/ivy.xml";
	
	public void testParse(){
		DbDepIvyParser mateIvyParser = new DbDepIvyParser();
		IvyDependencies dependencies = mateIvyParser.parse(IVY_TEST_FILE_PATH);
		Vector depVector = dependencies.getDependencies();
		IvyDependency dep1 = (IvyDependency)depVector.get(0);
		IvyDependency dep2 = (IvyDependency)depVector.get(1);
		
		assertEquals("commons-lang", dep1.getName());
		assertEquals("2.0", dep1.getRev());
		assertEquals("commons-cli", dep2.getName());
		assertEquals("1.0",dep2.getRev());
	}
	
}

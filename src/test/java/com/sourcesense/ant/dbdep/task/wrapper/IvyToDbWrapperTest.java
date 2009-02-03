package com.sourcesense.ant.dbdep.task.wrapper;

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

import java.util.Iterator;
import java.util.List;

import com.sourcesense.ant.dbdep.task.dataobject.DependencyDO;
import com.sourcesense.ant.dbdep.task.parser.DbDepIvyParser;
import com.sourcesense.ant.dbdep.task.parser.ivy.vo.IvyDependencies;
import com.sourcesense.ant.dbdep.task.wrapper.DbDepIvyToDbWrapper;

import junit.framework.TestCase;

/**
 * 
 * @author Piergiorgio Lucidi
 *
 */
public class IvyToDbWrapperTest extends TestCase {

	public void testWrapper(){
		DbDepIvyToDbWrapper wrapper = new DbDepIvyToDbWrapper();
		IvyDependencies dependenciesIvy = new DbDepIvyParser().parse("src/test/resources/ivy.xml");
		List dependenciesDO = wrapper.getDependenciesDO(dependenciesIvy, "development",	 "Mock");
		Iterator i = dependenciesDO.iterator();
		assertEquals(2, dependenciesDO.size());
		int found = 0;
		while(i.hasNext()){
			DependencyDO dep = (DependencyDO)i.next();
			if("commons-lang".equals(dep.getName())
					|| "commons-cli".equals(dep.getName()))
				found++;
		}
		assertEquals(2,found);
	}
	
}

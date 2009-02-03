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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.sourcesense.ant.dbdep.task.dataobject.DependencyDO;
import com.sourcesense.ant.dbdep.task.parser.ivy.vo.IvyDependencies;
import com.sourcesense.ant.dbdep.task.parser.ivy.vo.IvyDependency;

/**
 *
 * @author Piergiorgio Lucidi
 *
 */
public class DbDepIvyToDbWrapper {
	
	public List getDependenciesDO(IvyDependencies dependencies, String environment, String project){
		List dependenciesForDb = new ArrayList();
		Iterator i = dependencies.getDependencies().iterator();
		while(i.hasNext()){
			IvyDependency dependency = (IvyDependency)i.next();
			DependencyDO dependencyDO = new DependencyDO();
			dependencyDO.setName(dependency.getName());
			dependencyDO.setVersion(dependency.getRev());
			dependencyDO.setEnvironment(environment);
			dependencyDO.setProject(project);
			dependenciesForDb.add(dependencyDO);
		}
		return dependenciesForDb;
	}
	
}

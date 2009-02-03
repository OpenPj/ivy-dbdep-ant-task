package com.sourcesense.ant.dbdep.task.parser.ivy.vo;

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author Piergiorgio Lucidi
 *
 */
public class IvyDependencies {

	private static Log log = LogFactory.getLog(IvyDependencies.class);
	private Vector dependencies;
	
	public IvyDependencies() {
		this.dependencies = new Vector();
	}
	
	public void addDependency(IvyDependency dependency){
		this.dependencies.addElement(dependency);
		if(log.isDebugEnabled())
			log.debug("IvyDependency added: "+dependency);
	}
	
	public String toString() {
		return "IvyDependencies: "+this.dependencies;
	}

	public Vector getDependencies() {
		return this.dependencies;
	}

	public void setDependencies(Vector dependencies) {
		this.dependencies = dependencies;
	}
	
}

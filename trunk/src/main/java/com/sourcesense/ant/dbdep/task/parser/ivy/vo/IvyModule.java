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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * @author Piergiorgio Lucidi
 *
 */
public class IvyModule {

	private static Log log = LogFactory.getLog(IvyModule.class);
	private IvyDependencies dependencies;
	private IvyInfo info;
	private String version;
	
	public void setDependencies(IvyDependencies dependencies){
		this.dependencies = dependencies;
		if(log.isDebugEnabled())
			log.debug("IvyDependencies: "+dependencies);
	}
	
	public void setInfo(IvyInfo info){
		this.info = info;
		if(log.isDebugEnabled())
			log.debug("IvyInfo: "+info);
	}
	
	public IvyDependencies getDependencies(){
		return this.dependencies;
	}

	public void setVersion(String version) {
		this.version = version;
		if(log.isDebugEnabled())
			log.debug("version: "+version);
	}

	public IvyInfo getInfo() {
		return info;
	}

	public String getVersion() {
		return version;
	}
	
	public void addInfo(IvyInfo info){
		this.info = info;
	}
	
	public void addDependencies(IvyDependencies dependencies){
		this.dependencies = dependencies;
	}
	
}

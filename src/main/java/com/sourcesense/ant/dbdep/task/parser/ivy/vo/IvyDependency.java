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
public class IvyDependency {

	private static Log log = LogFactory.getLog(IvyDependency.class);
	private String org;
	private String name;
	private String rev;
	
	public void setOrg(String org) {
		this.org = org;
		if(log.isDebugEnabled())
			log.debug("org: "+org);
		
	}
	public void setName(String name) {
		this.name = name;
		if(log.isDebugEnabled())
			log.debug("name: "+name);
	}
	public void setRev(String rev) {
		this.rev = rev;
		if(log.isDebugEnabled())
			log.debug("rev: "+rev);
	}
	
	public String toString() {
		return "IvyDependency | org: "+this.org+" | name: "+this.name+" | rev: "+this.rev;
	}
	
	public String getOrg() {
		return org;
	}
	public String getName() {
		return name;
	}
	public String getRev() {
		return rev;
	}
}

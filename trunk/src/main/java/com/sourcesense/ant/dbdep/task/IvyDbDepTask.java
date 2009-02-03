package com.sourcesense.ant.dbdep.task;

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

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sourcesense.ant.dbdep.task.bl.IDbDepAntBl;

/**
 * @author Piergiorgio Lucidi
 *
 */
public class IvyDbDepTask extends Task {

	private static final String SPRING_CONTEXT = "com/sourcesense/ant/dbdep/task/context/applicationContext.xml";
	private static final String DATASOURCE_BEAN_NAME = "ds";
	private String project;
	private String environment;
	private String ivyFilePath;
	private String databaseDriverClassName;
	private String databaseUrl;
	private String databaseUsername;
	private String databasePassword;
	
	public void execute() throws BuildException {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {SPRING_CONTEXT});
        IDbDepAntBl dbdepAntBl = (IDbDepAntBl)context.getBean(IDbDepAntBl.BEAN_NAME);
        BasicDataSource ds = (BasicDataSource)context.getBean(DATASOURCE_BEAN_NAME);
        ds.setDriverClassName(databaseDriverClassName);
        ds.setUrl(databaseUrl);
        ds.setUsername(databaseUsername);
        ds.setPassword(databasePassword);
        dbdepAntBl.writeDependencies(project,environment,ivyFilePath);
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public void setIvyFilePath(String ivyFilePath) {
		this.ivyFilePath = ivyFilePath;
	}

	public void setDatabaseDriverClassName(String databaseDriverClassName) {
		this.databaseDriverClassName = databaseDriverClassName;
	}

	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

	public void setDatabaseUsername(String databaseUsername) {
		this.databaseUsername = databaseUsername;
	}

	public void setDatabasePassword(String databasePassword) {
		this.databasePassword = databasePassword;
	}
	
}

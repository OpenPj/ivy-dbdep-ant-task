package com.sourcesense.ant.dbdep.task.bl;

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

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sourcesense.ant.dbdep.task.dao.DbDepDao;
import com.sourcesense.ant.dbdep.task.parser.DbDepIvyParser;
import com.sourcesense.ant.dbdep.task.parser.ivy.vo.IvyDependencies;
import com.sourcesense.ant.dbdep.task.wrapper.DbDepIvyToDbWrapper;

/**
 * 
 * @author Piergiorgio Lucidi
 *
 */
public class DbDepAntBl implements IDbDepAntBl {

	private static Log log = LogFactory.getLog(DbDepAntBl.class);
	private DbDepDao dbDepDao;
	private DbDepIvyParser dbDepIvyParser;
	private DbDepIvyToDbWrapper dbDepIvyToDbWrapper;
	
	public void writeDependencies(String project, String environment, String ivyFilePath) {
		log.info("IvyDbDep started for project: "+project);
		IvyDependencies dependencies = dbDepIvyParser.parse(ivyFilePath);
		List dependenciesDO =  dbDepIvyToDbWrapper.getDependenciesDO(dependencies, environment, project);
		dbDepDao.insertDependencies(dependenciesDO);
		log.info("IvyDbDep has finisched for project: "+project);
	}

	public void setDbDepDao(DbDepDao dbDepDao) {
		this.dbDepDao = dbDepDao;
	}

	public void setDbDepIvyParser(DbDepIvyParser dbDepIvyParser) {
		this.dbDepIvyParser = dbDepIvyParser;
	}

	public void setDbDepIvyToDbWrapper(DbDepIvyToDbWrapper dbDepIvyToDbWrapper) {
		this.dbDepIvyToDbWrapper = dbDepIvyToDbWrapper;
	}

	
	
}

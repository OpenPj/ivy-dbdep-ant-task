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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.digester.Digester;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.xml.sax.SAXException;

import com.sourcesense.ant.dbdep.task.parser.ivy.vo.IvyDependencies;
import com.sourcesense.ant.dbdep.task.parser.ivy.vo.IvyDependency;
import com.sourcesense.ant.dbdep.task.parser.ivy.vo.IvyInfo;
import com.sourcesense.ant.dbdep.task.parser.ivy.vo.IvyModule;

/**
 * 
 * @author Piergiorgio Lucidi
 *
 */
public class DbDepIvyParser {

	private static Log log = LogFactory.getLog(DbDepIvyParser.class);
	
	/**
	 * 
	 * @param filePath
	 * @return Vector di tutte le dipendenze lette dal file Ivy
	 */
	public IvyDependencies parse(String ivyFilePath) {
		
		//ivy-module
		Digester digester = new Digester();
		digester.setValidating(false);
		digester.addObjectCreate("ivy-module", IvyModule.class);
		digester.addSetProperties("ivy-module");

		//info
		digester.addObjectCreate("ivy-module/info", IvyInfo.class);
		digester.addSetProperties("ivy-module/info");
		digester.addBeanPropertySetter("ivy-module/info/organisation", "organisation");
		digester.addBeanPropertySetter("ivy-module/info/module", "module");
		digester.addSetNext("ivy-module/info", "addInfo");
		
		//dependencies
		digester.addObjectCreate("ivy-module/dependencies/", IvyDependencies.class);
		digester.addSetProperties("ivy-module/dependencies/");
		digester.addBeanPropertySetter("ivy-module/dependencies/dependencies", "dependencies");
		
		//dependency
		digester.addObjectCreate("ivy-module/dependencies/dependency", IvyDependency.class);
		digester.addSetProperties("ivy-module/dependencies/dependency");
		digester.addBeanPropertySetter("ivy-module/dependencies/dependency/org");
		digester.addBeanPropertySetter("ivy-module/dependencies/dependency/name");
		digester.addBeanPropertySetter("ivy-module/dependencies/dependency/rev");
		digester.addSetNext("ivy-module/dependencies/dependency", "addDependency");
		digester.addSetNext("ivy-module/dependencies", "addDependencies");
		
		FileInputStream inputFile = null;
		try {
			inputFile = new FileInputStream(ivyFilePath);
		} catch (FileNotFoundException e) {
			log.error("Apache Ivy input file not found",e);
			throw new RuntimeException("Apache Ivy input file not found",e);
		}
		
		IvyModule ivyModule = null;
	    try {
			 ivyModule = (IvyModule)digester.parse(inputFile);
		} catch (IOException e) {
			log.error("I/O Error during parsing Apache Ivy file",e);
			throw new RuntimeException("I/O Error during parsing Apache Ivy file",e);
		} catch (SAXException e) {
			log.error("Error during parsing Apache Ivy file",e);
			throw new RuntimeException("Error during parsing Apache Ivy file",e);
		}
		
		return ivyModule.getDependencies(); 
	}

}

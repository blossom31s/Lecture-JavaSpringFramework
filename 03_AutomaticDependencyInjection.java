# Maven Project File Structure
springTest
  src/main/java
    com.word
      WordSet.java
      MainClass.java
      MainClassUseAutowired.java
      MainClassUseResource.java
      MainClassUseInject.java
    com.word.dao
      WordDao.java
    com.word.service
      WordRegisterService.java
      WordRegisterServiceUseAutowired.java
      WordRegisterServiceUseResource.java
      WordRegisterServiceUseInject.java
      WordSearchService.java
      WordSearchServiceUseAutowired.java
      WordSearchServiceUseResource.java
      WordSearchServiceUseInject.java
  src/main/resources
    applicationContext.xml
    appCtxUseAutowired.java
    appCtxUseResource.java
    appCtxUseInject.java
  pom.xml

/*
// pom.xml

<project xmlns="http://maven.apache.org/POM/4.0.0"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>springLecture</groupId>
  <artifactId>springTest</artifactId>
  <version>0.0.1-SNAPSHOT</version>

	<dependencies>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>4.1.0.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>javax.annotation</groupId>
			<artifactId>javax.annotation-api</artifactId>
			<version>1.3.1</version>
		</dependency>
		<dependency>
			<groupId>javax.inject</groupId>
			<artifactId>javax.inject</artifactId>
			<version>1</version>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.1</version>
				<configuration>
					<source>1.8</source>
					<target>1.8</target>
					<encoding>utf-8</encoding>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

*/

/*
// applicationContext.xml

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="wordDao" class="com.word.dao.WordDao" />

	<bean id="registerService" class="com.word.service.WordRegisterService">
		<constructor-arg ref="wordDao" />
	</bean>

	<bean id="searchService" class="com.word.service.WordSearchService">
		<constructor-arg ref="wordDao" />
	</bean>

</beans>

*/

/*
// appCtxUseAutowired.java

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd 
 		http://www.springframework.org/schema/context 
 		http://www.springframework.org/schema/context/spring-context.xsd">

	<context:annotation-config />

	<bean id="wordDao" class="com.word.dao.WordDao">
		<!-- <qualifier value="usedDao"/> -->
	</bean>
	<bean id="wordDao2" class="com.word.dao.WordDao" />
	<bean id="wordDao3" class="com.word.dao.WordDao" />

	<bean id="registerService" class="com.word.service.WordRegisterServiceUseAutowired" />

	<bean id="searchService" class="com.word.service.WordSearchServiceUseAutowired" />

</beans>

*/

/*
// appCtxUseResource.java

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd 
 		http://www.springframework.org/schema/context 
 		http://www.springframework.org/schema/context/spring-context.xsd">

	<context:annotation-config />

	<bean id="wordDao" class="com.word.dao.WordDao">
		<!-- <qualifier value="usedDao"/> -->
	</bean>
	<bean id="wordDao2" class="com.word.dao.WordDao" />
	<bean id="wordDao3" class="com.word.dao.WordDao" />

	<bean id="registerService" class="com.word.service.WordRegisterServiceUseResource" />

	<bean id="searchService" class="com.word.service.WordSearchServiceUseResource" />

</beans>

*/

/*
// appCtxUseInject.java

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd 
 		http://www.springframework.org/schema/context 
 		http://www.springframework.org/schema/context/spring-context.xsd">

	<context:annotation-config />

	<bean id="wordDao1" class="com.word.dao.WordDao" />
	<bean id="wordDao2" class="com.word.dao.WordDao" />

	<bean id="registerService" class="com.word.service.WordRegisterServiceUseInject" />

	<bean id="searchService" class="com.word.service.WordSearchServiceUseInject" />

</beans>

*/

/*
// WordSet.java

package com.word;

public class WordSet {

	private String wordKey;
	private String wordValue;

	public WordSet(String wordKey, String wordValue) {
		this.wordKey = wordKey;
		this.wordValue = wordValue;
	}

	public String getWordKey() {
		return wordKey;
	}

	public void setWordKey(String wordKey) {
		this.wordKey = wordKey;
	}

	public String getWordValue() {
		return wordValue;
	}

	public void setWordValue(String wordValue) {
		this.wordValue = wordValue;
	}

}

*/

/*
// MainClass.java

package com.word;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.word.service.WordRegisterService;
import com.word.service.WordSearchService;

public class MainClass {

	public static void main(String[] args) {

		String[] keyWords = {"c", "c++", "java", "jsp", "spring"};
		String[] values = {"C는 1972년 켄 톰슨과 데니스 리치가 유닉스 운영 체제에서 사용하기 위해 개발한 프로그래밍 언어이다.", 
				"C++는 AT&T 벨 연구소의 비야네 스트롭스트룹이 1983년 발표하여 발전한 프로그래밍 언어이다.", 
				"자바는 썬 마이크로시스템즈의 제임스 고슬링(James Gosling)과 다른 연구원들이 개발한 객체 지향적 프로그래밍 언어이다.", 
				"JSP는 HTML내에 자바 코드를 삽입하여 웹 서버에서 동적으로 웹 페이지를 생성하여 웹 브라우저에 돌려주는 언어이다.", 
				"스프링 프레임워크는 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크로서 간단히 스프링이라고도 불린다."};

		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");

		WordRegisterService registerService =
				ctx.getBean("registerService", WordRegisterService.class);
		WordSearchService searchService =
				ctx.getBean("searchService", WordSearchService.class);

		// register
		for(int i=0 ; i<keyWords.length ; ++i) {
			WordSet wordSet = new WordSet(keyWords[i], values[i]);
			registerService.register(wordSet);
		}

		// search
		System.out.println("--------------------------------------------------"
				+ "--------------------------------------------------");
		for(int i=0 ; i<values.length ; ++i) {
			WordSet wordSet = searchService.searchWord(keyWords[i]);
			System.out.print(wordSet.getWordKey() + "\t : ");
			System.out.println(wordSet.getWordValue());
			System.out.println("--------------------------------------------------"
					+ "--------------------------------------------------");
		}
		System.out.println("\n\n");

		ctx.close();
	}

}

*/

/*
// MainClassUseAutowired.java

package com.word;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.word.service.WordRegisterServiceUseAutowired;
import com.word.service.WordSearchServiceUseAutowired;


public class MainClassUseAutowired {

	public static void main(String[] args) {

		String[] keyWords = {"c", "c++", "java", "jsp", "spring"};
		String[] values = {"C는 1972년 켄 톰슨과 데니스 리치가 유닉스 운영 체제에서 사용하기 위해 개발한 프로그래밍 언어이다.", 
				"C++는 AT&T 벨 연구소의 비야네 스트롭스트룹이 1983년 발표하여 발전한 프로그래밍 언어이다.", 
				"자바는 썬 마이크로시스템즈의 제임스 고슬링(James Gosling)과 다른 연구원들이 개발한 객체 지향적 프로그래밍 언어이다.", 
				"JSP는 HTML내에 자바 코드를 삽입하여 웹 서버에서 동적으로 웹 페이지를 생성하여 웹 브라우저에 돌려주는 언어이다.", 
				"스프링 프레임워크는 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크로서 간단히 스프링이라고도 불린다."};

		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtxUseAutowired.xml");

		WordRegisterServiceUseAutowired registerService =
				ctx.getBean("registerService", WordRegisterServiceUseAutowired.class);
		WordSearchServiceUseAutowired searchService =
				ctx.getBean("searchService", WordSearchServiceUseAutowired.class);

		// register
		for(int i=0 ; i<keyWords.length ; ++i) {
			WordSet wordSet = new WordSet(keyWords[i], values[i]);
			registerService.register(wordSet);
		}

		// search
		System.out.println("--------------------------------------------------"
				+ "--------------------------------------------------");
		for(int i=0 ; i<values.length ; ++i) {
			WordSet wordSet = searchService.searchWord(keyWords[i]);
			System.out.print(wordSet.getWordKey() + "\t : ");
			System.out.println(wordSet.getWordValue());
			System.out.println("--------------------------------------------------"
					+ "--------------------------------------------------");
		}
		System.out.println("\n\n");

		ctx.close();
	}

}

*/

/*
// MainClassUseResource.java

package com.word;

import org.springframework.context.support.GenericXmlApplicationContext;

//import com.word.service.WordRegisterServiceUseAutowired;
import com.word.service.WordRegisterServiceUseResource;
//import com.word.service.WordSearchServiceUseAutowired;
import com.word.service.WordSearchServiceUseResource;


public class MainClassUseResource {

	public static void main(String[] args) {

		String[] keyWords = {"c", "c++", "java", "jsp", "spring"};
		String[] values = {"C는 1972년 켄 톰슨과 데니스 리치가 유닉스 운영 체제에서 사용하기 위해 개발한 프로그래밍 언어이다.", 
				"C++는 AT&T 벨 연구소의 비야네 스트롭스트룹이 1983년 발표하여 발전한 프로그래밍 언어이다.", 
				"자바는 썬 마이크로시스템즈의 제임스 고슬링(James Gosling)과 다른 연구원들이 개발한 객체 지향적 프로그래밍 언어이다.", 
				"JSP는 HTML내에 자바 코드를 삽입하여 웹 서버에서 동적으로 웹 페이지를 생성하여 웹 브라우저에 돌려주는 언어이다.", 
				"스프링 프레임워크는 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크로서 간단히 스프링이라고도 불린다."};

//		GenericXmlApplicationContext ctx =
//				new GenericXmlApplicationContext("classpath:appCtxUseAutowired.xml");
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtxUseResource.xml");

//		WordRegisterServiceUseAutowired registerService =
//				ctx.getBean("registerService", WordRegisterServiceUseAutowired.class);
//		WordSearchServiceUseAutowired searchService =
//				ctx.getBean("searchService", WordSearchServiceUseAutowired.class);
		WordRegisterServiceUseResource registerService =
				ctx.getBean("registerService", WordRegisterServiceUseResource.class);
		WordSearchServiceUseResource searchService =
				ctx.getBean("searchService", WordSearchServiceUseResource.class);

		// register
		for(int i=0 ; i<keyWords.length ; ++i) {
			WordSet wordSet = new WordSet(keyWords[i], values[i]);
			registerService.register(wordSet);
		}

		// search
		System.out.println("--------------------------------------------------"
				+ "--------------------------------------------------");
		for(int i=0 ; i<values.length ; ++i) {
			WordSet wordSet = searchService.searchWord(keyWords[i]);
			System.out.print(wordSet.getWordKey() + "\t : ");
			System.out.println(wordSet.getWordValue());
			System.out.println("--------------------------------------------------"
					+ "--------------------------------------------------");
		}
		System.out.println("\n\n");

		ctx.close();
	}

}

*/

/*
// MainClassUseInject.java

package com.word;

import org.springframework.context.support.GenericXmlApplicationContext;

//import com.word.service.WordRegisterServiceUseAutowired;
import com.word.service.WordRegisterServiceUseInject;
//import com.word.service.WordSearchServiceUseAutowired;
import com.word.service.WordSearchServiceUseInject;


public class MainClassUseInject {

	public static void main(String[] args) {

		String[] keyWords = {"c", "c++", "java", "jsp", "spring"};
		String[] values = {"C는 1972년 켄 톰슨과 데니스 리치가 유닉스 운영 체제에서 사용하기 위해 개발한 프로그래밍 언어이다.", 
				"C++는 AT&T 벨 연구소의 비야네 스트롭스트룹이 1983년 발표하여 발전한 프로그래밍 언어이다.", 
				"자바는 썬 마이크로시스템즈의 제임스 고슬링(James Gosling)과 다른 연구원들이 개발한 객체 지향적 프로그래밍 언어이다.", 
				"JSP는 HTML내에 자바 코드를 삽입하여 웹 서버에서 동적으로 웹 페이지를 생성하여 웹 브라우저에 돌려주는 언어이다.", 
				"스프링 프레임워크는 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크로서 간단히 스프링이라고도 불린다."};

//		GenericXmlApplicationContext ctx =
//				new GenericXmlApplicationContext("classpath:appCtxUseAutowired.xml");
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtxUseInject.xml");

//		WordRegisterServiceUseAutowired registerService =
//				ctx.getBean("registerService", WordRegisterServiceUseAutowired.class);
//		WordSearchServiceUseAutowired searchService =
//				ctx.getBean("searchService", WordSearchServiceUseAutowired.class);
		WordRegisterServiceUseInject registerService =
				ctx.getBean("registerService", WordRegisterServiceUseInject.class);
		WordSearchServiceUseInject searchService =
				ctx.getBean("searchService", WordSearchServiceUseInject.class);

		// register
		for(int i=0 ; i<keyWords.length ; ++i) {
			WordSet wordSet = new WordSet(keyWords[i], values[i]);
			registerService.register(wordSet);
		}

		// search
		System.out.println("--------------------------------------------------"
				+ "--------------------------------------------------");
		for(int i=0 ; i<values.length ; ++i) {
			WordSet wordSet = searchService.searchWord(keyWords[i]);
			System.out.print(wordSet.getWordKey() + "\t : ");
			System.out.println(wordSet.getWordValue());
			System.out.println("--------------------------------------------------"
					+ "--------------------------------------------------");
		}
		System.out.println("\n\n");

		ctx.close();
	}

}

*/

/*
// WordRegisterService.java

package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterService {

	private WordDao wordDao;

	public WordRegisterService(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}

	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}

	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}

*/

/*
// WordRegisterServiceUseAutowired.java

package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseAutowired {

	@Autowired
//	@Qualifier("usedDao")
	private WordDao wordDao;

	public WordRegisterServiceUseAutowired() {
	}

//	@Autowired
	public WordRegisterServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}

	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}

//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}

*/

/*
// WordRegisterServiceUseResource.java

package com.word.service;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseResource {

	@Resource
//	@Qualifier("usedDao")
	private WordDao wordDao;

	public WordRegisterServiceUseResource() {
	}

	public WordRegisterServiceUseResource(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}

	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}

//	@Resource
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}

*/

/*
// WordRegisterServiceUseInject.java

package com.word.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordRegisterServiceUseInject {

	@Inject
	@Named(value="wordDao1")
	private WordDao wordDao;

	public WordRegisterServiceUseInject() {
	}

//	@Inject
	public WordRegisterServiceUseInject(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}

	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}

//	@Inject
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}

*/

/*
// WordSearchService.java

package com.word.service;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchService {

	private WordDao wordDao;

	public WordSearchService(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		return null;
	}

	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}

	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}

*/

/*
// WordSearchServiceUseAutowired.java

package com.word.service;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchServiceUseAutowired {

	@Autowired
//	@Qualifier("usedDao")
	private WordDao wordDao;

	public WordSearchServiceUseAutowired() {
	}

//	@Autowired
	public WordSearchServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		return null;
	}

	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}

//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}

*/

/*
// WordSearchServiceUseResource.java

package com.word.service;

import javax.annotation.Resource;

//import org.springframework.beans.factory.annotation.Qualifier;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchServiceUseResource {

	@Resource
//	@Qualifier("usedDao")
	private WordDao wordDao;

	public WordSearchServiceUseResource() {
	}

	public WordSearchServiceUseResource(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		return null;
	}

	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}

//	@Resource
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}

*/

/*
// WordSearchServiceUseInject.java

package com.word.service;

import javax.inject.Inject;
import javax.inject.Named;

import com.word.WordSet;
import com.word.dao.WordDao;

public class WordSearchServiceUseInject {

	@Inject
	@Named(value="wordDao1")
	private WordDao wordDao;

	public WordSearchServiceUseInject() {
	}

//	@Inject
	public WordSearchServiceUseInject(WordDao wordDao) {
		this.wordDao = wordDao;
	}

	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		return null;
	}

	public boolean verify(String wordKey) {
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}

//	@Inject
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}

}

*/

/*
// WordDao.java

package com.word.dao;

import java.util.HashMap;
import java.util.Map;

import com.word.WordSet;

public class WordDao {

	private Map<String, WordSet> wordDB =
			new HashMap<String, WordSet>();

	public void insert(WordSet wordSet) {
		wordDB.put(wordSet.getWordKey(), wordSet);
	}

	public WordSet select(String wordKey) {
		return wordDB.get(wordKey);
	}

	public void update(WordSet wordSet) {
		wordDB.put(wordSet.getWordKey(), wordSet);
	}

	public void delete(String wordKey) {
		wordDB.remove(wordKey);
	}

	public Map<String, WordSet> getWordDB() {
		return wordDB;
	}

}

*/

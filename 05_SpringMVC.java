# ProjectName : practiceSpringMVC
    Java Resources
        src/main/java
            com.spring.mvc
                HomeController.java
            com.spring.mvc.member
                Member.java
                MemPhone.java
            com.spring.mvc.member.controller
                MemberController.java
            com.spring.mvc.member.dao
                IMemberDao.java
                MemberDao.java
            com.spring.mvc.member.service
                IMemberService.java
                MemberService.java
    src
        main
            webapp
                resources
                    html
                        index.html
                        login.html
                        memJoin.html
                        memModify.html
                        remove.html
                WEB-INF
                    spring
                        appServlet
                            servlet-context.xml
                        root-context.xml
                    views
                        home.jsp
                        memJoinOK.jsp
                        memLoginOK.jsp
                        memModifyOK.jsp
                        memRemoveOK.jsp
                    web.xml
    target
        pom.xml

/*
// HomeController.java

package com.spring.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}

*/

/*
// Member.java

package com.spring.mvc.member;

import java.util.List;

public class Member {

	private String memId;
	private String memPw;
	private String memMail;
	private List<MemPhone> memPhones;
	private int memAge;
	private boolean memAdult;
	private String memGender;
	private String[] memFSprots;

	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPw() {
		return memPw;
	}
	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}
	public String getMemMail() {
		return memMail;
	}
	public void setMemMail(String memMail) {
		this.memMail = memMail;
	}
	public List<MemPhone> getMemPhones() {
		return memPhones;
	}
	public void setMemPhones(List<MemPhone> memPhones) {
		this.memPhones = memPhones;
	}
	public int getMemAge() {
		return memAge;
	}
	public void setMemAge(int memAge) {
		this.memAge = memAge;
	}
	public boolean isMemAdult() {
		return memAdult;
	}
	public void setMemAdult(boolean memAdult) {
		this.memAdult = memAdult;
	}
	public String getMemGender() {
		return memGender;
	}
	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}
	public String[] getMemFSprots() {
		return memFSprots;
	}
	public void setMemFSprots(String[] memFSprots) {
		this.memFSprots = memFSprots;
	}

}

*/

/*
// MemPhone.java

package com.spring.mvc.member;

public class MemPhone {

	private String memPhone1;
	private String memPhone2;
	private String memPhone3;

	public String getMemPhone1() {
		return memPhone1;
	}
	public void setMemPhone1(String memPhone1) {
		this.memPhone1 = memPhone1;
	}
	public String getMemPhone2() {
		return memPhone2;
	}
	public void setMemPhone2(String memPhone2) {
		this.memPhone2 = memPhone2;
	}
	public String getMemPhone3() {
		return memPhone3;
	}
	public void setMemPhone3(String memPhone3) {
		this.memPhone3 = memPhone3;
	}

}

*/

/*
// MemberController.java

package com.spring.mvc.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.member.Member;
import com.spring.mvc.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;

	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		return dateFormat.format(date);
	}

	@RequestMapping(value = "/memJoin", method = RequestMethod.POST)
	public String memJoin(Member member) {
		service.memberRegister(member);

		return "memJoinOK";
	}

	@RequestMapping(value = "/memLogin", method = RequestMethod.POST)
	public String memLogin(Member member) {
		service.memberSearch(member);

		return "memLoginOK";
	}

	@RequestMapping(value = "/memRemove", method = RequestMethod.POST)
	public String memRemove(@ModelAttribute("mem") Member member) {
		service.memberRemove(member);

		return "memRemoveOK";
	}

//	@RequestMapping(value = "/memModify")
//	public String memModify(Model model, Member member) {
//		Member[] members = service.memberModify(member);
//
//		model.addAttribute("memBef", members[0]);
//		model.addAttribute("memAft", members[1]);
//
//		return "memModifyOK";
//	}

	@RequestMapping(value = "/memModify")
	public ModelAndView memModify(Member member) {
		Member[] members = service.memberModify(member);

		ModelAndView mav = new ModelAndView();
		mav.addObject("memBef", members[0]);
		mav.addObject("memAft", members[1]);

		mav.setViewName("memModifyOK");

		return mav;
	}
}

*/

/*
// IMemberDao.java

package com.spring.mvc.member.dao;

import java.util.Map;

import com.spring.mvc.member.Member;

public interface IMemberDao {

	Map<String, Member> memberInsert(Member member);
	Member memberSelect(Member member);
	Member memberUpdate(Member member);
	Map<String, Member> memberDelete(Member member);

}

*/

/*
// MemberDao.java

package com.spring.mvc.member.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.mvc.member.Member;

@Repository
public class MemberDao implements IMemberDao {

	private HashMap<String, Member> dbMap;

	public MemberDao() {
		dbMap = new HashMap<String, Member>();
	}

	@Override
	public Map<String, Member> memberInsert(Member member) {
		dbMap.put(member.getMemId(), member);
		return dbMap;
	}

	@Override
	public Member memberSelect(Member member) {
		Member mem = dbMap.get(member.getMemId());
		return mem;
	}

	@Override
	public Member memberUpdate(Member member) {
		dbMap.put(member.getMemId(), member);
		return dbMap.get(member.getMemId());
	}

	@Override
	public Map<String, Member> memberDelete(Member member) {
		dbMap.remove(member.getMemId());
		return dbMap;
	}
}

*/

/*
// IMemberService.java

package com.spring.mvc.member.service;

import com.spring.mvc.member.Member;

public interface IMemberService {

	void memberRegister(Member member);
	void memberSearch(Member member);
	Member[] memberModify(Member member);
	void memberRemove(Member member);

}

*/

/*
// MemberService.java

package com.spring.mvc.member.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.member.MemPhone;
import com.spring.mvc.member.Member;
import com.spring.mvc.member.dao.MemberDao;

@Service
public class MemberService implements IMemberService {

	@Autowired
	MemberDao dao;

	@Override
	public void memberRegister(Member member) {
		printMembers(dao.memberInsert(member));
	}

	@Override
	public void memberSearch(Member member) {
		printMember(dao.memberSelect(member));
	}

	@Override
	public Member[] memberModify(Member member) {
		Member memBef = dao.memberSelect(member);
		Member memAft = dao.memberUpdate(member);
		printMember(memAft);

		return new Member[] {memBef, memAft};
	}

	@Override
	public void memberRemove(Member member) {
		printMembers(dao.memberDelete(member));
	}

	private void printMembers(Map<String, Member> map) {
		Set<String> keys = map.keySet();
		Iterator<String> iterator = keys.iterator();

		while(iterator.hasNext()) {
			String key = iterator.next();
			Member mem = map.get(key);
			printMember(mem);
		}
	}

	private void printMember(Member mem) {
		System.out.print("ID : " + mem.getMemId() + "\t");
		System.out.print("|PW : " + mem.getMemPw() + "\t");
		System.out.print("|MAIL : " + mem.getMemMail() + "\t");

		List<MemPhone> memPhones = mem.getMemPhones();
		for(MemPhone memPhone : memPhones) {
			System.out.print("|PHONE : " + memPhone.getMemPhone1() + " - "
				+ memPhone.getMemPhone2() + " - "
				+ memPhone.getMemPhone3() + "\t");
		}

		System.out.print("|AGE : " + mem.getMemAge() + "\t");
		System.out.print("|ADULT : " + mem.isMemAdult() + "\t");
		System.out.print("|GENDER : " + mem.getMemGender() + "\t");
		System.out.print("|FAVORITE SPORTS : " + Arrays.toString(mem.getMemFSprots()) + "\n");
	}
}

*/

/*
// index.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Main</h1>
	<a href="/mvc/resources/html/memJoin.html">JOIN</a> &nbsp;&nbsp;
	<a href="/mvc/resources/html/login.html">LOGIN</a> &nbsp;&nbsp;
	<a href="/mvc/resources/html/remove.html">REMOVE</a> &nbsp;&nbsp;
	<a href="/mvc/resources/html/memModify.html">MODIFY</a> &nbsp;&nbsp;
</body>
</html>

*/

/*
// login.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="/mvc/member/memLogin" method="post">
		ID : <input type="text" name="memId"><br>
		PW : <input type="password" name="memPw"><br>
		<input type="submit" value="Login">
	</form>
	<a href="/mvc/resources/html/memJoin.html">JOIN</a> &nbsp;&nbsp; <a href="/mvc/resources/html/index.html">MAIN</a>
</body>
</html>

*/

/*
// memJoin.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Join</h1>
	<form action="/mvc/member/memLogin" method="post">
		ID : <input type="text" name="memId"><br>
		PW : <input type="password" name="memPw"><br>
		MAIL : <input type="text" name="memMail"><br>
		PHONE1 : <input type="text" name="memPhones[0].memPhone1" size="5"> -
				 <input type="text" name="memPhones[0].memPhone2" size="5"> -
				 <input type="text" name="memPhones[0].memPhone3" size="5"><br>
		PHONE2 : <input type="text" name="memPhones[1].memPhone1" size="5"> -
				 <input type="text" name="memPhones[1].memPhone2" size="5"> -
				 <input type="text" name="memPhones[1].memPhone3" size="5"><br>
		AGE : <input type="text" name="memAge" size="4" value="0"><br>
		ADULT : <input type="radio" name="memAdult" value="true">Yes,
				<input type="radio" name="memAdult" value="false">No <br>
		GENDER : <input type="radio" name="memGender" value="M">Men,
				<input type="radio" name="memGender" value="W">Women <br>
		FAVORITE SPORT : <input type="checkbox" name="memFSports" value="soccer">Soccer,
				<input type="checkbox" name="memFSports" value="baseball">baseball,
				<input type="checkbox" name="memFSports" value="basketball">basketball,
				<input type="checkbox" name="memFSports" value="volleyball">volleyball,
				<input type="checkbox" name="memFSports" value="billiards">billiards <br>
		<input type="submit" value="Join">
		<input type="reset" value="Cancel">
	</form>
	<a href="/mvc/resources/html/login.html">LOGIN</a> &nbsp;&nbsp; <a href="/mvc/resources/html/index.html">MAIN</a>
</body>
</html>

*/

/*
// memModify.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Member Modify</h1>
	<form action="/mvc/member/memModify" method="post">
		ID : <input type="text" name="memId"><br>
		PW : <input type="password" name="memPw"><br>
		MAIL : <input type="text" name="memMail"><br>
		PHONE1 : <input type="text" name="memPhones[0].memPhone1" size="5"> -
				 <input type="text" name="memPhones[0].memPhone2" size="5"> -
				 <input type="text" name="memPhones[0].memPhone3" size="5"><br>
		PHONE2 : <input type="text" name="memPhones[1].memPhone1" size="5"> -
				 <input type="text" name="memPhones[1].memPhone2" size="5"> -
				 <input type="text" name="memPhones[1].memPhone3" size="5"><br>
		AGE : <input type="text" name="memAge" size="4" value="0"><br>
		ADULT : <input type="radio" name="memAdult" value="true">Yes,
				<input type="radio" name="memAdult" value="false">No <br>
		GENDER : <input type="radio" name="memGender" value="M">Men,
				<input type="radio" name="memGender" value="W">Women <br>
		FAVORITE SPORT : <input type="checkbox" name="memFSports" value="soccer">Soccer,
				<input type="checkbox" name="memFSports" value="baseball">baseball,
				<input type="checkbox" name="memFSports" value="basketball">basketball,
				<input type="checkbox" name="memFSports" value="volleyball">volleyball,
				<input type="checkbox" name="memFSports" value="billiards">billiards <br>
		<input type="submit" value="Modify">
		<input type="reset" value="Cancel">
	</form>
	<a href="/mvc/resources/html/index.html">MAIN</a>
</body>
</html>

*/

/*
// remove.html

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Remove</h1>
	<form action="/mvc/member/memRemove" method="post">
		ID : <input type="text" name="memId"><br>
		<input type="submit" value="Remove">
	</form>
	<a href="/mvc/resources/html/memJoin.html">JOIN</a> &nbsp;&nbsp; <a href="/mvc/resources/html/index.html">MAIN</a>
</body>
</html>

*/

/*
// servlet-context.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans:beans xmlns="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:beans="http://www.springframework.org/schema/beans"
	xmlns:context="http://www.springframework.org/schema/context"
	xsi:schemaLocation="http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd
		http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd
		http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

	<!-- DispatcherServlet Context: defines this servlet's request-processing infrastructure -->
	
	<!-- Enables the Spring MVC @Controller programming model -->
	<annotation-driven />

	<!-- Handles HTTP GET requests for /resources/** by efficiently serving up static resources in the ${webappRoot}/resources directory -->
	<resources mapping="/resources/**" location="/resources/" />

	<!-- Resolves views selected for rendering by @Controllers to .jsp resources in the /WEB-INF/views directory -->
	<beans:bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<beans:property name="prefix" value="/WEB-INF/views/" />
		<beans:property name="suffix" value=".jsp" />
	</beans:bean>
	
	<context:component-scan base-package="com.spring.mvc" />
	
</beans:beans>

*/

/*
// root-context.xml

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans https://www.springframework.org/schema/beans/spring-beans.xsd">
	
	<!-- Root Context: defines shared resources visible to all other web components -->
		
</beans>

*/

/*
// home.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>

*/

/*
// memJoinOK.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> memJoinOK </h1>

	ID : ${member.memId} <br>
	PW : ${member.memPw} <br>
	Mail : ${member.memMail} <br>
	PHONE1 : ${member.memPhones[0].memPhone1} - ${member.memPhones[0].memPhone2} - ${member.memPhones[0].memPhone3} <br>
	PHONE2 : ${member.memPhones[1].memPhone1} - ${member.memPhones[1].memPhone2} - ${member.memPhones[1].memPhone3} <br>
	AGE : ${member.memAge} <br>
	ADULT : ${member.memAdult} <br>
	GENDER : ${member.memGender} <br>
	FAVORITE SPORT :
	<c:forEach var="fSport" items="${member.memFSports}">
		${fSport},
	</c:forEach><br>

	<p> The time on the server is ${serverTime}. </p>

	<a href="/mvc/resources/html/memJoin.html"> Go MemberJoin </a>
</body>
</html>

*/

/*
// memLoginOK.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> memLoginOK </h1>

	ID : ${member.memId} <br>
	PW : ${member.memPw} <br>

	<p> The time on the server is ${serverTime}. </p>

	<a href="/mvc/resources/html/index.html"> Go Main </a>
</body>
</html>

*/

/*
// memModifyOK.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> memModifyOK </h1>

	<h3> memBef </h3>
	ID : ${member.memId} <br>
	PW : ${member.memPw} <br>
	Mail : ${member.memMail} <br>
	PHONE1 : ${member.memPhones[0].memPhone1} - ${member.memPhones[0].memPhone2} - ${member.memPhones[0].memPhone3} <br>
	PHONE2 : ${member.memPhones[1].memPhone1} - ${member.memPhones[1].memPhone2} - ${member.memPhones[1].memPhone3} <br>
	AGE : ${member.memAge} <br>
	ADULT : ${member.memAdult} <br>
	GENDER : ${member.memGender} <br>
	FAVORITE SPORT :
	<c:forEach var="fSport" items="${member.memFSports}">
		${fSport},
	</c:forEach><br>

	<h3> memAft </h3>
	ID : ${member.memId} <br>
	PW : ${member.memPw} <br>
	Mail : ${member.memMail} <br>
	PHONE1 : ${member.memPhones[0].memPhone1} - ${member.memPhones[0].memPhone2} - ${member.memPhones[0].memPhone3} <br>
	PHONE2 : ${member.memPhones[1].memPhone1} - ${member.memPhones[1].memPhone2} - ${member.memPhones[1].memPhone3} <br>
	AGE : ${member.memAge} <br>
	ADULT : ${member.memAdult} <br>
	GENDER : ${member.memGender} <br>
	FAVORITE SPORT :
	<c:forEach var="fSport" items="${member.memFSports}">
		${fSport},
	</c:forEach><br>

	<p> The time on the server is ${serverTime}. </p>

	<a href="/mvc/resources/html/index.html"> Go Main </a>
</body>
</html>

*/

/*
// memRemoveOK.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> memRemoveOK </h1>

	ID : ${member.memId} <br>

	<p> The time on the server is ${serverTime}. </p>

	<a href="/mvc/resources/html/index.html"> Go Main </a>
</body>
</html>

*/

/*
// web.xml

<?xml version="1.0" encoding="UTF-8"?>
<web-app version="2.5" xmlns="http://java.sun.com/xml/ns/javaee"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://java.sun.com/xml/ns/javaee https://java.sun.com/xml/ns/javaee/web-app_2_5.xsd">

	<!-- The definition of the Root Spring Container shared by all Servlets and Filters -->
	<context-param>
		<param-name>contextConfigLocation</param-name>
		<param-value>/WEB-INF/spring/root-context.xml</param-value>
	</context-param>
	
	<!-- Creates the Spring Container shared by all Servlets and Filters -->
	<listener>
		<listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
	</listener>

	<!-- Processes application requests -->
	<servlet>
		<servlet-name>appServlet</servlet-name>
		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
		<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/spring/appServlet/servlet-context.xml</param-value>
		</init-param>
		<load-on-startup>1</load-on-startup>
	</servlet>
		
	<servlet-mapping>
		<servlet-name>appServlet</servlet-name>
		<url-pattern>/</url-pattern>
	</servlet-mapping>

	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>
			org.springframework.web.filter.CharacterEncodingFilter     
		</filter-class>
		<init-param>
			<param-name>encoding</param-name>   
			<param-value>UTF-8</param-value>
		</init-param>
		<init-param>
			<param-name>forceEncoding</param-name>  
			<param-value>true</param-value>
		</init-param>
	</filter>    

	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>                 
	</filter-mapping>

</web-app>

*/

/*
// pom.xml

<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/maven-v4_0_0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<groupId>com.spring</groupId>
	<artifactId>mvc</artifactId>
	<name>practiceSpringMVC</name>
	<packaging>war</packaging>
	<version>1.0.0-BUILD-SNAPSHOT</version>
	<properties>
		<java-version>1.8</java-version>
		<org.springframework-version>4.1.0.RELEASE</org.springframework-version>
		<org.aspectj-version>1.6.10</org.aspectj-version>
		<org.slf4j-version>1.6.6</org.slf4j-version>
	</properties>
	<dependencies>
		<!-- Spring -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${org.springframework-version}</version>
			<exclusions>
				<!-- Exclude Commons Logging in favor of SLF4j -->
				<exclusion>
					<groupId>commons-logging</groupId>
					<artifactId>commons-logging</artifactId>
				 </exclusion>
			</exclusions>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${org.springframework-version}</version>
		</dependency>
				
		<!-- AspectJ -->
		<dependency>
			<groupId>org.aspectj</groupId>
			<artifactId>aspectjrt</artifactId>
			<version>${org.aspectj-version}</version>
		</dependency>	
		
		<!-- Logging -->
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-api</artifactId>
			<version>${org.slf4j-version}</version>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>jcl-over-slf4j</artifactId>
			<version>${org.slf4j-version}</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.slf4j</groupId>
			<artifactId>slf4j-log4j12</artifactId>
			<version>${org.slf4j-version}</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>log4j</groupId>
			<artifactId>log4j</artifactId>
			<version>1.2.15</version>
			<exclusions>
				<exclusion>
					<groupId>javax.mail</groupId>
					<artifactId>mail</artifactId>
				</exclusion>
				<exclusion>
					<groupId>javax.jms</groupId>
					<artifactId>jms</artifactId>
				</exclusion>
				<exclusion>
					<groupId>com.sun.jdmk</groupId>
					<artifactId>jmxtools</artifactId>
				</exclusion>
				<exclusion>
					<groupId>com.sun.jmx</groupId>
					<artifactId>jmxri</artifactId>
				</exclusion>
			</exclusions>
			<scope>runtime</scope>
		</dependency>

		<!-- @Inject -->
		<dependency>
			<groupId>javax.inject</groupId>
			<artifactId>javax.inject</artifactId>
			<version>1</version>
		</dependency>
				
		<!-- Servlet -->
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>servlet-api</artifactId>
			<version>2.5</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet.jsp</groupId>
			<artifactId>jsp-api</artifactId>
			<version>2.1</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
			<version>1.2</version>
		</dependency>
	
		<!-- Test -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.7</version>
			<scope>test</scope>
		</dependency>        
	</dependencies>
    <build>
        <plugins>
            <plugin>
                <artifactId>maven-eclipse-plugin</artifactId>
                <version>2.9</version>
                <configuration>
                    <additionalProjectnatures>
                        <projectnature>org.springframework.ide.eclipse.core.springnature</projectnature>
                    </additionalProjectnatures>
                    <additionalBuildcommands>
                        <buildcommand>org.springframework.ide.eclipse.core.springbuilder</buildcommand>
                    </additionalBuildcommands>
                    <downloadSources>true</downloadSources>
                    <downloadJavadocs>true</downloadJavadocs>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.5.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                    <compilerArgument>-Xlint:all</compilerArgument>
                    <showWarnings>true</showWarnings>
                    <showDeprecation>true</showDeprecation>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.codehaus.mojo</groupId>
                <artifactId>exec-maven-plugin</artifactId>
                <version>1.2.1</version>
                <configuration>
                    <mainClass>org.test.int1.Main</mainClass>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

*/

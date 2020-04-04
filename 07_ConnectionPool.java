# ProjectName : practiceSpring
    Java Resources
        src/main/java
            com.cs.practice
                HomeController.java
            com.cs.practice.config
                DBConfig.java
            com.cs.practice.member
                Member.java
            		MemberLoginInterceptor.java
            com.cs.practice.member.controller
                MemberController.java
            com.cs.practice.member.dao
                IMemberDao.java
                MemberDao.java
            com.cs.practice.member.service
                IMemberService.java
                MemberService.java
    src
        main
            webapp
                resources
                    css
                        normal.css
                WEB-INF
                    spring
                        appServlet
                            servlet-context.xml
                        root-context.xml
                    views
                        member
                            joinForm.jsp
                            joinOK.jsp
                            loginForm.jsp
                            loginOK.jsp
                            logoutOK.jsp
                            modifyForm.jsp
                            modifyOK.jsp
                            removeForm.jsp
                            removeOK.jsp
                        index.jsp
                    web.xml
    target
        pom.xml

/*
// HomeController.java

package com.sc.practice;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "/index";
	}

}

*/

/*
// DBConfig.java

package com.sc.practice.config;

import java.beans.PropertyVetoException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
public class DBConfig {

	@Bean
	public ComboPooledDataSource dataSource() throws PropertyVetoException {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();

		dataSource.setDriverClass("oracle.jdbc.driver.OracleDriver");
		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		dataSource.setUser("scott");
		dataSource.setPassword("tiger");
		dataSource.setMaxPoolSize(200);
		dataSource.setCheckoutTimeout(60000);
		dataSource.setMaxIdleTime(1800);
		dataSource.setIdleConnectionTestPeriod(600);

		return dataSource;
	}

}

*/

/*
// Member.java

package com.sc.practice.member;

public class Member {

	private String memId;
	private String memPw;
	private String memMail;
	private int memPurchNum;

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
	public int getMemPurchNum() {
		return memPurchNum;
	}
	public void setMemPurchNum(int memPurchNum) {
		this.memPurchNum = memPurchNum;
	}

}

*/

/*
// MemberLoginInterceptor.java

package com.sc.practice.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class MemberLoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		HttpSession session = request.getSession(false);
		if(session != null) {
			Object obj = session.getAttribute("member");
			if(obj != null)
				return true;
		}

		response.sendRedirect(request.getContextPath() + "/");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {

		super.postHandle(request, response, handler, mav);
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

		super.afterCompletion(request, response, handler, ex);
	}
}

*/

/*
// MemberController.java

package com.sc.practice.member.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sc.practice.member.Member;
import com.sc.practice.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService service;

	@ModelAttribute("cp")
	public String getContextPath(HttpServletRequest request) {
		return request.getContextPath();
	}

	@ModelAttribute("serverTime")
	public String getServerTime(Locale locale) {

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		return dateFormat.format(date);
	}

	// Join
	@RequestMapping("/joinForm")
	public String joinForm(Member member) {
		return "/member/joinForm";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinReg(Member member) {

		service.memberRegister(member);

		return "/member/joinOk";
	}

	// Login
	@RequestMapping("/loginForm")
	public String loginForm(Member member) {
		return "/member/loginForm";
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String memLogin(Member member, HttpServletRequest request) {
//
//		Member mem = service.memberSearch(member);
//
//		HttpSession session = request.getSession();
//		session.setAttribute("member", mem);
//
//		return "/member/loginOK";
//	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memLogin(Member member, HttpSession session) {

		Member mem = service.memberSearch(member);
		if(mem == null)
			return "/member/loginForm";

		session.setAttribute("member", mem);

		return "/member/loginOk";
	}

//	// Logout
//	@RequestMapping("/logout")
//	public String memLogout(Member member, HttpServletRequest request) {
//
//		HttpSession session = request.getSession();
//		session.invalidate();
//
//		return "/member/logoutOK";
//	}

	@RequestMapping("/logout")
	public String memLogout(Member member, HttpSession session) {

		session.invalidate();

		return "/member/logoutOk";
	}

	// Modify
	@RequestMapping(value = "/modifyForm", method = RequestMethod.POST)
	public ModelAndView modifyForm(HttpServletRequest request) {

		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");

		ModelAndView mav = new ModelAndView();
		mav.addObject("member", service.memberSearch(member));

		mav.setViewName("/member/modifyForm");

		return mav;
	}

	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public ModelAndView modify(Member member, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();

		Member mem = service.memberModify(member);
		if(mem == null) {
			mav.setViewName("/member/modifyForm");
		} else {
			session.setAttribute("member", mem);

			mav.addObject("memAft", mem);
			mav.setViewName("/member/modifyOk");
		}

		return mav;
	}

	// Remove
	@RequestMapping("/removeForm")
	public ModelAndView removeForm(HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();

		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");

		if(null == member) {
			mav.setViewName("redirect:/");
		} else {
			mav.addObject("member", member);
			mav.setViewName("/member/removeForm");
		}

		return mav;
	}

	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String memRemove(Member member, HttpServletRequest request) {

		int result = service.memberRemove(member);

		if(result == 0)
			return "/member/removeForm";

		HttpSession session = request.getSession();
		session.invalidate();

		return "/member/removeOk";
	}

}

*/

/*
// IMemberDao.java

package com.sc.practice.member.dao;

import com.sc.practice.member.Member;

public interface IMemberDao {

	int memberInsert(Member member);
	Member memberSelect(Member member);
	int memberUpdate(Member member);
	int memberDelete(Member member);

}

*/

/*
// MemberDao.java

package com.sc.practice.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.sc.practice.member.Member;

@Repository
public class MemberDao implements IMemberDao {

	private JdbcTemplate template;

	@Autowired
	public MemberDao(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public int memberInsert(Member member) {
		
		int result = 0;

		final String sql = "INSERT INTO member(memId, memPw, memMail) VALUES(?, ?, ?)";

//		// 1st
//		result = template.update(sql, member.getMemId(), member.getMemPw(), member.getMemMail());
//
//		// 2nd
//		result = template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, member.getMemId());
//				pstmt.setString(2, member.getMemPw());
//				pstmt.setString(3, member.getMemMail());
//
//				return pstmt;
//			}
//		});

		// 3rd
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMemId());
				pstmt.setString(2, member.getMemPw());
				pstmt.setString(3, member.getMemMail());
			}
		});

		return result;
	}

	@Override
	public Member memberSelect(final Member member) {

		List<Member> members = null;

		final String sql = "SELECT * FROM member WHERE memId = ? AND memPw = ?";

//		// 1st
//		members = template.query(sql, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement pstmt) throws SQLException {
//				pstmt.setString(1, member.getMemId());
//				pstmt.setString(2, member.getMemPw());
//			}
//		}, new RowMapper<Member>() {
//
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Member mem = new Member();
//				mem.setMemId(rs.getString("memId"));
//				mem.setMemPw(rs.getString("memPw"));
//				mem.setMemMail(rs.getString("memMail"));
//				mem.setMemPurchNum(rs.getInt("memPurchNum"));
//				return mem;
//			}
//		});
//
//		// 2nd
//		members = template.query(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, member.getMemId());
//				pstmt.setString(2, member.getMemPw());
//				return pstmt;
//			}
//		}, new RowMapper<Member>() {
//
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Member mem = new Member();
//				mem.setMemId(rs.getString("memId"));
//				mem.setMemPw(rs.getString("memPw"));
//				mem.setMemMail(rs.getString("memMail"));
//				mem.setMemPurchNum(rs.getInt("memPurchNum"));
//				return mem;
//			}
//		});
//
//		// 3rd
//		members = template.query(sql, new RowMapper<Member>() {
//
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Member mem = new Member();
//				mem.setMemId(rs.getString("memId"));
//				mem.setMemPw(rs.getString("memPw"));
//				mem.setMemMail(rs.getString("memMail"));
//				mem.setMemPurchNum(rs.getInt("memPurchNum"));
//				return mem;
//			}
//		}, member.getMemId(), member.getMemPw());

		// 4th
		members = template.query(sql, new Object[]{member.getMemId(), member.getMemPw()},
				new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member mem = new Member();
				mem.setMemId(rs.getString("memId"));
				mem.setMemPw(rs.getString("memPw"));
				mem.setMemMail(rs.getString("memMail"));
				mem.setMemPurchNum(rs.getInt("memPurchNum"));
				return mem;
			}
		});

		if(members.isEmpty())
			return null;

		return members.get(0);
	}

	@Override
	public int memberUpdate(final Member member) {

		int result = 0;

		final String sql = "UPDATE member SET memPw = ?, memMail = ? WHERE memId = ?";

//		// 1st
//		result = template.update(sql, member.getMemPw(), member.getMemMail(), member.getMemId());
//
//		// 2nd
//		result = template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, member.getMemPw());
//				pstmt.setString(2, member.getMemMail());
//				pstmt.setString(3, member.getMemId());
//
//				return pstmt;
//			}
//		});

		// 3rd
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMemPw());
				pstmt.setString(2, member.getMemMail());
				pstmt.setString(3, member.getMemId());
			}
		});

		return result;
	}

	@Override
	public int memberDelete(final Member member) {

		int result = 0;

		final String sql = "DELETE member WHERE memId = ? AND memPw = ?";

//		// 1st
//		result = template.update(sql, member.getMemId(), member.getMemPw());
//
//		// 2nd
//		result = template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//				PreparedStatement pstmt = con.prepareStatement(sql);
//				pstmt.setString(1, member.getMemId());
//				pstmt.setString(2, member.getMemPw());
//
//				return pstmt;
//			}
//		});

		// 3rd
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, member.getMemId());
				pstmt.setString(2, member.getMemPw());
			}
		});

		return result;
	}

}

*/

/*
// IMemberService.java

package com.sc.practice.member.service;

import com.sc.practice.member.Member;

public interface IMemberService {

	void memberRegister(Member member);
	Member memberSearch(Member member);
	Member memberModify(Member member);
	int memberRemove(Member member);

}

*/

/*
// MemberService.java

package com.sc.practice.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.practice.member.Member;
import com.sc.practice.member.dao.MemberDao;

@Service
public class MemberService implements IMemberService {

	@Autowired
	MemberDao dao;

	@Override
	public void memberRegister(Member member) {
		int result = dao.memberInsert(member);

		if(result == 0) {
			System.out.println("Join Fail!");
		} else {
			System.out.println("Join Success!");
		}
	}

	@Override
	public Member memberSearch(Member member) {
		Member mem = dao.memberSelect(member);

		if(mem == null) {
			System.out.println("Login Fail!");
		} else {
			System.out.println("Login Success!");
		}

		return mem;
	}

	@Override
	public Member memberModify(Member member) {
		int result = dao.memberUpdate(member);

		if(result == 0) {
			System.out.println("Modify Fail!");
			return null;
		} else {
			System.out.println("Modify Success!");
		}

		return member;
	}

	@Override
	public int memberRemove(Member member) {
		int result = dao.memberDelete(member);

		if(result == 0) {
			System.out.println("Remove Fail!");
		} else {
			System.out.println("Remove Success!");
		}

		return result;
	}

//	private void printMembers(Map<String, Member> map) {
//
//		Set<String> keys = map.keySet();
//		Iterator<String> iterator = keys.iterator();
//
//		while(iterator.hasNext()) {
//			String key = iterator.next();
//			Member mem = map.get(key);
//			printMember(mem);
//		}
//	}
//
//	private void printMember(Member mem) {
//		System.out.print("ID : " + mem.getMemId() + "\t");
//		System.out.print("|PW : " + mem.getMemPw() + "\t");
//		System.out.print("|MAIL : " + mem.getMemMail() + "\n");
//	}

}

*/

/*
// normal.css

table {
	border: 1px solid #cccccc;
}

table td {
	padding: 3px;
	border: 1px solid #cccccc;
}

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
	
	<context:component-scan base-package="com.sc.practice" />
	
	<interceptors>
		<interceptor>
			<mapping path="/member/modifyForm"/>
			<mapping path="/member/removeForm"/>
			<!--
			<mapping path="/member/**"/>
			<exclude-mapping path="/member/joinForm"/>
			<exclude-mapping path="/member/join"/>
			<exclude-mapping path="/member/loginForm"/>
			<exclude-mapping path="/member/login"/>
			<exclude-mapping path="/member/logout"/>
			<exclude-mapping path="/member/modify"/>
			<exclude-mapping path="/member/remove"/>
			-->
			<beans:bean class="com.sc.practice.member.MemberLoginInterceptor"/>
		</interceptor>
	</interceptors>

	<!--
	<beans:bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
		<beans:property name="driverClass" value="oracle.jdbc.driver.OracleDriver" />
		<beans:property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:orcl" />
		<beans:property name="user" value="scott" />
		<beans:property name="password" value="tiger" />
		<beans:property name="maxPoolSize" value="200" />
		<beans:property name="checkoutTimeout" value="60000" />
		<beans:property name="maxIdleTime" value="1800" />
		<beans:property name="idleConnectionTestPeriod" value="600" />
	</beans:bean>
	-->

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
// joinForm.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
	<h1>MEMBER JOIN</h1>

	<form:form action="${cp}/member/join" method="post" commandName="member">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="memId" /></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:password path="memPw" /></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><form:input path="memMail" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Join">
					<input type="reset" value="Cancel">
				</td>
			</tr>
		</table>
	</form:form>

	<a href="${cp}/">MAIN</a>
</body>
</html>

*/

/*
// joinOK.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>MEMBER JOIN OK</h1>

	ID : ${member.memId} <br>
	PW : ${member.memPw} <br>
	Mail : ${member.memMail} <br>

	<p>The time on the server is ${serverTime}.</p>

	<a href="${cp}/">MAIN</a>
</body>
</html>

*/

/*
// loginForm.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
	<h1>MEMBER LOGIN</h1>

	<form:form action="${cp}/member/join" method="post" commandName="member">
		<table>
			<tr>
				<td>ID</td>
				<td><form:input path="memId" /></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:password path="memPw" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
		</table>
	</form:form>

	<a href="${cp}/">MAIN</a>
</body>
</html>

*/

/*
// loginOK.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>MEMBER LOGIN OK</h1>

	ID : ${member.memId} <br>
	PW : ${member.memPw} <br>

	<p>The time on the server is ${serverTime}.</p>

	<a href="${cp}/">MAIN</a>
</body>
</html>

*/

/*
// logoutOK.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>MEMBER LOGIN OK</h1>

	<p>The time on the server is ${serverTime}.</p>

	<a href="${cp}/">MAIN</a>
</body>
</html>

*/

/*
// modifyForm.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
	<h1>MEMBER LOGIN</h1>

	<form:form action="${cp}/member/join" method="post" commandName="member">
		<form:hidden path="memId" value="${member.memId}"/>
		<table>
			<tr>
				<td>ID</td>
				<td>${member.memId}</td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:password path="memPw" /></td>
			</tr>
			<tr>
				<td>MAIL</td>
				<td><form:input path="memMail" value="${member.memMail}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Modify"></td>
			</tr>
		</table>
	</form:form>

	<a href="${cp}/">MAIN</a>
</body>
</html>

*/

/*
// modifyOK.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>MEMBER MODIFY OK</h1>

<%--
 	<h3>Before Modify</h3>
	ID : ${memBef.memId} <br>
	PW : ${memBef.memPw} <br>
	Mail : ${memBef.memMail} <br>
--%>

	<h3>After Modify</h3>
	ID : ${memAft.memId} <br>
	PW : ${memAft.memPw} <br>
	Mail : ${memAft.memMail} <br>

	<p>The time on the server is ${serverTime}.</p>

	<a href="${cp}/">MAIN</a>
</body>
</html>

*/

/*
// removeForm.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
	<h1>MEMBER REMOVE</h1>

	<form:form action="${cp}/member/join" method="post" commandName="member">
		<input type="hidden" name="memId" value="${member.memId}"/>
		<table>
			<tr>
				<td>ID</td>
				<td>${member.memId}</td>
			</tr>
			<tr>
				<td>PW</td>
				<td><form:password path="memPw" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Remove"></td>
			</tr>
		</table>
	</form:form>

	<a href="${cp}/">MAIN</a>
</body>
</html>

*/

/*
// removeOK.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>MEMBER REMOVE OK</h1>

	ID : ${member.memId} <br>

	<p>The time on the server is ${serverTime}.</p>

	<a href="${cp}/">MAIN</a>
</body>
</html>

*/

/*
// index.jsp

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>MAIN</h1>

	<c:if test="${empty member}">
		<a href="${cp}/member/joinForm">JOIN</a> &nbsp;&nbsp;
		<a href="${cp}/member/loginForm">LOGIN</a> &nbsp;&nbsp;
	</c:if>

	<c:if test="${!empty member}">
		<a href="${cp}/member/modifyForm">MODIFY</a> &nbsp;&nbsp;
		<a href="${cp}/member/logout">LOGOUT</a> &nbsp;&nbsp;
		<a href="${cp}/member/removeForm">REMOVE</a> &nbsp;&nbsp;
	</c:if>

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
	<groupId>com.sc</groupId>
	<artifactId>practice</artifactId>
	<name>practiceSpring</name>
	<packaging>war</packaging>
	<version>1.0.0-BUILD-SNAPSHOT</version>
	<properties>
		<java-version>1.8</java-version>
		<org.springframework-version>4.1.0.RELEASE</org.springframework-version>
		<org.aspectj-version>1.6.10</org.aspectj-version>
		<org.slf4j-version>1.6.6</org.slf4j-version>
	</properties>

	<repositories>
		<repository>
			<id>oracle</id>
			<name>ORACLE JDBC Repository</name>
			<url>http://maven.jahia.org/maven2</url>
		</repository>
	</repositories>

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

		<!-- DB -->
		<dependency>
			<groupId>com.oracle</groupId>
			<artifactId>ojdbc6</artifactId>
			<version>12.1.0.2</version>
		</dependency>
		<dependency>
			<groupId>com.mchange</groupId>
			<artifactId>c3p0</artifactId>
			<version>0.9.5</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-jdbc</artifactId>
			<version>4.1.6.RELEASE</version>
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

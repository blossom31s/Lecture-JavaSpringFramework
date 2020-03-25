# Maven Project File Structure
springTest
  src/main/java
    com.brms
      MainClass.java
    com.brms.book
      Book.java
    com.brms.book.dao
      BookDao.java
    com.brms.book.service
      BookRegisterService.java
      BookSearchService.java
    com.brms.member
      Member.java
    com.brms.member.dao
      MemberDao.java
    com.brms.member.service
      MemberRegisterService.java
      MemberSearchService.java
  src/main/resources
    applicationContext.xml
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
	xmlns:context="http://www.springframework.org/schema/context"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd 
 		http://www.springframework.org/schema/context 
 		http://www.springframework.org/schema/context/spring-context.xsd">

	<context:annotation-config />

	<bean id="bookDao" class="com.brms.book.dao.BookDao" />
	<bean id="bookRegisterService" class="com.brms.book.service.BookRegisterService"
		init-method="initMethod" destroy-method="destroyMethod" />
	<bean id="bookSearchService" class="com.brms.book.service.BookSearchService" />

	<bean id="memberDao" class="com.brms.member.dao.MemberDao" />
	<bean id="memberRegisterService" class="com.brms.member.service.MemberRegisterService" />
	<bean id="memberSearchService" class="com.brms.member.service.MemberSearchService" />

</beans>

*/

/*
// MainClass.java

package com.brms;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.brms.book.Book;
import com.brms.book.service.BookRegisterService;
import com.brms.book.service.BookSearchService;
import com.brms.member.Member;
import com.brms.member.service.MemberRegisterService;
import com.brms.member.service.MemberSearchService;

public class MainClass {

	public static void main(String[] args) {

		String[] bNums = { "739", "985", "184", "830", "816" };
		String[] bTitles = { "html", "css", "jQuery", "java", "spring" };
		
		String[] mIds = { "rabbit", "hippo", "raccoon", "elephan", "lion" };
		String[] mPws = { "96539", "94875", "15284", "48765", "28661" };
		String[] mNames = { "agatha", "barbara", "chris", "doris", "elva" };

		// Create Spring Container
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");

		// Register Dummy Book List
		BookRegisterService bookRegisterService =
				ctx.getBean("bookRegisterService", BookRegisterService.class);
		for(int i=0 ; i<bNums.length ; ++i) {
			Book book = new Book(bNums[i], bTitles[i], true, null);
			bookRegisterService.register(book);
		}

		// Print Out Dummy Book List
		BookSearchService bookSearchService =
				ctx.getBean("bookSearchService", BookSearchService.class);
		System.out.println("\nbNum\tbTitle\tbCanRen\tbLenderId");
		System.out.println("--------------------------------------------------"
				+ "--------------------------------------------------");
		for(int i=0 ; i<bNums.length ; ++i) {
			Book book = bookSearchService.searchBook(bNums[i]);
			System.out.print(book.getbNum() + "\t");
			System.out.print(book.getbTitle() + "\t");
			System.out.print(book.isbCanRental() + "\t");
			System.out.println(book.getbMember() == null ? null : book.getbMember().getmId());
		}

		// Register Dummy Member List
		MemberRegisterService memberRegisterService =
				ctx.getBean("memberRegisterService", MemberRegisterService.class);
		for(int i=0 ; i<mIds.length ; ++i) {
			Member member = new Member(mIds[i], mPws[i], mNames[i]);
			memberRegisterService.register(member);
		}

		// Print Out Dummy Member List
		MemberSearchService memberSearchService =
				ctx.getBean("memberSearchService", MemberSearchService.class);
		System.out.println("\nmId\tmPw\tmName");
		System.out.println("--------------------------------------------------"
				+ "--------------------------------------------------");
		for(int i=0 ; i<mIds.length ; ++i) {
			Member member = memberSearchService.searchMember(mIds[i]);
			System.out.print(member.getmId() + "\t");
			System.out.print(member.getmPw() + "\t");
			System.out.println(member.getmName());
		}

		// Register a list of books for rent
		bookRegisterService.register(new Book("739", "html", false, memberSearchService.searchMember("elephan")));
		bookRegisterService.register(new Book("184", "jQuery", false, memberSearchService.searchMember("hippo")));
		bookRegisterService.register(new Book("816", "spring", false, memberSearchService.searchMember("rabbit")));
		bookRegisterService.register(new Book("985", "css", false, memberSearchService.searchMember("rabbit")));

		// Print out a list of books for rent
		System.out.println("\nbNum\tbTitle\tbCanRen\tbLenderId");
		System.out.println("--------------------------------------------------"
				+ "--------------------------------------------------");
		for(int i=0 ; i<bNums.length ; ++i) {
			Book book = bookSearchService.searchBook(bNums[i]);
			System.out.print(book.getbNum() + "\t");
			System.out.print(book.getbTitle() + "\t");
			System.out.print(book.isbCanRental() + "\t");
			System.out.println(book.getbMember() == null ? null : book.getbMember().getmId());
		}

		ctx.close();
	}

}

*/

/*
// BookRegisterService.java

package com.brms.book.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;

public class BookRegisterService {

	@Autowired
	private BookDao bookDao;

	public BookRegisterService() { }

	public void register(Book book) {
		bookDao.insert(book);
	}

	public void initMethod() {
		System.out.println("BookRegisterService Bean 객체 생성 단계");
	}

	public void destroyMethod() {
		System.out.println("BookRegisterService Bean 객체 소멸 단계");
	}
}

*/

/*
// BookSearchService.java

package com.brms.book.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.brms.book.Book;
import com.brms.book.dao.BookDao;

public class BookSearchService {

	@Autowired
	private BookDao bookDao;

	public BookSearchService() { }

	public Book searchBook(String bNum) {
		Book book = bookDao.select(bNum);
		return book;
	}

}

*/

/*
// BookDao.java

package com.brms.book.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import com.brms.book.Book;

public class BookDao implements InitializingBean, DisposableBean {

	private Map<String, Book> bookDB =
			new HashMap<String, Book>();

	public void insert(Book book) {
		bookDB.put(book.getbNum(), book);
	}

	public Book select(String bNum) {
		return bookDB.get(bNum);
	}

	public void update(Book book) {
		
	}

	public void delete() {
		
	}

	public Map<String, Book> getBookDB() {
		return bookDB;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Bean 객체 생성 단계");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Bean 객체 소멸 단계");
	}
}

*/

/*
// Book.java

package com.brms.book;

import com.brms.member.Member;

public class Book {

	private String bNum;
	private String bTitle;
	private boolean bCanRental;
	private Member bMember;

	public Book(String bNum, String bTitle, boolean bCanRental, Member bMember) {
		this.bNum = bNum;
		this.bTitle = bTitle;
		this.bCanRental = bCanRental;
		this.bMember = bMember;
	}

	public String getbNum() {
		return bNum;
	}

	public void setbNum(String bNum) {
		this.bNum = bNum;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public boolean isbCanRental() {
		return bCanRental;
	}

	public void setbCanRental(boolean bCanRental) {
		this.bCanRental = bCanRental;
	}

	public Member getbMember() {
		return bMember;
	}

	public void setbMember(Member bMember) {
		this.bMember = bMember;
	}

}

*/

/*
// MemberRegisterService.java

package com.brms.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.brms.member.Member;
import com.brms.member.dao.MemberDao;

public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;

	public MemberRegisterService() { }

	public void register(Member member) {
		memberDao.insert(member);
	}

}

*/

/*
// MemberSearchService.java

package com.brms.member.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.brms.member.Member;
import com.brms.member.dao.MemberDao;

public class MemberSearchService {

	@Autowired
	private MemberDao memberDao;

	public MemberSearchService() { }

	public Member searchMember(String mId) {
		return memberDao.select(mId);
	}

}

*/

/*
// MemberDao.java

package com.brms.member.dao;

import java.util.HashMap;
import java.util.Map;

import com.brms.member.Member;

public class MemberDao {

	private Map<String, Member> memberDB =
			new HashMap<String, Member>();

	public void insert(Member member) {
		memberDB.put(member.getmId(), member);
	}

	public Member select(String mId) {
		return memberDB.get(mId);
	}

	public void update(Member member) {
		
	}

	public void delete(String mId) {
		
	}

	public Map<String, Member> getMemberDB() {
		return memberDB;
	}
}

*/

/*
// Member.java

package com.brms.member;

public class Member {

	private String mId;
	private String mPw;
	private String mName;

	public Member(String mId, String mPw, String mName) {
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

}

*/

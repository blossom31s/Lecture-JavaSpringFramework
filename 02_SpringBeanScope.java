# Maven Project File Structure
springTest
  src/main/java
    scope
      MainClass.java
      InjectionBean.java
      DependencyBean.java
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
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="injectionBean" class="scope.InjectionBean" />

	<bean id="dependencyBeanSingleton" class="scope.DependencyBean">
		<constructor-arg ref="injectionBean" />
		<property name="injectionBean" ref="injectionBean" />
	</bean>

	<bean id="dependencyBeanPrototype" class="scope.DependencyBean" scope="prototype">
		<constructor-arg ref="injectionBean" />
		<property name="injectionBean" ref="injectionBean" />
	</bean>

</beans>

*/

/*
// scope.MainClass.java

package scope;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {

		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");

		InjectionBean injectionBean =
				ctx.getBean("injectionBean", InjectionBean.class);

		DependencyBean deBeanSingleton_1 =
				ctx.getBean("dependencyBeanSingleton", DependencyBean.class);

		DependencyBean deBeanSingleton_2 =
				ctx.getBean("dependencyBeanSingleton", DependencyBean.class);

		DependencyBean deBeanPrototype_1 =
				ctx.getBean("dependencyBeanPrototype", DependencyBean.class);

		DependencyBean deBeanPrototype_2 =
				ctx.getBean("dependencyBeanPrototype", DependencyBean.class);

		if(deBeanSingleton_1.equals(deBeanSingleton_2)) {
			System.out.println("dependencyBeanSingleton_1 == dependencyBeanSingleton_2");
		} else {
			System.out.println("dependencyBeanSingleton_1 != dependencyBeanSingleton_2");
		}

		if(deBeanPrototype_1.equals(deBeanPrototype_2)) {
			System.out.println("dependencyBeanPrototype_1 == dependencyBeanPrototype_2");
		} else {
			System.out.println("dependencyBeanPrototype_1 != dependencyBeanPrototype_2");
		}

		ctx.close();
	}

}

*/

/*
// scope.InjectionBean.java

package scope;

public class InjectionBean {

}

*/

/*
// scope.DependencyBean.java

package scope;

public class DependencyBean {

	private InjectionBean injectionBean;

	public DependencyBean(InjectionBean injectionBean) {
		System.out.println("DependencyBean : constructor");
		this.injectionBean = injectionBean;
	}

	public void setInjectionBean(InjectionBean injectionBean) {
		System.out.println("DependencyBean : setter");
		this.injectionBean = injectionBean;
	}

}

*/

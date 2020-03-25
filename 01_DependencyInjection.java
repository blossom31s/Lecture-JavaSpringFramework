# Maven Project File Structure
springTest
  src/main/java
    ems.member
      DataBaseConnectionInfo.java
      MainClass.java
      MainClassUseConfiguration.java
      MainClassUseConfigurations.java
      MainClassUseConfigurationsImport.java
      MainClassUseXML.java
      MainClassUseXMLs.java
      MainClassUseXMLsImport.java
      Student.java
      StudentAssembler.java
    ems.member.configuration
      MemberConfig.java
      MemberConfig1.java
      MemberConfig2.java
      MemberConfig3.java
      MemberConfigImport.java
    ems.member.dao
      StudentDao.java
    ems.member.service
      EMSInformationService.java
      StudentAllSelectService.java
      StudentDeleteService.java
      StudentModifyService.java
      StudentRegisterService.java
      StudentSelectService.java
  src/main/resources
    appCtx1.xml
    appCtx2.xml
    appCtx3.xml
    appCtxImport.xml
    applicationContext.xml
  pom.xml

/*
// DataBaseConnectionInfo.java

package ems.member;

public class DataBaseConnectionInfo {

	private String jdbcUrl;
	private String userId;
	private String userPw;

	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

}

*/

/*
// MainClass.java

package ems.member;

import java.util.Scanner;

import ems.member.Student;
import ems.member.StudentAssembler;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

public class MainClass {

	public static void main(String[] args) {

		String[] sNums = {"H39r8djakndfae32", "H39asdfaelu42o23", "H39iiemamca8w9h4", 
						  "H39lkmn754fghia7", "H39plo865cuy8k92", "H39mnbviiaed89q1", 
						  "H399omjjyv56t3d5", "H39lczaqwg644gj8", "H39ymbcsh74thgh2", 
						  "H39lesvj7544vf89"};

		String[] sIds = {"rabbit", "hippo", "raccoon", "elephant", "lion", 
						  "tiger", "pig", "horse", "bird", "deer"};

		String[] sPws = {"96539", "94875", "15284", "48765", "28661", 
						 "60915", "30028", "29801", "28645", "28465"};

		String[] sNames = {"agatha", "barbara", "chris", "doris", "elva", 
						   "fiona", "holly", "jasmin", "lena", "melissa"};

		int[] sAges = {19, 22, 20, 27, 19, 21, 19, 25, 22, 24};

		String[] sGenders = {"M", "W", "W", "M", "M", "M", "W", "M", "W", "W"};

		String[] sMajors = {"English Literature", "Korean Language and Literature", 
							"French Language and Literature", "Philosophy", "History", 
							"Law", "Statistics", "Computer", "Economics", "Public Administration"};

		Scanner scanner = new Scanner(System.in);

		StudentAssembler assembler = new StudentAssembler();
		StudentRegisterService registerService = assembler.getRegisterService();
		StudentModifyService modifyService = assembler.getModifyService();
		StudentDeleteService deleteService = assembler.getDeleteService();
		StudentSelectService selectService = assembler.getSelectService();
		StudentAllSelectService allSelectService = assembler.getAllSelectService();

		// register
		for(int i=0 ; i<sNums.length ; ++i) {
			Student student = new Student(sNums[i], sIds[i], sPws[i], sNames[i],
					sAges[i], sGenders[i], sMajors[i]);
			registerService.register(student);
		}

		// modify
		modifyService.modify(new Student("H39lesvj7544vf89", "deer", "12345", "melissa", 
				26, "W", "Vocal Music"));

		// delete
		deleteService.delete("H399omjjyv56t3d5");

		// select
		selectService.select("H39r8djakndfae32");

		// allSelect
		allSelectService.allSelect();

		// user menu
		while(true) {
			String str = "";

			System.out.println("--------------------------------------------------"
					+ "--------------------------------------------------"
					+ "--------------------------------------------------");
			System.out.println("Select Number.");
			System.out.println("1. Check Student Information");
			System.out.println("2. Exit");

			str = scanner.next();
			if(str.equals("2")) {
				System.out.println("Bye~!");
				break;
			} else {
				System.out.println("Please input your class number.");

				str = scanner.next();
				selectService.select(str);
			}
		}

		scanner.close();
	}

}

*/

/*
// MainClassUseConfiguration.java



*/

/*
// MainClassUseConfigurations.java



*/

/*
// MainClassUseConfigurationsImport.java



*/

/*
// MainClassUseXML.java

package ems.member;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import ems.member.Student;
//import ems.member.StudentAssembler;
import ems.member.service.EMSInformationService;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

public class MainClassUseXML {

	public static void main(String[] args) {

		String[] sNums = {"H39r8djakndfae32", "H39asdfaelu42o23", "H39iiemamca8w9h4", 
						  "H39lkmn754fghia7", "H39plo865cuy8k92", "H39mnbviiaed89q1", 
						  "H399omjjyv56t3d5", "H39lczaqwg644gj8", "H39ymbcsh74thgh2", 
						  "H39lesvj7544vf89"};

		String[] sIds = {"rabbit", "hippo", "raccoon", "elephant", "lion", 
						  "tiger", "pig", "horse", "bird", "deer"};

		String[] sPws = {"96539", "94875", "15284", "48765", "28661", 
						 "60915", "30028", "29801", "28645", "28465"};

		String[] sNames = {"agatha", "barbara", "chris", "doris", "elva", 
						   "fiona", "holly", "jasmin", "lena", "melissa"};

		int[] sAges = {19, 22, 20, 27, 19, 21, 19, 25, 22, 24};

		String[] sGenders = {"M", "W", "W", "M", "M", "M", "W", "M", "W", "W"};

		String[] sMajors = {"English Literature", "Korean Language and Literature", 
							"French Language and Literature", "Philosophy", "History", 
							"Law", "Statistics", "Computer", "Economics", "Public Administration"};

		Scanner scanner = new Scanner(System.in);

//		StudentAssembler assembler = new StudentAssembler();
//		StudentRegisterService registerService = assembler.getRegisterService();
//		StudentModifyService modifyService = assembler.getModifyService();
//		StudentDeleteService deleteService = assembler.getDeleteService();
//		StudentSelectService selectService = assembler.getSelectService();
//		StudentAllSelectService allSelectService = assembler.getAllSelectService();
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		EMSInformationService informationService = ctx.getBean("informationService", EMSInformationService.class);
		StudentRegisterService registerService = ctx.getBean("registerService", StudentRegisterService.class);
		StudentModifyService modifyService = ctx.getBean("modifyService", StudentModifyService.class);
		StudentDeleteService deleteService = ctx.getBean("deleteService", StudentDeleteService.class);
		StudentSelectService selectService = ctx.getBean("selectService", StudentSelectService.class);
		StudentAllSelectService allSelectService = ctx.getBean("allSelectService", StudentAllSelectService.class);

		// information
		informationService.outputEMSInformation();
		
		// register
		for(int i=0 ; i<sNums.length ; ++i) {
			Student student = new Student(sNums[i], sIds[i], sPws[i], sNames[i],
					sAges[i], sGenders[i], sMajors[i]);
			registerService.register(student);
		}

		// modify
		modifyService.modify(new Student("H39lesvj7544vf89", "deer", "12345", "melissa", 
				26, "W", "Vocal Music"));

		// delete
		deleteService.delete("H399omjjyv56t3d5");

		// select
		selectService.select("H39r8djakndfae32");

		// allSelect
		allSelectService.allSelect();

		// user menu
		while(true) {
			String str = "";

			System.out.println("--------------------------------------------------"
					+ "--------------------------------------------------"
					+ "--------------------------------------------------");
			System.out.println("Select Number.");
			System.out.println("1. Check Student Information");
			System.out.println("2. Exit");

			str = scanner.next();
			if(str.equals("2")) {
				System.out.println("Bye~!");
				break;
			} else {
				System.out.println("Please input your class number.");

				str = scanner.next();
				selectService.select(str);
			}
		}

		ctx.close();
		scanner.close();
	}

}

*/

/*
// MainClassUseXMLs.java

package ems.member;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import ems.member.Student;
//import ems.member.StudentAssembler;
import ems.member.service.EMSInformationService;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

public class MainClassUseXMLs {

	public static void main(String[] args) {

		String[] sNums = {"H39r8djakndfae32", "H39asdfaelu42o23", "H39iiemamca8w9h4", 
						  "H39lkmn754fghia7", "H39plo865cuy8k92", "H39mnbviiaed89q1", 
						  "H399omjjyv56t3d5", "H39lczaqwg644gj8", "H39ymbcsh74thgh2", 
						  "H39lesvj7544vf89"};

		String[] sIds = {"rabbit", "hippo", "raccoon", "elephant", "lion", 
						  "tiger", "pig", "horse", "bird", "deer"};

		String[] sPws = {"96539", "94875", "15284", "48765", "28661", 
						 "60915", "30028", "29801", "28645", "28465"};

		String[] sNames = {"agatha", "barbara", "chris", "doris", "elva", 
						   "fiona", "holly", "jasmin", "lena", "melissa"};

		int[] sAges = {19, 22, 20, 27, 19, 21, 19, 25, 22, 24};

		String[] sGenders = {"M", "W", "W", "M", "M", "M", "W", "M", "W", "W"};

		String[] sMajors = {"English Literature", "Korean Language and Literature", 
							"French Language and Literature", "Philosophy", "History", 
							"Law", "Statistics", "Computer", "Economics", "Public Administration"};

		Scanner scanner = new Scanner(System.in);

//		StudentAssembler assembler = new StudentAssembler();
//		StudentRegisterService registerService = assembler.getRegisterService();
//		StudentModifyService modifyService = assembler.getModifyService();
//		StudentDeleteService deleteService = assembler.getDeleteService();
//		StudentSelectService selectService = assembler.getSelectService();
//		StudentAllSelectService allSelectService = assembler.getAllSelectService();
		String[] appCtxs = {"classpath:appCtx1.xml", "classpath:appCtx2.xml", "classpath:appCtx3.xml"};
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext(appCtxs);
		EMSInformationService informationService = ctx.getBean("informationService", EMSInformationService.class);
		StudentRegisterService registerService = ctx.getBean("registerService", StudentRegisterService.class);
		StudentModifyService modifyService = ctx.getBean("modifyService", StudentModifyService.class);
		StudentDeleteService deleteService = ctx.getBean("deleteService", StudentDeleteService.class);
		StudentSelectService selectService = ctx.getBean("selectService", StudentSelectService.class);
		StudentAllSelectService allSelectService = ctx.getBean("allSelectService", StudentAllSelectService.class);

		// information
		informationService.outputEMSInformation();
		
		// register
		for(int i=0 ; i<sNums.length ; ++i) {
			Student student = new Student(sNums[i], sIds[i], sPws[i], sNames[i],
					sAges[i], sGenders[i], sMajors[i]);
			registerService.register(student);
		}

		// modify
		modifyService.modify(new Student("H39lesvj7544vf89", "deer", "12345", "melissa", 
				26, "W", "Vocal Music"));

		// delete
		deleteService.delete("H399omjjyv56t3d5");

		// select
		selectService.select("H39r8djakndfae32");

		// allSelect
		allSelectService.allSelect();

		// user menu
		while(true) {
			String str = "";

			System.out.println("--------------------------------------------------"
					+ "--------------------------------------------------"
					+ "--------------------------------------------------");
			System.out.println("Select Number.");
			System.out.println("1. Check Student Information");
			System.out.println("2. Exit");

			str = scanner.next();
			if(str.equals("2")) {
				System.out.println("Bye~!");
				break;
			} else {
				System.out.println("Please input your class number.");

				str = scanner.next();
				selectService.select(str);
			}
		}

		ctx.close();
		scanner.close();
	}

}

*/

/*
// MainClassUseXMLsImport.java

package ems.member;

import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import ems.member.Student;
//import ems.member.StudentAssembler;
import ems.member.service.EMSInformationService;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

public class MainClassUseXMLsImport {

	public static void main(String[] args) {

		String[] sNums = {"H39r8djakndfae32", "H39asdfaelu42o23", "H39iiemamca8w9h4", 
						  "H39lkmn754fghia7", "H39plo865cuy8k92", "H39mnbviiaed89q1", 
						  "H399omjjyv56t3d5", "H39lczaqwg644gj8", "H39ymbcsh74thgh2", 
						  "H39lesvj7544vf89"};

		String[] sIds = {"rabbit", "hippo", "raccoon", "elephant", "lion", 
						  "tiger", "pig", "horse", "bird", "deer"};

		String[] sPws = {"96539", "94875", "15284", "48765", "28661", 
						 "60915", "30028", "29801", "28645", "28465"};

		String[] sNames = {"agatha", "barbara", "chris", "doris", "elva", 
						   "fiona", "holly", "jasmin", "lena", "melissa"};

		int[] sAges = {19, 22, 20, 27, 19, 21, 19, 25, 22, 24};

		String[] sGenders = {"M", "W", "W", "M", "M", "M", "W", "M", "W", "W"};

		String[] sMajors = {"English Literature", "Korean Language and Literature", 
							"French Language and Literature", "Philosophy", "History", 
							"Law", "Statistics", "Computer", "Economics", "Public Administration"};

		Scanner scanner = new Scanner(System.in);

//		StudentAssembler assembler = new StudentAssembler();
//		StudentRegisterService registerService = assembler.getRegisterService();
//		StudentModifyService modifyService = assembler.getModifyService();
//		StudentDeleteService deleteService = assembler.getDeleteService();
//		StudentSelectService selectService = assembler.getSelectService();
//		StudentAllSelectService allSelectService = assembler.getAllSelectService();
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtxImport.xml");
		EMSInformationService informationService = ctx.getBean("informationService", EMSInformationService.class);
		StudentRegisterService registerService = ctx.getBean("registerService", StudentRegisterService.class);
		StudentModifyService modifyService = ctx.getBean("modifyService", StudentModifyService.class);
		StudentDeleteService deleteService = ctx.getBean("deleteService", StudentDeleteService.class);
		StudentSelectService selectService = ctx.getBean("selectService", StudentSelectService.class);
		StudentAllSelectService allSelectService = ctx.getBean("allSelectService", StudentAllSelectService.class);

		// information
		informationService.outputEMSInformation();
		
		// register
		for(int i=0 ; i<sNums.length ; ++i) {
			Student student = new Student(sNums[i], sIds[i], sPws[i], sNames[i],
					sAges[i], sGenders[i], sMajors[i]);
			registerService.register(student);
		}

		// modify
		modifyService.modify(new Student("H39lesvj7544vf89", "deer", "12345", "melissa", 
				26, "W", "Vocal Music"));

		// delete
		deleteService.delete("H399omjjyv56t3d5");

		// select
		selectService.select("H39r8djakndfae32");

		// allSelect
		allSelectService.allSelect();

		// user menu
		while(true) {
			String str = "";

			System.out.println("--------------------------------------------------"
					+ "--------------------------------------------------"
					+ "--------------------------------------------------");
			System.out.println("Select Number.");
			System.out.println("1. Check Student Information");
			System.out.println("2. Exit");

			str = scanner.next();
			if(str.equals("2")) {
				System.out.println("Bye~!");
				break;
			} else {
				System.out.println("Please input your class number.");

				str = scanner.next();
				selectService.select(str);
			}
		}

		ctx.close();
		scanner.close();
	}

}

*/

/*
// Student.java

package ems.member;

public class Student {

	private String sNum;
	private String sId;
	private String sPw;
	private String sName;
	private int sAge;
	private String sGender;
	private String sMajor;

	public Student(String sNum, String sId, String sPw, String sName,
			int sAge, String sGender, String sMajor) {
		this.sNum = sNum;
		this.sId = sId;
		this.sPw = sPw;
		this.sName = sName;
		this.sAge = sAge;
		this.sGender = sGender;
		this.sMajor = sMajor;
	}

	public String getsNum() {
		return sNum;
	}

	public void setsNum(String sNum) {
		this.sNum = sNum;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsPw() {
		return sPw;
	}

	public void setsPw(String sPw) {
		this.sPw = sPw;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getsAge() {
		return sAge;
	}

	public void setsAge(int sAge) {
		this.sAge = sAge;
	}

	public String getsGender() {
		return sGender;
	}

	public void setsGender(String sGender) {
		this.sGender = sGender;
	}

	public String getsMajor() {
		return sMajor;
	}

	public void setsMajor(String sMajor) {
		this.sMajor = sMajor;
	}

}

*/

/*
// StudentAssembler.java

package ems.member;

import ems.member.dao.StudentDao;
import ems.member.service.StudentAllSelectService;
import ems.member.service.StudentDeleteService;
import ems.member.service.StudentModifyService;
import ems.member.service.StudentRegisterService;
import ems.member.service.StudentSelectService;

public class StudentAssembler {

	private StudentDao studentDao;
	private StudentRegisterService registerService;
	private StudentModifyService modifyService;
	private StudentDeleteService deleteService;
	private StudentSelectService selectService;
	private StudentAllSelectService allSelectService;

	public StudentAssembler() {
		studentDao = new StudentDao();
		registerService = new StudentRegisterService(studentDao);
		modifyService = new StudentModifyService(studentDao);
		deleteService = new StudentDeleteService(studentDao);
		selectService = new StudentSelectService(studentDao);
		allSelectService = new StudentAllSelectService(studentDao);
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public StudentRegisterService getRegisterService() {
		return registerService;
	}

	public void setRegisterService(StudentRegisterService registerService) {
		this.registerService = registerService;
	}

	public StudentModifyService getModifyService() {
		return modifyService;
	}

	public void setModifyService(StudentModifyService modifyService) {
		this.modifyService = modifyService;
	}

	public StudentDeleteService getDeleteService() {
		return deleteService;
	}

	public void setDeleteService(StudentDeleteService deleteService) {
		this.deleteService = deleteService;
	}

	public StudentSelectService getSelectService() {
		return selectService;
	}

	public void setSelectService(StudentSelectService selectService) {
		this.selectService = selectService;
	}

	public StudentAllSelectService getAllSelectService() {
		return allSelectService;
	}

	public void setAllSelectService(StudentAllSelectService allSelectService) {
		this.allSelectService = allSelectService;
	}

}

*/

/*
// MemberConfig.java



*/

/*
// MemberConfig1.java



*/

/*
// MemberConfig2.java



*/

/*
// MemberConfig3.java



*/

/*
// MemberConfigImport.java



*/

/*
// StudentDao.java

package ems.member.dao;

import java.util.HashMap;
import java.util.Map;

import ems.member.Student;

public class StudentDao {

	private Map<String, Student> studentDB = new HashMap<String, Student>();

	public void insert(Student student) {
		studentDB.put(student.getsNum(), student);
	}

	public Student select(String sNum) {
		return studentDB.get(sNum);
	}

	public void update(Student student) {
		studentDB.put(student.getsNum(), student);
	}

	public void delete(String sNum) {
		studentDB.remove(sNum);
	}

	public Map<String, Student> getStudentDB() {
		return studentDB;
	}

}

*/

/*
// EMSInformationService.java

package ems.member.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ems.member.DataBaseConnectionInfo;

public class EMSInformationService {

	private String info;
	private String copyRight;
	private String ver;
	private int sYear;
	private int sMonth;
	private int sDay;
	private int eYear;
	private int eMonth;
	private int eDay;
	private List<String> developers;
	private Map<String, String> administrators;
	private Map<String, DataBaseConnectionInfo> dbInfos;

	public EMSInformationService() {
		;
	}

	public void outputEMSInformation() {
		System.out.println("\n\n");
		String devPeriod = sYear + "/" + sMonth + "/" + sDay + " ~ " + eYear + "/" + eMonth + "/" + eDay;
		System.out.println(info + "(" + devPeriod + ")" + "\n" + copyRight + "\n" + ver);
		System.out.println("Developers : " + developers);
		System.out.println("Administrator : " + administrators);
		outputDataBaseInfo();
		System.out.println("\n\n");
	}

	private void outputDataBaseInfo() {
		Set<String> keys = dbInfos.keySet();
		Iterator<String> iterator = keys.iterator();

		while(iterator.hasNext()) {
			String key = iterator.next();
			DataBaseConnectionInfo info = dbInfos.get(key);
			System.out.println("[" + key + "]");
			System.out.println("jdbcUrl : " + info.getJdbcUrl() + "\t");
			System.out.println("userId : " + info.getUserId() + "\t");
			System.out.println("userPw : " + info.getUserPw() + "\t");
		}
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCopyRight() {
		return copyRight;
	}

	public void setCopyRight(String copyRight) {
		this.copyRight = copyRight;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		this.ver = ver;
	}

	public int getsYear() {
		return sYear;
	}

	public void setsYear(int sYear) {
		this.sYear = sYear;
	}

	public int getsMonth() {
		return sMonth;
	}

	public void setsMonth(int sMonth) {
		this.sMonth = sMonth;
	}

	public int getsDay() {
		return sDay;
	}

	public void setsDay(int sDay) {
		this.sDay = sDay;
	}

	public int geteYear() {
		return eYear;
	}

	public void seteYear(int eYear) {
		this.eYear = eYear;
	}

	public int geteMonth() {
		return eMonth;
	}

	public void seteMonth(int eMonth) {
		this.eMonth = eMonth;
	}

	public int geteDay() {
		return eDay;
	}

	public void seteDay(int eDay) {
		this.eDay = eDay;
	}

	public List<String> getDevelopers() {
		return developers;
	}

	public void setDevelopers(List<String> developers) {
		this.developers = developers;
	}

	public Map<String, String> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(Map<String, String> administrators) {
		this.administrators = administrators;
	}

	public Map<String, DataBaseConnectionInfo> getDbInfos() {
		return dbInfos;
	}

	public void setDbInfos(Map<String, DataBaseConnectionInfo> dbInfos) {
		this.dbInfos = dbInfos;
	}

}

*/

/*
// StudentAllSelectService.java

package ems.member.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import ems.member.Student;
import ems.member.dao.StudentDao;

public class StudentAllSelectService {

	private StudentDao studentDao;

	public StudentAllSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void allSelect() {
		Map<String, Student> allStudent = studentDao.getStudentDB();
		Set<String> keys = allStudent.keySet();
		Iterator<String> iterator = keys.iterator();

		while (iterator.hasNext()) {
			String key = iterator.next();
			Student student = allStudent.get(key);
			System.out.print("sNum:" + student.getsNum() + "\t");
			System.out.print("|sId:" + student.getsId() + "\t");
			System.out.print("|sPw:" + student.getsPw() + "\t");
			System.out.print("|sName:" + student.getsName() + "\t");
			System.out.print("|sAge:" + student.getsAge() + "\t");
			System.out.print("|sGender:" + student.getsGender() + "\t");
			System.out.println("|sMajor:" + student.getsMajor() + "\t");
		}
	}

}

*/

/*
// StudentDeleteService.java

package ems.member.service;

import ems.member.Student;
import ems.member.dao.StudentDao;

public class StudentDeleteService {

	private StudentDao studentDao;

	public StudentDeleteService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void delete(String sNum) {
		if(verify(sNum)) {
			studentDao.delete(sNum);
		} else {
			System.out.println("Student information is not available.");
		}
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}

}

*/

/*
// StudentModifyService.java

package ems.member.service;

import ems.member.Student;
import ems.member.dao.StudentDao;

public class StudentModifyService {

	private StudentDao studentDao;

	public StudentModifyService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void modify(Student student) {
		if(verify(student.getsNum())) {
			studentDao.update(student);
		} else {
			System.out.println("Student information is not available.");
		}
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}

}

*/

/*
// StudentRegisterService.java

package ems.member.service;

import ems.member.Student;
import ems.member.dao.StudentDao;

public class StudentRegisterService {

	private StudentDao studentDao;

	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void register(Student student) {
		if(verify(student.getsNum())) {
			studentDao.insert(student);
		} else {
			System.out.println("The student has already registered.");
		}
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student == null ? true : false;
	}

}

*/

/*
// StudentSelectService.java

package ems.member.service;

import ems.member.Student;
import ems.member.dao.StudentDao;

public class StudentSelectService {

	private StudentDao studentDao;

	public StudentSelectService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void select(String sNum) {
		Student student = studentDao.select(sNum);
		if(verify(sNum)) {
			System.out.print("sNum:" + student.getsNum() + "\t");
			System.out.print("|sId:" + student.getsId() + "\t");
			System.out.print("|sPw:" + student.getsPw() + "\t");
			System.out.print("|sName:" + student.getsName() + "\t");
			System.out.print("|sAge:" + student.getsAge() + "\t");
			System.out.print("|sGender:" + student.getsGender() + "\t");
			System.out.print("|sMajor:" + student.getsMajor() + "\n\n");
		} else {
			System.out.println("Student information is not available.");
		}
	}

	public boolean verify(String sNum) {
		Student student = studentDao.select(sNum);
		return student != null ? true : false;
	}

}

*/

/*
// appCtx1.xml

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="studentDao" class="ems.member.dao.StudentDao" />

	<bean id="registerService" class="ems.member.service.StudentRegisterService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="modifyService" class="ems.member.service.StudentModifyService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="deleteService" class="ems.member.service.StudentDeleteService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="selectService" class="ems.member.service.StudentSelectService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="allSelectService" class="ems.member.service.StudentAllSelectService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

</beans>

*/

/*
// appCtx2.xml

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="dataBaseConnectionInfoDev" class="ems.member.DataBaseConnectionInfo">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:orcl" />
		<property name="userId" value="scott" />
		<property name="userPw" value="tiger" />
	</bean>

	<bean id="dataBaseConnectionInfoReal" class="ems.member.DataBaseConnectionInfo">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@192.64.0.1:1521:orcl" />
		<property name="userId" value="masterid" />
		<property name="userPw" value="masterpw" />
	</bean>

</beans>

*/

/*
// appCtx3.xml

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="informationService" class="ems.member.service.EMSInformationService">
		<property name="info">
			<value>Education Management System program was developed in 2015.</value>
		</property>
		<property name="copyRight">
			<value>COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.</value>
		</property>
		<property name="ver">
			<value>The version is 0.1</value>
		</property>
		<property name="sYear">
			<value>2015</value>
		</property>
		<property name="sMonth">
			<value>1</value>
		</property>
		<property name="sDay">
			<value>1</value>
		</property>
		<property name="eYear" value="2015" />
		<property name="eMonth" value="2" />
		<property name="eDay" value="28" />
		<property name="developers">
			<list>
				<value>Cheney.</value>
				<value>Eloy.</value>
				<value>Jasper.</value>
				<value>Dillon.</value>
				<value>Kian.</value>
			</list>
		</property>
		<property name="administrators">
			<map>
				<entry>
					<key>
						<value>Cheney</value>
					</key>
					<value>cheney@springPjt.org</value>
				</entry>
				<entry>
					<key>
						<value>Jasper</value>
					</key>
					<value>jasper@springPjt.org</value>
				</entry>
			</map>
		</property>
		<property name="dbInfos">
			<map>
				<entry>
					<key>
						<value>dev</value>
					</key>
					<ref bean="dataBaseConnectionInfoDev"/>
				</entry>
				<entry>
					<key>
						<value>real</value>
					</key>
					<ref bean="dataBaseConnectionInfoReal"/>
				</entry>
			</map>
		</property>
	</bean>

</beans>

*/

/*
// appCtxImport.xml

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd">

	<import resource="classpath:appCtx2.xml" />
	<import resource="classpath:appCtx3.xml" />

	<bean id="studentDao" class="ems.member.dao.StudentDao" />

	<bean id="registerService" class="ems.member.service.StudentRegisterService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="modifyService" class="ems.member.service.StudentModifyService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="deleteService" class="ems.member.service.StudentDeleteService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="selectService" class="ems.member.service.StudentSelectService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="allSelectService" class="ems.member.service.StudentAllSelectService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

</beans>

*/

/*
// applicationContext.xml

<?xml version="1.0" encoding="UTF-8"?>

<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans 
 		http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="studentDao" class="ems.member.dao.StudentDao" />

	<bean id="registerService" class="ems.member.service.StudentRegisterService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="modifyService" class="ems.member.service.StudentModifyService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="deleteService" class="ems.member.service.StudentDeleteService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="selectService" class="ems.member.service.StudentSelectService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="allSelectService" class="ems.member.service.StudentAllSelectService">
		<constructor-arg ref="studentDao"></constructor-arg>
	</bean>

	<bean id="dataBaseConnectionInfoDev" class="ems.member.DataBaseConnectionInfo">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@localhost:1521:orcl" />
		<property name="userId" value="scott" />
		<property name="userPw" value="tiger" />
	</bean>

	<bean id="dataBaseConnectionInfoReal" class="ems.member.DataBaseConnectionInfo">
		<property name="jdbcUrl" value="jdbc:oracle:thin:@192.64.0.1:1521:orcl" />
		<property name="userId" value="masterid" />
		<property name="userPw" value="masterpw" />
	</bean>

	<bean id="informationService" class="ems.member.service.EMSInformationService">
		<property name="info">
			<value>Education Management System program was developed in 2015.</value>
		</property>
		<property name="copyRight">
			<value>COPYRIGHT(C) 2015 EMS CO., LTD. ALL RIGHT RESERVED. CONTACT MASTER FOR MORE INFORMATION.</value>
		</property>
		<property name="ver">
			<value>The version is 0.1</value>
		</property>
		<property name="sYear">
			<value>2015</value>
		</property>
		<property name="sMonth">
			<value>1</value>
		</property>
		<property name="sDay">
			<value>1</value>
		</property>
		<property name="eYear" value="2015" />
		<property name="eMonth" value="2" />
		<property name="eDay" value="28" />
		<property name="developers">
			<list>
				<value>Cheney.</value>
				<value>Eloy.</value>
				<value>Jasper.</value>
				<value>Dillon.</value>
				<value>Kian.</value>
			</list>
		</property>
		<property name="administrators">
			<map>
				<entry>
					<key>
						<value>Cheney</value>
					</key>
					<value>cheney@springPjt.org</value>
				</entry>
				<entry>
					<key>
						<value>Jasper</value>
					</key>
					<value>jasper@springPjt.org</value>
				</entry>
			</map>
		</property>
		<property name="dbInfos">
			<map>
				<entry>
					<key>
						<value>dev</value>
					</key>
					<ref bean="dataBaseConnectionInfoDev"/>
				</entry>
				<entry>
					<key>
						<value>real</value>
					</key>
					<ref bean="dataBaseConnectionInfoReal"/>
				</entry>
			</map>
		</property>
	</bean>

</beans>

*/

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

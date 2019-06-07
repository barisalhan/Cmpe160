package codes.teaching.testing.student;

import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import books.*;
import librarymembers.*;
import interfaces.Borrow;
import interfaces.ReadInLibrary;
import library.Library;

//Tests will be sorted in lexicographical order.
//Therefore start the names as "test1_TestName"
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

@RunWith(JUnit4.class)
public final class ExamTestCase extends ExamTest{

	@Rule
	public TestName name  = new TestName();
	
	@Test
	public void test1_ClassHierarchy_Handwritten() {
		ExamTest.testInitialization(1,name.getMethodName(),"Is HandWritten subclass of Book?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			if(Book.class.isAssignableFrom(Handwritten.class)
					&& ReadInLibrary.class.isAssignableFrom(Handwritten.class)) {
				answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
		
	@Test
	public void test2_ClassHierarchy_Printed() {
		ExamTest.testInitialization(2,name.getMethodName(),"Is Printed subclass of Book?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			if(Book.class.isAssignableFrom(Printed.class)
					&& ReadInLibrary.class.isAssignableFrom(Printed.class)
					&& Borrow.class.isAssignableFrom(Printed.class)) {
				answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	

	@Test
	public void test3_ClassHierarchy_Academic() {
		ExamTest.testInitialization(3,name.getMethodName(),"Is Academic subclass of Book?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			if(LibraryMember.class.isAssignableFrom(Academic.class)) {
				answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
	@Test
	public void test4_ClassHierarchy_Student() {
		ExamTest.testInitialization(4,name.getMethodName(),"Is Student subclass of Book?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			if(LibraryMember.class.isAssignableFrom(Student.class)) {
				answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
	@Test
	public void test5_HaveConstructor_Handwritten() {
		ExamTest.testInitialization(5,name.getMethodName(),"Does HandWritten have a constructor?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			Constructor<?>[] constr = Handwritten.class.getDeclaredConstructors();
			
			AnnotatedType[] parameters = constr[0].getAnnotatedParameterTypes();
			
			if(parameters[0].getType().toString().equals("int")) {
				answerStudent = "success";
			}
			
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
	
	@Test
	public void test6_HaveConstructor_Printed() {
		ExamTest.testInitialization(6,name.getMethodName(),"Does Printed have a constructor?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			Constructor<?>[] constr = Printed.class.getDeclaredConstructors();
			
			AnnotatedType[] parameters = constr[0].getAnnotatedParameterTypes();
			
			if(parameters[0].getType().toString().equals("int")) {
				answerStudent = "success";
			}
			
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
	@Test
	public void test7_isAbstract_Book() {
		ExamTest.testInitialization(7,name.getMethodName(),"Does Book is an abstract class?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			
			if(Book.class.getModifiers()==1025) {
				answerStudent = "success";
			}
			
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
	@Test
	public void test8_isAbstract_LibraryMember() {
		ExamTest.testInitialization(8,name.getMethodName(),"Does LibraryMember is an abstract class?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			
			if(LibraryMember.class.getModifiers()==1025) {
				answerStudent = "success";
			}
			
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
	
	

}


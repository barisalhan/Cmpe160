package codes.teaching.testing.student;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.AnnotatedType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.MethodSorters;

import com.sun.javafx.tools.packager.Main;

import books.*;
import librarymembers.*;
import librarysimulator.*;
import librarysimulator.LibrarySimulator;
import librarysimulator.Action.Type;
import interfaces.Borrow;
import interfaces.ReadInLibrary;
import library.Library;

//Tests will be sorted in lexicographical order.
//Therefore start the names as "test1_TestName"
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/**
 * 
 * @author BarisAlhan
 *
 */
@RunWith(JUnit4.class)
public final class ExamTestCase extends ExamTest{

	@Rule
	public TestName name  = new TestName();
	
	@Test
	public void test01_ClassHierarchy_Handwritten() {
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
	public void test02_ClassHierarchy_Printed() {
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
	public void test03_ClassHierarchy_Academic() {
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
	public void test04_ClassHierarchy_Student() {
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
	public void test05_HaveConstructor_Handwritten() {
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
	public void test06_HaveConstructor_Printed() {
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
	public void test07_isAbstract_Book() {
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
	public void test08_isAbstract_LibraryMember() throws IOException {
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
	
	@Test
	public void test17_HaveConstructor_Book() {
		ExamTest.testInitialization(17,name.getMethodName(),"Does Book have a constructor?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			Constructor<?>[] constr = Book.class.getDeclaredConstructors();
			
			AnnotatedType[] parameters = constr[0].getAnnotatedParameterTypes();
			if( (parameters[0].getType().toString().equals("int") && parameters[1].getType().toString().contains("String"))
				|| (parameters[1].getType().toString().equals("int") && parameters[0].getType().toString().contains("String")) ) {
				answerStudent = "success";
			}
			
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	@Test
	public void test18_HaveConstructor_Academic() {
		ExamTest.testInitialization(18,name.getMethodName(),"Does Academic have a constructor?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			Constructor<?>[] constr = Academic.class.getDeclaredConstructors();
			
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
	public void test19_HaveConstructor_Student() {
		ExamTest.testInitialization(19,name.getMethodName(),"Does Student have a constructor?",
				"success",5,0);
		try {
			String answerStudent = "not success";
			Constructor<?>[] constr = Student.class.getDeclaredConstructors();
			
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
	public void test09_case1() throws Exception, FileNotFoundException{
		ExamTest.testInitialization(9,name.getMethodName(),"Testing the fee of the student.",
				"success",5,0);
		
		File inputFile = new File("input1.txt");
		
		Scanner scanner = new Scanner(inputFile);
		
		LibrarySimulator simulation = new LibrarySimulator(scanner);
		int numberOfEvents = scanner.nextInt();
		
		for(int i=0;i<numberOfEvents;i++) {
			
			int type = scanner.nextInt();
//			System.out.println(type);
			Action action;
			
			if(type==1) {
				 action = new Action(Type.addBook);
				 simulation.timerTick(action);
			}
			else if(type==2) {
				action = new Action(Type.addMember);
				simulation.timerTick(action);
			}
			else if(type==3) {
				action = new Action(Type.borrowBook);
				simulation.timerTick(action);
			}
			else if(type==4){
				action = new Action(Type.returnBook);
				simulation.timerTick(action);
			}
			else if(type==5){
				action = new Action(Type.extendBook);
				simulation.timerTick(action);
			}
			else if(type==6){
				action = new Action(Type.readInLibrary);
				simulation.timerTick(action);
			}
			
		}
		scanner.close();
		
		Field[] declaredFields = LibrarySimulator.class.getDeclaredFields();
		Field newField = null;
		for(int i = 0; i < declaredFields.length; i++) {
			if(declaredFields[i].getName().contains("library")) {
				declaredFields[i].setAccessible(true);
				newField = declaredFields[i];
			}
		}
		
		Library l = (Library) newField.get(simulation);
		
		
		try {
			String answerStudent = "not success";
			if(l.totalFee == 11) {
				answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
	@Test
	public void test10_case2() throws Exception, FileNotFoundException{
		ExamTest.testInitialization(10,name.getMethodName(),"Testing the Fee of  the academician",
				"success",5,0);
		
		File inputFile = new File("input2.txt");
		
		Scanner scanner = new Scanner(inputFile);
		
		LibrarySimulator simulation = new LibrarySimulator(scanner);
		int numberOfEvents = scanner.nextInt();
		
		for(int i=0;i<numberOfEvents;i++) {
			
			int type = scanner.nextInt();
			
			Action action;
			
			if(type==1) {
				 action = new Action(Type.addBook);
				 simulation.timerTick(action);
			}
			else if(type==2) {
				action = new Action(Type.addMember);
				simulation.timerTick(action);
			}
			else if(type==3) {
				action = new Action(Type.borrowBook);
				simulation.timerTick(action);
			}
			else if(type==4){
				action = new Action(Type.returnBook);
				simulation.timerTick(action);
			}
			else if(type==5){
				action = new Action(Type.extendBook);
				simulation.timerTick(action);
			}
			else if(type==6){
				action = new Action(Type.readInLibrary);
				simulation.timerTick(action);
			}
			
		}
		scanner.close();
		
		Field[] declaredFields = LibrarySimulator.class.getDeclaredFields();
		Field newField = null;
		for(int i = 0; i < declaredFields.length; i++) {
			if(declaredFields[i].getName().contains("library")) {
				declaredFields[i].setAccessible(true);
				newField = declaredFields[i];
			}
		}
		
		Library l = (Library) newField.get(simulation);
		
		
		try {
			String answerStudent = "not success";
			if(l.totalFee == 11) {
				answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	@Test
	public void test11_case3() throws Exception, FileNotFoundException{
		ExamTest.testInitialization(11,name.getMethodName(),"Testing the Fee of the student with the extension of deadline",
				"success",5,0);
		
		File inputFile = new File("input3.txt");
		
		Scanner scanner = new Scanner(inputFile);
		
		LibrarySimulator simulation = new LibrarySimulator(scanner);
		int numberOfEvents = scanner.nextInt();
		
		for(int i=0;i<numberOfEvents;i++) {
			
			int type = scanner.nextInt();
			
			Action action;
			
			if(type==1) {
				 action = new Action(Type.addBook);
				 simulation.timerTick(action);
			}
			else if(type==2) {
				action = new Action(Type.addMember);
				simulation.timerTick(action);
			}
			else if(type==3) {
				action = new Action(Type.borrowBook);
				simulation.timerTick(action);
			}
			else if(type==4){
				action = new Action(Type.returnBook);
				simulation.timerTick(action);
			}
			else if(type==5){
				action = new Action(Type.extendBook);
				simulation.timerTick(action);
			}
			else if(type==6){
				action = new Action(Type.readInLibrary);
				simulation.timerTick(action);
			}
			
		}
		scanner.close();
		
		Field[] declaredFields = LibrarySimulator.class.getDeclaredFields();
		Field newField = null;
		for(int i = 0; i < declaredFields.length; i++) {
			if(declaredFields[i].getName().contains("library")) {
				declaredFields[i].setAccessible(true);
				newField = declaredFields[i];
			}
		}
		
		Library l = (Library) newField.get(simulation);
		
		
		try {
			String answerStudent = "not success";
			if(l.totalFee == 12) {
				answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
	@Test
	public void test12_case4() throws Exception, FileNotFoundException{
		ExamTest.testInitialization(12,name.getMethodName(),"Testing the Fee of the academician with the extension of deadline",
				"success",5,0);
		
		File inputFile = new File("input4.txt");
		
		Scanner scanner = new Scanner(inputFile);
		
		LibrarySimulator simulation = new LibrarySimulator(scanner);
		int numberOfEvents = scanner.nextInt();
		
		for(int i=0;i<numberOfEvents;i++) {
			
			int type = scanner.nextInt();
			
			Action action;
			
			if(type==1) {
				 action = new Action(Type.addBook);
				 simulation.timerTick(action);
			}
			else if(type==2) {
				action = new Action(Type.addMember);
				simulation.timerTick(action);
			}
			else if(type==3) {
				action = new Action(Type.borrowBook);
				simulation.timerTick(action);
			}
			else if(type==4){
				action = new Action(Type.returnBook);
				simulation.timerTick(action);
			}
			else if(type==5){
				action = new Action(Type.extendBook);
				simulation.timerTick(action);
			}
			else if(type==6){
				action = new Action(Type.readInLibrary);
				simulation.timerTick(action);
			}
			
		}
		scanner.close();
		
		Field[] declaredFields = LibrarySimulator.class.getDeclaredFields();
		Field newField = null;
		for(int i = 0; i < declaredFields.length; i++) {
			if(declaredFields[i].getName().contains("library")) {
				declaredFields[i].setAccessible(true);
				newField = declaredFields[i];
			}
		}
		
		Library l = (Library) newField.get(simulation);
		
		
		try {
			String answerStudent = "not success";
			if(l.totalFee == 12) {
				answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
	@Test
	public void test13_case5() throws Exception, FileNotFoundException{
		ExamTest.testInitialization(13,name.getMethodName(),"Testing the Fee of  the student with the erroneous extension of deadline",
				"success",5,0);
		
		File inputFile = new File("input5.txt");
		
		Scanner scanner = new Scanner(inputFile);
		
		LibrarySimulator simulation = new LibrarySimulator(scanner);
		int numberOfEvents = scanner.nextInt();
		
		for(int i=0;i<numberOfEvents;i++) {
			
			int type = scanner.nextInt();
			
			Action action;
			
			if(type==1) {
				 action = new Action(Type.addBook);
				 simulation.timerTick(action);
			}
			else if(type==2) {
				action = new Action(Type.addMember);
				simulation.timerTick(action);
			}
			else if(type==3) {
				action = new Action(Type.borrowBook);
				simulation.timerTick(action);
			}
			else if(type==4){
				action = new Action(Type.returnBook);
				simulation.timerTick(action);
			}
			else if(type==5){
				action = new Action(Type.extendBook);
				simulation.timerTick(action);
			}
			else if(type==6){
				action = new Action(Type.readInLibrary);
				simulation.timerTick(action);
			}
			
		}
		scanner.close();
		
		Field[] declaredFields = LibrarySimulator.class.getDeclaredFields();
		Field newField = null;
		for(int i = 0; i < declaredFields.length; i++) {
			if(declaredFields[i].getName().contains("library")) {
				declaredFields[i].setAccessible(true);
				newField = declaredFields[i];
			}
		}
		
		Library l = (Library) newField.get(simulation);
		
		
		try {
			String answerStudent = "not success";
			if(l.totalFee == 14) {
				answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}

	@Test
	public void test14_case6() throws Exception, FileNotFoundException{
		ExamTest.testInitialization(14,name.getMethodName(),"Testing the erroneous borrowal of a handwritten book",
				"success",5,0);
		
		File inputFile = new File("input6.txt");
		
		Scanner scanner = new Scanner(inputFile);
		
		LibrarySimulator simulation = new LibrarySimulator(scanner);
		int numberOfEvents = scanner.nextInt();
		
		for(int i=0;i<numberOfEvents;i++) {
			
			int type = scanner.nextInt();
			
			Action action;
			
			if(type==1) {
				 action = new Action(Type.addBook);
				 simulation.timerTick(action);
			}
			else if(type==2) {
				action = new Action(Type.addMember);
				simulation.timerTick(action);
			}
			else if(type==3) {
				action = new Action(Type.borrowBook);
				simulation.timerTick(action);
			}
			else if(type==4){
				action = new Action(Type.returnBook);
				simulation.timerTick(action);
			}
			else if(type==5){
				action = new Action(Type.extendBook);
				simulation.timerTick(action);
			}
			else if(type==6){
				action = new Action(Type.readInLibrary);
				simulation.timerTick(action);
			}
			
		}
		scanner.close();
		
		Field[] declaredFields = LibrarySimulator.class.getDeclaredFields();
		Field newField = null;
		for(int i = 0; i < declaredFields.length; i++) {
			if(declaredFields[i].getName().contains("library")) {
				declaredFields[i].setAccessible(true);
				newField = declaredFields[i];
			}
		}
		
		Library l = (Library) newField.get(simulation);
		
		try{
			String answerStudent = "not success";
			LibraryMember[] members = l.getMembers();
			LibraryMember mem1 = members[1]; 
			LibraryMember mem2 = members[3];
			ArrayList<Book> list1 = mem1.getTheHistory();
			ArrayList<Book> list2 = mem2.getTheHistory();
			//System.out.println(list1.size());
			//System.out.println(list2.size());
			if(list1.size()==0 && list2.size()==0) {
					answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}	
	
	@Test
	public void test15_case7() throws Exception, FileNotFoundException{
		ExamTest.testInitialization(15,name.getMethodName(),"Testing the erroneous borrowal of a printed book",
				"success",5,0);
		
		File inputFile = new File("input7.txt");
		
		Scanner scanner = new Scanner(inputFile);
		
		LibrarySimulator simulation = new LibrarySimulator(scanner);
		int numberOfEvents = scanner.nextInt();
		
		for(int i=0;i<numberOfEvents;i++) {
			
			int type = scanner.nextInt();
			
			Action action;
			
			if(type==1) {
				 action = new Action(Type.addBook);
				 simulation.timerTick(action);
			}
			else if(type==2) {
				action = new Action(Type.addMember);
				simulation.timerTick(action);
			}
			else if(type==3) {
				action = new Action(Type.borrowBook);
				simulation.timerTick(action);
			}
			else if(type==4){
				action = new Action(Type.returnBook);
				simulation.timerTick(action);
			}
			else if(type==5){
				action = new Action(Type.extendBook);
				simulation.timerTick(action);
			}
			else if(type==6){
				action = new Action(Type.readInLibrary);
				simulation.timerTick(action);
			}
			
		}
		scanner.close();
		
		Field[] declaredFields = LibrarySimulator.class.getDeclaredFields();
		Field newField = null;
		for(int i = 0; i < declaredFields.length; i++) {
			if(declaredFields[i].getName().contains("library")) {
				declaredFields[i].setAccessible(true);
				newField = declaredFields[i];
			}
		}
		
		Library l = (Library) newField.get(simulation);
		
		try{
			String answerStudent = "not success";
			LibraryMember[] members = l.getMembers();
			LibraryMember mem1 = members[1]; 
			LibraryMember mem2 = members[2];
			ArrayList<Book> list1 = mem1.getTheHistory();
			ArrayList<Book> list2 = mem2.getTheHistory();
			//System.out.println(list1.size());
			//System.out.println(list2.size());
			if(list1.size()==2 && list2.size()==0) {
					answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
	@Test
	public void test16_case8() throws Exception, FileNotFoundException{
		ExamTest.testInitialization(16,name.getMethodName(),"Testing the erroneous request of readInLibrary",
				"success",5,0);
		//System.out.println("Here");
		File inputFile = new File("input8.txt");
		
		Scanner scanner = new Scanner(inputFile);
		
		LibrarySimulator simulation = new LibrarySimulator(scanner);
		int numberOfEvents = scanner.nextInt();
		
		for(int i=0;i<numberOfEvents;i++) {
			
			int type = scanner.nextInt();
			
			Action action;
			
			if(type==1) {
				 action = new Action(Type.addBook);
				 simulation.timerTick(action);
			}
			else if(type==2) {
				action = new Action(Type.addMember);
				simulation.timerTick(action);
			}
			else if(type==3) {
				action = new Action(Type.borrowBook);
				simulation.timerTick(action);
			}
			else if(type==4){
				action = new Action(Type.returnBook);
				simulation.timerTick(action);
			}
			else if(type==5){
				action = new Action(Type.extendBook);
				simulation.timerTick(action);
			}
			else if(type==6){
				action = new Action(Type.readInLibrary);
				simulation.timerTick(action);
			}
			
		}
		scanner.close();
		
		Field[] declaredFields = LibrarySimulator.class.getDeclaredFields();
		Field newField = null;
		for(int i = 0; i < declaredFields.length; i++) {
			if(declaredFields[i].getName().contains("library")) {
				declaredFields[i].setAccessible(true);
				newField = declaredFields[i];
			}
		}
		
		Library l = (Library) newField.get(simulation);
		
		try{
			String answerStudent = "not success";
			LibraryMember[] members = l.getMembers();
			LibraryMember mem1 = members[1]; 
			LibraryMember mem2 = members[3];
			ArrayList<Book> list1 = mem1.getTheHistory();
			ArrayList<Book> list2 = mem2.getTheHistory();
			if(list1.size()==0 && list2.size()==1) {
					answerStudent = "success";
			}
			ExamTest.testCheck(answerStudent);
		}catch(Exception e) {
			testFailedExecution(e);
		}
	}
	
}



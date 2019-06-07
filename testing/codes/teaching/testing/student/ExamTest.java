package codes.teaching.testing.student;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class ExamTest {

	void tcFail(String msg) {
		System.err.println(msg);
		fail(msg);
	}
	
	void tcSuccess(String msg) {
		System.out.println(msg);
	}
	
	public String answerStudent;
	static String description;
	static String answerCorrect;
	static String methodName;
	StringBuilder stringBuilder = new StringBuilder();
	static final String REPORT_DESCRIPTION = "\n\tDESCRIPTION:\t";
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	static final void testInitialization(int scenerioNo, String MethodName, String description, String answerCorrect,
			int pointPlus, int pointMinus) {
		ExamTest.methodName = methodName;
		ExamTest.description = methodName + REPORT_DESCRIPTION + description;
		ExamTest.answerCorrect = answerCorrect;
	}
	
	static final void testCheck(String answerStudent) {
		try {
			assertTrue(answerCorrect.equals(answerStudent));
			System.out.println(description + "\tSuccess: Your answer:\t" + answerStudent);
		} catch (AssertionError e) {
			/* runs but produces wrong answer */
			System.err.println(description +"\tFAILED :");
			System.err.println("\tYour answer:\t" + answerStudent);
			System.err.println("\tCorrect answer:\t" + ExamTest.answerCorrect);
			fail("Your answer does not match the expected answer");
		}
	}
	
	static final void testFailedExecution(Throwable e) {
		System.out.println("testFailedExecution");
	}
	
	public static void main(String[] args) {
		System.out.println("ExamTest Main");
		Result result = JUnitCore.runClasses(ExamTestCase.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
	}

}
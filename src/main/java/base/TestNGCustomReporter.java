package base;

import org.testng.Reporter;

public class TestNGCustomReporter extends Reporter {
//Use the methods from here, if you would like to log to the TestNG reports
	public static void logln(String str) {
		log("\n" + str);
	}

	public static void logbr(String str) {
		System.out.println(str);

		log("<br>" + str);
	}
}

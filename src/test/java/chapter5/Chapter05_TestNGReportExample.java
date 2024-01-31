package chapter5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Chapter05_TestNGReportExample {
	@Test
	public void sampleTest() {
		Assert.assertEquals(5, 5, "Sample test for demonstration.");
	}

}

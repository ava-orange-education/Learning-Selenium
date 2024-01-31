package chapter10;

import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import base.BaseTest;

public class Chapter10_ExcelTest extends BaseTest {
	@Test
	public void excelReadTest() throws InterruptedException, FileNotFoundException {
		System.out.println("Value from specified file is " + excelValueReader(0, 0));
	}

	@Test
	public void excelWriteTest() throws InterruptedException, FileNotFoundException {
		String testdata1 = String.valueOf(Math.random());
		System.out.println("Value written is " + testdata1);
		excelValueWriter(0, 0, testdata1);
	}
}

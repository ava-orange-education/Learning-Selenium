package chapter5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Chapter05_LogExample {
	@Test(priority = 1)
	public void loggerTest() throws Exception {
		final Logger logger = LogManager.getLogger();

		logger.trace("Entering method processOrder().");
		logger.debug("Received order with ID 12345.");
		logger.info("Order shipped successfully.");
		logger.warn("Potential security vulnerability detected in user input: '...'");
		logger.error("Failed to process order. Error: {. . .}");
		logger.fatal("System crashed. Shutting down...");

	}
}

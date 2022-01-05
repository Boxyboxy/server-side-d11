package com.example.workshop11;

import java.util.Collections;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// import third party library for logging
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class Workshop11Application {
	// instantiate the logger
	private static final Logger logger = LoggerFactory.getLogger(Workshop11Application.class);
	// the default fallback port used by the spring boot application
	private static final String DEFAULT_PORT = "3000";

	public static void main(String[] args) {
		// logger.info("Workshop 11");
		// SpringApplication app = new SpringApplication(Workshop11Application.class);

		// String port = "8080";
		// ApplicationArguments appArgs = new DefaultApplicationArguments(args);
		// if (appArgs.containsOption("port")) {
		// port = appArgs.getOptionValues("port").get(0);
		// }

		// logger.info("Port configured using CLI: " + appArgs);
		// app.setDefaultProperties(Collections.singletonMap("server.port", port));
		// System.out.printf("Application started on port %s\n", port);
		// app.run(args);

		logger.info("Workshop 11");
		// init the spring app
		SpringApplication app = new SpringApplication(Workshop11Application.class);
		// decode the hava app args using spring args helper
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);
		// return the args from the java args as list of strings
		List optsVal = appArgs.getOptionValues("port");
		logger.info("List taken in: " + optsVal);
		// variable to hold up the port number to be pass on to the spring boot app
		String portNumber = null;
		// check if the opt arg is null or the first element is null as before
		// retrieving it from the env variable

		if (optsVal == null || optsVal.get(0) == null) {
			// retrieve from the OS env variable
			portNumber = System.getenv("PORT");

			logger.info("0 - " + portNumber);
			// if OS env variable is null or empty, default a default port
			if (portNumber == null)
				portNumber = DEFAULT_PORT;
		} else {
			// if both above conditions is not met, get from the args in the app
			portNumber = (String) optsVal.get(0);
		}

		logger.info("1 - " + optsVal);
		logger.info("2 - " + portNumber);
		// check if the port number is still null or empty
		if (portNumber != null) {
			// override the spring boot app port number using the defaultproperties from
			// spring boot framework
			app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		}
		app.run(args);

		// can also configure in applications.properties with server.port = 8080
	}

}

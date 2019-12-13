package com.example.elk;

import java.util.Random;

import org.apache.log4j.Logger;

public class ELKMain {
	protected static Logger logger = Logger.getLogger(ELKMain.class);

	public static void main(String[] args) {
		// DOMConfigurator is used to configure logger from xml configuration file
		//DOMConfigurator.configure("log4j.xml");
		logger.debug("Started the ELK Application");

		EmployeeService service = new EmployeeService();
		int employeeId = generateEmployeeID();
		service.addEmployee(
				new Employee(new Long(employeeId), "Employee Name " + employeeId, "email" + employeeId + "@test.com"));

		logger.debug("Stopped the ELK Application");
	}

	private static int generateEmployeeID() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}
}
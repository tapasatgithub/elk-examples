package com.example.elk;

import java.util.Random;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class EmployeeServiceTest {
	protected static Logger logger = Logger.getLogger(EmployeeServiceTest.class);
	protected EmployeeService service;

	@Before
	public void setUp() {
		logger.debug("Setup EmployeeServiceTest");
		service = new EmployeeService();
	}

	@Test
	public void addEmployeeTest() {
		logger.debug("Executing addEmployeeTest");
		int employeeId = generateEmployeeID();
		service.addEmployee(
				new Employee(new Long(employeeId), "Employee Name " + employeeId, "email" + employeeId + "@test.com"));
	}

	private static int generateEmployeeID() {
		Random rand = new Random();
		return rand.nextInt(1000);
	}
}

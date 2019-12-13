package com.example.elk;

import org.apache.log4j.Logger;

public class EmployeeService {
	protected static Logger logger = Logger.getLogger(EmployeeService.class);
	private EmployeeDAO employeeDAO;
	
	public EmployeeService() {
		employeeDAO = new EmployeeDAO();
	}
	
	public void addEmployee(Employee employee) {
		LoggerUtil.pushLog(logger, "EmployeeFlow", "Start", employee.getEmpID(), employee.getEmpID(), "AU");
		try {
			employeeDAO.addEmployee(employee);
			LoggerUtil.pushLog(logger, "EmployeeFlow", "End", employee.getEmpID(), employee.getEmpID(), "AU");
		} catch (Exception e) {
			logger.error("Issue in addition of employee: " + e.getMessage());
		}
	}
}

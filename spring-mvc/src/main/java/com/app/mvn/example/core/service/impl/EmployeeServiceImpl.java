package com.app.mvn.example.core.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.mvn.example.core.dao.EmployeeDAO;
import com.app.mvn.example.core.model.Employee;
import com.app.mvn.example.core.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Log logger = LogFactory.getLog(EmployeeServiceImpl.class);
    private EmployeeDAO dao;


	/* (non-Javadoc)
	 * @see com.app.mvn.example.core.service.EmployeeService#getAllEmployees()
	 */
	public List<Employee> getAllEmployees()
    {
		logger.info("getAllEmployees ");
        return dao.getAllEmployees();
    }
	
	 
    @Autowired
    public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

}

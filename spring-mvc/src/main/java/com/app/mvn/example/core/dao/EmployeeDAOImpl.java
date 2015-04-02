package com.app.mvn.example.core.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.mvn.example.core.model.Employee;
import com.app.mvn.example.core.model.User;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	private static final Log logger = LogFactory.getLog(EmployeeDAOImpl.class);
	private JdbcTemplate jdbcTemplate;
	
	public List<Employee> getAllEmployees()
    {
		logger.info("getAllEmployees ");
        List<Employee> employees = new ArrayList<Employee>();
 
        Employee vo1 = new Employee();
        vo1.setId(1);
        vo1.setFirstName("Lokesh");
        vo1.setLastName("Gupta");
        employees.add(vo1);
 
        Employee vo2 = new Employee();
        vo2.setId(2);
        vo2.setFirstName("Raj");
        vo2.setLastName("Kishore");
        employees.add(vo2);
        
        List<User> list = jdbcTemplate.query("select id, name from t1", new RowMapper<User>(){

			public User mapRow(ResultSet rs, int arg1) throws SQLException {
				User u = new User();
				u.setId(rs.getString("id"));
				u.setName(rs.getString("name"));
				return u;
			}
        	
        });
        
        if(null != list)
        {
        	for(User u : list){
        		logger.info(u.toString());
        	}
        }
        
 
        return employees;
    }

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	

}

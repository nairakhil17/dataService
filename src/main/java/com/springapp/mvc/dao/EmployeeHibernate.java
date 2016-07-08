package com.springapp.mvc.dao;

import com.springapp.mvc.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by akhil on 5/7/16.
 */
@Repository("employeeDao")
@Transactional
public class EmployeeHibernate extends GenericDaoHibernate<Employee,Long> {

    public EmployeeHibernate() {
        super(Employee.class);
    }
}

package com.springapp.mvc.service;

import com.jolbox.bonecp.BoneCPDataSource;
import com.springapp.mvc.dao.DepartmentHibernate;
import com.springapp.mvc.dao.EmployeeHibernate;
import com.springapp.mvc.datasource.RoutingDataSource;
import com.springapp.mvc.model.Department;
import com.springapp.mvc.model.Employee;
import org.hibernate.FlushMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by akhil on 1/7/16.
 */
//@WebService(endpointInterface = "com.springapp.mvc.service.MyDataService")
public class MyDataServiceImpl implements MyDataService {

    private HibernateTemplate hibernateTemplate;

    @Autowired
    @Qualifier("employeeDao")
    private EmployeeHibernate employeeHibernate;

    @Autowired
    @Qualifier("departmentDao")
    private DepartmentHibernate departmentHibernate;

    @Autowired
    @Qualifier("dummyDataSource")
    BoneCPDataSource dataSourceDummy;

    @Autowired
    @Qualifier("dummy1DataSource")
    BoneCPDataSource dataSourceDummy1;

    public MyDataServiceImpl(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
    @Override
    public String ping() {
        return "true";
    }

    @Override
    public Employee getEmployeeName(String id,String website) {
        RoutingDataSource.setDataSourceKey(website);
        Employee e = hibernateTemplate.get(Employee.class,Long.valueOf(id));
        return e;
    }

    @Override
    @Transactional(readOnly = false)
    public void saveEmployee(String id, String name, String dno) {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setId(Long.valueOf(id));

        Department department = departmentHibernate.get(Integer.valueOf(dno));
        employee.setDepartment(department);
//        employeeHibernate.getHibernateTemplate().getSessionFactory().getCurrentSession().setFlushMode(FlushMode.AUTO);
        employeeHibernate.save(employee);

        ;
    }


}

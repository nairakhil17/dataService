package com.springapp.mvc.dao;

import com.springapp.mvc.model.Department;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by akhil on 7/7/16.
 */
@Repository("departmentDao")
@Transactional
public class DepartmentHibernate extends GenericDaoHibernate<Department,Integer> {
    public DepartmentHibernate() {
        super(Department.class);
    }
}

package com.springapp.mvc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by akhil on 5/7/16.
 */
@SuppressWarnings({"UnusedDeclaration"})
@Table(name = "employee")
@Entity
@XmlRootElement
public class Employee {

    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @JoinColumn(name = "dept_no",nullable = false)
    @OneToOne(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

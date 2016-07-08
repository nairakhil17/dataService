package com.springapp.mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by akhil on 7/7/16.
 */
@Table(name = "department")
@Entity
@XmlRootElement
public class Department {
    @Id
    private int dno;

    @Column(name = "dname",nullable = false)
    private String dname;

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public int getDno() {
        return dno;
    }

    public void setDno(int dno) {
        this.dno = dno;
    }



}

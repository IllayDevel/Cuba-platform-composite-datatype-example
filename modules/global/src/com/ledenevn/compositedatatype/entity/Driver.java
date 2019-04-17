package com.ledenevn.compositedatatype.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s (%s)|fio,age")
@Table(name = "COMPOSITEDATATYPE_DRIVER")
@Entity(name = "compositedatatype$Driver")
public class Driver extends StandardEntity {
    private static final long serialVersionUID = 253407871990033595L;

    @Column(name = "FIO")
    protected String fio;

    @Column(name = "AGE")
    protected Integer age;

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }


}
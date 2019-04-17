package com.ledenevn.compositedatatype.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;

@NamePattern("%s|fio")
@Table(name = "COMPOSITEDATATYPE_PERSONAL")
@Entity(name = "compositedatatype$Personal")
public class Personal extends StandardEntity {
    private static final long serialVersionUID = -2198844862835642569L;

    @Column(name = "FIO")
    protected String fio;

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }


}
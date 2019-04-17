package com.ledenevn.compositedatatype.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import com.haulmont.chile.core.annotations.MetaProperty;
import com.ledenevn.compositedatatype.CompositeDatatypeConverter;
import javax.persistence.Column;
import javax.persistence.Lob;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.persistence.*;
import com.ledenevn.compositedatatype.CompositeDatatypeContainer;
import com.ledenevn.compositedatatype.CompositeDatatype;

@NamePattern("%s|name")
@Table(name = "COMPOSITEDATATYPE_TEST")
@Entity(name = "compositedatatype$Test")
public class Test extends StandardEntity {
    private static final long serialVersionUID = -4672438247414319884L;

    @Column(name = "NAME")
    protected String name;

    @Lob
    @Column(name = "COMMENT_")
    protected String comment;

    @MetaProperty(datatype = CompositeDatatype.NAME)
    @Column(name = "CD")
    @Convert(converter = CompositeDatatypeConverter.class)
    protected CompositeDatatypeContainer cd;

    public void setCd(CompositeDatatypeContainer cd) {
        this.cd = cd;
    }

    public CompositeDatatypeContainer getCd() {
        return cd;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }


}
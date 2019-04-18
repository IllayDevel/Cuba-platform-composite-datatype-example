package com.ledenevn.compositedatatype.web.test;

import com.haulmont.cuba.core.entity.Entity;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.EntityCombinedScreen;
import com.haulmont.cuba.gui.components.Field;
import com.haulmont.cuba.gui.components.TextArea;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.core.global.LoadContext;
import com.ledenevn.compositedatatype.CompositeDatatypeContainer;
import com.ledenevn.compositedatatype.entity.Driver;
import com.ledenevn.compositedatatype.entity.Personal;
import com.ledenevn.compositedatatype.entity.Test;


import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

public class TestBrowse extends EntityCombinedScreen {

    @Inject
    private Datasource<Test> testDs;
    @Inject
    private TextArea textArea;
    @Inject
    private DataManager dataManager;
    @Named("fieldGroup.cd")
    private Field cd;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
    }


    public void onAcCreateContainerClick() {
        LoadContext<Personal> contextPersonal = LoadContext.create(Personal.class);
        List<Personal> personals = dataManager.loadList(contextPersonal);
        LoadContext<Driver> contextDriver = LoadContext.create(Driver.class);
        List<Driver> drivers = dataManager.loadList(contextDriver);

        CompositeDatatypeContainer container = new CompositeDatatypeContainer();
        container.setByte(Byte.parseByte("10"));
        container.setByte(Byte.parseByte("11"));
        container.setShort(Short.parseShort("1"));
        container.setShort(Short.parseShort("2"));
        container.setInt(Integer.parseInt("45456547"));
        container.setInt(Integer.parseInt("23423423"));
        container.setLong(Long.parseLong("2342342345"));
        container.setLong(Long.parseLong("2342342332"));
        container.setFloat(Float.parseFloat("0.001"));
        container.setFloat(Float.parseFloat("20.001"));
        container.setDouble(Double.parseDouble("10.001"));
        container.setDouble(Double.parseDouble("30.001"));
        container.setChar('a');
        container.setChar('b');
        container.setString("dead");
        container.setString("beef");
        container.setBool(Boolean.parseBoolean("true"));
        container.setBool(Boolean.parseBoolean("false"));
        for (Personal personal: personals) {
            container.setEntity(personal);
        }
        for (Driver driver: drivers) {
            container.setEntity(driver);
        }
        testDs.getItem().setCd(container);
    }

    public void onAcReadContainerClick() {
        String text;
        Integer i;
        CompositeDatatypeContainer container =  testDs.getItem().getCd();
        text = container.getByte(0).toString()+"\r\n";
        text += container.getByte(1).toString()+"\r\n";
        for (Short sh0rt : container.getShorts()) {
            text += sh0rt.toString()+"\r\n";
        }
        text += container.getInt(0).toString()+"\r\n";
        text += container.getInt(1).toString()+"\r\n";
        for (Long l0ng : container.getLongs()) {
            text += l0ng.toString()+"\r\n";
        }
        text += container.getFloat(0).toString()+"\r\n";
        text += container.getFloat(1).toString()+"\r\n";
        for (Double d0uble : container.getDoubles()) {
            text += d0uble.toString()+"\r\n";
        }
        text += container.getChar(0).toString()+"\r\n";
        text += container.getChar(1).toString()+"\r\n";
        for (String string : container.getStrings()) {
            text += string.toString()+"\r\n";
        }
        text += container.getBool(0).toString()+"\r\n";
        text += container.getBool(1).toString()+"\r\n";
        for (Entity entity : container.getEntitys()){
            text += entity.getInstanceName()+"\r\n";
        }

        //has value
        text += "Has values:\r\n";
        text += container.hasByte+"\r\n";
        text += container.hasShort+"\r\n";
        text += container.hasInt+"\r\n";
        text += container.hasLong+"\r\n";
        text += container.hasFloat+"\r\n";
        text += container.hasDouble+"\r\n";
        text += container.hasChar+"\r\n";
        text += container.hasString+"\r\n";
        text += container.hasBool+"\r\n";
        text += container.hasEntity+"\r\n";

        textArea.setValue(text);

    }
}
package com.ledenevn.compositedatatype.web.gui.xml.layout.loaders;

import com.ledenevn.compositedatatype.web.gui.components.CompositeDataField;
import com.haulmont.cuba.gui.xml.layout.loaders.AbstractComponentLoader;

public class CompositeDataFieldLoader extends AbstractComponentLoader<CompositeDataField> {
    @Override
    public void createComponent() {
        resultComponent = factory.createComponent(CompositeDataField.class);
        loadId(resultComponent, element);
    }

    @Override
    public void loadComponent() {
    }
}

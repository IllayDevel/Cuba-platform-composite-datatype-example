package com.ledenevn.compositedatatype.web.gui.components;

import com.haulmont.cuba.web.gui.components.WebAbstractComponent;

public class WebCompositeDataField extends WebAbstractComponent<com.ledenevn.compositedatatype.web.toolkit.ui.CompositeDataField> implements CompositeDataField {
    public WebCompositeDataField() {
        this.component = new com.ledenevn.compositedatatype.web.toolkit.ui.CompositeDataField();
    }
}
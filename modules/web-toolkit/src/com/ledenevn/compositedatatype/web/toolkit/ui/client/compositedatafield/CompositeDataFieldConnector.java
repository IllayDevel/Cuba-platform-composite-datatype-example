package com.ledenevn.compositedatatype.web.toolkit.ui.client.compositedatafield;

import com.ledenevn.compositedatatype.web.toolkit.ui.CompositeDataField;
import com.vaadin.client.ui.AbstractFieldConnector;
import com.vaadin.shared.ui.Connect;

@Connect(CompositeDataField.class)
public class CompositeDataFieldConnector extends AbstractFieldConnector {
    @Override
    public CompositeDataFieldState getState() {
        return (CompositeDataFieldState) super.getState();
    }

    @Override
    public CompositeDataFieldWidget getWidget() {
        return (CompositeDataFieldWidget) super.getWidget();
    }
}

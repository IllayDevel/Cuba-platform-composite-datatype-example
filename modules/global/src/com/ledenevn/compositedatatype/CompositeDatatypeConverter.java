package com.ledenevn.compositedatatype;

/**
 * Created by Ledenev N.K. on 15.04.2019.
 */

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.google.gson.Gson;
import com.haulmont.cuba.core.sys.MetadataLoader;


@Converter
public class CompositeDatatypeConverter extends MetadataLoader implements AttributeConverter<CompositeDatatypeContainer, String> {

    @Override
    public String convertToDatabaseColumn(CompositeDatatypeContainer Attribute) {
        if (Attribute == null)
            Attribute = new CompositeDatatypeContainer();
        return Attribute.toString();
    }

    @Override
    public CompositeDatatypeContainer convertToEntityAttribute(String value) {
        return new Gson().fromJson(value, CompositeDatatypeContainer.class);
    }

}

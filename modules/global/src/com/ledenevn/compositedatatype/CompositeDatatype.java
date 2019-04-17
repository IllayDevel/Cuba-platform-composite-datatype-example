package com.ledenevn.compositedatatype;

/**
 * Created by Ledenev N.K. on 16.04.2019.
 */

import com.haulmont.chile.core.annotations.JavaClass;
import com.haulmont.chile.core.datatypes.Datatype;

import java.text.ParseException;
import java.util.Locale;

@JavaClass(CompositeDatatypeContainer.class)
public class CompositeDatatype implements Datatype<CompositeDatatypeContainer> {

        @Override
        public String format(Object value) {
            if (value == null)
                return "";
            return ((CompositeDatatypeContainer) value).getName();
        }

        @Override
        public String format(Object value, Locale locale) {
            return format(value);
        }

        @Override
        public CompositeDatatypeContainer parse(String value) {
            return new CompositeDatatypeContainer();
        }

        @Override
        public CompositeDatatypeContainer parse(String value, Locale locale) throws ParseException {
            return new CompositeDatatypeContainer();
        }

        @Override
        public String toString() {
            return getClass().getSimpleName();
        }

        @Deprecated
        public final static String NAME = "CompositeDatatype";

}

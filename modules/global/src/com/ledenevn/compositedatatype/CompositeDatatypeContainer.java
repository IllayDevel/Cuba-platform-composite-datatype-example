package com.ledenevn.compositedatatype;
/**
 * Created by Ledenev N.K. on 15.04.2019.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.haulmont.chile.core.model.MetaClass;
import com.haulmont.cuba.core.entity.Entity;

import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import com.haulmont.cuba.core.global.*;

public class CompositeDatatypeContainer implements Serializable {

    private static Integer nameLength = 255;
    private static String nameDelimiter = "; ";

    private Collection<Byte> ofByte = new ArrayList<>();
    private Collection<Short> ofShort = new ArrayList<>();
    private Collection<Integer> ofInt = new ArrayList<>();
    private Collection<Long> ofLong = new ArrayList<>();
    private Collection<Float> ofFloat = new ArrayList<>();
    private Collection<Double> ofDouble = new ArrayList<>();
    private Collection<Character> ofChar = new ArrayList<>();
    private Collection<String> ofString = new ArrayList<>();
    private Collection<Boolean> ofBool = new ArrayList<>();
    private Collection<String> ofEntity = new ArrayList<>();

    public Boolean hasByte = false;
    public Boolean hasShort = false;
    public Boolean hasInt = false;
    public Boolean hasLong = false;
    public Boolean hasFloat = false;
    public Boolean hasDouble = false;
    public Boolean hasChar = false;
    public Boolean hasString = false;
    public Boolean hasBool = false;
    public Boolean hasEntity = false;

    //byte
    public void setByte(Byte value){
        ofByte.add(value);
        hasByte = true;
    }

    public Collection<Byte> getBytes()
    {
        return ofByte;
    }

    public Byte getByte(Integer index) {
        return (Byte) (ofByte.toArray())[index];
    }

    //Short
    public void setShort(Short value){
        ofShort.add(value);
        hasShort = true;
    }

    public Collection<Short> getShorts()
    {
        return ofShort;
    }

    public Short getShort(Integer index) {
        return (Short) (ofShort.toArray())[index];
    }

    //Int
    public void setInt(Integer value){
        ofInt.add(value);
        hasInt = true;
    }

    public Collection<Integer> getInts()
    {
        return ofInt;
    }

    public Integer getInt(Integer index) {
        return (Integer) (ofInt.toArray())[index];
    }

    //Long
    public void setLong(Long value){
        ofLong.add(value);
        hasLong = true;
    }

    public Collection<Long> getLongs()
    {
        return ofLong;
    }

    public Long getLong(Integer index) {
        return (Long) (ofLong.toArray())[index];
    }

    //Float
    public void setFloat(Float value){
        ofFloat.add(value);
        hasFloat = true;
    }

    public Collection<Float> getFloats()
    {
        return ofFloat;
    }

    public Float getFloat(Integer index) {
        return (Float) (ofFloat.toArray())[index];
    }

    //Double
    public void setDouble(Double value){
        ofDouble.add(value);
        hasDouble = true;
    }

    public Collection<Double> getDoubles()
    {
        return ofDouble;
    }

    public Double getDouble(Integer index) {
        return (Double) (ofDouble.toArray())[index];
    }

    //Char
    public void setChar(Character value){
        ofChar.add(value);
        hasChar = true;
    }

    public Collection<Character> getChars()
    {
        return ofChar;
    }

    public Character getChar(Integer index) {
        return (Character) (ofChar.toArray())[index];
    }

    //String
    public void setString(String value){
        ofString.add(value);
        hasString = true;
    }

    public Collection<String> getStrings()
    {
        return ofString;
    }

    public String getString(Integer index) {
        return (String) (ofString.toArray())[index];
    }

    //Bool
    public void setBool(Boolean value){
        ofBool.add(value);
        hasBool = true;
    }

    public Collection<Boolean> getBools()
    {
        return ofBool;
    }

    public Boolean getBool(Integer index) {
        return (Boolean) (ofBool.toArray())[index];
    }

    //Entity !hand made
    public void setEntity(Entity value){
        if (value == null)
             return;
        EntityLoadInfoBuilder builder = getEntityLoadInfoBuilder();
        EntityLoadInfo entityLoadInfo = builder.create(value);
        ofEntity.add(entityLoadInfo.toString());
        hasEntity = true;
    }

    public Collection<Entity> getEntitys()
    {
        Collection<Entity> entities = new ArrayList<>();
        for (String entity : ofEntity) {
            EntityLoadInfoBuilder builder = getEntityLoadInfoBuilder();
            EntityLoadInfo entityLoadInfo = builder.parse(entity);
            if (entityLoadInfo != null) {
                entities.add(loadEntity(entityLoadInfo));
            }
        }
        return entities;
    }

    public Entity getEntity(Integer index) {
        if (Strings.isNullOrEmpty((String)(ofEntity.toArray())[index]))
            return null;
        EntityLoadInfoBuilder builder = getEntityLoadInfoBuilder();
        EntityLoadInfo entityLoadInfo = builder.parse((String)(ofEntity.toArray())[index]);
        Entity entity = null;
        if (entityLoadInfo != null) {
            entity = loadEntity(entityLoadInfo);
        }
        return entity;
    }

    //Thanks Mario David
    private EntityLoadInfoBuilder getEntityLoadInfoBuilder() {
        return AppBeans.get(EntityLoadInfoBuilder.NAME);
    }

    private Entity loadEntity(EntityLoadInfo entityLoadInfo) {
        DataManager dataManager = getDataManager();
        return dataManager.load(getLoadContextForForEntityLoadInfo(entityLoadInfo.getMetaClass(), entityLoadInfo.getId()));
    }

    private DataManager getDataManager() {
        return AppBeans.get(DataManager.NAME);
    }

    protected LoadContext getLoadContextForForEntityLoadInfo(MetaClass metaClass, Object entityId) {
        LoadContext loadContext = LoadContext.create(metaClass.getJavaClass());
        loadContext.setId(entityId);
        return loadContext;
    }

    private String truncateName(String name) {
        return name.length()>=nameLength?name.substring(0, nameLength)+"...":name;
    }

    public String getName() {
        String name = "";
        if (hasByte) {
            for (Byte b: getBytes()) {
                if (name.length()<nameLength) {
                    name += b.toString()+nameDelimiter;
                } else {
                    return truncateName(name);
                }
            }
        }
        if (hasShort) {
            for (Short s: getShorts()) {
                if (name.length()<nameLength) {
                    name += s.toString()+nameDelimiter;
                } else {
                    return truncateName(name);
                }
            }
        }
        if (hasInt) {
            for (Integer i: getInts()) {
                if (name.length()<nameLength) {
                    name += i.toString()+nameDelimiter;
                } else {
                    return truncateName(name);
                }
            }
        }
        if (hasLong) {
            for (Long l: getLongs()) {
                if (name.length()<nameLength) {
                    name += l.toString()+nameDelimiter;
                } else {
                    return truncateName(name);
                }
            }
        }
        if (hasFloat) {
            for (Float f: getFloats()) {
                if (name.length()<nameLength) {
                    name += f.toString()+nameDelimiter;
                } else {
                    return truncateName(name);
                }
            }
        }
        if (hasDouble) {
            for (Double d: getDoubles()) {
                if (name.length()<nameLength) {
                    name += d.toString()+nameDelimiter;
                } else {
                    return truncateName(name);
                }
            }
        }
        if (hasChar) {
            for (Character c: getChars()) {
                if (name.length()<nameLength) {
                    name += Character.toString(c)+nameDelimiter;
                } else {
                    return truncateName(name);
                }
            }
        }
        if (hasString) {
            for (String s: getStrings()) {
                if (name.length()<nameLength) {
                    name += s+nameDelimiter;
                } else {
                    return truncateName(name);
                }
            }
        }
        if (hasBool) {
            for (Boolean b: getBools()) {
                if (name.length()<nameLength) {
                    name += b+nameDelimiter;
                } else {
                    return truncateName(name);
                }
            }
        }
        if (hasEntity) {
            for (Entity e: getEntitys()) {
                if (name.length()<nameLength) {
                    name += e.getInstanceName()+nameDelimiter;
                } else {
                    return truncateName(name);
                }
            }
        }
        return truncateName(name);
    }

    public String getSimpleName() {
        return getName();
    }

    public String toString() {
        Gson gson = new GsonBuilder().serializeNulls().disableInnerClassSerialization().create();
        return gson.toJson(this);
    }

}

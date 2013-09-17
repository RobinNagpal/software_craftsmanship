package com.cleanCode.domain;

import java.io.Serializable;

public class Country {



    public long getPrimaryKey() {
        return _countryId;
    }

    public void setPrimaryKey(long pk) {
        setCountryId(pk);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_countryId);
    }

    public long getCountryId() {
        return _countryId;
    }

    public void setCountryId(long countryId) {
        _countryId = countryId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;

        if (_originalName == null) {
            _originalName = name;
        }
    }

    public String getOriginalName() {
        return _originalName;
    }

    public String getA2() {
        return _a2;
    }

    public void setA2(String a2) {
        _a2 = a2;

        if (_originalA2 == null) {
            _originalA2 = a2;
        }
    }

    public String getOriginalA2() {
        return _originalA2;
    }

    public String getA3() {
        return _a3;
    }

    public void setA3(String a3) {
        _a3 = a3;

        if (_originalA3 == null) {
            _originalA3 = a3;
        }
    }

    public String getOriginalA3() {
        return _originalA3;
    }

    public String getNumber() {
        return _number;
    }

    public void setNumber(String number) {
        _number = number;
    }

    public String getIdd() {
        return _idd;
    }

    public void setIdd(String idd) {
        _idd = idd;
    }

    public boolean getActive() {
        return _active;
    }

    public boolean isActive() {
        return _active;
    }

    public void setActive(boolean active) {
        _active = active;
    }



    public int compareTo(Country country) {
        int value = 0;

        value = getName().compareTo(country.getName());

        if (value != 0) {
            return value;
        }

        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Country country = null;

        try {
            country = (Country)obj;
        }
        catch (ClassCastException cce) {
            return false;
        }

        long pk = country.getPrimaryKey();

        if (getPrimaryKey() == pk) {
            return true;
        }
        else {
            return false;
        }
    }

    public int hashCode() {
        return (int)getPrimaryKey();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("{countryId=");
        sb.append(getCountryId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", a2=");
        sb.append(getA2());
        sb.append(", a3=");
        sb.append(getA3());
        sb.append(", number=");
        sb.append(getNumber());
        sb.append(", idd=");
        sb.append(getIdd());
        sb.append(", active=");
        sb.append(getActive());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBuilder sb = new StringBuilder();

        sb.append("<model><model-name>");
        sb.append("com.liferay.portal.model.Country");
        sb.append("</model-name>");

        sb.append(
                "<column><column-name>countryId</column-name><column-value><![CDATA[");
        sb.append("getCountryId()");
        sb.append("]]></column-value></column>");
        sb.append(
                "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append("getName()");
        sb.append("]]></column-value></column>");
        sb.append(
                "<column><column-name>a2</column-name><column-value><![CDATA[");
        sb.append("getA2()");
        sb.append("]]></column-value></column>");
        sb.append(
                "<column><column-name>a3</column-name><column-value><![CDATA[");
        sb.append("getA3()");
        sb.append("]]></column-value></column>");
        sb.append(
                "<column><column-name>number</column-name><column-value><![CDATA[");
        sb.append("getNumber()");
        sb.append("]]></column-value></column>");
        sb.append(
                "<column><column-name>idd</column-name><column-value><![CDATA[");
        sb.append("getIdd()");
        sb.append("]]></column-value></column>");
        sb.append(
                "<column><column-name>active</column-name><column-value><![CDATA[");
        sb.append("getActive()");
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }

    private long _countryId;
    private String _name;
    private String _originalName;
    private String _a2;
    private String _originalA2;
    private String _a3;
    private String _originalA3;
    private String _number;
    private String _idd;
    private boolean _active;
}

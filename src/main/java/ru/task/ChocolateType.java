//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.30 at 03:05:36 PM MSK 
//


package ru.task;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for chocolateType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="chocolateType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Milk"/>
 *     &lt;enumeration value="White"/>
 *     &lt;enumeration value="Classic"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "chocolateType", namespace = "http://www.ingredients.ru")
@XmlEnum
public enum ChocolateType {

    @XmlEnumValue("Milk")
    MILK("Milk"),
    @XmlEnumValue("White")
    WHITE("White"),
    @XmlEnumValue("Classic")
    CLASSIC("Classic");
    private final String value;

    ChocolateType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChocolateType fromValue(String v) {
        for (ChocolateType c: ChocolateType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

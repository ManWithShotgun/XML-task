//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.11.30 at 03:05:36 PM MSK 
//


package ru.task;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for propType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="propType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="proteins" type="{http://www.candy.ru}grType"/>
 *         &lt;element name="fats" type="{http://www.candy.ru}grType"/>
 *         &lt;element name="carbohydrate" type="{http://www.candy.ru}grType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "propType", propOrder = {
    "proteins",
    "fats",
    "carbohydrate"
})
public class PropType {

    protected int proteins;
    protected int fats;
    protected int carbohydrate;

    /**
     * Gets the value of the proteins property.
     * 
     */
    public int getProteins() {
        return proteins;
    }

    /**
     * Sets the value of the proteins property.
     * 
     */
    public void setProteins(int value) {
        this.proteins = value;
    }

    /**
     * Gets the value of the fats property.
     * 
     */
    public int getFats() {
        return fats;
    }

    /**
     * Sets the value of the fats property.
     * 
     */
    public void setFats(int value) {
        this.fats = value;
    }

    /**
     * Gets the value of the carbohydrate property.
     * 
     */
    public int getCarbohydrate() {
        return carbohydrate;
    }

    /**
     * Sets the value of the carbohydrate property.
     * 
     */
    public void setCarbohydrate(int value) {
        this.carbohydrate = value;
    }

}

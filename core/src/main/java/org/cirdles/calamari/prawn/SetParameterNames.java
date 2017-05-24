/*
 * Copyright 2015 CIRDLES.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 * This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
 * See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
 * Any modifications to this file will be lost upon recompilation of the source schema. 
 * Generated on: 2015.10.25 at 07:31:08 AM EDT 
 */
package org.cirdles.calamari.prawn;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for SetParameterNames.
 *
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * <p>
 * <
 * pre>
 * &lt;simpleType name="SetParameterNames"&gt; &lt;restriction
 * base="{http://www.w3.org/2001/XMLSchema}string"&gt; &lt;enumeration
 * value="date"/&gt; &lt;enumeration value="time"/&gt; &lt;enumeration
 * value="qt1y"/&gt; &lt;enumeration value="qt1y_volts"/&gt; &lt;enumeration
 * value="qt1z"/&gt; &lt;enumeration value="egy"/&gt; &lt;enumeration
 * value="egz"/&gt; &lt;enumeration value="prealphay"/&gt; &lt;enumeration
 * value="pbm"/&gt; &lt;enumeration value="eisie_cps"/&gt; &lt;enumeration
 * value="eisie_date_time"/&gt; &lt;/restriction&gt; &lt;/simpleType&gt;
 * </pre>
 *
 */
@XmlType(name = "SetParameterNames")
@XmlEnum
public enum SetParameterNames implements Serializable {

    /**
     *
     */
    @XmlEnumValue("date")
    DATE("date"),
    /**
     *
     */
    @XmlEnumValue("time")
    TIME("time"),
    /**
     *
     */
    @XmlEnumValue("qt1y")
    QT_1_Y("qt1y"),
    /**
     *
     */
    @XmlEnumValue("qt1y_volts")
    QT_1_Y_VOLTS("qt1y_volts"),
    /**
     *
     */
    @XmlEnumValue("qt1z")
    QT_1_Z("qt1z"),
    /**
     *
     */
    @XmlEnumValue("egy")
    EGY("egy"),
    /**
     *
     */
    @XmlEnumValue("egz")
    EGZ("egz"),
    /**
     *
     */
    @XmlEnumValue("egkY")
    egkY("egkY"),
    /**
     *
     */
    @XmlEnumValue("egkZ")
    egkZ("egkZ"),
    /**
     *
     */
    @XmlEnumValue("egcY")
    egcY("egcY"),
    /**
     *
     */
    @XmlEnumValue("egcZ")
    egcZ("egcZ"),
    /**
     *
     */
    @XmlEnumValue("prealphay")
    PREALPHAY("prealphay"),
    /**
     *
     */
    @XmlEnumValue("pbm")
    PBM("pbm"),
    /**
     *
     */
    @XmlEnumValue("eisie_cps")
    EISIE_CPS("eisie_cps"),
    /**
     *
     */
    @XmlEnumValue("eisie_date_time")
    EISIE_DATE_TIME("eisie_date_time"),
    /**
     *
     */
    @XmlEnumValue("lab_temperature_degc")
    lab_temperature_degc("lab_temperature_degc");

    private final String value;

    SetParameterNames(String v) {
        value = v;
    }

    /**
     *
     * @return
     */
    public String value() {
        return value;
    }

    /**
     *
     * @param v
     * @return
     */
    public static SetParameterNames fromValue(String v) {
        for (SetParameterNames c : SetParameterNames.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

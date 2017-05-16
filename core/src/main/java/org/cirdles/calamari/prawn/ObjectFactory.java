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

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the shrimp package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: shrimp
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PrawnFile }
     * 
     * @return 
     */
    public PrawnFile createPrawnFile() {
        return new PrawnFile();
    }

    /**
     * Create an instance of {@link PrawnFile.Run }
     * 
     * @return 
     */
    public PrawnFile.Run createPrawnFileRun() {
        return new PrawnFile.Run();
    }

    /**
     * Create an instance of {@link PrawnFile.Run.Set }
     * 
     * @return 
     */
    public PrawnFile.Run.Set createPrawnFileRunSet() {
        return new PrawnFile.Run.Set();
    }

    /**
     * Create an instance of {@link PrawnFile.Run.Set.Scan }
     * 
     * @return 
     */
    public PrawnFile.Run.Set.Scan createPrawnFileRunSetScan() {
        return new PrawnFile.Run.Set.Scan();
    }

    /**
     * Create an instance of {@link PrawnFile.Run.Set.Scan.Measurement }
     * 
     * @return 
     */
    public PrawnFile.Run.Set.Scan.Measurement createPrawnFileRunSetScanMeasurement() {
        return new PrawnFile.Run.Set.Scan.Measurement();
    }

    /**
     * Create an instance of {@link PrawnFile.Run.RunTable }
     * 
     * @return 
     */
    public PrawnFile.Run.RunTable createPrawnFileRunRunTable() {
        return new PrawnFile.Run.RunTable();
    }

    /**
     * Create an instance of {@link PrawnFile.Run.RunTable.Entry }
     * 
     * @return 
     */
    public PrawnFile.Run.RunTable.Entry createPrawnFileRunRunTableEntry() {
        return new PrawnFile.Run.RunTable.Entry();
    }

    /**
     * Create an instance of {@link PrawnFile.Run.Par }
     * 
     * @return 
     */
    public PrawnFile.Run.Par createPrawnFileRunPar() {
        return new PrawnFile.Run.Par();
    }

    /**
     * Create an instance of {@link PrawnFile.Run.Set.Par }
     * 
     * @return 
     */
    public PrawnFile.Run.Set.Par createPrawnFileRunSetPar() {
        return new PrawnFile.Run.Set.Par();
    }

    /**
     * Create an instance of {@link PrawnFile.Run.Set.Scan.Measurement.Par }
     * 
     * @return 
     */
    public PrawnFile.Run.Set.Scan.Measurement.Par createPrawnFileRunSetScanMeasurementPar() {
        return new PrawnFile.Run.Set.Scan.Measurement.Par();
    }

    /**
     * Create an instance of {@link PrawnFile.Run.Set.Scan.Measurement.Data }
     * 
     * @return 
     */
    public PrawnFile.Run.Set.Scan.Measurement.Data createPrawnFileRunSetScanMeasurementData() {
        return new PrawnFile.Run.Set.Scan.Measurement.Data();
    }

    /**
     * Create an instance of {@link PrawnFile.Run.RunTable.Entry.Par }
     * 
     * @return 
     */
    public PrawnFile.Run.RunTable.Entry.Par createPrawnFileRunRunTableEntryPar() {
        return new PrawnFile.Run.RunTable.Entry.Par();
    }

}

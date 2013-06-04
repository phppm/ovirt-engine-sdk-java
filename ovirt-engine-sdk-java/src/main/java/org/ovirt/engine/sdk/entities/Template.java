//
// Copyright (c) 2012 Red Hat, Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//           http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

// *********************************************************************
// ********************* GENERATED CODE - DO NOT MODIFY ****************
// *********************************************************************


package org.ovirt.engine.sdk.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Template complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Template">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResource">
 *       &lt;sequence>
 *         &lt;element ref="{}vm" minOccurs="0"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}status" minOccurs="0"/>
 *         &lt;element name="memory" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="cpu" type="{}CPU" minOccurs="0"/>
 *         &lt;element name="os" type="{}OperatingSystem" minOccurs="0"/>
 *         &lt;element ref="{}cluster" minOccurs="0"/>
 *         &lt;element ref="{}storage_domain" minOccurs="0"/>
 *         &lt;element name="creation_time" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="origin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="high_availability" type="{}HighAvailability" minOccurs="0"/>
 *         &lt;element name="display" type="{}Display" minOccurs="0"/>
 *         &lt;element name="stateless" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="delete_protected" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="timezone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element ref="{}domain" minOccurs="0"/>
 *         &lt;element ref="{}usb" minOccurs="0"/>
 *         &lt;element name="tunnel_migration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Template", propOrder = {
    "vm",
    "type",
    "status",
    "memory",
    "cpu",
    "os",
    "cluster",
    "storageDomain",
    "creationTime",
    "origin",
    "highAvailability",
    "display",
    "stateless",
    "deleteProtected",
    "timezone",
    "domain",
    "usb",
    "tunnelMigration"
})
public class Template
    extends BaseResource
{

    protected VM vm;
    protected String type;
    protected Status status;
    protected Long memory;
    protected CPU cpu;
    protected OperatingSystem os;
    protected Cluster cluster;
    @XmlElement(name = "storage_domain")
    protected StorageDomain storageDomain;
    @XmlElement(name = "creation_time")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar creationTime;
    protected String origin;
    @XmlElement(name = "high_availability")
    protected HighAvailability highAvailability;
    protected Display display;
    protected Boolean stateless;
    @XmlElement(name = "delete_protected")
    protected Boolean deleteProtected;
    protected String timezone;
    protected Domain domain;
    protected Usb usb;
    @XmlElement(name = "tunnel_migration")
    protected Boolean tunnelMigration;

    /**
     * Gets the value of the vm property.
     * 
     * @return
     *     possible object is
     *     {@link VM }
     *     
     */
    public VM getVm() {
        return vm;
    }

    /**
     * Sets the value of the vm property.
     * 
     * @param value
     *     allowed object is
     *     {@link VM }
     *     
     */
    public void setVm(VM value) {
        this.vm = value;
    }

    public boolean isSetVm() {
        return (this.vm!= null);
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    public boolean isSetType() {
        return (this.type!= null);
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    public void setStatus(Status value) {
        this.status = value;
    }

    public boolean isSetStatus() {
        return (this.status!= null);
    }

    /**
     * Gets the value of the memory property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMemory() {
        return memory;
    }

    /**
     * Sets the value of the memory property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMemory(Long value) {
        this.memory = value;
    }

    public boolean isSetMemory() {
        return (this.memory!= null);
    }

    /**
     * Gets the value of the cpu property.
     * 
     * @return
     *     possible object is
     *     {@link CPU }
     *     
     */
    public CPU getCpu() {
        return cpu;
    }

    /**
     * Sets the value of the cpu property.
     * 
     * @param value
     *     allowed object is
     *     {@link CPU }
     *     
     */
    public void setCpu(CPU value) {
        this.cpu = value;
    }

    public boolean isSetCpu() {
        return (this.cpu!= null);
    }

    /**
     * Gets the value of the os property.
     * 
     * @return
     *     possible object is
     *     {@link OperatingSystem }
     *     
     */
    public OperatingSystem getOs() {
        return os;
    }

    /**
     * Sets the value of the os property.
     * 
     * @param value
     *     allowed object is
     *     {@link OperatingSystem }
     *     
     */
    public void setOs(OperatingSystem value) {
        this.os = value;
    }

    public boolean isSetOs() {
        return (this.os!= null);
    }

    /**
     * Gets the value of the cluster property.
     * 
     * @return
     *     possible object is
     *     {@link Cluster }
     *     
     */
    public Cluster getCluster() {
        return cluster;
    }

    /**
     * Sets the value of the cluster property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cluster }
     *     
     */
    public void setCluster(Cluster value) {
        this.cluster = value;
    }

    public boolean isSetCluster() {
        return (this.cluster!= null);
    }

    /**
     * Gets the value of the storageDomain property.
     * 
     * @return
     *     possible object is
     *     {@link StorageDomain }
     *     
     */
    public StorageDomain getStorageDomain() {
        return storageDomain;
    }

    /**
     * Sets the value of the storageDomain property.
     * 
     * @param value
     *     allowed object is
     *     {@link StorageDomain }
     *     
     */
    public void setStorageDomain(StorageDomain value) {
        this.storageDomain = value;
    }

    public boolean isSetStorageDomain() {
        return (this.storageDomain!= null);
    }

    /**
     * Gets the value of the creationTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCreationTime() {
        return creationTime;
    }

    /**
     * Sets the value of the creationTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setCreationTime(XMLGregorianCalendar value) {
        this.creationTime = value;
    }

    public boolean isSetCreationTime() {
        return (this.creationTime!= null);
    }

    /**
     * Gets the value of the origin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the value of the origin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigin(String value) {
        this.origin = value;
    }

    public boolean isSetOrigin() {
        return (this.origin!= null);
    }

    /**
     * Gets the value of the highAvailability property.
     * 
     * @return
     *     possible object is
     *     {@link HighAvailability }
     *     
     */
    public HighAvailability getHighAvailability() {
        return highAvailability;
    }

    /**
     * Sets the value of the highAvailability property.
     * 
     * @param value
     *     allowed object is
     *     {@link HighAvailability }
     *     
     */
    public void setHighAvailability(HighAvailability value) {
        this.highAvailability = value;
    }

    public boolean isSetHighAvailability() {
        return (this.highAvailability!= null);
    }

    /**
     * Gets the value of the display property.
     * 
     * @return
     *     possible object is
     *     {@link Display }
     *     
     */
    public Display getDisplay() {
        return display;
    }

    /**
     * Sets the value of the display property.
     * 
     * @param value
     *     allowed object is
     *     {@link Display }
     *     
     */
    public void setDisplay(Display value) {
        this.display = value;
    }

    public boolean isSetDisplay() {
        return (this.display!= null);
    }

    /**
     * Gets the value of the stateless property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getStateless() {
        return stateless;
    }

    /**
     * Sets the value of the stateless property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStateless(Boolean value) {
        this.stateless = value;
    }

    public boolean isSetStateless() {
        return (this.stateless!= null);
    }

    /**
     * Gets the value of the deleteProtected property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getDeleteProtected() {
        return deleteProtected;
    }

    /**
     * Sets the value of the deleteProtected property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDeleteProtected(Boolean value) {
        this.deleteProtected = value;
    }

    public boolean isSetDeleteProtected() {
        return (this.deleteProtected!= null);
    }

    /**
     * Gets the value of the timezone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Sets the value of the timezone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTimezone(String value) {
        this.timezone = value;
    }

    public boolean isSetTimezone() {
        return (this.timezone!= null);
    }

    /**
     * Gets the value of the domain property.
     * 
     * @return
     *     possible object is
     *     {@link Domain }
     *     
     */
    public Domain getDomain() {
        return domain;
    }

    /**
     * Sets the value of the domain property.
     * 
     * @param value
     *     allowed object is
     *     {@link Domain }
     *     
     */
    public void setDomain(Domain value) {
        this.domain = value;
    }

    public boolean isSetDomain() {
        return (this.domain!= null);
    }

    /**
     * Gets the value of the usb property.
     * 
     * @return
     *     possible object is
     *     {@link Usb }
     *     
     */
    public Usb getUsb() {
        return usb;
    }

    /**
     * Sets the value of the usb property.
     * 
     * @param value
     *     allowed object is
     *     {@link Usb }
     *     
     */
    public void setUsb(Usb value) {
        this.usb = value;
    }

    public boolean isSetUsb() {
        return (this.usb!= null);
    }

    /**
     * Gets the value of the tunnelMigration property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean getTunnelMigration() {
        return tunnelMigration;
    }

    /**
     * Sets the value of the tunnelMigration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setTunnelMigration(Boolean value) {
        this.tunnelMigration = value;
    }

    public boolean isSetTunnelMigration() {
        return (this.tunnelMigration!= null);
    }

}

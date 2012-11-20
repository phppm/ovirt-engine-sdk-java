
package org.ovirt.engine.sdk.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BaseResources complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BaseResources">
 *   &lt;complexContent>
 *     &lt;extension base="{}ActionableResource">
 *       &lt;sequence>
 *         &lt;element name="total" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *         &lt;element name="active" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseResources", propOrder = {
    "total",
    "active"
})
@XmlSeeAlso({
    Domains.class,
    HostStorage.class,
    HostNics.class,
    Groups.class,
    StorageDomains.class,
    Roles.class,
    Events.class,
    GlusterBricks.class,
    Snapshots.class,
    Tags.class,
    Files.class,
    Quotas.class,
    GlusterVolumes.class,
    Users.class,
    IPs.class,
    DataCenters.class,
    Hosts.class,
    Permissions.class,
    VMs.class,
    Networks.class,
    PreviewVMs.class,
    Templates.class,
    Clusters.class,
    Permits.class,
    Statistics.class,
    VmPools.class,
    BaseDevices.class
})
public class BaseResources
    extends ActionableResource
{

    @XmlSchemaType(name = "unsignedInt")
    protected Long total;
    @XmlSchemaType(name = "unsignedInt")
    protected Long active;

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotal(Long value) {
        this.total = value;
    }

    public boolean isSetTotal() {
        return (this.total!= null);
    }

    /**
     * Gets the value of the active property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getActive() {
        return active;
    }

    /**
     * Sets the value of the active property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setActive(Long value) {
        this.active = value;
    }

    public boolean isSetActive() {
        return (this.active!= null);
    }

}

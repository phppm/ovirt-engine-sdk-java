
package org.ovirt.engine.sdk.entities;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Permits complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Permits">
 *   &lt;complexContent>
 *     &lt;extension base="{}BaseResources">
 *       &lt;sequence>
 *         &lt;element name="permit" type="{}Permit" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Permits", propOrder = {
    "permits"
})
public class Permits
    extends BaseResources
{

    @XmlElement(name = "permit", required = true)
    protected List<Permit> permits;

    /**
     * Gets the value of the permits property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the permits property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPermits().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Permit }
     * 
     * 
     */
    public List<Permit> getPermits() {
        if (permits == null) {
            permits = new ArrayList<Permit>();
        }
        return this.permits;
    }

    public boolean isSetPermits() {
        return ((this.permits!= null)&&(!this.permits.isEmpty()));
    }

    public void unsetPermits() {
        this.permits = null;
    }

}

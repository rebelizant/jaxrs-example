package io.github.rebelizant.jaxrsexample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@XmlRootElement
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Customer extends AbstractEntity {

    private String firstName;

    private String lastName;

    private Address address;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

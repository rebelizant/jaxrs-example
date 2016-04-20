package io.github.rebelizant.jaxrsexample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Address {

    private String street;

    private String city;

    private String state;

    private String zip;

    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}

package io.github.rebelizant.jaxrsexample.domain;

/**
 * @author rebelizant
 *         Created on 18.04.16
 */
public abstract class AbstractEntity {

    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

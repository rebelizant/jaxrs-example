package io.github.rebelizant.jaxrsexample.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author rebelizant
 *         Created on 08.05.16
 */
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorMessage {

    private String message;

    private int code;

    private String documentation;

    public ErrorMessage(String message, int code, String documentation) {
        this.message = message;
        this.code = code;
        this.documentation = documentation;
    }

    public ErrorMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDocumentation() {
        return documentation;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }
}

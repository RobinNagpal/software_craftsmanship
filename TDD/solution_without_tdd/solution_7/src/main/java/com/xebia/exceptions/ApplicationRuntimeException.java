package com.xebia.exceptions;

/**
 * Created with IntelliJ IDEA.
 * User: robin
 * Date: 19/6/13
 * Time: 4:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class ApplicationRuntimeException  extends  RuntimeException{
    private  String message;

    public ApplicationRuntimeException(String message) {
        super(message);
        this.message=message;
    }

    public String getMessage() {
        return message;
    }
}

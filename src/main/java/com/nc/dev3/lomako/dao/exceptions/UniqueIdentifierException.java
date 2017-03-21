package com.nc.dev3.lomako.dao.exceptions;

/**
 * Created by arturlomako on 3/19/17.
 */
public final class UniqueIdentifierException extends Exception {

    public UniqueIdentifierException() {
        super("Entity with some unique identifier already exists");
    }

    public UniqueIdentifierException(String message) {
        super(message);
    }

}

package com.nc.dev3.lomako.dao.exceptions;

/**
 * Created by arturlomako on 3/19/17.
 */
public final class NoFindEntityException extends Exception {
    public NoFindEntityException() {
        super("Entity doesn't exists");
    }

    public NoFindEntityException(String message) {
        super(message);
    }
}

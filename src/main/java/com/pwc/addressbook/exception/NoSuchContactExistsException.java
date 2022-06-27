package com.pwc.addressbook.exception;

public class NoSuchContactExistsException extends RuntimeException {
  
    private String message;
  
    public NoSuchContactExistsException() {}
  
    public NoSuchContactExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}

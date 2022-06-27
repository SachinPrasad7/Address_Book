package com.pwc.addressbook.exception;

public class ContactAlreadyExistsException extends RuntimeException {
  
    private String message;
  
    public ContactAlreadyExistsException() {}
  
    public ContactAlreadyExistsException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
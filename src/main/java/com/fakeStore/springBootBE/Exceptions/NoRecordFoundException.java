package com.fakeStore.springBootBE.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoRecordFoundException extends Exception{
    private String message;
    public NoRecordFoundException(String message){
        super(message);
    }
}

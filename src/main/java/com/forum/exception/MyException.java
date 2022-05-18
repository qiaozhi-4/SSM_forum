package com.forum.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyException extends RuntimeException{
    private String message;

    public MyException(String message){
        super(message);
        this.message = message;
    }
}

package com.zorrix.tgpremiumbot.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class WrongMessageException extends RuntimeException{
    public WrongMessageException(String message){
        super(message);
    }
}

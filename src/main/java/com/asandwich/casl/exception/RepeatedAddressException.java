package com.asandwich.casl.exception;

import com.asandwich.casl.memory.Word;

public class RepeatedAddressException extends Exception {
    private static final long serialVersionUID = 1L;

    public RepeatedAddressException(Word address) {
        super("Repeated address usage : " + address.toString());
    }

}

package com.asandwich.casl.operation.math;

import com.asandwich.casl.memory.Word;

public class Divide extends MathOperation {

    public Divide(Word addrL, Word addrR) {
        super(addrL, addrR);
    }

    @Override
    public Word getResult() {
        return new Word(this.addrL.getData() / this.addrR.getData());
    }

    @Override
    public Integer getOpCode() {
        return opCode;
    }
}

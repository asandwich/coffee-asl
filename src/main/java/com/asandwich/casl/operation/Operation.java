package com.asandwich.casl.operation;

import com.asandwich.casl.memory.MemoryInterface;
import com.asandwich.casl.memory.Word;

public class Operation {
    protected static Integer opCode;
    protected Word left;
    protected Word right;

    public void run(MemoryInterface memory) {
    }

    public Integer getOpCode() {
        return opCode;
    }
}

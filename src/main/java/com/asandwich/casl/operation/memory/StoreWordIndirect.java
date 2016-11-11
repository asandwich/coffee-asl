package com.asandwich.casl.operation.memory;

import com.asandwich.casl.memory.MemoryInterface;
import com.asandwich.casl.memory.Word;
import com.asandwich.casl.operation.Operation;

public class StoreWordIndirect extends Operation {

    public StoreWordIndirect(Word addrL, Word addrR) {
        this.left = addrL;
        this.right = addrR;
    }

    @Override
    public void run(MemoryInterface memory) {
        Word value = memory.read(right);
        memory.store(left, value);
    }

    @Override
    public Integer getOpCode() {
        return opCode;
    }
}

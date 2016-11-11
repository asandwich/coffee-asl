package com.asandwich.casl.operation.memory;

import com.asandwich.casl.memory.MemoryInterface;
import com.asandwich.casl.memory.Word;
import com.asandwich.casl.operation.Operation;

public class StoreWordDirect extends Operation {

    public StoreWordDirect(Word addr, Word value) {
        this.left = addr;
        this.right = value;
    }

    @Override
    public void run(MemoryInterface memory) {
        memory.store(left, right);
    }

    @Override
    public Integer getOpCode() {
        return opCode;
    }
}

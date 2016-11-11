package com.asandwich.casl.operation.control;

import com.asandwich.casl.memory.MemoryInterface;
import com.asandwich.casl.memory.Word;
import com.asandwich.casl.operation.Operation;

public class Branch extends Operation {
    public Branch(Word addr, Word compareValue) {
        opCode = 1;
        this.left = addr;
        this.right = compareValue;
    }

    @Override
    public void run(MemoryInterface memory) {
        if(this.right.equals(memory.getOperationResult()))
            memory.setProgramCounter(this.left);
    }

    @Override
    public Integer getOpCode() {
        return opCode;
    }
}

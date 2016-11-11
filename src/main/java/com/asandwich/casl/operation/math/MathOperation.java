package com.asandwich.casl.operation.math;

import com.asandwich.casl.memory.MemoryInterface;
import com.asandwich.casl.memory.Word;
import com.asandwich.casl.operation.Operation;

public abstract class MathOperation extends Operation {
    protected Word addrL;
    protected Word addrR;

    public abstract Word getResult();

    public MathOperation(Word addrL, Word addrR) {
        this.addrL = addrL;
        this.addrR = addrR;
    }

    @Override
    public void run(MemoryInterface memory) {
        memory.storeOperationResult(this.getResult());
    }

}

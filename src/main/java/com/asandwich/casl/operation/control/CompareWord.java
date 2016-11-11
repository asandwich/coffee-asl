package com.asandwich.casl.operation.control;

import com.asandwich.casl.memory.MemoryInterface;
import com.asandwich.casl.memory.Word;
import com.asandwich.casl.operation.Operation;

public class CompareWord extends Operation {

    public CompareWord(Word addrL, Word addrR) {
        this.left = addrL;
        this.right = addrR;
    }

    @Override
    public void run(MemoryInterface memory) {
        Word l = memory.read(this.left);
        Word r = memory.read(this.right);
        Word result = l.equals(r) ? new Word(0x00000001) : new Word(0x00000000);
        memory.storeOperationResult(result);
    }

    @Override
    public Integer getOpCode() {
        return opCode;
    }

}

package com.asandwich.casl.processor;

import com.asandwich.casl.memory.Word;
import com.asandwich.casl.operation.NoOp;
import com.asandwich.casl.operation.Operation;
import com.asandwich.casl.operation.control.Branch;
import com.asandwich.casl.operation.control.CompareWord;
import com.asandwich.casl.operation.io.Print;
import com.asandwich.casl.operation.math.Add;
import com.asandwich.casl.operation.math.Divide;
import com.asandwich.casl.operation.math.Multiply;
import com.asandwich.casl.operation.math.Subtract;
import com.asandwich.casl.operation.memory.StoreWordDirect;
import com.asandwich.casl.operation.memory.StoreWordIndirect;

public class InstructionDecoder {
    public InstructionDecoder() {

    }

    public Operation decode(Word instruction, Word left, Word right) {
        Operation o = new NoOp();
        if(instruction.getData() == 1)
            o = new Branch(left, right);
        else if(instruction.getData() == 2)
            o = new CompareWord(left, right);
        else if(instruction.getData() == 3)
            o = new Print(left, right);
        else if(instruction.getData() == 4)
            o = new Add(left, right);
        else if(instruction.getData() == 5)
            o = new Subtract(left, right);
        else if(instruction.getData() == 6)
            o = new Multiply(left, right);
        else if(instruction.getData() == 7)
            o = new Divide(left, right);
        else if(instruction.getData() == 8)
            o = new StoreWordDirect(left, right);
        else if(instruction.getData() == 9)
            o = new StoreWordIndirect(left, right);
        return o;
    }
}

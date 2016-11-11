package com.asandwich.casl.processor;

import com.asandwich.casl.memory.MainMemory;
import com.asandwich.casl.memory.Word;
import com.asandwich.casl.operation.Operation;

public class MainProcessor {

    public void run() {
        MainMemory main_memory = new MainMemory();
        InstructionDecoder instruction_decoder = new InstructionDecoder();

        while(true) {
            //main_memory.dumpMemory();
            Word instruction = main_memory.getNextValue();
            Word left = main_memory.getNextValue();
            Word right = main_memory.getNextValue();
            Operation operation = instruction_decoder.decode(instruction, left, right);
            operation.run(main_memory);
        }
    }
}

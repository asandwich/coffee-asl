package com.asandwich.casl.interpreter;

import com.asandwich.casl.exception.MisMatchedPairException;
import com.asandwich.casl.exception.RepeatedAddressException;
import com.asandwich.casl.memory.MainMemory;
import com.asandwich.casl.memory.Word;
import com.asandwich.casl.memory.WordTuple;

import java.util.ArrayList;
import java.util.HashSet;

public class MemoryWriter {
    //Input
    //ArrayList<(word,word)>
    //output
    //MemoryObject with everything added to it.
    //	Verify that no address is being written to twice

    private MainMemory mainMemory;

    private MemoryWriter() {
        //TODO This is where memory will be customized. I.e.
        //Creating a (initialization file) RAM/ROM length, stuff like that
    }

    private void writeToMemory(ArrayList<WordTuple> memory) throws RepeatedAddressException, MisMatchedPairException {
        HashSet<Word> addresses = new HashSet<>();

        for(WordTuple wt : memory) {
            if(wt == null || wt.getAddress() == null || wt.getValue() == null)
                throw new MisMatchedPairException(wt);
            if(!addresses.add(wt.getAddress()))
                throw new RepeatedAddressException(wt.getAddress());
        }
        mainMemory = new MainMemory();
        for(WordTuple wt : memory) {
            mainMemory.store(wt.getAddress(), wt.getValue());
        }
    }

    private MainMemory getMainMemory() {
        return mainMemory;
    }

    public static void main(String[] args) {
        MemoryWriter mw = new MemoryWriter();
        ArrayList<WordTuple> memory = new ArrayList<>();
        memory.add(new WordTuple(new Word(0x1000003), new Word(0x9123333)));
        memory.add(new WordTuple(new Word(0x1000004), new Word(0x9124333)));
        memory.add(new WordTuple(new Word(0x1000005), new Word(0x91223123)));
        memory.add(new WordTuple(new Word(0x1000006), new Word(0x912a433)));

        try {
            mw.writeToMemory(memory);
        } catch (RepeatedAddressException | MisMatchedPairException e) {
            e.printStackTrace();
        }
        mw.getMainMemory().dumpMemory();
    }
}

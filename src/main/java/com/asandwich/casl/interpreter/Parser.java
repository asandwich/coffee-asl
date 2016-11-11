package com.asandwich.casl.interpreter;

import com.asandwich.casl.memory.Word;
import com.asandwich.casl.memory.WordTuple;

import java.util.ArrayList;

public class Parser {
    //Input String[]

    //Operation format
    //Integer Integer Integer; <--This is an instruction
    //Integer Integer Integer; <--This is an instruction

    //Region
    //Region : Integer
    //End Region;

    //Output, ArrayList<(word, word)>

    private ArrayList<String> rawData;
    private ArrayList<WordTuple> output;

    Parser(ArrayList<String> rawData) {
        this.output = new ArrayList<>();
        this.rawData = rawData;
    }

    //Isolate a region.
    //Throw errors if you find problems
    //return the parsed regions
    ArrayList<WordTuple> parseData() {
        return output;
    }

    //TODO throw a LOT of errors
    void parseRegion(Word address) {

        ArrayList<WordTuple> region = new ArrayList<>();
        for(String s : this.rawData) {
            region.addAll(parseLine(s, address));
        }
        output.addAll(region);
    }

    //TODO
    //Throw a SHIT load of exceptions at this point. Malformed lines,
    //malformed words all that stuff.
    private ArrayList<WordTuple> parseLine(String line, Word address) {

        line = line.trim();
        //Check last character equal to ';'
        if(line.charAt(line.length() - 1) != ';')
            return null;
        line = line.replace(";", "");
        String[] temp = line.split(" ");
        if(temp.length != 3)
            return null;

        ArrayList<WordTuple> retVal = new ArrayList<>();
        for(String s : temp) {
            retVal.add(new WordTuple(address, new Word(s)));
            address.increment();
        }
        return retVal;
    }
}

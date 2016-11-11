package com.asandwich.casl.interpreter;

import com.asandwich.casl.memory.Word;
import org.junit.Test;

import java.util.ArrayList;

public class ParserTest {
    @Test
    public void testParser() {
        String a = "0x00000000 0x000000001 0x00000002;";
        String b = "0x00000003 0x000000004 0x00000005;";
        String c = "0x00000006 0x000000007 0x00000008;";
        String d = "0x00000009 0x00000000A 0x0000000B;";
        String e = "0x0000000C 0x00000000D 0x0000000E;";
        ArrayList<String> region = new ArrayList<>();
        region.add(a);
        region.add(b);
        region.add(c);
        region.add(d);
        region.add(e);
        Parser p = new Parser(region);
        p.parseRegion(new Word(0x10000000));
        p.parseData().forEach(o -> System.out.println(o.toString()));
    }
}

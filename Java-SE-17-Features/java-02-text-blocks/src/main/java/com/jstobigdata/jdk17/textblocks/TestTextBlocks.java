package com.jstobigdata.jdk17.textblocks;

import com.fasterxml.jackson.core.JsonProcessingException;

public class TestTextBlocks {
    public static void main(String[] args) throws JsonProcessingException {
        //Example-1
        TextBlockExamples example1 = new TextBlockExamples();
        example1.print();

        //Example-2
        JsonExample example2 = new JsonExample();
        example2.parseJson();
    }
}

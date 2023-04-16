package com.jstobigdata.jdk17.textblocks;

public class TextBlockExamples {
    private String multiLine = """
            This is
            a
            multiline
            Text
            """;

    private String singleLine = """
            This is also possible""";

    private String indentedText = """
            {
                "name": "John Cena",
                "age": 45,
                "profession": "Wrestler"
            }
            """;

    //private String illegal = """Not possible """;

    public void print (){
        System.out.println("================multiLine =========");
        System.out.println(multiLine);

        System.out.println("================singleLine =========");
        System.out.println(singleLine);

        System.out.println("================indentedText =========");
        System.out.println(indentedText);
    }
}

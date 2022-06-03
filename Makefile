CLASSPATH = lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/commonmark-0.19.0.jar:.

MarkdownParse.class : MarkdownParse.java
        javac -g -cp $(CLASSPATH) MarkdownParse.java
MarkdownParseTest.class : MarkdownParseTest.java MarkdownParse.class
        javac -g -cp $(CLASSPATH) MarkdownParseTest.java
test: MarkdownParseTest.class
        java -cp $(CLASSPATH) org.junit.runner.JUnitCore  MarkdownParseTest

TryCommonMark.class: TryCommonMark.java
        javac -g -cp $(CLASSPATH) TryCommonMark.java
package ch.resrc.antlr.graphics;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.Path;

public class GraphicsMain {

    public static void main(String[] args) throws IOException {
        // /Users/resc/git/ch.resrc.antlr/ch/resrc/antlr/graphics/box.txt
        // /Users/resc/git/ch.resrc.antlr/src/main/java/ch/resrc/antlr/graphics/box.txt"
        // /Users/resc/git/ch.resrc.antlrsrc/main/java/ch/resrc/antlr/graphics/box.txt
        CharStream input;
        if (args.length > 0) {
            Path path = Path.of(System.getProperty("user.dir") + args[0]);
            System.out.println(path);
            input = new ANTLRFileStream(path.toString()) {
            };
        } else {
            input = new ANTLRInputStream(System.in);
        }
        GraphicsLexer lexer = new GraphicsLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        GraphicsParser parser = new GraphicsParser(tokens);
        GraphicsParser.FileContext file = parser.file();
        file.children.forEach(c -> System.out.println(c.getText()));
    }
}

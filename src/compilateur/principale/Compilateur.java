package compilateur.principale;

import compilateur.codeGenerateur.CodeGenerateur;
import compilateur.lexer.Lexer;
import compilateur.lexer.LexerException;
import compilateur.node.Start;
import compilateur.parser.Parser;
import compilateur.parser.ParserException;
import compilateur.semantique.Semantique;
import javafx.scene.control.TextArea;

import java.io.*;

public class Compilateur {

    public Compilateur()  {

    }

    public void demarrerCompilateur(String texte_caractere) throws ParserException, IOException, LexerException{

        InputStream texte_byte = new ByteArrayInputStream(texte_caractere.getBytes());
        System.out.println(texte_byte);
        Lexer lexical = new Lexer(
                new PushbackReader(
                        new InputStreamReader(texte_byte), 1024));

        Parser syntaxique = new Parser(lexical);
        Start arbre = syntaxique.parse();
        arbre.apply(new Semantique());
        arbre.apply(new CodeGenerateur());

    }
}

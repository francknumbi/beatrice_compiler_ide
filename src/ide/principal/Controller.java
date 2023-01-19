package ide.principal;

import compilateur.lexer.LexerException;
import compilateur.parser.ParserException;
import compilateur.principale.Compilateur;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;

public class Controller {
    public static String nomClass;
    private int untitledFileNumber;
    private HashMap<String,String> FichiersEnregistrer;

    private String cheminDefaut = new File("").getAbsolutePath();
    public static HashMap<String,String> table_symboles = new HashMap<String,String>();
    @FXML
    private MenuItem btn_Copier, btn_SelectionnerCopier, btn_Quitter;
    @FXML
    private MenuItem btn_Importer, btn_creerFichier, btn_Enregistrer;
    @FXML
    private Slider s;
    @FXML
    private TextArea code_Source, textAreaResultat;
    @FXML
    private TabPane tabbedEditors, tabConsole;

    @FXML
    private ImageView executer;

    public Controller() {
    }

    @FXML
    public void onClick_btn_creerFichier(ActionEvent e){

        Tab nouveauOnglet = new Tab();
        this.untitledFileNumber +=1;
        tabbedEditors.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
        nouveauOnglet.setClosable(true);
        TextArea code = new TextArea();
        code.setId("untitled "+this.untitledFileNumber);

        code.setText("algorithme 'nomAlgorithme' \n" +
                "\n" +
                "debut\n" +
                "\n" +
                "fin");

        nouveauOnglet.setText("untitled "+this.untitledFileNumber+".algo");
        nouveauOnglet.setId("untitled "+this.untitledFileNumber);
        nouveauOnglet.setContent(code);
        tabbedEditors.getTabs().add(nouveauOnglet);
        SingleSelectionModel<Tab> selection = tabbedEditors.getSelectionModel();
        selection.select(nouveauOnglet);
    }

    @FXML
    public void onClick_btn_Copier(ActionEvent e){

        String texte = code_Source.getSelectedText();
        final Clipboard presse_Papier = Clipboard.getSystemClipboard();
        final ClipboardContent Contenu_Presse_Papier = new ClipboardContent();

        Contenu_Presse_Papier.putString(texte);
        presse_Papier.setContent(Contenu_Presse_Papier);
    }
    @FXML
    public void onClick_Enregistrer(ActionEvent e) throws IOException {

        File repertoireSelectionner=null;
        FileChooser repertoireChoisi = new FileChooser();
        String nomNouveauFichier = tabbedEditors.getSelectionModel().getSelectedItem().getText();

        repertoireChoisi.setInitialFileName(nomNouveauFichier);

        if(new File(new File("").getAbsolutePath()+"/"+nomNouveauFichier).exists()){
            code_Source = (TextArea) tabbedEditors.getSelectionModel().getSelectedItem().getContent();
            BufferedWriter BR = new BufferedWriter(new FileWriter(cheminDefaut+"/"+nomNouveauFichier));
            StringBuilder texte = new StringBuilder(code_Source.getText());
            BR.write(texte.toString());
            BR.close();
        }
        else {
            FileChooser.ExtensionFilter fichierExtension =
                    new FileChooser.ExtensionFilter("fichiers algo (*.algo)", "*.algo");
            repertoireChoisi.getExtensionFilters().add(fichierExtension);
            repertoireSelectionner = repertoireChoisi.showSaveDialog(null);

            tabbedEditors.getSelectionModel().getSelectedItem().setText(repertoireSelectionner.getName());
            code_Source = (TextArea) tabbedEditors.getSelectionModel().getSelectedItem().getContent();
            if(repertoireSelectionner!=null){

                String chemin = repertoireSelectionner.getAbsolutePath();
                BufferedWriter BR = new BufferedWriter(new FileWriter(chemin));
                BR.write(code_Source.getText());
                BR.close();
            }
        }
    }

    @FXML
    public void onClick_Importer(ActionEvent e) throws IOException {

        Tab nouveauOnglet = new Tab();
        TextArea code = new TextArea();
        Stage scene = new Stage();
        FileChooser fichierChoisi = new FileChooser();
        fichierChoisi.setTitle("Fichier ouvert");
        File fichierSelectionner = fichierChoisi.showOpenDialog(scene);

        code.setId(fichierSelectionner.getName());
        nouveauOnglet.setText(fichierSelectionner.getName());
        nouveauOnglet.setId(fichierSelectionner.getName());

        if (fichierSelectionner!=null)
        {
            FileReader FR = new FileReader(fichierSelectionner.getAbsolutePath());
            BufferedReader BR = new BufferedReader(FR);
            StringBuilder sb = new StringBuilder();
            String texte ="";
            while ((texte = BR.readLine())!= null){
                sb.append(texte +"\n");
            }
            code.setText(sb.toString());
            nouveauOnglet.setContent(code);
            tabbedEditors.getTabs().add(nouveauOnglet);
            SingleSelectionModel<Tab> selection = tabbedEditors.getSelectionModel();
            selection.select(nouveauOnglet);
        }
    }
    public void onClick_Quitter(ActionEvent e){
        System.out.println("exit");
        Platform.exit();
    }
    @FXML
    public void onClick_SelectionnerCopier(ActionEvent e){
        String texte = code_Source.getSelectedText();
        final Clipboard presse_Papier = Clipboard.getSystemClipboard();
        final ClipboardContent Contenu_Presse_Papier = new ClipboardContent();

        Contenu_Presse_Papier.putString(texte);
        presse_Papier.setContent(Contenu_Presse_Papier);
    }
    public void onClick_Deboguer(ActionEvent e){
        String texte = code_Source.getSelectedText();
        final Clipboard presse_Papier = Clipboard.getSystemClipboard();
        final ClipboardContent Contenu_Presse_Papier = new ClipboardContent();

        Contenu_Presse_Papier.putString(texte);
        presse_Papier.setContent(Contenu_Presse_Papier);
    }
    public void onClick_Arreter(ActionEvent e){
        String texte = code_Source.getSelectedText();
        final Clipboard presse_Papier = Clipboard.getSystemClipboard();
        final ClipboardContent Contenu_Presse_Papier = new ClipboardContent();

        Contenu_Presse_Papier.putString(texte);
        presse_Papier.setContent(Contenu_Presse_Papier);
    }


    @FXML
    public void onClick_btn_executer(ActionEvent e) throws ParserException, IOException, LexerException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        code_Source = (TextArea)tabbedEditors.getSelectionModel().getSelectedItem().getContent();

        // APPEL DU COMPILATEUR
        new Compilateur().demarrerCompilateur(code_Source.getText());




        // CHARGEMENT DYNAMIQUE DU FICHIER .CLASS
        if(nomClass!=null)
        {
            // REDIRECTION DU FLUX DE SORTIE
            ByteArrayOutputStream nouvelleSortie = new ByteArrayOutputStream();
            PrintStream nouveauFluxSortie = new PrintStream(nouvelleSortie);
            PrintStream ancienneSortie = System.out;
            System.setOut(nouveauFluxSortie);

            // REDIRECTION DU FLUX D'ENTREE
            Class <?> classChargee = new URLClassLoader(
                    new URL[]{new File("/home/numbi/Documents/tfc/javafx/beatrice_compiler_ide/").toURI().toURL()}).loadClass(Controller.nomClass);
            Method methodePrincipale = classChargee.getDeclaredMethod("main", String[].class);
            methodePrincipale.invoke(methodePrincipale, new Object[]{new String[0]});

            // VIDER LA SORTIE ET REPLACER LA SORTIE A LA NORMAL
            System.out.flush();
            System.setOut(ancienneSortie);

            String sortieConsole = nouvelleSortie.toString();
            // INSERTION TEXT DANS LA CONSOLE
            textAreaResultat.setText(sortieConsole);
        }





        //System.out.println(methodePrincipale);

        //Afficher le resultat

        System.out.println(table_symboles);
        System.out.println(System.getProperty("user.name"));
        System.out.println("Success");

    }
}

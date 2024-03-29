package compilateur.codeGenerateur;

import compilateur.analysis.DepthFirstAdapter;
import compilateur.node.*;
import jas.*;
import ide.principal.Controller;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class CodeGenerateur extends DepthFirstAdapter {

    //class principale
    private ClassEnv classPrincipale = new ClassEnv();

    //methode constructeur
    private CodeAttr constructeur = new CodeAttr();
    //methode principale de la class
    private CodeAttr main_methode = new CodeAttr();
    int labelNumber =0;
    Label labelNom;
    private String nomClass;
    public static String classNom;
    private String typeVariableActuelle =null;
    private boolean conditionnelle = true;

    private HashMap<String,String> table_symboles = Controller.table_symboles;



    /**
     *    definition du constructeur
     *    Definition d une partie de la methode main
     */
    public void inAAlgorithmeProgramme(AAlgorithmeProgramme node)
    {
        try{
            constructeur.addInsn(new Insn(RuntimeConstants.opc_aload_0));
            constructeur.addInsn(new Insn(RuntimeConstants.opc_invokespecial, new MethodCP(
                    "java/lang/Object", "<init>", "()V")));
            constructeur.addInsn(new Insn(RuntimeConstants.opc_return));


            main_methode.setVarSize((short) 10);
            main_methode.setStackSize((short) 9);
        } catch (jas.jasError jasError) {
            jasError.printStackTrace();
        }
    }

    /**
     * Definition de la class principale
     */
    public void outANomAlgorithme(ANomAlgorithme node)
    {
        nomClass = node.getIdentifiant().getText();
        try{

            classPrincipale.setClass(new ClassCP(nomClass));
            classPrincipale.setSuperClass(new ClassCP("java/lang/Object"));
            classPrincipale.setSource(new SourceAttr(""));
            classPrincipale.setClassAccess((short) RuntimeConstants.ACC_PUBLIC);
            classPrincipale.addMethod((short) RuntimeConstants.ACC_PUBLIC,
                    "<init>", "()V",constructeur,new ExceptAttr());

            /**
             * Ajout d'attributs (variables) a la class
             */

            if(table_symboles!=null){

                table_symboles.forEach((identifiant,type) ->{
                    switch (type) {
                        case "entier":
                        case "byte":
                            classPrincipale.addField(new Var((short) (RuntimeConstants.ACC_STATIC | RuntimeConstants.ACC_PUBLIC),
                                    new AsciiCP(identifiant), new AsciiCP("I"), new ConstAttr(new IntegerCP(1))));
                            break;
                        case "reel":
                            classPrincipale.addField(new Var((short) (RuntimeConstants.ACC_STATIC | RuntimeConstants.ACC_PUBLIC),
                                    new AsciiCP(identifiant), new AsciiCP("F"), new ConstAttr(new FloatCP(1))));
                            break;
                        case "caractere":
                            classPrincipale.addField(new Var((short) (RuntimeConstants.ACC_STATIC | RuntimeConstants.ACC_PUBLIC),
                            new AsciiCP(identifiant), new AsciiCP("Ljava/lang/String;"), new ConstAttr(new StringCP("null"))));
                            break;
                    }
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**********************************************************
     ************************* OPERATIONS **********************
     *********************************************************/


    /*******************************************************
     *  ******************    AFFECTATIONS
     *******************************************************/
    public void inAAffectation(AAffectation node)
    {
        typeVariableActuelle = table_symboles.get(node.getIdentifiant().getText());
    }
    public void inAIdentifiantTerme(AIdentifiantTerme node)
    {
        typeVariableActuelle = table_symboles.get(node.getIdentifiant().getText());
    }
    public void outAAffectation(AAffectation node)
    {
        String identifiant = node.getIdentifiant().getText();
        if(typeVariableActuelle.equals("reel")){
            try {
                main_methode.addInsn(new Insn(RuntimeConstants.opc_putstatic,new FieldCP(nomClass,identifiant,"F")));
            } catch (jas.jasError jasError) {
                jasError.printStackTrace();
            }
        }
        else if (typeVariableActuelle.equals("entier") | typeVariableActuelle.equals("byte")){
            try {
                main_methode.addInsn(new Insn(RuntimeConstants.opc_putstatic,new FieldCP(nomClass,identifiant,"I")));
            } catch (jas.jasError jasError) {
                jasError.printStackTrace();
            }
        }
        else if (typeVariableActuelle.equals("caractere")){
            try {
                main_methode.addInsn(new Insn(RuntimeConstants.opc_putstatic,new FieldCP(nomClass,identifiant,"Ljava/lang/String;")));
            } catch (jas.jasError jasError) {
                jasError.printStackTrace();
            }
        }
        typeVariableActuelle =null;
    }
    /*************************************************************
     **************  PLACER LA VALEUR ENTIERE DANS LA PILE
     *************************************************************/
    public void outAValeurEntiereTerme(AValeurEntiereTerme node)  {

        if (typeVariableActuelle != null && typeVariableActuelle.equals("reel")){
            float valeur = Float.parseFloat(node.getNombreEntier().getText());
            try {
                main_methode.addInsn(new Insn(RuntimeConstants.opc_ldc,new FloatCP(valeur)));
            } catch (jas.jasError jasError) {
                jasError.printStackTrace();
            }
        }
        else {
            int valeur = Integer.parseInt(node.getNombreEntier().getText());
            if (valeur > -1){
                try {
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_bipush,valeur));
                } catch (jas.jasError jasError) {
                    jasError.printStackTrace();
                }
            }
        }
    }
    /**********************************************************************
     ********************* PLACER LA VALEUR DECIMALE DANS LA PILE
     **********************************************************************/
    public void outAValeurReelTerme(AValeurReelTerme node)
    {
        float valeur = Float.parseFloat(node.getNombreReel().getText());
        try {
            main_methode.addInsn(new Insn(RuntimeConstants.opc_ldc,new FloatCP(valeur)));
        } catch (jas.jasError jasError) {
            jasError.printStackTrace();
        }
    }
    /***********************************************************
     *****************  PLACER UNE CHAINE DANS LA PILE
     ***********************************************************/

    public void caseAChaineTerme(AChaineTerme node)
    {
        String valeur = node.getCaracteres().getText().replaceAll("\"","");
        System.out.println(valeur);
        try{
            main_methode.addInsn(new Insn(RuntimeConstants.opc_ldc,new StringCP(valeur)));
        }catch (jas.jasError jasError) {
            jasError.printStackTrace();
        }
    }

    /*******************************************************************
     ***************  PLACER LA VALEUR D'UNE VARIABLE DANS LA PILE
     *******************************************************************/
    public void outAIdentifiantTerme(AIdentifiantTerme node)
    {
        String type = table_symboles.get(node.getIdentifiant().getText());
        String identifiant = node.getIdentifiant().getText();

        if (type != null && type.equals("reel")){

            try {
                main_methode.addInsn(new Insn(RuntimeConstants.opc_getstatic,new FieldCP(nomClass, identifiant, "F")));
            } catch (jas.jasError jasError) {
                jasError.printStackTrace();
            }
        }
        else if(type.equals("entier") | type.equals("byte")){

            try {
                if(typeVariableActuelle.equals("reel")){
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_getstatic,new FieldCP(nomClass, identifiant, "I")));
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_i2f));
                }
                else if(typeVariableActuelle.equals("entier") | type.equals("byte")) {
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_getstatic,new FieldCP(nomClass, identifiant, "I")));
                }
            } catch (jas.jasError jasError) {
                jasError.printStackTrace();
            }
        }
        System.out.println("identifiant = "+identifiant.length() +" type ="+type);
    }
    /***************************************************
     ******************   OPERATIONS ARITHMETIQUES
     ***************************************************/
    public void outAAdditionExpress(AAdditionExpress node)
    {
        try {
            if(typeVariableActuelle.equals("reel"))
                main_methode.addInsn(new Insn(RuntimeConstants.opc_fadd));
            else if(typeVariableActuelle.equals("entier") | typeVariableActuelle.equals("byte"))
                main_methode.addInsn(new Insn(RuntimeConstants.opc_iadd));
        } catch (jas.jasError jasError) {
            jasError.printStackTrace();
        }
    }
    public void outASoustractionExpress(ASoustractionExpress node)
    {
        try {
            if(typeVariableActuelle.equals("reel"))
                main_methode.addInsn(new Insn(RuntimeConstants.opc_fsub));
            else if(typeVariableActuelle.equals("entier") | typeVariableActuelle.equals("byte"))
                main_methode.addInsn(new Insn(RuntimeConstants.opc_isub));
        } catch (jas.jasError jasError) {
            jasError.printStackTrace();
        }
    }
    public void outAMultiplicationFacteur(AMultiplicationFacteur node)
    {
        try {
            if(typeVariableActuelle.equals("reel"))
                main_methode.addInsn(new Insn(RuntimeConstants.opc_fmul));
            else if(typeVariableActuelle.equals("entier") | typeVariableActuelle.equals("byte"))
                main_methode.addInsn(new Insn(RuntimeConstants.opc_imul));
        } catch (jas.jasError jasError) {
            jasError.printStackTrace();
        }
    }
    public void outADivisionFacteur(ADivisionFacteur node)
    {
        try {
            if(typeVariableActuelle.equals("reel"))
                main_methode.addInsn(new Insn(RuntimeConstants.opc_fdiv));
            else if(typeVariableActuelle.equals("entier") | typeVariableActuelle.equals("byte"))
                main_methode.addInsn(new Insn(RuntimeConstants.opc_idiv));
        } catch (jas.jasError jasError) {
            jasError.printStackTrace();
        }
    }
    public void outAModuloFacteur(AModuloFacteur node)
    {
        try {
            if(typeVariableActuelle.equals("reel"))
                main_methode.addInsn(new Insn(RuntimeConstants.opc_frem));
            else if(typeVariableActuelle.equals("entier") | typeVariableActuelle.equals("byte"))
                main_methode.addInsn(new Insn(RuntimeConstants.opc_irem));
        } catch (jas.jasError jasError) {
            jasError.printStackTrace();
        }
    }

    public void outAPuissanceFacteur(APuissanceFacteur node)
    {

    }
    /*******************************************************************************
     ***************** Affichage d un simple message ou simple identifiant
     *******************************************************************************/
    public void inASinglePrint(ASinglePrint node)
    {
        try {
            main_methode.addInsn(new Insn(RuntimeConstants.opc_getstatic,new FieldCP("java/lang/System", "out", "Ljava/io/PrintStream;")));
        } catch (jas.jasError jasError) {
            jasError.printStackTrace();
        }

    }
    public void outASinglePrint(ASinglePrint node)
    {

        String message = node.getMessageAdd().toString().replaceAll(" ","");
        System.out.println(message);
            // AFFCHER IDENTIFIANT
        if(conditionnelle){
            if(table_symboles.containsKey(message)){
                try {
                    String type = table_symboles.get(message);
                    switch (type) {

                        case "entier":
                        case "byte":
                            main_methode.addInsn(new Insn(RuntimeConstants.opc_getstatic,new FieldCP(nomClass, message,"I")));
                            System.out.println("byte entier");
                            main_methode.addInsn(new Insn(RuntimeConstants.opc_invokevirtual, new MethodCP("java/io/PrintStream", "println", "(I)V")));
                            break;
                        case "reel":
                            System.out.println("relllll");
                            main_methode.addInsn(new Insn(RuntimeConstants.opc_getstatic,new FieldCP(nomClass, message,"F")));
                            main_methode.addInsn(new Insn(RuntimeConstants.opc_invokevirtual, new MethodCP("java/io/PrintStream", "println", "(F)V")));
                            break;
                        case "caractere":
                            System.out.println("caractere");
                            main_methode.addInsn(new Insn(RuntimeConstants.opc_getstatic,new FieldCP(nomClass, message,"Ljava/lang/String;")));
                            main_methode.addInsn(new Insn(RuntimeConstants.opc_invokevirtual, new MethodCP("java/io/PrintStream", "println", "(Ljava/lang/String;)V")));
                            break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            //AFFICHER MESSAGE
            else {
                message = node.getMessageAdd().toString().replaceAll("\"","");
                try {
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_ldc, new StringCP(message)));
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_invokevirtual, new MethodCP("java/io/PrintStream", "println", "(Ljava/lang/String;)V")));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        //INSTRUCTIONS D UN LABEL MARQUANT  UNE STRUCTURE CONDITIONNELLE
        else {
            try {

                message = node.getMessageAdd().toString().replaceAll("\"","");
                main_methode.addInsn(labelNom);
                main_methode.addInsn(new Insn(RuntimeConstants.opc_ldc, new StringCP(message)));
                main_methode.addInsn(new Insn(RuntimeConstants.opc_invokevirtual, new MethodCP("java/io/PrintStream", "println", "(Ljava/lang/String;)V")));

            } catch (jasError e) {
                throw new RuntimeException(e);
            }

        }

    }
    /**
     * *********** LECTURE D UNE VALEUR
     */
    public void outAInput(AInput node)
    {
        String identifiant = node.getIdentifiant().getText();

        String type = table_symboles.get(identifiant);
        System.out.println(type + " "+ identifiant + " FIN");
        try {
            main_methode.addInsn(new Insn(RuntimeConstants.opc_new, new ClassCP("java/util/Scanner")));
            main_methode.addInsn(new Insn(RuntimeConstants.opc_dup));
            main_methode.addInsn(new Insn(RuntimeConstants.opc_getstatic, new FieldCP("java/lang/System","in","Ljava/io/InputStream;")));
            main_methode.addInsn(new Insn(RuntimeConstants.opc_invokespecial, new MethodCP("java/util/Scanner", "<init>", "(Ljava/io/InputStream;)V")));
            switch (type) {

                case "entier":
                case "byte":
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_invokevirtual, new MethodCP("java/util/Scanner","nextInt","()I")));
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_putstatic,new FieldCP(nomClass,identifiant,"I")));
                break;
                case "reel":
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_invokevirtual, new MethodCP("java/util/Scanner","nextFloat","()F")));
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_putstatic,new FieldCP(nomClass,identifiant,"F")));
                break;
                case "caractere":
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_invokevirtual, new MethodCP("java/util/Scanner","nextLine","()Ljava/lang/String;")));
                    main_methode.addInsn(new Insn(RuntimeConstants.opc_putstatic,new FieldCP(nomClass,identifiant,"Ljava/lang/String;")));
                break;
            }
        } catch (jasError e) {
            throw new RuntimeException(e);
        }
    }
    /***************************************************************
     * *********** INSTRUCTIONS CONDITIONNELLES
     **************************************************************/
    public void outASimpleStructureConditionnelle(ASimpleStructureConditionnelle node)
    {

    }
    /**
     * OPERATEUR D INFERIORITE
     */
    public void outAInferieurConditionSimple(AInferieurConditionSimple node)
    {
        try {
            labelNumber +=1;
            labelNom = new Label("Label"+labelNumber);
            conditionnelle =false;
            main_methode.addInsn(new Insn(RuntimeConstants.opc_if_icmpgt,labelNom));
        } catch (jasError e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * OPERATEUR D EGALITE
     */
    public void outAEgalConditionSimple(AEgalConditionSimple node)
    {
        try {
            labelNumber +=1;
            labelNom = new Label("Label"+labelNumber);
            conditionnelle =false;
            System.out.println("EGALLLLLL");
            main_methode.addInsn(new Insn(RuntimeConstants.opc_if_icmpeq,labelNom));

        } catch (jasError e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Ajout de la methode principale (main) a la class principale
     */
    public void outAAlgorithmeProgramme(AAlgorithmeProgramme node)
    {
        try{
            main_methode.addInsn(new Insn(RuntimeConstants.opc_return));
            classPrincipale.addMethod((short)(RuntimeConstants.ACC_STATIC| RuntimeConstants.ACC_PUBLIC),"main","([Ljava/lang/String;)V",main_methode,new ExceptAttr());

            classPrincipale.write(new DataOutputStream(new FileOutputStream(nomClass+".class")));
            Controller.nomClass = nomClass;

        } catch (jas.jasError | IOException jasError) {
            jasError.printStackTrace();
        }
    }


}

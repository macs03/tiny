package compilador;

import ast.*;
import java_cup.runtime.*;

/**
 *
 *  @author Miguel C�rdenas
 *  @author Yorman Castellanos
 *  @author Yacson Ramirez
 *  @author Jorge Gomez
 */

public class Compilador {
	
	/***********
	SymbolFactory es una nueva caracteristica que ha sido a?adida a las version 11a de cup, la cual facilita la implementacion de clases Symbol personalizadas
	, esto debido a que dicha clase no provee mucha informaci?n de contexto que podria ser util para el analisis semantico o ayudar en la construccion del AST
	Mas informacion en: http//4thmouse.com/index.php/2007/02/15/using-custom-symbols-in-cup/
	***********/

	public static void main(String[] args) throws Exception {
            
            
		@SuppressWarnings("deprecation")
		SymbolFactory sf = new DefaultSymbolFactory();
		parser parser_obj;

		if (args.length==0) 
			parser_obj=new parser(new Scanner(new java.io.FileInputStream("entrada2.tny"),sf),sf);
		else 
			parser_obj=new parser(new Scanner(new java.io.FileInputStream("entrada2.tny"),sf),sf);


		UtGen.debug=false; //NO muestro mensajes de depuracion del generador (UTGen) para que el codigo sea compatible con la version visual de la TM
		//Para ver depuracion de analisis sintactico se debe ir al parser.java y colocar modoDepuracion en true
                
		System.out.println("aqui llega");
                parser_obj.parse();
                System.out.println("inicializo el parse");
		NodoBase root=parser_obj.action_obj.getASTroot();
		System.out.println();
		System.out.println("IMPRESION DEL AST GENERADO");
		System.out.println();
		ast.Util.imprimirAST(root);
                System.out.println("IMPRESION DE LA TABLA");

                TablaSimbolos ts = new TablaSimbolos();
		ts.cargarTabla(root);
		ts.ImprimirClaves();
	    //REALIZAR ACA ANALISIS SEMANTICO
                System.out.println("");
                System.out.println("**ANALISIS SEMANTICO**");
                Semantico sem = new Semantico(root,ts);
                
//                Generador.setTablaSimbolos(ts);    
//                Generador.generarCodigoObjeto(root);
                    
	}

}

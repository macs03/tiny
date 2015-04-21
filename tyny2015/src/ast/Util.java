package ast;

public class Util {
	
	static int sangria = 0;
	
	//Imprimo en modo texto con sangrias el AST
	public static void imprimirAST(NodoBase raiz){
		  sangria+=2;
		  while (raiz != null) {
		    printSpaces();
		    if (raiz instanceof  NodoIf)
		    	System.out.println("If");
		    else if (raiz instanceof  NodoRepeat)
		    	System.out.println("Repeat");
		    
		    else if (raiz instanceof  NodoAsignacion)
		    	System.out.println("Asignacion a: "+((NodoAsignacion)raiz).getIdentificador());

		    else if (raiz instanceof  NodoLeer)  
		    	System.out.println("Lectura: "+((NodoLeer)raiz).getIdentificador());

		    else if (raiz instanceof  NodoEscribir)
		    	System.out.println("Escribir");
		    
		    else if (raiz instanceof NodoOperacion
		    		|| raiz instanceof NodoValor
		    		|| raiz instanceof NodoIdentificador )
		    	imprimirNodo(raiz);
                    
                    else if (raiz instanceof NodoFor)
                          System.out.println("For");
                    else if (raiz instanceof NodoParametro)
                          System.out.println("parametro");
                                       
                    else if (raiz instanceof NodoProcedure)
                          System.out.println("PROCEDURE");
                    
                    else if (raiz instanceof NodoFunction)
                          System.out.println("FUNCTION");
                    else if(raiz instanceof  NodoDeclararVariable)
                          System.out.println("Declara Variable");
                    
                    else if(raiz instanceof  NodollamaFunction)
                          System.out.println("LLama Function");
                        
                    else if(raiz instanceof NodoVector)
                          System.out.println("vector");
                    
		    else System.out.println("Tipo de nodo desconocido");;
		    
		    /* Hago el recorrido recursivo */
                    
                    if(raiz instanceof NodoDeclararVariable){
                        printSpaces();
                        imprimirNodo(((NodoDeclararVariable)raiz).getTipo());
                        imprimirAST(((NodoDeclararVariable)raiz).getId());
                        
                    }
                    
                                        
                    if(raiz instanceof NodoVector){
                        imprimirAST(((NodoVector)raiz).getId());
                        System.out.println("ind: "+((NodoVector)raiz).getIndice());
                    }
                    
                    if(raiz instanceof NodoFor){
                        printSpaces();
		    	System.out.println("**Inicio FOR**");
                        imprimirAST(((NodoFor)raiz).getInicio());
                        System.out.println("**Comprobacion FOR**");
                        imprimirAST(((NodoFor)raiz).getComprobacion());
                        System.out.println("**Paso FOR**");
                        imprimirAST(((NodoFor)raiz).getPaso());
                        System.out.println("**cuerpo FOR**");
                        imprimirAST(((NodoFor)raiz).getSeq_sent());
                    }
                    if(raiz instanceof NodoParametro){
                        printSpaces();
                        imprimirNodo(((NodoParametro)raiz).getTipo());
                        imprimirNodo(((NodoParametro)raiz).getID());
                        
                    }
                   
                    if(raiz instanceof NodoProcedure){
                        printSpaces();
		    	imprimirAST(((NodoProcedure)raiz).getNombre());
                        imprimirAST(((NodoProcedure)raiz).getParametros());
                        System.out.println("**cuerpo Procedure**");
		    	imprimirAST(((NodoProcedure)raiz).getSeq_sent());
                    }
                    
                    if(raiz instanceof NodoFunction){
                        printSpaces();
		    	imprimirNodo(((NodoFunction)raiz).getTipo());
                        imprimirNodo(((NodoFunction)raiz).getNombre());
                        imprimirAST(((NodoFunction)raiz).getParametros());
                        System.out.println("**cuerpo Function**");
		    	imprimirAST(((NodoFunction)raiz).getSeq_sent());
                        System.out.println("**Return**");
                        imprimirAST(((NodoFunction)raiz).getRetorna());
                    }
                    
                    if(raiz instanceof NodollamaFunction){
                        printSpaces();
                        imprimirAST(((NodollamaFunction)raiz).getNombre());
                        System.out.println("parametros");
                        imprimirAST(((NodollamaFunction)raiz).getParametros());
                        
                    }
                    
		    if (raiz instanceof  NodoIf){
		    	printSpaces();
		    	System.out.println("**Prueba IF**");
		    	imprimirAST(((NodoIf)raiz).getPrueba());
		    	printSpaces();
		    	System.out.println("**Then IF**");
		    	imprimirAST(((NodoIf)raiz).getParteThen());
		    	if(((NodoIf)raiz).getParteElse()!=null){
		    		printSpaces();
		    		System.out.println("**Else IF**");
		    		imprimirAST(((NodoIf)raiz).getParteElse());
		    	}
		    }
		    else if (raiz instanceof  NodoRepeat){
		    	printSpaces();
		    	System.out.println("**Cuerpo REPEAT**");
		    	imprimirAST(((NodoRepeat)raiz).getCuerpo());
		    	printSpaces();
		    	System.out.println("**Prueba REPEAT**");
		    	imprimirAST(((NodoRepeat)raiz).getPrueba());
		    }
		    else if (raiz instanceof  NodoAsignacion)
		    	imprimirAST(((NodoAsignacion)raiz).getOperacion());
		    else if (raiz instanceof  NodoEscribir)
		    	imprimirAST(((NodoEscribir)raiz).getExpresion());
		    else if (raiz instanceof NodoOperacion){
		    	printSpaces();
		    	System.out.println("**Expr Izquierda Operacion**");
		    	imprimirAST(((NodoOperacion)raiz).getOpIzquierdo());
		    	printSpaces();
		    	System.out.println("**Expr Derecha Operacion**");		    	
		    	imprimirAST(((NodoOperacion)raiz).getOpDerecho());
		    }
		    raiz = raiz.getHermanoDerecha();
		  }
		  sangria-=2;
		}

/* Imprime espacios con sangria */
static void printSpaces()
{ int i;
  for (i=0;i<sangria;i++)
	  System.out.print(" ");
}

/* Imprime informacion de los nodos */
static void imprimirNodo( NodoBase raiz )
{
	if(	raiz instanceof NodoRepeat
		||	raiz instanceof NodoLeer
		||	raiz instanceof NodoEscribir  ){
		System.out.println("palabra reservada: "+ raiz.getClass().getName());
	}
	
	if(	raiz instanceof NodoAsignacion )
		System.out.println(":=");
	
	if(	raiz instanceof NodoOperacion ){
		tipoOp sel=((NodoOperacion) raiz).getOperacion();
		if(sel==tipoOp.menor)
			System.out.println("<"); 
		if(sel==tipoOp.igual)
			System.out.println("=");
		if(sel==tipoOp.mas)
			System.out.println("+");
		if(sel==tipoOp.menos)
			System.out.println("-");
		if(sel==tipoOp.por)
			System.out.println("*");
		if(sel==tipoOp.entre)
			System.out.println("/");
	}

	if(	raiz instanceof NodoValor ){
		System.out.println("NUM, val= "+ ((NodoValor)raiz).getValor());
	}

	if(	raiz instanceof NodoIdentificador ){
		System.out.println("ID, nombre= "+ ((NodoIdentificador)raiz).getNombre());
	}

        if(	raiz instanceof NodoTipo ){
		System.out.println("Tipo dato= "+ ((NodoTipo)raiz).getTipo());
	}
}


}

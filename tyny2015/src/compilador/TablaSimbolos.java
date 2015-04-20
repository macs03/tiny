package compilador;

import java.util.*;


import ast.NodoAsignacion;
import ast.NodoBase;
import ast.NodoEscribir;
import ast.NodoIdentificador;
import ast.NodoIf;
import ast.NodoOperacion;
import ast.NodoRepeat;
import ast.NodoDeclararVector;
import ast.NodoFor;
import ast.NodoFunction;
import ast.NodoProcedure;
import ast.NodollamaFunction;
import ast.NodollamaProcedure;
import ast.NodollamarVector;
import ast.NodoFuncionR;

public class TablaSimbolos {
	private HashMap<String, RegistroSimbolo> tabla;
	private int direccion;  //Contador de las localidades de memoria asignadas a la tabla
	
	public TablaSimbolos() {
		super();
		tabla = new HashMap<String, RegistroSimbolo>();
		direccion=0;
	}

	public void cargarTabla(NodoBase raiz){
		while (raiz != null) {
	    if (raiz instanceof NodoIdentificador){
	    	InsertarSimbolo(((NodoIdentificador)raiz).getNombre(),-1);
	    	//TODO: A�adir el numero de linea y localidad de memoria correcta
	    }

	    /* Hago el recorrido recursivo */
	    if (raiz instanceof  NodoIf){
	    	cargarTabla(((NodoIf)raiz).getPrueba());
	    	cargarTabla(((NodoIf)raiz).getParteThen());
	    	if(((NodoIf)raiz).getParteElse()!=null){
	    		cargarTabla(((NodoIf)raiz).getParteElse());
	    	}
	    }
	    else if (raiz instanceof  NodoRepeat){
	    	cargarTabla(((NodoRepeat)raiz).getCuerpo());
	    	cargarTabla(((NodoRepeat)raiz).getPrueba());
	    }
	    else if (raiz instanceof  NodoAsignacion)
	    	cargarTabla(((NodoAsignacion)raiz).getExpresion());
	    else if (raiz instanceof  NodoEscribir)
	    	cargarTabla(((NodoEscribir)raiz).getExpresion());
	    else if (raiz instanceof NodoOperacion){
	    	cargarTabla(((NodoOperacion)raiz).getOpIzquierdo());
	    	cargarTabla(((NodoOperacion)raiz).getOpDerecho());
	    }else if (raiz instanceof NodoDeclararVector) {
                cargarTabla(((NodoDeclararVector)raiz).getIndice());
            }else if (raiz instanceof NodoFor) {
                cargarTabla(((NodoFor)raiz).getComprobacion());
                cargarTabla(((NodoFor)raiz).getInicio());
                cargarTabla(((NodoFor)raiz).getPaso());
                cargarTabla(((NodoFor)raiz).getSeq_sent());
            }else if (raiz instanceof NodoFunction) {
                cargarTabla(((NodoFunction)raiz).getParametros());
                cargarTabla(((NodoFunction)raiz).getSeq_sent());
                cargarTabla(((NodoFunction)raiz).getRetorna());
            }else if (raiz instanceof NodoProcedure) {
                cargarTabla(((NodoProcedure)raiz).getParametros());
                cargarTabla(((NodoProcedure)raiz).getSeq_sent());
            }else if (raiz instanceof NodollamaFunction) {
                cargarTabla(((NodollamaFunction)raiz).getParametros());
            }else if (raiz instanceof NodollamaProcedure) {
                cargarTabla(((NodollamaProcedure)raiz).getParametros());
            }else if (raiz instanceof NodollamarVector) {
                cargarTabla(((NodollamarVector)raiz).getIndice());
            }else if (raiz instanceof NodoFuncionR ) {
                cargarTabla(((NodoFuncionR)raiz).getParametros());
            }
	    raiz = raiz.getHermanoDerecha();
	  }
	}
	
	//true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar 
	public boolean InsertarSimbolo(String identificador, int numLinea){
		RegistroSimbolo simbolo;
		if(tabla.containsKey(identificador)){
			return false;
		}else{
			simbolo= new RegistroSimbolo(identificador,numLinea,direccion++);
			tabla.put(identificador,simbolo);
			return true;			
		}
	}
	
	public RegistroSimbolo BuscarSimbolo(String identificador){
		RegistroSimbolo simbolo=(RegistroSimbolo)tabla.get(identificador);
		return simbolo;
	}
	
	public void ImprimirClaves(){
		System.out.println("*** Tabla de Simbolos ***");
		for( Iterator <String>it = tabla.keySet().iterator(); it.hasNext();) { 
            String s = (String)it.next();
	    System.out.println("Consegui Key: "+s+" con direccion: " + BuscarSimbolo(s).getDireccionMemoria());
		}
	}

	public int getDireccion(String Clave){
		return BuscarSimbolo(Clave).getDireccionMemoria();
	}
	
	/*
	 * TODO:
	 * 1. Crear lista con las lineas de codigo donde la variable es usada.
	 * */
}

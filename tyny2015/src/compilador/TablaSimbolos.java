package compilador;

import java.util.*;

import ast.NodoAsignacion;
import ast.NodoBase;
import ast.NodoDeclararVariable;
import ast.NodoEscribir;
import ast.NodoIdentificador;
import ast.NodoIf;
import ast.NodoOperacion;
import ast.NodoRepeat;
import ast.NodoTipo;
import ast.NodoFor;
import ast.NodoFunction;
import ast.NodoProcedure;
import ast.NodollamaFunction;
import ast.NodollamaProcedure;
import ast.NodoFuncionR;
import ast.NodoParametro;
import ast.NodoVector;

public class TablaSimbolos {

    private HashMap<String, RegistroSimbolo> tabla;
    private int direccion;  //Contador de las localidades de memoria asignadas a la tabla

    public TablaSimbolos() {
        super();
        tabla = new HashMap<String, RegistroSimbolo>();
        direccion = 0;
    }

    public void cargarTabla(NodoBase raiz) {
        while (raiz != null) {
            if (raiz instanceof NodoIdentificador) {
                InsertarSimbolo(((NodoIdentificador) raiz).getNombre(), -1, null);
                //TODO: A�adir el numero de linea y localidad de memoria correcta
            }

            /* Hago el recorrido recursivo */
            if (raiz instanceof NodoIf) {
                cargarTabla(((NodoIf) raiz).getPrueba());
                cargarTabla(((NodoIf) raiz).getParteThen());
                if (((NodoIf) raiz).getParteElse() != null) {
                    cargarTabla(((NodoIf) raiz).getParteElse());
                }
            } else if (raiz instanceof NodoRepeat) {
                cargarTabla(((NodoRepeat) raiz).getCuerpo());
                cargarTabla(((NodoRepeat) raiz).getPrueba());
            } else if (raiz instanceof NodoAsignacion) {
                cargarTabla(((NodoAsignacion) raiz).getOperacion());
                cargarTabla(((NodoAsignacion) raiz).getVector());
            } else if (raiz instanceof NodoEscribir) {
                cargarTabla(((NodoEscribir) raiz).getExpresion());
            } else if (raiz instanceof NodoOperacion) {
                cargarTabla(((NodoOperacion) raiz).getOpIzquierdo());
                cargarTabla(((NodoOperacion) raiz).getOpDerecho());
            } else if (raiz instanceof NodoFor) {
                cargarTabla(((NodoFor) raiz).getComprobacion());
                cargarTabla(((NodoFor) raiz).getInicio());
                cargarTabla(((NodoFor) raiz).getPaso());
                cargarTabla(((NodoFor) raiz).getSeq_sent());
            } else if (raiz instanceof NodoFunction) {

                cargarTabla(((NodoFunction) raiz).getParametros());
                cargarTabla(((NodoFunction) raiz).getSeq_sent());
                cargarTabla(((NodoFunction) raiz).getRetorna());
                
                obtenerTipoFuncion(((NodoFunction)raiz).getTipo(),((NodoFunction)raiz).getNombre());
                

            } else if (raiz instanceof NodoProcedure) {
                cargarTabla(((NodoProcedure) raiz).getNombre());
                cargarTabla(((NodoProcedure) raiz).getParametros());
                cargarTabla(((NodoProcedure) raiz).getSeq_sent());
            } else if (raiz instanceof NodollamaFunction) {
                cargarTabla(((NodollamaFunction) raiz).getNombre());
                cargarTabla(((NodollamaFunction) raiz).getParametros());
            } else if (raiz instanceof NodollamaProcedure) {
                cargarTabla(((NodollamaProcedure) raiz).getParametros());
            } else if (raiz instanceof NodoFuncionR) {
                cargarTabla(((NodoFuncionR) raiz).getParametros());
            } else if (raiz instanceof NodoParametro) {
                
                //cargarTabla(((NodoParametro) raiz).getID());
                //cargarTabla(((NodoParametro) raiz).getTipo());
                
                obtenerTipoParametro(((NodoParametro) raiz).getID(),((NodoParametro) raiz).getTipo());
               
                
                
            } else if (raiz instanceof NodoDeclararVariable) {

                obtenerTipo(((NodoDeclararVariable) raiz).getTipo(), ((NodoDeclararVariable) raiz).getId());

            } else if (raiz instanceof NodoVector) {
                cargarTabla(((NodoVector) raiz).getId());
                //cargarTabla(((NodoVector)raiz).getIndice());
            }
            raiz = raiz.getHermanoDerecha();
        }
    }

    //true es nuevo no existe se insertara, false ya existe NO se vuelve a insertar 
    public boolean InsertarSimbolo(String identificador, int numLinea, String tipo) {
        RegistroSimbolo simbolo;
        if (tabla.containsKey(identificador)) {
            return false;
        } else {
            simbolo = new RegistroSimbolo(identificador, numLinea, direccion++, tipo);
            tabla.put(identificador, simbolo);
            return true;
        }
    }

    public RegistroSimbolo BuscarSimbolo(String identificador) {
        RegistroSimbolo simbolo = (RegistroSimbolo) tabla.get(identificador);
        return simbolo;
    }

    public void ImprimirClaves() {
        System.out.println("*** Tabla de Simbolos ***");
        for (Iterator<String> it = tabla.keySet().iterator(); it.hasNext();) {
            String s = (String) it.next();
            System.out.println("Consegui Key: " + s + " con direccion: " + BuscarSimbolo(s).getDireccionMemoria());
            System.out.println("tipo: " + BuscarSimbolo(s).getTipo());
        }
    }

    public int getDireccion(String Clave) {
        return BuscarSimbolo(Clave).getDireccionMemoria();
    }

    /*
     * TODO:
     * 1. Crear lista con las lineas de codigo donde la variable es usada.
     * */
    private void obtenerTipo(NodoBase nodoT, NodoBase nodoI) {
        String tipo = ((NodoTipo) nodoT).getTipo();
        while (nodoI != null) {

            if (nodoI instanceof NodoIdentificador) {
                String identificador = ((NodoIdentificador) nodoI).getNombre();
                InsertarSimbolo(identificador, -1, tipo);
            } else if (nodoI instanceof NodoVector) {
                NodoBase vector = ((NodoVector) nodoI).getId();
                String nombre = ((NodoIdentificador) vector).getNombre();
                InsertarSimbolo(nombre, -1, tipo);
            }
            nodoI = nodoI.getHermanoDerecha();
        }
    }

    private void obtenerTipoFuncion(NodoBase nodoT, NodoBase nodoN) {
       
        String tipo = ((NodoTipo) nodoT).getTipo();
        String nombre = ((NodoIdentificador) nodoN).getNombre();
        if (!tipo.isEmpty())
            InsertarSimbolo(nombre, -1, tipo);
        else
            InsertarSimbolo(nombre, -1, "void");
    }

    private void obtenerTipoParametro(NodoBase nodoI, NodoBase nodoT) {

        if (((NodoTipo)nodoT)!=null) {
            
        
        String tipo = ((NodoTipo)nodoT).getTipo();
        while (nodoI != null) {            
           String identificador = ((NodoIdentificador)nodoI).getNombre();
            InsertarSimbolo(identificador, -1, tipo);
            
            nodoI =  nodoI.getHermanoDerecha();
        }
        
        }
        
    }
}

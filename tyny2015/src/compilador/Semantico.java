/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compilador;

import ast.NodoAsignacion;
import ast.NodoBase;
import ast.NodoBoolean;
import ast.NodoEscribir;
import ast.NodoFor;
import ast.NodoFunction;
import ast.NodoIdentificador;
import ast.NodoIf;
import ast.NodoLeer;
import ast.NodoOperacion;
import ast.NodoParametro;
import ast.NodoProcedure;
import ast.NodoRepeat;
import ast.NodoValor;
import ast.NodollamaFunction;
import ast.NodollamaProcedure;

/**
 *
 * @author miguelcardenas
 * @author yacson ramirez
 * @author yormnan castellanos
 * @author jorge gomez
 */
public class Semantico {
    
    public void iniciarSemantico(NodoBase nodo){
        NodoBase raiz =  nodo;
        
        while (raiz != null) {            
            if (raiz instanceof NodoEscribir) {
                nodoEscribir(((NodoEscribir)raiz));
            } else if (raiz instanceof NodoLeer) {
                nodoLeer(((NodoLeer)raiz));
            } else if (raiz instanceof NodoIf) {
                nodoIf(((NodoIf)raiz));
            } else if (raiz instanceof  NodoFor) {
                nodoFor (((NodoFor)raiz));
            } else if (raiz instanceof NodoOperacion){
                nodoOperacion (((NodoOperacion)raiz));
            } else if (raiz instanceof NodoRepeat) {
                nodoRepeat (((NodoRepeat)raiz));
            } else if ( raiz instanceof NodoAsignacion) {
                nodoAsignacion (((NodoAsignacion)raiz));
            } else if (raiz instanceof NodoFunction){
                nodoFunction (((NodoFunction)raiz));
            } else if (raiz instanceof NodoProcedure){
                nodoProcedure (((NodoProcedure)raiz));
            } else if (raiz instanceof NodoParametro){
                nodoParametro (((NodoParametro)raiz));
            } else if (raiz instanceof NodoIdentificador) {
                nodoIdentificador(((NodoIdentificador)raiz));
            } else if(raiz instanceof NodoValor){
                nodoValor(((NodoValor)raiz));
            } else if(raiz instanceof NodoBoolean ){
                nodoBoolean(((NodoBoolean)raiz));
            }else if (raiz instanceof NodollamaProcedure){
                nodollamaProcedure (((NodollamaProcedure)raiz));
            } else if (raiz instanceof NodollamaFunction){
                nodollamaFunction (((NodollamaFunction)raiz));
            }
            
            raiz =  raiz.getHermanoDerecha();
        }
        
    }

    private void nodoEscribir(NodoEscribir nodoEscribir) {

         NodoBase nodo = nodoEscribir.getExpresion();
         if (nodo instanceof NodoIdentificador ){
             System.out.println("se puede escribir una variable");
         }else if(nodo instanceof NodoValor){
             System.out.println("se puede escribir un numero");
         }
        
    }

    private void nodoLeer(NodoLeer nodoLeer) {

        
    
    }

    private void nodoIf(NodoIf nodoIf) {
       
        NodoBase nodo = nodoIf.getPrueba();
        if (nodo != null) {
            iniciarSemantico(nodoIf.getParteThen());
        } else {
            iniciarSemantico(nodoIf.getParteElse());
        }
        
    }

    private void nodoFor(NodoFor nodoFor) {

        
        
    }

    private void nodoOperacion(NodoOperacion nodoOperacion) {

        
    
    }

    private void nodoRepeat(NodoRepeat nodoRepeat) {
        
        
    
    }

    private void nodoAsignacion(NodoAsignacion nodoAsignacion) {

        
    
    }

    private void nodoFunction(NodoFunction nodoFunction) {

        
        
    }

    private void nodoProcedure(NodoProcedure nodoProcedure) {

        
    
    }

    private void nodoParametro(NodoParametro nodoParametro) {

        
    
    }

    private void nodollamaProcedure(NodollamaProcedure nodollamaProcedure) {

        
        
    }

    private void nodollamaFunction(NodollamaFunction nodollamaFunction) {

        
    
    }

    private void nodoIdentificador(NodoIdentificador nodoIdentificador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void nodoValor(NodoValor nodoValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void nodoBoolean(NodoBoolean nodoBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

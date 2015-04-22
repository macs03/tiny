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
    private NodoBase raiz;
    private TablaSimbolos ts;
    private boolean valido;

    public Semantico(NodoBase raiz, TablaSimbolos ts) {
        this.raiz = raiz;
        this.ts = ts;
        this.valido=true;
        iniciarSemantico(raiz);
    }
    
    
    
    public void iniciarSemantico(NodoBase raiz){
               
        while (raiz != null && valido) {            
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
                System.out.println("aquiii");
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
             nodoIdentificador((NodoIdentificador) nodo);
         
         }
        
    }

    private void nodoLeer(NodoLeer nodoLeer) {

         NodoBase nodo = nodoLeer.getIdentificador();
         if (nodo instanceof NodoIdentificador ){
             nodoIdentificador((NodoIdentificador) nodo);
         
         }
    
    }

    private void nodoIf(NodoIf nodoIf) {
       
        nodoOperacion((NodoOperacion) nodoIf.getPrueba());
        if (nodoIf != null) {
            iniciarSemantico(nodoIf.getParteThen());
        } else {
            iniciarSemantico(nodoIf.getParteElse());
        }
        
    }

    private void nodoFor(NodoFor nodoFor) {

        nodoAsignacion((NodoAsignacion) nodoFor.getInicio());
        nodoOperacion((NodoOperacion) nodoFor.getComprobacion());
        nodoAsignacion((NodoAsignacion) nodoFor.getPaso());
        iniciarSemantico(nodoFor.getSeq_sent());
    }

    private void nodoOperacion(NodoOperacion nodoOperacion) {

        if(nodoOperacion.getOpIzquierdo() instanceof NodoIdentificador){
            nodoIdentificador((NodoIdentificador) nodoOperacion.getOpIzquierdo());
        }
        
        if(nodoOperacion.getOpDerecho()instanceof NodoIdentificador){
            nodoIdentificador((NodoIdentificador) nodoOperacion.getOpDerecho());
        }
        
        if(nodoOperacion.getOpDerecho()instanceof NodoOperacion){
            nodoOperacion((NodoOperacion) nodoOperacion.getOpDerecho());
        }
    }

    private void nodoRepeat(NodoRepeat nodoRepeat) {
        
        iniciarSemantico(nodoRepeat.getCuerpo());
        nodoOperacion((NodoOperacion) nodoRepeat.getPrueba());
    
    }

    private void nodoAsignacion(NodoAsignacion nodoAsignacion) {
      
        nodoIdentificador((NodoIdentificador) nodoAsignacion.getIdentificador());
        if(nodoAsignacion.getOperacion() instanceof NodoOperacion){
            nodoOperacion((NodoOperacion) nodoAsignacion.getOperacion());
        }
        
        if(nodoAsignacion.getOperacion() instanceof NodoIdentificador){
             nodoIdentificador((NodoIdentificador) nodoAsignacion.getOperacion());
        }
    }

    private void nodoFunction(NodoFunction nodoFunction) {

        nodoIdentificador((NodoIdentificador) nodoFunction.getNombre());
        nodoParametro( nodoFunction.getParametros());
        iniciarSemantico(nodoFunction.getSeq_sent());
        
        if(nodoFunction.getRetorna() instanceof NodoOperacion){
            nodoOperacion((NodoOperacion) nodoFunction.getRetorna());
        }else if(nodoFunction.getRetorna() instanceof NodoIdentificador){
            nodoIdentificador((NodoIdentificador) nodoFunction.getRetorna());
        }
        
        
    }

    private void nodoProcedure(NodoProcedure nodoProcedure) {

        nodoIdentificador((NodoIdentificador) nodoProcedure.getNombre());
        nodoParametro( nodoProcedure.getParametros());
        iniciarSemantico(nodoProcedure.getSeq_sent());
    
    }

    private void nodoParametro(NodoBase nodo) {
        
        while(nodo!=null){
           if(nodo instanceof NodoParametro){
                NodoParametro np = ((NodoParametro)nodo);
           }
            nodo=nodo.getHermanoDerecha();
        }
    
    }

    private void nodollamaProcedure(NodollamaProcedure nodollamaProcedure) {

        
        
    }

    private void nodollamaFunction(NodollamaFunction nodollamaFunction) {

        nodoIdentificador((NodoIdentificador) nodollamaFunction.getNombre());
        NodoBase par = nodollamaFunction.getParametros();
        if(par!=null){
            if(par instanceof NodoIdentificador){
                nodoIdentificador((NodoIdentificador) par);
            }
            par.getHermanoDerecha();
        }
        
    }

    private void nodoIdentificador(NodoIdentificador nodoIdentificador) {
        
        if(ts.BuscarSimbolo(nodoIdentificador.getNombre()).getTipo()==null){
            
            System.out.println("La variable ("+nodoIdentificador.getNombre()+") no a sido declarada");
            valido=false;
        }
        
    
    }

    private void nodoValor(NodoValor nodoValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void nodoBoolean(NodoBoolean nodoBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
  
    
}

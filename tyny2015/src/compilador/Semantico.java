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
import ast.NodoVector;
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
    private String tipo_dato = null;

    public Semantico(NodoBase raiz, TablaSimbolos ts) {
        this.raiz = raiz;
        this.ts = ts;
        this.valido = true;
        iniciarSemantico(raiz);
    }

    public void iniciarSemantico(NodoBase raiz) {

        while (raiz != null && valido) {
            if (raiz instanceof NodoEscribir) {
                nodoEscribir(((NodoEscribir) raiz));
            } else if (raiz instanceof NodoLeer) {
                nodoLeer(((NodoLeer) raiz));
            } else if (raiz instanceof NodoIf) {
                nodoIf(((NodoIf) raiz));
            } else if (raiz instanceof NodoFor) {
                nodoFor(((NodoFor) raiz));
            } else if (raiz instanceof NodoOperacion) {
                nodoOperacion(((NodoOperacion) raiz));
            } else if (raiz instanceof NodoRepeat) {
                nodoRepeat(((NodoRepeat) raiz));
            } else if (raiz instanceof NodoAsignacion) {
                nodoAsignacion(((NodoAsignacion) raiz));
            } else if (raiz instanceof NodoFunction) {
                nodoFunction(((NodoFunction) raiz));
            } else if (raiz instanceof NodoProcedure) {
                nodoProcedure(((NodoProcedure) raiz));
            } else if (raiz instanceof NodoParametro) {
                nodoParametro(((NodoParametro) raiz));
            } else if (raiz instanceof NodoIdentificador) {
                System.out.println("aquiii");
                nodoIdentificador(((NodoIdentificador) raiz));
            } else if (raiz instanceof NodoValor) {
                nodoValor(((NodoValor) raiz));
            } else if (raiz instanceof NodoBoolean) {
                nodoBoolean(((NodoBoolean) raiz));
            } else if (raiz instanceof NodollamaProcedure) {
                nodollamaProcedure(((NodollamaProcedure) raiz));
            } else if (raiz instanceof NodollamaFunction) {
                nodollamaFunction(((NodollamaFunction) raiz));
            }else if (raiz instanceof NodoVector) {
                nodovector(((NodoVector) raiz));
            }

            raiz = raiz.getHermanoDerecha();
        }

    }

    private void nodoEscribir(NodoEscribir nodoEscribir) {

        NodoBase nodo = nodoEscribir.getExpresion();
        if (nodo instanceof NodoIdentificador) {
            nodoIdentificador((NodoIdentificador) nodo);

        }

    }

    private void nodoLeer(NodoLeer nodoLeer) {

        NodoBase nodo = nodoLeer.getIdentificador();
        if (nodo instanceof NodoIdentificador) {
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
        String tipo = null;
        switch(nodoOperacion.getOperacion().toString()){
            case "menor":
            case "mayor":
            case "igual":               
            case "mas":               
            case "menos":                
            case "por":                
            case "entre": 
            case "mayorigual":
            case "menorigual":
                tipo = "int";
                break;
                
            case "diferente":
            case "igualigual":
                String nodo_tipo = ((NodoIdentificador) nodoOperacion.getOpIzquierdo()).getNombre();
                tipo = ts.BuscarSimbolo(nodo_tipo).getTipo();
                break;
                
            case "and":
            case "or":
                tipo = "boolean";
                break;
        }
        
        if (nodoOperacion.getOpIzquierdo() instanceof NodoIdentificador) {
            nodoIdentificador((NodoIdentificador) nodoOperacion.getOpIzquierdo());
            if (valido) {
                    String aux = null;
                    String nodo_tipo = ((NodoIdentificador) nodoOperacion.getOpIzquierdo()).getNombre();
                    aux = ts.BuscarSimbolo(nodo_tipo).getTipo();
                    if (!aux.equals(tipo)) {
                        valido = false;
                        System.out.println("Los datos no tienen el mismo tipo");
                    }
                
            }
        }

        if (nodoOperacion.getOpIzquierdo() instanceof NodoValor) {
            
            if (valido) {
                
                if (!tipo.equals("int")) {
                    valido = false;
                    System.out.println("Tipo de datos no compatibles");
                }
            }
        }
        if (nodoOperacion.getOpDerecho() instanceof NodoValor) {

            if (valido) {
                if (!tipo.equals("int")) {
                    valido = false;
                    System.out.println("Tipo de datos no compatibles");
                }
                
                
            }
        }
        
         if (nodoOperacion.getOpIzquierdo() instanceof NodoBoolean) {

            if (valido) {  
                if (!tipo.equals("boolean")) {
                    valido = false;
                    System.out.println("Tipo de datos no compatibles");
                }
            }
        }

        if (nodoOperacion.getOpDerecho() instanceof NodoBoolean) {

            if (valido) {
                if (!tipo.equals("boolean")) {
                    valido = false;
                    System.out.println("Tipo de datos no compatibles");
                }
            }
        }
        if(nodoOperacion.getOpIzquierdo() instanceof NodoVector){
            
            nodovector((NodoVector) nodoOperacion.getOpIzquierdo());
            NodoVector nodo_vector=(NodoVector) nodoOperacion.getOpIzquierdo();
            NodoIdentificador nodo = ((NodoIdentificador)nodo_vector.getId());
             String aux = null;
            
                if (valido) {
                    
                    aux = nodo.getNombre();
                    aux = ts.BuscarSimbolo(aux).getTipo();
                    if (!aux.equals(tipo)) {
                        valido = false;
                        System.out.println("Los datos no tienen el mismo tipo");
                    }
                }
        }
        
        if(nodoOperacion.getOpDerecho()instanceof NodoVector){
            
            nodovector((NodoVector) nodoOperacion.getOpDerecho());
            NodoVector nodo_vector=(NodoVector) nodoOperacion.getOpDerecho();
            NodoIdentificador nodo = ((NodoIdentificador)nodo_vector.getId());
            String aux = null;
            
                if (valido) {
                    
                    aux = nodo.getNombre();
                    aux = ts.BuscarSimbolo(aux).getTipo();
                    if (!aux.equals(tipo)) {
                        valido = false;
                        System.out.println("Los datos no tienen el mismo tipo");
                    }
                }
        }
        
        
        if (nodoOperacion.getOpDerecho() instanceof NodoIdentificador) {
            nodoIdentificador((NodoIdentificador) nodoOperacion.getOpDerecho());
            String aux = null;
            if (valido) {
                String nodo_tipo = ((NodoIdentificador) nodoOperacion.getOpDerecho()).getNombre();
                aux = ts.BuscarSimbolo(nodo_tipo).getTipo();
                if (!aux.equals(tipo)) {
                    valido = false;
                    System.out.println("Los datos no tienen el mismo tipo");
                }
            }

        }

        if (nodoOperacion.getOpDerecho() instanceof NodollamaFunction) {
            nodollamaFunction((NodollamaFunction) nodoOperacion.getOpDerecho());
            if (valido) {
                NodollamaFunction nodo = (NodollamaFunction) nodoOperacion.getOpDerecho();
                NodoIdentificador nodo1 = (NodoIdentificador) nodo.getNombre();
                String tp = ts.BuscarSimbolo(nodo1.getNombre()).getTipo();

                if (tp.equals("void")) {
                    valido = false;
                    System.out.println("No se puede hacer la operacion con funcion void");
                } else {
                    if (!tipo.equals("")) {
                        tipo = tp;

                    } else {
                        if (!tp.equals(tipo)) {
                            valido = false;
                            System.out.println("Tipo de datos incompatibles");
                        }
                    }
                }
            }
            String aux = null;
            if (valido) {
                String nodo_tipo = ((NodoIdentificador) nodoOperacion.getOpDerecho()).getNombre();
                aux = ts.BuscarSimbolo(nodo_tipo).getTipo();
                if (!aux.equals(tipo)) {
                    valido = false;
                    System.out.println("Los datos no tienen el mismo tipo");
                }
            }

        }

        if (nodoOperacion.getOpIzquierdo() instanceof NodollamaFunction) {
            nodollamaFunction((NodollamaFunction) nodoOperacion.getOpIzquierdo());
            if (valido) {
                NodollamaFunction nodo = (NodollamaFunction) nodoOperacion.getOpIzquierdo();
                NodoIdentificador nodo1 = (NodoIdentificador) nodo.getNombre();
                String tp = ts.BuscarSimbolo(nodo1.getNombre()).getTipo();

                if (tp.equals("void")) {
                    valido = false;
                    System.out.println("No se puede hacer la operacion con funcion void");
                } else {
                    if (!tp.equals(tipo)) {
                        valido = false;
                        System.out.println("Los datos no tienen el mismo tipo");
                    }
                }
            }
            String aux = null;
            if (valido) {
                String nodo_tipo = ((NodoIdentificador) nodoOperacion.getOpDerecho()).getNombre();
                aux = ts.BuscarSimbolo(nodo_tipo).getTipo();
                if (!aux.equals(tipo)) {
                    valido = false;
                    System.out.println("Los datos no tienen el mismo tipo");
                }
            }

        } 
        
        if (nodoOperacion.getOpIzquierdo() instanceof NodoOperacion) {
            String nodo_tipo = ((NodoIdentificador) nodoOperacion.getOpIzquierdo()).getNombre();
            String aux2 = ts.BuscarSimbolo(nodo_tipo).getTipo();
            if (!aux2.equals(tipo)) {
                valido = false;
                System.out.println("Ambos datos deben ser de tipo "+tipo);
            }else{
                nodoOperacion((NodoOperacion) nodoOperacion.getOpIzquierdo());
            }            
        }
        
        if (nodoOperacion.getOpDerecho() instanceof NodoOperacion) {
            String nodo_tipo = ((NodoIdentificador) nodoOperacion.getOpDerecho()).getNombre();
            String aux2 = ts.BuscarSimbolo(nodo_tipo).getTipo();
            if (!aux2.equals(tipo)) {
                valido = false;
                System.out.println("Ambos datos deben ser de tipo "+tipo);
            }else{
                nodoOperacion((NodoOperacion) nodoOperacion.getOpDerecho());
            }
        }
    }

    private void nodoRepeat(NodoRepeat nodoRepeat) {

        iniciarSemantico(nodoRepeat.getCuerpo());
        nodoOperacion((NodoOperacion) nodoRepeat.getPrueba());

    }

    private void nodoAsignacion(NodoAsignacion nodoAsignacion) {
        String tipo=null;
        if (nodoAsignacion.getVector() == null) {

            nodoIdentificador((NodoIdentificador) nodoAsignacion.getIdentificador());
            String nodo_tipo = ((NodoIdentificador) nodoAsignacion.getIdentificador()).getNombre();
            tipo = ts.BuscarSimbolo(nodo_tipo).getTipo();
            //System.out.println("tipo: "+tipo);
        }else if(nodoAsignacion.getVector()!=null){
            nodovector((NodoVector) nodoAsignacion.getVector());
            NodoVector nodo_vector=(NodoVector) nodoAsignacion.getVector();
            String nodo_tipo = ((NodoIdentificador)nodo_vector.getId()).getNombre();
            tipo = ts.BuscarSimbolo(nodo_tipo).getTipo();
           
            
        }
        
        if (nodoAsignacion.getOperacion() instanceof NodoVector) {

            nodovector((NodoVector) nodoAsignacion.getOperacion());
            NodoVector nodo_vector=(NodoVector) nodoAsignacion.getOperacion();
            NodoIdentificador nodo = ((NodoIdentificador)nodo_vector.getId());
             String aux = null;
            
                if (valido) {
                    aux = nodo.getNombre();
                    aux = ts.BuscarSimbolo(aux).getTipo();
                    if (!aux.equals(tipo)) {
                        valido = false;
                        System.out.println("Los datos no tienen el mismo tipo");
                    }
                }
            }
            if (nodoAsignacion.getOperacion() instanceof NodoOperacion) {
                nodoOperacion((NodoOperacion) nodoAsignacion.getOperacion());
            }

            if (nodoAsignacion.getOperacion() instanceof NodoIdentificador) {

                nodoIdentificador((NodoIdentificador) nodoAsignacion.getOperacion());
                NodoIdentificador nodo = (NodoIdentificador) nodoAsignacion.getOperacion();
                String aux = null;

                if (valido) {
                    aux = nodo.getNombre();
                    aux = ts.BuscarSimbolo(aux).getTipo();
                    if (!aux.equals(tipo)) {
                        valido = false;
                        System.out.println("Los datos no tienen el mismo tipo");
                    }
                }
            }
            if (nodoAsignacion.getOperacion() instanceof NodoValor) {
                if (!tipo.equals("int")) {
                    System.out.println("Tipo de datos no compatibles");
                    valido = false;
                }
            }
            if (nodoAsignacion.getOperacion() instanceof NodoBoolean) {

                if (!tipo.equals("boolean")) {
                    valido = false;
                    System.out.println("Tipo de datos no compatibles");
                }
            }
        
    }

    private void nodoFunction(NodoFunction nodoFunction) {

        nodoIdentificador((NodoIdentificador) nodoFunction.getNombre());
        nodoParametro(nodoFunction.getParametros());
        iniciarSemantico(nodoFunction.getSeq_sent());

        if (nodoFunction.getRetorna() instanceof NodoOperacion) {
            nodoOperacion((NodoOperacion) nodoFunction.getRetorna());
        } else if (nodoFunction.getRetorna() instanceof NodoIdentificador) {
            nodoIdentificador((NodoIdentificador) nodoFunction.getRetorna());
        }

    }

    private void nodoProcedure(NodoProcedure nodoProcedure) {

        nodoIdentificador((NodoIdentificador) nodoProcedure.getNombre());
        nodoParametro(nodoProcedure.getParametros());
        iniciarSemantico(nodoProcedure.getSeq_sent());

    }

    private void nodoParametro(NodoBase nodo) {

        while (nodo != null) {
            if (nodo instanceof NodoParametro) {
                NodoParametro np = ((NodoParametro) nodo);
            }
            nodo = nodo.getHermanoDerecha();
        }

    }

    private void nodollamaProcedure(NodollamaProcedure nodollamaProcedure) {

    }

    private void nodollamaFunction(NodollamaFunction nodollamaFunction) {

        nodoIdentificador((NodoIdentificador) nodollamaFunction.getNombre());
        NodoBase par = nodollamaFunction.getParametros();
        if (par != null) {
            if (par instanceof NodoIdentificador) {
                nodoIdentificador((NodoIdentificador) par);
            }
            par.getHermanoDerecha();
        }

    }

    private void nodoIdentificador(NodoIdentificador nodoIdentificador) {

        if (ts.BuscarSimbolo(nodoIdentificador.getNombre()).getTipo() == null) {

            System.out.println("La variable (" + nodoIdentificador.getNombre() + ") no a sido declarada");
            valido = false;
        }

    }

    private void nodoValor(NodoValor nodoValor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void nodoBoolean(NodoBoolean nodoBoolean) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void nodovector(NodoVector nodoVector) {
         nodoIdentificador((NodoIdentificador) nodoVector.getId());
    }

}

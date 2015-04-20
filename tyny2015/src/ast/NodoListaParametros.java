/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

import java.util.ArrayList;

/**
 *
 * @author jurado
 */
public class NodoListaParametros extends NodoBase{
    
    private ArrayList<NodoBase> lista_parametro;

    public NodoListaParametros(ArrayList<NodoBase> lista_parametro) {
        super();
        this.lista_parametro = lista_parametro;
    }
    
     public NodoListaParametros() {
        super();
        this.lista_parametro = null;
    }

    public ArrayList<NodoBase> getLista_parametro() {
        return lista_parametro;
    }

    public void setLista_parametro(ArrayList<NodoBase> lista_parametro) {
        this.lista_parametro = lista_parametro;
    }
    
    
   

    
    
}

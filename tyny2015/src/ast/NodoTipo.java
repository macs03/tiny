/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ast;

/**
 *
 * @author yacson.ramirez
 */
public class NodoTipo extends NodoBase{
    private String tipo;

    public NodoTipo(String tipo) {
        super();
        this.tipo = tipo;
    }
     public NodoTipo() {
        super();
        this.tipo = null;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
     
    
}



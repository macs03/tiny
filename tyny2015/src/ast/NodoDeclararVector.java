/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ast;

/**
 *
 * @author miguel.cardenas
 */
public class NodoDeclararVector extends NodoBase{
    
    private NodoBase Tipo;
    private NodoBase vector;
    

    public NodoDeclararVector(NodoBase Tipo, NodoBase vector ) {
        super();
        this.Tipo = Tipo;
        this.vector = vector;
        
    }

    public NodoDeclararVector() {
        super();
        this.vector = null;
        this.Tipo = null;
    }

    public NodoBase getvector() {
        return vector;
    }

    public void setIndice(NodoBase vector) {
        this.vector = vector;
    }

    public NodoBase getTipo() {
        return Tipo;
    }

    public void setTipo(NodoBase Tipo) {
        this.Tipo = Tipo;
    }
    
    
    
    
    
}

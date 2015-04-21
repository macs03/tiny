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
public class NodoDeclararVariable extends NodoBase{
    private NodoBase Tipo;
    private NodoBase id;

    public NodoDeclararVariable(NodoBase Tipo, NodoBase id) {
        super();
        this.Tipo = Tipo;
        this.id = id;
    }
    
    public NodoDeclararVariable() {
        super();
        this.Tipo = null;
        this.id = null;
    }

    public NodoBase getTipo() {
        return Tipo;
    }

    public void setTipo(NodoBase Tipo) {
        this.Tipo = Tipo;
    }

    public NodoBase getId() {
        return id;
    }

    public void setId(NodoBase id) {
        this.id = id;
    }
    
    
}

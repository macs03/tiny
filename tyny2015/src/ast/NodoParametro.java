/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author jurado
 */
public class NodoParametro extends NodoBase{
    
    private String tipo;
    private NodoBase ID;

    public NodoParametro(String tipo, NodoBase ID) {
        super();
        this.tipo = tipo;
        this.ID = ID;
    }

    public NodoParametro() {
        super();
        this.tipo = null;
        this.ID = null;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NodoBase getID() {
        return ID;
    }

    public void setID(NodoBase ID) {
        this.ID = ID;
    }
    
    
    
    
}

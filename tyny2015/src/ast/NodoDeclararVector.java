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
    
    private String id;
    private NodoBase indice;
    private String Tipo;

    public NodoDeclararVector(String id, NodoBase indice, String Tipo) {
        super();
        this.id = id;
        this.indice = indice;
        this.Tipo = Tipo;
    }

    public NodoDeclararVector() {
        super();
        this.id = null;
        this.indice = null;
        this.Tipo = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NodoBase getIndice() {
        return indice;
    }

    public void setIndice(NodoBase indice) {
        this.indice = indice;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
    
    
    
}

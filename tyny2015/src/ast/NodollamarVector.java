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
public class NodollamarVector extends NodoBase{
        
    private String id;
    private NodoBase Indice;
    
    public NodollamarVector(NodoBase Indice, String id) {
        super();
        this.Indice = Indice;
        this.id = id;
    }
    public NodollamarVector() {
        super();
        this.Indice = null;
        this.id = null;
    }

    public NodoBase getIndice() {
        return Indice;
    }

    public void setIndice(NodoBase Indice) {
        this.Indice = Indice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    
}

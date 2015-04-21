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
public class NodoVector extends NodoBase{
        
    private NodoBase id;
    private int Indice;
    
    public NodoVector( NodoBase id,int Indice) {
        super();
        this.Indice = Indice;
        this.id = id;
    }
    public NodoVector() {
        super();
        this.Indice = 0;
        this.id = null;
    }

    public int getIndice() {
        return Indice;
    }

    public void setIndice(int Indice) {
        this.Indice = Indice;
    }

    public NodoBase getId() {
        return id;
    }

    public void setId(NodoBase id) {
        this.id = id;
    }
    
    
    
    
}

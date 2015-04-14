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
public class NodoBoolean extends NodoBase{
    private boolean valor;

    public NodoBoolean(boolean valor) {
        super();
        this.valor = valor;
    }

    public NodoBoolean() {
        this.valor = false;
    }

    public boolean isValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }
    
    
    
    
}

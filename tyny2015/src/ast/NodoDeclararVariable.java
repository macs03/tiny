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
    private String Tipo;
    private String id;

    public NodoDeclararVariable(String Tipo, String id) {
        super();
        this.Tipo = Tipo;
        this.id = id;
    }
    
    public NodoDeclararVariable() {
        super();
        this.Tipo = null;
        this.id = null;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
}

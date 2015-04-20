/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ast;

/**
 *
 * @author miguelcardenas
 */
public class NodoFuncionR extends NodoBase{
    private String id;
    private NodoBase parametros;

    public NodoFuncionR(String id, NodoBase parametros, NodoBase hermanoDerecha) {
        super(hermanoDerecha);
        this.id = id;
        this.parametros = parametros;
    }

    public NodoFuncionR(String id, NodoBase parametros) {
        this.id = id;
        this.parametros = parametros;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public NodoBase getParametros() {
        return parametros;
    }

    public void setParametros(NodoBase parametros) {
        this.parametros = parametros;
    }
    
}

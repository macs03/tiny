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
public class NodollamaFunction extends NodoBase{
    
    private NodoBase nombre;
    private NodoBase parametros;

    public NodollamaFunction(NodoBase nombre, NodoBase parametros) {
        super();
        this.nombre = nombre;
        this.parametros = parametros;
    }

    public NodollamaFunction() {
        super();
        this.nombre = nombre;
        this.parametros = parametros;
    }

    public NodoBase getNombre() {
        return nombre;
    }

    public void setNombre(NodoBase nombre) {
        this.nombre = nombre;
    }

    public NodoBase getParametros() {
        return parametros;
    }

    public void setParametros(NodoBase parametros) {
        this.parametros = parametros;
    }
    
    
    
}

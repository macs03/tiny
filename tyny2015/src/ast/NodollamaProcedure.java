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
public class NodollamaProcedure extends NodoBase{
    
    private String nombre;
    private NodoBase parametros;

    public NodollamaProcedure(String nombre, NodoBase parametros) {
        super();
        this.nombre = nombre;
        this.parametros = parametros;
    }
    public NodollamaProcedure() {
        super();
        this.nombre = null;
        this.parametros = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public NodoBase getParametros() {
        return parametros;
    }

    public void setParametros(NodoBase parametros) {
        this.parametros = parametros;
    }
    
    
    
}

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
public class NodoProcedure extends NodoBase{
     private NodoBase nombre;
     private NodoBase parametros;
     private NodoBase seq_sent;

    public NodoProcedure(NodoBase nombre,NodoBase parametros, NodoBase seq_sent) {
        super();
        this.nombre = nombre;
        this.parametros = parametros;
        this.seq_sent = seq_sent;
    }

    public NodoProcedure() {
        super();
        this.nombre = null;
        this.parametros = null;
        this.seq_sent = null;
    }

    public NodoBase getParametros() {
        return parametros;
    }

    public void setParametros(NodoBase parametros) {
        this.parametros = parametros;
    }

    public NodoBase getSeq_sent() {
        return seq_sent;
    }

    public void setSeq_sent(NodoBase seq_sent) {
        this.seq_sent = seq_sent;
    }

    public NodoBase getNombre() {
        return nombre;
    }

    public void setNombre(NodoBase nombre) {
        this.nombre = nombre;
    }
    
    
    

     
    
     
     
}

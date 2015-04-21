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
public class NodoFunction extends NodoBase{
    
    private NodoBase Tipo;
    private NodoBase nombre;
    private NodoBase parametros;
    private NodoBase seq_sent;
    private NodoBase retorna;
    

    public NodoFunction(NodoBase Tipo, NodoBase nombre,NodoBase parametros, NodoBase seq_sent, NodoBase retorna) {
        super();
        this.nombre = nombre;
        this.parametros = parametros;
        this.seq_sent = seq_sent;
        this.retorna = retorna;
        this.Tipo = Tipo;
    }

    public NodoFunction() {
        super();
        this.nombre= nombre;
        this.parametros = null;
        this.seq_sent = null;
        this.retorna = null;
        this.Tipo=null;
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

    public NodoBase getRetorna() {
        return retorna;
    }

    public void setRetorna(NodoBase retorna) {
        this.retorna = retorna;
    }

    public NodoBase getNombre() {
        return nombre;
    }

    public void setNombre(NodoBase nombre) {
        this.nombre = nombre;
    }

    public NodoBase getTipo() {
        return Tipo;
    }

    public void setTipo(NodoBase Tipo) {
        this.Tipo = Tipo;
    }
    
    
    
    
    
}

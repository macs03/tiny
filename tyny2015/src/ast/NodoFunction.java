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
    
    private String Tipo;
    private String nombre;
    private NodoBase parametros;
    private NodoBase seq_sent;
    private NodoBase retorna;
    

    public NodoFunction(String Tipo, String nombre,NodoBase parametros, NodoBase seq_sent, NodoBase retorna) {
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    
    
    
    
}

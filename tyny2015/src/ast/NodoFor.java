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
public class NodoFor extends NodoBase{
    
    private NodoBase inicio;
    private NodoBase comprobacion;
    private NodoBase paso;
    private NodoBase seq_sent;

    public NodoFor(NodoBase inicio, NodoBase comprobacion, NodoBase paso, NodoBase seq_sent) {
        super();
        this.inicio = inicio;
        this.comprobacion = comprobacion;
        this.paso = paso;
        this.seq_sent = seq_sent;
    }

    public NodoFor() {
        this.inicio = null;
        this.comprobacion = null;
        this.paso = null;
        this.seq_sent = null;
    }

    public NodoBase getInicio() {
        return inicio;
    }

    public void setInicio(NodoBase inicio) {
        this.inicio = inicio;
    }

    public NodoBase getComprobacion() {
        return comprobacion;
    }

    public void setComprobacion(NodoBase comprobacion) {
        this.comprobacion = comprobacion;
    }

    public NodoBase getPaso() {
        return paso;
    }

    public void setPaso(NodoBase paso) {
        this.paso = paso;
    }

    public NodoBase getSeq_sent() {
        return seq_sent;
    }

    public void setSeq_sent(NodoBase seq_sent) {
        this.seq_sent = seq_sent;
    }
    
    
    
    
}

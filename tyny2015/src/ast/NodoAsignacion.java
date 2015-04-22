package ast;

public class NodoAsignacion extends NodoBase {

    private NodoBase identificador;
    private NodoBase operacion;
    private NodoBase vector;
    

    public NodoAsignacion(NodoBase identificador) {
        super();
        this.identificador = identificador;
        this.operacion = null;
    }

    public NodoAsignacion(NodoBase identificador, NodoBase expresion) {
        super();
        this.identificador = identificador;
        this.operacion = expresion;
        this.vector=null;
    }

    public NodoAsignacion(NodoBase vector, NodoBase operacion,String v) {
        super();
        this.vector = vector;
        this.operacion = operacion;
        this.identificador=null;
    }

    public NodoBase getIdentificador() {
        return identificador;
    }

    public void setIdentificador(NodoBase identificador) {
        this.identificador = identificador;
    }

    public NodoBase getOperacion() {
        return operacion;
    }

    public void setOperacion(NodoBase operacion) {
        this.operacion = operacion;
    }

    public NodoBase getVector() {
        return vector;
    }

    public void setVector(NodoBase vector) {
        this.vector = vector;
    }

}

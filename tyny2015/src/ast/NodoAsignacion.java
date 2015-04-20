package ast;

public class NodoAsignacion extends NodoBase {

    private String identificador;
    private NodoBase operacion;
    private NodoBase vector;
    

    public NodoAsignacion(String identificador) {
        super();
        this.identificador = identificador;
        this.operacion = null;
    }

    public NodoAsignacion(String identificador, NodoBase expresion) {
        super();
        this.identificador = identificador;
        this.operacion = expresion;
        this.vector=null;
    }

    public NodoAsignacion(NodoBase vector, NodoBase operacion) {
        super();
        this.vector = vector;
        this.operacion = operacion;
        this.identificador=null;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
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

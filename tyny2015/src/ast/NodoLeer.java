package ast;

public class NodoLeer extends NodoBase {
	private NodoBase id;

	public NodoLeer(NodoBase identificador) {
		super();
		this.id = identificador;
	}

	public NodoLeer() {
		super();
		id=null;
	}

	public NodoBase getIdentificador() {
		return id;
	}

	public void setExpresion(NodoBase identificador) {
		this.id = identificador;
	}

}

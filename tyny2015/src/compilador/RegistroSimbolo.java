package compilador;

public class RegistroSimbolo {
	private String identificador;
	private int NumLinea;
	private int DireccionMemoria;
        private String Tipo;
	
	public RegistroSimbolo(String identificador, int numLinea,
			int direccionMemoria, String tipo) {
		super();
		this.identificador = identificador;
		NumLinea = numLinea;
		DireccionMemoria = direccionMemoria;
                Tipo = tipo;
	}

	public String getIdentificador() {
		return identificador;
	}

        public String getTipo() {
            return Tipo;
        }

        public void setTipo(String Tipo) {
            this.Tipo = Tipo;
        }

	public int getNumLinea() {
		return NumLinea;
	}

	public int getDireccionMemoria() {
		return DireccionMemoria;
	}

	public void setDireccionMemoria(int direccionMemoria) {
		DireccionMemoria = direccionMemoria;
	}
}

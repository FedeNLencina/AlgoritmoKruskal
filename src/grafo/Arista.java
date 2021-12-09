package grafo;

public class Arista {

	private int inicial;
	private int terminal;
	private float peso;

	public Arista(int inicio, int terminal, float peso) {
		this.inicial = inicio;
		this.terminal = terminal;
		this.peso = peso;
	}

	public int getInicial() {
		return inicial;
	}

	public void setInicial(int inicial) {
		this.inicial = inicial;
	}

	public int getTerminal() {
		return terminal;
	}

	public void setTerminal(int terminal) {
		this.terminal = terminal;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String toString() {
		return "(" + inicial + "|" + terminal + ", " + peso + ")";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Arista other = (Arista) obj;
		return (inicial == other.inicial && terminal == other.terminal)
				|| (inicial == other.terminal && terminal == other.inicial)
						&& (Float.floatToIntBits(peso) == Float.floatToIntBits(other.peso));
	}

}

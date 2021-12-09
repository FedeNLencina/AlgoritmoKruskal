package grafo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Grafo {

	private ArrayList<Set<Integer>> vecinos;
	private ArrayList<Arista> aristas;
	private static int[] compConexas;
	private int cantVertices;

	
	public Grafo(int vertices) {

		cantVertices = vertices;
		aristas = new ArrayList<Arista>();
		vecinos = new ArrayList<Set<Integer>>(vertices);
		compConexas = new int[vertices];

		for (int i = 0; i < vertices; i++) {

			vecinos.add(new HashSet<Integer>());
			// al comienzo cada vertice pertenece a su propia componente conexa
			compConexas[i] = i;
		}
	}

	// -----------METODOS DE ARISTAS-----------------//

	//O(n)
	public void agregarArista(int i, int j, float peso) {
		
		verificarArista(i, j, "agregar");
		
		if (existeArista(i, j, peso)) {
			throw new IllegalArgumentException("Se intento agregar una arista ya existente: " + i + "|" + j + "|" + peso);
		}

		// -----------AGREGO A LISTA DE ARISTAS-----------------//

		Arista aristaNueva = new Arista(i, j, peso);

		int indice = buscarIndice(aristaNueva.getPeso());//O(n)
		if (indice == -1)
			aristas.add(aristaNueva); //O(1) amortizado
		else
			aristas.add(indice, aristaNueva); //O(n) 

		// -----------AGREGO A LISTA DE VECINOS-----------------//

		vecinos.get(i).add(j);
		vecinos.get(j).add(i);
	}
	
	//O(n)
	public void eliminarArista(int i, int j,float peso) {

		verificarArista(i, j, "eliminar");

		if (!existeArista(i, j,peso)) {
			throw new IllegalArgumentException("Se intento eliminar una arista no existente" + i + "|" + j + "|" + peso);
		}
		
		// -----------ELIMINO DE LISTA DE ARISTAS-----------------//
		
		Arista auxArista = new Arista(i, j, peso);		
		aristas.remove(auxArista);

		// -----------ELIMINO DE LISTA DE VECINOS-----------------//

		vecinos.get(i).remove(j);
		vecinos.get(j).remove(i);

	}
	//O(1)
	private void verificarArista(int i, int j, String tipo) {

		if (i == j)
			throw new IllegalArgumentException("Se intento " + tipo + " una arista con i = j : " + i + "|" + j);

		verificarVertice(i, tipo);
		verificarVertice(j, tipo);

	}
	
	public boolean existeArista(int i, int j,float peso) {

		Arista auxArista = new Arista(i, j, peso);
			if (aristas.contains(auxArista)) 
				return true && (vecinos.get(i).contains(j) && vecinos.get(j).contains(i));
		return false;
	}
	
	
	private int buscarIndice(float peso) {
		for (int indice = 0; indice < aristas.size(); indice++) {
			if (peso < aristas.get(indice).getPeso())
				return indice;
		}
		// en el caso de que sea el de mayor peso retorna -1
		return -1;
	}

	// -----------METODOS DE VERTICES-----------------//

	
	public Set<Integer> vecinos(int i) {

		verificarVertice(i, " un vertice ");

		return vecinos.get(i);
	}

	
	public int grado(int i) {

		verificarVertice(i, " un vertice ");

		return vecinos.get(i).size();
	}
	
	
	private void verificarVertice(int i, String tipo) {

		if (i < 0 || i >= cantVertices)
			throw new IllegalArgumentException("Se intento usar " + tipo + " con valores, fuera de rango: " + i);
	}

	// -----------GETTERS, SETTERS Y EQUALS-----------------//

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Grafo other = (Grafo) obj;
		return Objects.equals(aristas, other.aristas) && cantVertices == other.cantVertices
				&& Objects.equals(vecinos, other.vecinos);
	}

	public int GetVertices() {
		return cantVertices;
	}

	public ArrayList<Arista> GetAristas() {
		return aristas;
	}

	public int[] GetCompConexas() {
		return compConexas;
	}

}

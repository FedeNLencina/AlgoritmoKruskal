package prim;

import java.util.ArrayList;

import bfs.BFS;
import grafo.Arista;
import grafo.Grafo;


public class Prim {
		
		public static Grafo prim(Grafo g) {
			verificarGrafo(g);
			
			Grafo arbolGeneradorMinimo = new Grafo(g.GetVertices());
			
			if (g.GetVertices()==1) 
				return arbolGeneradorMinimo;
			
			@SuppressWarnings("unchecked")
			ArrayList<Arista> aristasPendientes = (ArrayList<Arista>) g.GetAristas().clone();
			
			ArrayList<Integer> verticesVisitados = new ArrayList<Integer>();
			
			verticesVisitados.add(aristasPendientes.get(0).getInicial());   
			
			ArrayList<Arista> aristasDisponibles;
			
			Arista aristaMenorPeso;
			
			while(verticesVisitados.size()<g.GetVertices()){ 
				
				aristasDisponibles = new ArrayList<Arista>();

				agregarAristasDisponibles(verticesVisitados,aristasPendientes,aristasDisponibles);
				
				aristaMenorPeso = aristasDisponibles.get(0);
				
				aristaMenorPeso = seleccionarAristaMenorPeso(aristaMenorPeso,aristasDisponibles);				

				arbolGeneradorMinimo.agregarArista(aristaMenorPeso.getInicial(), aristaMenorPeso.getTerminal(),aristaMenorPeso.getPeso());
				
				agregarVerticesVisitados(verticesVisitados,aristaMenorPeso); 

				aristasPendientes.remove(aristaMenorPeso);
				
			}
			return arbolGeneradorMinimo;
		}

		private static void verificarGrafo(Grafo grafo) {
			if (!BFS.esConexo(grafo))
				throw new IllegalArgumentException("El grafo no es conexo, no es posible realizar el algoritmo.");
		}

		private static Arista seleccionarAristaMenorPeso(Arista aristaMenorPeso, ArrayList<Arista> aristasDisponibles) {
			
			for (int i = 0; i < aristasDisponibles.size(); i++) {
				if (aristaMenorPeso.getPeso() >= aristasDisponibles.get(i).getPeso()) {
					aristaMenorPeso = aristasDisponibles.get(i);
				}
			} 
			return aristaMenorPeso;
		}

		public static void agregarVerticesVisitados(ArrayList<Integer> verticesVisitados, Arista aristaMenorPeso) {
			
			int iteraciones = verticesVisitados.size();
			
			for(int i=0;i<iteraciones;i++){
				if(verticesVisitados.get(i).equals(aristaMenorPeso.getInicial())){ 
					verticesVisitados.add(aristaMenorPeso.getTerminal());
	
				}
				if(verticesVisitados.get(i).equals(aristaMenorPeso.getTerminal())){ 
					verticesVisitados.add(aristaMenorPeso.getInicial());
				} 
			}
		}

		public static void agregarAristasDisponibles(ArrayList<Integer> verticesVisitados,ArrayList<Arista> aristasPendientes,ArrayList<Arista> aristaDisponibles) {
			//agrego a las aristasDisponibles las arista alcanzadas por los vertices visitados 
			for(int i=0;i<verticesVisitados.size();i++){
				for(int j=0;j<aristasPendientes.size();j++){
					if((aristasPendientes.get(j).getInicial() == verticesVisitados.get(i) && !verticesVisitados.contains(aristasPendientes.get(j).getTerminal())) ||
					(aristasPendientes.get(j).getTerminal()==verticesVisitados.get(i) && !verticesVisitados.contains(aristasPendientes.get(j).getInicial()))){
						if (!aristaDisponibles.contains(aristasPendientes.get(j))) 
							aristaDisponibles.add(aristasPendientes.get(j));
					}
				}
			}
			
		}
	
	
}

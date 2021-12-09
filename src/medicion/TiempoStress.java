	package medicion;
	
	import java.util.ArrayList;
	import grafo.Grafo;
	
	public class TiempoStress {
	
		
		//DEMOSTRACION
		//-------------------------ALGORITMO ALEATORIO 2---------------------------------------//
		public static void generarGrafosKruskalUnionFind(int vertices, int aristas, int tamano) {
			
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, aristas, tamano);
			System.out.println("|---------------------------------------------------------------------------------|");
			System.out.println("|   KruskalUnionFind " + "|Cant.Grafos: " + tamano 
					+ "|Cant.Vertices: " + vertices + "|Cant.Aristas: " + aristas + "");
			System.out.println("|---------------------------------------------------------------------------------|");
			
			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverKruskalUnionFind();
				
				System.out.println("|   Tiempo Parcial(Grafo n" + i+")-----------------Tiempo: " + Tiempo.darTiempo() + " milisegundos");
			}
			System.out.println("|---------------------------------------------------------------------------------|");
			
			long total = System.currentTimeMillis() - inicio;
			
			System.out.println("|   Tiempo Total: " + total / (long) 1000.0 + " segundo/s  " + total + " milisegundo/s.");
			System.out.println("|   Tiempo promedio por Grafo: " + total / tamano + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
	
		public static void generarGrafosKruskalBFS(int vertices, int aristas, int tamano) {
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, aristas, tamano);
			
			System.out.println("|---------------------------------------------------------------------------------|");
			System.out.println("|   KruskalBFS " + "|Cant.Grafos: " + tamano 
					+ "|Cant.Vertices: " + vertices + "|Cant.Aristas: " + aristas + "");
			System.out.println("|---------------------------------------------------------------------------------|");
	
			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverKruskalBFS();
				
				System.out.println("|   Tiempo Parcial(Grafo n" + i+")-----------------Tiempo: " + Tiempo.darTiempo() + " milisegundos");
	
			}
			System.out.println("|---------------------------------------------------------------------------------|");
			
			long total = System.currentTimeMillis() - inicio;
			
			System.out.println("|   Tiempo Total: " + total / (long) 1000.0 + " segundo/s  " + total +" milisegundo/s.");
			System.out.println("|   Tiempo promedio por Grafo: " + total / tamano + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
	
		public static void generarGrafosPrim(int vertices, int aristas, int tamano) {
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, aristas, tamano);
			
			System.out.println("|---------------------------------------------------------------------------------|");
			System.out.println("|     Prim     " + "|Cant.Grafos: " + tamano 
					+ "|Cant.Vertices: " + vertices + "|Cant.Aristas: " + aristas + "");
			System.out.println("|---------------------------------------------------------------------------------|");
	
			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverPrim();
				
				System.out.println("|   Tiempo Parcial(Grafo n" + i+")-----------------Tiempo: " + Tiempo.darTiempo() + " milisegundos");
	
			}
			System.out.println("|---------------------------------------------------------------------------------|");
			
			long total = System.currentTimeMillis() - inicio;
			
			System.out.println("|   Tiempo Total: " + total / (long) 1000.0 + " segundo/s  " + total +" milisegundo/s.");
			System.out.println("|   Tiempo promedio por Grafo: " + total / tamano + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
		
		//-------------------------ALGORITMO ALEATORIO 1---------------------------------------//
		public static void generarGrafosKruskalUnionFind(int vertices, int tamano) {
			
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, tamano);
			System.out.println("|---------------------------------------------------------------------------------|");
			System.out.println("|   KruskalUnionFind " + "|Cant.Grafos: " + tamano 
					+ "|Cant.Vertices: " + vertices );
			System.out.println("|---------------------------------------------------------------------------------|");
			
			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverKruskalUnionFind();
				
				System.out.println("|   Tiempo Parcial(Grafo n" + i+" con "+ grafosPrueba.get(i).GetAristas().size()+" aristas)----------Tiempo: " + Tiempo.darTiempo() + " milisegundos");
			}
			System.out.println("|---------------------------------------------------------------------------------|");
			
			long total = System.currentTimeMillis() - inicio;
			
			System.out.println("|   Tiempo Total: " + total / (long) 1000.0 + " segundo/s  " + total + " milisegundo/s.");
			System.out.println("|   Tiempo promedio por Grafo: " + total / tamano + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
		
		public static void generarGrafosKruskalBFS(int vertices,int tamano) {
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, tamano);
			
			System.out.println("|---------------------------------------------------------------------------------|");
			System.out.println("|   KruskalBFS " + "|Cant.Grafos: " + tamano 
					+ "|Cant.Vertices: " + vertices);
			System.out.println("|---------------------------------------------------------------------------------|");
	
			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverKruskalBFS();
				
				System.out.println("|   Tiempo Parcial(Grafo n" + i+" con "+ grafosPrueba.get(i).GetAristas().size()+" aristas)----------Tiempo: " + Tiempo.darTiempo() + " milisegundos");
	
			}
			System.out.println("|---------------------------------------------------------------------------------|");
			
			long total = System.currentTimeMillis() - inicio;
			
			System.out.println("|   Tiempo Total: " + total / (long) 1000.0 + " segundo/s  " + total +" milisegundo/s.");
			System.out.println("|   Tiempo promedio por Grafo: " + total / tamano + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
		
		public static void generarGrafosPrim(int vertices,int tamano) {
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, tamano);
			
			System.out.println("|---------------------------------------------------------------------------------|");
			System.out.println("|     Prim     " + "|Cant.Grafos: " + tamano 
					+ "|Cant.Vertices: " + vertices);
			System.out.println("|---------------------------------------------------------------------------------|");
	
			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverPrim();
				
				System.out.println("|   Tiempo Parcial(Grafo n" + i+" con "+ grafosPrueba.get(i).GetAristas().size()+" aristas)----------Tiempo: " + Tiempo.darTiempo() + " milisegundos");
	
			}
			System.out.println("|---------------------------------------------------------------------------------|");
			
			long total = System.currentTimeMillis() - inicio;
			
			System.out.println("|   Tiempo Total: " + total / (long) 1000.0 + " segundo/s  " + total +" milisegundo/s.");
			System.out.println("|   Tiempo promedio por Grafo: " + total / tamano + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
		
		
		
		
		
		//PARA PODER GRAFICAR MAS FACIL
		//------------------------- PRUEBA ALGORITMO ALEATORIO 2---------------------------------------//
		public static void generarGrafosKruskalUnionfind_Prueba(int vertices, int aristas, int tamano) {
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, aristas, tamano);

			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverKruskalUnionFind();
			}
			
			long total = System.currentTimeMillis() - inicio;
			System.out.println("|V = " +vertices+  "|T.promedio/Grafo: " + total / tamano + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
		
		public static void generarGrafosKruskalBFS_Prueba(int vertices, int aristas, int tamano) {
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, aristas, tamano);

			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverKruskalBFS();
			}
			
			long total = System.currentTimeMillis() - inicio;
			System.out.println("|V = " +vertices+  "|T.promedio/Grafo: " + total / tamano + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
		
		public static void generarGrafosPrim_Prueba(int vertices, int aristas, int tamaño) {
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, aristas, tamaño);

			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverPrim();
			}
			
			long total = System.currentTimeMillis() - inicio;
			System.out.println("|V = " +vertices+  "|T.promedio/Grafo: " + total / tamaño + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
	
		//------------------------- PRUEBA ALGORITMO ALEATORIO 1---------------------------------------//
		public static void generarGrafosKruskalUnionfind_Prueba(int vertices, int tamano) {
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, tamano);

			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverKruskalUnionFind();
			}
			
			long total = System.currentTimeMillis() - inicio;
			System.out.println("|V = " +vertices+  "|T.promedio/Grafo: " + total / tamano + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
		
		public static void generarGrafosKruskalBFS_Prueba(int vertices, int tamano) {
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, tamano);

			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverKruskalBFS();
			}
			
			long total = System.currentTimeMillis() - inicio;
			System.out.println("|V = " +vertices+  "|T.promedio/Grafo: " + total / tamano + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
		
		public static void generarGrafosPrim_Prueba(int vertices, int tamaño) {
			ArrayList<Grafo> grafosPrueba = Aleatorio.llenarDeGrafosAleatorios(vertices, tamaño);

			long inicio = System.currentTimeMillis();
			for (int i = 0; i < grafosPrueba.size(); i++) {
				
				Tiempo solver = new Tiempo(grafosPrueba.get(i));
				solver.resolverPrim();
			}
			
			long total = System.currentTimeMillis() - inicio;
			System.out.println("|V = " +vertices+  "|T.promedio/Grafo: " + total / tamaño + " milisegundo/s");
			System.out.println("|---------------------------------------------------------------------------------|");
		}
	
		
	}
	
	
	
	

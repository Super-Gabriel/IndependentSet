import src.GraphReader;
import src.Grafica;
import java.util.LinkedList;
import java.util.Random;

public class Main{
    public static void main(String[] uwu){

	String ruta = "data/grafica.txt";
	
	GraphReader gr = new GraphReader();	      
	int[] nodes = gr.getNodes(ruta,1);//obteniendo nodos	
	int[][] edges = gr.getEdges(ruta);//obteniendo aristas

	//creando la gráfica
	Grafica graph = new Grafica(nodes, edges);		

	//obteniendo el conjunto independiente uwu
	//(el conjunto depende del primer nodo aleatorio seleccionado)
	Random rand = new Random();
	int numR = 0;
	LinkedList<Integer> indSet = new LinkedList<>();
	while(graph.numNodes() !=0 ){//mientras no haya nodos en la gráfica
	    
	    //obteniendo numero random de los vértices válidos faltantes
	    numR = rand.nextInt(graph.numNodes());
	    
	    //removiendo el nodo elegido y sus implicados unu
	    indSet.add(graph.removeV(numR));
	}
	
	System.out.println("Conjunto independiente: "+indSet);	
    }    
}

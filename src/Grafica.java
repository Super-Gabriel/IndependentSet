package src;
import java.util.LinkedList;
    
public class Grafica{
    private LinkedList<Integer> nodos;
    private LinkedList<int[]> aristas;

    /**metodo constructor*/
    public Grafica(int[] nodes, int[][] edges){
	nodos = toNodeList(nodes);
	aristas = toEdgeList(edges);
    }    
    
    /**metodo para obtener el numero de nodos*/
    public int numNodes(){
	return nodos.size();
    }

    /**metodo para obtener el numero de aristas*/
    public int numEdges(){
	return aristas.size();
    }

    /**metodo para obtener la i esima arista*/
    public int[] getEdge(int i){
	return aristas.get(i);
    }

    /**metodo para quitar un vértice incluyendo sus vecinos dirigidos*/
    public int removeV(int i){
	LinkedList<Integer> list = new LinkedList<>();
	int result = nodos.get(i);
	
	list.add(nodos.get(i));

	/**falta eliminar unas aristas pero en este ejercicio no importa c:*/
	//removiendo aristas
	for(int j=0; j< aristas.size(); j++){
	    if(aristas.get(j)[0]==nodos.get(i)){
		list.add(aristas.get(j)[1]);
	    }	    
	}

	//removiendo nodos
	for(int j=0; j<list.size(); j++){
	    removeAux(list.get(j));
	}
	
	return result;
    }
    /**metodo auxiliar ^ para eliminar un elemento de una lista de ints*/
    private void removeAux(int i){
	for(int j=0; j<nodos.size(); j++){
	    if(nodos.get(j)==i){
		nodos.remove(j);
	    }
	}
    }

    @Override
    public String toString(){
	String form = "Nodos:\n";
	for(int i=0; i<nodos.size(); i++){
	    form += ""+nodos.get(i)+",";
	}
	form += "\n\nAristas:\n";
	for(int i=0; i<aristas.size(); i++){
	    form += ""+aristas.get(i)[0]+"-"+aristas.get(i)[1]+"\n";
	}

	return form;
    }
    
    /**metodo para pasar un array en una linkedlist*/
    private LinkedList<Integer> toNodeList(int[] nodes){
	LinkedList<Integer> n = new LinkedList<>();
	
	for(int i=0; i<nodes.length; i++){
	    n.add(nodes[i]);
	}
	
	return n;
    }
    /**metodo para pasar un array bidimensional a una linked list*/
    private LinkedList<int[]> toEdgeList(int[][] edges){
	LinkedList<int[]> e = new LinkedList<>();

	for(int i=0; i<edges.length; i++){
	    e.add(edges[i]);
	}

	return e;
    }
}

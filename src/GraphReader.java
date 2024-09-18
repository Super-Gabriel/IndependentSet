package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Clase para leer una gráfica. Nodos en un array y aristas en una matriz
 */
public class GraphReader{
    
    /**
     * obtener los nodos de la gráfica dado el txt
     * @param src - ruta del archivo
     * @param l - linea (1 es la de los nodos (1))
     */
    public static int[] getNodes(String src, int l){
	
	LinkedList<String[]> arista = new LinkedList<>();
	String[] tmp = {"hola"};
	
	try (BufferedReader br = new BufferedReader(new FileReader(src))) {
            String linea;
	    int i = l;
            while ((linea = br.readLine()) != null) {
		if(i==1){//primera linea (nodos)
		    tmp = linea.split(",");		    
		    break;
		}
		arista.add(linea.split(","));
            }	    
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	int[] result = new int[tmp.length];
	if(l==1){	    
	    for(int i=0; i<tmp.length; i++){
		result[i] = Integer.valueOf(tmp[i]);
	    }
	    return result;
	}            
	return result;
    }

    /**
     * obtener las aristas de una grafica dada su ruta
     * @param src - ruta del archivo
     */
    public static int[][] getEdges(String src){
	
	LinkedList<String[]> arista = new LinkedList<>();
	
	try (BufferedReader br = new BufferedReader(new FileReader(src))) {
            String linea;	    
            while ((linea = br.readLine()) != null) {
		arista.add(linea.split(","));
            }	    
        } catch (IOException e) {
            e.printStackTrace();
        }
	
	int[][] result = new int[arista.size()-1][arista.get(1).length];
	for(int i=1; i<arista.size(); i++){
	    for(int j=0; j<arista.get(i).length; j++){
		result[i-1][j] = Integer.valueOf(arista.get(i)[j]);
	    }
	}
	
	return result;
    }
    
}

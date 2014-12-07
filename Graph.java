import java.util.*;

public class Graph{
	Hashtable<String, LinkedList<Edge>> adj = new Hashtable<String, LinkedList<Edge>>();

	public Graph(int h, int w, int k){
		

	}

	public void addEdge(String u, Edge v){
		if (adj.containsKey(u)==true)
				adj.get(u).add(v);
		else{
			adj.put(u, new LinkedList<Edge>()); 
			adj.get(u).add(v);
		}

	}

}
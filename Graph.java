import java.util.*;

public class Graph{
	Hashtable<String, LinkedList<Edge>> adj = new Hashtable<String, LinkedList<Edge>>();
	Hashtable<String, Integer> adjDist = new Hashtable<String, Integer>();
	Hashtable<String, String> adjPi = new Hashtable<String, String>();
	ArrayList<String> vertices = new ArrayList<String>();
	ArrayList<String> paths = new ArrayList<String>();
	int height, width, points;

	public Graph(int h, int w, int k){
		this.height = h;
		this.width = w;
		this.points = k;
		this.getVerts();
	}

	public void getVerts(){
		for (int i=0; i<height; i++){
			for (int j=0; j<width; j++){
				for (int k=0; k<points; k++){
					String v = "v"+i+"."+j+"."+k;
					vertices.add(v);
				}
			}
		}

		for (int i=0; i<=height; i++){
			for (int j=0; j<=width; j++){
				String g = "g"+i+"."+j;
				vertices.add(g);
				
			}
		}
	}

	public void getWeight(String v){
		System.out.println(adjDist.get(v));
	}

	public void addEdge(String u, Edge v){
		if (adj.containsKey(u)==true)
				adj.get(u).add(v);
		else{
			adj.put(u, new LinkedList<Edge>()); 
			adj.get(u).add(v);
		}
	}

	public void addDist(String u, Integer d){
			adjDist.put(u,d);
	}

	public void addPi(String u, String p){
			adjPi.put(u,p);
	}

	public void dijkstra(String u, String v){
		init(u);
		ArrayList<Edge> s = new ArrayList<Edge>();
		PriorityQueue<String, Integer> q = new PriorityQueue<String, Integer>();
		for (int i=0; i<vertices.size(); i++){
			if (vertices.get(i).equals(u)==false)
				q.addItem(vertices.get(i),Integer.MAX_VALUE);
			else{
				q.addItem(vertices.get(i),0);
				// System.out.println("Hello");
			}
		}

		while (q.getSize()!=0){
			String min = q.removeItem();
			// System.out.println(min);
			paths.add(min);
			//need the path, not just the list of verts
			for (int i=0; i<adj.get(min).size(); i++){
				relax(q, min,adj.get(min).get(i).getVert(),adj.get(min).get(i).getWeight());
			}
		}
		getWeight(v);
	}

	public void relax(PriorityQueue<String, Integer> q, String u, String v, int w){
		// System.out.println(adjDist.get(v));
		if (adjDist.get(v)>(adjDist.get(u)+w)){
			adjDist.put(v, adjDist.get(u)+w);
			adjPi.put(v,u);
			q.decreasePriority(v, adjDist.get(u)+w);
		}
		// System.out.println();
	}

	public void init(String u){
		for (int i=0; i<vertices.size(); i++){
			adjDist.put(vertices.get(i),Integer.MAX_VALUE);
			// System.out.println(adjDist.get(vertices.get(i)));
			addPi(vertices.get(i),"");
		}
		adjDist.put(u,0);
		// System.out.println(adjDist.get(u));
	}

}
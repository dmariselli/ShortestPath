import java.util.*;

public class ShortestPathsMain {
	public static void main(String[] args) {
		new ShortestPathsMain().go();
	}

	public void go() {
		Scanner kbd = new Scanner(System.in);

		Graph g = new Graph(kbd.nextInt(), kbd.nextInt(), kbd.nextInt());

		while (kbd.hasNext()){
			String u=kbd.next();
			if (u.equals("queries"))
				break;
			String v=kbd.next();
			int w = kbd.nextInt();
			Vertex vert = new Vertex();
			Edge e1 = new Edge(v, w);
			Edge e2 = new Edge(u, w);
			g.addEdge(u,e1);
			g.addEdge(v,e2);

			
		}
	}
}
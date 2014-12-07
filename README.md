Computes shortest (least total weight) paths in a weighted, undirected graph. The graph will have a special property: it can be broken down into a 2-D grid of cells, where each cell has 4 special "corner" vertices shared with its neighbors, and all of the edges are between two vertices in the same cell or between a non-corner vertex in a cell and one of the corner vertices of the same cell.


the input must be read from standard input where
	the first line of input is three integers giving the width and height of the grid,
	the rest of the input is divided into two sections separated by the word "queries" on a separate line, where
	the first part contains information about the edges, one edge per line in the format "endpoint endpoint weight"; and
	the second part contains the endpoints of shortest paths we wish to compute, one query per line in the format "source destination"; and
the output must be written to standard output in the format "weight path" where "weight" is the total weight of a shortest (least total weight) path from the source to the destination, and "path" is the list of vertices on that path given by name in order from source to destination in the same format as a Java list.

Assuming:

the weights are non-negative integers,
the names of the vertices are in the form "gi.j" for the corner vertex in the top left of the grid cell in row i, column j (0=i=h and 0=j=w) and "v.i.j.k" for the kth vertex in cell (i, j), where 0=k<n,
each corner vertex has an edge to a non-corner vertex in each cell it is adjacent to,
no edge is listed in the input twice,
each cell is connected,
the graph is connected, and
the source and destination vertices for shortest path queries exist and are non-corner vertices in different cells.


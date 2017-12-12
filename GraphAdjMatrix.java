public class GraphAdjMatrix implements Graph{

	private int[][] graph;
	private int vertex;
	
	//constructor
	public GraphAdjMatrix(int vertices) {
		
		this.graph = new int[vertices][vertices];
		this.vertex = vertices;	
	}
	
	
	public void addEdge(int v1, int v2) {
		
	}


	public void topologicalSort() {
	
	}

	//add weight between edge
	public void addEdge(int v1, int v2, int weight) {
		
		graph[v1][v2] = weight;
		graph[v2][v1] = weight;
	}

	//return weight between two edges
	public int getEdge(int v1, int v2) {
		
			return graph[v1][v2];
	}

	//create minimum spanning tree,remove edges which are not in the tree,
	//return weight of the minimum spanning tree
	public int createSpanningTree() {
		
		int weight = 0;
		int parent[] = new int[vertex];
		int key[] = new int[vertex];
		boolean set[] = new boolean[vertex];
		
		for (int i = 0; i < vertex; i++) {
			
			key[i] = Integer.MAX_VALUE;
			set[i] = false;
		}
		
		key[0] = 0;
		parent[0] = -1;
		
		for (int count = 0; count < vertex; count++) {
			
			int min = minIndex(key, set);
			set[min] = true;
			
			for (int j = 0; j < vertex; j++) {
				
				if (graph[min][j] != 0 && set[j] == false && graph[min][j] < key[j]) {
					parent[j] = min;
					key[j] = graph[min][j];
				}
			}
		}
		
		for (int k = 1; k < vertex; k++) {
			weight += graph[k][parent[k]];
		}
		
		return weight;
	}
	
	//return minimum index
	public int minIndex(int key[], boolean set[]) {
		
		int min = Integer.MAX_VALUE;
		int index = -1;
		
		for (int i = 0; i < vertex; i++) {
			
			if (set[i] == false && key[i] < min) {
				min = key[i];
				index = i;
			}
		}
		return index;
	}

}
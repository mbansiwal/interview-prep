package graph;

public class HeapMapNode {
	private Vertex<Integer> vertex;
	private Integer weight;
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Vertex<Integer> getVertex() {
		return vertex;
	}

	public Integer getWeight() {
		return weight;
	}

	public HeapMapNode(Vertex<Integer> vertex, Integer weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vertex == null) ? 0 : vertex.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeapMapNode other = (HeapMapNode) obj;
		if (vertex == null) {
			if (other.vertex != null)
				return false;
		} else if (!vertex.equals(other.vertex))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}
}

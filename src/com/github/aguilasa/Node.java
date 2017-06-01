package com.github.aguilasa;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private boolean hasGetCur = false;
	private int currentAdj = -1;
	private String name;
	private List<Node> adjacency = new ArrayList<>();

	public Node() {

	}

	public Node(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Node> getAdjacency() {
		return adjacency;
	}

	public Node addAdj(Node node) {
		adjacency.add(node);
		return this;
	}

	public boolean containsAdjNode(Node n) {
		return adjacency.contains(n);
	}

	public Node getCurAdj() {
		if (!hasGetCur && currentAdj == -1) {
			currentAdj = 0;
			hasGetCur = true;
		}
		if (currentAdj >= 0 && currentAdj < adjacency.size()) {
			return adjacency.get(currentAdj);
		}
		return null;
	}

	public Node getNextAdj() {
		currentAdj++;
		return getCurAdj();
	}

	public Node getPrevAdj() {
		currentAdj--;
		return getCurAdj();
	}

	public void reset() {
		hasGetCur = false;
		currentAdj = -1;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Node other = (Node) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}

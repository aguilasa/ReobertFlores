package com.github.aguilasa;

import java.util.LinkedList;

public class NodeList extends LinkedList<Node> {

	private static final long serialVersionUID = -3643759433812704525L;

	public String toString() {
		String v = "";
		StringBuilder sb = new StringBuilder();
		sb.append("S = {");
		for (Node n : this) {
			sb.append(v);
			sb.append(n);
			v = ", ";
		}
		sb.append("}");

		return sb.toString();
	}

}

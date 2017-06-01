package com.github.aguilasa;

public class RobertFlores {

	private NodeList complete = new NodeList();
	private NodeList list = new NodeList();
	private Node v;

	public static void main(String[] args) {
		RobertFlores rf = new RobertFlores();
		rf.init();
		rf.exec();
	}

	public void init() {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");

		complete.add(a);
		complete.add(b);
		complete.add(c);
		complete.add(d);
		complete.add(e);
		complete.add(f);
		complete.add(g);
		complete.add(h);
		complete.add(i);

		a.addAdj(b).addAdj(d).addAdj(f).addAdj(h);
		b.addAdj(a).addAdj(d).addAdj(f).addAdj(i);
		c.addAdj(d).addAdj(e).addAdj(g);
		d.addAdj(a).addAdj(b).addAdj(c).addAdj(i);
		e.addAdj(a).addAdj(c).addAdj(f).addAdj(h);
		f.addAdj(a).addAdj(b).addAdj(e).addAdj(h);
		g.addAdj(c).addAdj(h).addAdj(i);
		h.addAdj(e).addAdj(f).addAdj(g);
		i.addAdj(b).addAdj(d).addAdj(g);

		v = a;
		list.add(v);
	}

	private int step = 3;
	private boolean printStep = true;
	private boolean backTracking = false;

	public void exec() {
		System.out.println("P1)\r\nVértice inicial: " + v);
		System.out.println("P2)\r\n" + list);

		while (true) {
			printStep();

			if (!backTracking) {
				Node last = list.getLast();
				if (list.size() == complete.size()) {
					backTracking = true;
 					printStep = true;
				} else {
					Node next = last.getNextAdj();
					if (next != null) {
						if (!list.contains(next)) {
							list.add(next);
							if (list.size() == complete.size() && list.getLast().containsAdjNode(v)) {
								printCicle();
							} else {
								printList();
							}
						}
					} else {
						backTracking = true;
						printStep = true;
					}
				}

			} else {
				Node lastRemoved = list.removeLast();
				lastRemoved.reset();
				printList();
				if (list.size() == 1) {
					break;
				} else {
					Node last = list.getLast();
					Node next = last.getNextAdj();
					if (next != null && next != lastRemoved) {
						if (!list.contains(next)) {
							list.add(next);
							backTracking = false;
							printStep(true);
							printList();
						}
					}
				}
			}

		}
	}

	private void printCicle() {
		printStep(true);
		System.out.println("Caminho hamiltoniano: " + list);
	}

	private void printList() {
		System.out.println(list);
	}

	private void printStep() {
		printStep(false);
	}

	private void printStep(boolean force) {
		if (printStep || force) {
			System.out.println(String.format("P%d)", step));
			printStep = false;
			step++;
			if (backTracking) {
				System.out.println("Back-tracking");
			}
		}
	}

}

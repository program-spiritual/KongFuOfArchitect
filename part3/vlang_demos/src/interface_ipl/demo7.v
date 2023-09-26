struct Empty {
}

struct Node {
	value f64
	left  Tree
	right Tree
}

type Tree = Empty | Node

fn sum(t Tree) f64 {
	return match t {
		Empty { 0 }
		Node { t.value + sum(t.left) + sum(t.right) }
	}
}

fn main() {
	left := Node{0.2, Empty{}, Empty{}}
	right := Node{0.3, Empty{}, Node{0.4, Empty{}, Empty{}}}
	tree := Node{0.5, left, right}
	println(sum(tree))
}

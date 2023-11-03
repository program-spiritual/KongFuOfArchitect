module main

struct Point {
	x int
	y int
}

struct Line {
	p1 Point
	p2 Point
}

type ObjectSumType = Line | Point

mut object_list := []ObjectSumType{}
object_list << Point{1, 1}
object_list << Line{
	p1: Point{1, 1}
	p2: Point{2, 2}
}

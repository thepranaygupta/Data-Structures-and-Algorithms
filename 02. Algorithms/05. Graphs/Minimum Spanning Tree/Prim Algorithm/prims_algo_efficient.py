'''
	Prim's Algo Efficient implementation
	using Priority queue to find minimum edge weight.
'''

from collections import defaultdict, deque
from queue import PriorityQueue

class Prims2:
	def __init__(self, v):
		self.vertices = v
		self.graph = defaultdict(list)
		self.key = [ float('inf') ] * self.vertices
		self.mst = [ False ] * self.vertices
		self.parent = [ -1 ] * self.vertices

	def add_edge(self, src, dest, weight):
		self.graph[src].append((dest, weight))

	def construct_mst(self, src):
		# intialising priority queue to get min distance
		priority_q = PriorityQueue()

		self.key[src] = 0
		self.parent[src] = -1
		priority_q.put((0, src))

		while not priority_q.empty():
			parent_node = priority_q.get()[1]

			for neighbour in self.graph[parent_node]:
				vertex = neighbour[0]
				weight = neighbour[1]

				if (not self.mst[vertex]) and (weight < self.key[vertex]):
					self.parent[vertex] = parent_node
					self.key[vertex] = weight
					priority_q.put((weight, vertex))

		print(f"MST for src node '{0}'", self.parent)


if __name__ == '__main__':
	g = Prims2(5)

	g.add_edge(0, 1, 2) # src, dest, weight
	g.add_edge(0, 3, 6)
	g.add_edge(1, 0, 2)
	g.add_edge(1, 2, 3)
	g.add_edge(1, 3, 8)
	g.add_edge(1, 4, 5)
	g.add_edge(2, 1, 3)
	g.add_edge(2, 4, 7)
	g.add_edge(3, 0, 6)
	g.add_edge(3, 1, 8)
	g.add_edge(4, 1, 5)
	g.add_edge(4, 2, 7)

	g.construct_mst(0)
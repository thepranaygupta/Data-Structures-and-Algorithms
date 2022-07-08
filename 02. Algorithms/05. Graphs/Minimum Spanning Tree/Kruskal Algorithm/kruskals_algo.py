'''
	Kruskals algo implementation 
'''
from collections import defaultdict, deque

class Kruskals:
	def __init__(self, v):
		self.vertices = v
		self.graph = []
		self.parent = [-1] * self.vertices
		self.rank = [0] * self.vertices
		self.min_cost = 0
		self.mst = []
 
	def add_edge(self, src, dest, weight):
		self.graph.append((src, dest, weight))

	def make_set(self):
		for i in range(self.vertices):
			self.parent[i] = i
			
	def find_parent(self, node):
		if node == self.parent[node]:
			return node

		return self.find_parent(self.parent[node])

	def union(self, src, dest):
		src = self.find_parent(src)
		dest = self.find_parent(dest)

		if self.rank[src] < self.rank[dest]:
			self.parent[src] = dest
		elif self.rank[dest] < self.rank[src]:
			self.parent[dest] = src
		else:
			self.parent[dest] = src
			self.rank[src] += 1


	def construct_mst(self):
		# sorting the graph by edge weights
		self.graph.sort(key = lambda x: x[2])

		for node in self.graph:
			src = node[0]
			dest = node[1]
			w = node[2]
			if self.find_parent(src) != self.find_parent(dest):
				self.min_cost += w
				# storing the nodes src and dest forming mst
				self.mst.append((src, dest))

				# performing union operation
				self.union(src, dest)

		print('MST ->', self.mst)
		print('Minimum cost for MST ->', self.min_cost)


if __name__ == '__main__':
	g = Kruskals(5)

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

	g.make_set()
	g.construct_mst()



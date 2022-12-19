from collections import defaultdict
from queue import PriorityQueue

class Solution:
    def networkDelayTime(self, times: List[List[int]], n: int, k: int) -> int:
        distance = [float('inf')] * (n+1)
        graph = defaultdict(list)
        
        for src, dest, weight in times:
            graph[src].append((dest, weight))
        
        distance[k] = 0
        
        pq = PriorityQueue()
        pq.put((0, k))
        
        while not pq.empty():
            vertex = pq.get()
            node = vertex[1]
            node_dist = vertex[0]
            
            for neighbour in graph[node]:
                adj_node = neighbour[0]
                adj_dist = neighbour[1]
                
                if distance[adj_node] > node_dist + adj_dist:
                    distance[adj_node] = node_dist + adj_dist
                    pq.put((distance[adj_node], adj_node))
        
        # updating distance of node 0 as -1 cuz node 0 wont exist         
        distance[0] = -1
        maxi = max(distance)
        return maxi if maxi != float('inf') else -1
        
        
            
        
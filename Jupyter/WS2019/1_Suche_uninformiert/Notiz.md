1. Completeness
2. Low time complexity
3. Low memory complexity
4. Optimality

|                   |       BFS       |       DFS       |
| ----------------- | :-------------: | :-------------: |
| Completeness      |     $True$      |     $False$     |
| Time Complexity   | $o(b^{d+1})=16$ |     $b^m=8$     |
| Memory Complexity | $o(b^{d+1})=16$ | $o(b\cdot m)=6$ |
| Optimality        |     $True$      |     $False$     |

$d: depth\  of\  the\ solution=3$

$b:\ branching\ factor=2$

$m:\ depth\ of\ the\ full\ tree=3$

$$weight\ of\ path\ between\ tree\ nodes\ (n-6)^2$$

$1,3,6,7,2,5,4,8,9,10,11$

```pseudocode
# Pure BFS Node Search in Tree
BFS(start, target){
	queue = []
	queue.add(root)
	do{
		node = queue.popFirst()
		if(node.equals(target)){return node}
		else{queue.add(node.children)}
	} while(queue.isNotEmpty)
  return null
}
```

```pseudocode
# BFS in Graph Search
BFS(start, target){
	queue=[]
	visited=[]
	queue.add(start)
	do{
		node = queue.popFirst()
		if(node == target){return node}
		else{
			visited.add(node)
			queue.add(node.allNeighboursNotInVisited)
		}
	} while(queue.isNotEmpty)
}
```

```pseudocode
# BFS in Graph Search with Path Weight aka. Dijkstra
BFS(start, target){
	queue = []
	visited = []
	shortestPaths = []
	do{
		
	}
}

```


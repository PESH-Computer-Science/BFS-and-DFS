# BFS
Code + PPT + Video for the Breadth-first Search (BFS) Algorithm.

- [**BFS_Floodfill.java**](https://github.com/PESH-Computer-Science/BFS/blob/main/BFS_Floodfill.java): Code for doing a BFS and changing squares of a certain color to a new color.
- [**BFS_Maze.java**](https://github.com/PESH-Computer-Science/BFS/blob/main/BFS_Maze.java): Code for shortest path in a grid with walls.
- [**PPT**](https://github.com/PESH-Computer-Science/BFS/blob/main/BFS.pptx)

## [**BFS Video**](https://youtu.be/7UhCFunIQ0U)

## General Algorithm
- Add starting point to the queue
- Iterate while the queue is not empty
  - Remove top coordinate from queue
  - If coordinate has been visited already: skip the below steps
  - Set coordinate to visited
  - Add all adjacent coordinates to the queue.


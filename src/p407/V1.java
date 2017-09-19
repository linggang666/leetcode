package p407;

import java.util.Comparator;
import java.util.PriorityQueue;

public class V1 {

    class Cell{
        int x,y,value;
        public Cell(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public int trapRainWater(int[][] heightMap) {

        if(heightMap == null || heightMap.length<3 || heightMap[0].length<3){
            return 0;
        }
        int res = 0;
        int level = 0;
        int m = heightMap.length, n = heightMap[0].length;
        
        boolean[][] visited = new boolean[m][n];
        int[][] dir = {{-1, 0}, {1, 0}, {0,-1}, {0,1}};
        PriorityQueue<Cell> q = new PriorityQueue<Cell>(new Comparator<Cell>() {
            public int compare(Cell o1, Cell o2) {
                return o1.value-o2.value;
            }
        });
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 || j==0 || i==m-1|| j==n-1){
                    q.add(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }
        
        while (!q.isEmpty()) {
            Cell cell = q.poll();
            level = Math.max(level, cell.value);
            for(int[] d : dir){
                int x = d[0] + cell.x;
                int y = d[1] + cell.y;
                if(x<0 || x>=m || y<0 || y>=n || visited[x][y]){
                    continue;
                }
                res += Math.max(level - heightMap[x][y], 0);
                visited[x][y] = true;
                q.add(new Cell(x, y, heightMap[x][y]));
            }
        }
        return res;
    }
    

    public static void main(String[] args) {
        int[][] d = {{1,4,3,1,3,2},
                      {3,2,1,3,2,4},
                      {2,3,3,2,3,1}};
        V1 v = new V1();
        System.out.println(v.trapRainWater(d));
    }

}

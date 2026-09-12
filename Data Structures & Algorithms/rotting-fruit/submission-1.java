class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh =0;
        Queue<int[]>q = new LinkedList<>();
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j] ==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        if(fresh==0) return 0;
        int minutes=0;
        int[] dr ={-1,1,0,0};
        int []dc = {0,0,-1,1};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int []current = q.poll();
                int row = current[0];
                int col = current[1];
                for(int d=0;d<4;d++){
                    int nr = row+dr[d];
                    int nc = col+dc[d];
                    if(nr >=0 && nr < rows&& nc>=0 && nc < cols && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        fresh--;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
            minutes++;
        }
        return fresh ==0 ?  minutes-1 : -1;
    }
}
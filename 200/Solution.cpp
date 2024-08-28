class Solution {
public:
    void dfs(vector<vector<char>>& grid, int rowSize, int colSize, int row, int col){
        if(row>=0 && row<rowSize && col>=0 && col<colSize && grid[row][col]=='1'){
            grid[row][col] = '0';
            dfs(grid,rowSize,colSize,row+1,col);
            dfs(grid,rowSize,colSize,row-1,col);
            dfs(grid,rowSize,colSize,row,col+1);
            dfs(grid,rowSize,colSize,row,col-1);
        }
    }
    int numIslands(vector<vector<char>>& grid) {
        int count = 0;
        int rowSize = grid.size();
        int colSize = grid[0].size();
        for(int i=0;i<grid.size();++i){
            for(int j=0;j<grid[0].size();++j){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,rowSize,colSize,i,j);
                }
            }
        }
        return count;
    }
};
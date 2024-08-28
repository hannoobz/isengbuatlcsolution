class Solution {
public:
    bool dfs(vector<vector<int>>& grid1,vector<vector<int>>& grid2, int row, int col, bool& status){
        if(row<grid2.size() && row>=0 && col<grid2[0].size() && col>=0 && grid2[row][col]==1){
            if(grid2[row][col]!=grid1[row][col]){
                status = false;
            }
            grid2[row][col] = 0;
            dfs(grid1,grid2,row+1,col,status);
            dfs(grid1,grid2,row-1,col,status);
            dfs(grid1,grid2,row,col+1,status);
            dfs(grid1,grid2,row,col-1,status);
            return status;
        }
        return false;
    }
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int rows = grid1.size();
        int cols = grid1[0].size();
        int count = 0;
        bool marking = true;
        
        for(int i=0;i<rows;++i){
            for(int j=0;j<cols;++j){
                if(grid2[i][j]==1 && grid2[i][j]==grid1[i][j]){
                    marking = dfs(grid1,grid2,i,j,marking);
                    if(marking){
                        count++;
                    }
                }
                marking = true;
            }
        }
        return count;
    }
};
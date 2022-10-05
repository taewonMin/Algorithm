package level_0;

// 안전지대
public class Sol_120866 {
    public int solution(int[][] board) {
        int n = board.length;
        int answer = n*n;
        boolean[][] visited = new boolean[n][n];
        int[] dx = {0,-1,-1,0,1,1,1,0,-1};
        int[] dy = {0,0,1,1,1,0,-1,-1,-1};

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 1){
                    for(int k=0; k<9; k++){
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(0<=nx && nx<n && 0<=ny && ny<n && visited[nx][ny]==false){
                            answer--;
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }

        return answer;
    }
}
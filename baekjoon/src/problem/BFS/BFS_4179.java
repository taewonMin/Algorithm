package problem.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 불
public class BFS_4179 {
    public static char[][] maze;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static Queue<Unit> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        maze = new char[input[0]][input[1]];
        List<Unit> listF = new ArrayList<>();
        for(int i=0; i<input[0]; i++){
            maze[i] = br.readLine().toCharArray();
            for(int j=0; j<input[1]; j++){
                if(maze[i][j]=='J'){
                    queue.offer(new Unit(i,j,'J',0));
                }else if(maze[i][j]=='F'){
                    listF.add(new Unit(i,j,'F',-1));
                }
            }
        }

        for(Unit f : listF){
            queue.offer(f);
        }

        bfs();

        br.close();
    }

    public static void bfs(){
        while(!queue.isEmpty()){
            Unit unit = queue.poll();
            
            for(int i=0; i<4; i++){
                int x = unit.i + dx[i];
                int y = unit.j + dy[i];
                if(unit.name=='J' && maze[unit.i][unit.j]=='J'){
                    if(!boundaryCheck(x, y)){
                        System.out.println(unit.time+1);
                        return;
                    }else if(maze[x][y]=='.'){
                        queue.offer(new Unit(x,y,'J',unit.time+1));
                        maze[x][y] = 'J';
                    }
                }else if(unit.name=='F'){
                    if(boundaryCheck(x, y) && maze[x][y]!='F' && maze[x][y]!='#'){
                        queue.offer(new Unit(x,y,'F',-1));
                        maze[x][y] = 'F';
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static boolean boundaryCheck(int x, int y){
        return 0<=x && x<maze.length && 0<=y && y<maze[0].length;
    }

    static class Unit{
        int i;
        int j;
        char name;
        int time;

        Unit(int i, int j, char name, int time){
            this.i = i;
            this.j = j;
            this.name = name;
            this.time = time;
        }
    }
}

package problem.BFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 불
public class BFS_5427 {
    public static char[][] map;
    public static int[] dx = {-1,0,1,0};
    public static int[] dy = {0,1,0,-1};
    public static Queue<Unit> queue = new LinkedList<>();
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            queue.clear();
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map = new char[input[1]][input[0]];

            ArrayList<Unit> list = new ArrayList<>();
            for(int j=0; j<input[1]; j++){
                map[j] = br.readLine().toCharArray();
                for(int k=0; k<map[j].length; k++){
                    if(map[j][k]=='@'){
                        queue.offer(new Unit(j, k, '@',0));
                    }else if(map[j][k]=='*'){
                        list.add(new Unit(j,k,'*',0));
                    }
                }
            }

            for(Unit unit : list){
                queue.offer(unit);
            }

            bfs();
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void bfs() throws IOException{
        while(!queue.isEmpty()){
            Unit unit = queue.poll();
            for(int i=0; i<4; i++){
                int x = unit.x + dx[i];
                int y = unit.y + dy[i];
                if(unit.name=='@'){
                    if(map[unit.x][unit.y]=='@'){   // 한 턴동안 살아남았는지 체크
                        if(!boundaryCheck(x, y)){
                            bw.write((unit.time+1)+"\n");
                            return;
                        }
                        if(map[x][y] == '.'){
                            queue.offer(new Unit(x,y,'@',unit.time+1));
                            map[x][y] = '@';
                        }
                    }
                }else{  // 불
                    if(boundaryCheck(x, y) && map[x][y] != '#' && map[x][y] != '*'){
                        queue.offer(new Unit(x,y,'*',0));
                        map[x][y] = '*';
                    }
                }
            }
        }
        bw.write("IMPOSSIBLE\n");
    }

    public static boolean boundaryCheck(int x, int y){
        return 0<=x && x<map.length && 0<=y && y<map[0].length;
    }

    static class Unit{
        int x;
        int y;
        char name;
        int time;

        Unit(int x, int y, char name, int time){
            this.x = x;
            this.y = y;
            this.name = name;
            this.time = time;
        }
    }
}

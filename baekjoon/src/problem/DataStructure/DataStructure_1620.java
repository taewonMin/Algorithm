package problem.DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 나는야 포켓몬 마스터 이다솜
public class DataStructure_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[] dogam = new String[input[0]];
        Pocketmon[] sortDogam = new Pocketmon[input[0]];
        for(int i=0; i<input[0]; i++){
            dogam[i] = br.readLine();
            sortDogam[i] = new Pocketmon(i+1, dogam[i]);
        }

        Arrays.sort(sortDogam, (o1, o2) -> o1.name.compareTo(o2.name));

        for(int i=0; i<input[1]; i++){
            String quiz = br.readLine();
            if(quiz.matches("\\d+")){
                bw.write(dogam[Integer.parseInt(quiz)-1]+"\n");
            }else{
                bw.write(binarySearch(quiz, sortDogam)+"\n");
            }
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static int binarySearch(String target, Pocketmon[] array){
        int lo = 0; 
        int hi = array.length-1;

        while(lo <= hi){
            int mid = (hi+lo)/2;

            if(array[mid].name.compareTo(target)==0){
                return array[mid].index;
            }else if(array[mid].name.compareTo(target) < 0){
                lo = mid+1;
            }else{
                hi = mid-1;
            }
        }
        return -1;
    }

    static class Pocketmon {
        int index;
        String name;

        Pocketmon(int index, String name){
            this.index = index;
            this.name = name;
        }
    }
}

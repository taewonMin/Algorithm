package problem.Implement;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// 웰컴
public class Imple_5337 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(".  .   .\n");
        bw.write("|  | _ | _. _ ._ _  _\n");
        bw.write("|/\\|(/.|(_.(_)[ | )(/.\n");

        bw.flush();
        bw.close();
    }
}

package problem.Math1;

import java.util.Scanner;
import java.util.StringTokenizer;

// 인공지능 시계
public class Math1_2530 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int time = sc.nextInt();

        int second2 = (second + time) % 60;
        int minute2 = (minute + (second+time)/60) % 60;
        int hour2 = (hour + (minute + (second+time)/60)/60) % 24;

        System.out.println(hour2+" "+minute2+" "+second2);

        sc.close();
    }
}

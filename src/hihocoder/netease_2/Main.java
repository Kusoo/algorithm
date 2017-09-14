package hihocoder.netease_2;

import java.util.Scanner;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int[] tX = new int[n];
            int[] tY = new int[n];
            for(int i = 0; i < n; i++)
                tX[i] = sc.nextInt();
            for(int i = 0; i < n; i++)
                tY[i] = sc.nextInt();
            int gX = sc.nextInt();
            int gY = sc.nextInt();
            int walkTime = sc.nextInt();
            int taxiTime = sc.nextInt();

            int min = distance(0, 0, gX, gY) * walkTime;
            for(int i = 0; i < n; i++){
                int walkDistance = distance(0, 0, tX[i], tY[i]);
                int taxiDistance = distance(tX[i], tY[i], gX, gY);
                int time = walkDistance * walkTime + taxiDistance * taxiTime;
                min = Math.min(min, time);
            }
            System.out.println(min);
        }
    }

    private static int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

package hihocoder.netease_7;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Created by l81022078 on 2017/8/11.
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int w = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            TreeSet<Node> set = new TreeSet<>();
            for(int i = w; i <=x; i++){
                for(int j = y; j <= z; j++){
                    set.add(new Node(i, j));
                }
            }
            System.out.println(set.size());
        }
    }
}
class Node implements Comparable<Node>{
    int x;
    int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Node o) {
        return Integer.compare(x * o.y, o.x * y);
    }
}
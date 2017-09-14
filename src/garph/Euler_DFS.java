package garph;


import java.util.Stack;

public class Euler_DFS {
    int N;
    int M;
    int[] path;
    int[][] edges;

    Euler_DFS(int n, int m, int[][] edges){
        N = n;
        M = m;
        this.edges = edges;
        path = new int[M + 1];
    }

    boolean isEuler(){
        int num = 0;
        for(int i = 0; i < N; i++){
            int degree = 0;
            for(int j = 0; j < N; j++){
                degree += edges[i][j];
            }
            if((degree & 1) == 1){
                num++;
            }
        }
        if(num == 0 || num == 2)
            return true;
        return false;
    }

    /**
     *
     * @param s 起始点
     * @param depth default 0
     * */
    boolean euler(int s, int depth){
        path[depth] = s;
        if(depth == M)
            return true;
        depth++;
        for(int i = 0; i < N; i++){
            if(edges[s][i] == 1){
                edges[s][i] = edges[i][s] = 0;
                if(euler(i, depth))
                    return true;
                edges[s][i] = edges[i][s] = 1;
             }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0}
        };
        Euler_DFS dfs = new Euler_DFS(5, 10, edges);
        dfs.euler(0, 0);
        for(int i = 0; i <= dfs.M; i++){
            System.out.println(dfs.path[i]);
        }
    }
}

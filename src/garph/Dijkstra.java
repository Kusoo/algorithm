package garph;

public class Dijkstra {
    int N;
    int edges[][];
    int S[];
    int dist[];
    int prev[];
    int MAX = Integer.MAX_VALUE;

    public Dijkstra(int n, int[][] edges){
        N = n;
        this.edges = edges;
        S = new int[N];
        dist = new int[N];
        prev = new int[N];
    }

    public void dijkstra(int s){
        for(int i = 0; i < N; i++){
            dist[i] = edges[s][i];
            S[i] = 0;
            if(dist[i] < MAX && i != s)
                prev[i] = s;
            else
                prev[i] = -1;
        }
        S[s] = 1;
        for(int i = 0; i < N - 1; i++){
            int min = MAX;
            int index = s;
            for(int j = 0; j < N; j++){
                if(S[j] != 1 && dist[j] < min){
                    min = dist[j];
                    index = j;
                }
            }
            S[index] = 1;
            for(int j = 0; j < N; j++){
                if(S[j] != 1 && edges[index][j] < MAX){
                    if(dist[index] + edges[index][j] < dist[j]){
                        dist[j] = dist[index] + edges[index][j];
                        prev[j] = index;
                    }
                }
            }
        }
    }
}

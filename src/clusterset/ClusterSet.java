package clusterset;


public class ClusterSet {
    int[] prev;
    public ClusterSet(int num){
        prev = new int[num];
        for(int i = 0; i < num; i++)
            prev[i] = i;
    }

    int find(int x){
        int r = x;
        while(prev[r] != r)
            r = prev[r];

        //路径压缩
        int i = x, j;
        while(i != r){
            j = prev[i];
            prev[i] = r;
            i = j;
        }
        return r;
    }

    void join(int x, int y){
        int rx = find(x);
        int ry = find(y);
        if(rx != ry)
            prev[rx] = ry;
    }
}

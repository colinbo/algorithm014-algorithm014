public class FriendCircle {

    public int find(int[] parent, int i){

        while (parent[i] != i){
            i = parent[i];
        }
        return i;
    }

    public void union(int[] parents, int i, int j){
        int pI = find(parents, i);
        int pJ = find(parents, j);
        if (pI != pJ){
            parents[pI] = pJ;
        }
    }

    public int[] initParent(int length){
        int[] parents = new int[length];
        for (int i = 0; i < length; i++){
            parents[i] = i;
        }
        return parents;
    }

    public int findCircleNum(int[][] M) {

        if (M == null || M.length == 0) return 0;

        int[] parents = initParent(M.length);
        for (int i = 0; i < M.length; i++){
            for (int j = 0; j < M[0].length; j++){
                if (M[i][j] == 1){
                    union(parents, i, j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < M.length; i++){
            if (parents[i] == i){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] M = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(new FriendCircle().findCircleNum(M));
    }
}

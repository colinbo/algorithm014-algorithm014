public class NQueen {

    private int size;
    private int count;

    public void solve(int row, int pie, int na){
        if (row == size){  // if all available positions are occupied, count it as the solution.
            count++;
            return;
        }

        int availPos = (~(row | pie | na)) & size;  //still available positions for the current row
        while (availPos != 0){  //loop until all available positions are occupied
            int firstPos = availPos & (-availPos);  //find the first available position
            availPos = availPos - firstPos;  //mark the first available position as occupied
            solve(row | firstPos, (pie | firstPos) >> 1, (na | firstPos) << 1);
            //mark the available positions for the next row, mark the hill diagonal and dale diagonal affected in the next row.
        }
    }

    public int totalNQueens(int n) {

        size = (1 << n) - 1; //turns all available positions to 1
        solve(0, 0, 0);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NQueen().totalNQueens(8));
    }
    
}

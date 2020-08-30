import java.util.LinkedList;
import java.util.List;

public class Combination {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        recursList(1, n, k, tempList, result);
        return result;
    }

    public void recursList(int level, int n, int k, List<Integer> tempList, List<List<Integer>> result){
        if (tempList.size() == k){
            result.add(new LinkedList<>(tempList));
            return;
        }

        for (int i = level; i <= n; i++){
            tempList.add(i);
            recursList(i + 1, n, k, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combination().combine(4, 2));
    }
}

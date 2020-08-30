import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        recursList(nums, nums, tempList, result);
        return result;
    }

    public void recursList(int[] reducedNums, int[] nums, List<Integer> tempList, List<List<Integer>> result){
        if (tempList.size() == nums.length){
            result.add(new LinkedList<>(tempList));
            return;
        }

        for (int i = 0; i < reducedNums.length; i++){
            tempList.add(reducedNums[i]);
            int index = i;
            int[] regenNums = Arrays.stream(reducedNums).filter(x -> x != reducedNums[index]).toArray();
            recursList(regenNums, nums, tempList, result);
            tempList.remove(tempList.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(new Permutation().permute(nums));
    }
}

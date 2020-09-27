import java.util.*;
import java.util.stream.Collectors;

public class FourSum {

    public List<List<Integer>> combine(int[] nums, int k) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> tempList = new LinkedList<>();
        Arrays.sort(nums);
        recursList(0, nums, k, tempList, result);
        //result.stream().distinct().collect(Collectors.toList());
        return result;
    }

    public void recursList(int level, int[] nums, int k, List<Integer> tempList, List<List<Integer>> result){
        if (tempList.size() == 4){
            if (tempList.stream().reduce(0, Integer::sum) == k){
                List<Integer> tempResult = new LinkedList<>(tempList);
                //Collections.sort(tempResult);
                if (!result.contains(tempResult)){
                    result.add(tempResult);
                }
            }
            return;
        }

        for (int i = level; i < nums.length; i++){
            tempList.add(nums[i]);
            recursList(i + 1, nums, k, tempList, result);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(new FourSum().combine(nums, 2));
    }
}

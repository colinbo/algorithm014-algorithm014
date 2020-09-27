public class Steps {

    public int jump(int[] nums) {
        int lastreach = 0, maxreach = 0, count = 0;

        for (int i = 0; i < nums.length; i++){
            if (i > maxreach)
                return -1;

            if (i > lastreach){
                count++;
                lastreach = maxreach;
            }

            if (i + nums[i] > maxreach){
                maxreach = i + nums[i];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] bills = {2,3,1,1,4};
        System.out.println(new Steps().jump(bills));
    }
}

import java.util.Arrays;

public class RotateArray {

    public void rotate(int[] nums, int k) {

        int length = nums.length;
        for (int j = 1; j <= k; j++){
            int prev = nums[length - 1];
            for (int i = 0; i < length; i++){
                int temp = nums[i];
                nums[i] = prev;
                prev = temp;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public void rotate2(int[] nums, int k) {

        int length = nums.length;

        int count = 0;
        for (int start = 0; count < length; start++){
            int prev = nums[start];
            int temp, nextIndex = (k + start) % length;
            boolean oneRoundDone = false;
            while (true){
                temp = nums[nextIndex];
                nums[nextIndex] = prev;
                prev = temp;
                count++;

                if (oneRoundDone){
                    break;
                }

                nextIndex = (k + nextIndex) % length;
                if (nextIndex == start){
                    oneRoundDone = true;
                }

            }

        }


        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] list = {1,2,3,4,5,6};
        new RotateArray().rotate2(list, 2);
    }
}

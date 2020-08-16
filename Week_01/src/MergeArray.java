import java.util.Arrays;

public class MergeArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = 0;
        int p2 = 0;
        int[] mergedArray = new int[m + n];
        int i = 0;
        while (p1 < m && p2 < n){
            if (nums1[p1] < nums2[p2]){
                mergedArray[i] = nums1[p1];
                p1++;
            }
            else {
                mergedArray[i] = nums2[p2];
                p2++;
            }
            i++;
        }

        if (p1 < m){
            System.arraycopy(nums1, p1, mergedArray, p1 + p2, m - p1);
        }
        if (p2 < n){
            System.arraycopy(nums2, p2, mergedArray, p1 + p2, n - p2);
        }

        System.arraycopy(mergedArray, 0, nums1, 0, mergedArray.length);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        int[] list1 = {1,2,3,0,0,0};
        int[] list2 = {2,5,6};
        new MergeArray().merge(list1, 3, list2, 3);
    }
}

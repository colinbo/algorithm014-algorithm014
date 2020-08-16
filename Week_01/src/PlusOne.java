import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            //if the digit is smaller than 9, just add 1 and break
            if (digits[i] < 9){
                digits[i] += 1;
                break;
            }
            else {
                //if the digit is 9, set the current digit to 0 and
                // plus 1 to the previous digit in next loop
                digits[i] = 0;
            }
        }

        int[] extDigits = null;
        //if the first digit is 0, it means the input digits are all 9s
        if (digits[0] == 0){
            extDigits = new int[digits.length + 1];
            extDigits[0] = 1;

        }
        else {
            extDigits = digits;
        }

        return extDigits;
    }

    public static void main(String[] args) {
        int[] list = {9,9,9,9,9,9};
        int[] result = new PlusOne().plusOne(list);
        System.out.println(Arrays.toString(result));
    }
}

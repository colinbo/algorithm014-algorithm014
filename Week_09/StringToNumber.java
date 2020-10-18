public class StringToNumber {

    public int myAtoi(String s) {
        if (s == null || s.equals("")) return 0;
        long value = 0;
        int i = 0;
        while ( i < s.length() && s.charAt(i) == ' '){
            i++;
        }

        if (i == s.length()) return 0;

        int sign = 1;
        if (s.charAt(i) == '-'){
            sign = -1;
            i++;
        } else if (s.charAt(i) == '+'){
            sign = 1;
            i++;
        } else if (s.charAt(i) > '0' && s.charAt(i) < '9'){
            sign = 1;
        }


        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9'){
            int num = s.charAt(i) - '0';

            if (sign == 1){
                value = value * 10 + num;
            }
            else if (sign == -1){
                value = value * 10 - num;
            }

            if (sign == 1 && Integer.MAX_VALUE < value) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && Integer.MIN_VALUE > value){
                return  Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)value;
    }

    public static void main(String[] args) {
        System.out.println(new StringToNumber().myAtoi("21474836460"));
    }


}

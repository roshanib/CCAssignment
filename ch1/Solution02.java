import java.util.Arrays;

public class Solution02 {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "acdb";

        System.out.println(checkPermutation(str1, str2));
    } 

    public static boolean checkPermutation(String str1, String str2) {

        char[] chars = str1.toCharArray();
        Arrays.sort(chars);
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars2);

        String sorted1 = new String(chars);
        String sorted2 = new String(chars2);
        return sorted1.equals(sorted2);
    }
}

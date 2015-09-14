
 public class Solution01 {
    public static void main(String args[]) {
    
        String check = "aacd";
        System.out.println(isUnique(check));    

    }

    public static boolean isUnique(String str) {
        int bitmap = 0;
        str = str.toLowerCase();

        for (int i=0; i <str.length(); i++) {
            char c = str.charAt(i);
            int number = c - 'a';
            if ((bitmap & 1 << number) != 0) {
                // character already exists;
                return false;
            }
            // mark appropriate character as present
            bitmap |= 1<< number;

        }
        return true;
    }
 }

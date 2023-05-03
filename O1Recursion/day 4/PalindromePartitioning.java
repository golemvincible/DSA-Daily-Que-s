import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> op = new ArrayList<>();

        util(s,res,op,0);

        return res;
    }

    private static void util(String s, List<List<String>> res, List<String> op, int start) {

        if(start==s.length()){
            res.add(new ArrayList<>(op));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if(isPalindrome(s,start,i)){

                op.add(s.substring(start,i+1));
                util(s,res,op,i+1);
                op.remove(op.size()-1);

            }

        }
    }

    private static boolean isPalindrome(String s, int start, int end) {
        while(start<end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }

        return true;
    }
}

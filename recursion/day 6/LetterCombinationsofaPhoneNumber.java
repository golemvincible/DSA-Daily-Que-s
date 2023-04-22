class LetterCombinationsofaPhoneNumber {
    private static void solve(String digits,String[] dig,List<String> res,int ind,String op){
        if(ind==digits.length()){
            res.add(op);
            return;
        }
        
        int num=Integer.valueOf(digits.charAt(ind));  //ind ->num
        String s = dig[num-48];
        
        for(int i=0;i<s.length();i++){
            
            op=op+s.charAt(i);
            solve(digits,dig,res,ind+1,op);
            op=op.substring(0,op.length()-1);
            
        }
    }
    public List<String> letterCombinations(String digits) {
        
        String[] dig = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        
        List<String> res = new ArrayList<>();
        
        if(digits.length()==0)
            return res;
        
        solve(digits,dig,res,0,"");
        
        return res;
    }
}

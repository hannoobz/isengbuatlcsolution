class Solution {
    public boolean isValid(String s) {
        Stack<Character> a = new Stack<>();
        a.push('#');
        for (int i = 0; i < s.length(); i++){
        char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{'){
                a.push(c);
            }
            else if(c==')' && a.peek()=='('){
                a.pop();
            }
            else if(c=='}' && a.peek()=='{'){
                a.pop();
            }
            else if(c==']' && a.peek()=='['){
                a.pop();
            }
            else{
                return false;
            }
        }
        a.pop();
        if(a.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
}
class Solution {
    int gcd(int a, int b){
        if(a==0){
            return b;
        }
        return gcd(b%a,a);
    }

    int lcm(int a, int b){
        return (int) Math.abs(a*b)/gcd(a,b);
    }

    public String fractionAddition(String expression) {
        ArrayList<Integer> number = new ArrayList<>();
        StringBuilder resBuild = new StringBuilder();
        int numLCM;
        int numGCD;
        int result = 0;

        Scanner scan = new Scanner(expression);
        scan.useDelimiter("/|(?=[-+])");
        while(scan.hasNext()){
            if (scan.hasNextInt()) {
                number.add(scan.nextInt());
            }
            else{
                scan.next();
            }
        }
        
        numLCM = number.get(1);

        for(int i=1;i<number.size()-2;i+=2){
            numLCM = lcm(numLCM,number.get(i+2));
        }
        
        for(int i=0;i<number.size();i+=2){
            result += number.get(i)*(int)(numLCM/number.get(i+1));
        }
        numGCD = Math.abs(gcd(result,numLCM));
        result = (int) (result/numGCD);
        numLCM = (int) (numLCM/numGCD);

        resBuild.append(Integer.toString(result));
        resBuild.append("/");
        resBuild.append(Integer.toString(numLCM));
        
        return resBuild.toString();
    }
}
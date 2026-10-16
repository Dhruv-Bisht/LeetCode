class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int n = s.length();
        int count = 0;
        for(int i=n-1; i>=0; i--){
            char ch = s.charAt(i);
            if(ch == '-'){
                continue;
            }

            if(count > 0 && count % k == 0){
                sb.append('-');
            }

            sb.append(Character.toUpperCase(ch));
            count++;
       }

       return sb.reverse().toString();
    }
}
class Solution {
    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<parts.length; i++){
            int num = Integer.parseInt(parts[i]);
            sb.append(Integer.toBinaryString(num));
            if(i != parts.length-1){
                sb.append("-");
            }
        }
        return sb.toString();
    }
}
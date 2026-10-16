class Solution {
    public int numUniqueEmails(String[] emails) {
        // HashSet set = new HashSet<>();

        // for (String email:emails){
        //     String[] name = email.split("@");
        //     String[] localPart = name[0].split("\\+");
        //     String local = localPart[0].replace(".",""); 
        //     // local = local.split("+")[0];
        //     // local = local.replace(".","");

        //     set.add(local+"@"+name[1]);
        // }
        // return set.size();


        HashSet<String> set = new HashSet<>();
        for(String email:emails){
            set.add(normalizedString(email));
        }

        return set.size();
    }

    public String normalizedString(String email){
        int index = email.indexOf("@"); // find the index of (@);
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<index; i++){
            char ch = email.charAt(i);
            if(ch == '+') break;
            if(ch != '.') sb.append(ch);
        }

        sb.append(email.substring(index));
        return sb.toString();
    }

}
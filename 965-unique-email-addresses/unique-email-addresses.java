class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet set = new HashSet<>();

        for (String email:emails){
            String[] name = email.split("@");
            String[] localPart = name[0].split("\\+");
            String local = localPart[0].replace(".",""); 
            // local = local.split("+")[0];
            // local = local.replace(".","");

            set.add(local+"@"+name[1]);
        }
        return set.size();

    }
}
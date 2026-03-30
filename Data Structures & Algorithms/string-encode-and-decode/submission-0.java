class Solution {

    public String encode(List<String> strs) {
        String res="";
        for(String s :strs ){
            res += s.length()+"#"+s;
        }
        return res;
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();
        int i=0; 
        int j;
        while(i<str.length()){
            j=i;
            while(str.charAt(j) !='#'){
                j++;
            }
            int len= Integer.parseInt(str.substring(i,j));
            String word = str.substring(j+1,j+1+len);
            list.add(word);
            i = j+1+len;
        }
         return list;
    }
   
}

class Solution {

    public boolean compare(HashMap<Character, Integer> smap, HashMap<Character, Integer> pmap){
        for(char ch : smap.keySet()){
            if(pmap.getOrDefault(ch, 0) != smap.get(ch))
               return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> pmap = new HashMap<>();

        List<Integer> ans = new LinkedList<>();

        for(int i =0 ;i < p.length() ; i++){
            char ch = p.charAt(i);
            pmap.put(ch , pmap.getOrDefault(ch , 0) + 1);

            char ch1 = s.charAt(i);
            smap.put(ch1 , smap.getOrDefault(ch1 , 0) + 1);
        }
        

        int i = p.length();
        while( i < s.length()){
            if(compare(pmap, smap) == true){
                ans.add(i - p.length());
            }

            char cha = s.charAt(i);
            smap.put(cha, smap.getOrDefault(cha , 0 ) + 1);

            char chr = s.charAt(i - p.length());
            if(smap.get(chr) == 1)
                smap.remove(chr);
            else
                smap.put(chr, smap.get(chr) - 1);

            i++;

        }
         if(compare(pmap, smap) == true){
                ans.add(i - p.length());
        }

        return ans;
    }
}

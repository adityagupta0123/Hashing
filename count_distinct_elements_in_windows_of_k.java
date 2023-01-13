
class Solution
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> list  = new ArrayList<>();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int i =0;
        while( i< k -1 ){
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1); // acqure
            i++;
        }
        i--; // i = k-1
        int j = -1;
        while( i < n - 1){
            i++;
            hm.put(A[i], hm.getOrDefault(A[i], 0) + 1);
            
            list.add(hm.size()); // put
            
            // release
            j++;
            int freq = hm.get(A[j]); 
            if( freq == 1)
               hm.remove(A[j]);
            else
               hm.put(A[j], freq - 1);
            
        }
        
        return list;
    }
}

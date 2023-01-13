class GfG
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> hm = new HashMap<>(); // sum , i
        int maxlen = 0;
        int i = -1;
        int sum = 0;
        hm.put(sum, i);
        while( i < n - 1 ){
            i++;
            sum += arr[i];
            if(hm.containsKey(sum) == false)
               hm.put(sum, i);
            else{
               int len = i - hm.get(sum);
               maxlen = Math.max(maxlen, len);
            }
        }
        return maxlen;
    }
}

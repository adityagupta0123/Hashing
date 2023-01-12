class Solution {
    // public boolean canArrange(int[] arr, int k) {
    //     HashMap<Integer, Integer> rfmap = new HashMap<>();
    //     for(int val : arr){
    //         int rem = val % k ;
    //         int oldFact = rfmap.getOrDefault(rem , 0);
    //         rfmap.put(rem , oldFact + 1);
    //     } 
    //     for(int val : arr){
    //         int rem = val % k;
    //         if( rem == 0){
    //            int feq = rfmap.get(rem);
    //            if((feq & 1) == 1)
    //                return false;
    //         } else if( (rem * 2) == k){
    //             int feq = rfmap.get(rem);
    //            if((feq & 1) == 1)
    //                return false;
    //         }else{
    //            int feq = rfmap.get(rem);
    //            int oldFeq = rfmap.getOrDefault(k - rem , 0);
    //            if( feq != oldFeq){
    //                return false;
    //            }
    //         }
    //     }
    //     return true;
    // }
    // 
    // above code only for +ve value
    //



     public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer> hs = new HashMap<>();
        ///agar array even hi ni hoga to pair to vese hi ni ban payenge
		if(arr.length%2!=0){
		        return false;
		}
		for(int i=0;i<= arr.length-1; i++){
		    int val = arr[i];
		    int mod = val%k;
		    if(mod<0){
		        mod = k+mod;
		    }
		    hs.put(mod,hs.getOrDefault(mod,0)+1);
		}
        ///fir hm hash map par treverse kar ke dekhenge 
		for(Integer val : hs.keySet()){
		    int get = hs.get(val);
            ///agar 0 hai to oska difference k hi hoga jo ki hash map me hoga hi nahi to 0 ke liye check kar lenge agar oski frequency even hai to pair up kar sakta hai
            /// dusra for the even k  agar val k ka half hai to k-val=val hi hoga to os case me bhi val ki frequency even honi chaie
		    if((val==0&&get%2!=0)||(k%2==0&&val*2==k&&get%2!=0)){
		        return false;
		    }else if(val!=0&&val*2!=k){
		        int diff = k-val;
                ///agar diff hai and oska frequency even hai to hm answer true hoga 
		        if(!hs.containsKey(diff)||!hs.get(diff).equals(hs.getOrDefault(val,0))){
		        return false;
		        }
		    }
		}
		return true;
    }

}

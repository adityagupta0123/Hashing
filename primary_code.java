import java.util.*;
class HelloWorld {
    public static void main(String[] args) {
        HashMap<Integer,String> hm = new HashMap<>();
        hm.put(1, "red");
        hm.put(2, "green");
        hm.put(3, "black");
        hm.put(4, "white");
        hm.put(5, "blue");
     
        for(Map.Entry x : hm.entrySet()){
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
}

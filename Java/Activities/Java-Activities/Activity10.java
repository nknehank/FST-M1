package Activities;

import java.util.HashSet;

public class Activity10 {

    public static void main(String[] args) {
        HashSet<String> hash = new HashSet<String>();
        // Adding element to HashSet
        hash.add("ABC");
        hash.add("DEF");
        hash.add("GHI");
        hash.add("JKL");
        hash.add("MNO");
        hash.add("PQR");

        //Print HashSet
        System.out.println("Original HashSet: " + hash);
        //Print size of HashSet
        System.out.println("Size of HashSet: " + hash.size());

        //Remove element
        System.out.println("Removing PQR: " + hash.remove("PQR"));
        //Remove element that is not present
        if(hash.remove("ZZZ")) {
            System.out.println("ZZZ removed from the Set");
        } else {
            System.out.println("ZZZ is not present in the Set");
        }

        //Search for element
        System.out.println("Checking if GHI is present: " + hash.contains("GHI"));
        //Print updated HashSet
        System.out.println("Updated HashSet: " + hash);
    }






}

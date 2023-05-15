package Activities;
import java.util.HashMap;
public class Activity11 {

    public static void main(String[] args) {
HashMap<Integer,String> map = new HashMap<Integer,String>();
//add key value pair in map
        map.put(1,"Pink");
        map.put(2,"green");
        map.put(3,"brown");
        map.put(4,"white");
        map.put(5,"yellow");
        //Print elements of map
        System.out.println("The Original map: " + map);

        // Remove one colour
        map.remove(4);
        //  after removing a colour
        System.out.println("After removing White: " + map);

        // Check if green color exists
        if(map.containsValue("Green")) {
            System.out.println("Green exists ");
        } else {
            System.out.println("Green does not exist ");
        }

        // Print the size of the Map
        System.out.println("Number of pairs in the Map is: " + map.size());
    }
}

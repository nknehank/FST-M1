package Activities;
import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
     //declare array list
        ArrayList<String> myList = new ArrayList<String> ();
        //add objects to array list
        myList.add("Watermelon");
        myList.add("banana");
        myList.add("mango");
        myList.add(3,"papaya");
        myList.add("pineapple");
System.out.println("Print all objects");
for(String str:myList) {
System.out.println(str);
}

        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is muskmelon is in list: " + myList.contains("muskmelon"));
        System.out.println("Size of ArrayList: " + myList.size());

        myList.remove("mango");

        System.out.println("New Size of ArrayList: " + myList.size());


    }

}

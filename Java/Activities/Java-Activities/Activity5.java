package Activities;

//Abstract class
abstract class Book{
    String title;
    abstract void setTitle(String str);
    //concrete method
    String getTitle()
    {
        return title;
    }

}

class MyBook extends Book {
    public void
    setTitle(String str) {
        title = str;
    }
}

public class Activity5 {

    public static void main(String[] args) {

        String title = "Harry Potter";
        Book newNovel = new MyBook();
        newNovel.setTitle(title);
        //Print result
        System.out.println("Title is :" + newNovel.getTitle());

    }
}


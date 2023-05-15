package Activities;

public class Activity1 {
    public static void main(String[] args) {

        Car Swift = new Car();//Object of car class
        Swift.make=2014;
        Swift.color="Black";
        Swift.transmission="Manual";

        //call methods
        Swift.displayCharacterstics();
        Swift.accelerate();
        Swift.brake();




    }

}

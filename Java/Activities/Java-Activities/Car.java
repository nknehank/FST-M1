package Activities;

public class Car {
    String car;
    String color;
    String transmission;
    int make;
    int tyres;
    int doors;
    Car()
    {
        tyres=4;
        doors=4;

    }
    //Methods
    public void displayCharacterstics() {
        System.out.println("Color of the car" + color);
        System.out.println("No of doors of the car" + doors);
        System.out.println("No of tyres of the car" + tyres);
        System.out.println("Color of the car" + make);
        System.out.println("transmission of the car" + transmission);
    }

        public void accelerate()
        {
            System.out.println("Accelerate the car");
        }

        public void brake()
        {
            System.out.println("Stop the car");
        }

    }



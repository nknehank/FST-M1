package Activities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity6 {
    public static void main(String[] args) throws InterruptedException {


//Plane with max 10 passengers
Plane plane = new Plane(10);
//Add passengers on plane
        plane.onboard("Neha");
        plane.onboard("Sanika");
        plane.onboard("Harish");
        //Takeoff Time
        System.out.println("Take off time" + plane.takeOff());
        //passengers in plane
        System.out.println("Passengers while Take off plane" + plane.getPassengers());
        // sleep time
        Thread.sleep(5000);
        //landed
        plane.land();

        //plane landed last time on
        System.out.println("Plane landed on time" + plane.getLastTimeLanded());
        //After landing people are
        System.out.println("After landing plane people are" + plane.getPassengers());

    }
}

class Plane
{
    private List<String> passengers;
    private int maxPass;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    public Plane(int maxPass)
    {
     this.maxPass=maxPass;
     this.passengers=new ArrayList<>();
    }

    public void onboard(String passenger) {
            this.passengers.add(passenger);
        }

        public Date takeOff() {
            this.lastTimeTookOf = new Date();
            return lastTimeTookOf;
        }

        public void land() {
            this.lastTimeLanded = new Date();
            this.passengers.clear();
        }

        public Date getLastTimeLanded() {
            return lastTimeLanded;
        }

        public List<String> getPassengers() {
            return passengers;
        }
    }



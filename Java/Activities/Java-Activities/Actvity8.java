package Activities;

public class Actvity8 {

    public static void main(String[] args) {

        try {
            // Method call with correct input
            Actvity8.exceptionTest("Will print to console");
            // Method call with incorrect input
            Actvity8.exceptionTest(null); // Exception is thrown here
            Actvity8.exceptionTest("Won't execute");
        } catch (CustomException mae) {
            System.out.println("Inside catch block: " + mae.getMessage());
        }

    }

        static void exceptionTest(String str) throws CustomException
        {
            if(str == null) {
                throw new CustomException("String value is null");
            } else {
                System.out.println(str);
            }

        }


    }


class CustomException extends Exception

{
  private String str=null;

      public  CustomException(String str)
        {
            this.str=str;

        }

@Override
public String getMessage() {
        return str;
        }


}

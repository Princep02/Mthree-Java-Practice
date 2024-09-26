package firstday;
class Vehicle{}
//These class explains the use of "instanceof" operator
/*  instanceof is a keyword in java which is used to check whether the object is of a particular type
    it returns true if the object is of that type otherwise it returns false
 */
public class Car  extends Vehicle{
    public static void main(String[] args) {
        Vehicle a = new Car();
        boolean result =  a instanceof Car;
        System.out.println("result = " + result);
    }
}

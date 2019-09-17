package weekthree.tuesday.inheritence;

public class InHouseDoctor extends GenericDoctor {
    boolean makesHouseCalls;

    public InHouseDoctor(){
        doctorType = "In House Doctor";
    }

    private void givesAdvice(){
        System.out.println(doctorType + " is giving advice");
    }
}

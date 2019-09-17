package weekthree.tuesday.inheritence;

public class GenericDoctor{
    String doctorType;
    String[] patients;

    public GenericDoctor(){
        doctorType = "Generic Doctor";
    }

    private void treatPatient(){
        System.out.println("The " + doctorType + " has treat the patient");
    }
}

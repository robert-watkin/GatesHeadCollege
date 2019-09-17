package weekthree.tuesday.inheritence;

public class Surgeon extends GenericDoctor{

    public Surgeon(){
        doctorType = "mofo surgeon";
    }

    public void treatPatient(){
        System.out.println(doctorType + "is now performing surgery");
    }
}

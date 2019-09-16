package weekthree.monday.library;

public class Member {
    public int memberID;
    public String memberForename;
    public String memberSurname;
    public byte memberAge;

    public Member(int memberID, String memberForename, String memberSurname, byte memberAge) {
        this.memberID = memberID;
        this.memberForename = memberForename;
        this.memberSurname = memberSurname;
        this.memberAge = memberAge;
    }
}

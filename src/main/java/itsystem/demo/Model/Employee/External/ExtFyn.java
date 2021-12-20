package itsystem.demo.Model.Employee.External;

public class ExtFyn extends ExternalEmp{

    public ExtFyn(){ super(4, "Fyn");}

    public ExtFyn(Long id, String firstName, String lastName, String initials, int phoneNumber, String address, String superior, String password, String email) {
        super(4, "Fyn", id, firstName, lastName, initials, phoneNumber, address, superior, password, email);
    }

    public ExtFyn(int department, String departmentName, String firstName, String lastName, String initials, int phoneNumber, String address, String superior, String password, String email){
        super(4, "Fyn", firstName, lastName, initials, phoneNumber, address, superior, password, email);
    }
}

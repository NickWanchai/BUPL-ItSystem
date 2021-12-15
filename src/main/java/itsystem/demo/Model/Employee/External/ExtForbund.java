package itsystem.demo.Model.Employee.External;

public class ExtForbund extends ExternalEmp{

    public ExtForbund(){ super(1, "Forbund");}

    public ExtForbund(Long id, String firstName, String lastName, String initials, int phoneNumber, String address, String superior, String password, String email) {
        super(1, "Forbund", id, firstName, lastName, initials, phoneNumber, address, superior, password, email);
    }

    public ExtForbund(int department, String departmentName, String firstName, String lastName, String initials, int phoneNumber, String address, String superior, String password, String email){
        super(1, "Forbund", firstName, lastName, initials, phoneNumber, address, superior, password, email);
    }
}

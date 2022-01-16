package itsystem.demo.Model.Employee;

public class Admin extends Employee {

    public Admin(){
        super(1, "Admin");
    }

    public Admin(Long id, String firstName, String lastName, String initials, int phoneNumber, String address, String superior, String password, String email, String image){
        super(1, "Admin", id, firstName, lastName, initials, phoneNumber, address, superior, password, email, image);
    }

    public Admin(int department, String departmentName, String firstName, String lastName, String initials, int phoneNumber, String address, String superior, String password, String email, String image){
        super(1, "Admin", firstName, lastName, initials, phoneNumber, address, superior, password, email, image);
    }
}

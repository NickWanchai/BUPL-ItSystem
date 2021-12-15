package itsystem.demo.Model.Employee;

import itsystem.demo.Model.Employee.Employee;

public class Support extends Employee {


    public Support(){
        super(2, "Support");
    }

    public Support(Long id, String firstName, String lastName, String initials, int phoneNumber, String address, String superior, String password, String email){

        super(2, "Support", id, firstName, lastName, initials, phoneNumber, address, superior, password, email);
    }

    public Support(int department, String departmentName, String firstName, String lastName, String initials, int phoneNumber, String address, String superior, String password, String email){
        super(2, "Support", firstName, lastName, initials, phoneNumber, address, superior, password, email);
    }
}

package itsystem.demo.Model.Employee;

import itsystem.demo.Model.Employee.Employee;

public class ITdep extends Employee {

    public ITdep(){
        super(3, "IT-drift");
    }

    public ITdep(Long id, String firstName, String lastName, String initials, int phoneNumber, String address, String superior){
        super(3, "IT-drift", id, firstName, lastName, initials, phoneNumber, address, superior);
    }

    public ITdep(int department, String departmentName, String firstName, String lastName, String initials, int phoneNumber, String address, String superior){
        super(3, "IT-drift", firstName, lastName, initials, phoneNumber, address, superior);
    }
}

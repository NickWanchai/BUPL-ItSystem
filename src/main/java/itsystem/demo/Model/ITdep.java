package itsystem.demo.Model;

public class ITdep extends Employee{

    public ITdep(){
        super(3, "IT-drift");
    }

    public ITdep(Long id, String firstName, String lastName, int phoneNumber, String address, String superior){
        super(3, "IT-drift", id, firstName, lastName, phoneNumber, address, superior);
    }

    public ITdep(int department, String departmentName, String firstName, String lastName, int phoneNumber, String address, String superior){
        super(3, "IT-drift", firstName, lastName, phoneNumber, address, superior);
    }
}
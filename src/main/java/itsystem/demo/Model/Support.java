package itsystem.demo.Model;

public class Support extends Employee{


    public Support(){
        super(2, "Support");
    }

    public Support(Long id, String firstName, String lastName, int phoneNumber, String address, String superior){

        super(2, "Support", id, firstName, lastName, phoneNumber, address, superior);
    }

    public Support(int department, String departmentName, String firstName, String lastName, int phoneNumber, String address, String superior){
        super(2, "Support", firstName, lastName, phoneNumber, address, superior);
    }
}

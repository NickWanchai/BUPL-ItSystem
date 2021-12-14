package itsystem.demo.Model.Employee.External;

public class ExtHovedstad extends ExternalEmp{

    public ExtHovedstad(){ super(2, "Hovedstad");}

    public ExtHovedstad(Long id, String firstName, String lastName, String initials, int phoneNumber, String address, String superior) {
        super(2, "Hovedstad", id, firstName, lastName, initials, phoneNumber, address, superior);
    }

    public ExtHovedstad(int department, String departmentName, String firstName, String lastName, String initials, int phoneNumber, String address, String superior){
        super(2, "Hovedstad", firstName, lastName, initials, phoneNumber, address, superior);
    }
}

package itsystem.demo.Model.Employee.External;

public class ExtArhus extends ExternalEmp{

    public ExtArhus(){ super(3, "Århus");}

    public ExtArhus(Long id, String firstName, String lastName, String initials, int phoneNumber, String address, String superior) {
        super(3, "Århus", id, firstName, lastName, initials, phoneNumber, address, superior);
    }

    public ExtArhus(int department, String departmentName, String firstName, String lastName, String initials, int phoneNumber, String address, String superior){
        super(3, "Århus", firstName, lastName, initials, phoneNumber, address, superior);
    }
}

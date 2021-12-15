package itsystem.demo.Model.Employee;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Employee {

    //Unikt id, så hver employee får deres egen plads i databasen
    @Id
    @Column("employee_id")
    private Long id;
    //navn
    private String firstName;
    private String lastName;
    private String initials;
    //tlf nummer
    private int phoneNumber;
    //et int der indikerer afdelingen
    private int department;
    //afdeling - IT-drift, support, admin
    private String departmentName;
    //hvem er vedkomnes leder
    private String superior;
    //adresse
    private String address;
    //email
    private String email;
    //password
    private String password;

    public Employee() {
    }

    public Employee(int department, String departmentName){
        this.department = department;
        this.departmentName = departmentName;
    }

    public Employee(int department, String departmentName, Long id, String firstName, String lastName, String initials, int phoneNumber, String address, String superior, String password, String email){
        this.department = department;
        this.departmentName = departmentName;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.superior = superior;
        this.email = email;
        this.password = password;
    }

    public Employee(String firstName, String lastName, int phoneNumber, int department, String superior, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.superior = superior;
        this.address = address;
    }

    public Employee(int department, String departmentName, String firstName, String lastName, String initials, int phoneNumber, String address, String superior, String password, String email){
        this.department = department;
        this.departmentName = departmentName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.superior = superior;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

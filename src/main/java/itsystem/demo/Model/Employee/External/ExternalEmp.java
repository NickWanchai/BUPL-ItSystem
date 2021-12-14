package itsystem.demo.Model.Employee.External;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class ExternalEmp{

    @Id
    @Column("external_id")
    private Long id;

    private String firstName;
    private String lastName;
    private String initials;
    private int phoneNumber;
    private int department;
    private String departmentName;
    private String superior;
    private String address;

    public ExternalEmp(){}

    public ExternalEmp(int department, String departmentName){
        this.department = department;
        this.departmentName = departmentName;
    }

    public ExternalEmp(int department, String departmentName, Long id, String firstName, String lastName, String initials, int phoneNumber, String address, String superior){
        this.department = department;
        this.departmentName = departmentName;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.superior = superior;
    }

    public ExternalEmp(String firstName, String lastName, int phoneNumber, int department, String superior, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.department = department;
        this.superior = superior;
        this.address = address;
    }

    public ExternalEmp(int department, String departmentName, String firstName, String lastName, String initials, int phoneNumber, String address, String superior){
        this.department = department;
        this.departmentName = departmentName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.initials = initials;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.superior = superior;
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

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
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
}

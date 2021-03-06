package itsystem.demo.Model.Hardware;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Hardware {

    @Id
    @Column("hardware_id")
    private Long id;

    //type indikere om det er en pc, tablet, mobil eller tilbehør
    private int type;
    //id er unikt så de ikke overlapper i db
    // navn på produktet
    private String name;
    // status for at indikere om udstyret f.eks i brug eller kasseret
    private String status;
    // produkttype viser navnet på type
    private String producttype;
    private String productuser;


    public Hardware() {
    }


    public Hardware(int type, String producttype) {
        this.type = type;
        this.producttype = producttype;
    }

    public Hardware(int type, String name, String status, String producttype) {
        this.type = type;
        this.name = name;
        this.status = status;
        this.producttype = producttype;
    }

    public Hardware(int type, Long id, String name, String status, String producttype) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.status = status;
        this.producttype = producttype;
    }

    public Hardware(int type, Long id, String name, String status, String producttype, String productUser) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.status = status;
        this.producttype = producttype;
        this.productuser = productUser;
    }

    public Hardware(int type, String name, String status, String producttype, String productUser) {
        this.type = type;
        this.name = name;
        this.status = status;
        this.producttype = producttype;
        this.productuser = productUser;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getProductuser() {
        return productuser;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }

    public void setProductuser(String productuser) {
        this.productuser = productuser;
    }

    @Override
    public String toString() {
        return "Hardware{" +
                "id=" + id +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", producttype='" + producttype + '\'' +
                ", productUser='" + productuser + '\'' +
                '}';
    }
}

package itsystem.demo.Model;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

public class Hardware {

    //type indikere om det er en pc, tablet, mobil eller tilbehør
    private int type;
    //id er unikt så de ikke overlapper i db
    @Id
    @Column("hardware_id")
    private Long id;
    // navn på produktet
    private String name;
    // status for at indikere om udstyret f.eks i brug eller kasseret
    private String status;
    // produkttype viser navnet på type
    private String producttype;

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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return id;
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

    @Override
    public String toString() {
        return "Hardware{" +
                "type=" + type +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", producttype='" + producttype + '\'' +
                '}';
    }
}

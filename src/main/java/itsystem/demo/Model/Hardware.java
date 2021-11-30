package itsystem.demo.Model;

public class Hardware {

    private int type;
    private int id;
    private String name;
    // private Hardware hardware;
    private String status;
    private String producttype;

    public Hardware() {
    }


    public Hardware(int type, int id, String name, String status) {
        this.type = type;
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        status = status;
    }

    public String getProducttype() {
        return producttype;
    }

    public void setProducttype(String producttype) {
        this.producttype = producttype;
    }
}

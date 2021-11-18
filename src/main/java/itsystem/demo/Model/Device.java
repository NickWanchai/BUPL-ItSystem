package itsystem.demo.Model;

public class Device {

    private String name;
    private String status;
    private String product;
    private String serialNr;
    private int imeiNr;

    public Device() {
    }

    public Device(String name, String status, String product, String serialNr, int imeiNr) {
        this.name = name;
        this.status = status;
        this.product = product;
        this.serialNr = serialNr;
        this.imeiNr = imeiNr;
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

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSerialNr() {
        return serialNr;
    }

    public void setSerialNr(String serialNr) {
        this.serialNr = serialNr;
    }

    public int getImeiNr() {
        return imeiNr;
    }

    public void setImeiNr(int imeiNr) {
        this.imeiNr = imeiNr;
    }
}

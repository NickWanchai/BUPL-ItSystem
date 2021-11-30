package itsystem.demo.Model;

public class Tablet extends Hardware{

    public Tablet() {
        super(3, "Tablet");

    }

    public Tablet(int id, String name, String status) {
        super(3, id, name, status, "Tablet");
    }

    public Tablet(int type, String name, String status, String producttype) {
        super(3, name, status, "Tablet");
    }
}

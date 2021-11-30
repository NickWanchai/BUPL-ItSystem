package itsystem.demo.Model;

public class Peripheral extends Hardware{

    public Peripheral() {
        super(4, "Tilbehør");

    }

    public Peripheral(int id, String name, String status) {
        super(4, id, name, status, "Tilbehør");
    }

    public Peripheral(int type, String name, String status, String producttype) {
        super(4, name, status, "Tilbehør");
    }

}

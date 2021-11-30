package itsystem.demo.Model;

public class Mobil extends Hardware{

    public Mobil() {
        super(2, "Mobil");
    }

    public Mobil(String name, String status) {
        super(name, status);
    }

    public Mobil(int id, String name, String status) {
        super(2, id, name, status, "Mobil");
    }

//    public Mobil(int type, int id, String name, String status, String producttype) {
//        super(2, id, name, status, "mobil");
//    }

    public Mobil(int type, String name, String status, String producttype) {
        super(2, name, status, "mobil");
    }
}

package itsystem.demo.Model;

public class Mobil extends Hardware{

    // Bliver brugt til at vise data i HTML, ikk slet ham Nick W
    public Mobil() {
        super(2, "Mobil");
    }

    public Mobil(int type, String name, String status, String producttype) {
        super(2, name, status, "mobil");
    }
}

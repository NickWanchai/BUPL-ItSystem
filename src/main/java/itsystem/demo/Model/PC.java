package itsystem.demo.Model;

public class PC extends Hardware {


    public PC() {
        super(1, "PC");

    }


    public PC(int type, String name, String status, String producttype) {
        super(1, name, status, "PC");
    }

}

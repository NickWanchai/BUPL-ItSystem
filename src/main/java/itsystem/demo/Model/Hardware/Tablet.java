package itsystem.demo.Model.Hardware;

import itsystem.demo.Model.Hardware.Hardware;

public class Tablet extends Hardware {

    public Tablet() {
        super(3, "Tablet");

    }

    public Tablet(int type, String name, String status, String producttype, String productUser) {
        super(3, name, status, "Tablet", productUser);
    }
}

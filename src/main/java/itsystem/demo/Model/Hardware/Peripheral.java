package itsystem.demo.Model.Hardware;

import itsystem.demo.Model.Hardware.Hardware;

public class Peripheral extends Hardware {

    public Peripheral() {
        super(4, "Tilbehør");

    }

    public Peripheral(int type, String name, String status, String producttype, String productUser) {
        super(4, name, status, "Tilbehør", productUser);
    }

}

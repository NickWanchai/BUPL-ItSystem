package itsystem.demo.Repository.Hardware;
import itsystem.demo.Model.Hardware.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Service
public class HardwareService {

    @Autowired
    private HardwareRepo hardwareRepo;
    @Autowired
    private PCRepo pcRepo;
    @Autowired
    private MobilRepo mobilRepo;
    @Autowired
    private TabletRepo tabletRepo;
    @Autowired
    private PeripheralRepo peripheralRepo;

//Metoder


//Find udstyr
    public List<Hardware> findAllHardware(){
        return (List<Hardware>) hardwareRepo.findAll();
    }

    public List<PC> findAllPC(){
        return (List<PC>) pcRepo.findAll();
    }

    public List<Mobil> findAllMobil(){
        return (List<Mobil>) mobilRepo.findAll();
    }

    public List<Tablet> findAllTablet(){
        return (List<Tablet>) tabletRepo.findAll();
    }

    public List<Peripheral> findAllPeripheral(){
        return (List<Peripheral>) peripheralRepo.findAll();
    }

//Find på id
    public Hardware findHardwareById(Long id){
        return hardwareRepo.findById(id).get();
    }

    public PC findPCById(Long id){
        return pcRepo.findById(id).get();
    }

    public Mobil findMobilById(Long id){
        return mobilRepo.findById(id).get();
    }

    public Tablet findTabletById(Long id){
        return tabletRepo.findById(id).get();
    }

    public Peripheral findPeripheralById(Long id){
        return peripheralRepo.findById(id).get();
    }

//Gem
    public void saveHardware(Hardware hardware){
        hardwareRepo.save(hardware);
    }

//Slet
    public void deleteHardware(Long id){hardwareRepo.deleteById(id);}

    public void deletePC(Long id){
        pcRepo.deleteById(id);
    }

    public void deleteMobil(Long id){
        mobilRepo.deleteById(id);
    }

    public void deleteTablet(Long id){
        tabletRepo.deleteById(id);
    }

    public void deletePeripheral(Long id){
        peripheralRepo.deleteById(id);
    }


//tildel

    public List<Hardware> findByProductuserEquals(String initial){
        return hardwareRepo.findByProductuserEquals(initial);
    }

    public List<PC> findByPCuserEquals(String initial){
        return pcRepo.findByProductuserEquals(initial);
    }
    public List<Mobil> findByMobiluserEquals(String initial){
        return mobilRepo.findByProductuserEquals(initial);
    }
    public List<Peripheral> findByPeripheraluserEquals(String initial){
        return peripheralRepo.findByProductuserEquals(initial);
    }
    public List<Tablet> findByTabletuserEquals(String initial){
        return tabletRepo.findByProductuserEquals(initial);
    }

}

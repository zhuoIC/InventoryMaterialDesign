package com.example.inventorymaterial.repository;

import com.example.inventorymaterial.pojo.Sector;

import java.util.ArrayList;

/**
 * Created by usuario on 30/10/17.
 */

public class SectorRepository {

    /* Declaración*/
    private ArrayList<Sector> sectors;
    private static SectorRepository sectorRepository;

    /* Inicialización
    /* Inicializa todos los atributos de ámbito static o de clase */
    static {
        sectorRepository = new SectorRepository();
    }

    /**
     * El constructor ha de ser privado para garantizar que hay una sola instancia de Repository
     */
    private SectorRepository(){
        this.sectors = new ArrayList<>();
        initialize();
    }

    /* Métodos */
    public void initialize(){
        addSector(new Sector(1, "Armario empotrado", "Armario",
                "Armario empotrado de la esquina.", 2, true, true));
        addSector(new Sector(2, "Pizarra", "Pizarra",
                "Pizarra de 2m x 1m", 1, true, false));
        addSector(new Sector(3, "Armario empotrado", "Armario",
                "Armario empotrado de la esquina.", 2, true, true));
        addSector(new Sector(4, "Pizarra", "Pizarra",
                "Pizarra de 2m x 1m", 1, true, false));
        addSector(new Sector(5, "Armario empotrado", "Armario",
                "Armario empotrado de la esquina.", 2, true, true));
        addSector(new Sector(6, "Pizarra", "Pizarra",
                "Pizarra de 2m x 1m", 1, true, false));
        addSector(new Sector(7, "Armario empotrado", "Armario",
                "Armario empotrado de la esquina.", 2, true, true));
        addSector(new Sector(8, "Pizarra", "Pizarra",
                "Pizarra de 2m x 1m", 1, true, false));
        addSector(new Sector(9, "Armario empotrado", "Armario",
                "Armario empotrado de la esquina.", 2, true, true));
        addSector(new Sector(10, "Pizarra", "Pizarra",
                "Pizarra de 2m x 1m", 1, true, false));
    }

    /* Patrón Singleton*/
    public static SectorRepository getInstance(){
        if(sectorRepository == null)
            sectorRepository = new SectorRepository();
        return sectorRepository;
    }


    /**
     * Método que añade un sector
     * @param sector
     */
    public void addSector(Sector sector){
        sectors.add(sector);
    }

    public ArrayList<Sector> getSectors(){
        return sectors;
    }
}

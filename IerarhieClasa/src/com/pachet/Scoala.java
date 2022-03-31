package com.pachet;

import java.util.*;


public class Scoala {

    HashMap<String, Clasa> mapa = new HashMap<String, Clasa>();
    private static Scanner input = new Scanner(System.in);

    public Scoala()
    {
        mapa.put("A", new Clasa());
        mapa.put("B", new Clasa());
        mapa.put("C", new Clasa());
        mapa.put("D", new Clasa());
    };


    public void AdaugatiProfesor(String clasa)
    {
        System.out.println("\n Se va adauga un profesor \n");
        String adresa;
        adresa = input.nextLine();

        String nume;
        nume = input.nextLine();

        try {
            mapa.get(clasa).adaugaProfesor(adresa, nume);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }


    public void AdaugatiElevi(String clasa, int numar)
    {
        System.out.println("\n Se vor adauga elevii in numar de " + numar);
        for(int i = 0; i < numar; i++)
        {
            String nume;
            String adresa;
            nume = input.nextLine();
            adresa = input.nextLine();
            mapa.get(clasa).adaugaElevi(nume,adresa);
        }

    }

    public void afisatiElevi(String clasa)
    {
        mapa.get(clasa).afisareElevi();
    }

    public void afisatiProfesor(String clasa)
    {
        mapa.get(clasa).afisareProfesori();
    }

    public void atribuieNota(String clasa, String nume, int nota)
    {
        mapa.get(clasa).NotaElev(nume, nota);
    }

    public void atribuieNotaTotiElevii(String clasa, int nota)
    {
        mapa.get(clasa).TotiElevi(nota);
    }

    public void atribuieRandom(String clasa)
    {
        mapa.get(clasa).AtribuieRandom();
    }



}

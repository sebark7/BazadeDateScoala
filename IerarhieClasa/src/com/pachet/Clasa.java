package com.pachet;

import java.util.ArrayList;
import java.util.Random;

public class Clasa
{

    private ArrayList<Elev> ListaElevi = new ArrayList<Elev>();
    public Profesor profesor = null;
    public int numar_note = 0;
    public Clasa()
    {

    }

    public int NumarElevi()
    {
        return ListaElevi.size();
    }


    public String returneazaNumeleElevulNr(int x)
    {
        int nr = 0;

        for(Elev el : ListaElevi)
        {
            if(nr == x)
            {
                return el.returneazaNume();
            }
            nr++;
        }
        return "";
    }

    public String retuneazaAdresaElevNr(int x)
    {


        int nr = 0;

        for(Elev el : ListaElevi)
        {
            if(nr == x)
            {
                return el.returneazaAdresa();
            }
            nr++;
        }
        return "";
    }

    public ArrayList<Integer> returneazaNotaElevNr(int x)
    {
        return  ListaElevi.get(x).getNote();
    }

    public ArrayList<Integer> returneazaNotaElevNr(String x)
    {

        for(Elev el:ListaElevi)
        {
            if(el.returneazaNume().equals(x))
            {
                return  el.getNote();
            }
        }

        return new ArrayList<>();
    }


    public void adaugaProfesor(String nume, String adresa) throws Exception
    {
        if(profesor == null)
        {
            profesor = new Profesor(nume, adresa);

        }
        else
        {
            throw new Exception("Exista deja un profesor");
        }

    }

    public void adaugaElevi(String nume, String adresa)
    {
        ListaElevi.add(new Elev(nume, adresa));
    }

    public void afisareElevi()
    {
        ListaElevi.forEach(valoare -> System.out.println(valoare));
    }


    public void afisareProfesori()
    {
        System.out.println(profesor);
    }

    public void NotaElev(String nume, int nota)
    {
        if(numar_note <= 10)
        {
            for(Elev elev : ListaElevi)
            {
                if(elev.returneazaNume().equals(nume) )
                {
                    elev.adaugaNota(nota);
                }
            }

        }
        else
        {
            System.out.println("S-a depasit numarul maxim de note");
        }

    }


    public void TotiElevi(int nota)
    {
        for(Elev el : ListaElevi)
        {
            el.adaugaNota(nota);
        }
    }

    public String AdresaProfesor()
    {
        return profesor.adresaProfesor();
    }

    public String NumeProfesor()
    {
        return profesor.numeProfesor();
    }

    public int ExistaProfesor()
    {
        return (profesor!=null) ? 1 : 0;
    }

    public void AtribuieRandom()
    {
        Random rand = new Random();


        for(Elev el : ListaElevi)
        {
            int nota_test = rand.nextInt(10) + 1;
            el.adaugaNota(nota_test);
        }
    }

}

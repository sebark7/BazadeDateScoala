package com.pachet;

import java.util.ArrayList;

public class Elev extends Persoana {


    ArrayList<Integer> note = new ArrayList<>();

    public Elev(String nume, String adresa) {
        super(nume, adresa);
    }


    public void adaugaNota(Integer nota) {
        note.add(nota);
    }

    public ArrayList<Integer> getNote()
    {
        return note;
    }

    public int numarNote()
    {
        return note.size();
    }

    public String returneazaNume()
    {
        return this.name;
    }

    public String returneazaAdresa() {return  this.adresa;}

    public int returneazaNota(int nr)
    {
        int x = 0;

        for(Integer el: note)
        {
            if( nr == x )
            {
                return el;
            }
        }
        return 0;
    }


}

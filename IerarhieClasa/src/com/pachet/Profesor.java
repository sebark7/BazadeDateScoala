package com.pachet;

public final class Profesor extends Persoana{

    public Profesor(String nume, String adresa)
    {
        super(nume, adresa);
    }

    public String adresaProfesor()
    {
        return adresa;
    }

    public String numeProfesor()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "name='" + name + '\'' +
                ", adresa='" + adresa + '\'' +
                '}' + '\n';
    }
}

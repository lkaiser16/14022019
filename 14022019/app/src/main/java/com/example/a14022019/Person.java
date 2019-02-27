package com.example.a14022019;

public class Person
{
    String vorname;
    String nachname;
    int id;

    public Person(String vorname, String nachname, int id)
    {
        this.vorname = vorname;
        this.nachname = nachname;
        this.id = id;
    }

    public String getVorname()
    {
        return vorname;
    }

    public void setVorname(String vorname)
    {
        this.vorname = vorname;
    }

    public String getNachname()
    {
        return nachname;
    }

    public void setNachname(String nachname)
    {
        this.nachname = nachname;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return vorname+", "+nachname;
    }
}

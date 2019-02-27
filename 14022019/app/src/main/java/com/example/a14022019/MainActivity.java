package com.example.a14022019;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView v1 = findViewById(R.id.listView);
        Person[] persons = readAssets();
        String[] personen = new String[persons.length];
        for (int i = 0; i < persons.length; i++)
        {
            personen[i] = persons[i].toString();
        }

        ListAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, personen);
        v1.setAdapter(adapter);
//        SearchView searchView = item.get
//        AssetManager.AssetInputStream
//        try (BufferedReader in = new BufferedReader(new FileReader("customers_data.csv")))
//        {
//            String line = in.readLine();
//            while (line != null)
//            {
//                line = in.readLine();
//                String[] personArray = line.split(",");
//                int id = Integer.parseInt(personArray[0]);
//                String vorname = personArray[1];
//                String nachname = personArray[2];
//                Person p = new Person(vorname, nachname, id);
//                System.out.println(p.toString());
//            }
//
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }


    }

    private InputStream getInputStreamForAsset(String filename)
    {// tries to open Stream on Assets. If fails, returns null
        AssetManager assets = getAssets();
        try
        {
            return assets.open(filename);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    private Person[] readAssets()
    {// better store assetfilename as String constant!
        InputStream in = getInputStreamForAsset("customers_data.csv");
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));
        String line;
        List<Person> persons = new ArrayList<>();

        try
        {
            bin.readLine();

            while ((line = bin.readLine()) != null)
            {
                String[] personArray = line.split(",");
                int id = Integer.parseInt(personArray[0]);
                String vorname = personArray[1];
                String nachname = personArray[2];
                Person p = new Person(vorname, nachname, id);
                persons.add(p);
            }
        }
        catch (IOException e)
        {

            e.printStackTrace();
        }
        Person[] arraywithPersons = new Person[persons.size()];
        for (int i = 0; i < persons.size(); i++)
        {
            arraywithPersons[i] = persons.get(i);
        }

        return arraywithPersons;
    }
}

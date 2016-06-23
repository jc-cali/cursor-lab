package org.codeforcoffee.planetssql;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView mTxtPlanetName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHelper db = new DatabaseHelper(this);
        db.createPlanet(1, "Mercury", 1, "pure metal core");
        db.createPlanet(2, "Venus", 2, "very strong electrical field");
        db.createPlanet(3, "Mars", 4, "1 ice cap is water, 1 ice cap is co2");
        db.createPlanet(4, "Jupiter", 5, "insane radiation; no landing on europa");
        db.createPlanet(5, "uranus", 7, "lopsided tilt; as if it were drunk?");
        db.createPlanet(6, "earth", 3, "our only fucking shot");
        db.createPlanet(7, "saturn", 6, "2 moons capable of organic life");
        db.createPlanet(8, "neptune", 8, "is a big, badass, methane, mofo");

        Planets firstPlanet = db.getPlanetByID(1);

        mTxtPlanetName = (TextView) findViewById(R.id.txt_planet);
        mTxtPlanetName.setText(firstPlanet.getName());

        // Build the array for all the planets stored in the planets table
        ArrayList<String> planetArray = db.showAllPlanets();
        ListView listView = (ListView)findViewById(R.id.lst_planet);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,planetArray);
        listView.setAdapter(arrayAdapter);
    }


}

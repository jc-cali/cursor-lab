package org.codeforcoffee.planetssql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by codeforcoffee on 6/22/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "Planets.db";

    public static final String CREATE_TABLE = "create table planets(id int primary key, name text, position int, fact text);";
    public static final String DROP_TABLE = "drop table if exists planets;";

    public DatabaseHelper(Context ctx) {
        super(ctx, DB_NAME, null, DB_VERSION);
        // new SQLiteOpenHelper(ctx, "Planets.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void createPlanet(int id, String name, int position, String fact) {
        SQLiteDatabase db = getReadableDatabase();
        ContentValues planet = new ContentValues();
        planet.put("id", id);
        planet.put("name", name);
        planet.put("position", position);
        planet.put("fact", fact);
        db.insert("planets", null, planet);
    }

    public Planets getPlanetByID(int id) {

        SQLiteDatabase db = getReadableDatabase();
        String[] projection = new String[]{"id","name","position","fact"}; // columns to select
        String selection = "id = ?"; // similar to a WHERE clause
        String[] selectionArguments = new String[] { Integer.toString(id) };
       // String orderBy = "position asc";

        Cursor c = db.query("planets", projection, selection, selectionArguments, null, null, null, null);

        c.moveToFirst();

        int PlanetId = Integer.parseInt(c.getString(c.getColumnIndex("id")));
        String PlanetName = c.getString(c.getColumnIndex("name"));
        int PlanetPosition = Integer.parseInt(c.getString(c.getColumnIndex("position")));
        String PlanetFact = c.getString(c.getColumnIndex("fact"));

        Planets PName = new Planets(PlanetId, PlanetName, PlanetPosition, PlanetFact);
        return PName;

    }

    public ArrayList<String> showAllPlanets(){
    // Method to display all the planets.  Use the cursor to grab the column fields from the planets table, combine it into
    // a single string and store it into the array.  Loop the cursor to grab all the records from the planets table.

        SQLiteDatabase db = getReadableDatabase();
        String orderBy = "position asc";

        Cursor cursor = db.query("planets",
                null, null, null, null, null, orderBy);

        ArrayList<String> planetArray = new ArrayList<>();

        // Grab 1st record in table
        cursor.moveToFirst();
        // Combine all the columns from 1 record in the table to 1 string and add to array.
        while(!cursor.isAfterLast()){
            planetArray.add(cursor.getInt(0)+" - "+cursor.getString(1)+" - "+cursor.getInt(2)+" - "+cursor.getString(3));
            // Get next record from table
            cursor.moveToNext();
        }

        cursor.close();
        // Return the array values.
        return planetArray;
    }



}

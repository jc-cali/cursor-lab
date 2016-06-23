package org.codeforcoffee.planetssql;

/**
 * Created by JC on 6/22/16.
 */
public class Planets {

    public int id;
    public String name;
    public int position;
    public String fact;

    public Planets(int id, String name, int position, String fact) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.fact = fact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}

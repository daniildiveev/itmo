package ru.ifmo.se.lab2;
import ru.ifmo.se.lab2.characters.*;
import ru.ifmo.se.lab2.objects.*;
import ru.ifmo.se.lab2.enums.*;

class Main {
    public static void main(String [] args){
        Znaika z = new Znaika();
        Shorties s = new Shorties();
        Rubber rubber = new Rubber();
        Sphere sphere = new Sphere(rubber);
        Boots boots = new Boots(rubber);
        Flowers flowers = new Flowers();
        Juice j = new Juice();

        String output = z.toString() + z.think(PartOfDay.NONE, 0);
        output = output + z.toString() + z.think(PartOfDay.DAY, 3);
        output = output + z.think(PartOfDay.NIGHT, 3);
        output = output + z.getTheIdea(sphere);

        output = output + s.toString() + s.gather(rubber);

        output = output + flowers.grow(Place.CITY) + flowers.toString() + flowers.lookALike();
        output = output + flowers.makeACut() + j.dripOut() + j.color + j.toString();
        output = output + j.toString() + j.thickify() + j.transform(rubber);
        output = output + boots.getMaterial() + boots.canBeMadeOutOf() + sphere.canBeMadeOutOf();

        System.out.println(output);
    }
}
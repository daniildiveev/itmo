package ru.ifmo.se.lab2;
import ru.ifmo.se.lab2.characters.*;
import ru.ifmo.se.lab2.objects.*;
import ru.ifmo.se.lab2.enums.*;

class Main {
    public static void main(String [] args){
        Znaika z = new Znaika();
        NeZnaika nz = new NeZnaika();
        Shorties s = new Shorties();
        Babies b = new Babies();
        Gunka g = new Gunka();
        Rubber rubber = new Rubber();
        Sphere sphere = new Sphere(rubber);
        Boots boots = new Boots(rubber);
        Flowers flowers = new Flowers();
        Juice juice = new Juice();
        Ball ball = new Ball(rubber);
        Person character = new Person();
        Barrel barrel = new Barrel();

        String output = z.toString() + z.think(PartOfDay.NONE, 0);
        output = output + z.toString() + z.think(PartOfDay.DAY, 3);
        output = output + z.think(PartOfDay.NIGHT, 3);
        output = output + z.getTheIdea() + sphere.toString() + sphere.getMaterial();

        output = output + s.toString() + s.gather(rubber);

        output = output + flowers.grow(Place.CITY) + flowers.toString() + flowers.lookALike();
        output = output + flowers.makeACut() + juice.dripOut() + juice.color + juice.toString();
        output = output + juice.toString() + juice.thickify() + juice.transform(rubber);
        output = output + boots.getMaterial() + boots.canBeMadeOutOf() + ball.canBeMadeOutOf();
        output = output + z.toString() + z.getTheIdea() + z.toString() + z.tell(s);
        output = output + s.gather(juice) + character.toString() + character.carry(juice);
        output = output + z.toString() + z.prepare(barrel);
        output = output + nz.toString() + nz.meet(g) + g.playPrigalki(b, 2); 

        System.out.println(output);
    }
}
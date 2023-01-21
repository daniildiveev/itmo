package ru.ifmo.se.lab3;
import ru.ifmo.se.lab3.characters.*;
import ru.ifmo.se.lab3.objects.*;
import ru.ifmo.se.lab3.enums.*;
import ru.ifmo.se.lab3.exceptions.*;

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
        Person person = new Person();
        Aerostat aerostat = new Aerostat(rubber);

        String output = person.likeTheIdea() + s.neverFly(aerostat);
        b.expressEmotion(Emotions.INTERESTING);
        output = output + b.getEmotion() + aerostat.nobodyKnewHowToMake();
        output = output + z.say() + z.thinkOver() + z.explain();
        output = output + z.think(PartOfDay.NONE, 0) + z.think(PartOfDay.DAY, 3) + z.think(PartOfDay.NIGHT, 3);
        output = output + z.getTheIdea(sphere) + sphere.getMaterial();
        output = output + s.toString() + s.mine(rubber);
        flowers.grow(Place.CITY);
        output = output + flowers.getGrowPlace() + flowers.lookALike();
        output = output + flowers.makeACut() + juice.dripOut();
        juice.specifyType(JuiceParams.WHITE);
        output = output + juice.getType() + juice.toString();
        output = output + juice.toString() + juice.thicken() + juice.transform(rubber);
        output = output + boots.getMaterial() + boots.canBeMadeOutOf() + ball.getMaterial() + ball.canBeMadeOutOf();
        output = output + z.getTheIdea(ball) + z.getTheIdea(boots) + z.tell(b);
        output = output + b.gather(juice);
        juice.specifyType(JuiceParams.RUBBER);
        output = output + juice.getType() + person.carry(juice);
        output = output + z.prepareBarrel();
        output = output + nz.gather(juice);
        output = output + nz.meet(g, Place.STREET);
        
        try{
            output = output + g.playPrigalki(b, 2);
        }
        catch (AmountOfPlayersException e){
            System.out.println(e.getMessage());
        }

        g.expressEmotion(Emotions.JEALOUS);
        output = output + g.getEmotion() + g.toShowOff() + g.say();

        System.out.println(output);
    }
}
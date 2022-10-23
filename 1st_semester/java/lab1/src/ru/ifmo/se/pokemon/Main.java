package ru.ifmo.se.pokemon;

class Main{
    public static void main(String[] args){
        Battle b = new Battle();
        Terrakion p1 = new Terrakion("Terrakion", 1);
        Bergmite p2 = new Bergmite("Bergmite", 1);
        Avalugg p3 = new Avalugg("Avalugg", 1);
        Grubbin p4 = new Grubbin("Grubbin", 1);
        Charjabug p5 = new Charjabug("Charjabug", 1);
        Vikavolt p6 = new Vikavolt("Vikavolt", 1);
        b.addAlly(p1);
        b.addFoe(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addAlly(p5);
        b.addFoe(p6);
        b.go();
    }
}
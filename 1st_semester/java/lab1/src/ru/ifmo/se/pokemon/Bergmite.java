package ru.ifmo.se.pokemon;

class Bergmite extends Pokemon{
    public Bergmite(String name, int level){
        super(name, level);
        setStats(55, 69, 85, 32, 35, 28);
        setType(Type.ICE);
        setMove(new Blizzard(), new IceFang(), new FlashCannon());
    }
}
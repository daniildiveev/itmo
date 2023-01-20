package ru.ifmo.se.lab3.characters;
import ru.ifmo.se.lab3.enums.Emotions;

public class PersonWithEmotions extends Person{
    private String emotion;

    public void expressEmotion(Emotions e){
        switch (e){
            case INTERESTING -> this.emotion = " интересно";
            case JEALOUS -> this.emotion = " завидно";
            default -> this.emotion = ""; 
        }
    }

    public String getEmotion(){
        return this.emotion;
    }

    @Override
    public boolean equals(Object o){
        if (this.getClass() != o.getClass() || o == null){
            return false;
        }

        PersonWithEmotions pwe = (PersonWithEmotions) o;

        return this.emotion == pwe.getEmotion();
    }

    @Override
    public int hashCode(){
        String stringToHash = this.getClass().getSimpleName() + this.emotion;
        return stringToHash.hashCode();
    }
}
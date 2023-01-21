package ru.ifmo.se.lab3.characters;
import ru.ifmo.se.lab3.enums.Emotions;
import ru.ifmo.se.lab3.exceptions.NoEmotionException;

public class PersonWithEmotions extends Person{
    private String emotion = null;

    public void expressEmotion(Emotions e){
        switch (e){
            case INTERESTING -> this.emotion = " интересно";
            case JEALOUS -> this.emotion = " завидно";
            default -> this.emotion = ""; 
        }
    }

    public String getEmotion() throws NoEmotionException{
        if (this.emotion == null){
            throw new NoEmotionException("emotion hasn't been specified yet!");
        }

        return toString() + " это было очень" + this.emotion;
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
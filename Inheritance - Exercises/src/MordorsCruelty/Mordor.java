package MordorsCruelty;

public class Mordor {

    private int happinessPoints;
    private String mood;

    public Mordor() {
    }

    public void eatFood(String food){
        switch (food.toLowerCase()){
            case"cram":
                this.happinessPoints+=2;
                break;
            case"lembas":
                this.happinessPoints+=3;
                break;
            case"apple":
                this.happinessPoints+=1;
                break;
            case"melon":
                this.happinessPoints+=1;
                break;
            case"honeycake":
                this.happinessPoints+=5;
                break;
            case"mushrooms":
                this.happinessPoints+=-10;
                break;
            default:
                this.happinessPoints+=-1;
        }

    }
    public String getMood(){
        String mood = null;
        if (this.happinessPoints<-5){
            mood = "Angry";
        }else if (this.happinessPoints>=-5&&this.happinessPoints<0){
            mood = "Sad";
        }else if (this.happinessPoints>=0&&this.happinessPoints<15){
            mood = "Happy";
        }else if (this.happinessPoints>=15){
            mood = "JavaScript";
        }
        return this.mood = mood;
    }

    @Override
    public String toString() {
        return this.happinessPoints + "\n" + this.getMood() ;
    }
}

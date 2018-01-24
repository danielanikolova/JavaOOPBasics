package app.factories;

import app.races.CasualRace;
import app.races.DragRace;
import app.races.DriftRace;
import app.races.Race;

public final class RaceFactory {

    public RaceFactory() {
    }
    public static Race openRace(String type, int length, String route, int prizePool){

        Race race;
        switch (type){
            case "Casual":
                race = new CasualRace(length, route, prizePool);
                break;
            case "Drag":
                race = new DragRace(length, route, prizePool);
                break;
            case "Drift":
                race = new DriftRace(length, route, prizePool);
                break;
                default:race =null;
        }
       return race;
    }
}

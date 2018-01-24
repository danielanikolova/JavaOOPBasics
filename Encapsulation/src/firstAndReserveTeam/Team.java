package firstAndReserveTeam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Team {
    private String name;
    private List<Person> firstList;
    private List<Person>reserveList;

    public Team(String name) {
        this.setName(name);
        this.firstList = new ArrayList<>();
        this.reserveList = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstList(List<Person> firstList) {
        this.firstList = firstList;
    }

    public void setReserveList(List<Person> reserveList) {
        this.reserveList = reserveList;
    }

    public String getName() {
        return name;
    }

    public List<Person> getFirstList() {

        return Collections.unmodifiableList(firstList);
    }

    public List<Person> getReserveList() {
        return Collections.unmodifiableList(reserveList);
    }

    @Override
    public String toString() {
        return String.format("First team have %d players\nReserve team have %d players",
                this.firstList.size(),
                this.reserveList.size()
                );
    }
}

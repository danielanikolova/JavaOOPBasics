package app.races;

import app.cars.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Race {

    private int length;
    private String route;
    private int prizePool;
    private List<Car> participants;
    private String status = "OPEN";

    protected Race(int length, String route, int prizePool) {
        this.setLength(length);
        this.setRoute(route);
        this.setPrizePool(prizePool);
        this.participants = new ArrayList<>();

    }

    protected int getLength() {
        return this.length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    protected String getRoute() {
        return this.route;
    }

    private void setRoute(String route) {
        this.route = route;
    }

    private void setPrizePool(int prizePool) {
        this.prizePool = prizePool;
    }

    public List<Car> getParticipants() {
        return this.participants;
    }

    public void addCar(Car car){
        this.participants.add(car);
    }

    public String getStatus() {
        return this.status;
    }
    protected void setStatus(String status) {
        this.status = status;
    }

    public String startRace(String type){

        this.setStatus("CLOSED");
        List<Car> winners = this.getParticipants().stream()
                .sorted((a, b)->Integer.compare(b.calculatePerformance(type), a.calculatePerformance(type)))
                .limit(3)
        .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s - %d\n", this.getRoute(), this.getLength()));

        int position = 1;
        for (Car car:winners) {
            int moneyWon =0;
            switch (position){
                case 1:
                    moneyWon = this.prizePool/2;
                    break;
                case 2:
                    moneyWon = this.prizePool*30/100;
                    break;
                case 3:
                    moneyWon = this.prizePool*20/100;
                    break;

            }
            sb.append(String.format("%d. %s %s %dPP - $%d\n",
                    position,
                    car.getBrand(),
                    car.getModel(),
                    car.calculatePerformance(type), moneyWon));
            position++;
        }


        return sb.toString();
    }


}

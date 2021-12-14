package subway.domain;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> stations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void addStation(Station station) {
        stations.add(station);
    }

    public void printLine() {
        System.out.println(this.name);
        for (Station station : stations) {
            station.printStation();
        }
        System.out.println();
    }
}

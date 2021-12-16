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

    public void addStation(Station station) {
        stations.add(station);
    }

    public ArrayList<Station> getStations() {
        return stations;
    }

    public void addStationWithNumber(Station station, int number) {
        stations.add(number - 1, station);
    }

    public void deleteStation(Station station) {
        stations.remove(station);
    }

    public int getIntervalSize() {
        return stations.size();
    }
}

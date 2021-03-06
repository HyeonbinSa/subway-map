package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void addStationInLineByName(String lineName, Station station) {
        Line line = findLineByName(lineName);
        line.addStation(station);
    }

    public static Line findLineByName(String name) {
        for (Line line : lines()) {
            if (line.getName().equals(name)) {
                return line;
            }
        }
        return null;
    }
}

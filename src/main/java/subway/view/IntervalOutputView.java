package subway.view;

import subway.domain.Line;
import subway.domain.Station;

public class IntervalOutputView {
    public void printCreateIntervalSuccess() {
        System.out.println("\n[INFO] 구간이 등록되었습니다.");
    }

    public void printDeleteIntervalSuccess() {
        System.out.println("\n[INFO] 구간이 삭제되었습니다.");
    }

    public void printLineInterval(Line line) {
        System.out.println("[INFO] " + line.getName());
        System.out.println("[INFO] " + "---");
        for (Station station : line.getStations()) {
            System.out.println("[INFO] " + station.getName());
        }
        System.out.println();
    }
}

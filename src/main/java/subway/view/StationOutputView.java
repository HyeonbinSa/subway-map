package subway.view;

import subway.domain.Station;

import java.util.List;

public class StationOutputView {
    public void printCreateStationSuccess() {
        System.out.println("\n[INFO] 지하철 역이 등록되었습니다.");
    }
    public void printDeleteStationSuccess() {
        System.out.println("\n[INFO] 지하철 역이 삭제되었습니다.");
    }
    public void printAllStation(List<Station> stationList) {
        System.out.println("\n## 역 목록");
        for(Station station : stationList){
            System.out.println("[INFO] "+station.getName());
        }
        System.out.println("");
    }
}

package subway.validator;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class IntervalValidator {
    private static final List<String> menuList = Arrays.asList("1", "2", "B");

    /**
     * 1. 입력
     * 1. 노선 입력 시 검증
     * - 선택한 노선이 없을 경우
     * 2. 역 이름 입력 시 검증
     * - 해당 역이  Stations에 존재하지 않는 경우
     * - 노선에 이미 등록되어 있는 경우
     * - 입력할 수 없는 위치에 입력했을 경우
     * 2. 삭제
     * 1. 노선 입력 시 검증
     * - 선택한 노선이 없는 경우
     * 2. 해당 노선의 사이즈가 2보다 작을 경우
     * 3. 역 이름 입력  검증
     * - 해당 역이 존재하지 않는 경우
     * - 노선 내에 없는 경우
     * - 해당 역 이름 제거 시 1개 이하가 될 경우
     */
    public void validateSelectMenu(String menu) {
        if (!menuList.contains(menu)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }

    public void validateExistLine(String lineName) {
        if (LineRepository.findLineByName(lineName) == null) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 노선입니다.");
        }
    }

    public void validateExistStationByName(String stationName) {
        if (StationRepository.getStationByName(stationName) == null) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    public void validateExistStationInLine(Line line, Station station) {
        if (line.getStations().contains(station)) {
            throw new IllegalArgumentException("[ERROR] 노선에 이미 존재하는 역입니다.");
        }
    }

    public void validateNotExistStationInLine(Line line, Station station) {
        if (!line.getStations().contains(station)) {
            throw new IllegalArgumentException("[ERROR] 노선에 존재하지 않는 역입니다.");
        }
    }

    public void validateOnlyNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다.");
        }
    }

    public void validateIntervalNumber(Line line, int number) {
        if (line.getIntervalSize() < number) {
            throw new IllegalArgumentException("[ERROR] 상행 종점과 하행 종점 사이에 위치해야합니다.");
        }
        if (1 > number) {
            throw new IllegalArgumentException("[ERROR] 상행 종점역보다 앞에 위치할 수 없습니다.");
        }
    }
    public void validateMinimumTwoStation(Line line){
        if(line.getIntervalSize() <= 2){
            throw new IllegalArgumentException("[ERROR] 구간은 최소 2개역이 포함되어있어야합니다.");
        }
    }
}

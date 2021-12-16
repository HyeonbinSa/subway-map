package subway.validator;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class IntervalValidator {
    private static final List<String> menuList = Arrays.asList("1", "2", "B");

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

    public void validateMinimumTwoStation(Line line) {
        if (line.getIntervalSize() <= 2) {
            throw new IllegalArgumentException("[ERROR] 구간은 최소 2개역이 포함되어있어야합니다.");
        }
    }
}

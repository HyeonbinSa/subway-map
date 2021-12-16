package subway.validator;

import subway.domain.LineRepository;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class LineValidator {
    private static final List<String> menuList = Arrays.asList("1", "2", "3", "B");

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

    public void validateDuplicateLine(String lineName) {
        if (LineRepository.findLineByName(lineName) != null) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 노선입니다.");
        }
    }

    public void validateLongerThanTwo(String lineName) {
        if (lineName.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 노선 이름은 최소 2자 이상입니다.");
        }
    }

    public void validateStartStationName(String start) {
        if (StationRepository.getStationByName(start) == null) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 상행 종점역입니다.");
        }
    }

    public void validateEndStationName(String end) {
        if (StationRepository.getStationByName(end) == null) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 하행 종점역입니다.");
        }
    }

    public void validateSameStation(String start, String end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException("[ERROR] 상행 종점역과 하행 종점역이 같을 수 없습니다.");
        }
    }
}

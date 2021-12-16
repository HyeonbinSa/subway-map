package subway.validator;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

import java.util.Arrays;
import java.util.List;

public class StationValidator {
    private static final List<String> menuList = Arrays.asList("1", "2", "3", "B");

    public void validateSelectMenu(String menu) {
        if (!menuList.contains(menu)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }

    public void validateExistStation(String stationName) {
        if (StationRepository.getStationByName(stationName) == null) {
            throw new IllegalArgumentException("[ERROR] 존재하지 않는 역입니다.");
        }
    }

    public void validateDuplicateStation(String stationName) {
        if (StationRepository.getStationByName(stationName) != null) {
            throw new IllegalArgumentException("[ERROR] 이미 존재하는 역입니다.");
        }
    }

    public void validateLongerThanTwo(String stationName) {
        if (stationName.length() < 2) {
            throw new IllegalArgumentException("[ERROR] 역이름은 최소 2자 이상입니다.");
        }
    }

    public void validateEnrolledLine(String stationName) {
        Station station = StationRepository.getStationByName(stationName);
        for (Line line : LineRepository.lines()) {
            if (line.getStations().contains(station)) {
                throw new IllegalArgumentException("[ERROR] 해당 역이 포함된 구간이 존재합니다.");
            }
        }
    }
}

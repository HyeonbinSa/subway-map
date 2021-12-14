package subway;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class InitialSetting {
    private static final String GYODAE = "교대";
    private static final String GANGNAM = "강남";
    private static final String YEOKSAM = "역삼";
    private static final String NAMBUTERMINAL = "남부터미널";
    private static final String YANGJAE = "양재";
    private static final String YANGJAEFOREST = "양재시민의숲";
    private static final String MAEBONG = "매봉";
    private static final String LINE_TWO = "2호선";
    private static final String LINE_THREE = "3호선";
    private static final String LINE_NEW_BUNDANG = "신분당선";

    public void initSetting() {
        StationRepository.addStation(new Station(GYODAE));
        StationRepository.addStation(new Station(GANGNAM));
        StationRepository.addStation(new Station(YEOKSAM));
        StationRepository.addStation(new Station(NAMBUTERMINAL));
        StationRepository.addStation(new Station(YANGJAE));
        StationRepository.addStation(new Station(YANGJAEFOREST));
        StationRepository.addStation(new Station(MAEBONG));

        LineRepository.addLine(new Line(LINE_TWO));
        LineRepository.addLine(new Line(LINE_THREE));
        LineRepository.addLine(new Line(LINE_NEW_BUNDANG));

        LineRepository.addStationInLineByName(LINE_TWO, StationRepository.getStationByName(GYODAE));
        LineRepository.addStationInLineByName(LINE_TWO, StationRepository.getStationByName(GANGNAM));
        LineRepository.addStationInLineByName(LINE_TWO, StationRepository.getStationByName(YEOKSAM));

        LineRepository.addStationInLineByName(LINE_THREE, StationRepository.getStationByName(GYODAE));
        LineRepository.addStationInLineByName(LINE_THREE, StationRepository.getStationByName(NAMBUTERMINAL));
        LineRepository.addStationInLineByName(LINE_THREE, StationRepository.getStationByName(YANGJAE));
        LineRepository.addStationInLineByName(LINE_THREE, StationRepository.getStationByName(MAEBONG));

        LineRepository.addStationInLineByName(LINE_NEW_BUNDANG, StationRepository.getStationByName(GANGNAM));
        LineRepository.addStationInLineByName(LINE_NEW_BUNDANG, StationRepository.getStationByName(YANGJAE));
        LineRepository.addStationInLineByName(LINE_NEW_BUNDANG, StationRepository.getStationByName(YANGJAEFOREST));

        LineRepository.printLine();
        StationRepository.printStations();
    }
}

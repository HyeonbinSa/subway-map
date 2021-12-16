package subway.controller;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.StationInputView;
import subway.view.StationOutputView;

import java.util.List;
import java.util.Scanner;

public class StationController {
    private Scanner scanner;
    private StationInputView stationInputView;
    private StationOutputView stationOutputView;

    public void run(Scanner scanner) {
        this.scanner = scanner;
        stationInputView = new StationInputView();
        stationOutputView = new StationOutputView();
        stationInputView.printStationMenu();
        stationInputView.printSelectMenu();
        String menu = scanner.nextLine();
        selectMenu(menu);
    }

    public void selectMenu(String menu) {
        if (menu.equals("1")) {
            createStation();
        }
        if (menu.equals("2")) {
            removeStation();
        }
        if (menu.equals("3")) {
            getStations();
        }
        if (menu.equals("Q")) {

        }
    }

    public void createStation() {
        stationInputView.printCreateStation();
        String stationName = scanner.nextLine();
        StationRepository.addStation(new Station(stationName));
        stationOutputView.printCreateStationSuccess();
    }

    public void removeStation() {
        stationInputView.printRemoveStation();
        String stationName = scanner.nextLine();
        if (StationRepository.deleteStation(stationName)) {
            stationOutputView.printDeleteStationSuccess();
        }
    }

    public void getStations() {
        List<Station> stationList = StationRepository.stations();
        stationOutputView.printAllStation(stationList);
    }
}

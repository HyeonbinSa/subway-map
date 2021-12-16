package subway.controller;

import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.StationValidator;
import subway.view.InputView;
import subway.view.OutputView;
import subway.view.StationInputView;
import subway.view.StationOutputView;

import java.util.List;
import java.util.Scanner;

public class StationController {
    private Scanner scanner;
    private StationInputView stationInputView = new StationInputView();
    private StationOutputView stationOutputView = new StationOutputView();
    private StationValidator stationValidator = new StationValidator();
    public  StationController(Scanner scanner){
        this.scanner = scanner;
    }
    public void run() {
        while(true){
            try{
                stationInputView.printStationMenu();
                stationInputView.printSelectMenu();
                String menu = scanner.nextLine();
                selectMenu(menu);
                break;
            }catch(IllegalArgumentException exception){
                System.out.println(exception.getMessage());
            }
        }
    }

    public void selectMenu(String menu) {
        stationValidator.validateSelectMenu(menu);
        if (menu.equals("1")) {
            createStation();
        }
        if (menu.equals("2")) {
            removeStation();
        }
        if (menu.equals("3")) {
            getStations();
        }
        if (menu.equals("B")) {
            return;
        }
    }

    public void createStation() {
        stationInputView.printCreateStation();
        String stationName = scanner.nextLine();
        stationValidator.validateLongerThanTwo(stationName);
        stationValidator.validateDuplicateStation(stationName);
        StationRepository.addStation(new Station(stationName));
        stationOutputView.printCreateStationSuccess();
    }

    public void removeStation() {
        stationInputView.printRemoveStation();
        String stationName = scanner.nextLine();
        stationValidator.validateExistStation(stationName);
        stationValidator.validateEnrolledLine(stationName);
        if (StationRepository.deleteStation(stationName)) {
            stationOutputView.printDeleteStationSuccess();
        }
    }

    public void getStations() {
        List<Station> stationList = StationRepository.stations();
        stationOutputView.printAllStation(stationList);
    }
}

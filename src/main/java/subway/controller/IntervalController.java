package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.IntervalValidator;
import subway.view.IntervalInputView;
import subway.view.IntervalOutputView;

import java.util.Scanner;

public class IntervalController {
    private Scanner scanner;
    private IntervalInputView intervalInputView = new IntervalInputView();
    private IntervalValidator intervalValidator = new IntervalValidator();
    private IntervalOutputView intervalOutputView = new IntervalOutputView();

    public IntervalController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            try {
                intervalInputView.printIntervalMenu();
                intervalInputView.printSelectIntervalMenu();
                String menu = scanner.nextLine();
                selectMenu(menu);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void selectMenu(String menu) {
        intervalValidator.validateSelectMenu(menu);
        if (menu.equals("1")) {
            createInterval();
        }
        if (menu.equals("2")) {
            removeInterval();
        }
        if (menu.equals("B")) {
            return;
        }
    }

    public void createInterval() {
        intervalInputView.printInputLineNumber();
        String lineName = scanner.nextLine();
        intervalValidator.validateExistLine(lineName);
        Line line = LineRepository.findLineByName(lineName);

        intervalInputView.printInputStationName();
        String stationName = scanner.nextLine();
        intervalValidator.validateExistStationByName(stationName);
        Station station = StationRepository.getStationByName(stationName);

        intervalValidator.validateExistStationInLine(line, station);

        intervalInputView.printInputIntervalNumber();
        String intervalNumber = scanner.nextLine();
        intervalValidator.validateOnlyNumber(intervalNumber);
        int integerNumber = Integer.parseInt(intervalNumber);
        intervalValidator.validateIntervalNumber(line, integerNumber);
        line.addStationWithNumber(station, integerNumber);
        intervalOutputView.printCreateIntervalSuccess();
    }

    public void removeInterval() {
        intervalInputView.printInputRemoveLineNumber();
        String lineName = scanner.nextLine();
        intervalValidator.validateExistLine(lineName);
        Line line = LineRepository.findLineByName(lineName);
        intervalValidator.validateMinimumTwoStation(line);

        intervalInputView.printInputRemoveStation();
        String stationName = scanner.nextLine();
        intervalValidator.validateExistStationByName(stationName);
        Station station = StationRepository.getStationByName(stationName);
        intervalValidator.validateNotExistStationInLine(line, station);
        line.deleteStation(station);
        intervalOutputView.printDeleteIntervalSuccess();
    }

    public void getInterval() {
        for (Line line : LineRepository.lines()) {
            intervalOutputView.printLineInterval(line);
        }
    }
}

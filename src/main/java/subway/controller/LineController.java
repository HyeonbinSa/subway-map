package subway.controller;

import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.validator.LineValidator;
import subway.view.LineInputView;
import subway.view.LineOutputView;

import java.util.List;
import java.util.Scanner;

public class LineController {
    private Scanner scanner;
    private LineInputView lineInputView = new LineInputView();
    private LineOutputView lineOutputView = new LineOutputView();
    private LineValidator lineValidator = new LineValidator();

    public LineController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        while (true) {
            try {
                lineInputView.printLineMenu();
                lineInputView.printSelectMenu();
                String menu = scanner.nextLine();
                selectMenu(menu);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public void selectMenu(String menu) {
        lineValidator.validateSelectMenu(menu);
        if (menu.equals("1")) {
            createLine();
        }
        if (menu.equals("2")) {
            removeLine();
        }
        if (menu.equals("3")) {
            getLines();
        }
        if (menu.equals("B")) {
            return;
        }
    }

    public void createLine() {
        lineInputView.printCreateLine();
        String lineName = scanner.nextLine();
        lineValidator.validateLongerThanTwo(lineName);
        lineValidator.validateDuplicateLine(lineName);
        lineInputView.printInputStartStation();
        String startStation = scanner.nextLine();
        lineValidator.validateStartStationName(startStation);
        lineInputView.printInputEndStation();
        String endStation = scanner.nextLine();
        lineValidator.validateEndStationName(endStation);
        lineValidator.validateSameStation(startStation, endStation);
        Station start = StationRepository.getStationByName(startStation);
        Station end = StationRepository.getStationByName(endStation);
        Line line = new Line(lineName);
        line.addStation(start);
        line.addStation(end);
        LineRepository.addLine(line);
    }

    public void removeLine() {
        lineInputView.printRemoveLine();
        String lineName = scanner.nextLine();
        lineValidator.validateExistLine(lineName);
        LineRepository.deleteLineByName(lineName);
    }

    public void getLines() {
        List<Line> lineList = LineRepository.lines();
        lineOutputView.printAllLine(lineList);
    }
}

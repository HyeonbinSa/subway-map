package subway;

import subway.controller.LineController;
import subway.controller.IntervalController;
import subway.controller.StationController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {
    private Scanner scanner;
    private InputView inputView;
    private StationController stationController;
    private LineController lineController;
    private IntervalController intervalController;

    public SubwayController(Scanner scanner) {
        InitialSetting initialSetting = new InitialSetting();
        initialSetting.initSetting();
        this.scanner = scanner;
        stationController = new StationController(scanner);
        lineController = new LineController(scanner);
        intervalController = new IntervalController(scanner);
        this.inputView = new InputView();
    }

    public void run() {
        runMainMenu();
    }

    public void runMainMenu() {
        boolean flag = true;
        while (flag) {
            inputView.printMainFunction();
            inputView.printSelectFunction();
            String selectMenu = scanner.nextLine();
            flag = checkMainMenuSelection(selectMenu);
        }
    }

    public boolean checkMainMenuSelection(String selectMenu) {
        if (selectMenu.equals("Q")) {
            return false;
        }
        if (selectMenu.equals("1")) {
            runStationMenu();
        }
        if (selectMenu.equals("2")) {
            runLineMenu();
        }
        if (selectMenu.equals("3")) {
            runLineInfoMenu();
        }
        if (selectMenu.equals("4")) {
            printLineInfo();
        }
        return true;
    }

    public void runStationMenu() {
        stationController.run();
    }

    public void runLineMenu() {
        lineController.run();
    }

    public void runLineInfoMenu() {
        intervalController.run();
    }

    public void printLineInfo() {
        intervalController.getInterval();
    }
}

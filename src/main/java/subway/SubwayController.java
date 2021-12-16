package subway;

import subway.controller.LineController;
import subway.controller.StationController;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {
    private Scanner scanner;
    private InputView inputView;
    private StationController stationController;
    private LineController lineController;

    public SubwayController(Scanner scanner) {
        InitialSetting initialSetting = new InitialSetting();
        initialSetting.initSetting();
        this.scanner = scanner;
        stationController = new StationController(scanner);
        lineController = new LineController(scanner);
        this.inputView = new InputView(scanner);
    }

    public void run() {
        runMainMenu();
    }

    public void runMainMenu() {
        boolean flag = true;
        while (flag) {
            OutputView.printMainFunction();
            String selectMenu = inputView.printSelectFunction();
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
        OutputView.printLineInfoMenu();
    }

    public void printLineInfo() {
        // 4. 지하철 노선도 출력
    }
}

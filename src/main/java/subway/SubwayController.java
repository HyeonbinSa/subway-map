package subway;

import subway.view.InputView;
import subway.view.OutputView;

import java.util.Scanner;

public class SubwayController {
    private Scanner scanner;
    private InputView inputView;

    public SubwayController(Scanner scanner) {
        InitialSetting initialSetting = new InitialSetting();
        initialSetting.initSetting();
        this.scanner = scanner;
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
        OutputView.printStationMenu();
    }

    public void runLineMenu() {
        OutputView.printLineMenu();
    }

    public void runLineInfoMenu() {
        OutputView.printLineInfoMenu();
    }

    public void printLineInfo() {
        // 구간 출력
    }
}

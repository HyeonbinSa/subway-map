package subway.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String printSelectFunction() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
        String selectMenu = scanner.nextLine();
        return selectMenu;
    }
}

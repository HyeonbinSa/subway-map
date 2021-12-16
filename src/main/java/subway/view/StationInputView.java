package subway.view;

import java.util.Scanner;

public class StationInputView {
    public void printStationMenu() {
        System.out.println("## 역 관리 화면");
        System.out.println("1. 역 등록");
        System.out.println("2. 역 삭제");
        System.out.println("3. 역 조회");
        System.out.println("B. 돌아가기");
    }

    public void printSelectMenu() {
        System.out.println("## 원하는 기능을 선택하세요.");
    }

    public void printCreateStation() {
        System.out.println("## 등록할 역 이름을 입력하세요.");
    }

    public void printRemoveStation() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
    }

}

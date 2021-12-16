package subway.view;

public class IntervalInputView {
    public void printIntervalMenu() {
        System.out.println("\n## 구간 관리 화면");
        System.out.println("1. 구간 등록");
        System.out.println("2. 구간 삭제");
        System.out.println("B. 돌아가기");
    }

    public void printSelectIntervalMenu() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public void printInputLineNumber() {
        System.out.println("\n## 노선을 입력하세요.");
    }

    public void printInputStationName() {
        System.out.println("\n## 역이름을 입력하세요.");
    }

    public void printInputIntervalNumber() {
        System.out.println("\n## 순서를 입력하세요.");
    }

    public void printInputRemoveLineNumber() {
        System.out.println("\n## 삭제할 구간의 노선을 입력하세요.");
    }

    public void printInputRemoveStation() {
        System.out.println("\n## 삭제할 구간의 역을 입력하세요.");
    }
}

package subway.view;

public class LineInputView {
    public void printLineMenu() {
        System.out.println("\n## 노선 관리 화면");
        System.out.println("1. 노선 등록");
        System.out.println("2. 노선 삭제");
        System.out.println("3. 노선 조회");
        System.out.println("B. 돌아가기");
    }

    public void printSelectMenu() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public void printCreateLine() {
        System.out.println("\n## 등록할 노선 이름을 입력하세요.");
    }

    public void printInputStartStation() {
        System.out.println("\n## 등록할 노선의 상행 종점역 이름을 입력하세요.");
    }

    public void printInputEndStation() {
        System.out.println("\n## 등록할 노선의 하행 종점역 이름을 입력하세요.");
    }

    public void printRemoveLine() {
        System.out.println("\n## 삭제할 노선 이름을 입력하세요.");
    }
}

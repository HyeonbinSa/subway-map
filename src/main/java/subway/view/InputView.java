package subway.view;

public class InputView {
    public void printSelectFunction() {
        System.out.println("\n## 원하는 기능을 선택하세요.");
    }

    public static void printMainFunction() {
        System.out.println("\n## 메인 화면");
        System.out.println("1. 역 관리");
        System.out.println("2. 노선 관리");
        System.out.println("3. 구간 관리");
        System.out.println("4. 지하철 노선도 출력");
        System.out.println("Q. 종료");
    }
}

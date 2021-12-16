package subway.view;

import subway.domain.Line;

import java.util.List;

public class LineOutputView {
    public void printAllLine(List<Line> lineList) {
        System.out.println("\n## 노선 목록");
        for (Line line : lineList) {
            System.out.println("[INFO] " + line.getName());
        }
        System.out.println("");
    }
}

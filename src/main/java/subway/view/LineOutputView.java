package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class LineOutputView {
    public void printAllLine(List<Line> lineList) {
        System.out.println("\n## 노선 목록");
        for(Line line : lineList){
            System.out.println("[INFO] "+line.getName());
        }
        System.out.println("");
    }
//    public void  printLine(Line  line){
//        System.out.println("[INFO] " + line.getName());
//    }
//    public void printLineInfo(Line line){
//        System.out.println(line.getName());
//        for(Station station : line.getStations()){
//            System.out.println("[INFO] "+station.getName());
//        }
//    }
}

package Lv1;

import java.util.*;

/**
 *  프로그래머스 : 바탕화면 정리
 *
 *  문제 설명
 *
 *   머쓱이는 최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 한 번에 지우려고 하며 드래그로 파일들을 선택하는 방법은 다음과 같습니다.
 *
 *  드래그는 바탕화면의 격자점 S(lux, luy)를 마우스 왼쪽 버튼으로 클릭한 상태로 격자점 E(rdx, rdy)로 이동한 뒤 마우스 왼쪽 버튼을 떼는 행동입니다.
 *  이때, "점 S에서 점 E로 드래그한다"고 표현하고 점 S와 점 E를 각각 드래그의 시작점, 끝점이라고 표현합니다.
 *  점 S(lux, luy)에서 점 E(rdx, rdy)로 드래그를 할 때, "드래그 한 거리"는 |rdx - lux| + |rdy - luy|로 정의합니다.
 *  점 S에서 점 E로 드래그를 하면 바탕화면에서 두 격자점을 각각 왼쪽 위, 오른쪽 아래로 하는 직사각형 내부에 있는 모든 파일이 선택됩니다.
 *  머쓱이의 컴퓨터 바탕화면의 상태를 나타내는 문자열 배열 wallpaper가 매개변수로 주어질 때 바탕화면의 파일들을 한 번에 삭제하기 위해 최소한의 이동거리를
 *  갖는 드래그의 시작점과 끝점을 담은 정수 배열을 return하는 solution 함수를 작성해 주세요. 드래그의 시작점이 (lux, luy), 끝점이 (rdx, rdy)라면
 *  정수 배열 [lux, luy, rdx, rdy]를 return하면 됩니다.
 *
 *  풀이 과정
 *
 *  - x,y 좌표의 위치를 구하고 리스트에 넣어준다
 *  - 예를 들어 "#"의 위치가 [1,0]에 하나만 있었다면 [1,0,2,1]이다
 *  - 즉, 최소 드래그는 [y좌표 최소, x좌표 최소, y좌표 최대 + 1, x좌표 최대 +1]가 될 것이다
 *
 */

public class DesktopCleanup {
    public int[] solution(String[] wallpaper) {
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();

        for (int i = 0; i < wallpaper.length; i++) {
            String[] split = wallpaper[i].split("");

            for (int j = 0; j < split.length; j++) {
                if(split[j].equals("#")){
                    x.add(j);
                    y.add(i);
                }
            }
        }

        int xMin = Collections.min(x);
        int yMin = Collections.min(y);
        int xMax = Collections.max(x);
        int yMax = Collections.max(y);

        return new int[]{yMin, xMin, yMax + 1, xMax + 1};
    }

    public static void main(String[] args) {
        String[] wallpaper = {".#...", "..#..", "...#."};
        DesktopCleanup desktopCleanup = new DesktopCleanup();
        System.out.println(Arrays.toString(desktopCleanup.solution(wallpaper)));
    }
}
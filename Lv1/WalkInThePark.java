package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : 공원 산책
 *
 *  문제 설명
 *
 *  로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
 *
 *  지나다니는 길을 'O', 장애물을 'X'로 나타낸 직사각형 격자 모양의 공원에서 로봇 강아지가 산책을 하려합니다
 *  로봇 강아지는 명령을 수행하기 전에 다음 두 가지를 먼저 확인합니다.
 *  - 주어진 방향으로 이동할 때 공원을 벗어나는지 확인합니다.
 *  - 주어진 방향으로 이동 중 장애물을 만나는지 확인합니다.
 *  위 두 가지중 어느 하나라도 해당된다면, 로봇 강아지는 해당 명령을 무시하고 다음 명령을 수행합니다.
 *
 *  공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때,
 *  로봇 강아지가 모든 명령을 수행 후 놓인 위치를 [세로 방향 좌표, 가로 방향 좌표] 순으로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *
 *  - park를 이용한 반복으로 시작 위치인 S의 좌표를 구하고, park를 펼친 2차원 배열의 parkBoard를 생성한다.
 *  - routes를 이용한 반복으로 각각 N,S,W,E에 따라 이동한다
 *      - 만약 위치를 벗어나거나 X를 만나게 되면 flag를 통해 이동하지 않도록 설정해준다
 */

public class WalkInThePark {
    public int[] solution(String[] park, String[] routes) {
        int[] locationOfS = new int[2];
        int[] currentLocation;
        int lastRightPosition = park[0].split("").length - 1;
        int lastBottomPosition = park.length - 1;
        String[][] parkBoard = new String[lastBottomPosition + 1][lastRightPosition + 1];

        for (int i = 0; i < park.length; i++) {
            String[] parkSplit = park[i].split("");
            for (int j = 0; j < parkSplit.length; j++) {
                parkBoard[i][j] = parkSplit[j];
                if(parkSplit[j].equals("S")){
                    locationOfS[0] = i;
                    locationOfS[1] = j;
                }
            }
        }
        currentLocation = Arrays.copyOf(locationOfS, locationOfS.length);

        for (int i = 0; i < routes.length; i++) {
            String[] routeSplit = routes[i].split("\\s");
            boolean flag = false;
            for (int j = 0; j < Integer.parseInt(routeSplit[1]); j++) {
                switch (routeSplit[0]){
                    case "E":
                        currentLocation[1] += 1;
                        if(lastRightPosition < currentLocation[1] || parkBoard[currentLocation[0]][currentLocation[1]].equals("X")){
                            flag = true;
                        }
                        break;
                    case "N":
                        currentLocation[0] -= 1;
                        if(currentLocation[0] < 0 || parkBoard[currentLocation[0]][currentLocation[1]].equals("X")){
                            flag = true;
                        }
                        break;
                    case "S":
                        currentLocation[0] += 1;
                        if(lastBottomPosition < currentLocation[0] || parkBoard[currentLocation[0]][currentLocation[1]].equals("X")){
                            flag = true;
                        }
                        break;
                    case "W":
                        currentLocation[1] -= 1;
                        if(currentLocation[1] < 0 || parkBoard[currentLocation[0]][currentLocation[1]].equals("X")){
                            flag = true;
                        }
                        break;
                }
            }
            if(flag){
                currentLocation = Arrays.copyOf(locationOfS, locationOfS.length);
            }else{
                locationOfS =  Arrays.copyOf(currentLocation, currentLocation.length);
            }
        }

        return currentLocation;
    }

    public static void main(String[] args) {
        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};
        WalkInThePark walkInThePark = new WalkInThePark();
        System.out.println(Arrays.toString(walkInThePark.solution(park,routes)));
    }
}
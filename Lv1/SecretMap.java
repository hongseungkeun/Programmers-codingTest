package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : [1차] 비밀지도
 *
 *  문제 설명
 *
 *  네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다.
 *  그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다.
 *  다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
 *
 *  - 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
 *  - 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다.
 *      - 각각 "지도 1"과 "지도 2"라고 하자.
 *      - 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다.
 *      - 지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
 *  - "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
 *  - 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
 *  - 네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.
 *
 *  풀이 과정
 *  - toBinaryString을 이용해서 arr1과 arr2의 2진수의 2진수의 OR 비트연산을 한 문자열을 만든다
 *  - 앞이 0이라면 사라져 n의 길이와 맞지 않으므로 n - bi(위에서 만든 문자열)의 길이만큼 "0"을 만들어주고 bi와 합친다
 *  - bi의 "1"은 "#"으로, "0"은 공백으로 변환한다
 */

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < arr1.length; i++) {
            String bi = Integer.toBinaryString(arr1[i] | arr2[i]);
            bi = "0".repeat(n - bi.length()) + bi;
            answer[i] = bi.replaceAll("1", "#").replaceAll("0"," ");
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] arr1 = {46, 33, 33 ,22, 31, 50};
        int[] arr2 = {27 ,56, 19, 14, 14, 10};
        SecretMap secretMap = new SecretMap();
        System.out.println(Arrays.toString(secretMap.solution(n, arr1, arr2)));
    }
}

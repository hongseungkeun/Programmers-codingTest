package Lv1;

import java.util.Arrays;

/**
 * 프로그래머스 : 최소직사각형
 *
 * 모든 명함의 가로 길이와 세로 길이를 나타내는 2차원 배열 sizes가 매개변수로 주어집니다.
 * 모든 명함을 수납할 수 있는 가장 작은 지갑을 만들 때, 지갑의 크기를 return 하도록 solution 함수를 완성해주세요.
 *
 * 풀이
 * - 각각 가로, 세로 길이가 들어있는 배열을 정렬 (가로 : 작은 수, 세로 : 큰 수)
 * - 가로(작은 수)에서 가장 큰 값, 세로(큰 수)에서 가장 큰 값을 곱한 값 리턴
 */
public class MinimumRectangle {
    public int solution(int[][] sizes) {
        int width = 0;
        int vertical = 0;
        for (int[] size : sizes){
            Arrays.sort(size);
            if(width < size[0]){
                width = size[0];
            }
            if(vertical < size[1]){
                vertical = size[1];
            }
        }
        return width * vertical;
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70},{60, 30},{80, 40}};
        MinimumRectangle minimumRectangle = new MinimumRectangle();
        System.out.println(minimumRectangle.solution(sizes));
    }
}

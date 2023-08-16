package Lv1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  프로그래머스 : 로또의 최고 순위와 최저 순위
 *
 *  문제 설명
 *  로또 6/45(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다.
 *  아래는 로또의 순위를 정하는 방식입니다.
 *  - 순위	    당첨 내용
 *  - 1	        6개 번호가 모두 일치
 *  - 2	        5개 번호가 일치
 *  - 3	        4개 번호가 일치
 *  - 4	        3개 번호가 일치
 *  - 5	        2개 번호가 일치
 *  - 6(낙첨)   그 외
 *
 *  로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다. 하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다.
 *  당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
 *  민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다.
 *  이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
 *
 *  풀이 과정
 *  - 구매한 로또와 당첨 번호의 같은 값을 담은 리스트의 사이즈, 구매한 로또의 0(구매한 로또의 알아볼 수 없는 값)의 개수를 구한다
 *      - 최고 순위는 리스트의 크기와 0의 개수를 더한 값으로 찾아낸다
 *  - 위에서 구한 리스트의 사이즈와, 최고 순위를 구할 값으로 최고 순위, 최저 순위를 구해 answer 배열의 0, 1번째 칸에 넣어 준다
 *      - 각각 값이 1보다 작거나 같다면 6, 아니라면 7 - 값을 해준다. (2개 번호가 일치할 때부터 5가 되므로 편의상 7로 넣어줌)
 *
 *  - 코드가 너무 중구난방인 느낌이 들어서 많이 아쉬운 것 같다
 */

public class HighestAndLowestRankingOfLotto {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        List<Integer> lottoList = Arrays.stream(lottos).boxed().collect(Collectors.toList());
        List<Integer> winNumList = Arrays.stream(win_nums).boxed().collect(Collectors.toList());
        int zeroSize = (int) lottoList.stream().filter(lotto -> lotto.equals(0)).count();

        lottoList.retainAll(winNumList);
        int winSize = lottoList.size();
        int highestRanking = winSize + zeroSize;

        answer[0] = highestRanking <= 1 ? 6 : 7 - highestRanking;
        answer[1] = winSize <= 1 ? 6 : 7 - winSize;

        return answer;
    }

    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        HighestAndLowestRankingOfLotto highestAndLowestRankingOfLotto = new HighestAndLowestRankingOfLotto();
        System.out.println(Arrays.toString(highestAndLowestRankingOfLotto.solution(lottos, win_nums)));
    }
}

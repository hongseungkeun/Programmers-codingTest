package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : [1차] 다트 게임
 *
 *  문제 설명
 *
 *  갓 입사한 무지는 코딩 실력을 인정받아 게임의 핵심 부분인 점수 계산 로직을 맡게 되었다.
 *  다트 게임의 점수 계산 로직은 아래와 같다.
 *  - 다트 게임은 총 3번의 기회로 구성된다.
 *  - 각 기회마다 얻을 수 있는 점수는 0점에서 10점까지이다.
 *  - 점수와 함께 Single(S), Double(D), Triple(T) 영역이 존재하고 각 영역 당첨 시 점수에서 1제곱, 2제곱, 3제곱 (점수1 , 점수2 , 점수3 )으로 계산된다.
 *  - 옵션으로 스타상(*) , 아차상(#)이 존재하며 스타상(*) 당첨 시 해당 점수와 바로 전에 얻은 점수를 각 2배로 만든다. 아차상(#) 당첨 시 해당 점수는 마이너스된다.
 *  - 스타상(*)은 첫 번째 기회에서도 나올 수 있다. 이 경우 첫 번째 스타상(*)의 점수만 2배가 된다. (예제 4번 참고)
 *  - 스타상(*)의 효과는 다른 스타상(*)의 효과와 중첩될 수 있다. 이 경우 중첩된 스타상(*) 점수는 4배가 된다. (예제 4번 참고)
 *  - 스타상(*)의 효과는 아차상(#)의 효과와 중첩될 수 있다. 이 경우 중첩된 아차상(#)의 점수는 -2배가 된다. (예제 5번 참고)
 *  - Single(S), Double(D), Triple(T)은 점수마다 하나씩 존재한다.
 *  - 스타상(*), 아차상(#)은 점수마다 둘 중 하나만 존재할 수 있으며, 존재하지 않을 수도 있다.
 *  0~10의 정수와 문자 S, D, T, *, #로 구성된 문자열이 입력될 시 총점수를 반환하는 함수를 작성하라.
 *
 *  [입력 형식]
 *  "점수|보너스|[옵션]"으로 이루어진 문자열 3세트. 예) 1S2D*3T
 *  - 점수는 0에서 10 사이의 정수이다.
 *  - 보너스는 S, D, T 중 하나이다.
 *  - 옵선은 *이나 # 중 하나이며, 없을 수도 있다.
 *
 *  [출력 형식]
 *  3번의 기회에서 얻은 점수 합계에 해당하는 정수값을 출력한다. 예) 37
 *
 *  풀이 과정
 *  - 다트 게임은 총 3번 진행되므로 3번을 담을 int[] dart 선언
 *  - 특수 문자, S, D, T일 경우에는 상황에 맞는 로직 진행
 *      - S, D, T
 *          - 각각 현재 숫자를 1, 2, 3만큼 제곱해준다
 *      - *
 *          - 현재, 이전 숫자를 2배로 만든다
 *      - #
 *          - 현재 숫자를 마이너스로 만든다
 *   - 특수 문자, S, D, T가 아닌 경우에는 숫자이므로 문자열을 연결해준다
 */

public class DartsGame {
    private final int[] dart = new int[3];
    private final StringBuilder currentNum = new StringBuilder();
    private int idx = 0;

    public int solution(String dartResult) {
        String[] darts = dartResult.split("");

        for (String d : darts) {
            if ("*".equals(d)) {
                dart[idx - 1] *= 2;
                if (idx - 2 >= 0) {
                    dart[idx - 2] *= 2;
                }
            } else if ("#".equals(d)) {
                dart[idx - 1] *= -1;
            } else if (Bonus.S.toString().equals(d)) {
                bonusProgression(Bonus.S);
            } else if (Bonus.D.toString().equals(d)) {
                bonusProgression(Bonus.D);
            } else if (Bonus.T.toString().equals(d)) {
                bonusProgression(Bonus.T);
            } else {
                currentNum.append(d);
            }
        }
        return Arrays.stream(dart).sum();
    }

    private void bonusProgression(Bonus bonus){
        dart[idx++] = (int) Math.pow(Integer.parseInt(currentNum.toString()), bonus.bonusScore);
        currentNum.setLength(0);
    }

    enum Bonus{
        S(1),
        D(2),
        T(3);

        private final int bonusScore;

        Bonus(int bonusScore){
            this.bonusScore = bonusScore;
        }
    }

    public static void main(String[] args) {
        String dartResult = "1S*2T*3S";
        DartsGame dartsGame = new DartsGame();
        System.out.println(dartsGame.solution(dartResult));
    }
}

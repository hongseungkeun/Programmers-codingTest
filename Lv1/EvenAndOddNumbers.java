package Lv1;

/**
 *  프로그래머스 : 짝수와 홀수
 *
 *  문제 설명
 *
 *  정수 num이 짝수일 경우 "Even"을 반환하고 홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
 *
 *  제한 조건
 *  - num은 int 범위의 정수입니다.
 *  - 0은 짝수입니다.
 *
 *  풀이 과정
 *  - 숫자를 2로 나눴을 때의 나머지가 0이라면 Even, 아니라면 Odd를 반환한다
 */

public class EvenAndOddNumbers {
    public String solution(int num) {
        return num % 2 == 0 ? Num.EVEN.value : Num.ODD.value;
    }

    enum Num {
        ODD("Odd"),
        EVEN("Even");

        public String value;

        Num(String value){
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int num = 3;
        EvenAndOddNumbers evenAndOddNumbers = new EvenAndOddNumbers();
        System.out.println(evenAndOddNumbers.solution(num));
    }
}

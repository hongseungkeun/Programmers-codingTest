package Lv1;

import java.util.ArrayList;
import java.util.List;

/**
 *  프로그래머스 : 기사단원의 무기
 *
 *  문제 설명
 *
 *  각 기사는 자신의 기사 번호의 약수 개수에 해당하는 공격력을 가진 무기를 구매하려 합니다. 단, 이웃나라와의 협약에 의해
 *  공격력의 제한수치를 정하고, 제한수치보다 큰 공격력을 가진 무기를 구매해야 하는 기사는 협약기관에서 정한 공격력을 가지는 무기를 구매해야 합니다.
 *  예를 들어, 15번으로 지정된 기사단원은 15의 약수가 1, 3, 5, 15로 4개 이므로, 공격력이 4인 무기를 구매합니다. 만약, 이웃나라와의 협약으로 정해진
 *  공격력의 제한수치가 3이고 제한수치를 초과한 기사가 사용할 무기의 공격력이 2라면, 15번으로 지정된 기사단원은 무기점에서 공격력이 2인 무기를 구매합니다.
 *  무기를 만들 때, 무기의 공격력 1당 1kg의 철이 필요합니다. 그래서 무기점에서 무기를 모두 만들기 위해 필요한 철의 무게를 미리 계산하려 합니다.
 *  기사단원의 수를 나타내는 정수 number와 이웃나라와 협약으로 정해진 공격력의 제한수치를 나타내는 정수 limit와 제한수치를 초과한 기사가 사용할 무기의
 *  공격력을 나타내는 정수 power가 주어졌을 때, 무기점의 주인이 무기를 모두 만들기 위해 필요한 철의 무게를 return 하는 solution 함수를 완성하시오.
 *
 *  풀이 과정
 *  - 반복을 통해 1부터 number까지의 약수들의 개수를 순서대로 구하고 limit을 넘지 않으면 그 갯수만큼, 넘는다면 power만큼 answer에 더해준다
 */

public class KnightWeapon {
    public int solution(int number, int limit, int power) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            int sqrt = (int) Math.sqrt(i);
            List<Integer> arr = new ArrayList<>();

            for (int j = 1; j <= sqrt; j++) {
                if(i % j == 0){
                    arr.add(j);
                    if(i / j != j){
                        arr.add(i / j);
                    }
                }
            }

            if(arr.size() <= limit) {
                answer += arr.size();
            }else {
                answer += power;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int number = 5;
        int limit = 3;
        int power = 2;
        KnightWeapon knightWeapon = new KnightWeapon();
        System.out.println(knightWeapon.solution(number,limit,power));
    }
}

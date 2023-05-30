package Lv2;

import java.util.*;

/**
 *  프로그래머스 : 롤케이크 자르기
 *
 *  문제 설명
 *
 *   철수와 동생은 롤케이크를 공평하게 나눠먹으려 하는데, 그들은 롤케이크의 크기보다 롤케이크 위에 올려진 토핑들의
 *   종류에 더 관심이 많습니다. 그래서 잘린 조각들의 크기와 올려진 토핑의 개수에 상관없이 각 조각에 동일한 가짓수의
 *   토핑이 올라가면 공평하게 롤케이크가 나누어진 것으로 생각합니다.
 *   롤케이크에 올려진 토핑들의 번호를 저장한 정수 배열 topping이 매개변수로 주어질 때, 롤케이크를 공평하게 자르는
 *   방법의 수를 return 하도록 solution 함수를 완성해주세요.
 *
 *   풀이 과정
 *   - map에 topping 종류와 개수를 담는다
 *   - 반복을 통해 set에 하나씩 넣어 중복을 제거한다
 *   - map에 방금 넣은 토핑의 값이 0이면 없애준다
 *   - 이렇게 하나씩 진행하며 map과 set의 사이즈를 비교해 같다면 answer++
 */

public class CuttingRollCake {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> toppings = new HashMap<>();
        Set<Integer> brother = new HashSet<>();

        for (int i = 0; i < topping.length; i++) {
            toppings.put(topping[i], toppings.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            brother.add(topping[i]);
            toppings.put(topping[i], toppings.get(topping[i]) - 1);

            if(toppings.get(topping[i]) == 0){
                toppings.remove(topping[i]);
            }

            if(brother.size() == toppings.size()){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        CuttingRollCake cuttingRollCake = new CuttingRollCake();
        System.out.println(cuttingRollCake.solution(topping));
    }
}

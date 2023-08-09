package Lv1;

/**
 *  프로그래머스 : 부족한 금액 계산하기
 *
 *  문제 설명
 *  새로 생긴 놀이기구는 인기가 매우 많아 줄이 끊이질 않습니다. 이 놀이기구의 원래 이용료는 price원 인데,
 *  놀이기구를 N번째 이용한다면 원래 이용료의 N배를 받기로 하였습니다. 즉, 처음 이용료가 100이었다면
 *  2번째에는 200, 3번째에는 300으로 요금이 인상됩니다.
 *  놀이기구를 count번 타게 되면 현재 자신이 가지고 있는 금액에서 얼마가 모자라는지를 return 하도록
 *  solution 함수를 완성하세요. 단, 금액이 부족하지 않으면 0을 return 하세요.
 *
 *  제한사항
 *  - 놀이기구의 이용료 price : 1 ≤ price ≤ 2,500, price는 자연수
 *  - 처음 가지고 있던 금액 money : 1 ≤ money ≤ 1,000,000,000, money는 자연수
 *  - 놀이기구의 이용 횟수 count : 1 ≤ count ≤ 2,500, count는 자연수
 *
 *  풀이 과정
 *  - price의 모든 값을 반복문을 통해 구한 후 money보다 작다면 금액이 부족하지 않으므로 0 return
 *  - money보다 크다면 money에서 price를 뺀 후 Math.abs를 통해 절댓값으로 환산한 후 return
 *
 *  - 처음에 money -= price * i로 연산했으나 int값을 넘어가서인지 테스트 통과를 하지 못함
 *  - long prices 변수를 통해 연산한 값들을 long 변수에 넣은 후 money와 비교하는 것으로 변경
 */

public class CalculatingTheShortfall {
    public long solution(int price, int money, int count) {
        long answer;
        long prices = 0;

        for (int i = 1; i <= count; i++) {
            prices += (long) price * i;
        }

        if(prices <= money){
            return 0;
        }else{
            answer = Math.abs(money-prices);
        }

        return answer;
    }

    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        CalculatingTheShortfall calculatingTheShortfall = new CalculatingTheShortfall();
        System.out.println(calculatingTheShortfall.solution(price,money,count));
    }
}

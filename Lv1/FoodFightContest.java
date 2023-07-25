package Lv1;

/**
 *  프로그래머스 : 푸드 파이트 대회
 *
 *  문제 설명
 *
 *  수웅이는 매달 주어진 음식을 빨리 먹는 푸드 파이트 대회를 개최합니다.
 *  이 대회에서 선수들은 1대 1로 대결하며, 매 대결마다 음식의 종류와 양이 바뀝니다.
 *  대결은 준비된 음식들을 일렬로 배치한 뒤, 한 선수는 제일 왼쪽에 있는 음식부터 오른쪽으로,
 *  다른 선수는 제일 오른쪽에 있는 음식부터 왼쪽으로 순서대로 먹는 방식으로 진행됩니다.
 *  중앙에는 물을 배치하고, 물을 먼저 먹는 선수가 승리하게 됩니다.
 *
 *  이때, 대회의 공정성을 위해 두 선수가 먹는 음식의 종류와 양이 같아야 하며, 음식을 먹는 순서도 같아야 합니다.
 *  또한, 이번 대회부터는 칼로리가 낮은 음식을 먼저 먹을 수 있게 배치하여 선수들이 음식을 더 잘 먹을 수 있게 하려고 합니다.
 *
 *  수웅이가 준비한 음식의 양을 칼로리가 적은 순서대로 나타내는 정수 배열 food가 주어졌을 때,
 *  대회를 위한 음식의 배치를 나타내는 문자열을 return 하는 solution 함수를 완성해주세요.
 *
 *  제한사항
 *  - 2 ≤ food의 길이 ≤ 9
 *  - 1 ≤ food의 각 원소 ≤ 1,000
 *  - food에는 칼로리가 적은 순서대로 음식의 양이 담겨 있습니다.
 *  - food[i]는 i번 음식의 수입니다.
 *  - food[0]은 수웅이가 준비한 물의 양이며, 항상 1입니다.
 *  - 정답의 길이가 3 이상인 경우만 입력으로 주어집니다.
 *
 *  풀이 과정
 *  - 앞 부분을 구한 뒤 앞 부분, "0", 앞 부분을 뒤집은 값 세 개를 더한다
 *  - 앞 부분 구하기
 *      - 만약 food[i]가 홀수라면 -1을 통해 짝수로 만들어준다
 *      - food[i] / 2 만큼 음식 이름을 StringBuilder로 이어 붙힌다
 *
 *  - return에서 sb에 toString()을 사용하지 않으면 sb가 전부 뒤집어진 값으로 리턴이 됨
 */

public class FoodFightContest {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            if(food[i] % 2 == 1){
                food[i] -= 1;
            }

            sb.append(String.valueOf(i).repeat(food[i] / 2));
        }

        return sb.toString() + "0" + sb.reverse().toString();
    }

    public static void main(String[] args) {
        int[] food = {1, 3, 4, 6};
        FoodFightContest foodFightContest = new FoodFightContest();
        System.out.println(foodFightContest.solution(food));
    }
}

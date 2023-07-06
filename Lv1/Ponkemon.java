package Lv1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *  프로그래머스 : 폰켓몬
 *
 *  문제 설명
 *
 *  당신은 폰켓몬을 잡기 위한 오랜 여행 끝에, 홍 박사님의 연구실에 도착했습니다.
 *  홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
 *  당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.
 *  N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때, N/2마리의 폰켓몬을 선택하는 방법 중,
 *  가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아, 그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 *  제한사항
 *  - nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
 *  - nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
 *  - 폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
 *  - 가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다
 *
 *  풀이 과정
 *  - 종류의 개수, 골라야 하는 폰켓몬의 개수를 각각 구한다
 *  - 다른 조건을 이용할 필요 없이 두 개중 가장 낮은 수를 리턴한다
 *      - 이 문제는 가장 많은 종류의 개수를 리턴하는 문제이다
 *      - 종류가 골라야 하는 개수보다 적다면 모든 종류를 고를 수 있기 때문에 종류의 개수가 된다
 *      - 종류가 골라야 하는 개수보다 많다면 제한 사항의 4번째와 같이 종류에서 골라야 하는 개수만큼 고를 수 있기 때문에 골라야 하는 개수가 된다
 *
 *  - 문제를 푼 후 다른 사람의 풀이를 봤는데 내 풀이를 한 줄로 축약한 코드가 있어서 가져오게 되었다
 *  - Arrays.stream(nums).boxed()
 *                 .collect(Collectors.collectingAndThen(Collectors.toSet(),
 *                         phonekemons -> Integer.min(phonekemons.size(), nums.length / 2)))
 */

public class Ponkemon {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().toList());
        int kind = set.size();
        int PickNum = nums.length / 2;

        return Math.min(kind, PickNum);
    }

    public static void main(String[] args) {
        int[] nums = {3,1,2,3};
        Ponkemon ponkemon = new Ponkemon();
        System.out.println(ponkemon.solution(nums));
    }
}

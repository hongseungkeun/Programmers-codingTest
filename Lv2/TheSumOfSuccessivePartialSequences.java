package Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  프로그래머스 : 연속된 부분 수열의 합
 *
 *  문제 설명
 *
 *  비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.
 *  - 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
 *  - 부분 수열의 합은 k입니다.
 *  - 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
 *  - 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
 *  수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때, 위 조건을
 *  만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요.
 *  이때 수열의 인덱스는 0부터 시작합니다.
 *
 *  풀이 과정
 *
 *  - 인덱스와 인덱스 사이의 값을 구하기 위해 사이를 이동할 left, right
 *  - 인덱스와 인덱스 사이의 값인 sum
 *  - 길이가 짧은 수열과 앞쪽에 나오는 수열을 찾기 위해 사용할 객체 Sequences
 *  - while문을 사용해 반복하여 사이의 숫자를 구합니다
 *      - 만약 left나 right가 하나라도 sequence의 길이보다 커지게 되면 반복 탈출
 *      - 먼저 현재 사이값인 sum과 k를 비교해 같다면 answer에 넣어준다
 *      - sum이 k보다 작거나 같고 right이 sequence의 길이보다 작다면
 *          - right++를 해주고 sum에 sequence[right]를 더해준다
 *          - sequence가 오름차순으로 정렬되어 있기 때문에 sum이 k보다 작다는 건 값이 커져야 한다는 것
 *          - right가 sequence 길이보다 같거나 크다면 길이를 넘어가기 때문에 sum에 값을 더해줄 수 없음
 *      - 위의 경우가 아니라면 left++를 해주고 sum에서 sequence[left]를 빼준다
 *
 *
 *  - 처음에 do ~ while문으로 작성했으나 while문으로 해도 똑같아서 변경
 *  - Sequneces에 Comparable 인터페이스를 추가하면 compareTo 메소드를 오버라이드하여 사용할 수 있다
 */

public class TheSumOfSuccessivePartialSequences {
    public int[] solution(int[] sequence, int k) {
        List<Sequences> answer = new ArrayList<>();
        int left = 0;
        int right = 0;
        int sum = sequence[0];

        int lastSequenceLength = sequence.length - 1;

        while(left <= lastSequenceLength && right <= lastSequenceLength){
            if(sum == k){
                answer.add(new Sequences(left,right));
            }

            if(sum <= k && right < lastSequenceLength){
                right++;
                sum += sequence[right];
            }else{
                sum -= sequence[left];
                left++;
            }
        }

        answer.sort(Sequences::compare);

        return new int[]{answer.get(0).left,answer.get(0).right};
    }

    private static class Sequences{
        private final int left;
        private final int right;
        private final int size;

        public Sequences(int left, int right){
            this.left = left;
            this.right = right;
            this.size = right - left;
        }

        public int compare(Sequences sequence){
            if(this.size == sequence.size){
                return this.left - sequence.left;
            }
            return this.size - sequence.size;
        }
    }

    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        TheSumOfSuccessivePartialSequences theSumOfSuccessivePartialSequences = new TheSumOfSuccessivePartialSequences();
        System.out.println(Arrays.toString(theSumOfSuccessivePartialSequences.solution(sequence,k)));
    }
}
package Lv1;

import java.util.Arrays;

/**
 *  프로그래머스 : 소수 만들기
 *
 *  문제 설명
 *
 *  주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다.
 *  숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때
 *  소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
 *
 *  제한사항
 *  - nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
 *  - nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
 */

public class CreatePrimeNumbers {
    private static final int[] primeArr = findPrimeNumber();
    private static final int[] arr = new int[3];
    private static int[] numArr;
    private static int N;
    private static int resultCount = 0;

    public int solution(int[] nums) {
        N = nums.length;
        numArr = nums;

        DFS(0, 0);
        return resultCount;
    }

    private static void DFS(int idx, int depth) {
        if(depth == 3) {
            if(primeArr[Arrays.stream(arr).sum()] != 0) {
                resultCount++;
            }
            return;
        }

        for(int i = idx; i < N; i++) {
            arr[depth] = numArr[i];
            DFS(i + 1, depth + 1);
        }
    }

    private static int[] findPrimeNumber(){
        int n = 2997;
        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        arr[1] = 0;

        for (int i = 2; i <= n; i++) {
            if(arr[i] == 0) {
                continue;
            }

            for (int j = i * 2; j <= n; j+=i) {
                arr[j] = 0;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        CreatePrimeNumbers createPrimeNumbers = new CreatePrimeNumbers();
        System.out.println(createPrimeNumbers.solution(nums));
    }
}

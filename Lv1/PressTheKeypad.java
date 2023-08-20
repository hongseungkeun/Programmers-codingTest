package Lv1;

/**
 *  프로그래머스 : [카카오 인턴] 키패드 누르기
 *
 *  문제 설명
 *
 *  스마트폰 전화 키패드에서 왼손과 오른손의 엄지손가락만을 이용해서 숫자만을 입력하려고 합니다.
 *  맨 처음 왼손 엄지손가락은 * 키패드에 오른손 엄지손가락은 # 키패드 위치에서 시작하며, 엄지손가락을 사용하는 규칙은 다음과 같습니다.
 *  - 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
 *  - 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
 *  - 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
 *  - 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
 *      - 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
 *
 *  순서대로 누를 번호가 담긴 배열 numbers, 왼손잡이인지 오른손잡이인 지를 나타내는 문자열 hand가 매개변수로 주어질 때,
 *  각 번호를 누른 엄지손가락이 왼손인 지 오른손인 지를 나타내는 연속된 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 *
 *  제한 사항
 *  - numbers 배열의 크기는 1 이상 1,000 이하입니다.
 *  - numbers 배열 원소의 값은 0 이상 9 이하인 정수입니다.
 *  - hand는 "left" 또는 "right" 입니다.
 *      - "left"는 왼손잡이, "right"는 오른손잡이를 의미합니다.
 *  - 왼손 엄지손가락을 사용한 경우는 L, 오른손 엄지손가락을 사용한 경우는 R을 순서대로 이어붙여 문자열 형태로 return 해주세요.
 *
 *  풀이 과정
 *  - 계산의 편의성을 위해 손가락들의 처음 위치인 *은 10, #은 12로 둔다
 *  - 1, 4, 7일 경우 L을 붙혀주고 왼쪽 손가락 위치를 변경해준다
 *  - 3, 6, 9일 경우 R을 붙혀주고 오른쪽 손가락 위치를 변경해준다
 *  - 그 외에는 거리 계산을 진행해준다
 *      - number가 0이라면 *, #과 마찬가지로 계산에 용이하도록 11로 변경해준다
 *      - 거리 계산
 *          - Math.abs((number - 1) / 3 - (방향 - 1) / 3)를 통해 행 간의 거리를 구한다
 *          - Math.abs((number - 1) % 3 - (방향 - 1) % 3)를 통해 열 간의 거리를 구한다
 *          - 위에서 구한 두 개의 거리를 더한 값이 number와 방향간의 거리가 된다
 *      - 비교
 *          - 왼쪽 거리 계산값이 오른쪽 거리 계산값보다 작다면 왼쪽이 더 가까우므로 L을 붙혀주고 왼쪽 손가락 위치를 변경해준다
 *          - 왼쪽 거리 계산값이 오른쪽 거리 계산값보다 크다면 왼쪽이 더 가까우므로 R을 붙혀주고 오른쪽 손가락 위치를 변경해준다
 *          - 두 값이 같다면 hand에 따라 결정해준다
 */

public class PressTheKeypad {
    private final StringBuilder answer = new StringBuilder();
    private int left = 10;
    private int right = 12;
    private static final int ZERO = 11;

    public String solution(int[] numbers, String hand) {
        for (int number : numbers) {
            switch (number) {
                case 1, 4, 7 -> {
                    answer.append(Direction.LEFT.direction);
                    left = number;
                }
                case 3, 6, 9 -> {
                    answer.append(Direction.RIGHT.direction);
                    right = number;
                }
                default -> calculation(number, hand);
            }
        }

        return answer.toString();
    }

    private void calculation(int number, String hand) {
        number = (number == 0) ? ZERO : number;

        int leftDistance = calculateDistance(number, left);
        int rightDistance = calculateDistance(number, right);

        if (leftDistance < rightDistance) {
            answer.append(Direction.LEFT.direction);
            left = number;
        } else if (rightDistance < leftDistance) {
            answer.append(Direction.RIGHT.direction);
            right = number;
        } else {
            if (hand.equals(Direction.LEFT.hand)) {
                answer.append(Direction.LEFT.direction);
                left = number;
            } else {
                answer.append(Direction.RIGHT.direction);
                right = number;
            }
        }
    }

    private int calculateDistance(int number, int distance) {
        return Math.abs((number - 1) / 3 - (distance - 1) / 3) + Math.abs((number - 1) % 3 - (distance - 1) % 3);
    }

    private enum Direction {
        LEFT("L", "left"),
        RIGHT("R", "right");

        public final String direction;
        public final String hand;

        Direction(String direction, String hand) {
            this.direction = direction;
            this.hand = hand;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";
        PressTheKeypad pressTheKeypad = new PressTheKeypad();
        System.out.println(pressTheKeypad.solution(numbers, hand));
    }
}

# Problem 7 기능 목록
- 추천 점수를 구하는 메서드 구현
- 친구 그래프 자료구조 구현
- 크루별 함께 아는 친구들의 수를 구하는 메서드 구현
- 사용자의 타임라인에 방문한 회수를 구하는 메서드 구현
- 크루별 추천점수 구하는 메서드 구현
- 크루별 추천점수로 추천리스트 구하는 메서드 구현 (추천점수 0제외)

## 제한사항 예외처리
- `user`의 길이가 1이상 30이하가 아닐경우 예외 발생
- `friends`의 길이가 1이상 10000이하가 아닐 경우 예외 발생
- `friends`의 원소 값이 2개가 아닐 경우 예외 발생
- `friends`의 원소 값이 인덱스 구분 없이 중복될 경우 예외 발생 (집합을 비교한다는 의미)
- `visitors`의 길이가 10000이하가 아닐경우 예외 발생
- 아이디 길이가 1이상 30이하가 아닐 경우 예외 발생
- 아이디가 알파벳 소문자로만 이루어지지 않은경우 예외 발생
# java-ladderBoard

사다리 타기 미션 저장소

사다리게임
플레이어들(플레이어) 당첨항목들(당첨항목) 사다리게임판(플레이어위치, 사다리높이, 사다리연결다리) 게임(사다리알고리즘)

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 목록

## 개요

해당 저장소는 사다리 게임을 구현한 저장소입니다. `n`명의 플레이어 이름과 `n`개의 실행 결과와 높이 `m`을 입력하면 사다리가 생성됩니다.

결과 확인을 위해서는 플레이어 이름을 입력해야 합니다. 모든 플레이어의 결과를 확인할 수 있습니다.

결과 출력 후 게임은 종료됩니다.

입력 예외에 대한 재시도는 5회까지만 가능합니다. 재시도할 수 없으면 게임이 종료됩니다.

## 세부사항

플레이어

- [x] [제한사항] 이름은 영문자만 가능하다.
- [x] [제한사항] 이름은 최대 5글자까지 가능하다.

플레이어 그룹

- [x] [제한사항] 플레이어는 2명 이상, 10명 이하만 가능하다.
- [x] [제한사항] 플레이어의 이름은 중복될 수 없다.

링크

- [x] 연결선은 있거나 없다.
- [x] 연결선은 랜덤으로 정해진다.

라운드

- [x] 같은 높이의 연결선들의 집합이다

사다리게임판

- [x] 라운드의 사이즈는 2 이상, 10 이하만 가능하다
- [x] 위치에 알맞은 방향으로 이동시킨다.
- [x] 사다리를 탄다.

당첨 항목

- [x] [제한사항] 당첨 항목의 개수는 플레이어 수와 같다.
- [x] [제한사항] 당첨 항목은 공백이 될 수 없다.
- [x] [제한사항] 당첨 항목은 최대 5글자까지 가능하다.
- [x] 위치에 알맞은 당첨 항목을 반환한다.

결과

- [] 사다리 결과를 생성한다.
- [] 결과를 확인할 수 없는 대상은 예외가 발생한다
- [] 대상의 단일 결과를 반환한다.
- [] 전체 결과를 출력한다

재시도

- [] 재시도 가능 여부를 확인한다.
- [] 재시도 횟수를 감소시킨다.

## 도메인 식별

- 사다리게임판
- 연결선
- 플레이어
- 플레이어들
- 당첨항목
- 당첨항목들
- 라운드(각 라운드 : 높이 1)

## 시나리오

1. 플레이어 이름을 입력 받는다
2. 당첨항목 입력 받는다
3. 최대 사다리 높이를 입력 받는다
4. 결과를 확인할 단일 플레이어를 입력 받는다
5. 해당 플레이어의 결과를 출력한다
6. 전체 결과를 출력한다

## 개요

해당 저장소는 사다리 게임을 구현한 저장소입니다. `n`명의 플레이어 이름과 `n`개의 실행 결과와 높이 `m`을 입력하면 사다리가 생성됩니다.

결과 확인을 위해서는 플레이어 이름을 입력해야 합니다. 모든 플레이어의 결과를 확인할 수 있습니다.

결과 출력 후 게임은 종료됩니다.

입력 예외에 대한 재시도는 5회까지만 가능합니다. 재시도할 수 없으면 게임이 종료됩니다.

## 세부사항

플레이어

- 플레이어는 여러 명 존재할 수 있다.
    - [x] [제한사항] 플레이어는 2명 이상, 10명 이하만 가능하다.
    - [x] [제한사항] 플레이어의 이름은 중복될 수 없다.
- 플레이어는 이름을 가진다.
    - [x] [제한사항] 이름은 영문자만 가능하다.
    - [x] [제한사항] 이름은 최대 5글자까지 가능하다.

사다리

<img width="500" src="./static/ladderBoard.png">

- 선들의 집합이다.
    - [x] [제한사항] 높이는 2 이상, 10 이하만 가능하다.
    - [x] 선은 방향들의 집합이다.
        - [x] 왼쪽, 오른쪽, 정지를 가진다.
        - [x] 방향은 랜덤으로 정해진다.
        - [x] 위치에 알맞은 방향으로 이동시킨다.
- [x] 사다리를 탄다.

당첨 항목

- 당첨 항목은 여러 개 존재할 수 있다.
    - [x] [제한사항] 당첨 항목의 개수는 플레이어 수와 같다.
    - [x] [제한사항] 당첨 항목은 공백이 될 수 없다.
    - [x] [제한사항] 당첨 항목은 최대 5글자까지 가능하다.
- [x] 위치에 알맞은 당첨 항목을 반환한다.

결과

- [x] 사다리 결과를 생성한다.
- [x] 결과를 확인할 수 있는 대상인지 확인한다.
- [x] 대상의 단일 결과를 반환한다.

재시도

- [x] 재시도 가능 여부를 확인한다.
- [x] 재시도 횟수를 감소시킨다.

입력

- [x] 참여할 플레이어들의 이름을 입력한다.
  ```text
  참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)
  pobi,honux,crong,jk
  ```
- [x] 실행 결과를 입력한다.
  ```text
  실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)
  꽝,5000,꽝,3000
  ```
- [x] 최대 사다리 높이를 입력한다.
  ```text
  최대 사다리 높이는 몇 개인가요?
  5
  ```
- [x] 결과 확인 대상을 입력한다.
    - 단일 대상
      ```text
      결과를 보고 싶은 사람은?
      pobi
      ```
    - 전체 대상
      ```text
      결과를 보고 싶은 사람은?
      pobi
      ```

출력

- [x] 사다리 결과를 출력한다.
  ```text
  사다리 결과
  
  pobi  honux crong   jk
  |-----|     |-----|
  |     |-----|     |
  |-----|     |     |
  |     |-----|     |
  |-----|     |-----|
  꽝    5000  꽝    3000
  ```
- [x] 실행 결과를 출력한다.
    - 단일 결과
      ```text
      실행 결과
      꽝
      ```
    - 전체 결과
      ```text
      실행 결과
      pobi : 꽝
      honux : 3000
      crong : 꽝
      jk : 5000
      ```

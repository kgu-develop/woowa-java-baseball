## Feature

- [X] 컴퓨터는 1..9 범위에서 서로 다른 임의의 수 3개 선택
- [ ] 유저는 1..9 범위에서 서로 다른 숫자 3개를 입력한다
    - [ ] 숫자가 아닌 값을 입력한 경우 `IllegalArgumentException` 발생
- [ ] 심판은 `컴퓨터 <-> 유저의 3가지 숫자`를 토대로 숫자 야구 게임 결과를 도출한다
    - 비교 후 `strikeCount & ballCount` 정보를 `Result`로 Wrapping한 후 결과를 발송한다
- [ ] 컴퓨터가 선택한 모든 숫자를 맞히면 게임은 클리어된다
    - [ ] 사용자는 재시작[1], 종료[2] 중 하나를 입력한다
        - [ ] 숫자가 아닌 값을 입력한 경우 `IllegalArgumentException` 발생

<br>
<hr>

## Model

### `Baseballs`

- 입력한 3개의 숫자들을 추상화시킨 `Baseballs`
    - Baseballs에 속한 `List<Integer>`은
        - [X] 각 원소가 `1..9` 범위 사이여야 한다
        - [X] 원소의 크기가 3이여야 한다
        - [X] 중복된 원소가 없어야 한다

<br>

### `Computer: 컴퓨터`

- 1..9 범위에서 서로 다른 임의의 수 3개 선택
    - Computer는 중복 숫자를 선택하지 않도록 구현
- User 선택을 통한 결과 산출의 기준

<br>

### `User: 사용자`

- 숫자 3개 입력
    - 숫자를 입력하지 않을 경우 (IllegalArgumentException)
- 게임 재시작/종료와 관련된 커맨드 입력
    - 숫자를 입력하지 않을 경우 (IllegalArgumentException)

<br>

### `Referee: 심판`

- 플레이어 점수 채점
    - 숫자 겹침 + 동일 위치 = 스트라이크
    - 숫자 겹침 + 다른 위치 = 볼
    - 숫자 안겹침 = 낫싱

<br>

### `Result: 채점 결과`

- 스트라이크 & 볼에 대한 count field 보유

<br>

### `GameStatus: 게임 상태`

- 진행중인 게임에 대한 상태
    - `GAME_RUN` -> 게임 실행
    - `GAME_TERMINATE` -> 게임 종료

<br>

### `GameProcessDecider: 재시작 or 종료 결정자`

- 게임 클리어 후 종료 or 재시작에 대한 커맨더

<br>
<hr>

## Utils

### `ExceptionConstants`

- 전역 예외 메시지 통합 컴포넌트

### `BaseballConstants`

- Baseball에 대한 상수 전용 컴포넌트
    - 숫자 범위
    - Baseball 개수

<br>
<hr>

## View

### `InputView`

- 사용자 Input을 받기 위한 컴포넌트

### `OutputView`

- 게임 진행과 관련된 출력 컴포넌트

<br>
<hr>

## Controller

### `GameController`

- 게임 진행과 관련된 컨트롤러

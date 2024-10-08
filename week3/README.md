# 컨벤션

## 디렉토리 구조 (도메인 중심 패키지 구조)

```
week3
│  
├─board
│  ├─controller
│  │      BoardController.java
│  │
│  ├─dto
│  │  ├─request
│  │  │      BoardCreateRequest.java
│  │  │      BoardUpdateRequest.java
│  │  │
│  │  └─response
│  │      │  BoardResponse.java
│  │      │
│  │      └─result
│  │              BoardListResult.java
│  │
│  ├─entity
│  │      Board.java
│  │
│  ├─mapper
│  │      BoardMapper.java
│  │
│  ├─repository
│  │      BoardRepository.java
│  │
│  └─service
│          BoardService.java
│
├─global
│  ├─config
│  │      OpenApiConfig.java
│  │
│  ├─dto
│  │  └─response
│  │      │  ErrorResponse.java
│  │      │  JwtTokenSet.java
│  │      │  SuccessResponse.java
│  │      │
│  │      └─result
│  │              ExceptionResult.java
│  │              ListResult.java
│  │              ResponseState.java
│  │              SingleResult.java
│  │
│  ├─exception
│  │      CustomException.java
│  │      ErrorCode.java
│  │      ExceptionAdvice.java
│  │
│  ├─jwt
│  │      JwtInterceptor.java
│  │      JwtUtil.java
│  │
│  └─service
│          AuthService.java
│          ResponseService.java
│
└─member
    ├─controller
    │      MemberController.java
    │
    ├─dto
    │  ├─request
    │  │      MemberCreateRequest.java
    │  │      MemberLoginRequest.java
    │  │
    │  └─response
    │      MemberResponse.java
    │
    ├─entity
    │      Member.java
    │
    ├─mapper
    │      MemberMapper.java
    │
    ├─repository
    │      MemberMemoryRepository.java
    │      MemberRepository.java
    │
    └─service
            MemberService.java
```

**도메인 중심 패키지 구조 사용**

: 관련된 코드들이 응집해 있어 파악하기 쉽게 만듬

## 코드 컨벤션 규칙

1. **네이밍 규칙**
   - 패키지 네이밍: 패키지 이름은 모두 소문자로 작성함 (ex. `board`, `member`, `global`).
   - 클래스 네이밍: 클래스 이름은 PascalCase를 사용함 (ex. `BoardController`, `MemberService`).
   - 메서드 네이밍: 메서드는 동작을 설명하는 동사로 시작하며, camelCase를 사용함 (ex. `createBoard`, `updateMember`).

2. **응답 규격화**
   - 모든 API 응답은 `SuccessResponse`, `ErrorResponse`, `SingleResult`, `ListResult` 등의 응답 객체로 래핑하여 일관된 구조로 제공함

3. **에러 처리**
   - `CustomException`과 `ErrorCode`를 사용하여 예외를 정의하고, `ExceptionAdvice`를 통해 글로벌 예외 처리를 담당함
  


# 프로그래머스 인증

![프로그래머스lv3인증](https://github.com/user-attachments/assets/1f96e983-cfe5-4dab-9be3-2e2109123992)


# 흥미로운 내용 스터디
https://www.notion.so/String-StringBuffer-StringBuilder-10c4b00a8b0480ab9f59d99d2353c18e?pvs=4
# #목차
   1) [프로젝트 소개](#1-프로젝트-소개)
   2) [프로젝트 목적](#2-프로젝트-목적)
   3) [프로젝트 인원](#3-프로젝트-인원)
   4) [개발 환경](#4-개발-환경be)
   5) [와이어프레임](#5-와이어프레임)
   6) [API 설계](#6-api-설계)
   7) [ERD](#7-erd)

<br>
<br>

# 1. 프로젝트 소개
당근 마켓 클론코딩

<br>
<br>

# 2. 프로젝트 목적

FE개발자(리액트)와 BE개발자(스프링)가 6주차까지 배운 내용을 기반으로 협력을 통해 개발하는 프로젝트


<br>
<br>

# 3. 프로젝트 인원 

- FE  
📍 김영호, 📍 지송이

- BE  
📍 김건 (좋아요 기능, 로그인 및 비로그인조회, 지역별 및 인기순 조회기능, 조회수기능, )  
📍 백현명 (게시물 CRUD, CORS설정, 이미지업로드)   
📍 심규홍 (ExceptionHandler, jwt이용 로그인, 회원가입)


<br>
<br>

# 4. 개발 환경(BE)  
> 언어 및 개발툴 
- [java](https://github.com/whitewise95/TIL/tree/main/Java)
- 스프링 부트 '2.7.0' 버전
- 인텔리제이

> 서버환경
-  [AWS EC2 (Ubuntu 22.04)](https://github.com/whitewise95/TIL/tree/main/AWS/EC2)
  
> DB  
- [RDS(MySQL)](https://github.com/whitewise95/TIL/tree/main/AWS/RDS) 

> 형상관리
- [소스트리](https://www.sourcetreeapp.com/).
- [github](https://github.com/whitewise95).


> 라이브러리(gradle)
- lombok
```
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
```
- mysql
```
    runtimeOnly 'mysql:mysql-connector-java'
```
- H2
```
    runtimeOnly 'com.h2database:h2'
    runtimeOnly 'mysql:mysql-connector-java'
```

- jwt
```
 implementation group: 'io.jsonwebtoken', name: 'jjwt', version: '0.9.1'
```

-Validation
```
implementation 'javax.validation:validation-api:2.0.1.Final'
```
  
<br>
<br>


# 5. 와이어프레임

![화면 캡처 2022-06-23 175050](https://user-images.githubusercontent.com/81284265/175258463-5e148692-467d-4e22-be18-8b1dc72a3155.png)

<br>
<br>

# 6. API 설계
![1](https://user-images.githubusercontent.com/81284265/175259232-4a764c5b-9c42-46bf-b918-18c313f40531.png)
![화면 캡처 2022-06-23 175258](https://user-images.githubusercontent.com/81284265/175259241-f86f8723-c40c-4fd9-a658-fc0b7b8ee2cc.png)
![화면 캡처 2022-06-23 175309](https://user-images.githubusercontent.com/81284265/175259245-4e036587-947b-4d46-bec0-42af34d32c15.png)
![화면 캡처 2022-06-23 175322](https://user-images.githubusercontent.com/81284265/175259250-2fe5c414-b344-4db5-9260-3f8490b3dbf5.png)
![화면 캡처 2022-06-23 175337](https://user-images.githubusercontent.com/81284265/175259256-23401826-6257-484e-8ef7-fa468553b33f.png)
![화면 캡처 2022-06-23 175345](https://user-images.githubusercontent.com/81284265/175259261-6937fa9d-c03f-480c-b3a3-7543dd9e63d8.png)


# 7. ERD
![화면 캡처 2022-06-23 175139](https://user-images.githubusercontent.com/81284265/175258663-9777bf47-4e03-4b50-8fa5-f69f563fbe08.png)


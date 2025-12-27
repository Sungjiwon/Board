package com.jws.boardapi.domain;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
// JpaRepository를 상속받은 인터페이스는 스프링 실행 시 자동으로 빈 등록 해준다. 내부적으로 컴포넌트 스캔 대상이 되도록 설계되어있다.
public interface BoardRepository extends JpaRepository<Board, Long> {

}

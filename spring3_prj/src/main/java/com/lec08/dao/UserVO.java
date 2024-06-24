package com.lec08.dao;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString

@Component		// Spring <bean>   JPA :: @Entity
@Data			// lombok
//@ToString
//@Getter
//@Setter
//@RequiredArgsConstructor
//@EqualsAndHashCode

public class UserVO {
	private int userSeq;
	private String userId;
	private String userPw;
	private String userName;
	private String userGubun;
	private String regdate;
}

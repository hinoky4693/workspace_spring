package com.lec09.orm.mybatis;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Data
public class UserVO {
	private int userSeq;
	private String userId;
	private String userPw;
	private String userName;
	private String userGubun;
	private String regdate;
}

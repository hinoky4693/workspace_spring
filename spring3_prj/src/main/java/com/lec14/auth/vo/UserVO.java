package com.lec14.auth.vo;

import org.springframework.stereotype.Component;
import lombok.Data;

@Component    //--------------Spring <bean>  JPA:@Entity
@Data         //--------------lombok
public class UserVO {
	private int userSeq;
	private String userId;
	private String userPw;
	private String userName;
	private String userGubun;
	private String regdate;


	private String email;
	private String picture;
	private String accessToken;


}

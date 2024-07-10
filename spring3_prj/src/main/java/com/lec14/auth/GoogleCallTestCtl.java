package com.lec14.auth;


import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

import com.lec14.auth.vo.GoogleInfResponseVO;
import com.lec14.auth.vo.GoogleRequestVO;
import com.lec14.auth.vo.GoogleResponseVO;


@PropertySource("classpath:lec14-oauth.properties")
@Controller
public class GoogleCallTestCtl {
	
	@Value("${google.loginform.url}")
	private String LOGIN_FORM_URL;
	@Value("${google.client.id}")
	private String CLIENT_ID;
	@Value("${google.client.pw}")
	private String CLIENT_PW;
	//@Value("${google.redirect.uri}")
	private String CALLBACK_URL = "http://localhost:8089/test_google_oauth2callback";
	@Value("${google.endpoint.token}")
	private String ENDPOINT_URL_TOKEN;
	@Value("${google.endpoint.userinfo}")
	private String ENDPOINT_URL_USERINFO;
	private String authCode="";
    
	//http://localhost:8089/test_google_loginForm
	
    @RequestMapping(value="/test_google_loginForm")
   	public String loginForm(Model model) {
    	//-------------------------------------------------------------------------
        //로그인폼 요청을 위한 주소  
    	// https://accounts.google.com/o/oauth2/v2/auth?client_id=${CLIENT_ID}&redirect_uri=${REDIRECT_URI}&response_type=code&scope=email%20profile%20openid&access_type=offline
    	String loginFormUrl = LOGIN_FORM_URL 
    			+ "?client_id=" + CLIENT_ID				//
    			+ "&redirect_uri="+CALLBACK_URL			//
    			+ "&response_type=code"					//
    			+ "&scope=email%20profile%20openid"  
    			+ "&access_type=offline";			 
    	
       	System.out.println("0.로그인폼URL:" + loginFormUrl);
       	return "redirect:" +loginFormUrl;
   	}
 
    
    /**
     * access_token 토큰 획득
     */
    @RequestMapping(value="/test_google_oauth2callback", method = RequestMethod.GET)
    public void loginGoogle(@RequestParam(value = "code") String code){
    	this.authCode = code;
    	System.out.println("1.authCode:" + code);
    	
    	//-------------------------------------------------------------------------
        //토큰 요청
    	// curl -v -X POST "https://oauth2.googleapis.com/token" 
    	// 			-d "code=${리턴된code}"
		// 			-d "client_id=${CLIENT_ID}"
    	// 			-d "client_secret=${CLIENT_SECRET}" 
    	// 			-d "grant_type=authorization_code" 
    	//			--data-urlencode "redirect_uri=${REDIRECT_URI}"
    	//-------------------------------------------------------------------------
    	
    	// 필수 바디 정보 
        GoogleRequestVO googleRequestVO = GoogleRequestVO
                .builder()
                .code(authCode)
                .clientId(CLIENT_ID)
                .clientSecret(CLIENT_PW)
                .grantType("authorization_code")
                .redirectUri(CALLBACK_URL).build();
        System.out.println("2.토큰요청 필수 바디(vo):" + googleRequestVO.toString());
        /**
         GoogleRequestVO(
         * clientId=132153140522-46cvv4nbdb8gi5sou3972g2vaa9hg.apps.googleusercontent.com, 
         * redirectUri=http://localhost:8089/test_google_oauth2callback, 
         * clientSecret=1SHdnEEJChFrfO8lRV6rB, 
           responseType=null, 
           scope=null, 
         * code=4/0ATx3LY5Zv-hVDO-XY68Y1-xZOPs7USoju8HBsEmWELGFZGPr9I-SdaeX1R4AJMvOThA, 
           accessType=null, 
         * grantType=authorization_code,  //고정값(인가code를 통한 로그인 방식)
           state=null, 
           includeGrantedScopes=null, 
           loginHint=null, 
           prompt=null)
         */
        
        RestTemplate restTemplate = new RestTemplate();
    	ResponseEntity<GoogleResponseVO> tokenResponse = restTemplate.postForEntity(ENDPOINT_URL_TOKEN, googleRequestVO, GoogleResponseVO.class);
        System.out.println("2.토큰 응답:" + tokenResponse.toString());
        /**
         <200 OK,tokenResponse(
         * access_token=ya29.a0AXooCgvDOaSSsTcWHQvPxodXuQ4LZnp3whkg_79CWrURjZ9VXNu9NxRa-D1jZl_Yt-VQVrggx17xmXArImhdZ3QVammOX0x9NcthRjMeskd7RG2jpFpwPrVg_T1iwP3VwSSjfi_-VHG7gdFFeBmskkXFvvUgpYzQaCgYKASUSARMSFQHGX2MiJK_y_-OGPHbN7clZS9IYfQ017, 
           expires_in=3599, 
           refresh_token=null, 
           scope=https://www.googleapis.com/auth/userinfo.profile openid https://www.googleapis.com/auth/userinfo.email, 
           token_type=Bearer,   //고정값
         * id_token=eyJhbGciOiJSUzI1NiIsImtpZCI6IjJhZjkwg3YmUxNDBjMjAwMzg4OThhNmVmYTExMjgzZGFiNjAzMWQiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiIxMzIxNTMxNDA1MjItNDZjdnY0bmJkYjhnaTVzb3VnNTM5NzJnMnZhYTloZ24uYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiIxMzIxNTMxNDA1MjItNDZjdnY0bmJkYjhnaTVzb3VnNTM5NzJnMnZhYTloZ24uYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTY3ODI5NTY4MzUwMTQ5MzY2MTYiLCJlbWFpbCI6ImNvbXMua29yZWFAZ21haWwuY29tIiwiZW1haWxfdmVyaWZpZWQiOnRydWUsImF0X2hhc2giOiJLZ3NLN05LQ1BUZVkwRWdFTFRvZE1RIiwibmFtZSI6IuydtOqyve2ZlCIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vYS9BQ2c4b2NMYlRiWTlGVWdCeURybUgxQ21RUlF5VV9iMURGRVdjdWJjNlNqUjR1WmZEV1hWYU4wPXM5Ni1jIiwiZ2l2ZW5fbmFtZSI6Iuqyve2ZlCIsImZhbWlseV9uYW1lIjoi7J20IiwiaWF0IjoxNzE5OTYyODc5LCJleHAiOjE3MTk5NjY0Nzl9.YhG5yHG2yfmA_I5kWNIaiPax-VpN0GqdyomwkGItAFJKJ40O2jVbFY7jPTBRQM3kfwtaqbeqo0vdKrdKrrfZv1m9sAMtav82P2jZgPnoweSexGJ_SVtFVwI_Mlz312V2AaRyh7qr9JhbSDl2-JzzZIwKmIYIL34Vh92iBYy8i7-EQYqukRYzEtD15StGNUSqUWE-FpQ86KLZQw8k7UwdbVLU4dK0kFWcvQrnCAhOdsHyCqB7E9mwevkrBKKEKIcBsQraHcFe6xbtXTBvBjWn8BuMZjwi-_ElrusVkfJINUc24JFctLKrpE0e2Uzt_FdvP6YfHudcZFWGj5wgGPM1U)
           ,{Date=[Tue, 02 Jul 2024 23:27:59 GMT], Expires=[Mon, 01 Jan 1990 00:00:00 GMT], Cache-Control=[no-cache, no-store, max-age=0, must-revalidate], Pragma=[no-cache], Content-Type=[application/json; charset=utf-8], Vary=[X-Origin, Referer, Origin,Accept-Encoding], Server=[scaffolding on HTTPServer2], X-XSS-Protection=[0], X-Frame-Options=[SAMEORIGIN], X-Content-Type-Options=[nosniff], Alt-Svc=[h3=":443"; ma=2592000,h3-29=":443"; ma=2592000], Accept-Ranges=[none], Transfer-Encoding=[chunked]}>
         */
        
        
        //-------------------------------------------------------------------------
        // 토큰 유효성 검증
    	// curl -v -X POST "https://oauth2.googleapis.com/tokeninfo" 
    	// 			-d "id_token=${리턴된id_token}"
    	//-------------------------------------------------------------------------
        String idToken     = tokenResponse.getBody().getId_token();
        String accessToken = tokenResponse.getBody().getAccess_token();
        
        //필수 바디 정보
        Map<String, String> map=new HashMap<>();
        map.put("id_token",idToken);
        
        ResponseEntity<GoogleInfResponseVO> tokenInfoResponse = restTemplate.postForEntity("https://oauth2.googleapis.com/tokeninfo", map, GoogleInfResponseVO.class);
        String email = tokenInfoResponse.getBody().getEmail();
        System.out.println("3.토큰유효성검증 응답(body):" + tokenInfoResponse.toString());
        System.out.println("3.토큰유효성검증 응답(email):" +email);
        /**
         <200 OK,tokenInfoResponse(
           iss=https://accounts.google.com, 
           azp=132153140522-46cvv4nbdb8gi5soug53972g2vaa9gn.apps.googleusercontent.com, 
           aud=132153140522-46cvv4nbdb8gi5soug53972g2vaa9gn.apps.googleusercontent.com, 
           sub=116782956835014936616, 
         * email=coms.korea@gmail.com, 
           email_verified=true, 
           at_hash=PeKpLSK-laItGayJ01lw, 
         * name=이경화, 
           picture=https://lh3.googleusercontent.com/a/ACg8ocLbTbY9FByDrmHmQRQyU_b1DFEWcubc6SjR4uZfDWXVaN0=s96-c, 
           given_name=경화, family_name=이, 
           locale=null, 
           iat=1719963501,
           exp=1719967101, 
           alg=RS256, 
           kid=2af90e87be140c20038898a6efa112dab6031d, typ=JWT),
           {Pragma=[no-cache], Expires=[Mon, 01 Jan 1990 00:00:00 GMT], Date=[Tue, 02 Jul 2024 23:38:21 GMT], Cache-Control=[no-cache, no-store, max-age=0, must-revalidate], Content-Type=[application/json; charset=UTF-8], Vary=[X-Origin, Referer, Origin,Accept-Encoding], Server=[ESF], X-XSS-Protection=[0], X-Frame-Options=[SAMEORIGIN], X-Content-Type-Options=[nosniff], Alt-Svc=[h3=":443"; ma=2592000,h3-29=":443"; ma=2592000], Accept-Ranges=[none], Transfer-Encoding=[chunked]}>
         */
        
        //-------------------------------------------------------------------------
        // 획득한 AccessToken으로 유저정보 가져오기
    	// 	curl -v -X POST "https://www.googleapis.com/userinfo/v2/me" 
		// 			-H "Authorization: Bearer ${리턴된access_token}" 
    	//-------------------------------------------------------------------------
        
        //필수 헤더 정보
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        restTemplate = new RestTemplate();
        ResponseEntity<Map> userinfoResponse = restTemplate.exchange(ENDPOINT_URL_USERINFO, HttpMethod.GET, entity, Map.class);
        System.out.println("4.유저정보 응답:" +userinfoResponse.toString());    
    }
    
    
    
   
}

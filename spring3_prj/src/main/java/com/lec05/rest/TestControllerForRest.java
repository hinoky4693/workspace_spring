//package com.lec05.rest;
//
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.google.gson.Gson;
//import com.lec05.rest.BoardDAO;
//import com.lec05.rest.BoardVO;
//
//@Controller
//public class TestControllerForRest {
//	@Autowired
//	private BoardDAO boardDAO;
//	
////	@RequestMapping(value = "/str_str", method=RequestMethod.POST,
////					consumes="application/json", // 서버가 받아들일 데이터
////					produces="application/json") // 서버가 내보낼 데이터
////	@ResponseBody								 // HTTP 바디에 응답을 실어서 보내라
////    public String cltSample(Model model,
////    						@ModelAttribute BoardVO bvo) { // form의 입력값들
////			
////		return "200 OK";
////	}
//	@RequestMapping(value="/ctl_str_str", method=RequestMethod.POST)
//	@ResponseBody
//	public String cltStrStr(@RequestParam String ename) {
//		System.out.println(ename);
//		return ename;
//	}
//	
//	@RequestMapping(value="/ctl_str_str2", method=RequestMethod.POST)
//	@ResponseBody
//	public String cltStrStr2(@RequestParam String ename) {
//		System.out.println(ename);
//		
//		return "1. 200 ok";
//	}
//	
//	@RequestMapping(value="/ctl_json_str", method=RequestMethod.POST, consumes="application/json")
//	@ResponseBody
//	public String cltJsonStr(@RequestBody BoardVO bvo) {
//		System.out.println(bvo.getTitle() + ", "+ bvo.getContents());
//		
//		return "2. 200 OK";
//	}
//	
//	@RequestMapping(value="/ctl_str_json", method=RequestMethod.POST)
//	@ResponseBody
//	public ResponseEntity<Map<String, String>> cltStrJson(@RequestParam String ename) {
//		System.out.println(ename);
//		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("status", "200");
//		map.put("message", "서버가 보낸 응답");
//		return new ResponseEntity<>(map, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value="/ctl_json_json", method=RequestMethod.POST, consumes="application/json", produces="application/json")
//	@ResponseBody
//	public ResponseEntity<Map<String, String>> cltJsonJson(@RequestBody BoardVO bvo) {
//		System.out.println(bvo.getTitle() + ", "+ bvo.getContents());
//		
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("status", "200");
//		map.put("message", "서버가 보낸 응답");
//		return new ResponseEntity<>(map, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value="/ctl_normal", method=RequestMethod.POST, produces="application/json")
//	@ResponseBody
//	public ResponseEntity<ArrayList<BoardVO>> cltNormal(@ModelAttribute BoardVO bvo) {
//		System.out.println(bvo.getTitle() + ", "+ bvo.getRegid());
//		ArrayList<BoardVO> list = boardDAO.boardSelect();
//		
//		return new ResponseEntity<ArrayList<BoardVO>>(list, HttpStatus.OK);
//	}
//}

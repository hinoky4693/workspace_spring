package com.lec05.rest;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.lec04.di.board.BoardDAO;
import com.lec04.di.board.BoardVO;

@RestController
//@Controller + @ResponseBody
public class TestRestControllerForRest {

	@RequestMapping(value="/restctl_str_str", method=RequestMethod.POST)
	public String cltRestStrStr(@RequestParam String ename) {
		System.out.println(ename);
		
		return "0.RestController 200 ok";
	}
}

package com.test.demo.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	@RequestMapping("/")
	public void test(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out;
			out = response.getWriter();
			out.println("<html>\n"
					+ "\n"
					+ "<head>\n"
					+ "    <meta charset=\"UTF-8\">\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
					+ "    <title>Home 테스트 페이지</title>\n"
					+ "</head>\n"
					+ "\n"
					+ "<body>\n"
					+ "    <a href=\"index.html\">\n"
					+ "        <h1>Home 테스트 페이지</h1>\n"
					+ "    </a>\n"
					+ "\n"
					+ "    <h2>목차</h2>\n"
					+ "    <ul>\n"
					+ "        <li>HTML의 탄생</li>\n"
					+ "        <li>HTML 특징</li>\n"
					+ "        <li>HTML 페이지 구조</li>\n"
					+ "        <li>HTML 홈페이지 만들기</li>\n"
					+ "    </ul>\n"
					+ "\n"
					+ "    <h3>HTML의 탄생</h3>\n"
					+ "    <p>HTML은 <strong>Hyper Text Markup Language</strong>라는 용어의 약자로서 물리학자 <strong>팀 버너스리</strong>가 1990년에 HTTP, URL,\n"
					+ "        브라우저와 함께 개발했습니다. 팀 버너스리는 인터넷의 기반을 닦은 여러 공로로 웹의 아버지라고 불리는 인물 중 하나입니다.</p>\n"
					+ "\n"
					+ "</body>\n"
					+ "\n"
					+ "</html>");
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

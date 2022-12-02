package servlet.exam07;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "exam07.RemoveSessionController", urlPatterns = "/exam07/RemoveSessionController")
public class RemoveSessionController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//세션에 저장된 데이터(객체)를 제거
		//로그아웃할 때 쓸 수 있음
		session.removeAttribute("loginId");
		session.removeAttribute("loginDate");
		session.removeAttribute("Cart");
		
		//HttpSession 객체 자체를 제거 (세션 그 자체를 제거)
		//session에 담겼던 객체를 다 없어짐. 세션 객체는 다시 서블릿 객체를 만들어진다.
	/*	session.invalidate();*/
		
		response.sendRedirect("ContentController");
		
	}

}

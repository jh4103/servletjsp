package servlet.exam06;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exam06.UseCookieController", urlPatterns = "/exam06/UseCookieController")
public class UseCookieController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie: cookies) {
			
			//쿠키 이름 읽기
			String name = cookie.getName();

			if(name.equals("useremail")) {
				
				//쿠키값 읽기
				String value = cookie.getValue();
				System.out.println("useremail: " +value);
				//JSP에서 읽을 수 있도록 설정
				request.setAttribute("useremail", value);
			} else if(name.equals("userId")) {
				String value = cookie.getValue();
				request.setAttribute("userId", value);
			
			}
			
		}
		
		request.getRequestDispatcher("/WEB-INF/views/exam06/useCookie.jsp").forward(request, response);
	}


}

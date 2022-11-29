package servlet.exam04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exam04.HtmlResponseController", urlPatterns = "/exam04/HtmlResponseController")
public class HtmlResponseController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html; charset=UTF-8");
//		PrintWriter pw = response.getWriter();
//		pw.println("<!DOCTYPE html>");
//		pw.print("<html>");
//		pw.print("<body>");
//		pw.print("<h4>한글</h4>");
//		pw.print("<hr/>");
//		pw.print("</body>");
//		pw.print("</html>");
//		pw.flush();
//		pw.close();
		request.getRequestDispatcher("/WEB-INF/views/exam04/html.jsp");
	}

	
}

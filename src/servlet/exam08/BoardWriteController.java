package servlet.exam08;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;

@WebServlet(name = "exam08.BoardWriteController", urlPatterns = "/exam08/BoardWriteController")
public class BoardWriteController extends HttpServlet {

	
	//get방식이면 양식을 보여주고 post방식이면 완료 폼 보여주는것
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam08/writeForm.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트가 보낸 데이터 얻기 
		//이런식 말고 dto로 얻어야 함
		Board board = new Board();
		board.setBtitle(request.getParameter("btitle"));
		board.setBcontent(request.getParameter("bcontent"));
		
		//서비스로 회원 가입 요청 
		//서비스 얻는 방법
		ServletContext application = request.getServletContext();
		BoardService boardService =(BoardService) application.getAttribute("boardService");
		boardService.write(board);
		
		response.sendRedirect("ContentController");
	}
}

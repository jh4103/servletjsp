package context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import dao.BoardDao;
import dao.UserDao;
import service.BoardService;
import service.UserService;

public class WebAppContext implements ServletContextListener {
 //interface 인 ServletContextListner를 재정의 해준다. 
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ServletContext가 생성 완료됨");
		//생성된 servletContext객체를 내가 얻겠다!
		ServletContext application = sce.getServletContext();
	
		//ServletContext 객체에 데이터(객체) 저장
		//서비스랑 dao 저장하기로 함
		//이렇게 애플리케이션에 저장해서 넣으면 모든 클라이언트들이 공유할 수 있는 공유객체가됨
		application.setAttribute("userService", new UserService(application));
		application.setAttribute("boardService", new BoardService(application));
	
		application.setAttribute("userDao", new UserDao());
		application.setAttribute("boardDao", new BoardDao());
	}
}

package service;

import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.BoardDao;
import dto.Board;
import util.Pager;

public class BoardService {
	private ServletContext application;
	private DataSource ds; //이게 connection pool임
	private BoardDao boardDao;
	
	public BoardService(ServletContext application) {
		this.application = application;
		boardDao = (BoardDao) application.getAttribute("boardDao");
		ds = (DataSource) application.getAttribute("dataSource");
/*		try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/java");
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		
	}
	
	public void write(Board board) {
		boardDao.insert(board, null);
	}
	
	public void write2(Board board) {
		
		Connection conn = null;
		try {
			conn = ds.getConnection();
			boardDao.insert2(board, conn);
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (Exception e) {}
		}
	}

	public int getTotalRows() {
		int result = 0;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = boardDao.countRows(conn);
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (Exception e) {}
		}
		return result;
	}

	public List<Board> getPageList(Pager pager) {
		
		List<Board> result = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = boardDao.selectPageList(pager, conn);
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (Exception e) {}
		}
		return result;
		
	}

	public Board getBoard(int bno) {
		
		Board result = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = boardDao.selectBoard(bno, conn);
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (Exception e) {}
		}
		return result;
	}
	
}

package context;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConnectionProvider {
	private static Connection conn;
	// 방법1
	/*
	 * public static Connection getConnection() { if(conn == null) { try{
	 * Class.forName("oracle.jdbc.OracleDriver"); conn =
	 * DriverManager.getConnection(
	 * "jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle");
	 * }catch(Exception e) { e.printStackTrace(); } } return conn; }
	 */

	// 방법2
	/*
	 * public static synchronized Connection getConnection() { if(conn == null) {
	 * try { Class.forName("oracle.jdbc.OracleDriver"); conn =
	 * DriverManager.getConnection(
	 * "jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle"); }
	 * catch(Exception e) { e.printStackTrace(); } } return conn; }
	 */

	// 방법3
/*	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun", "oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return conn;
	}*/

	// Connection conn = ConnectionProvider.getConnction();
/*
	// 방법4
	public static Connection getConnection() {
		Connection conn = null;
		if (conn == null) {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection("jdbc:oracle:thin:@kosa402.iptime.org:50031:orcl", "younghun",
						"oracle");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
*/
	// 방법5
	//싱글톤 패턴 활용 -> 커넥션을 만들기 dataSource = dataPool
	private static BasicDataSource dataSource;
	static {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/orcl");
		dataSource.setUsername("java");
		dataSource.setPassword("oracle");
		dataSource.setMaxTotal(2);
		dataSource.setInitialSize(1);
		dataSource.setMaxIdle(1);
	}
	
	public static DataSource getDataSource() {
		return dataSource;
		
	}

	/*public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void main(String[] args) {
		Connection conn = null;
		try {
			// Connection 대여
			conn = ConnectionProvider.getConnection();
			System.out.println("대여 성공");
		} catch (Exception e) {

		} finally {
			try {
				// Connection 반납
				conn.close();
				System.out.println("반납 성공");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}*/

}

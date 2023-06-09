package VoteDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoteDAO {
	Connection conn = null; // 변수선언 DB와 연결 
	PreparedStatement ps = null; // sql문 담당 
	ResultSet rs = null; // select문에서 검색 결과를 담을 
	
	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver"); // oracle 드라이버 JVM에 로딩
		Connection con = 
		DriverManager.getConnection("jdbc:oracle:thin@//localhost:1521/xe","system","1234");
		// 2단계 연결하기
		return con;
	}

	public int insertVote(HttpServletRequest request, HttpServletResponse response)  {
		// 투표하기 삽입 DAO
		int result = 0;
		try {
			conn = getConnection();
			// 2단계 브라우저에 입력한 자료를 자바로 가지고 옴 
			String v_jumin = request.getParameter("v_jumin");
			String v_name = request.getParameter("v_name");
			String m_no = request.getParameter("m_no");
			String v_time = request.getParameter("v_time");
			String v_area = request.getParameter("v_area");
			String v_confirm = request.getParameter("v_confirm");
			// 3단계 sql문의 삽입문을 작성 
			String sql = "insert into tbl_vote_202005 values (?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, v_jumin);
			ps.setString(2, v_name);
			ps.setString(3, m_no);
			ps.setString(4, v_time);
			ps.setString(5, v_area);
			ps.setString(6, v_confirm);
			
			// 4단계 실행시킴
			result = ps.executeUpdate(); // 실패 0,성공 1
			System.out.println("성공 실패 여부 " + result);
			// 5단계 자원 반납
		try {	conn.close();
			ps.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 1단계 DB 연결 
	}
	return result;
}

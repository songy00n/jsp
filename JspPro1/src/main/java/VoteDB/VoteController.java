package VoteDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VoteController
 * 컨트롤러 작성하는 부분
 * View와 Model 연결하기 
 * 요청을 받아서 Model 분기시키기
 * 
 */
@WebServlet("/VoteController")
public class VoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		requestPro( request,  response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		requestPro( request,  response );
	}
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청한 것을 받아서 Model 분기하기 
		// View 보내기 
		String uri = request.getRequestURI(); //요청한 브라우저의 URI값을 얻는다.
		String context = request.getContextPath();// 요청한 context경로를 얻는다.
		String command = uri.substring(context.length());
		String site = null;
		
		System.out.println(  "uri : " + uri );
		System.out.println(  "context : " + context );
		System.out.println(  "command : " + command );
        
		VoteDAO vote = new VoteDAO();
		
		switch( command ) {
		    case "/main.do":   site="index.jsp"; break;
		    case "/memberList.do":   
		    	    site = vote.selectMember(request, response);//검색할 DAO에 있는 메소드를 호출한다.
		    	    break; //후보조회
		    case "/voteMember.do":   site="voteMember.jsp"; break;
		    case "/voteList.do":   site="voteList.jsp"; break;
		    case "/vote.do" : 
		    	     int result  = vote.insertVote( request, response );//삽입할 메소드로 호출합니다. 
		    	     response.setContentType("text/html; charset=UTF-8");
		    	     PrintWriter out = response.getWriter();
		    	     if(result == 1) {
		    	 		out.println("<script>");
		    	 		out.println("alert('투표하기 정보가 정상적으로 등록 되었습니다!'); location.href='"+context+"'; ");
		    	 		out.println("</script>");
		    	 		out.flush();
		    	 	}else {
		    	 		out.println("<script>");
		    	 		out.println("alert('등록실패!'); location.href='"+context+"'; ");
		    	 		out.println("</script>");
		    	 		out.flush();
		    	 	}	
		    	     break;
		    default:  break;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(site);
		dispatcher.forward(request, response);
	}
}

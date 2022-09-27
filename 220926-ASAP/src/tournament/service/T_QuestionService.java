package tournament.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import tournament.dao.T_QuestionDAO;
import tournament.model.Question;


public class T_QuestionService {
	public T_QuestionDAO tournamentQ = new T_QuestionDAO();
	
	//topic_id로 받은 question 객체를 list로 리턴하는 메소드 
	public List<Question> t_listQuestion(int what){
		try(Connection conn= ConnectionProvider.getConnection()){
			List<Question> question = new ArrayList<>(tournamentQ.readQuestion(conn,what));
			return question;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//question_id로 받은 question 객체를 리턴하는 메소드 
	public Question q_listQuestion(int what){
		try(Connection conn= ConnectionProvider.getConnection()){
			return tournamentQ.selectById(conn,what);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	//reply_t에 1-8위까지 전부 집어넣는거
	//member_id,question_id,m_reply_cnt 가 들어가야 한다. 
	public void insert(String member_id, int question_id, int m_reply_cnt ){
		try(Connection conn= ConnectionProvider.getConnection()){
			tournamentQ.insert(conn, member_id,  question_id, m_reply_cnt);
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
}

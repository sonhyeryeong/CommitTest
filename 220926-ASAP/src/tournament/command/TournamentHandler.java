package tournament.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import tournament.model.Question;
import tournament.service.T_QuestionService;

public class TournamentHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/worldcup/startQuestion.jsp";
	private T_QuestionService plz = new T_QuestionService();

	//파라미터로 토픽아이디를 받아주어야 함. 
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			//처음올 때 - a링크로 타고 오기 때문에 일로 온다. 
			return processForm(req, res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			//제출이 일어나야 하기 때문에 그 후 폼이다. 
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	//get방식
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("get방식으로 왔습니다!!");
//		//여기서 같이 라디오 버튼의 이름을 넘겨준다
		List<String> name = new ArrayList<>();
//		//라디오 버튼 그룹 지정을 위한 리스트 이름 
		req.setAttribute("name", listname(name));
//		//질문 객체를 넘겨준다. 
		req.setAttribute("question", plz.t_listQuestion(1));
		return FORM_VIEW;
	}
	
	//post방식  
	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("post방식으로 넘어왔습니다.");
		
		//여기서 같이 라디오 버튼의 이름을 넘겨준다
		List<String> name = new ArrayList<>();
		//라디오 버튼 그룹 지정을 위한 리스트 이름 
		req.setAttribute("name", listname(name));
		
		
		
		
		//질문 객체를 넘겨준다. 
		req.setAttribute("question", plz.t_listQuestion(1));
		return "/WEB-INF/worldcup/first.jsp";
	}
	
	
	
	//라디오버튼 이름-두개씩 똑같은 이름 만드는 메소드 
	public List<String> listname(List list){
		List<String> name = new ArrayList<>();
		int k=0;
		//질문이 7개면-> 00 11 22 3 이 되는데 하나 남을 필요가 없다. 
		//짝수일 때 
		if(list.size()%2==0) {
			for(int i=0; i< list.size() ; i++) {
				name.add("name"+k);
				if((i+1)%2==0) {
					k++;
				}
			}
			return name;
		}else {//홀수일 때 
			for(int i=0; i< list.size()-1 ; i++) {
				name.add("name"+k);
				if((i+1)%2==0) {
					k++;
				}
			}
			return name;
		}
	}

}
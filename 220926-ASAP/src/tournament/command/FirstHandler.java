package tournament.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import tournament.model.Question;
import tournament.service.T_QuestionService;

public class FirstHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/worldcup/selectQuestion.jsp";
	private T_QuestionService plz = new T_QuestionService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}	
	}
	
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}
	
	
	
	
	//짝수일 때-> 
	//현재 클릭된 값만 받아서 선택 형태로 넘겨준다.- 홀수인지 짝수인지 확인해서 넘겨야 한다. 
	public String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("-------------여기부터 firsthHandler 영역입니다.---------------");
		//현재 클릭된 값만 넘겨 받아서 question_id를 int리스트에 넣는다. 
		List<Integer> first =new ArrayList<>(); 
		for(int i =0; i< req.getParameterMap().size();i++) {
//			System.out.println(req.getParameter("name"+i));
			int what =Integer.valueOf(req.getParameter("name"+i));
			first.add(what);
		}
		
		
		//선택 갯수가 홀수인지 짝수인지 판별해서 부전승을 보낸다. 
		if(first.size()%2==0) {//짝수일 때 -> 부전승 없음. 
			//질문 리스트
			List<Question> question = new ArrayList<>(); 
			for(int j =0; j<first.size(); j++) {
				question.add( plz.q_listQuestion(first.get(j)));//질문 아이디를 파라미터로 넣어서 Question_class 객체를 생성한다. 
			}
			boolean oddeven = true;//질문이짝수인지 아닌지. 질문이 짝수일 때 true
			
			//선택한 질문 리스트(퀘스천 클래스), 라디오 버튼 이름 할 거 전부 넘긴다. 
			req.setAttribute("question", question);
			req.setAttribute("name", listname(first));
			req.setAttribute("oddeven", oddeven);
			return "/WEB-INF/worldcup/first.jsp";
		}else {//홀수일 때 -> 부전승 있음. 
			
			//한 문제가 남음. 부전승으로 보내야 된다. 
			//마지막 한 문제를 빼고 퀘스천리스트에 넣음
			List<Question> question = new ArrayList<>();
			for(int j =0; j<first.size()-1; j++) {
				question.add( plz.q_listQuestion(first.get(j)));
			}
			//마지막 한 문제를 퀘스천 객체로 만듬. 
			Question walkOver = plz.q_listQuestion(first.get(first.size()-1));
			boolean oddeven = false;//질문이짝수인지 아닌지. 질문이 홀수일 때 true
			
			
			//선택한 질문 리스트(퀘스천 클래스), 라디오 버튼 이름 할 거 전부 넘긴다. 
			req.setAttribute("question", question);//질문 보내기.
			req.setAttribute("name", listname(first));//라디오버튼 이름 보내기
			req.setAttribute("walkOver", walkOver);
			req.setAttribute("oddeven", oddeven);
			return "/WEB-INF/worldcup/first.jsp";
		}
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

package tournament.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import tournament.model.Question;
import tournament.service.T_QuestionService;

public class FifthHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/worldcup/forth.jsp";
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
	
	
	//6개 중 3개 선택한 걸 받아서 2개/1개 넘기기. 
	private String processSubmit(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("-------------여기부터 FifthHandler 영역입니다.---------------");
		//현재 클릭된 값만 넘겨 받아서 question_id를 int리스트에 넣는다. 
		List<Integer> fifth =new ArrayList<>(); 
		
		//walkOver값이 있다면-> name의 숫자가 달라지니까 확인해야한다. 
		String isit = req.getParameter("walkOver");
		
		if(isit!=null) {//부전승이 있었다면-> 부전승까지 합쳐서 짝수가 되어야한다. 
			//부전승은 선택 안됐으니까 선택된 질문 아이디 값에 넣으면 안된다. 
			for(int i =0; i< req.getParameterMap().size()-1;i++) {
				int what =Integer.valueOf(req.getParameter("name"+i));
				fifth.add(what);
			}
			//그러면 리스트는 부전승을 뺀 나머지 숫자임.
			//부전승인 값을 따로 받아야함. 
			int walk =Integer.valueOf(req.getParameter("walkOver"));
			fifth.add(walk);
			System.out.println("선택된 퀘스천아이디 넘어오나?"+fifth.toString());
		}else {//부전승이 없었다면!! 계속해도됨.  
			for(int i =0; i< req.getParameterMap().size();i++) {
				int what =Integer.valueOf(req.getParameter("name"+i));
				fifth.add(what);
			}
		}
		
	
		//선택 갯수가 홀수인지 짝수인지 판별해서 부전승을 보낸다. 
		if(fifth.size()%2==0) {//짝수일 때 -> 부전승 없음. 
			//질문 리스트
			List<Question> question = new ArrayList<>(); 
			for(int j =0; j<fifth.size(); j++) {
				question.add( plz.q_listQuestion(fifth.get(j)));//질문 아이디를 파라미터로 넣어서 Question_class 객체를 생성한다. 
			}
			
			System.out.println("퀘스천 객체 제대로 만들어 졌는지?"+question.toString());
			
			
			boolean oddeven = true;//질문이짝수인지 아닌지. 질문이 짝수일 때 true
			
			//선택한 질문 리스트(퀘스천 클래스), 라디오 버튼 이름 할 거 전부 넘긴다. 
			req.setAttribute("question", question);
			req.setAttribute("name", listname(fifth));
			req.setAttribute("oddeven", oddeven);
			return "/WEB-INF/worldcup/fifth.jsp";
		}else {//홀수일 때 -> 부전승 있음. 
			
			//한 문제가 남음. 부전승으로 보내야 된다. 
			//마지막 한 문제를 빼고 퀘스천리스트에 넣음
			List<Question> question = new ArrayList<>();
			for(int j =0; j<fifth.size()-1; j++) {
				question.add( plz.q_listQuestion(fifth.get(j)));
			}
			
			System.out.println("퀘스천 객체 제대로 만들어 졌는지?"+question.toString());
			
			//마지막 한 문제를 퀘스천 객체로 만듬. 
			Question walkOver = plz.q_listQuestion(fifth.get(fifth.size()-1));
			boolean oddeven = false;//질문이짝수인지 아닌지. 질문이 홀수일 때 true
			
			
			//선택한 질문 리스트(퀘스천 클래스), 라디오 버튼 이름 할 거 전부 넘긴다. 
			req.setAttribute("question", question);//질문 보내기.
			req.setAttribute("name", listname(fifth));//라디오버튼 이름 보내기
			req.setAttribute("walkOver", walkOver);
			req.setAttribute("oddeven", oddeven);
			return "/WEB-INF/worldcup/fifth.jsp";
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

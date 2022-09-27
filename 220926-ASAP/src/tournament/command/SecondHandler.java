package tournament.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import tournament.model.Question;
import tournament.service.T_QuestionService;


//질문 8개 출력
//여기서 질문을 일단 저장해야함.
public class SecondHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/worldcup/first.jsp";
	private T_QuestionService plz = new T_QuestionService();
	static List<Question> AllList ;
	
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
	
	
	
	//현재 클릭된 값만 받아서 선택 형태로 넘겨준다. 
	public String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("-------------여기부터 secondHandler 영역입니다.---------------");
		
		//현재 클릭된 값만 넘겨 받아서 question_id를 int리스트에 넣는다. -11개임
		List<Integer> second =new ArrayList<>(); 
		
		//walkOver값이 있다면-> name의 숫자가 달라지니까 확인해야한다. 
		String isit = req.getParameter("walkOver");
		//현재 클릭된 값만 넘겨 받아서 question_id를 int리스트에 넣는다. 
		if(isit!=null) {//홀수라면!
			//부전승은 선택 안됐으니까 선택된 질문 아이디 값에 넣으면 안된다. 
			for(int i =0; i< req.getParameterMap().size()-1;i++) {
				int what =Integer.valueOf(req.getParameter("name"+i));
				second.add(what);
			}
			//그러면 리스트는 부전승을 뺀 나머지 숫자임.
			//부전승인 값을 따로 받아야함. 
			int walk =Integer.valueOf(req.getParameter("walkOver"));
			second.add(walk);
		}else {
			for(int i =0; i< req.getParameterMap().size();i++) {
				int what =Integer.valueOf(req.getParameter("name"+i));
				second.add(what);
			}
			System.out.println("질문 몇 개일까?"+second.size());
		}
		
		
		List<Question> question = new ArrayList<>(); 
		//선택 갯수가 홀수인지 짝수인지 판별해서 부전승을 보낸다. 
		if(second.size()%2==0) {//짝수일 때 -> 부전승 없음. 
			//질문 리스트
			
			for(int j =0; j<second.size(); j++) {
				question.add( plz.q_listQuestion(second.get(j)));//질문 아이디를 파라미터로 넣어서 Question_class 객체를 생성한다. 
			}
			boolean oddeven = true;//질문이짝수인지 아닌지. 질문이 짝수일 때 true
			//모든 질문을 담아 보낸다.
			AllList = question;
			
			//선택한 질문 리스트(퀘스천 클래스), 라디오 버튼 이름 할 거 전부 넘긴다. 
			req.setAttribute("question", question);
			req.setAttribute("name", listname(second));
			req.setAttribute("oddeven", oddeven);
			return "/WEB-INF/worldcup/second.jsp";
		}else {//홀수일 때 -> 부전승 있음. 
			//한 문제가 남음. 부전승으로 보내야 된다. 
			//마지막 한 문제를 빼고 퀘스천리스트에 넣음
			
			//0-10까지가 원래 인덱스임. -> 0-9까지 question에 넣고, 10은 walkover객체에 넣어서 보낸다.
			for(int j =0; j<second.size()-1; j++) {
				question.add( plz.q_listQuestion(second.get(j)));
			}
			System.out.println("퀘스천 객체에 뭐 들어있을까? "+question.toString());
			
			//마지막 한 문제를 퀘스천 객체로 만듬. 
			Question walkOver = plz.q_listQuestion(second.get(second.size()-1));
			System.out.println("walkOver객체에 들어있는건? "+walkOver.toString());
			
			boolean oddeven = false;//질문이짝수인지 아닌지. 질문이 홀수일 때 true
			//모든 질문을 담는다. 
			AllList = question;
			
			//선택한 질문 리스트(퀘스천 클래스), 라디오 버튼 이름 할 거 전부 넘긴다. 
			req.setAttribute("question", question);//질문 보내기.
			req.setAttribute("name", listname(second));//라디오버튼 이름 보내기
			req.setAttribute("walkOver", walkOver);
			req.setAttribute("oddeven", oddeven);
			return "/WEB-INF/worldcup/second.jsp";
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
	
	public List<Question> allQuestion() {
		return AllList;
	}
	
	
	
}

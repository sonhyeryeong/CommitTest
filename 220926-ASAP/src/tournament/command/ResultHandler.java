package tournament.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import tournament.model.Question;
import tournament.service.T_QuestionService;

public class ResultHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/worldcup/forth.jsp";
	private T_QuestionService plz = new T_QuestionService();
	private ThirdHandler third = new ThirdHandler();
	private ForthHandler forth = new ForthHandler();
	
	
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
	
	
	
	//여기서 1-6위까지 결과 도출하기 !!!!
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("-------------여기부터ResultHandler 영역입니다.---------------");
		
		
		//선택된 퀘스천아이디를  받는 변수
		int result = Integer.valueOf(req.getParameter("name0"));
	
		System.out.println("선택한 퀘스천아이디: "+ result);
		
		
		Question two = null;
		if(forth.two().get(0).getQuestion_id()!=result) {//선택된거랑 같지 않으면
			two = plz.q_listQuestion(forth.two().get(0).getQuestion_id());
		}
		if(forth.two().get(1).getQuestion_id()!=result) {//선택된거랑 같지 않으면
			two = plz.q_listQuestion(forth.two().get(1).getQuestion_id());
		}
			
		System.out.println("선택 안한 거"+ two.toString());
		
		
		
		Question question =  plz.q_listQuestion(result);
		
		
		
		
		
		
		
		List<Question> threeTofour = forth.threeTofour();
		List<Question> fourtoEight = third.fourtoEight();
		
		
		
		System.out.println("1위는: "+question.toString());
		System.out.println("2위까지 : "+two.toString());
		System.out.println("3위-4위까지 : "+threeTofour.toString());
		System.out.println("4위-8위까지 : "+fourtoEight.toString());
		
		
		//db에 넣는거. 일단 주석처리함. 
//		//여기다 로그인한 유저 아이디 넣어야함. 
//		String user_id = "gPfud";
//		
//		for(int k=0; k<9; k++) {
//			if(k==0) {//처음
//				plz.insert(user_id, question.getQuestion_id(), (k+1));
//			}else if(k==1){//두번째
//				plz.insert(user_id, two.getQuestion_id(), (k+1));
//			}else if (k==2) {//3-4
//				plz.insert(user_id, threeTofour.get(0).getQuestion_id(), (k+1));
//			}else if(k==3) {//
//				plz.insert(user_id, threeTofour.get(1).getQuestion_id(), (k+1));
//			}else if(k==4) {//5-8
//				plz.insert(user_id, fourtoEight.get(0).getQuestion_id(), (k+1));
//			}else if(k==5) {//
//				plz.insert(user_id, fourtoEight.get(1).getQuestion_id(), (k+1));
//			}else if(k==6) {//
//				plz.insert(user_id, fourtoEight.get(2).getQuestion_id(), (k+1));
//			}else if(k==7) {//
//				plz.insert(user_id, fourtoEight.get(3).getQuestion_id(), (k+1));
//			}
//		}
		

		//값 전부 보내자 !!!!!!
		req.setAttribute("one", question);
		req.setAttribute("two", two);
		req.setAttribute("fourtoEight", fourtoEight);
		req.setAttribute("threeTofour", threeTofour);
		return "/WEB-INF/worldcup/result.jsp";
	}
	
	// 라디오버튼 이름-두개씩 똑같은 이름 만드는 메소드
		public List<String> listname(List list) {
			List<String> name = new ArrayList<>();
			int k = 0;
			// 질문이 7개면-> 00 11 22 3 이 되는데 하나 남을 필요가 없다.
			// 짝수일 때
			if (list.size() % 2 == 0) {
				for (int i = 0; i < list.size(); i++) {
					name.add("name" + k);
					if ((i + 1) % 2 == 0) {
						k++;
					}
				}
				return name;
			} else {// 홀수일 때
				for (int i = 0; i < list.size() - 1; i++) {
					name.add("name" + k);
					if ((i + 1) % 2 == 0) {
						k++;
					}
				}
				return name;
			}

		}
}

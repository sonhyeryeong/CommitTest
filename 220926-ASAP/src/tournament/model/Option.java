package tournament.model;

public class Option {
	int option_id;
	int question_id1;
	String option_text;
	String group_text;
	
	public Option(int option_id, int question_id, String option_text, String group_text) {
		super();
		this.option_id = option_id;
		this.question_id1 = question_id;
		this.option_text = option_text;
		this.group_text = group_text;
	}
	
	public int getOption_id() {
		return option_id;
	}

	public void setOption_id(int option_id) {
		this.option_id = option_id;
	}

	public int getQuestion_id() {
		return question_id1;
	}

	public void setQuestion_id(int question_id) {
		this.question_id1 = question_id;
	}

	public String getOption_text() {
		return option_text;
	}

	public void setOption_text(String option_text) {
		this.option_text = option_text;
	}

	public String getGroup_text() {
		return group_text;
	}

	public void setGroup_text(String group_text) {
		this.group_text = group_text;
	}

	@Override
	public String toString() {
		return "Option [option_id=" + option_id + ", question_id=" + question_id1 + ", option_text=" + option_text
				+ ", group_text=" + group_text + "]";
	}

	 int question_id;
	   int topic_id;
	   String question_text;
	
	
}

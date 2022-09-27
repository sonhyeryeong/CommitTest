package tournament.model;

public class Question {
	   int question_id;
	   int topic_id;
	   String question_text;
	   
	   public Question() {}
	   
	   public Question(int question_id, int topic_id, String question_text) {
	      this.question_id = question_id;
	      this.topic_id = topic_id;
	      this.question_text = question_text;
	   }

	   public int getQuestion_id() {
	      return question_id;
	   }

	   public void setQuestion_id(int question_id) {
	      this.question_id = question_id;
	   }

	   public int getTopic_id() {
	      return topic_id;
	   }

	   public void setTopic_id(int topic_id) {
	      this.topic_id = topic_id;
	   }

	   public String getQuestion_text() {
	      return question_text;
	   }

	   public void setQuestion_text(String question_text) {
	      this.question_text = question_text;
	   }

	   @Override
	   public String toString() {
	      return "Question [question_id=" + question_id + ", topic_id=" + topic_id + ", question_text=" + question_text
	            + "]";
	   }
	}

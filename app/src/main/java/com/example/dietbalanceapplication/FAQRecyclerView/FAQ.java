package com.example.dietbalanceapplication.FAQRecyclerView;

/**
 * @author Devika krishnan
 * Date: Nov 6, 2021
 * PlaceHolder class that contains items to displayed in the recycler view
 */
public class FAQ {
    private String question;
    private String answer;

    /**
     * Constructor
     */
    public FAQ() {
    }

    /**
     * Constructor for initialising properties
     * @param question
     * @param answer
     */
    public FAQ(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * To get Questions display on the recycle view
     * @return question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Set Question
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * To get answers for the questions
     * @return answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Set Answers
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

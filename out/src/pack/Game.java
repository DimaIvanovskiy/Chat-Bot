package pack;


 class Game {

    State GameState = State.STARTING;

    private Category category;

    private Archive archive = new Archive();

    private Question question;

    public Question getQuestion()
    {
        return question;
    }

    Question changeAndGetNewQuestion()
    {
        question = archive.getQuestionAndAnswer(category, false);
        return question;
    }
    void setCategory(Category category)
    {
        this.category = category;
        GameState = State.ASKING_QUESTION;
        question = archive.getQuestionAndAnswer(category, true);
    }
}

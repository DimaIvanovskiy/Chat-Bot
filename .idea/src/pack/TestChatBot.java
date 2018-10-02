package pack;

import static org.junit.Assert.*;

public class TestChatBot {

    private Archive archive = new Archive();

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }


    @org.junit.Test
    public void testStart()
    {
        ChatBot bot = new ChatBot();
        String expectedResult = Archive.greetingInformation + Archive.categoryInformation;
        String message = bot.start();
        assertEquals(expectedResult, message);
    }
    @org.junit.Test
    public void testCommandChange()
    {
        ChatBot bot = new ChatBot();
        String message = "-change";
        assertEquals(Archive.categoryInformation, bot.processCommands(message));
    }

    @org.junit.Test
    public void testCommandHelp()
    {
        ChatBot bot = new ChatBot();
        String message = "-help";
        String expectedResult = Archive.greetingInformation;
        assertEquals(expectedResult, bot.processCommands(message));
    }

    @org.junit.Test
    public void testWrongCategory()
    {
        ChatBot bot = new ChatBot();
        String result = bot.start();
        String message = "hello";
        result = bot.processMessage(message);
        assertEquals("There is no such category. Try again.", result);
    }

    @org.junit.Test
    public void testCorrectCategory()
    {
        ChatBot bot = new ChatBot();
        String result = bot.start();
        String message = "Geography";
        result = bot.processMessage(message);
        boolean flag = false;
        for (Question q: archive.geographyQuestions)
        {
            if (q.question.equals(result))
                flag = true;
        }
        assertTrue(flag);
    }

    @org.junit.Test
    public void testWrongAnswer()
    {
        ChatBot bot = new ChatBot();
        String result = bot.start();
        String message = "Cinematography";
        result = bot.processMessage(message);
        message = "choose life";
        result = bot.processAnswers(message);

        assertNotEquals("Your answer is right.\n", result);
    }

    @org.junit.Test
    public void testSetCategory()
    {
        Game game = new Game();
        game.setCategory(Category.JOKES);
        Question question = game.getQuestion();
        boolean flag = false;
        for (Question q: archive.jokes)
        {
            if (q.question.equals(question.question))
                flag = true;
        }
        assertTrue(flag);
    }

    @org.junit.Test
    public void testGetQuestionAndAnswer() {
        Question question = archive.getQuestionAndAnswer(Category.CINEMATOGRAPHY,
                false);
        boolean flag = false;
        for (Question q : archive.cinematographyQuestions) {
            if (q.question.equals(question.question))
                flag = true;
        }
        assertTrue(flag);
    }
}
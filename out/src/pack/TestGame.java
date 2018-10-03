package pack;

import static org.junit.Assert.assertTrue;

public class TestGame {

    private Archive archive = new Archive();

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
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
}

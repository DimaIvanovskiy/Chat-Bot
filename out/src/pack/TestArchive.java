package pack;

import static org.junit.Assert.assertTrue;

public class TestArchive {

    private Archive archive = new Archive();

    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
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

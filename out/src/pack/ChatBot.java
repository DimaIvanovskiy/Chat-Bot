package pack;


import java.text.MessageFormat;

public class ChatBot
{

    private Game game = new Game();

    public String start()
    {
        game.GameState = State.CHANGING_CATEGORY;
        return Archive.greetingInformation + Archive.categoryInformation;
    }

    public String processAnswers(String message)
    {
        String result = processCommands(message);
        if (result == null)
        {
            if (message.equalsIgnoreCase(game.getQuestion().answer))
                result = "Your answer is right.\n";
            else {
                Question question = game.getQuestion();
                result = MessageFormat.format("Your answer is wrong. The right answer is {0}.\n{1}",
                        question.answer, question.description);
            }
                result += game.changeAndGetNewQuestion().question;
        }
        return result;
    }

    public String processCommands(String message)
    {
        String result = "";
        switch (message.toLowerCase())
        {
            case "-help":
                result = Archive.greetingInformation;
                break;
            case "-change":
                result = Archive.categoryInformation;
                game.GameState = State.CHANGING_CATEGORY;
                break;
            case "-exit":
                System.exit(0);
                break;
            default:
                result = null;
                break;
        }
        return result;
    }

    public String processMessage(String message)
    {
        String result = "";

        switch (game.GameState)
        {
            case CHANGING_CATEGORY:
                result = processCommands(message);
                if (result != null)
                    break;
                Category category = Category.fromString(message);
                if (category != null)
                {
                    game.setCategory(category);
                    result = game.getQuestion().question;
                }
                else
                    result = "There is no such category. Try again.";
                break;
            case ASKING_QUESTION:
                result = processAnswers(message);
                break;
        }
        return result;
    }
}

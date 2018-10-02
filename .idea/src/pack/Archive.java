package pack;



import java.text.MessageFormat;
import java.util.*;


public class Archive {

    private ArrayList<Question> notAskedQuestions = new ArrayList<>();

    public Question chooseQuestion(ArrayList<Question> questions, Boolean changeCategory)
    {
        if ((changeCategory == true) || (notAskedQuestions.size() == 0))
        {
            notAskedQuestions = new ArrayList<>(questions);
        }
        Random random = new Random();
        int index = random.nextInt(notAskedQuestions.size());
        Question question = notAskedQuestions.get(index);
        notAskedQuestions.remove(question);
        return question;
    }


    public Question getQuestionAndAnswer(Category category, Boolean changeCategory)
    {
        Question question = new Question("","", "");

        switch(category) {
            case QUADRATIC_EQUATION:
            {
                question = generateQuadraticEquationQuestion();
                break;
            }
            case GEOGRAPHY:
            {
                question = chooseQuestion(geographyQuestions, changeCategory);
                break;
            }
            case CINEMATOGRAPHY:
            {
                question = chooseQuestion(cinematographyQuestions, changeCategory);
                break;
            }
            case JOKES:
            {
                question = chooseQuestion(jokes, changeCategory);
                break;
            }

        }
        return question;
    }


    private Question generateQuadraticEquationQuestion()
    {
        Random random = new Random();
        int x1 = random.nextInt(20) - 10;
        int x2 = random.nextInt(20) - 10;
        int a = random.nextInt(20) - 10;
        while (a == 0)
            a = random.nextInt(20) - 10;
        int b = -a*(x1+x2);
        int c = a*x1*x2;
        String answer = String.format("%d %d", x1, x2);
        if (x1 > x2)
            answer = String.format("%d %d", x2, x1);
        String pattern = "What are the answers of this equation {0, choice, -1#{0}|1#|2#{0}}x^2" +
                "{1, choice, -1#{1}x|0#|0<+{1}x}{2, choice, -1#{2}|0#|0<+{2}}=0? Wright both of them ascending.";
        return new Question(MessageFormat.format(pattern, a, b, c), answer, "");
    }

    final ArrayList<Question> geographyQuestions =  new ArrayList<Question>()
    {{
         add(new Question("What is the capital of Great Britain?","London", ""));
         add(new Question("What is the capital of Russia?","Moscow", ""));
         add(new Question("What is the name of sea in which you can't sink?", "Death sea",
                 "Death sea contains too much solt and density of water is bigger than density of human.\n" +
                         "That's way you can't sink\n"));
         add(new Question("What is the first country which admire independence of Abkhazia?",
                 "Russia", "Abkhazia called yorself independent in 1994.\n" +
                 "But other countris did not agree with it and only in 2008 after conflict Russia and five countries\n" +
                 "from UNO admired independence\n"));
         add(new Question("Who was the first president of Russian Federation?", "Boris Yeltsin",
                 "Boris Yeltsin was a Soviet and Russian politician" +
                         " and the first President of the Russian Federation, serving from 1991 to 1999.\n" +
                         " Originally a supporter of Mikhail Gorbachev, Yeltsin emerged under the perestroika reforms " +
                         "as one of Gorbachev's most powerful political opponents.\n" +
                         "During the late 1980s, Yeltsin had been a candidate member of the Politburo, " +
                         "and in late 1987 tendered a letter of resignation in protest.\n" +
                         " No one had resigned from the Politburo before.\n" +
                         "This act branded Yeltsin as a rebel and led to his rise in popularity as an anti-establishment " +
                         "figure\n"));
    }};

    final ArrayList<Question> cinematographyQuestions = new ArrayList<Question>()
    {{
        add(new Question("What is the name of seven full-length film of Fellini?", "Eighth and a half",
                "It is a 1963 surrealist comedy-drama film directed by Federico Fellini.\n" +
                        "Co-scripted by Fellini, Tullio Pinelli, Ennio Flaiano, and Brunello Rondi,\n" +
                        "it stars Marcello Mastroianni as Guido Anselmi,\n" +
                        "a famous Italian film director who suffers from stifled creativity as he attempts to direct\n" +
                        "an epic science fiction film.\n" +
                        "Its title refers to it being Fellini's eighth and a half film as a director.\n" +
                        "His previous directorial work consisted of six features,\n" +
                        "two short segments, and a collaboration with another director,\n" +
                        "Alberto Lattuada, the latter three treated as half films\n"));
        add(new Question("Which film got the Oscar in category 'Best film' in 2018?", "Shape of water",
                "It is a 2017 American romantic dark fantasy drama film directed by Guillermo del Toro and " +
                        "written by del Toro and Vanessa Taylor.\n" +
                        "The story follows a mute custodian at a high-security " +
                        "government laboratory who falls in love with a captured humanoid amphibian creature\n"));
        add(new Question("Which film is admired the best film of all time?", "Citizen Kane",
                "It is is a 1941 American mystery drama film by Orson Welles.\n" +
                        "The quasi-biographical film examines the life and legacy of Charles Foster Kane, " +
                        "played by Welles,\n a character based in part upon the American newspaper magnates " +
                        "William Randolph Hearst and Joseph Pulitzer,\n " +
                        "Chicago tycoons Samuel Insull and Harold McCormick,\n" +
                        "and aspects of the screenwriters' own lives.\n" +
                        "Upon its release, Hearst prohibited mention of the film in any of his newspapers.\n" +
                        "Kane's career in the publishing world is born of idealistic social service,\n" +
                        "but gradually evolves into a ruthless pursuit of power.\n" +
                        "Narrated principally through flashbacks, the story is told through the research\n" +
                        "of a newsreel reporter seeking to solve the mystery" +
                        "of the newspaper magnate's dying word: Rosebud.\n"));
        add(new Question("What is the name of the first sound film?", "The Jazz Singer",
                "It is a 1927 American musical film by Alan Crosland.\n" +
                        "The film depicts the fictional story of Jakie Rabinowitz," +
                        "a young man who defies the traditions of his devout Jewish family.\n" +
                        "After singing popular tunes in a beer garden he is punished by his father,\n" +
                        "a hazzan (cantor), prompting Jakie to run away from home. Some years later,\n" +
                        "now calling himself Jack Robin, he has become a talented jazz singer.\n" +
                        "He attempts to build a career as an entertainer but his professional\n" +
                        "ambitions ultimately come into conflict with the demands of his home and heritage.\n"));
        add(new Question("What is the name of first soviet film who got the main award in Cannes?",
                "The cranes are flying", "It is a 1957 film about World War II.\n" +
                "It depicts the cruelty of war and the damage suffered to the Soviet psyche as a result " +
                "of World War II\n" +
                "It was directed by Soviet director Mikhail Kalatozov in 1957\n" +
                "and stars Aleksey Batalov and Tatiana Samoilova.\n"));
    }};

    final ArrayList<Question> jokes = new ArrayList<Question>()
    {{
        add(new Question("Как испортить прекрасный советский фильм? Сделать в наше время...",
                "Продолжение", ""));
        add(new Question("Ночь. Темно. К мужику кто-то стучится в дверь.\n" +
                "Открывает, а там старуха с косой стоит.\n" +
                "Он её и спрашивает: 'Ты кто?'\nОна ему отвечает: 'Смерть'.\n'Ну и что?'", "Ну и всё",
                ""));
        add(new Question("Горбачев во время визита в Штаты спрашивает Рейгана:\n" +
                "- Как ты так подбираешь таких умных людей себе в администрацию? вокруг меня одни балбесы.\n " +
                "- Да очень просто, перед приёмом на работу я задаю им загадку, вот смотри.\n" +
                "Вызывает Буша:\n " +
                "- Ответь на такой вопрос: кто сын твоего отца, но не твой брат?\n " +
                "- Я, конечно, - отвечает Буш.\n " +
                "- Вот видишь!\n " +
                "Приезжает Горбачев в Москву, вызывает Лигачева и спрашивает:\n " +
                "- Егор, кто сын твоего отца, но не твой брат? Лигачев говорит, что ответ знает, но забыл.\n " +
                "- Ну иди тогда подумай\n" +
                "Лигачев выходит из кабинета и садится подслушивать у замочной скважины.\n " +
                "Горбачёв вызывает Ельцина.\n " +
                "- Борис, ответь мне, кто сын твоего отца, но не твой брат?\n " +
                "- Я, конечно, - говорит Ельцин.\n " +
                "Лигачев с радостными криками вбегает в кабинет.\n " +
                "- Я вспомнил, вспомнил!!! Это Ельцин! Горбачев в ответ:\n" +
                "- Дураки вы оба! Это...\n", "Буш", ""));
    }};

    final static String greetingInformation = "Hello, my name is Rosa. I am the greatest chat-bot for quizzes. " +
            "I will ask you some questions and your task is to answer them correctly.\n" +
            "Here are commands that are available for you to use:\n" +
            "'-exit'-use it if you want to close me\n" +
            "'-help'-use it if you want to read about my functions\n" +
            "'-change'-use it if you want to change the category of questions\n";

    final static String categoryInformation = "Please choose one of this categories for question and write " +
            "it:\n" +
            "1)Quadratic equation\n" +
            "2)Geography\n" +
            "3)Cinematography\n" +
            "4)Jokes — category in which you should finish the joke";
}

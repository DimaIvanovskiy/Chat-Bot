package pack;

import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        ChatBot bot = new ChatBot();
        Scanner scanner = new Scanner(System.in);

        System.out.println(bot.start());
        while(true)
        {
            String message = scanner.nextLine();
            System.out.println(bot.processMessage(message));
        }
    }
}

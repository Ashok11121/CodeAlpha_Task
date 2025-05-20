import java.util.Scanner;

public class Chatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello! I am your chatbot. Ask me anything!");

        while (true) {
            String userInput = scanner.nextLine().toLowerCase();
            
            if (userInput.contains("hello")) {
                System.out.println("Hi there! How can I assist you?");
                System.out.println("How can help you today?");
            } else if (userInput.contains("bye")) {
                System.out.println("Goodbye! Have a great day!");
                break;
            } else {
                System.out.println("I'm still learning. Can you rephrase?");
                System.out.println(userInput+" is not a valid command.");
            }
        }

        scanner.close();
    }
}

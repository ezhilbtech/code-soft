package codsoft_task_4;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private static final int TIME_LIMIT = 10;
    private Question[] questions;
    private int score;
    private Scanner scanner;

    public Quiz(Question[] questions) {
        this.questions = questions;
        this.score = 0;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        for (int i = 0; i < questions.length; i++) {
            askQuestion(questions[i]);
        }
        showResults();
    }

    private void askQuestion(Question question) {
        System.out.println(question.getQuestionText());
        String[] options = question.getOptions();
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ": " + options[i]);
        }

        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                scanner.close();
            }
        };
        timer.schedule(timerTask, TIME_LIMIT * 1000);

        System.out.print("Your answer: ");
        String answer = scanner.nextLine();

        timer.cancel();

        if (answer.equalsIgnoreCase(question.getCorrectAnswer())) {
            score++;
            System.out.println("Correct!");
        } else {
            System.out.println("Incorrect. The correct answer was: " + question.getCorrectAnswer());
        }
    }

    private void showResults() {
        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + "/" + questions.length);
    }

    public static void main(String[] args) {
        Question[] questions = {
            new Question("What is the capital of France?", new String[]{"Paris", "London", "Berlin", "Madrid"}, "Paris"),
            new Question("What is 2 + 2?", new String[]{"3", "4", "5", "6"}, "4"),
            new Question("Who is the caption of Strawhats?", new String[]{"Shanks", "Zoro", "Luffy", "Kaido"}, "Luffy"),
            new Question("Who is the Right-hand man of Future pirate king?", new String[]{"sanji", "Rayley", "Zoro", "Benchmann"}, "Zoro")
        };
        Quiz quiz = new Quiz(questions);
        quiz.start();
    }
}

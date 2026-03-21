import java.util.Scanner;
public class RockPaperScissors {
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3); 
        if (choice == 0) return "Rock";
        if (choice == 1) return "Paper";
        return "Scissors";
    }
    public static String findWinner(String user, String computer) {
        if (user.equalsIgnoreCase(computer)) return "Tie";
        if ((user.equalsIgnoreCase("Rock") && computer.equals("Scissors")) ||
            (user.equalsIgnoreCase("Scissors") && computer.equals("Paper")) ||
            (user.equalsIgnoreCase("Paper") && computer.equals("Rock"))) {
            return "User";
        }
        return "Computer";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int games = sc.nextInt();
        int userWins = 0, compWins = 0;
        for (int i = 0; i < games; i++) {
            System.out.print("Game " + (i+1) + " - Rock, Paper, or Scissors? ");
            String user = sc.next();
            String computer = getComputerChoice();
            String winner = findWinner(user, computer);
            System.out.println("Computer chose: " + computer + " | Winner: " + winner);
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) compWins++;
        }
        System.out.println("\n--- Final Stats ---");
        System.out.printf("User Win %%: %.2f%%\n", ((double)userWins/games) * 100);
        System.out.printf("Computer Win %%: %.2f%%\n", ((double)compWins/games) * 100);
    }
}
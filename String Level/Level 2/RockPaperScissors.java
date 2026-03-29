import java.util.*;
public class RockPaperScissors {
    public static String getComputerChoice() {
        String[] choices = {"rock", "paper", "scissors"};
        int index = (int)(Math.random() * 3);
        return choices[index];
    }
    public static String getWinner(String user, String comp) {
        if (user.equals(comp)) return "Draw";
        if ((user.equals("rock") && comp.equals("scissors")) ||
            (user.equals("paper") && comp.equals("rock")) ||
            (user.equals("scissors") && comp.equals("paper"))) {
            return "User";
        } else {
            return "Computer";
        }
    }
    public static String[] getStats(int userWins, int compWins, int totalGames) {
        double userPercent = (userWins * 100.0) / totalGames;
        double compPercent = (compWins * 100.0) / totalGames;
        return new String[]{
            String.format("%.2f", userPercent),
            String.format("%.2f", compPercent)
        };
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of games: ");
        int n = sc.nextInt();
        sc.nextLine();
        int userWins = 0, compWins = 0;
        System.out.println("\nGame Results:");
        System.out.println("Game\tUser\tComputer\tWinner");
        for (int i = 1; i <= n; i++) {
            System.out.print("Enter choice (rock/paper/scissors): ");
            String user = sc.nextLine().toLowerCase();
            String comp = getComputerChoice();
            String winner = getWinner(user, comp);
            if (winner.equals("User")) userWins++;
            else if (winner.equals("Computer")) compWins++;
            System.out.println(i + "\t" + user + "\t" + comp + "\t\t" + winner);
        }
        String[] stats = getStats(userWins, compWins, n);
        System.out.println("\nUser Win % = " + stats[0]);
        System.out.println("Computer Win % = " + stats[1]);
        sc.close();
    }
}
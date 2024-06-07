import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;
import CandidateDao.CandidateDao;
import Entity.Candidate;
import UserDao.UserDao;
import Entity.User;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            CandidateDao candidateDao = new CandidateDao();
            UserDao userDao = new UserDao();

            boolean exit = false;
            while (!exit) {
                System.out.println("Menu:");
                System.out.println("1. Add Candidate");
                System.out.println("2. View All Candidates");
                System.out.println("3. Add User");
                System.out.println("4. View User by Email");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addCandidate(scanner, candidateDao);
                        break;
                    case 2:
                        viewAllCandidates(candidateDao);
                        break;
                    case 3:
                        addUser(scanner, userDao);
                        break;
                    case 4:
                        viewUserByEmail(scanner, userDao);
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addCandidate(Scanner scanner, CandidateDao candidateDao) throws SQLException {
        System.out.print("Enter candidate name: ");
        String name = scanner.next();
        System.out.print("Enter candidate party: ");
        String party = scanner.next();
        System.out.print("Enter candidate votes: ");
        int votes = scanner.nextInt();

        Candidate newCandidate = new Candidate(name, party, votes);
        candidateDao.save(newCandidate);
        System.out.println("Candidate added successfully.");
    }

    private static void viewAllCandidates(CandidateDao candidateDao) throws SQLException {
        System.out.println("All Candidates:");
        for (Candidate candidate : candidateDao.findAll()) {
            System.out.println(candidate);
        }
    }

    private static void addUser(Scanner scanner, UserDao userDao) throws SQLException {
        System.out.print("Enter user first name: ");
        String firstName = scanner.next();
        System.out.print("Enter user last name: ");
        String lastName = scanner.next();
        System.out.print("Enter user email: ");
        String email = scanner.next();
        System.out.print("Enter user password: ");
        String password = scanner.next();
        System.out.print("Enter user date of birth (yyyy-mm-dd): ");
        Date dob = Date.valueOf(scanner.next());
        System.out.print("Enter user role: ");
        String role = scanner.next();

        User newUser = new User(firstName, lastName, email, password, dob, role);
        userDao.save(newUser);
        System.out.println("User added successfully.");
    }

    private static void viewUserByEmail(Scanner scanner, UserDao userDao) throws SQLException {
        System.out.print("Enter user email to search: ");
        String email = scanner.next();
        User user = userDao.findByEmail(email);
        if (user.getId() != 0) {
            System.out.println("User found:");
            System.out.println(user);
        } else {
            System.out.println("User not found.");
        }
    }
}

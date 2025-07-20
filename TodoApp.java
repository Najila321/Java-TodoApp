import java.util.ArrayList;
import java.util.Scanner;

public class TodoApp {
    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n====== TO-DO LIST APP ======");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (choice != 5);
    }

    static void addTask() {
        System.out.print("Enter a new task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }

    static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
        } else {
            System.out.println("Your Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    static void updateTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to update: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            if (index >= 1 && index <= tasks.size()) {
                System.out.print("Enter updated task: ");
                String newTask = scanner.nextLine();
                tasks.set(index - 1, newTask);
                System.out.println("Task updated.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }

    static void deleteTask() {
        viewTasks();
        if (!tasks.isEmpty()) {
            System.out.print("Enter task number to delete: ");
            int index = scanner.nextInt();
            scanner.nextLine();
            if (index >= 1 && index <= tasks.size()) {
                tasks.remove(index - 1);
                System.out.println("Task deleted.");
            } else {
                System.out.println("Invalid task number.");
            }
        }
    }
}

import java.io.*;
import java.util.*;

public class TimeCapsule {
    private static final String FILE_PATH = "timecapsule.txt";
    private static final Scanner userIn = new Scanner(System.in);
    private static List<CapsuleItem> capsuleItems = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("You and your friend have found a time capsule that you buried 5 years ago. What do you find inside?");
        loadExistingData();
        fillCapsule("user1");
        fillCapsule("user2");
        saveData();
        displayCapsuleContents();
    }

    private static void loadExistingData() {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\|");
                    if (parts.length == 3) {
                        capsuleItems.add(new CapsuleItem(parts[0], parts[1], parts[2]));
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading existing data: " + e.getMessage());
            }
        }
    }

    private static void fillCapsule(String user) {
        System.out.println("\n" + user + "'s turn:");
        
        System.out.println("Would you like to add a memory? (yes/no)");
        String answer = userIn.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("What memory would you like to add?");
            String memory = userIn.nextLine();
            addToCapsule(user, "memory", memory);
        }

        System.out.println("Would you like to add a special connection? (yes/no)");
        answer = userIn.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("What connection would you like to add?");
            String connection = userIn.nextLine();
            addToCapsule(user, "connection", connection);
        }

        System.out.println("Would you like to add a song? (yes/no)");
        answer = userIn.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Enter the song name:");
            String song = userIn.nextLine();
            addToCapsule(user, "song", song);
        }
    }

    private static void addToCapsule(String user, String type, String content) {
        capsuleItems.add(new CapsuleItem(user, type, content));
    }

    private static void saveData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (CapsuleItem item : capsuleItems) {
                writer.write(item.getUser() + "|" + item.getType() + "|" + item.getContent());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }

    private static void displayCapsuleContents() {
        System.out.println("\nWould you like to see what's inside the time capsule? (yes/no)");
        String answer = userIn.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
            if (capsuleItems.isEmpty()) {
                System.out.println("The time capsule is empty!");
            } else {
                System.out.println("\n===== TIME CAPSULE CONTENTS =====");
                for (CapsuleItem item : capsuleItems) {
                    System.out.println(item.getUser() + " added a " + item.getType() + ": " + item.getContent());
                }
                System.out.println("=================================");
            }
        }
    }

    // Inner class to represent a capsule item
    private static class CapsuleItem {
        private String user;
        private String type;
        private String content;

        public CapsuleItem(String user, String type, String content) {
            this.user = user;
            this.type = type;
            this.content = content;
        }

        public String getUser() {
            return user;
        }

        public String getType() {
            return type;
        }

        public String getContent() {
            return content;
        }
    }
}
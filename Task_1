import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();
        
        System.out.println("Enter students' grades (type -1 to stop): ");
        
        while (true) {
            double grade = scanner.nextDouble();
            if (grade == -1) break; // Terminate input collection
            grades.add(grade);
        }
        
        if (grades.isEmpty()) {
            System.out.println("No grades entered.");
        } else {
            double average = calculateAverage(grades);
            double highest = findHighest(grades);
            double lowest = findLowest(grades);
            
            System.out.println("Average Score: " + average);
            System.out.println("Highest Score: " + highest);
            System.out.println("Lowest Score: " + lowest);
        }
        
        scanner.close();
    }

    private static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    private static double findHighest(ArrayList<Double> grades) {
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    private static double findLowest(ArrayList<Double> grades) {
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}

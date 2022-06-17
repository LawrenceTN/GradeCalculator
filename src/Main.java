/*
QLs:
https://www.geeksforgeeks.org/why-is-scanner-skipping-nextline-after-use-of-other-next-functions/
https://stackoverflow.com/questions/40181706/while-loop-repeats-twice-after-user-input
https://stackoverflow.com/questions/51231169/how-to-i-ensure-an-exception-is-thrown-if-user-input-is-not-an-integer-and-the

A grade calculating program that prompts the user for information about the courses they are taking for the purpose of obtaining their grades.


            Ex:
            MATH 150 : 40%, 30%, 15%, 15%
            _____________________________________________________
            Assignment - Entered grade --> (Entered grade / 100) * Weighted %
            Test - Enter 78.6% --> (78.6 / 100) * (40% / 100) * 100=
            Quiz - 85.3% --> (85.3 / 100) * Weighted % = ...
            Homework - 93.3% --> (93.3 / 100) * Weighted % = ...
            Lab - 88.9% --> (88.9 / 100) * Weighted % = ...
            _____________________________________________________
            */


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static int setTestPercentage(int currPercent, Course currCourse){
        Scanner input = new Scanner(System.in);
        int testPerc = 0;
        boolean isFinished = false;
        while(!isFinished){
            try {
                System.out.print("Test percentage (0 - " + currPercent + "): ");
                testPerc = Integer.parseInt(input.nextLine());

                if (testPerc > currPercent) {
                    System.out.println("Percentage cannot be higher than current percentage");
                } else {
                    isFinished = true;
                }
            }
            catch (NumberFormatException ex){
                System.out.println("Invalid input, please try again.");
            }
        }
        currCourse.setTests_perc(testPerc);
        currPercent -= currCourse.getTests_perc();
        return currPercent;
    }

    public static int setQuizPercentage(int currPercent, Course currCourse){
        Scanner input = new Scanner(System.in);
        int quizPerc = 0;
        boolean isFinished = false;
        while(!isFinished){
            try {
                System.out.print("Quiz percentage (0 - " + currPercent + "): ");
                quizPerc = Integer.parseInt(input.nextLine());

                if (quizPerc > currPercent) {
                    System.out.println("Percentage cannot be higher than current percentage");
                } else {
                    isFinished = true;
                }
            }
            catch (NumberFormatException ex){
                System.out.println("Invalid input, please try again.");
            }
        }
        currCourse.setQuizzes_perc(quizPerc);
        currPercent -= currCourse.getQuizzes_perc();
        return currPercent;
    }

    public static int setHWPercentage(int currPercent, Course currCourse){
        Scanner input = new Scanner(System.in);
        int hwPerc = 0;
        boolean isFinished = false;
        while(!isFinished){
            try {
                System.out.print("Homework percentage (0 - " + currPercent + "): ");
                hwPerc = Integer.parseInt(input.nextLine());

                if (hwPerc > currPercent) {
                    System.out.println("Percentage cannot be higher than current percentage");
                } else {
                    isFinished = true;
                }
            }
            catch (NumberFormatException ex){
                System.out.println("Invalid input, please try again.");
            }
        }
        currCourse.setHomework_perc(hwPerc);
        currPercent -= currCourse.getHomework_perc();
        return currPercent;
    }

    public static int setLabPercentage(int currPercent, Course currCourse){
        Scanner input = new Scanner(System.in);
        int labPerc = 0;
        boolean isFinished = false;
        while(!isFinished) {
            try {
                System.out.print("Lab percentage (0 - " + currPercent + "): ");
                labPerc = Integer.parseInt(input.nextLine());

                if (labPerc > currPercent) {
                    System.out.println("Percentage cannot be higher than current percentage");
                } else {
                    isFinished = true;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid input, please try again.");
            }
        }
        currCourse.setLabs_perc(labPerc);
        currPercent -= currCourse.getLabs_perc();
        return currPercent;
    }


    public static void main(String[] args){
        System.out.println("Welcome! Tired of your professor not weighing grades correctly on blackboard?");
        System.out.println("Enter your grades here as well as the weight of each type of assignment and we'll do what your professor is too lazy to do!");

        Scanner input = new Scanner(System.in);

        int number_of_assignments, number_of_courses = 0;
        boolean isPercentFinished = false;
        boolean isPercentEntered = false;
        List<Course> courses = new ArrayList<>();

        do {
            try {
                System.out.print("# of courses: ");
                number_of_courses = Integer.parseInt(input.nextLine()); // Reading input as a 'String' and converting it to an int
            } catch (NumberFormatException ex) {
                System.out.println("Not a valid number input");
            }
        } while(number_of_courses == 0);


        System.out.println("Please enter your courses and their details below: ");

            for (int i = 0; i < number_of_courses; i++) {
                int percent = 100;
                char choice;

                Course newCourse = new Course();
                System.out.print("Name of course: ");
                newCourse.setName(input.nextLine());
                System.out.println("\nCourse: " + newCourse.getName());

            do {
                percent = setTestPercentage(percent, newCourse);
                percent = setQuizPercentage(percent, newCourse);
                percent = setHWPercentage(percent, newCourse);
                percent = setLabPercentage(percent, newCourse);

                newCourse.displayPerc();

                System.out.println("Is this correct? Enter 'Y' to confirm...");

                        choice = input.next().charAt(0);

                        if (choice == 'Y') {
                            input.nextLine();
                            courses.add(newCourse);
                            isPercentFinished = true;
                            break;
                        } else {
                            input.nextLine();
                            System.out.println("Please re-enter the course's information.");
                            isPercentFinished = false;
                            percent = 100;
                        }

                } while(!isPercentFinished);
            }


        int currentCourse = 0;
        do {
            double score = 0;
            boolean avgTestGradeFinished = false;
            boolean avgQuizGradeFinished = false;
            boolean avgHWGradeFinished = false;
            boolean avgLabGradeFinished = false;

            do {
                System.out.println("Enter your average test grade percentage for " + courses.get(currentCourse).getName() + ":");
                try {
                    // courses.get(currentCourse).setTest_score(input.nextDouble());
                    courses.get(currentCourse).setTest_score(Double.parseDouble(input.nextLine()));
                    score += courses.get(currentCourse).calculateTest();
                    avgTestGradeFinished = true;
                } catch (NumberFormatException ex) {
                    System.out.println("This is not a valid number input");
                }
            } while ( avgTestGradeFinished != true);

            do {
                System.out.println("Enter your quiz grade percentage for " + courses.get(currentCourse).getName() + ":");
                try {
                    courses.get(currentCourse).setQuiz_score(Double.parseDouble(input.nextLine()));
                    score += courses.get(currentCourse).calculateQuiz();
                    avgQuizGradeFinished = true;
                } catch (NumberFormatException ex) {
                    System.out.println("This is not a valid number input");
                }
            } while( avgQuizGradeFinished != true);

            do {
                System.out.println("Enter your homework grade percentage for " + courses.get(currentCourse).getName() + ":");
                try {
                    courses.get(currentCourse).setHomework_score(Double.parseDouble(input.nextLine()));
                    score += courses.get(currentCourse).calculateHW();
                    avgHWGradeFinished = true;
                } catch (NumberFormatException ex) {
                    System.out.println("This is not a valid number input");
                }
            } while ( avgHWGradeFinished != true);

            do {
                System.out.println("Enter your lab grade percentage for " + courses.get(currentCourse).getName() + ":");
                try {
                    courses.get(currentCourse).setLabs_score(Double.parseDouble(input.nextLine()));
                    score += courses.get(currentCourse).calculateLab();
                    avgLabGradeFinished = true;
                } catch (NumberFormatException ex) {
                    System.out.println("This is not a valid number input");
                }
            } while( avgLabGradeFinished != true);


            score = (double) Math.round(score * 100) / 100; // Round it to 2 decimal places
            courses.get(currentCourse).setGrade(score);

            courses.get(currentCourse).getGrade();

            currentCourse++;

            if (currentCourse == number_of_courses) {
                isPercentEntered = true;
            }
        } while(!isPercentEntered);
    }
}
public class Course {
    private String name;
    private int tests_perc, quizzes_perc, homework_perc, labs_perc;
    public double test_score, quiz_score, homework_score, labs_score;
    private double grade;

    public void setName(String name){
        this.name = name;
    }

    public void setTests_perc (int tests_perc){
        this.tests_perc = tests_perc;
    }

    public void setQuizzes_perc (int quizzes_perc){
        this.quizzes_perc = quizzes_perc;
    }

    public void setHomework_perc (int homework_perc){
        this.homework_perc = homework_perc;
    }

    public void setLabs_perc (int labs_perc){
        this.labs_perc = labs_perc;
    }

    public int getTests_perc(){
        return tests_perc;
    }

    public int getQuizzes_perc(){
        return quizzes_perc;
    }

    public int getHomework_perc(){
        return homework_perc;
    }

    public int getLabs_perc(){
        return labs_perc;
    }

    public String getName(){
        return name;
    }

    public void displayPerc(){
        System.out.println("___________________");
        System.out.println("Course: " + name);
        System.out.println("Tests: " + tests_perc + "%");
        System.out.println("Quizzes: " + quizzes_perc + "%");
        System.out.println("Homework: " + homework_perc + "%");
        System.out.println("Labs: " + labs_perc + "%");
        System.out.println("___________________");
        return;
    }

    public double calculateTest(){
        double result = (test_score / 100.0) * (tests_perc / 100.0);
        return result;
    }
    public double calculateQuiz() {
        double result = (quiz_score / 100.0) * (quizzes_perc / 100.0);
        return result;
    }
    public double calculateHW() {
        double result = (homework_score / 100.0) * (homework_perc / 100.0);
        return result;
    }
    public double calculateLab() {
        double result = (labs_score / 100.0) * (labs_perc / 100.0);
        return result;
    }
/*
    public double calculateLab(int labs_perc, double labs_score) {
        double result = (labs_score / 100.0) * (labs_perc / 100.0);
        return result;
 */
    public void setGrade(double score){
        this.grade = score;
    }

    public void getGrade(){
        System.out.println("Your score is " + grade);
    }
}


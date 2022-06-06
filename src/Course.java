public class Course {
    private String name;
    private int tests_perc, quizzes_perc, homework_perc, labs_perc;
    private double test_score, quiz_score, homework_score, labs_score;

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


}


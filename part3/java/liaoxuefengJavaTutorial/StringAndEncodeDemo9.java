import java.util.Arrays;

public class StringAndEncodeDemo9 {
    public static void main(String[] args) {
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score s = new Score(scores);
        s.printScores();
        scores[2] = 99;
        s.printScores();
    }
}

class Score{
    private int[] scores;

    public Score(int[] scores) {

        this.scores = scores.clone();
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }

}
package com.nc.dev3.lomako.beans.answer;

/**
 * Created by arturlomako on 3/18/17.
 */
public class AnswerResult {
    private int countCorrectAnswersTotal;
    private int countCorrectAnswersUser;

    public AnswerResult() { }

    public AnswerResult(int countCorrectAnswersTotal, int countCorrectAnswersUser) {
        this.countCorrectAnswersTotal = countCorrectAnswersTotal;
        this.countCorrectAnswersUser = countCorrectAnswersUser;
    }

    public int getCountCorrectAnswersTotal() {
        return countCorrectAnswersTotal;
    }

    public void setCountCorrectAnswersTotal(int countCorrectAnswersTotal) {
        this.countCorrectAnswersTotal = countCorrectAnswersTotal;
    }

    public int getCountCorrectAnswersUser() {
        return countCorrectAnswersUser;
    }

    public void setCountCorrectAnswersUser(int countCorrectAnswersUser) {
        this.countCorrectAnswersUser = countCorrectAnswersUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AnswerResult)) return false;

        AnswerResult that = (AnswerResult) o;

        if (countCorrectAnswersTotal != that.countCorrectAnswersTotal) return false;
        return countCorrectAnswersUser == that.countCorrectAnswersUser;
    }

    @Override
    public int hashCode() {
        int result = countCorrectAnswersTotal;
        result = 31 * result + countCorrectAnswersUser;
        return result;
    }

    @Override
    public String toString() {
        return "AnswerResult{" +
                "countCorrectAnswersTotal=" + countCorrectAnswersTotal +
                ", countCorrectAnswersUser=" + countCorrectAnswersUser +
                '}';
    }
}

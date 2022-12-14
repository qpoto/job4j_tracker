package ru.job4j.map;
import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double subjectsQuantity = 0;
        double subjectsScore = 0;
         for (Pupil pupil : pupils) {
            for (Subject sub : pupil.subjects()) {
                subjectsScore += sub.score();
                subjectsQuantity++;
            }
        }
        return subjectsScore / subjectsQuantity;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> pupilAvarageScore = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = subject.score();
                Label pupilLabel = new Label(pupil.name(), score);
                pupilAvarageScore.add(pupilLabel);
            }
        }
        return pupilAvarageScore;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        return List.of();
    }

    public static Label bestStudent(List<Pupil> pupils) {
        return null;
    }

    public static Label bestSubject(List<Pupil> pupils) {
        return null;
    }
}

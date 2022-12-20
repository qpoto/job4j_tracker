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
            int subjectQuantity = 0;
            int scoreQuantity = 0;
            for (Subject subject : pupil.subjects()) {
                scoreQuantity += subject.score();
                subjectQuantity++;
            }
            pupilAvarageScore.add(new Label(pupil.name(), scoreQuantity / subjectQuantity));
        }
        return pupilAvarageScore;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> time = new LinkedHashMap<>();
        int pupilQuantity = 0;
        for (Pupil pupil : pupils) {
            pupilQuantity++;
            for (Subject subject : pupil.subjects()) {
                String name = subject.name();
                int score = time.containsKey(name) ? time.get(name) : 0;
                score += subject.score();
                time.put(name, score);
            }
        }
        List<Label> averageScoreBySubject = new ArrayList<>();
        for (String key : time.keySet()) {
            int value = time.get(key);
            averageScoreBySubject.add(new Label(key, value / pupilQuantity));
        }
        return averageScoreBySubject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> bestPupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int scoreQuantity = 0;
            for (Subject subject : pupil.subjects()) {
                scoreQuantity += subject.score();
            }
            bestPupil.add(new Label(pupil.name(), scoreQuantity));
        }
        bestPupil.sort(Comparator.naturalOrder());
        return bestPupil.get(bestPupil.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> time = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String name = subject.name();
                int score = time.containsKey(name) ? time.get(name) : 0;
                score += subject.score();
                time.put(name, score);
            }
        }
        List<Label> bestSubjectScore = new ArrayList<>();
        for (String key : time.keySet()) {
            int value = time.get(key);
            bestSubjectScore.add(new Label(key, value));
        }
        bestSubjectScore.sort(Comparator.naturalOrder());
        return bestSubjectScore.get(bestSubjectScore.size() - 1);
    }
}

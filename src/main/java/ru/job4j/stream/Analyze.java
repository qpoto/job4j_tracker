package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.subjects().stream())
                .mapToInt(Subject::score)
                .average() // как вернуть отсюда double?
                .orElse(0.0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.name(), 0))// не въеду как посчитать7
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return null;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
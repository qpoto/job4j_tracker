package ru.job4j.stream;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(e -> e.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0.0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.name(), e.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .average()
                        .getAsDouble()))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        stream.flatMap(e -> e.subjects().stream().collect(Collectors.groupingBy(Subject::name, LinkedHashMap::new, Collectors.averagingDouble()))
                .entrySet()
                .stream()
                .map(en -> new Tuple(en.getKey(), en.getValue()))
                .collect(Collectors.toList()));
        return List.of();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.name(), e.subjects()
                        .stream()
                        .mapToInt(Subject::score)
                        .sum()))
                .max(Comparator.comparing(Tuple::score))
                .orElse();
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return null;
    }
}
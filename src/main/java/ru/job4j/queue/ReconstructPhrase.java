package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> evenElements;

    private final Deque<Character> descendingElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder expected = new StringBuilder();
        for (int i = 1; i < evenElements.size(); i++) {
            if (i % 2 == 0) {
                expected.append(evenElements.poll());
            }
        }
        return expected.toString();
    }

    private String getDescendingElements() {
        return "";
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
package ru.job4j.search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class PhoneDictionaryTest {

    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk"));
        ArrayList<Person> persons = phones.find("Petr");
        assertThat(persons.get(0).getSurname()).isEqualTo("Arsentev");
    }

    @Test
    public void whenNotFind() {
        PhoneDictionary phones = new PhoneDictionary(); // Создаем новую "записную книжку"
        phones.add(new Person("Petr", "Arsentev", "534872", "Bryansk")); // Добавляем туда новый контакт
        ArrayList<Person> persons = phones.find("Efim"); //Записная книжка ищет Ефима
        assertThat(persons.size()).isEqualTo(0); // Так Ефим стройкой выше не найден, то и коллекция не создается
        // (не возвращается, а соответственно ее не и размер ее равен 0, поэтому тут проверяем, что размер равен 0.
    }
}
package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {

    private Connection connection;

    public SqlTracker() {
        init();
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream input = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(input);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        int id = item.getId();
        String name = item.getName();
        //Далее что работа с Insert
        return null;
    }

    @Override
    public boolean replace(int id, Item item) {
        String name = item.getName();
        //Далее найти заявки по id и перезаписать данми
        return true;
    }

    @Override
    public void delete(int id) {
        //Тут работа с Delete from items where id = id
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        //Тут c select * from items, с созданием Item и добавлением в allItems
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        //Тут c select * from items where name = key, с созданием Item и добавлением в allItems
        return items;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();
        //Select * from users where id = id;
        return item;
    }
}
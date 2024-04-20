package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
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
                .getResourceAsStream("db/liquibase.properties")) {
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
        try (PreparedStatement pS =
                     connection.prepareStatement("INSERT INTO items(name, created) VALUES (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            pS.setString(1, item.getName());
            pS.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            pS.execute();
            try (ResultSet generatedKeys = pS.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean isReplace = false;
        try (PreparedStatement pS =
                     connection.prepareStatement("UPDATE items SET name = (?), created = (?) where id = (?)")) {
            pS.setString(1, item.getName());
            pS.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            pS.setInt(3, id);
            isReplace = pS.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isReplace;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement pS =
                     connection.prepareStatement("DELETE from items where id = (?)")) {
            pS.setInt(1, id);
            pS.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pS =
                     connection.prepareStatement("Select * from items")) {
            pS.execute();
            ResultSet rS = pS.getResultSet();
            while (rS.next()) {
                Item itemFromDB = new Item();
                itemFromDB.setId(rS.getInt("id"));
                itemFromDB.setName(rS.getString("name"));
                Timestamp timestamp = (rS.getTimestamp("created"));
                itemFromDB.setCreated(timestamp.toLocalDateTime());
                items.add(itemFromDB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> items = new ArrayList<>();
        try (PreparedStatement pS =
                     connection.prepareStatement("Select * from items where name = (?)")) {
            pS.setString(1, key);
            pS.execute();
            ResultSet rS = pS.getResultSet();
            while (rS.next()) {
                Item itemFromDB = new Item();
                itemFromDB.setId(rS.getInt("id"));
                itemFromDB.setName(rS.getString("name"));
                Timestamp timestamp = (rS.getTimestamp("created"));
                itemFromDB.setCreated(timestamp.toLocalDateTime());
                items.add(itemFromDB);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return items;
    }

    @Override
    public Item findById(int id) {
        Item itemFromDB = new Item();
        try (PreparedStatement pS =
                     connection.prepareStatement("Select * from items where id = (?)")) {
            pS.setInt(1, id);
            pS.execute();
            ResultSet rS = pS.getResultSet();
            if (rS.next()) {
                itemFromDB.setId(rS.getInt("id"));
                itemFromDB.setName(rS.getString("name"));
                Timestamp timestamp = (rS.getTimestamp("created"));
                itemFromDB.setCreated(timestamp.toLocalDateTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return itemFromDB;
    }
}
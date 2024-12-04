package ru.example;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.*;

public class Person implements Serializable{

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void serializePerson(String filename) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(this);
        }
    }
    
    public static Person deserializePerson(String filename) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            return (Person) in.readObject();
        }
    }
    
    public void serializePersonToJson(String filename) {
        JSONObject jsonPerson = new JSONObject();
        jsonPerson.put("name", this.name);
        jsonPerson.put("age", this.age);

        try (FileWriter file = new FileWriter(filename)) {
            file.write(jsonPerson.toString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Person deserializePersonFromJson(String filename) {
        Person person = new Person();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(filename)) {
            Object obj = parser.parse(reader);
            org.json.simple.JSONObject jsonPerson = (org.json.simple.JSONObject) obj;
            person.setName((String) jsonPerson.get("name"));
            person.setAge(((Long) jsonPerson.get("age")).intValue());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return person;
    }

}


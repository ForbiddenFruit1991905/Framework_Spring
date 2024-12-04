package ru.example;

import java.io.IOException;

public class App {
    public static void main(String[] args) {

        Person person = new Person();
        person.setName("Vika");
        person.setAge(33);

        // Сериализация объекта в файл
        try {
            person.serializePerson("person.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Десериализация объекта из файла
        try {
            Person deserializedPerson = Person.deserializePerson("person.ser");
            System.out.println("Десериализованный объект: " + deserializedPerson.getName() + ", " + deserializedPerson.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Сериализация объекта в JSON файл
        person.serializePersonToJson("person.json");
        System.out.println("Объект Person успешно сериализован в JSON");

        // Десериализация объекта из JSON файла
        Person newPerson = Person.deserializePersonFromJson("person.json");
        System.out.println("Десериализованный объект Person:");
        System.out.println("Имя: " + newPerson.getName());
        System.out.println("Возраст: " + newPerson.getAge());
    }
}



// seminar_1
//import com.google.common.base.Joiner;
//
//public class App
//{
//    public static void main( String[] args )
//    {
//        String[] words = {"Hello", "World"};
//        String message = Joiner.on(", ").join(words);
//
//        System.out.println(message);
//    }
//}

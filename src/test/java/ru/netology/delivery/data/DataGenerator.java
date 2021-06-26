package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        return date;
    }

    public static String generateCity(String locale) {
        String[] cities = {"Красноярск", "Санкт-Петербург", "Тюмень", "Уфа", "Абакан", "Мурманск", "Воронеж"};
        Random rnd = new Random();
        int index = rnd.nextInt(cities.length);

        return cities[index];
    }

    public static String generateName(String locale) {
        String name = faker.name().lastName() + " " + faker.name().firstName();

        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().phoneNumber();

        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale("ru"));
            return new UserInfo(
                    generateCity("ru"),
                    generateName("ru"),
                    generatePhone("ru")
            );
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
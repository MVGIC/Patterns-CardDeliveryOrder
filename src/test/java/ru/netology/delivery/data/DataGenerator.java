package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    private static Faker faker;

    @BeforeEach
    void setUpAll() {
        faker = new Faker(new Locale("ru"));
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        String city = faker.address().city();

        return city;
    }

    public static String generateName(String locale) {
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.phoneNumber().cellPhone();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            Faker faker = new Faker(new Locale("ru"));
            return new UserInfo(
                    generateDate(4),
                    generateCity("ru"),
                    generateName("ru"),
                    generatePhone("ru")
            );
        }
    }

    @Value
    public static class UserInfo {
        String date;
        String city;
        String name;
        String phone;
    }
}

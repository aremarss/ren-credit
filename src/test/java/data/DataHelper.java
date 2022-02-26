package data;

import com.github.javafaker.Faker;
import lombok.*;

import java.util.Locale;

public class DataHelper {

    private static final Faker faker = new Faker(new Locale("ru"));
    private static final String amount = "1_400_000"; // Сумма, которую необходимо внести в поле "Сумма вклада"

    @Value
    public static class AuthInfo {
        String lastName;
        String firstName;
        String phone;
        String mail;
        String gender;
        String place;
        String city;
    }

    public static AuthInfo userInfo() {
        return new AuthInfo(
                faker.name().lastName(),
                faker.name().firstName(),
                "9123456789",
                getMail(),
                "Женский",
                "Пензенская область",
                "Пенза"
        );
    }

    private static String getMail() {
        Faker faker = new Faker(new Locale("en"));
        return faker.internet().emailAddress();
    }

    public static String getAmount() {
        return amount;
    }
}
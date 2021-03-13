package com.company;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userCountryQuery;
        Country resultCountry = null;


        System.out.println("Добро пожаловать! Мы предоставляем информацию о следющих странах:");
        for (Country country : Country.values()) {
            System.out.println(country);
        }

        while (true) {
            System.out.println("Введите название страны:");
            userCountryQuery = scanner.next();
            if (userCountryQuery.equals("exit")) {
                break;
            }
            try {
                resultCountry = Country.valueOf(userCountryQuery);
            } catch (NullPointerException e) {
                System.out.println("Not valid argument: " + userCountryQuery);
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                System.out.println("Наименование страны на английском введено некорректно,"
                        + " проверяем русское название...");
                resultCountry = null;
            }
            if (resultCountry == null) {
                try {
                    resultCountry = Country.getByRuName(userCountryQuery);
                } catch (NoSuchCountryException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            }
            System.out.println(resultCountry.info());
            System.out.println("Введите \"exit\", что бы выйти\n");
        }
    }
}

package com.algaworks.junit;

import org.junit.jupiter.api.DisplayNameGenerator;

import java.lang.reflect.Method;

public class CustomDisplayNameGenerator implements DisplayNameGenerator {

    @Override
    public String generateDisplayNameForClass(Class<?> testClass) {
        return formatCase(testClass.getSimpleName());
    }

    @Override
    public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
        return nestedClass.getSimpleName();
    }


    @Override
    public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
        return formatCase(testMethod.getName());
    }


    private String formatCase(String input) {
        StringBuilder words = new StringBuilder();
        int start = 0;

        for (int i = 1; i < input.length(); i++) {
            if (Character.isUpperCase(input.charAt(i))) {
                words.append(input, start, i).append(" ");
                start = i;
            }
        }
        words.append(input.substring(start));

        String formattedString = words.toString().trim();
        formattedString = formattedString.substring(0, 1).toUpperCase() + formattedString.substring(1).toLowerCase();

        return formattedString;
    }
}
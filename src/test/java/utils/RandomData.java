package utils;

import java.util.Random;


public class RandomData {

    public static String generateLastName(){
        Random generate = new Random();
        String[] lastName = { "Morley", "Scott", "Kruger", "Lain",
                "Kennedy", "Gawron", "Han", "Hall", "Aydogdu", "Grace",
                "Spiers", "Perera", "Smith", "Connoly",
                "Sokolowski", "Chaow", "James", "June" };
        return lastName[generate.nextInt(lastName.length)];
    }

    public static String generateFirstName(){
        Random generate = new Random();
        String[] firstName = {"John", "Marcus", "Susan", "Henry","Bob","Jill","Tom","Brandon"};
        return firstName[generate.nextInt(firstName.length)];
    }

    public static String generatePassword(){
        Random random = new Random();
        char[] chars = "!@#$%^&*-_=+|;:,<.>/?"
                .toCharArray();
        String pwd = generateRandomName(8) + chars[random.nextInt(chars.length)] + random.nextInt(10);
        return pwd;

    }
    private static String generateRandomName(int length) {
        char[] chars ="abcdefghijklmnopqrstuvwxyz"
                .toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        String randomString = sb.toString();
        return randomString;
    }

    public static String generateEmail()
    {
        String email=null;
        String name = generateRandomName(6);
        String domain = "testcompany";

        email=name + "@" + domain + ".com";

        return email;
    }

    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static String[] generateDOBvalues(int startYear, int endYear) {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(startYear, endYear);
        return new String[] {Integer.toString(day), Integer.toString(month),Integer.toString(year)};

        /*
        LocalDate dob = LocalDate.of(year, month, day);
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-M-yyyy");
        String dobString = dob.format(pattern);
        LocalDate dateParsed = LocalDate.parse(dobString, pattern);
        return dateParsed;

        */
    }




}

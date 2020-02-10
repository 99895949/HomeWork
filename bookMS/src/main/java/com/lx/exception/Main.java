package com.lx.exception;

import java.util.*;

public class Main {


    /**
     * 8. Combine all the code and create a Timetable program that allow only user with password to change the information and view the time table.
     */
    public static void main(String[] args) {

        HashMap<String, String[]> timetables = new HashMap<String, String[]>();

        List<String> courses = new ArrayList<String>(Arrays.asList("badminton", "math", "english", "chemical", "reading", "ec", "cs", "german", "writing"));

        final String CORRECT_PASSWORD = "admin";

        // 1. Write a simple code to get user input the password
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input password");
        String password = scanner.nextLine();


        // 2. Write a simple code to check the password if its correct, continue the program if it is not, exit.
        // default password is admin
        if (!password.equals(CORRECT_PASSWORD)) {
            System.out.println("Password Error,Program finished!");
            return;
        } else {
            System.out.println("Congratulations on the correct password");
        }

        // 3. Write an array call Timetable and store the time table for Monday from period 1 to period 9.
        timetables.put("Monday", courses.toArray(new String[0]));
        Collections.shuffle(courses);
        timetables.put("Tuesday", courses.toArray(new String[0]));
        Collections.shuffle(courses);
        timetables.put("Wednesday", courses.toArray(new String[0]));
        Collections.shuffle(courses);
        timetables.put("Thursday", courses.toArray(new String[0]));
        Collections.shuffle(courses);
        timetables.put("Friday", courses.toArray(new String[0]));
        Collections.shuffle(courses);
        timetables.put("Saturday", courses.toArray(new String[0]));
        Collections.shuffle(courses);
        timetables.put("Sunday", courses.toArray(new String[0]));

        // 4. Write an program to allow user to choose the day to display their time table.
        // You may used IF…ELSE… or switch(refer: https://www.w3schools.com/java/java_switch.asp)
        boolean flag = true;
        while (flag) {
            System.out.println("Replace Sunday to Saturday with 1 to 7,input 0 exit");
            int day = scanner.nextInt();
            switch (day) {
                case 1:
                    System.out.println("Sunday's Timetable:" + Arrays.toString(timetables.get("Sunday")));
                    break;
                case 2:
                    System.out.println("Monday's Timetable:" + Arrays.toString(timetables.get("Monday")));
                    break;
                case 3:
                    System.out.println("Tuesday's Timetable:" + Arrays.toString(timetables.get("Tuesday")));
                    break;
                case 4:
                    System.out.println("Wednesday's Timetable:" + Arrays.toString(timetables.get("Wednesday")));
                    break;
                case 5:
                    System.out.println("Thursday's Timetable:" + Arrays.toString(timetables.get("Thursday")));
                    break;
                case 6:
                    System.out.println("Friday's Timetable:" + Arrays.toString(timetables.get("Friday")));
                    break;
                case 7:
                    System.out.println("Saturday's Timetable:" + Arrays.toString(timetables.get("Saturday")));
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("Selection error...");
            }
        }

        // 5. Create a class call password check. Call the class in to your Main program. (You may refer to my ppt on java OPP and class)
        class PasswordCheck {
            public boolean checkpasswd(String password, String correct_password) {
                return password.equals(correct_password);
            }
        }
        PasswordCheck check = new PasswordCheck();
        System.out.println("Please input password again:");
        scanner = new Scanner(System.in);
        password = scanner.nextLine();
        if (check.checkpasswd(password, CORRECT_PASSWORD)) {
            System.out.println("Congratulations on the correct password");
        } else {
            System.out.println("Password Error,Program finished!");
            return;
        }

        // 6. Write a code to have the user edit the timetable that you have created in question 3.
        // You user are allow to choose which period to edit.
        boolean flag1 = true;
        while (flag1) {
            System.out.println("Replace Sunday to Saturday with 1 to 7,input 0 exit");
            int day = scanner.nextInt();
            switch (day) {
                case 1:
                    System.out.println("Sunday's Timetable:" + Arrays.toString(timetables.get("Sunday")));
                    edit(timetables.get("Sunday"));
                    break;
                case 2:
                    System.out.println("Monday's Timetable:" + Arrays.toString(timetables.get("Monday")));
                    edit(timetables.get("Monday"));
                    break;
                case 3:
                    System.out.println("Tuesday's Timetable:" + Arrays.toString(timetables.get("Tuesday")));
                    edit(timetables.get("Sunday"));
                    break;
                case 4:
                    System.out.println("Wednesday's Timetable:" + Arrays.toString(timetables.get("Wednesday")));
                    edit(timetables.get("Wednesday"));
                    break;
                case 5:
                    System.out.println("Thursday's Timetable:" + Arrays.toString(timetables.get("Thursday")));
                    edit(timetables.get("Thursday"));
                    break;
                case 6:
                    System.out.println("Friday's Timetable:" + Arrays.toString(timetables.get("Friday")));
                    edit(timetables.get("Friday"));
                    break;
                case 7:
                    System.out.println("Saturday's Timetable:" + Arrays.toString(timetables.get("Saturday")));
                    edit(timetables.get("Saturday"));
                    break;
                case 0:
                    flag1 = false;
                    String key;
                    String[] value;
                    Iterator it = timetables.keySet().iterator();
                    while (it.hasNext()) {
                        key = (String) it.next();
                        value = timetables.get(key);
                        System.out.println(key + "--" + Arrays.toString(value));
                    }
                    break;
                default:
                    System.out.println("Selection error...");
            }
        }
    }

    public static void edit(String[] timetable) {
        Scanner scanner = null;
        while (true) {
            System.out.println("Please select a period to edit. input 0 means to exit");
            scanner = new Scanner(System.in);
            int period = scanner.nextInt();
            if (period >= 1 && period <= 9) {
                System.out.println("Please enter what you want to do in the period " + period);
                scanner = new Scanner(System.in);
                String doWhat = scanner.nextLine();
                timetable[period - 1] = doWhat;
                System.out.println("new timetable is :" + Arrays.toString(timetable));
            } else if (period == 0) {
                System.out.println("editing is ended!");
                System.out.println("the latest timetable is :" + Arrays.toString(timetable));
                break;
            } else {
                System.out.println("input error");
            }
        }

    }
}

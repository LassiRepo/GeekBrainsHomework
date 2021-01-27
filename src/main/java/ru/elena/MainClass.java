package ru.elena;

public class MainClass {
    public static void main(String[] args) {
        Employee person1 = new Employee("Иванов Иван Иванович",
                "Инженер",
                "ivanov@mail.ru",
                "+7(085)555-55-55",
                60000.00,
                39);

        person1.print();

        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000.00, 30);
        persArray[1] = new Employee("Volkov Ivan", "Economist", "vvv@mail.ru", "892212122", 35000.00, 49);
        persArray[2] = new Employee("Zaytsev Alexsandr", "Engineer", "zzz@yandex.ru", "892223333", 40000.00, 33);
        persArray[3] = new Employee("Petrov Nikolay", "Director", "ppp@mail.ru", "899954622", 100000.00, 51);
        persArray[4] = new Employee("Usov Petr", "Economist", "uuu@mail.ru", "899955533", 36000.00, 22);

        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].getAge() > 40) {
                persArray[i].print();
            }

        }

    }
}


package ru.elena;

public class Employee {
    private String name;
    private String position;
    private String eMail;
    private String phoneNumber;
    private double salary;
    private int age;

    public Employee(String name, String position, String eMail, String phoneNumber, double salary, int age) {
        this.name = name;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;

    }
    public void print() {
        System.out.println("ФИО "+ name);
        System.out.println("Должность " + position);
        System.out.println("Email " + eMail);
        System.out.println("Телефон " + phoneNumber);
        System.out.println("Зарплата " + salary);
        System.out.println("Возраст " + age);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
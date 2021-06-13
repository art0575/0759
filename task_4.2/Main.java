/*
Создать class Dog. У собаки должна быть кличка String name и возраст int age.
Создайте геттеры и сеттеры для всех переменных класса Dog.
Требования:
•	Программа не должна считывать данные с клавиатуры.
•	У класса Dog должна быть переменная name с типом String.
•	У класса Dog должна быть переменная age с типом int.
•	У класса должен быть сеттер для переменной name.
•	У класса должен быть геттер для переменной name.
•	У класса должен быть сеттер для переменной age.
•	У класса должен быть геттер для переменной age.
*/


public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog(); // наследует и имя и возраст
        Dog dog2 = new Dog(); // не наследует
        Dog dog3 = new Dog(); // наследует имя
        Dog dog4 = new Dog(); // наследует возраст
        dog2.setName("Мурзик");
        dog2.setAge(3);
        dog3.setAge(5);
        dog4.setName("Алабай");
        System.out.println(dog1.getName()+" "+dog1.getAge());
        System.out.println(dog2.getName()+" "+dog2.getAge());
        System.out.println(dog3.getName()+" "+dog3.getAge());
        System.out.println(dog4.getName()+" "+dog4.getAge());

    }
}

//public class Dog {
class Dog {

    private String name = "Тузик";
    private int age = 2;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;

    }

}


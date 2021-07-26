package Interview.Lesson_1;

public class PersonBuilder {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;

    public PersonBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public PersonBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PersonBuilder setMiddleName(String middleNameName) {
        this.middleName = middleNameName;
        return this;
    }

    public PersonBuilder setCountry(String country) {
        this.country = country;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public PersonBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public Person build() {
        return new Person(firstName, lastName, middleName, country, address, phone, age, gender);
    }

    private static class Person {

        private String firstName;
        private String lastName;
        private String middleName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;

        public Person(String firstName, String lastName, String middleName, String country, String address, String phone, int age, String gender) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.country = country;
            this.address = address;
            this.phone = phone;
            this.age = age;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", middleName='" + middleName + '\'' +
                    ", country='" + country + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    ", age=" + age +
                    ", gender='" + gender + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        Person person = new PersonBuilder().
                setFirstName("Vasya").
                setLastName("Vasin").
                setMiddleName("Vasilevich").
                setCountry("Splyuevsk").
                setAddress("None").
                setPhone("99999").
                setAge(25).
                setGender("Male").
                build();
        System.out.println(person);
    }
}

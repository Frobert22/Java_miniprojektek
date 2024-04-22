package studentmanager;

import java.time.LocalDate;

public class Person {
    protected String name;
    protected String email;
    protected String phone;
    protected LocalDate birthDate;

    public Person(String name, String email, String phone) {
        if(!this.validateEmail(email)){
            throw new RuntimeException("Wrong email address!");
        }
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    private boolean validateEmail(String email){
        int atIdx = email.indexOf("@");
        int dotIdx = email.lastIndexOf(".");
        return atIdx > 0 && dotIdx > atIdx && dotIdx < email.length() - 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
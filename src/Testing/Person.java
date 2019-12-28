package Testing;

public class Person {
    private String first = null;
    private String lastName = null;
    public Person() {
    }
    public Person(String first, String lastName) {
        this.first = first;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return first;
    }
    public void setFirstName(String first) {
        this.first = first;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
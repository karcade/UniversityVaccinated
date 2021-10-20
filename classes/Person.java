package classes;

public class Person {
    private String firstname;
    private String surname;
    private boolean vacinated;

    public Person(String firstname,String surname, boolean vacinated){
        this.firstname=firstname;
        this.surname=surname;
        this.vacinated=vacinated;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public boolean getVacinated(){return vacinated;}


}

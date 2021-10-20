package classes;

public class Teacher extends Person{
    private String discipline;
    private int experience;

    public Teacher(String firstname, String surname,  String discipline, int experience, boolean vacinated) {
        super(firstname, surname, vacinated);
        this.discipline=discipline;
        this.experience=experience;
    }

    public String getDiscipline() {
        return discipline;
    }

    public int getExperience() {
        return experience;
    }

    public String toString() {
        String str="Имя:"+super.getFirstname()+ " " + super.getSurname()+
                "\nДисциплина: "+getDiscipline()+". Опыт:"+ getExperience()+
                " лет.\nВакцинирован/а: "+super.getVacinated()+"\n";
        return  str;
    }
}

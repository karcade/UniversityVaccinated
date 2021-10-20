package classes;

public class Student extends Person{
    private String specialization;
    private int course;

    public Student(String firstname, String surname,  String specialization, int course, boolean vacinated) {
        super(firstname, surname, vacinated);
        this.specialization=specialization;
        this.course = course;
    }

    public String getSpecialization() {
        return specialization;
    }

    public int getCourse() {
        return course;
    }

    public String toString() {
        String str="Имя:"+super.getFirstname()+ " " + super.getSurname()+
                "\nСпециальность: "+getSpecialization()+". Курс:"+ getCourse()+
                "\nВакцинирован/а: "+super.getVacinated()+"\n";
        return  str;
    }

}

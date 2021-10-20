package classes;

import java.util.List;

public class University {

    public static int personAmount(List<Person> universityList) {
        int amount=universityList.size();
        return amount;
    }

    public static int vacinatedPeople(List<Person> universityList) {
        int amountVacinated=0;
        for(Person person : universityList){
            if(person.getVacinated()) amountVacinated++;
        }
        return amountVacinated;
    }
}

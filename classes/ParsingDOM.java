package classes;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static classes.University.personAmount;
import static classes.University.vacinatedPeople;

public class ParsingDOM {
    // Коллекция для хранения студентов и преподовательского состава
    private static ArrayList<Person> universityList = new ArrayList<>();

    // Константы для элементов
    private static final String TEACHER = "teacher";
    private static final String STUDENT = "student";

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Запарсили XML, создав структуру Document
        Document document = builder.parse(new File("src/peopleInfo.hml"));

        // Получение информации про каждый элемент отдельно
        collectInformation(document, TEACHER);
        collectInformation(document, STUDENT);

        // Вывод информации
        universityList.forEach(System.out::println);
        System.out.println("Всего человек: "+personAmount(universityList));
        System.out.println("Из них вакцинированных: "+vacinatedPeople(universityList));
    }

    private static void collectInformation(Document document, final String element) {
        // Получение всех элементов по имени тега.
        NodeList elements = document.getElementsByTagName(element);

        // Перебор всех найденных элементов
        for (int i = 0; i < elements.getLength(); i++) {
            // Получение всех атрибутов элемента
            NamedNodeMap attributes = elements.item(i).getAttributes();
            String firstname = attributes.getNamedItem("firstname").getNodeValue();
            String surname = attributes.getNamedItem("surname").getNodeValue();
            String vacinated = attributes.getNamedItem("vacinated").getNodeValue();


            // В зависимости от типа элемента, нам нужно собрать свою дополнительну информацию про каждый подкласс, а после добавить нужные образцы в коллекцию.
            switch (element) {
                case TEACHER: {
                    String discipline = attributes.getNamedItem("discipline").getNodeValue();
                    String experience = attributes.getNamedItem("experience").getNodeValue();
                    universityList.add(new Teacher(firstname, surname, discipline, Integer.parseInt(experience), Boolean.parseBoolean(vacinated)));
                }
                break;
                case STUDENT: {
                    String course = attributes.getNamedItem("course").getNodeValue();
                    String specialization = attributes.getNamedItem("specialization").getNodeValue();
                    universityList.add(new Student(firstname, surname, specialization, Integer.parseInt(course), Boolean.parseBoolean(vacinated)));
                }
                break;
            }

        }
    }
}

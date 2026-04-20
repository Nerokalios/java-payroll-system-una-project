import java.util.ArrayList;

public class TestPrintList {

    static ArrayList<ArrayList<String>> people = new ArrayList<>();   // Global list that stores all people

    public static void main(String[] args) {

        ArrayList<String> person1 = new ArrayList<>();  // First person (inner list)
        person1.add("Wolfan");
        person1.add("Salcedo");
        person1.add("Male");
        person1.add("27");
        person1.add("Single");

        ArrayList<String> person2 = new ArrayList<>();  // Second person (inner list)
        person2.add("Isis");
        person2.add("Santana");
        person2.add("Female");
        person2.add("N/A");
        person2.add("N/A");

        people.add(person1);    // Add inner lists into the global list
        people.add(person2);

        System.out.println(people); // Print global list

        for (ArrayList<String> person : people) {   // Print all data
            System.out.println("Person:");
            System.out.println("Name: " + person.get(0));
            System.out.println("Surname: " + person.get(1));
            System.out.println("Gender: " + person.get(2));
            System.out.println("Age: " + person.get(3));
            System.out.println("Marital Status: " + person.get(4));
            System.out.println("----------------------");
        }
    }
}
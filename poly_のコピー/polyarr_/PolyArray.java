package com.hspedu.poly_.polyarr_;

public class PolyArray {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("Jack", 20);
        persons[1] = new Student("Marry", 18, 100);
        persons[2] = new Student("Smith", 19, 30.1);
        persons[3] = new Teacher("Scott", 30, 20000);
        persons[4] = new Teacher("King", 50, 25000);
        for(int i = 0; i < persons.length; i++) {
            System.out.println(persons[i].say());//動的バインティング
            if (persons[i] instanceof Student) {
//                ((Student)persons[i]).study();
                Student student = (Student) persons[i];
                student.study();
            } else if (persons[i] instanceof Teacher) {
//                ((Teacher) persons[i]).teach();
                Teacher teacher = (Teacher) persons[i];
                teacher.teach();
            } else {
                System.out.println("error");
            }
        }

    }
}

/*
Kod bazowy programu Commit4_0: 
• Program dodaje do prostej bazy danych (pliku db.txt) dane odnośnie Studentów.
• Studenci dodawani są w klasie Main.
• Wszyscy studenci są wypisywani na końcu klasy Main.
• Klasa Service obsługuje odczyt i zapis do pliku bazy danych.
• Klasa Student reprezentuje pojedynczego studenta (Imię, Wiek).
*/

import java.io.IOException;
import java.util.Scanner;
import java.util.Collection;

class Main {
  public static void main(String[] args) {
    try {
      Service s = new Service();
      Scanner sc = new Scanner(System.in);
System.out.println("1 - Dodaj studenta");
      System.out.println("2 - Wypisz wszystkich studentów");
      System.out.print("Wybierz opcję: ");
      int option = sc.nextInt();
      sc.nextLine(); 
      if(option == 1) {
        System.out.print("Podaj imię: ");
        String name = sc.nextLine();
        System.out.print("Podaj nazwisko: ");
        String surname = sc.nextLine();
        System.out.print("Podaj wiek: ");
        int age = sc.nextInt();
        s.addStudent(new Student(name, surname, age));
        System.out.println("Dodano studenta: " + name + " " + surname + " " + age);
      }
      else if(option == 2) {
        Collection<Student> students = s.getStudents();
        for(Student current : students) {
          System.out.println(current.ToString());
        }
      }
      else {
        System.out.println("Nieprawidłowa opcja");
      }
      sc.close();
    } catch (IOException e) {
      System.out.println("Błąd operacji na pliku");
    }
  }
}
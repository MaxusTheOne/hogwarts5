package dk.kea.dat3js.hogwarts5.students;

import dk.kea.dat3js.hogwarts5.house.House;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String firstName;
  private String middleName;
  private String lastName;
  @ManyToOne
  private House house;
  private Integer schoolYear; // 1-7

  public Student() {
  }

  public Student(String firstName, String lastName, House house, int schoolYear) {
    this(firstName, null, lastName, house, schoolYear);
  }

  public Student(String firstName, String middleName, String lastName, House house, int schoolYear) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.house = house;
    this.schoolYear = schoolYear;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = capitalize(firstName);
  }

  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = capitalize(middleName);
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = capitalize(lastName);
  }

  public House getHouse() {
    return house;
  }

  public void setHouse(House house) {
    this.house = house;
  }

  public Integer getSchoolYear() {
    return schoolYear;
  }

  public void setSchoolYear(Integer schoolYear) {
    this.schoolYear = schoolYear;
  }

  public String getFullName() {
    return firstName + " " + (middleName != null ? middleName + " " : "") + lastName;
  }

  public String setFullName(String fullName) {
    if (fullName == null) {
      fullName = "";
    }
    String[] names = fullName.split(" ");
    if (names.length == 0) {
      return "";
    }
    firstName = names[0];
    if (names.length > 2) {
        middleName = "";
      for (int i = 1; i < names.length - 1; i++) {
        if (i == names.length - 2) {
          middleName += capitalize(names[i]);
        } else {
          middleName += capitalize(names[i]) + " ";
        }
      }
      lastName = names[names.length - 1];
    } else if(names.length > 1){
      lastName = names[1];
      middleName = null;
    } else {
      lastName = null;
      middleName = null;
    }
    return getFullName();
  }

    public String capitalize(String str) {
      if (str == null || str.isEmpty()) {
        return str;
      }
        return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Student student = (Student) o;
    return Objects.equals(getFirstName(), student.getFirstName()) && Objects.equals(getMiddleName(), student.getMiddleName()) && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getHouse().getName(), student.getHouse().getName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getFirstName(), getMiddleName(), getLastName(), getHouse().getName());
  }

}

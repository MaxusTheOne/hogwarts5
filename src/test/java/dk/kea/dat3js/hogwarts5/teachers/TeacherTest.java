package dk.kea.dat3js.hogwarts5.teachers;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TeacherTest {

    @Test
    void getFullNameWithMiddleName() {
        // Arrange
        Teacher teacher = new Teacher("Harry", "James", "Potter",null, null, LocalDate.of(1990, 7, 31));

        // Act
        var result = teacher.getFullName();

        // Assert
        assertEquals("Harry James Potter", result);

    }

    @Test
    void getFullNameWithoutMiddleName() {
        // Arrange
        Teacher teacher = new Teacher("Cho", "Chang", null, null, LocalDate.of(1990, 7, 31));

        // Act
        var result = teacher.getFullName();

        // Assert
        assertEquals("Cho Chang", result);

    }

    @Test
    void setFullNameWithMiddleName() {
        // Arrange
        Teacher teacher = new Teacher();

        // Act
        teacher.setFullName("Hermione Jean Granger");
        var result = teacher.getFullName();

        // Assert
        assertEquals("Hermione", teacher.getFirstName());
        assertEquals("Jean", teacher.getMiddleName());
        assertEquals("Granger", teacher.getLastName());
    }

    @Test
    void setFullNameWithoutMiddleName() {
        // Arrange
        Teacher teacher = new Teacher();


        // Act
        teacher.setFullName("Neville Longbottom");
        var result = teacher.getFullName();

        // Assert
        assertEquals("Neville", teacher.getFirstName());
        assertNull(teacher.getMiddleName());
        assertEquals("Longbottom", teacher.getLastName());
    }

    @Test
    void setFullNameWithOnlyFirstName() {
        // Arrange
        Teacher teacher = new Teacher();

        // Act
        teacher.setFullName("Leanne");
        var result = teacher.getFullName();

        // Assert
        assertEquals("Leanne", teacher.getFirstName());
        assertNull(teacher.getMiddleName());
        assertNull(teacher.getLastName());
    }

    @Test
    void setFullNameWithManyMiddleNames() {
        // Arrange
        Teacher teacher = new Teacher();

        // Act
        teacher.setFullName("Albus Percival Wulfric Brian Dumbledore");
        var result = teacher.getFullName();

        // Assert
        assertEquals("Albus Percival Wulfric Brian Dumbledore", result);
    }

    @Test
    void setFullNameWithEmptyString() {
        // Arrange
        Teacher teacher = new Teacher();

        // Act
        teacher.setFullName("");
        var result = teacher.getFullName();

        // Assert
        assertEquals("", teacher.getFirstName());
        assertNull(teacher.getMiddleName());
        assertNull(teacher.getLastName());
    }

    @Test
    void setFullNameWithNull() {
        // Arrange
        Teacher teacher = new Teacher();

        // Act
        teacher.setFullName(null);
        var result = teacher.getFullName();

        // Assert
        assertEquals("", teacher.getFirstName());
    }

    @Test
    void capitalizeIndidualNames() {
        // Arrange
        Teacher teacher = new Teacher("first", "middle", "last",null, null, LocalDate.of(1990, 7, 31));

        // Act
        teacher.setFirstName("harry");
        teacher.setMiddleName("james");
        teacher.setLastName("potter");

        // Assert
        assertEquals("Harry", teacher.getFirstName());
        assertEquals("James", teacher.getMiddleName());
        assertEquals("Potter", teacher.getLastName());
    }

    @Test
    void capitalizeIndidualNamesWithCrazyInput() {
        // Arrange
        Teacher teacher = new Teacher("first", "middle", "last",null, null, LocalDate.of(1990, 7, 31));

        // Act
        teacher.setFirstName("hArRy");
        teacher.setMiddleName("jAmEs");
        teacher.setLastName("pOtTeR");

        // Assert
        assertEquals("Harry", teacher.getFirstName());
        assertEquals("James", teacher.getMiddleName());
        assertEquals("Potter", teacher.getLastName());
    }


}
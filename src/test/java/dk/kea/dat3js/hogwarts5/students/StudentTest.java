package dk.kea.dat3js.hogwarts5.students;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void getFullNameWithMiddleName() {
        // Arrange
        Student student = new Student("Harry", "James", "Potter", null, 5);

        // Act
        var result = student.getFullName();

        // Assert
        assertEquals("Harry James Potter", result);

    }

    @Test
    void getFullNameWithoutMiddleName() {
        // Arrange
        Student student = new Student("Cho", "Chang", null, 5);

        // Act
        var result = student.getFullName();

        // Assert
        assertEquals("Cho Chang", result);

    }

    @Test
    void setFullNameWithMiddleName() {
        // Arrange
        Student student = new Student();

        // Act
        student.setFullName("Hermione Jean Granger");
        var result = student.getFullName();

        // Assert
        assertEquals("Hermione", student.getFirstName());
        assertEquals("Jean", student.getMiddleName());
        assertEquals("Granger", student.getLastName());
    }

    @Test
    void setFullNameWithoutMiddleName() {
        // Arrange
        Student student = new Student();


        // Act
        student.setFullName("Neville Longbottom");
        var result = student.getFullName();

        // Assert
        assertEquals("Neville", student.getFirstName());
        assertNull(student.getMiddleName());
        assertEquals("Longbottom", student.getLastName());
    }

    @Test
    void setFullNameWithOnlyFirstName() {
        // Arrange
        Student student = new Student();

        // Act
        student.setFullName("Leanne");
        var result = student.getFullName();

        // Assert
        assertEquals("Leanne", student.getFirstName());
        assertNull(student.getMiddleName());
        assertNull(student.getLastName());
    }

    @Test
    void setFullNameWithManyMiddleNames() {
        // Arrange
        Student student = new Student();

        // Act
        student.setFullName("Albus Percival Wulfric Brian Dumbledore");
        var result = student.getFullName();

        // Assert
        assertEquals("Albus Percival Wulfric Brian Dumbledore", result);
    }

    @Test
    void setFullNameWithEmptyString() {
        // Arrange
        Student student = new Student();

        // Act
        student.setFullName("");
        var result = student.getFullName();

        // Assert
        assertEquals("", student.getFirstName());
        assertNull(student.getMiddleName());
        assertNull(student.getLastName());
    }

    @Test
    void setFullNameWithNull() {
        // Arrange
        Student student = new Student();

        // Act
        student.setFullName(null);
        var result = student.getFullName();

        // Assert
        assertEquals("", student.getFirstName());
    }

    @Test
    void capitalizeIndidualNames() {
        // Arrange
        Student student = new Student("first", "middle", "last", null, 5);

        // Act
        student.setFirstName("harry");
        student.setMiddleName("james");
        student.setLastName("potter");

        // Assert
        assertEquals("Harry", student.getFirstName());
        assertEquals("James", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }

    @Test
    void capitalizeIndidualNamesWithCrazyInput() {
        // Arrange
        Student student = new Student("first", "middle", "last", null, 5);

        // Act
        student.setFirstName("hArRy");
        student.setMiddleName("jAmEs");
        student.setLastName("pOtTeR");

        // Assert
        assertEquals("Harry", student.getFirstName());
        assertEquals("James", student.getMiddleName());
        assertEquals("Potter", student.getLastName());
    }


}
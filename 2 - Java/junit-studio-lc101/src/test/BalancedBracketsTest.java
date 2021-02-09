package test;

import org.junit.Test;

import static main.BalancedBrackets.hasBalancedBrackets;
import static org.junit.Assert.*;

public class BalancedBracketsTest {

    //TODO: add tests here
    @Test
    public void emptyTest() {
        assertEquals(true, true);
    }

    // 1 - [LaunchCode] : true
    @Test
    public void hasBalancedBrackets_ProperString1_ShouldReturnTrue() {
        // Arrange
        var string = "[LaunchCode]";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertTrue(expected);
    }

    // 2 Launch[Code]
    @Test
    public void hasBalancedBrackets_ProperString2_ShouldReturnTrue() {
        // Arrange
        var string = "Launch[Code]";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertTrue(expected);
    }


    // 3 - []LaunchCode
    @Test
    public void hasBalancedBrackets_ProperString3_ShouldReturnTrue() {
        // Arrange
        var string = "[]LaunchCode";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertTrue(expected);
    }

    // 4 -
    @Test
    public void hasBalancedBrackets_EmptyString_ShouldReturnTrue() {
        // Arrange
        var string = "";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertTrue(expected);
    }

    // 5 - []
    @Test
    public void hasBalancedBrackets_ProperSquareBracketsOnly_ShouldReturnTrue() {
        // Arrange
        var string = "";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertTrue(expected);
    }

    // 6 - [[
    @Test
    public void hasBalancedBrackets_DoubleOpenBrackets_ShouldReturnFalse() {
        // Arrange
        var string = "[[";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertFalse(expected);
    }

    // 7 - ]]
    @Test
    public void hasBalancedBrackets_DoubleCloseBrackets_ShouldReturnFalse() {
        // Arrange
        var string = "]]";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertFalse(expected);
    }

    // 8 - ][
    @Test
    public void hasBalancedBrackets_SwitchedBrackets_ShouldReturnFalse() {
        // Arrange
        var string = "][";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertFalse(expected);
    }

    // 9 - [][]
    @Test
    public void hasBalancedBrackets_DoubleProperBrackets_ShouldReturnFalse() {
        // Arrange
        var string = "[][]";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertTrue(expected);
    }

    // 10 - [[]]
    @Test
    public void hasBalancedBrackets_NestedBrackets_ShouldReturnFalse() {
        // Arrange
        var string = "[[]]";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertTrue(expected);
    }

    // 11 - [LaunchCode
    @Test
    public void hasBalancedBrackets_StringWithSingleOpenBracket_ShouldReturnFalse() {
        // Arrange
        var string = "[LaunchCode";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertFalse(expected);
    }

    // 12 - Launch]Code[
    @Test
    public void hasBalancedBrackets_ImproperlyPlacedBrackets_ShouldReturnFalse() {
        // Arrange
        var string = "Launch]Code[";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertFalse(expected);
    }

    // 13 - [
    @Test
    public void hasBalancedBrackets_SingleOpenBracket_ShouldReturnFalse() {
        // Arrange
        var string = "[";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertFalse(expected);
    }
    // 14 - ]
    @Test
    public void hasBalancedBrackets_SingleCloseBracket_ShouldReturnFalse() {
        // Arrange
        var string = "]";

        // Act
        var expected = hasBalancedBrackets(string);

        // Assert
        assertFalse(expected);
    }

    // 15 - pass in null : should be 0
    @Test(expected = NullPointerException.class)
    public void hasBalancedBrackets_Null_ShouldReturnFalse() {
        // Arrange

        // Act
        var expected = hasBalancedBrackets(null);

        // Assert
        assertFalse(expected);
    }
}
package com.example;
// Покрываем тестами класс Lion
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LionTest {

    private Lion lion;

    @Mock
    private Feline felineMock;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        lion = new Lion("Самец");
        lion.feline = felineMock;
    }

    @Test
    public void testDoesHaveMane() {
        boolean expected = true;
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetKittens() {
        int expected = 0;
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expected = Arrays.asList("Жираф", "Олень");
        when(felineMock.getFood("Хищник")).thenReturn(expected);

        List<String> actual = lion.getFood();

        assertEquals(expected, actual);
        verify(felineMock, times(1)).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void testLionConstructorThrowsException() throws Exception {
        lion = new Lion("Некорректное значение");
    }
}

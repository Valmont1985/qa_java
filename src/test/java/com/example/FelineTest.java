package com.example;
// Покрываем тестами класс Feline
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Mock
    private Animal animal;

    @Mock
    private Predator predator;

    @InjectMocks
    private Feline feline;
    private static final String MEAT_KIND = "Хищник";
    private static final List<String> EXPECTED_FOOD = List.of("Животные", "Птицы", "Рыба");

    @Test
    public void testGetFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittens() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void testGetKittensWithParameter() {
        int kittensCount = 3;
        int actualKittens = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actualKittens);
    }
}
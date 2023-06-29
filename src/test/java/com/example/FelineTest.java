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
    public void testConstructor() {
        assertEquals("Кошачьи", (new Feline()).getFamily());
    }
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
    public void testGetKittens2() {
        assertEquals(1, (new Feline()).getKittens());
    }
    @Test
    public void testGetKittens3() {
        assertEquals(3, (new Feline()).getKittens(3));
    }
    @Test
    public void testGetKittensWithParameter() {
        int kittensCount = 3;
        int actualKittens = feline.getKittens(kittensCount);
        assertEquals(kittensCount, actualKittens);
    }
    @Test
    public void testEatMeat() throws Exception {
        List<String> actualEatMeatResult = (new Feline()).eatMeat();
        assertEquals(3, actualEatMeatResult.size());
        assertEquals("Животные", actualEatMeatResult.get(0));
        assertEquals("Птицы", actualEatMeatResult.get(1));
        assertEquals("Рыба", actualEatMeatResult.get(2));
    }
}
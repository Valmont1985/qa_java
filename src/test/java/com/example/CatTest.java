package com.example;
// Покрываем тестами класс Cat

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;
    @InjectMocks
    private Cat cat;
    @Test
    public void testConstructor() {
        assertEquals("Мяу", (new Cat(new Feline())).getSound());
    }
    @Before
    public void setUp() {
        cat = new Cat(feline);
    }
    @Test
    public void testGetSound() {
        String sound = cat.getSound();
        Assert.assertEquals("Мяу", sound);
    }
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо1", "Мясо2", "Мясо3");
        when(feline.eatMeat()).thenReturn(expectedFood);
        List<String> actualFood = cat.getFood();
        Assert.assertEquals(expectedFood, actualFood);
        verify(feline, times(1)).eatMeat();
    }
    @Test
    public void testGetFood2() throws Exception {
        List<String> actualFood = (new Cat(new Feline())).getFood();
        assertEquals(3, actualFood.size());
        assertEquals("Животные", actualFood.get(0));
        assertEquals("Птицы", actualFood.get(1));
        assertEquals("Рыба", actualFood.get(2));
    }
}

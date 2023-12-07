package com.kodilla.patterns2.decorator.pizza;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BasicPizzaOrderTest {

    @Test
    void getCost() {

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        BigDecimal price = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(15), price);
    }

    @Test
    void getDescription() {

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza made with tomato sauce with fresh tomatoes, mozzarella cheese", description);
    }

    @Test
    void testBasicPizzaWithSalamiGetCost(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiDecorator(pizzaOrder);

        //When
        BigDecimal price = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(17), price);

    }

    @Test
    void testBasicPizzaWithSalamiGetDescription(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza made with tomato sauce with fresh tomatoes, mozzarella cheese + salami", description);
    }

    @Test
    void testBasicPizzaWithSalamiOnionOlivesHabaneroGetCost(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new HabaneroDecorator(pizzaOrder);

        //When
        BigDecimal price = pizzaOrder.getCost();

        //Then
        assertEquals(new BigDecimal(23), price);

    }

    @Test
    void testBasicPizzaWithSalamiOnionOlivesHabaneroGetDescription(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new SalamiDecorator(pizzaOrder);
        pizzaOrder = new OnionDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);
        pizzaOrder = new HabaneroDecorator(pizzaOrder);

        //When
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals("Pizza made with tomato sauce with fresh tomatoes, mozzarella cheese + salami + onion " +
                "+ olives + habanero", description);
    }
}
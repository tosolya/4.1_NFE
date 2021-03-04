package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    @Test
    public void shouldHaveAllMethodsFromSuper() {
        TShirt TShirt = new TShirt();

    }
    @Test
    public void shouldEUseEquals() {
        TShirt smartphone1 =new TShirt(2,"Sony",1000,"RRR");
        TShirt smartphone2 =new TShirt(2,"Sony",1000,"RRR");

        assertEquals(smartphone1,smartphone2);

    }

}

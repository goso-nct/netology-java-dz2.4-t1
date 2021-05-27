package ru.netology.stats;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StatsServiceTest {

    long sales[] = {8, 15, 13, 15, 17, 20, 19, 20, 7, 14, 14, 18};
    StatsService service = new StatsService();

    @Test
    void sumSales() {
        // подготавливаем данные:
        long expected = 180;

        // вызываем целевой метод:
        long actual = service.sumSales(sales);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void averageSale() {
        double expected = 15;
        double actual = service.averageSale(sales);
        assertEquals(expected, actual);
    }

    @Test
    void peekSaleMonth() {
        int expected = 8;
        int actual = service.peekSaleMonth(sales);
        assertEquals(expected, actual);
    }

    @Test
    void minimumSaleMonth() {
        int expected = 9;
        int actual = service.minimumSaleMonth(sales);
        assertEquals(expected, actual);
    }

    @Test
    void belowAverageMonths() {
        int expected = 5;
        int actual = service.belowAverageMonths(sales);
        assertEquals(expected, actual);
    }

    @Test
    void aboveAverageMonths() {
        int expected = 5;
        int actual = service.aboveAverageMonths(sales);
        assertEquals(expected, actual);
    }
}
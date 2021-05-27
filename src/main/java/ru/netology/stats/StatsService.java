package ru.netology.stats;

import java.util.Arrays;

public class StatsService {
    /*
    Вам поручили написать небольшой сервис (программисты все заняты),
    который умеет по предоставленному ему массиву месячных продаж рассчитывать:

    Сумму всех продаж
    Среднюю сумму продаж в месяц
    Номер месяца, в котором был пик продаж (осуществлены продажи на максимальную сумму)*
    Номер месяца, в котором был минимум продаж (осуществлены продажи на минимальную сумму)*
    Кол-во месяцев, в которых продажи были ниже среднего (см. п.2)
    Кол-во месяцев, в которых продажи были выше среднего (см. п.2)
    */

    public long sumSales(long[] sales) {
        return Arrays.stream(sales).sum();
    }

    public double averageSale(long[] sales) {
        return Arrays.stream(sales).average().orElse(0.0);
    }

    public int peekSaleMonth(long[] sales){
        long sale = sales[0];
        int month_number = 0;
        for (int i = 1; i < sales.length; i++) {
            if (sales[i] >= sale) {
                month_number = i;
                sale = sales[i];
            }
        }
        return month_number + 1;
    }

    public int minimumSaleMonth(long[] sales) {
        long sale = sales[0];
        int month_number = 0;
        for (int i = 1; i < sales.length; i++) {
            if (sales[i] <= sale) {
                month_number = i;
                sale = sales[i];
            }
        }
        return month_number + 1;
    }

    public int belowAverageMonths(long[] sales) {
        int month_numbers = 0;
        double average_sale = averageSale(sales);
        for (long sale : sales) {
            if (sale < average_sale) month_numbers++;
        }
        return month_numbers;
    }

    public int aboveAverageMonths(long[] sales) {
        int month_numbers = 0;
        double average_sale = averageSale(sales);
        for (long sale : sales) {
            if (sale > average_sale) month_numbers++;
        }
        return month_numbers;
    }

}

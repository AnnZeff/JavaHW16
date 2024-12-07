package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class AviaSoulsTest {

    @Test
    public void shouldSortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 400, 6, 7);
        Ticket ticket3 = new Ticket("MSK", "SPB", 100, 10, 13);
        Ticket ticket4 = new Ticket("SPB", "UFA", 650, 8, 14);
        Ticket ticket5 = new Ticket("MSK", "SPB", 250, 8, 9);
        Ticket ticket6 = new Ticket("KAZ", "MSK", 400, 6, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 200, 3, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket3, ticket1, ticket7, ticket5, ticket2 };
        Ticket[] actual = manager.search("MSK", "SPB");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 400, 6, 7);
        Ticket ticket3 = new Ticket("MSK", "SPB", 100, 10, 13);
        Ticket ticket4 = new Ticket("SPB", "UFA", 650, 8, 14);
        Ticket ticket5 = new Ticket("MSK", "SPB", 250, 8, 9);
        Ticket ticket6 = new Ticket("KAZ", "MSK", 400, 6, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 200, 3, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("STAV", "UFA");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 400, 6, 7);
        Ticket ticket3 = new Ticket("MSK", "SPB", 100, 10, 13);
        Ticket ticket4 = new Ticket("SPB", "UFA", 650, 8, 14);
        Ticket ticket5 = new Ticket("MSK", "SPB", 250, 8, 9);
        Ticket ticket6 = new Ticket("KAZ", "MSK", 400, 6, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 200, 3, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("SPB", "UFA");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortFewTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 12, 14);//2
        Ticket ticket2 = new Ticket("MSK", "SPB", 400, 6, 7);;//1
        Ticket ticket3 = new Ticket("MSK", "SPB", 100, 10, 13);//3
        Ticket ticket4 = new Ticket("SPB", "UFA", 650, 8, 14);//6
        Ticket ticket5 = new Ticket("MSK", "SPB", 250, 8, 9);//1
        Ticket ticket6 = new Ticket("KAZ", "MSK", 400, 6, 8);//2
        Ticket ticket7 = new Ticket("MSK", "SPB", 200, 3, 4);//1

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = { ticket2, ticket5, ticket7, ticket1, ticket3 };
        Ticket[] actual = manager.search("MSK", "SPB", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 400, 6, 7);;
        Ticket ticket3 = new Ticket("MSK", "SPB", 100, 10, 13);
        Ticket ticket4 = new Ticket("SPB", "UFA", 650, 8, 14);
        Ticket ticket5 = new Ticket("MSK", "SPB", 250, 8, 9);
        Ticket ticket6 = new Ticket("KAZ", "MSK", 400, 6, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 200, 3, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        Comparator <Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("STAV", "UFA", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortOneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 150, 12, 14);
        Ticket ticket2 = new Ticket("MSK", "SPB", 400, 6, 8);
        ;
        Ticket ticket3 = new Ticket("MSK", "SPB", 100, 10, 13);
        Ticket ticket4 = new Ticket("SPB", "UFA", 650, 8, 14);
        Ticket ticket5 = new Ticket("MSK", "SPB", 250, 8, 9);
        Ticket ticket6 = new Ticket("KAZ", "MSK", 400, 6, 8);
        Ticket ticket7 = new Ticket("MSK", "SPB", 200, 3, 4);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("SPB", "UFA", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }
}
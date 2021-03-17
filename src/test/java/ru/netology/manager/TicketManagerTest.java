package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.InformationTicket;
import ru.netology.repository.TicketsDataStorageRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketsDataStorageRepository repository = new TicketsDataStorageRepository();
    private InformationTicket ticketBusiness = new InformationTicket(1, 5250, "VKO", "YOW", 231000);
    private InformationTicket ticketComfort = new InformationTicket(22, 7320, "VKO", "YOW", 230000);
    private InformationTicket ticketEconomy = new InformationTicket(33, 4720, "VKO", "YOW", 250000);
    private InformationTicket ticketVIP = new InformationTicket(44, 10321, "VKO", "YOW", 220000);
    private InformationTicket ticketBusiness2 = new InformationTicket(55, 5777, "VKO", "YOW", 231000);
    private InformationTicket ticketComfortTwo = new InformationTicket(77, 7320, "VKO", "YOW", 230000);

    @Test
    void searchByAndSortAllTickets() {

        repository.save(ticketBusiness);
        repository.save(ticketComfort);
        repository.save(ticketEconomy);
        repository.save(ticketVIP);
        repository.save(ticketBusiness2);
        repository.save(ticketComfortTwo);

        TicketManager manager = new TicketManager(repository);
        InformationTicket[] actual = manager.searchBy("VKO", "YOW");
        InformationTicket[] expected = new InformationTicket[]{ticketEconomy, ticketBusiness, ticketBusiness2, ticketComfort, ticketComfortTwo, ticketVIP};

        assertArrayEquals(actual, expected);

    }

    @Test
    void searchByAndSortAllTickets1() {

        repository.save(ticketEconomy);
        repository.save(ticketVIP);


        TicketManager manager = new TicketManager(repository);
        InformationTicket[] actual = manager.searchBy("VKO", "YOW");
        InformationTicket[] expected = new InformationTicket[]{ticketEconomy, ticketVIP};

        assertArrayEquals(actual, expected);


    }

    @Test
    void searchByAndSortAllTickets2() {

        repository.save(ticketBusiness);
        repository.save(ticketBusiness2);

        TicketManager manager = new TicketManager(repository);
        InformationTicket[] actual = manager.searchBy("VKO", "YOW");
        InformationTicket[] expected = new InformationTicket[]{ticketBusiness, ticketBusiness2};

        assertArrayEquals(actual, expected);

    }

    @Test
    void searchByAndSortAllTickets3() {

        repository.save(ticketComfortTwo);
        repository.save(ticketComfort);



        TicketManager manager = new TicketManager(repository);
        InformationTicket[] actual = manager.searchBy("VKO", "YOW");
        InformationTicket[] expected = new InformationTicket[]{ ticketComfortTwo, ticketComfort};

        assertArrayEquals(actual, expected);
    }
}
package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.InformationTicket;
import ru.netology.repository.TicketsDataStorageRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketsDataStorageRepository repository = new TicketsDataStorageRepository();
    private InformationTicket ticketBusinessD = new InformationTicket(1, 5250, "DME", "YOW", 231000);
    private InformationTicket ticketComfortV = new InformationTicket(22, 7320, "VKO", "YOW", 230000);
    private InformationTicket ticketEconomyD = new InformationTicket(33, 4720, "DME", "YOW", 250000);
    private InformationTicket ticketVIPS = new InformationTicket(44, 10321, "SVO", "YOW", 220000);
    private InformationTicket ticketEconomyV = new InformationTicket(55, 5777, "VKO", "YOW", 231000);
    private InformationTicket ticketComfortTwoV = new InformationTicket(77, 7900, "VKO", "YOW", 240000);
    private InformationTicket ticketEconomyTwoD = new InformationTicket(88, 4900, "DME", "YOW", 260000);
    private InformationTicket ticketComfortS = new InformationTicket(99, 9800, "SVO", "YOW", 230000);
    private InformationTicket ticketBusinessV = new InformationTicket(111, 7000, "VKO", "YOW", 230500);
    private InformationTicket ticketVIPV = new InformationTicket(222, 15720, "VKO", "YOW", 220000);

    @Test
    void searchByAndSortAllTickets() {

        repository.save(ticketBusinessD);
        repository.save(ticketComfortV);
        repository.save(ticketEconomyD);
        repository.save(ticketVIPS);
        repository.save(ticketEconomyV);
        repository.save(ticketComfortTwoV);
        repository.save(ticketEconomyTwoD);
        repository.save(ticketComfortS);
        repository.save(ticketBusinessV);
        repository.save(ticketVIPV);


        TicketManager manager = new TicketManager(repository);
        InformationTicket[] actual = manager.searchBy("VKO", "YOW");
        InformationTicket[] expected = new InformationTicket[]{ticketEconomyV, ticketBusinessV, ticketComfortV, ticketComfortTwoV,ticketVIPV};

        assertArrayEquals(actual, expected);

    }

    @Test
    void searchByAndSortAllTickets1() {

        repository.save(ticketBusinessD);
        repository.save(ticketComfortV);
        repository.save(ticketEconomyD);
        repository.save(ticketVIPS);
        repository.save(ticketEconomyV);
        repository.save(ticketComfortTwoV);
        repository.save(ticketEconomyTwoD);
        repository.save(ticketComfortS);
        repository.save(ticketBusinessV);
        repository.save(ticketVIPV);


        TicketManager manager = new TicketManager(repository);
        InformationTicket[] actual = manager.searchBy("DME", "YOW");
        InformationTicket[] expected = new InformationTicket[]{ticketEconomyD, ticketEconomyTwoD, ticketBusinessD};

        assertArrayEquals(actual, expected);


    }

    @Test
    void searchByAndSortAllTickets2() {

        repository.save(ticketBusinessD);
        repository.save(ticketComfortV);
        repository.save(ticketEconomyD);
        repository.save(ticketVIPS);
        repository.save(ticketEconomyV);
        repository.save(ticketComfortTwoV);
        repository.save(ticketEconomyTwoD);
        repository.save(ticketComfortS);
        repository.save(ticketBusinessV);
        repository.save(ticketVIPV);

        TicketManager manager = new TicketManager(repository);
        InformationTicket[] actual = manager.searchBy("SVO", "YOW");
        InformationTicket[] expected = new InformationTicket[]{ticketComfortS, ticketVIPS};

        assertArrayEquals(actual, expected);

    }


}

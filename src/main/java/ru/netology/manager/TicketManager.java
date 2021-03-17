package ru.netology.manager;

import ru.netology.domain.InformationTicket;
import ru.netology.repository.TicketsDataStorageRepository;

import java.util.Arrays;
import java.util.Objects;

public class TicketManager {
    private TicketsDataStorageRepository repository;

    public TicketManager(TicketsDataStorageRepository repository) {
        this.repository = repository;
    }
    public InformationTicket[] searchBy(String from, String to) {
        InformationTicket[] result = new InformationTicket[0];
        for (InformationTicket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                InformationTicket[] tmp = new InformationTicket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
    public boolean matches(InformationTicket ticket, String from, String to) {
        if (ticket.getAirportDepartures().equalsIgnoreCase(from) & ticket.getAirportArrivalTime().equalsIgnoreCase(to)) {
            return true;
        }
        return false;


    }
}

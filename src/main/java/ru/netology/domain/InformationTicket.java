package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationTicket implements Comparable<InformationTicket>{
    private int id;
    private int price;
    private String airportDepartures;
    private String airportArrivalTime;
    private int TravelTime;


    @Override
    public int compareTo(InformationTicket informationTicket) {
        return price - informationTicket.price;
    }
}





package ru.netology.repository;

import ru.netology.domain.InformationTicket;

public class TicketsDataStorageRepository {
private InformationTicket[] items = new InformationTicket[0];
    public void save(InformationTicket item) {
        int length = items.length + 1;
        InformationTicket[] tmp = new InformationTicket[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public InformationTicket[] findAll() {
        return items;
    }

    public InformationTicket findById(int id) {
        for (InformationTicket item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }


    public void removeById(int id) {

            int length = items.length - 1;
            InformationTicket[] tmp = new InformationTicket[length];
            int index = 0;
            for (InformationTicket item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }



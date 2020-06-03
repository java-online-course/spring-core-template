package com.epam.edu.spring.core.template.repository;

import com.epam.edu.spring.core.template.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Random;

/**
 * Репозиторий, основанный на классе LinkedList.
 * initialSequence должен случайно генерироваться из диапазона от 1 до 100
 */
@Component
public class LinkedListItemRepository extends AbstractRepository<Item> implements ItemRepository {

    private LinkedList<Item> listItem = new LinkedList<>();

    @Override
    public Item getById(long id) {
        for (Item item : listItem) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public boolean createItem(Item item) {
        for (Item itemInList : listItem) {
            if (itemInList.equals(item)) {
                return false;
            }
        }
        listItem.add(item);
        return true;
    }

    void setInitialSequence(int val) {
        this.initialSequence = new Random().nextInt(1) + 100;
    }

    void setHolder() {
        //TODO
    }

    public LinkedList<Item> getListItem() {
        return listItem;
    }

    public void setListItem(LinkedList<Item> listItem) {
        this.listItem = listItem;
    }
}

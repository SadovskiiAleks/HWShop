package org.example.shop.delivery;

import org.example.userInterface.UnitOfBasket;

import java.util.List;

public class Supply {

    private int trackCode = 0;
    private List<UnitOfBasket> listOfSupply;
    private String userName;
    private String addressOfPIO;

    public Supply (List<UnitOfBasket> listOfBasket, String userName, String addressOfPIO) {
        listOfSupply = listOfBasket;
        trackCode++;
        this.userName = userName;
        this.addressOfPIO = addressOfPIO;
    }

    public int showTrackCode() {
       return trackCode;
    }

    public String getUserName() {
        return userName;
    }

    public String getAddressOfPIO() {
        return addressOfPIO;
    }

    public List<UnitOfBasket> showTheSupply() {
        return listOfSupply;
    }
}

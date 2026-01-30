package org.LLD.HotelBooking.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.LLD.HotelBooking.Enum.RoomStatus;
import org.LLD.HotelBooking.Enum.RoomType;

@Data
public class Room {

    private String id;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private double basePrice;

    public Room(String id, RoomType roomType, double basePrice) {
        this.id = id;
        this.roomType = roomType;
        this.basePrice = basePrice;
        this.roomStatus = RoomStatus.AVAILABLE;
    }

}

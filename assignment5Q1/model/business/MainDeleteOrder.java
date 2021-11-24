package model.business;
import java.time.LocalDate;
import java.util.List;

import model.dataccess.OrderDataAccess;
import model.entities.Order;

public class MainDeleteOrder {

	public static void main(String[] args) {
		
		OrderDataAccess orderDa = new OrderDataAccess();
        List<Order> orders = orderDa.getAllOrders();

        for(Order temp: orders)
        {
            orderDa.deleteOrder(temp.getId());
        }

        List<Order> orders_empty = orderDa.getAllOrders();

        if(orders_empty.isEmpty())
        {
            System.out.println("Empty");
        }

        for(Order temp: orders_empty)
        {
            // Should be empty
            System.out.println(temp.getId());
        }
	}
}

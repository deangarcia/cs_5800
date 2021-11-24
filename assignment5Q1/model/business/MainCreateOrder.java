package model.business;
import java.time.LocalDate;
import java.util.List;

import model.dataccess.ProductDataAccess;
import model.dataccess.OrderDataAccess;
import model.dataccess.OrderDetailDataAccess;
import model.entities.Product;
import model.entities.Order;
import model.entities.OrderDetail;
import model.entities.OrderDetailId;

public class MainCreateOrder {

	public static void main(String[] args) {
		
		ProductDataAccess productDa = new ProductDataAccess();
		Product activity_basketball = new Product("Basketball");
		Product activity_football = new Product("Football");
		Product activity_soccer = new Product("Soccer");
		productDa.saveProduct(activity_soccer);
		productDa.saveProduct(activity_football);
		productDa.saveProduct(activity_basketball);

		OrderDataAccess orderDa = new OrderDataAccess();
		
		LocalDate order_date_1 = LocalDate.of(2021, 1, 15);
		Order order1 = new Order(order_date_1, "George Lopez");
		orderDa.saveOrder(order1);
		
		LocalDate order_date_2 = LocalDate.of(2021, 1, 16);
		Order order2 = new Order(order_date_2, "Lemony Snicket");
		orderDa.saveOrder(order2);
		
		
		OrderDetailDataAccess order_detailDa = new OrderDetailDataAccess();
		OrderDetailId order_detail_1_pk = new OrderDetailId(order1, activity_basketball);
		OrderDetail order_detail_1 = new OrderDetail(order_detail_1_pk);
		order_detailDa.saveOrderDetail(order_detail_1);
		
		OrderDetailId order_detail_2_pk = new OrderDetailId(order1, activity_soccer);
		OrderDetail order_detail_2 = new OrderDetail(order_detail_2_pk);
		order_detailDa.saveOrderDetail(order_detail_2);

		OrderDetailId order_detail_3_pk = new OrderDetailId(order2, activity_football);
		OrderDetail order_detail_3 = new OrderDetail(order_detail_3_pk);
		order_detailDa.saveOrderDetail(order_detail_3);

        List<OrderDetail> orders = order_detailDa.getAllOrderDetails();

        for(OrderDetail temp: orders)
        {
            System.out.println(temp.getOrder().getId());
            System.out.println(temp.getOrder().getCustomerName());
            System.out.println(temp.getProduct().getName());
        }
		
	}
}

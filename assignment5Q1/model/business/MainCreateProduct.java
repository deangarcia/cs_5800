package model.business;

import java.util.List;

import model.dataccess.ProductDataAccess;
import model.entities.Product;

public class MainCreateProduct {

	public static void main(String[] args) 
    {
		ProductDataAccess productDa = new ProductDataAccess();
		Product activity_basketball = new Product("Basketball");
		Product activity_football = new Product("Football");
		Product activity_soccer = new Product("Soccer");
		productDa.saveProduct(activity_soccer);
		productDa.saveProduct(activity_football);
		productDa.saveProduct(activity_basketball);

		List<Product> products = productDa.getAllProducts();

        for(Product temp: products)
        {
            System.out.println(temp.getName());
        }
	}
}

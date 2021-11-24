package model.business;

import java.util.List;

import model.dataccess.ProductDataAccess;
import model.entities.Product;

public class MainDeleteProduct {

	public static void main(String[] args) 
    {
		ProductDataAccess productDa = new ProductDataAccess();

        List<Product> products = productDa.getAllProducts();

        for(Product temp: products)
        {
            productDa.deleteProduct(temp.getId());
        }

        List<Product> products_empty = productDa.getAllProducts();

        if(products_empty.isEmpty())
        {
            System.out.println("Elements Deleted");
        }

        for(Product temp: products_empty)
        {
            // Should be empty wont print anything
            System.out.println(temp.getName());
        }
	}
}

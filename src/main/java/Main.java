import model.beans.Cart;
import model.beans.Category;
import model.beans.Product;
import model.database.CartOperation;
import model.database.ProductOperation;
import model2.doa.CartDao;
import model2.doa.CategoryDao;
import model2.entity.CartEntity;
import model2.entity.CategoryEntity;
import model2.entity.UserEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Main {

    static List<String> nullList;

    public static void main(String[] args) {

        ProductOperation productOperation = new ProductOperation();
      Product product = new Product(10 , "eman" , 20 , 20 , 20.0 , "ddd" , "clothes");
//


        productOperation.editProduct(product);

//     Product p =  productOperation.getProductInfo(636);
//        System.out.println(p.getName());


//        try {
//            for(Product product : productOperation.getCategoryProducts("Clothes" ,5))
//            {
//                System.out.println(product.getName());
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

    }
}

package controller.product;

import controller.user.LoginController;
import model.beans.Cart;
import model.beans.Product;
import model.beans.User;
import model.database.CartOperation;
import model.database.ProductOperation;
import model.interfaces.CartOperationInterface;
import model.interfaces.ProductOperationInterface;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Vector;

public class CartController {


    public static final String CART_PRODUCT_LIST ="cartProductList";
    public static final String CART_ID = "cartID";

    public static final int OUT_OF_STOCK = 0;
    public static final int OPERATION_FAILED = -1;
    public static final int DONE = 1;

    public static final int NO_CART_FOUND = -1;

    public static final String productRequest = "productRequestSku";
    private CartOperationInterface cartOperation;
    private ProductController productController;

    public CartController()
    {
        cartOperation = new CartOperation();
        productController = new ProductController();
    }


    public int addToCart(HttpSession userSession , int productsku) {

        Vector<Product> productVector ;
        int result = OPERATION_FAILED;
        Product product = new Product();
        if(userSession.getAttribute(CART_PRODUCT_LIST) == null)
        {
            userSession.setAttribute(CART_PRODUCT_LIST , new Vector<Product>());
        }
        productVector = (Vector<Product>) userSession.getAttribute(CART_PRODUCT_LIST);


        for (Product products : productVector)
        {
            System.out.println(products.getSku());
            System.out.println(productsku);
            System.out.println("==----------========");

            if (products.getSku() == productsku) {
                if(productController.isProductAvailable(productsku, products.getQuantiity() + 1))
                {
                    products.setQuantiity(products.getQuantiity() + 1);
                    result =  DONE;
                    break;
                }
                else
                {
                    result =  OUT_OF_STOCK;
                    break;
                }
            }
        }

        if (productController.isProductAvailable(productsku, 1) && result == OPERATION_FAILED)
        {
            product = productController.getProduct(productsku);
            product.setQuantiity(1);
            productVector.add(product);
            result = DONE;
        }


        if (userSession.getAttribute(LoginController.USER_DATA) != null) {
            User user = (User) userSession.getAttribute(LoginController.USER_DATA);
            int cartID = hasCart(user.getEmail());
            if (cartID == -1)
                return OPERATION_FAILED;
            else {
                refreshCartDB(cartID, productVector);
            }
        }
        return result;
    }

    public int hasCart(String email) {
        int result = cartOperation.getUserCartID(email);
        if(result == -1)
        {
            result =  createUserCart(email);
        }
        return result;
    }

    private int createUserCart(String email)
    {
        return cartOperation.createUserCart(email);
    }

    public void refreshCartDB(int cartID, Vector<Product> products)  {
        for(Product product : products) {
            if (cartOperation.productInCart(cartID, product.getProductID())) {
                cartOperation.updateProductCartQuantity(cartID, product.getProductID(), product.getQuantiity());
            }
            else
            {
                cartOperation.addProductToCart(cartID , product.getProductID() , product.getQuantiity());
            }
        }
    }

    public Cart refreshLoggedUserCart(String email) {

         return cartOperation.getUserUnpaidCart(email);

    }

    public boolean removeFromCart(String email  , int productID)
    {
        int cartID = hasCart(email);
        return cartOperation.removeProductFromCart(cartID , productID);
    }

    public boolean finalizeCart(int cartID)
    {
        return cartOperation.finalizeCart(cartID);
    }


}

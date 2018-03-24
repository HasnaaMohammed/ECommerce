package model.database;

import model.beans.Cart;
import model.beans.Product;
import model2.adapter.EntityAdapter;
import model2.doa.*;
import model2.entity.CartEntity;
import model2.entity.CartProductEntity;
import model2.entity.ProductEntity;
import model2.entity.UserEntity;
import model2.interfaces.CartOperationInterface;

import java.sql.ResultSet;
import java.util.List;
import java.util.Vector;

public class CartOperation implements CartOperationInterface {


    private DatabaseHandler databaseHandler;
    private Vector<Product> productVector;
    private String query;
    private ResultSet resultSet;


    private CartDao cartDao = CartDao.getInstance();
    private CartProductDao cartProductDao = CartProductDao.getInstance();
    private UserDao userDao = UserDao.getInstance();
    private ProductOperation productOperation = new ProductOperation();

    public CartOperation() {
        databaseHandler = DatabaseHandler.getInstance();
    }

    //Converted
    @Override
    public CartEntity getCartByID(int id) {
        CartEntity cartEntity = cartDao.getEntityByID(id);
        if(cartEntity != null)
            return cartEntity;
        else
            return null;
    }

    //Converted
    @Override
    public Cart getUserUnpaidCart(String email) {


        int userCartID = getUserCartID(email);
        Cart cart = new Cart();
        String cartQuery = "select c from CartEntity c where " +
                "c.id = " + userCartID;
        CartEntity cartEntity = cartDao.select(cartQuery).get(0);
        if (cartEntity != null) {
            cart = EntityAdapter.cartAdapter(cartEntity);
        }

        return cart;

    }

    //Converted
    public int getUserCartID(String email) {

        String cartQuery = "select c from CartEntity c , UserEntity u" +
                " where c.userByUserId.email = '" + email + "' and c.checkout = 0";
        List<CartEntity> list = cartDao.select(cartQuery);
        if(list != null && list.size()>0)
        {
            return list.get(0).getId();
        }
        else
            return -1;
    }

    //Converted
    @Override
    public int createUserCart(String email) {

        String userQuery = "select u from UserEntity u where u.email = '"+email+"'";
        CartEntity cartEntity = new CartEntity();
        List<UserEntity> userEntities = userDao.select(userQuery);
        if(userEntities != null && userEntities.size() > 0)
        {
            cartEntity.setUserByUserId(userEntities.get(0));
            cartEntity.setCheckout((byte)0);
            cartDao.insert(cartEntity);
            return cartEntity.getId();
        }
        else
        {
            return -1;
        }
    }

    //Converted
    @Override
    public boolean productInCart(int cartID, int productID) {
        String cartQuery = "select c from CartProductEntity c where c.productByProductId.id = " + productID + " " +
                "and c.cartByCartId.id = " + cartID;
        List<CartProductEntity> cartProductEntity = cartProductDao.select(cartQuery);
        if (cartProductEntity != null)
            return cartProductEntity.size() > 0;
        else return false;

    }

    //Converted
    @Override
    public void updateProductCartQuantity(int cartID, int productID, int quantity) {
        String cartQuery = "select c from CartProductEntity c where c.productByProductId.id = " + productID + "and c.cartByCartId.id = " + cartID;

        List<CartProductEntity> cartProductEntity = cartProductDao.select(cartQuery);
        if (cartProductEntity != null && cartProductEntity.size() > 0) {
            CartProductEntity cartProductEntity1 = cartProductEntity.get(0);
            System.out.println(cartProductEntity1.getQuantity());
            cartProductEntity1.setQuantity(cartProductEntity1.getQuantity() + quantity);
            cartProductDao.update(cartProductEntity1);
        }
    }
    //Converted
    @Override
    public void addProductToCart(int cartID, int productID, int quantity) {

        ProductEntity productEntity =  productOperation.getProductByID(productID);
        CartEntity cartEntity = getCartByID(cartID);
        if(productEntity != null && cartEntity != null){
            CartProductEntity cartProductEntity = new CartProductEntity();
            cartProductEntity.setCartByCartId(cartEntity);
            cartProductEntity.setProductByProductId(productEntity);
            cartProductEntity.setQuantity(quantity);
            cartProductDao.insert(cartProductEntity);
        }

    }

    //Converted
    @Override
    public boolean removeProductFromCart(int cartID, int productID) {
        String cartQuery = "Select c from CartProductEntity c where c.productByProductId.id = "+productID+" and c.cartByCartId = "+cartID;
        List<CartProductEntity> cartProductEntities =  cartProductDao.select(cartQuery);
        if(cartProductEntities != null && cartProductEntities.size() > 0)
        {
            CartProductEntity cartProductEntity = cartProductEntities.get(0);
            cartProductDao.delete(cartProductEntity);
            return true;
        }
        return false;
    }

    //Converted
    @Override
    public boolean finalizeCart(int cartID) {

        String cartQuery = "select c from CartEntity c where c.id = "+cartID;
        List<CartEntity> carts = cartDao.select(cartQuery);
        if(carts != null && carts.size() > 0)
        {
            CartEntity cartEntity = carts.get(0);
            cartEntity.setCheckout((byte)1);
            cartDao.update(cartEntity);
            return true;
        }
        return false;

    }

}

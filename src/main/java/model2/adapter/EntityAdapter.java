package model2.adapter;

import model.beans.*;
import model2.entity.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Vector;

public class EntityAdapter {

    public static User userAdapter(UserEntity userEntity)
    {
        User user = new User();
        user.setFullName(userEntity.getFullName());
        user.setJob(userEntity.getJob());
        user.setAddress(userEntity.getAddress());
        user.setBirthDate(userEntity.getBirthdate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
        user.setEmail(userEntity.getEmail());
        user.setRole(userEntity.getRole());
        user.setPassword(userEntity.getPassword());
        user.setCredit(userEntity.getCreditLimit());
        return user;
    }

    public static Cart cartAdapter(CartEntity cartEntity)
    {
        Cart cart = new Cart();
        cart.setCartID(cartEntity.getId());
        cart.setCartProducts(new Vector<Product>());
        for(CartProductEntity productEntity :  cartEntity.getCartProductsById())
            cart.getCartProducts().add(productAdapter(productEntity.getProductByProductId()));
        cart.setCheckOut(Boolean.parseBoolean(cartEntity.getCheckout().toString()));

        return cart;
    }

    public static Product productAdapter(ProductEntity productEntity)
    {
        Product product = new Product();
        product.setProductID(productEntity.getId());
        product.setQuantiity(productEntity.getQuantity());
        product.setProduct_img(productEntity.getProductImg());
        product.setPrice(productEntity.getPrice());
        product.setSku(productEntity.getSku());
        product.setProduct_category(productEntity.getCategoryByCategoryId().getCategoryName());
        product.setName(productEntity.getName());
        return product;

    }

    public static Order orderAdapter(OrderEntity orderEntity)
    {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setPrice(orderEntity.getTotalPrice());
        order.setUserName(orderEntity.getCartByCartId().getUserByUserId().getFullName());
        order.setTimeStamp(orderEntity.getTimestamp().toLocalDateTime().toLocalDate());
        return order;
    }

    public static Category categoryAdapter(CategoryEntity categoryEntity)
    {
        Category category = new Category();
        category.setName(categoryEntity.getCategoryName());
        category.setProducts(new Vector<Product>());
        for(ProductEntity productEntity :  categoryEntity.getProductsById())
           category.getProducts().add(productAdapter(productEntity));
        return category;
    }
}

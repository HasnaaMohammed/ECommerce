package model2.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Cart", schema = "ECommerce", catalog = "")
public class CartEntity implements Serializable {
    private Integer id;
    private Byte checkout;
    private UserEntity userByUserId;
    private Collection<CartProductEntity> cartProductsById;
    private Collection<OrderEntity> ordersById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Checkout")
    public Byte getCheckout() {
        return checkout;
    }

    public void setCheckout(Byte checkout) {
        this.checkout = checkout;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartEntity that = (CartEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(checkout, that.checkout);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, checkout);
    }

    @ManyToOne
    @JoinColumn(name = "User_id", referencedColumnName = "id", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }

    @OneToMany(mappedBy = "cartByCartId")
    public Collection<CartProductEntity> getCartProductsById() {
        return cartProductsById;
    }

    public void setCartProductsById(Collection<CartProductEntity> cartProductsById) {
        this.cartProductsById = cartProductsById;
    }

    @OneToMany(mappedBy = "cartByCartId")
    public Collection<OrderEntity> getOrdersById() {
        return ordersById;
    }

    public void setOrdersById(Collection<OrderEntity> ordersById) {
        this.ordersById = ordersById;
    }
}

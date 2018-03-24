package model.beans2;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Product", schema = "ECommerce", catalog = "")
public class ProductEntity {
    private Integer id;
    private String name;
    private Integer quantity;
    private Integer sku;
    private Integer price;
    private String productImg;
    private Collection<CartProductEntity> cartProductsById;
    private CategoryEntity categoryByCategoryId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "Sku")
    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    @Basic
    @Column(name = "Price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Basic
    @Column(name = "Product_img")
    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(sku, that.sku) &&
                Objects.equals(price, that.price) &&
                Objects.equals(productImg, that.productImg);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, quantity, sku, price, productImg);
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<CartProductEntity> getCartProductsById() {
        return cartProductsById;
    }

    public void setCartProductsById(Collection<CartProductEntity> cartProductsById) {
        this.cartProductsById = cartProductsById;
    }

    @ManyToOne
    @JoinColumn(name = "Category_id", referencedColumnName = "id", nullable = false)
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}

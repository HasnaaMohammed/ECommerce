package model.beans2;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Category", schema = "ECommerce", catalog = "")
public class CategoryEntity {
    private Integer id;
    private String categoryName;
    private Collection<ProductEntity> productsById;
    private Collection<UserCategoriesEntity> userCategoriesById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Category_name")
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, categoryName);
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<ProductEntity> getProductsById() {
        return productsById;
    }

    public void setProductsById(Collection<ProductEntity> productsById) {
        this.productsById = productsById;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<UserCategoriesEntity> getUserCategoriesById() {
        return userCategoriesById;
    }

    public void setUserCategoriesById(Collection<UserCategoriesEntity> userCategoriesById) {
        this.userCategoriesById = userCategoriesById;
    }
}

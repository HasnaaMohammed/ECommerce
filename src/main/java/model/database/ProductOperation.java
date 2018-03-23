package model.database;

import model.beans.Category;
import model.beans.Product;
import model2.adapter.EntityAdapter;
import model2.doa.CategoryDao;
import model2.doa.ProductDao;
import model2.entity.CategoryEntity;
import model2.entity.ProductEntity;
import model2.interfaces.ProductOperationInterface;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProductOperation implements ProductOperationInterface {
    private DatabaseHandler databaseHandler;
    private String query;
    private ResultSet resultSet;
    private Product product = null;


    private ProductDao productDao = ProductDao.getInstance();
    private CategoryDao categoryDao = CategoryDao.getInstance();


    public ProductOperation() {
        databaseHandler = DatabaseHandler.getInstance();

    }

    //Converted
    @Override
    public boolean addNewProduct(Product product) {

        query = "select p from ProductEntity p where p.sku ='" + product.getSku() + "'";
        List<ProductEntity> productEntityList = productDao.select(query);
        if (productEntityList != null) {
            if (productEntityList.size() > 0) {
                return false;
            } else {
                String catQuery = "select c from CategoryEntity c where c.categoryName = '" + product.getProduct_category() + "'";
                List<CategoryEntity> categoryEntities = categoryDao.select(catQuery);
                CategoryEntity categoryEntity = null;
                if (categoryEntities != null && categoryEntities.size() > 0)
                    categoryEntity = categoryEntities.get(0);
                ProductEntity productEntity = new ProductEntity();
                productEntity.setName(product.getName());
                productEntity.setPrice(product.getPrice());
                productEntity.setProductImg(product.getProduct_img());
                productEntity.setQuantity(product.getSku());
                productEntity.setSku(product.getSku());
                productEntity.setCategoryByCategoryId(categoryEntity);
                productDao.insert(productEntity);
                return true;
            }
        }

        return false;
    }

    //Converted
    @Override
    public ProductEntity getProductByID(int id) {
        ProductEntity productEntity = productDao.getProductByID(id);
        if (productEntity != null)
            return productEntity;
        else
            return null;
    }

    //Converted
    @Override
    public boolean addNewCategory(String category) {
        query = " select c from CategoryEntity c  where c.categoryName ='" + category + "'";
        List<CategoryEntity> categoryEntitieList = categoryDao.select(query);
        CategoryEntity categoryEntity = null;
        if (categoryEntitieList != null) {
            if (categoryEntitieList.size() > 0) {
                return false;
            } else {
                categoryEntity = new CategoryEntity();
                categoryEntity.setCategoryName(category);
                categoryDao.insert(categoryEntity);
                return true;

            }
        }
        return false;
    }

    //Converted
    @Override
    public Product getProductInfo(int sku) {

        query = "select p from ProductEntity p where p.sku='" + sku + "'";
        Product product = null;
        ProductEntity productEntity = productDao.select(query).get(0);
        if (productEntity != null)
            product = EntityAdapter.productAdapter(productEntity);

        return product;

    }

    //Converted
    @Override
    public Vector<Category> getAllCategoriesWithProducts() {
        Vector<Category> categories = new Vector<>();

        try {
            Vector<String> categoriesQuery = getAllCategories();
            for (String categorys : categoriesQuery) {
                Category category = new Category();
                category.setName(categorys);
                category.setProducts(getCategoryProducts(categorys));
                categories.add(category);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    //Converted
    @Override
    public synchronized Vector<String> getAllCategories() throws SQLException {
        query = "select c from CategoryEntity c";
        Vector<String> categoryNameVector = new Vector<>();

        List<CategoryEntity> categoryEntityList = categoryDao.select(query);
        if (categoryEntityList != null && categoryEntityList.size() > 0)

            for (int i = 0; i < categoryEntityList.size(); i++) {
                String categoryName = categoryEntityList.get(i).getCategoryName();
                categoryNameVector.add(categoryName);

            }

        return categoryNameVector;

    }

    //Converted
    @Override
    public Vector<Product> getCategoryProducts(String category) throws SQLException {
        Vector<Product> productsVector = new Vector<>();
        Product product = null;
        query = "select c  from  CategoryEntity c where categoryName ='" + category + "'";
        List<CategoryEntity> categoryEntityList = categoryDao.select(query);
        if (categoryEntityList != null && categoryEntityList.size() > 0) {
            CategoryEntity categoryEntity = categoryEntityList.get(0);
            for (ProductEntity productEntity : categoryEntity.getProductsById()) {
                productsVector.add(EntityAdapter.productAdapter(productEntity));
            }
        }
        return productsVector;
    }

    @Override
    public Vector<Product> getCategoryProducts(String category, int index) throws SQLException {
        Vector<Product> productsVector = new Vector<>();
        Product product = null;
        int start = index * 5;
        int end = start + 5;
//        System.out.println(start);
//        System.out.println(end);
//        String query = "select  " +
//                "                    `Product`.`Name`, \n" +
//                "                    `Product`.`Quantity`, \n" +
//                "                    `Product`.`Sku`, \n" +
//                "                    `Product`.`Price`, \n" +
//                "                    `Product`.`Product_img`, \n" +
//                "                    `Product`.`Category_id`  \n" +
//                "                 from Product , Category \n" +
//                "                 where Category.Category_name = '" + category +
//                "'                and Product.Category_id = Category.id \n" +
//                "                 and Quantity > 0 Order by Product.ID Limit " + start + " , " + end + ";";
//        resultSet = databaseHandler.select(query);
//        getproduct(category, products);
//        return products;
        query = "select c  from  CategoryEntity c  where categoryName ='" + category + "'" + "'and  Order by ProductEntity.id limit " + start + " , " + end + ";";
        List<CategoryEntity> categoryEntityList = categoryDao.select(query);
        if (categoryEntityList != null && categoryEntityList.size() > 0) {
            CategoryEntity categoryEntity = categoryEntityList.get(0);
            for (ProductEntity productEntity : categoryEntity.getProductsById()) {
                productsVector.add(EntityAdapter.productAdapter(productEntity));
            }
        }
        return productsVector;
    }

    //feha moshklaaaa eny a7ot category id 
    @Override
    public boolean editProduct(Product product) {
        query = "select p from ProductEntity p where p.sku ='" + product.getSku() + "'";
        List<ProductEntity> productEntities = productDao.select(query);
        if (productEntities != null && productEntities.size() > 0) {
            ProductEntity productEntity = productEntities.get(0);
            productEntity.setName(product.getName());
            productEntity.setSku(product.getSku());
            productEntity.setProductImg(product.getProduct_img());
            productEntity.setPrice(product.getPrice());
            productDao.update(productEntity);
            return true;

        }
        return  false;
    }

    public boolean decreaseQuantity(int productID, int quantity) {

        query = "select p from ProductEntity p where p.id =' " + productID + "'";
        List<ProductEntity> productEntities = productDao.select(query);
        if (productEntities != null && productEntities.size() > 0) {
            ProductEntity productEntity = productEntities.get(0);
            productEntity.setQuantity(productEntity.getQuantity() - quantity);
            productDao.update(productEntity);
            return  true;

        }
        return  false;
    }

    @Override
    public boolean deleteProduct(int sku) {

        query = "select p from ProductEntity p where p.sku =' " + sku + "'";
        List<ProductEntity> productEntities = productDao.select(query);
        if (productEntities != null && productEntities.size() > 0) {
            ProductEntity productEntity = productEntities.get(0);
            productEntity.setQuantity(0);
            productDao.update(productEntity);
            return  true;

        }
        return  false;


    }


}

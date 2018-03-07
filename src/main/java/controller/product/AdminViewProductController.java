/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import java.util.Vector;
import model.beans.Category;
import model.database.ProductOperation;
import model.interfaces.ProductOperationInterface;

/**
 *
 * @author Asmaa
 */
public class AdminViewProductController {
    private ProductOperationInterface productOperationInterface;
    private Vector<Category> categoryList;// = new Vector<User>();
    
    public Vector<Category> getProductList(){
        productOperationInterface=new ProductOperation();
        categoryList=productOperationInterface.getAllCategoriesWithProducts();
        return categoryList;
    }
    
}

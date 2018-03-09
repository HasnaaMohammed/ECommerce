package controller.servlets;

import controller.product.AddProductController;
import controller.product.DeleteProductController;
import controller.product.EditProductController;
import model.beans.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

@WebServlet(urlPatterns = "/DeleteProduct")
public class DeleteProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("./404.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String result="";
        System.out.println("sku in servlet "+request.getParameter("sku"));
        int sku = Integer.parseInt(request.getParameter("sku"));
        


                DeleteProductController deleteProductController = new DeleteProductController();
                boolean deleteProductResult = deleteProductController.deleteProduct(sku);
                System.out.println(deleteProductResult);
                if (deleteProductResult) {
                    result = "Product Deleted Successfully";
                } else {
                   result = "No product deleted";
                }


               // response.sendRedirect("./admin/editProduct.html?result="+result);

            }


    }




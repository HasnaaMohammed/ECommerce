package controller.servlets;

import controller.product.AddProductController;
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

@WebServlet(urlPatterns = "/AddProduct")
public class AddProductServlet extends HttpServlet {

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
        System.out.println(request.getParameterMap().keySet());
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);

        String name = request.getParameter("name");
        double price = 0;
        int quantity = 0;
        int sku = 0;
        String image = "";
        String category = "";
        String img = "";
        String result = "";


        List<FileItem> fileItems = null;
        try {
            fileItems = upload.parseRequest(request);

            Iterator<FileItem> fileItemIterator = fileItems.iterator();


            System.out.println("In Upload" + fileItems.size());
            while (fileItemIterator.hasNext()) {
                FileItem item = fileItemIterator.next();
                if (item.isFormField()) {
                    switch (item.getFieldName()) {
                        case "pName":
                            name = item.getString();
                            break;
                        case "pSku":
                            sku = Integer.parseInt(item.getString());
                            break;
                        case "pQu":
                            quantity = Integer.parseInt(item.getString());
                            break;
                        case "pPrice":
                            price = Double.parseDouble(item.getString());
                            break;
                        case "pCat":
                            category = item.getString();
                    }
                } else {

                    String partName = LocalDate.now() +""+ Math.random() + item.getName();
                    String url = request.getServletContext().getRealPath("/products") + "/" +partName;
                    File file = new File(url);
                    item.write(file);
                    img = "http://" + request.getServerName() + ":" + request.getServerPort() +
                            "/ECommerce/products/" + partName;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                Product product = new Product();
                product.setName(name);
                product.setPrice(price);
                product.setQuantiity(quantity);
                product.setProduct_category(category);
                product.setProduct_img(img);
                product.setSku(sku);


                AddProductController addProductController = new AddProductController();
                int addProductResult = addProductController.addProduct(product);
                System.out.println(addProductResult);
                if (addProductResult == AddProductController.PRODUCT_EXIST) {
                    result = "Product Already Exist";
                } else if (addProductResult == AddProductController.PRODUCT_ADDED) {
                   result = "Added Successfully";
                } else if (addProductResult == AddProductController.INVALID_NAME) {
                    result = "Invalid Product Name";
                }


                response.sendRedirect("./admin/addproduct.jsp?result="+result);

            }


    }




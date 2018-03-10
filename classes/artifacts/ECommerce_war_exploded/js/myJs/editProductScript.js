function editProductHandler() {


    console.log("edit Product");
    var name = document.getElementById("product_name");
    var quantity = document.getElementById("product_quantity");
    var price = document.getElementById("product_price");
    var image = document.getElementById("product-image");
    var category = document.getElementById("sel1");
    var sku = document.getElementById("product_sku");
    

    var postObject = {
        "name":name.value,
        "sku":sku.value,
        "quantity":quantity.value ,
        "price":price.value,
        "image":image.value,
        "category":category.value
    };
   // var registerErrorLabel = document.getElementById("registerErrorLabel");
    var editProductBtn = document.getElementById("editProductBtn");
    editProductBtn.disabled = true;
    $.post("../EditProduct" , postObject , function (data) {
    console.log(data);
        if(data === "success")
            data = "Product Updated Successfully";
        //registerErrorLabel.innerHTML = data;
        editProductBtn.disabled = false;

    });
    return false;
}
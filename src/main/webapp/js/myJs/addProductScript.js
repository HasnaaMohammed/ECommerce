function addProductHandler() {


    console.log("Add Product");
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
    var addProductBtn = document.getElementById("addProductBtn");
    addProductBtn.disabled = true;
    $.post("../AddProduct" , postObject , function (data) {
    console.log(data);
        if(data === "success")
            data = "Product Added Successfully";
        //registerErrorLabel.innerHTML = data;
        addProductBtn.disabled = false;

    });
    return false;
}
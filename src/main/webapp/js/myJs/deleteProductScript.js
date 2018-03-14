 function deleteProduct(data1){
    console.log("delete "+data1);
        
    var skuvar = data1;
    

    var postObject = {
        "sku":skuvar    
    };

    $.post("../DeleteProduct" , postObject , function (data) {
    console.log(data);
        if(data === "success")
            data = "Product deleted Successfully";
 
    });
    return false;
}
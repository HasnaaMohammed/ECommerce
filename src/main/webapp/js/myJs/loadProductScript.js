

function loadProducts()
{
    // $.post("./Products" , )



    $.ajax({
        type: 'POST',
        url:"./Products",
        success:function (data) {
            var hot = document.getElementById("hot");
            data = JSON.parse(data);
            data.forEach(param =>{

                if(param.products.length > 0)
            {
                hot.appendChild(addHeader(param.name));
                hot.appendChild(addSlider(param.products));
            }
        });
        },
        async:   true
    });
}


function addHeader(head)
{
    var mainDiv = document.createElement("div");
    mainDiv.className = "box";
    var containerDiv = document.createElement("div");
    containerDiv.className = "container";
    var colDiv = document.createElement("div");
    colDiv.className = "col-md-12";
    var catName = document.createElement("h2");
    catName.innerHTML = head;
    colDiv.appendChild(catName);
    containerDiv.appendChild(colDiv);
    mainDiv.appendChild(containerDiv);
    return mainDiv;

}


function addSlider(products) {

    var containerDiv = document.createElement("div");
    containerDiv.className = "container";
    var productSlider = document.createElement("div");
    productSlider.className = "row";
    containerDiv.appendChild(productSlider);

    products.forEach(param =>{
        productSlider.append(addProduct(param));

    });

    return containerDiv;

}

function addProduct(product) {

    var item = document.createElement("div");
    item.className = "col-md-2";

    var productdiv = document.createElement("div");
    productdiv.className = "product";
    item.appendChild(productdiv);

    var imgDiv = document.createElement("div");
    var img = document.createElement("img");
    img.src = product.product_img;
    img.className = "img-responsive"

    imgDiv.appendChild(img);
    productdiv.appendChild(imgDiv);

    var textDiv = document.createElement("div");
    textDiv.className = "text";
    productdiv.appendChild(textDiv);

    var productName = document.createElement("h3");
    productName.innerHTML = product.name;

    var productPrice = document.createElement("p");
    productPrice.className = "price";
    productPrice.innerHTML = product.price;

    var productButtonField = document.createElement("p");
    productButtonField.className = "buttons";


    var form = document.createElement("form");
    form.onsubmit = function () {
        addToCart(this);
        return false;
    };

    var productSku = document.createElement("input");
    productSku.type = "hidden";
    productSku.value = product.sku;
    productSku.name = "productRequestSku";

    var productButton = document.createElement("Button");
    productButton.className = "btn btn-primary";
    productButton.innerHTML = "Add to Cart";

    form.appendChild(productSku);
    form.appendChild(productButton);
    productButtonField.appendChild(form);

    textDiv.appendChild(productName);
    textDiv.appendChild(productPrice);
    textDiv.appendChild(productButtonField);


    return item;

}

loadProducts();
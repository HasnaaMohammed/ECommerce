function getAllCategories() {

    $.post("./allcategories" , function (data) {
        var categoryList = document.getElementById("categoryList");
        data.forEach(param => {
           var anchor = document.createElement("a");
           anchor.innerHTML = param;
           var list = document.createElement("li");
           list.appendChild(anchor);
           categoryList.appendChild(list);

        });
    });

}


getAllCategories();
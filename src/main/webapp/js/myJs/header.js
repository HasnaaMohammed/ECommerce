function getAllCategories() {

    $.post("./allcategories" , function (data) {
        var categoryList = document.getElementById("categoryLists");
        data.forEach(param => {
           var anchor = document.createElement("a");
           anchor.innerHTML = param;
           anchor.href = "./catName?category="+param;
           var list = document.createElement("li");
           list.appendChild(anchor);
           categoryList.appendChild(list);

        });
    });

}


getAllCategories();
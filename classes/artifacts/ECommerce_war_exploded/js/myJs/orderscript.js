function ordersView()
{
    var ordersViewTable = document.getElementById("ordersViewTable");

    $.ajax({
        type: 'POST',
        url:"./vieworders",
        success: function (data) {

            if (data != null && data != "") {
                data = JSON.parse(data);
                data.forEach(param => {
                    ordersViewTable.appendChild(addTableRow(param));
            });
            }
        },
        async:   false
    });

}



function addTableRow(param)
{
    var row = document.createElement("tr");
    var cellid = document.createElement("td");
    var celldate = document.createElement("td");
    var cellTotal = document.createElement("td");

    cellid.innerHTML = "#"+param.id;
    celldate.innerHTML = param.timeStamp.year+"-"+param.timeStamp.month+"-"+param.timeStamp.day;
    cellTotal.innerHTML = param.price;
    row.appendChild(cellid);
    row.appendChild(celldate);
    row.appendChild(cellTotal);

    return row;
}
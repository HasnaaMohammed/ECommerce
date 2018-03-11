<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../assets/img/favicon.ico">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Light Bootstrap Dashboard - Free Bootstrap 4 Admin Dashboard by Creative Tim</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- CSS Files -->
    <link href="../assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../assets/css/light-bootstrap-dashboard.css?v=2.0.1" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="../assets/css/demo.css" rel="stylesheet" />
</head>

<body onload="setInterval('render()', 1000)">
    <div class="wrapper">
        <div class="sidebar" data-image="../assets/img/sidebar-5.jpg">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
    <div class="sidebar-wrapper">
        <div class="logo">
            <a class="simple-text">
                Admin Panel
            </a>
        </div>
        <ul class="nav">
            <li >
                <a class="nav-link" href="./addproduct.jsp">
                    <i class="nc-icon nc-simple-add"></i>
                    <p>Add Product</p>
                </a>
            </li>
            <li >
                <a class="nav-link" href="./editproduct.html">
                    <i class="nc-icon nc-settings-tool-66"></i>
                    <p>Edit Products</p>
                </a>
            </li>
            <li>
                <a class="nav-link" href="./viewcustomers.html">
                    <i class="nc-icon nc-single-02"></i>
                    <p>View Customers</p>
                </a>
            </li>
            <li >
                <a class="nav-link" href="./adminUser.html">
                    <i class="nc-icon nc-badge"></i>
                    <p>Create Admin User</p>
                </a>
            </li>
            <li class="nav-item active">
                    <a class="nav-link" href="./setting.html">
                        <i class="nc-icon nc-settings-gear-64"></i>
                        <p>Manage</p>
                    </a>
                </li>
           </ul>
    </div>
        </div>
        <div class="main-panel">
                       <!-- Navbar -->
                       <nav class="navbar navbar-expand-lg " color-on-scroll="500">
                        <div class=" container-fluid  ">
                            <a class="navbar-brand" href="#pablo"> Manage </a>
                            <button href="" class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-bar burger-lines"></span>
                                <span class="navbar-toggler-bar burger-lines"></span>
                                <span class="navbar-toggler-bar burger-lines"></span>
                            </button>
                            <div class="collapse navbar-collapse justify-content-end" id="navigation">
                            
                                <ul class="navbar-nav ml-auto">
                                    <li class="nav-item">
                                        <a class="nav-link">
                                            <span class="no-icon">Welcome&nbsp</span><span class="no-icon">User</span>
                                        </a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" href="#pablo" >
                                            <span class="no-icon">Log out</span>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </nav>
                    <!-- End Navbar -->
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">Add New Category</h4>
                                    <b style="color: darkorange">${param.result}</b>
                                </div>
                                <form ACTION="../AddCategory"  METHOD="post">
                                <div class="card-body">
                                        <div class="row">
                                                <div class="col-md-6">
                                                    <label>Category Name</label>
                                                    <input type="text" class="form-control" name="category_name">
                                                </div>
                                                <div class="col-md-6">
                                                    <br>
                                                        <button type="submit" class="btn btn-success btn-fill">Add</button>
                                                        
                                                </div>
                                          </div>
                                 
                                </div>
                            </form>
                        </div>
                       
                    </div>
                </div>
            </div>
         
                    <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header">
                                    <h4 class="card-title">New Orders</h4>
                                </div>
                                <div class="card-body">
                                        
                                   <div class="row">
                                    <div class="card-body  table-responsive ">
                                        <table class="table table-hover table-striped ">
                                            <thead>
                                                <th>Order Number</th>
                                                <th>Date</th>
                                                <th>User</th>
                                                <th>Total Price</th>
                                            </thead>
                                            <tbody id="orderTable">
                                            <tr>
                                                <td>Loading...</td>
                                                <td>Loading...</td>
                                                <td>Loading...</td>
                                                <td class="td-actions text-right">Loading...</td>
                                            </tr>
                                            </tbody>
                                        </table>
                                    </div>
                                   </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
         
        </div>
    </div>
   
</body>
<!--   Core JS Files   -->
<script src="../assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="../assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="../assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<!--  Plugin for Switches, full documentation here: http://www.jque.re/plugins/version3/bootstrap.switch/ -->
<script src="../assets/js/plugins/bootstrap-switch.js"></script>
<!--  Google Maps Plugin    -->
<script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
<!--  Chartist Plugin  -->
<script src="../assets/js/plugins/chartist.min.js"></script>
<!--  Notifications Plugin    -->
<script src="../assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Light Bootstrap Dashboard: scripts for the example pages etc -->
<script src="../assets/js/light-bootstrap-dashboard.js?v=2.0.1" type="text/javascript"></script>
<!-- Light Bootstrap Dashboard DEMO methods, don't include it in your project! -->
<script src="../assets/js/demo.js"></script>
<script>
    function render(){
        $.ajax({url: '../ViewAllOrdersServlet',
                type:'GET',
                contentType:'application/json',
                dataType:'json', 
                success: function (data) {
                    orders=data;
                    $("#orderTable tr").remove();
                    for(i=0;i<orders.length;i++){
                        $("#orderTable").append('<tr><td>'+orders[i].id+'</td><td>'+orders[i].timeStamp.day+"/"+orders[i].timeStamp.month+"/"+orders[i].timeStamp.year+'</td><td>'+orders[i].userName+'</td><td>'+orders[i].price+'</td></tr>');
                    }
                }
        
              });
     }
</script>
</html>

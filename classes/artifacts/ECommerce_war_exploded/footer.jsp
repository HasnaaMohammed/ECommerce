<%--
  Created by IntelliJ IDEA.
  User: 885
  Date: 3/9/2018
  Time: 11:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body >
<div id="footer" data-animate="fadeInUp">

    <div class="container">

        <div class="row" style="margin-left: 40%;">

            <div class="col-md-3 col-sm-6">

                <h4>User section</h4>

                <ul>
                    <li>
                        <a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
                    </li>
                    <li>
                        <a href="register.jsp">Register</a>
                    </li>
                </ul>

                <hr class="hidden-md hidden-lg hidden-sm">

            </div>
            <!-- /.col-md-3 -->

            <div class="col-md-3 col-sm-6">

                <h4>Categories</h4>



                <ul id="footerCatList">

                </ul>

                <hr class="hidden-md hidden-lg">

            </div>
            <!-- /.col-md-3 -->



        </div>
        <!-- /.col-md-3 -->

    </div>
    <!-- /.row -->
    <script>
        function getFooterCategory() {
            var xhttp = new XMLHttpRequest();
            $.post("./allcat", function (data) {

                // xhttp.open("POST", "./allcat", true);

                var list = JSON.parse(data);
                for (var i = 0; i < list.length; i++) {
                    $('#footerCatList').append('<li><a href="./catName?category='+list[i]+'">'+list[i]+ '</a></li>');
                }

            });

        }

        getFooterCategory();
    </script>
</div>
</body>
</html>

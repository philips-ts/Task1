<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <style>
        table {
            border-collapse:collapse;
            width:100%;
            max-width:700px;
            min-width:400px;
            text-align:center;
        }
        caption {
            caption-side:bottom;
            font-weight:bold;
            font-style:italic;
            margin:4px;
        }
        table,th, td {
            border: 1px solid gray;
        }
        th, td {
            height: 24px;
            padding:4px;
            vertical-align:middle;
        }
        th {
            background-image:url(table-shaded.png);
        }
        .rowtitle {
            font-weight:bold;
        }

        /*#header{*/
        /*    background:oldlace;*/
        /*    width:990px;*/
        /*    height:200px;*/
        /*    background: blue;*/
        /*    position:absolute;*/
        /*}*/

        /*#menu{*/
        /*    background:oldlace;*/
        /*    width:190px;*/
        /*    height:600px;*/
        /*    background: tomato;*/
        /*}*/
        /*#content{*/
        /*    background:oldlace;*/
        /*    width:800px;*/
        /*    height:600px;*/
        /*    position:absolute;*/
        /*    left:190px;*/
        /*    top:0px;*/
        /*}*/


        body {
           margin: 0;
           font-family: Arial, Helvetica, sans-serif;
        }

        .topnav {
            overflow: hidden;
            background-color: #333;
        }

        .topnav a {
            float: left;
            color: #f2f2f2;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .topnav a:hover {
            background-color: #ddd;
            color: black;
        }

        .topnav a.active {
            background-color: #04AA6D;
            color: white;
        }
    </style>

</head>



<body>



<div class="topnav">
    <a class="active" href="?action=catalog">Catalog</a>
    <a href="?action=bucket">Bucket</a>
    <a href="?action=logout">Logout</a>
</div>




<div style="padding-left:30px">

    <c:choose>
        <c:when test="${param.action == 'catalog'}">

            <br><br>
            <form action="?action=catalog" method="post">
                <select name="product_type" >
                    <option> ---- Select type of product</option>
                    <option>Food</option>
                    <option>NotFood</option>
                </select>
                <input type="submit" value="Select"/>
            </form>

            <c:choose>
                <c:when test="${param.product_type == 'Food'}">
                    <br>
                    <br>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Date of manufacture</th>
                            <th>Max temperature of storage</th>
                            <th>Shelf life / months</th>
                            <th>Price</th>
                            <th>Operations</th>
                        </tr>

                        <c:forEach var="foodItem" items="${allFood}">

                            <c:url var="addToBucketButton" value="/addToBucket">
                                <c:param name="productId" value="${foodItem.id}"/>
                            </c:url>


                            <tr>
                                <td>${foodItem.name}</td>
                                <td>${foodItem.dateOfManufacture}</td>
                                <td>${foodItem.maxStorageTemperature}</td>
                                <td>${foodItem.shelfLifeMonths}</td>
                                <td>${foodItem.price}</td>
                                <td>
                                    <input type="button" value="Add"
                                    onclick="window.location.href='${addToBucketButton}'">
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                </c:when>

                <c:when test="${param.product_type == 'NotFood'}">
                    <br><br>
                    <table>
                        <tr>
                            <th>Name</th>
                            <th>Date of manufacture</th>
                            <th>Is Breakable</th>
                            <th>Price</th>
                        </tr>

                        <c:forEach var="notFoodItem" items="${allNotFood}">
                            <tr>
                                <td>${notFoodItem.name}</td>
                                <td>${notFoodItem.dateOfManufacture}</td>
                                <td>${notFoodItem.breakable}</td>
                                <td>${notFoodItem.price}</td>
                            </tr>
                        </c:forEach>

                    </table>
                </c:when>

            </c:choose>


        </c:when>

        <c:when test="${param.action == 'bucket'}">

            <br><br>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>

                <c:forEach var="orderItem" items="${orderItems}">
                    <tr>
                        <td>${orderItem.product.name}</td>
                        <td>${orderItem.product.price}</td>
                        <td>${orderItem.quantity}</td>
                    </tr>
                </c:forEach>

            </table>

        </c:when>

        <c:when test="${param.action == 'logout'}">
            Logout succ!

        </c:when>
    </c:choose>

</div>

</body>

</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/navbar-static/">
<!-- Bootstrap core CSS -->
<link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/a27fadce28.js" crossorigin="anonymous"></script>

</head>
<body>
    <div class="bg-dark text-secondary px-4 py-5 text-center">
        <h2>User Coupons</h2>
        <hr/>

        <br/>
        <br/>
        <div class="container py-4">
        <div class="d-flex justify-content-center">

            <table class="table table-striped table-hover table-bordered">
                <thead>
                    <tr class="table-dark">
                        <th scope="col">COUPON ID</th>
                        <th scope="col">VALUE</th>
                        <th scope="col">REDEEMS</5th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${allCoupons}" var="coupon">
                        <tr class="table-primary">
                            <td scope="row">${coupon.id}</td>
                            <td scope="row">${coupon.value}</td>
                            <td scope="row">${coupon.availableRedeems}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
        </div>
        <br/>
        <br/>
        <br/>
        <br/>
    </div>

</body>
</html>
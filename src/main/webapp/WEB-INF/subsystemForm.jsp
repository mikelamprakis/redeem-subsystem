<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <link rel="stylesheet" href="css/pure-min.css">
    <link rel="stylesheet" href="css/custom.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <link rel="canonical" href="https://getbootstrap.com/docs/5.0/examples/navbar-static/">
    <!-- Bootstrap core CSS -->
    <link href="../assets/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="../assets/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://kit.fontawesome.com/a27fadce28.js" crossorigin="anonymous"></script>
</head>
<body>
    <div class="bg-dark text-secondary px-4 py-5">

	<div class="container">
    <div class="col-md-10 mx-auto col-lg-5">
    <h1>Redeem Sub-system</h1>
    <hr/>
	<sf:form action="submit-query" method="post" modelAttribute="availability" class="p-4 p-md-5 border rounded-3 bg-light">
		<div class="card">
			
			<div class="card-body">
                <h2>Please insert your USER and COUPON ID</h2>
                <hr/>
                <br>
                <div><h3>${message}</h3></div>
                <div><h4> ${redeemsAvailable}${redeems} </h4></div>
				<br>
				<div class="form-group">
					<sf:label class="form-label" path="userId"><h4>USER ID </h4> </sf:label>
					<sf:input class="form-control" type="number" path="userId" required="required"/>
				</div>
				<br>
				<div class="form-group">
					<sf:label class="form-label" path="couponId"><h4>COUPON ID</h4> </sf:label>
					<sf:input class="form-control" type="number" path="couponId" required="required"/>
				</div>
				<br>
				<div class="form-group" style={{ padding-top: 20% }}>
				<button class="btn btn-primary btn-lg" type="submit">Submit</button>
				</div>
			</div>
		</div>
	</sf:form>
	</div>
	</div>

    </div>
	
</body>
</html>
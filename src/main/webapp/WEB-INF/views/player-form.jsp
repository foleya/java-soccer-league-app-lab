<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>${ title }</title>
<!-- Link the bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<!-- Or in this case, a variation theme... -->
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />
 --><!-- Custom CSS goes below Bootstrap CSS -->
<link rel="stylesheet" href="/style.css" />
</head>
<body>
	<main class="container">
		<h1 class="col-4">${ title }</h1>
		<form class="form col-5" method="post">
			
			<div class="form-group">
			    <label for="name">Name</label>
			    <!-- pre-populate the input value from the existing food (if any) -->
			    <input class="form-control" id="name" name="name" value="${ player.name }" type="text" required minlength="2" autocomplete="off">
			</div>
			
			<div class="form-group">
				<label class="sr-only" for="category">Team</label>
		  		<select class="form-control mb-2 mr-sm-2" id="team" name="teamId" required>
		  			<option value="" disabled selected>Select a Team</option>
		  			<c:forEach items="${ teams }" var="team">
		  				<option value="${ team.teamId }">${ team.name }</option>
		  			</c:forEach>
		  		</select>
		  	</div>
			
			<button class="btn btn-primary mb-2 mr-2">Save +</button>
			<button type="button" onclick="location.href='/';" class="btn btn-secondary mb-2 mr-2">Cancel -</button>
		</form>
	</main>
</body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Simple Shop main page</h2>

	<div id="cat_products">
	    <c:forEach var="product" items="${category_products}">
	        <c:out value="${product.name}"/>
	    </c:forEach>
	</div>
</body>
</html>
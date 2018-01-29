<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="myTags"%>
<div id="product_categories">
    <h2>Product categories:</h2>
        <ul id="nav">
			<c:forEach var="category" items="${categories}">
			<s:url value="/category/${cat_id}"
                    var="cat_url">
                        <s:param name="cat_id"
                            value="${category.categoryId}" />
                </s:url>
			    <li><a href="${cat_url}"> <c:out value="${category.name}" /></a>
			        <myTags:getSubCategories category="${category}"/>
                </li>
			</c:forEach>
		</ul>
</div>
</body>
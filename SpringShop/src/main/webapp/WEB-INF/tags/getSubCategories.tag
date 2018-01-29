<%@ attribute name="category" type="com.vysu.store.model.entity.Category" required="true" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="myTags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="s" uri="http://www.springframework.org/tags"%>

<c:if test="${!empty category.subCategories}">
    <ul class="subs">
    <c:forEach var="category" items="${category.subCategories}">
    <s:url value="/category/${cat_id}"
        var="cat_url">
            <s:param name="cat_id"
                value="${category.categoryId}" />
    </s:url>
        <li>
        <a href="${cat_url}"> <c:out value="${category.name}" /> </a>
            <myTags:getSubCategories category="${category}"/>
        </li>
    </c:forEach>
    </ul>
</c:if>
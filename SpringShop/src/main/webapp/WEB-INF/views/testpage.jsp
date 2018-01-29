<!DOCTYPE html>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
   <html>
      <head>
         <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
         <title>Spring Boot</title>
      </head>
      <body>
         <h1>Edit Product Page</h1>
         <hr>

         <form:form method="post" modelAttribute="category" action="categories/add">
                     <form:label path="name">Name</form:label>
                     <Br>
                     <form:input path="name" type="text" />
                     <Br>
                     <select id="set_parent" name="set_parent">
                     <option value="" label="--- Please Select Parent Category"></option>
                     <c:forEach var="category" items="${categories}">
                        <option value="${category.categoryId}" label="${category.name}"></option>
                     </c:forEach>
                     </select>

                     <Br>
                     <input type="submit" value="Submit"/>
                  </form:form>

         <div id="product_categories">
            <h2>Product categories:</h2>
            <ul id="nav">
               <c:forEach var="category" items="${categories}">
                  <s:url value="/category/${cat_id}"
                     var="cat_url">
                     <s:param name="cat_id"
                        value="${category.categoryId}" />
                  </s:url>
                  <li>
                     <a href="${cat_url}">
                        <c:out value="${category.name}" />
                     </a>
                     <myTags:getSubCategories category="${category}"/>
                  </li>
               </c:forEach>
            </ul>
         </div>
      </body>
   </html>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

<body>
Available books <br/>
<c:forEach items="${bookList}" var="book">
		${book.id} ${book.authorId}: ${book.name}
		<br />
	</c:forEach>

	Message: ${bookList}
</body>

</html>
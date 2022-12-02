<%-- 지시자 --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		<a href="/servletjsp/exam10/ExceptionHandlingController" class="btn btn-info btn-sm">try-catch 이용</a>
		<!-- try-catch안쓰는 대신에 web.xml을 이용한다는 의미에서 no붙음 -->
		<a href="/servletjsp/exam10/NoExceptionHandlingController" class="btn btn-info btn-sm">web.xml 이용</a>
	</div>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>

<%-- 지시자 --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		userCookie.jsp
	</div>
	<div class="card-body">
		useremail: ${useremail}
		<br/>
		userId: ${userId}
	</div>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>

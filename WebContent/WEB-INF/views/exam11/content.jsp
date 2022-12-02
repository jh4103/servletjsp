<%-- 지시자 --%>
<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
		<h4>값출력</h4>
		1. ${5} <br/>
		2. ${"홍길동"} <br/>
		3. ${2+5} <br/>

		<h4 class="mt-3">산술 연산자</h4>
		<!-- 나머지를 산출하는 mod와 % -->
		4. ${7 mod 3} <br/> 
		5. ${7 % 3} <br/>
		
		
		<h4 class="mt-3">논리 연산자</h4>
		<!-- 둘다 true 여야 true값 나옴 -->
		6. ${true && true} <br/>
		7. ${true and true } <br/>

		<!-- 둘 중 하나만 true 여도 true -->
		8. ${true || false} <br/>
		9. ${true or false} <br/>
		
		<!-- true의 반대 -->
		10. ${!true} <br/>
		11. ${not true} <br/>
		
		<h4 class="mt-3">비교연산자</h4>
		<!-- 비교연산자 -->
		12. ${2 < 5}, ${2 lt 5} <br/> <!-- less than -->
		13. ${2 > 5}, ${2 gt 5} <br/> <!-- greate than -->
		14. ${2 <= 5}, ${2 le 5} <br/> <!-- less equal -->
		15. ${2 >= 5}, ${2 ge 5} <br/> <!-- greate equal -->
		16. ${2 != 5} <br/> 
		
		<!-- 빈 문자열에 대한 논리확인 -->
		17. ${empty null } <br/>
		18. ${empty "" } <br/>
		
		<h4 class="mt-3">pageContext를 이용해서 request, response, session의 Getter리턴값 얻기</h4>
		19. ${pageContext.request.contextPath} <br/>
		
		<h4 class="mt-3">request 범위 -> session범위 -> applicaion 범위 순으로 저장된 이름의 값을 출력</h4>
		20. ${user.userId} , ${user.userName} <br/> <!-- user라는 이름을 가진 객체 -->
		21. ${board.bno}, ${board.btitle}, ${board.bcontent} <br/>
		22. ${info} <!-- info는 문자열이라서 냅둠 -->
		
	</div>
</div>


<%@ include file="/WEB-INF/views/common/footer.jsp" %>

<%@ include file="/WEB-INF/template/include.jsp" %>

<%@ include file="/WEB-INF/template/header.jsp" %>

<h2>Existing Notes</h2>
<c:if test="${fn:length(notes) == 0}">
	None
</c:if>
<c:forEach var="note" items="${notes}">
	<div style="border: 1px black solid">
		<u>${note.title}</u><br/>
		${note.text}
	</div>
</c:forEach>

<h2>Add another note</h2>
<form method="post" action="addNote.form">
	<input type="hidden" name="patient_id" value="${patient.patientId}"/>
	Title: <input type="text" name="title"/><br/>
	Text: <input type="text" name="text"/><br/>
	<input type="submit" value="Add Note"/>
</form>

<%@ include file="/WEB-INF/template/footer.jsp" %>
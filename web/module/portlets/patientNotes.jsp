<%@ include file="/WEB-INF/template/include.jsp" %>

<c:if test="${fn:length(model.notes) == 0}">
	No notes
</c:if>

<c:forEach var="note" items="${model.notes}">
	<div style="border: 1px black solid; background-color: #ffff88; margin: 0.5em; width: 50%">
		<b><u>${note.title}</u></b><br/>
		${note.text}
	</div>
</c:forEach>

<br/>

<h4 style="border-top: 1px black dashed">Add another note</h4>
<form method="post" action="<openmrs:contextPath/>/module/patientnotes/addNote.form">
	<input type="hidden" name="patient_id" value="${patient.patientId}"/>
	<input type="hidden" name="returnUrl" value="/patientDashboard.form?patientId=${patient.patientId}"/>
	Title: <input type="text" name="title"/><br/>
	Text: <input type="text" name="text"/><br/>
	<input type="submit" value="Add Note"/>
</form>
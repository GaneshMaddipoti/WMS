<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
<script>
	//callback handler for form submit
	$(document).ready(function() {
		$("#saveVolunteerButton").click(function(e) {
			var postData = $("#volunteer").serializeArray();
			var formURL = $("#volunteer").attr("action");
			$.ajax({
				url : formURL,
				type : "POST",
				data : postData,
				success : function(data, textStatus, jqXHR) {
					$("main").html(data);
				},
				error : function(jqXHR, textStatus, errorThrown) {
					$("main").html(textStatus);
				}
			});
		});
	});
</script>
<div class="container" id="volunteerCreate">
	<div class="row">
		<div class="col s12">
			<div class="card">
				<div class="card-content">
					<form:form method="POST" action="volunteer/savevolunteer"
						modelAttribute="volunteer">

						<form:hidden path="id" />

						<div class="row">
							<div class="input-field col s6">
								<form:input path="firstName" />
								<form:label path="firstName">First Name</form:label>
							</div>
							<div class="input-field col s6">
								<form:input path="lastName" />
								<form:label path="lastName">Last Name</form:label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s6">
								<form:select path="gender">
									<form:option value="" disabled="disabled">Choose your option</form:option>
									<form:option value="Male">Male</form:option>
									<form:option value="Female">Female</form:option>
								</form:select>
								<label>Gender</label>
							</div>
							<div class="input-field col s6">
								<form:input path="birthDate" class="datepicker"/>
								<form:label path="birthDate">Birth Date</form:label>
							</div>
						</div>
						
						<div class="row">
							<div class="col s12">
								<input type="button" value="Save Volunteer" class="btn"
									id="saveVolunteerButton" />
							</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$('#modal1').modal('close');		
	});
</script>
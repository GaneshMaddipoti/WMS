<div class="container">
	<br />
	<div class="row">
		<div class="col s12 m6">
			<div class="card">
				<div class="card-content">
					<span class="card-title"><i class="material-icons">apps</i>
						Volunteers</span>
					<p>Description...</p>
				</div>
				<div class="card-action">
					<a href="#" id="viewVolunteers">View All</a>
				</div>
			</div>
		</div>		
	</div>
	
</div>
<script>
	$(document).ready(function() {
		try {
			$('#modal1').modal('close');
		}catch(err){
			//do nothing
		}
		$("#viewVolunteers").click(function() {
			$('#modal1').modal('open');
			$("main").load("volunteer/listvolunteer");
		})
	});
</script>
<c:if test = "${!empty success}">
	<div class="alert alert-info">
		<h3><strong>Op�ration effectu�e !</strong></h3>
		<h5>${success}</h5>
	</div>
</c:if> 

<c:if test = "${!empty warning}">
	<div class="alert alert-warning">
		<h3><strong>Attention !</strong></h3>
		<h5>${warning}</h5>
	</div>
</c:if>

<c:if test = "${!empty error}">
	<div class="alert alert-danger">
		<h3><strong>Erreur !</strong></h3>
		<h5>${error}</h5>									
	</div>
</c:if>

<%@page import="web.CreditModel"%>
<%
CreditModel model = (CreditModel) request.getAttribute("creditModel");
%>

<!DOCTYPE html>
<html>
<head>
<title>Crédit bancaire</title>
<meta charset="ut-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />
</head>
<body>
	<p class="spacer"></p>
	<div class="container">
		<div class="col-md-6 col-xm-12 col-sm-6 col-md-offset-3)">
			<div class="border ">
				<div class="card-header bg-primary">Simulateur de crédit</div>
				<div class="card-body">
					<form action="calculerMendualite.do" method=post>
						<div class="form-group">
							<label class="control-label"> Montant : </label> <input
								class="form-control" type="text" name="montant"
								value="<%=model.getMontant()%>" />
						</div>
						<div class="form-group">
							<label class="control-label"> Taux : </label> <input
								class="form-control" type="text" name="taux"
								value="<%=model.getTaux()%>" />
						</div>
						<div class="form-group">
							<label class="control-label"> Durée : </label> <input
								class="form-control" type="text" name="duree"
								value="<%=model.getDuree()%>" />
						</div>
						<button class="btn btn-danger">Calculer</button>
					</form>
					<p class="spacer"></p>
					<div class="card-footer">
						<label> Mensualité :</label> <label> <%=model.getMensualite()%></label>
					</div>

				</div>
			</div>
		</div>
	</div>

</body>

</html>
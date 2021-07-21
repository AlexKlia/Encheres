<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../../fragment/entete.jspf"%>

<%
	// Déclarations des variables
	String pseudo = (String) request.getAttribute("pseudo");
	String nom = (String) request.getAttribute("nom");
	String prenom = (String) request.getAttribute("prenom");
	String email = (String) request.getAttribute("email");
	String tel = (String) request.getAttribute("tel");
	String rue = (String) request.getAttribute("rue");
	String codePostal = (String) request.getAttribute("codePostal");
	String ville = (String) request.getAttribute("ville");
%>
<h1>Mon profil</h1>
<form action="<%=request.getContextPath()%>/ServletProfil" method="post">
	<div class="form-group row">
		<label for="text" class="col-sm-4 col-form-label">Pseudo : </label>
		<div class="col-sm-8">
			<input type="text" class="form-control" name="pseudo" id="pseudo"
				maxlength="30" value="${pseudo}" readonly />
		</div>
	</div>
	<div class="form-group row">
		<label for="text" class="col-sm-4 col-form-label">Nom : </label>
		<div class="col-sm-8">
			<input type="text" class="form-control" name="nom" id="nom"
				maxlength="30" value="${nom}" readonly/>
		</div>
	</div>
	<div class="form-group row">
		<label for="text" class="col-sm-4 col-form-label">Prénom : </label>
		<div class="col-sm-8">
			<input type="text" class="form-control" name="prenom" id="prenom"
				maxlength="30" value="${prenom}" readonly/>
		</div>
	</div>
	<div class="form-group row">
		<label for="text" class="col-sm-4 col-form-label">Email : </label>
		<div class="col-sm-8">
			<input type="email" class="form-control" name="email" id="mail"
				maxlength="20" value="${email}" readonly/>
		</div>
	</div>
	<div class="form-group row">
		<label for="text" class="col-sm-4 col-form-label">Téléphone :
		</label>
		<div class="col-sm-8">
			<input type="tel" class="form-control" name="tel" id="tel"
				maxlength="15" value="${tel}" readonly/>
		</div>
	</div>
	<div class="form-group row">
		<label for="text" class="col-sm-4 col-form-label">Rue : </label>
		<div class="col-sm-8">
			<input type="text" class="form-control" name="rue" id="rue"
				maxlength="30" value="${rue}" readonly/>
		</div>
	</div>
	<div class="form-group row">
		<label for="text" class="col-sm-4 col-form-label">Code postal
			: </label>
		<div class="col-sm-8">
			<input type="text" class="form-control" name="codePostal"
				id="codepostal" maxlength="10" value="${codePostal}" readonly/>
		</div>
	</div>
	<div class="form-group row">
		<label for="text" class="col-sm-4 col-form-label">Ville : </label>
		<div class="col-sm-8">
			<input type="text" class="form-control" name="ville" id="ville"
				maxlength="30" value="${ville}" readonly/>
		</div>
	</div>


	<div class="d-flex justify-content-center">
		<div class="row">

			<div class="col">
				<button class="btn btn-outline-dark btn-lg" type="submit"
					name="submitButton" value="update">Modifier</button>
			</div>
			<div class="col">
				<button class="btn btn-outline-dark btn-lg" type="submit"
					name="submitButton" value="cancel">Annuler</button>
			</div>

		</div>
	</div>

</form>

<%@ include file="../../fragment/piedDePage.jspf"%>
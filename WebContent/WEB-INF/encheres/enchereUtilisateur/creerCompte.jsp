<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../../fragment/entete.jspf"%>

<!-- Déclaration des variables -->
<%
	String erreur = (String) request.getAttribute("erreur");
%>

<div class="alert alert-${alertClass}" role="alert">
		<c:choose>
			<c:when test="${errorMessages != null}">
				<ul class="list-unstyled">
					<c:forEach var="var" items="${errorMessages}">
						<li>${var}</li>
					</c:forEach>
				</ul>
			</c:when>
		</c:choose>
</div>


<h1 class="text-center text-dark">Mon profil</h1>




<form action="<%=request.getContextPath()%>/ServletCreerCompte"
	method="post">

	<div class="row mt-5">

		<div class="col">
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Pseudo : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="pseudo" id="pseudo"
						maxlength="30" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Prénom : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="prenom" id="prenom"
						maxlength="30" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Téléphone
					: </label>
				<div class="col-sm-8">
					<input type="tel" class="form-control" name="tel" id="tel"
						maxlength="15" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Code
					postal : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="codePostal"
						id="codepostal" maxlength="10" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Mot de
					passe : </label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="mdp" id="mdp"
						maxlength="30" />

				</div>
			</div>
		</div>
		<div class="col">
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Nom : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="nom" id="nom"
						maxlength="30" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Email : </label>
				<div class="col-sm-8">
					<input type="email" class="form-control" name="email" id="mail"
						maxlength="20" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Rue : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="rue" id="rue"
						maxlength="30" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Ville : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="ville" id="ville"
						maxlength="30" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Confirmation
					: </label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="mdpC" id="mdpC"
						maxlength="30" />

				</div>
			</div>
		</div>

	</div>

	<div class="d-flex justify-content-center">
		<div class="row">

			<div class="col">
				<button class="btn btn-outline-dark" type="submit"
					name="submitButton" value="add">Créer</button>
			</div>
			<div class="col">
				<button class="btn btn-outline-dark" type="submit"
					name="submitButton" value="cancel">Annuler</button>
			</div>

		</div>

	</div>
	<div class="container">
		<div class="row mt-5">
			<div class="text-danger">
				<c:if test="${erreur!=null }"><%=erreur%></c:if>
			</div>
		</div>
	</div>

</form>













<%@ include file="../../fragment/piedDePage.jspf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../../fragment/entete.jspf"%>

<c:if test="${errorMessages != null}">
	<div class="alert alert-danger" role="alert">
		<ul class="list-unstyled">
			<c:forEach var="var" items="${errorMessages}">
				<li>${var}</li>
			</c:forEach>
		</ul>
	</div>
</c:if>


<h1 class="text-center text-dark">Mon profil</h1>

<form action="<%=request.getContextPath()%>/ServletModifierProfil"
	method="post">

	<div class="row mt-5">

		<div class="col">
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Pseudo : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="pseudo" id="pseudo" maxlength="30" value="${pseudo}" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Prénom : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="prenom" id="prenom" maxlength="30" value="${prenom}"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Téléphone
					: </label>
				<div class="col-sm-8">
					<input type="tel" class="form-control" name="tel" id="tel" maxlength="15" value="${tel}" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Code
					postal : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="codePostal"
						id="codepostal" maxlength="10" value="${codePostal}"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Mot de
					passe : </label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="mdp" id="mdp" maxlength="30" value="${mdp}"/>
				</div>
			</div>
		</div>
		<div class="col">
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Nom : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="nom" id="nom" maxlength="30" value="${nom}"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Email : </label>
				<div class="col-sm-8">
					<input type="email" class="form-control" name="email" id="mail" maxlength="20" value="${email}" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Rue : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="rue" id="rue" maxlength="30" value="${rue}"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Ville : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="ville" id="ville" maxlength="30" value="${ville}"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Confirmation
					: </label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="mdp" id="mdp" maxlength="30"/>
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Credit
					: </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="credit" id="credit" maxlength="30" value="${credit}" readonly/>
				</div>
			</div>
		</div>

	</div>


	<div class="d-flex justify-content-center">
		<div class="row">

			<div class="col">
			<button class="btn btn-outline-dark" type="submit" name="submitButton" value="update"
							>Enregistrer</button>
			</div>
			<div class="col">
			<button class="btn btn-outline-dark" type="submit" name="submitButton" value="delete"
							>Supprimer mon compte</button>
			</div>

		</div>
		
	</div>
</form>
<%@ include file="../../fragment/piedDePage.jspf"%>
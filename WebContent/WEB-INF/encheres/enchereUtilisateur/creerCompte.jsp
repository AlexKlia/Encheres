<%@ include file="../../fragment/entete.jspf"%>
<h1 class="text-center text-dark">Mon profil</h1>




<form action="<%=request.getContextPath()%>/ServletCreerCompte"
	method="post">

	<div class="row mt-5">

		<div class="col">
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Pseudo : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="identifiant"
						id="identifiant" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Prénom : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="prenom" id="prenom" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Téléphone
					: </label>
				<div class="col-sm-8">
					<input type="tel" class="form-control" name="tel" id="tel" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Code
					postal : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="codepostal"
						id="codepostal" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Mot de
					passe : </label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="mdp" id="mdp" />
				</div>
			</div>
		</div>
		<div class="col">
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Nom : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="nom" id="nom" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Email : </label>
				<div class="col-sm-8">
					<input type="email" class="form-control" name="mail" id="mail" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Rue : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="rue" id="rue" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Ville : </label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="ville" id="ville" />
				</div>
			</div>
			<div class="form-group row">
				<label for="text" class="col-sm-4 col-form-label">Confirmation
					: </label>
				<div class="col-sm-8">
					<input type="password" class="form-control" name="mdp" id="mdp" />
				</div>

			</div>
		</div>

	</div>


	<div class="d-flex justify-content-center">
		<div class="row">
			
				<div class="col">

					<button type="button" class="btn-size btn btn-outline-dark">Créer
					</button>
				</div>
				<div class="col">
					<button type="button" class="btn-size btn btn-outline-dark">Annuler</button>
				</div>
			
		</div>
	</div>
</form>













<%@ include file="../../fragment/piedDePage.jspf"%>
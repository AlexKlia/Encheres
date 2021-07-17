<%@ include file="../../fragment/entete.jspf"%>

<!-- D�claration des variables -->
<% 
	String rue = (String) request.getAttribute("rue");
	String code_postal = (String) request.getAttribute("code_postal");
	String ville = (String) request.getAttribute("ville");
	String article = (String) request.getAttribute("article");
	String description = (String) request.getAttribute("description");
	String categorie = (String) request.getAttribute("categorie");
	String miseAPrix = (String) request.getAttribute("miseAPrix");
	String debut = (String) request.getAttribute("debut");
	String fin = (String) request.getAttribute("fin");
	String id = (String) request.getAttribute("id");
%>

<h1 class="text-center">Nouvelle vente</h1>

<div class="row mt-5">
	<div class="col-3">
		<img class="col-12" alt="Photo de l'article en ventes" src="images/noPics.jpg">
	</div>

	<div class="col-9">
		<form action="<%=request.getContextPath()%>/ventes" method="POST">
			<div class="form-group row">
				<label for="article" class="col-sm-3 col-form-label">Article :</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="article" name="article" placeholder="Nom de l'article" value="<%= null != article ? article : "" %>">
				</div>
			</div>

			<div class="form-group row">
				<label for="description" class="col-sm-3 col-form-label">Description :</label>
				<div class="col-sm-8">
					<textarea rows="4" class="form-control" id="description" name="description"><%= null != description ? description : "" %></textarea>
				</div>
			</div>

			<div class="form-group row">
				<label for="categorie" class="col-sm-3 col-form-label">Cat�gorie :</label>
				<div class="col-sm-8">
					<select id="categorie" class="form-control" name="categorie">
						<option value="1" <%= categorie == "1" ? "selected" : "" %>>Maison</option>
						<option value="2" <%= categorie == "2" ? "selected" : "" %>>Exterieur</option>
					</select>
				</div>
			</div>

			<div class="form-group row">
				<label for="photoArticle" class="col-sm-3 col-form-label">Photo de l'article :</label>
				<div class="col-sm-8">
					<input type="file" class="form-control-file" id="photoArticle" name="photoArticle">
				</div>
			</div>

			<div class="form-group row">
				<label for="miseAPrix" class="col-sm-3 col-form-label">Mise � prix :</label>
				<div class="col-sm-8">
					<input type="number" class="form-control" id="miseAPrix" name="miseAPrix" value="<%= null != miseAPrix ? miseAPrix : "" %>">
				</div>
			</div>

			<div class="form-group row">
				<label for="debutEnchere" class="col-sm-3 col-form-label">D�but de l'enchere :</label>
				<div class="col-sm-8">
					<input type="date" class="form-control" id="debutEnchere" name="debutEnchere" value="<%= null != debut ? debut : "" %>">
				</div>
			</div>

			<div class="form-group row">
				<label for="finEnchere" class="col-sm-3 col-form-label">Fin de l'enchere :</label>
				<div class="col-sm-8">
					<input type="date" class="form-control" id="finEnchere" name="finEnchere" value="<%= null != fin ? fin : "" %>">
				</div>
			</div>

			<fieldset class="form-group border p-3">
				<legend class="w-auto px-2">Retrait</legend>

				<div class="form-group row">
					<label for="rue" class="col-sm-3 col-form-label">Rue :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="rue" name="rue" value="<%= null != rue ? rue : "" %>">
					</div>
				</div>

				<div class="form-group row">
					<label for="codePostal" class="col-sm-3 col-form-label">Code postal :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="codePostal" name="codePostal" value="<%=  null != code_postal ? code_postal : "" %>">
					</div>
				</div>

				<div class="form-group row">
					<label for="ville" class="col-sm-3 col-form-label">Ville :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="ville" name="ville" value="<%= null != ville ? ville : "" %>">
					</div>
				</div>
			</fieldset>

			<input type="hidden" id="noArticle" name="noArticle" value="<%= null != id ? id : "" %>">

			<button type="submit" class="btn btn-lg btn-outline-dark mr-5">Enregistrer</button>
			<button class="btn btn-lg btn-outline-danger">Annuler</button>

		</form>
	</div>
</div>

<%@ include file="../../fragment/piedDePage.jspf"%>
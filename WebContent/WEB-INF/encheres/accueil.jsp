<%@include file="../fragment/entete.jspf"%>

<h1 class="text-center text-dark">Liste des enchères</h1>

<h2>Filtres :</h2>

<form action="${request.getContextPath()}" method="GET">
	<div class="row">
		<div class="col col-sm-6">
			<div class="form-group row">
				<div class="col-sm-8"> 
					<input class="form-control" type="text" name="recherche" id="recherche" placeholder="Le nom de l'article contient" autofocus />
				</div>
			</div>
		
			<div class="form-group row">
				<label class="col-sm-auto col-form-label" for="categorie">Catégorie: </label>
				<div class="col-sm-6">
					<select class="form-control" name="categorie">
						<option value="toutes" selected="selected">Toutes</option>
						<option value="informatique">Informatique</option>
						<option value="ameubleument">Ameubleument</option>
						<option value="vetement">Vetement</option>
						<option value="sportLoisir">Sport&Loisirs</option>
					</select>
				</div>
			</div>
			
			
			<c:if test="${null != noUtilisateur}">
				<div class="form-group row">
					<div class="col-sm-6">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="mode" value="achats" id="checkAchat">
							<label class="form-check-label" for="checkAchat">Achats</label>
							
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="achats" value="encheresOuvertes" id="encheresOuvertes">
								<label class="form-check-label" for="encheresOuvertes">Enchères ouvertes</label>
							</div>
							
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="achats" value="mesEncheresOuvertes" id="mesEncheresOuvertes">
								<label class="form-check-label" for="mesEncheresOuvertes">Mes enchères en cours</label>
							</div>
							
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="achats" value="mesEncheresRemportees" id="mesEncheresRemportees">
								<label class="form-check-label" for="mesEncheresRemportees">Mes enchères remportées</label>
							</div>
						</div>
					</div>
					
					<div class="col-sm-6">
						<div class="form-check">
							<input class="form-check-input" type="radio" name="mode" value="ventes" id="checkVente">
							<label class="form-check-label" for="checkVente">Mes ventes</label>
							
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="ventes" value="ventesEnCours" id="ventesEnCours">
								<label class="form-check-label" for="ventesEnCours">Mes ventes en cours</label>
							</div>
							
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="ventes" value="ventesNonDebutees" id="ventesNonDebutees">
								<label class="form-check-label" for="ventesNonDebutees">Ventes non debutées</label>
							</div>
							
							<div class="form-check">
								<input class="form-check-input" type="checkbox" name="ventes" value="ventesTerminees" id="ventesTerminees">
								<label class="form-check-label" for="ventesTerminees">Ventes terminées</label>
							</div>
						</div>
					</div>
				</div>
			</c:if>
			
		</div>

		<div class="col col-sm-6">
			<button type="submit" name="submitButton" value="add" class="btn btn-lg btn-outline-dark btn-search">Rechercher</button>
		</div>
	</div>
</form>

<div class="row">
	<c:forEach var="a" items="${listArticles}">
		<div class="card mb-3 col col-5 ml-2">
			<div class="row no-gutters">
				<div class="col-md-4">
					<img class="col-md-12 img-full" alt="Photo de l'article en ventes" src="images/noPics.jpg">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<a class="card-title" href="<%= request.getContextPath() %>/ventes?noArticle=${a.noArticle}">${a.nomArticle}</a>
						<p class="card-text">Prix: ${a.miseAPrix} points</p>
						<p class="card-text">Fin de l'enchère: ${a.dateFinEncheres}</p>
						<p class="card-text">
							<small class="text-muted">${a.vendeur.pseudo}</small>
						</p>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</div>

<%@include file="../fragment/piedDePage.jspf"%>
	
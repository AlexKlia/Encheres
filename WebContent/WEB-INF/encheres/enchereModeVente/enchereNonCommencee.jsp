<%@ include file="../../fragment/entete.jspf"%>

<c:if test="${deleteSuccess || addSuccess || updateSuccess || cancelSuccess || null != errorMessages}">
	<div class="row justify-content-md-center">
		<div class="col col-lg-6 text-center font-weight-bold">
			<div class="alert alert-${alertClass}" role="alert">
				<c:choose>
					<c:when test="${deleteSuccess}">
			  			La vente a �t� annul�e avec succ�s.
			        </c:when>
			        
			        <c:when test="${addSuccess}">
					  	La vente a �t� cr�ee avec succ�s.
			        </c:when>
			        
			        <c:when test="${null != errorMessages}">
			        	<ul class="list-unstyled">
						  	<c:forEach var="var" items="${errorMessages}">
						  		<li>${var}</li>
							</c:forEach>
						</ul>
			        </c:when>
			        
			        <c:when test="${updateSuccess}">
					  	La vente a �t� modifi�e avec succ�s.
			        </c:when>
												
			        <c:otherwise>
						Les modifications ont �t� annul�es.
			        </c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</c:if>

<h1 class="text-center">${null != id ? "Votre vente" : "Nouvelle vente"}</h1>

<div class="row mt-5">
	<div class="col-3">
		<img class="col-12" alt="Photo de l'article en ventes" src="images/noPics.jpg">
	</div>

	<div class="col-9">
		<form action="${request.getContextPath()}" method="POST">
			<div class="form-group row">
				<label for="article" class="col-sm-3 col-form-label">Article :</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" id="article" name="article" placeholder="Nom de l'article" value="${article}">
				</div>
			</div>

			<div class="form-group row">
				<label for="description" class="col-sm-3 col-form-label">Description :</label>
				<div class="col-sm-8">
					<textarea rows="4" class="form-control" id="description" name="description">${description}</textarea>
				</div>
			</div>

			<div class="form-group row">
				<label for="categorie" class="col-sm-3 col-form-label">Cat�gorie :</label>
				<div class="col-sm-8">
					<select id="categorie" class="form-control" name="categorie">
						<option value="1" ${categorie.equals('1') ? 'selected' : ''}>Maison</option>
						<option value="2" ${categorie.equals('2') ? 'selected' : ''}>Exterieur</option>
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
					<input type="number" class="form-control" id="miseAPrix" name="miseAPrix" value="${miseAPrix}">
				</div>
			</div>

			<div class="form-group row">
				<label for="debutEnchere" class="col-sm-3 col-form-label">D�but de l'enchere :</label>
				<div class="col-sm-8">
					<input type="date" class="form-control" id="debutEnchere" name="debutEnchere" value="${debut}">
				</div>
			</div>

			<div class="form-group row">
				<label for="finEnchere" class="col-sm-3 col-form-label">Fin de l'enchere :</label>
				<div class="col-sm-8">
					<input type="date" class="form-control" id="finEnchere" name="finEnchere" value="${fin}">
				</div>
			</div>

			<fieldset class="form-group border p-3">
				<legend class="w-auto px-2">Retrait</legend>

				<div class="form-group row">
					<label for="rue" class="col-sm-3 col-form-label">Rue :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="rue" name="rue" value="${rue}">
					</div>
				</div>

				<div class="form-group row">
					<label for="codePostal" class="col-sm-3 col-form-label">Code postal :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="codePostal" name="codePostal" value="${codePostal}">
					</div>
				</div>

				<div class="form-group row">
					<label for="ville" class="col-sm-3 col-form-label">Ville :</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="ville" name="ville" value="${ville}">
					</div>
				</div>
			</fieldset>

			<input type="hidden" id="noArticle" name="noArticle" value="${id}">

			<button type="submit" name="submitButton" value="add" class="btn btn-lg btn-outline-dark mr-5">Enregistrer</button>
			<button type="submit" name="submitButton" value="cancel" class="btn btn-lg btn-outline-secondary">Annuler</button>
			<c:if test="${isCancellable}">
				<button type="submit" name="submitButton" value="delete" class="btn btn-lg btn-outline-danger ml-3">Annuler la vente</button>
			</c:if>
		</form>
	</div>
</div>

<%@ include file="../../fragment/piedDePage.jspf"%>
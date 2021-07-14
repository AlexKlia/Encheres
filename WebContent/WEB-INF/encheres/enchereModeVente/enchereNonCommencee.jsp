<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	
	    <title>Ventes - Enchères.org</title>
	
	    <!-- Bootstrap core CSS -->
	    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	</head>
	
	<body>
		<nav class="navbar navbar-dark bg-dark mb-3">
		  <a class="navbar-brand" href="#">ENI-Echeres</a>
		</nav>

		<div class="container">
			<h1 class="text-center">Nouvelle vente</h1>
			
			<div class="row mt-5">
				<div class="col-3">
					<img class="col-12" alt="Photo de l'article en ventes" src="images/noPics.jpg">
				</div>

				<div class="col-9">  				
	  				<form action="#"> 				
	  					<div class="form-group row">
	    					<label for="article" class="col-sm-3 col-form-label">Article :</label>
	    					<div class="col-sm-8">
	    						<input type="text" class="form-control" id="article" name="article" placeholder="Nom de l'article">
	    					</div>
 						</div>
 						
 						<div class="form-group row">
	    					<label for="description" class="col-sm-3 col-form-label">Description :</label>
	    					<div class="col-sm-8">
	  							<textarea rows="4" class="form-control" id="description" name="description"></textarea>
	    					</div>
 						</div>
	  					
	  					<div class="form-group row">
		  					<label for="categorie" class="col-sm-3 col-form-label">Catégorie :</label>
		  					<div class="col-sm-8">
			  					<select id="categorie" class="form-control" name="categorie">
			  						<option>Lorem</option>
			  						<option>Ipsum</option>
			  					</select>
		  					</div>
	  					</div>
	  					
	  					<div class="form-group row">
		  					<label for="photoArticle" class="col-sm-3 col-form-label">Photo de l'article :</label>
		  					<div class="col-sm-8">
		  						<input  type="file" class="form-control-file" id="photoArticle" name="photoArticle">
		  					</div>
		  				</div>	
	  					
	  					<div class="form-group row">
		  					<label for="miseAPrix" class="col-sm-3 col-form-label">Mise à prix :</label>
		  					<div class="col-sm-8">
		  						<input type="number" class="form-control" id="miseAPrix" name="miseAPrix">
		  					</div>
		  				</div>		
		  						
		  				<div class="form-group row">
		  					<label for="debutEnchere" class="col-sm-3 col-form-label">Début de l'enchere :</label>
		  					<div class="col-sm-8">
		  						<input type="date" class="form-control" id="debutEnchere" name="debutEnchere">
		  					</div>
		  				</div>		
		  						
		  				<div class="form-group row">
		  					<label for="finEnchere" class="col-sm-3 col-form-label">Fin de l'enchere :</label>
		  					<div class="col-sm-8">
		  						<input type="date" class="form-control" id="finEnchere" name="finEnchere">
		  					</div>
	  					</div>					
	  					
	  					<fieldset class="form-group border p-3">
					    	<legend class="w-auto px-2">Retrait</legend>

							<div class="form-group row">
							    <label for="rue" class="col-sm-3 col-form-label">Rue :</label>
							    <div class="col-sm-8">
		  							<input type="text" class="form-control" id="rue" name="rue">
							    </div>
	  						</div>
	  						
	  						<div class="form-group row">
							    <label for="codePostal" class="col-sm-3 col-form-label">Code postal :</label>
							    <div class="col-sm-8">
		  							<input type="text" class="form-control" id="codePostal" name="codePostal">
							    </div>
	  						</div>
	  						
	  						<div class="form-group row">
							    <label for="ville" class="col-sm-3 col-form-label">Ville :</label>
							    <div class="col-sm-8">
		  							<input type="text" class="form-control" id="ville" name="ville">
							    </div>
	  						</div>
						</fieldset>
						
						<button class="btn btn-lg btn-primary mr-5">Enregistrer</button>
						<button class="btn btn-lg btn-danger">Annuler</button>
						
	  				</form>
				</div>
			</div>
		</div>
	</body>
</html>

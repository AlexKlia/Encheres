
<%@ include file="../../fragment/entete.jspf"%>

<%-- <%-- <p><%=session.getAttribute("identifiant") %></p>
<p><%=session.getAttribute("mdp") %></p> --%>

<!-- Déclaration des variables -->
<%
	String erreur = (String) request.getAttribute("erreur");
	
%>


<div class="d-flex justify-content-center align-items-center container ">
	<form action="<%=request.getContextPath()%>/ServletConnexion"
		method="post">
		<div class="row mt-5">
			<div class="col-12">
				<div class="form-group row">
					<label for="text" class="col-sm-4 col-form-label">Identifiant
						: </label>
					<div class="col-sm-8">
						<input type="text" class="form-control" name="identifiant"
							id="identifiant" />
					</div>
				</div>
				<div class="form-group row">
					<label for="text" class="col-sm-4 col-form-label">Mot de
						passe : </label>
					<div class="col-sm-8">
						<input type="password" class="form-control" name="mdp" id="mdp" />
					</div>
				</div>
				<div class="row">
					<div class="col-sm-6">
						<button type="submit" name="submitButton" value="connexion"
							class="col-sm-12 btn btn-outline-dark btn-lg">Connexion</button>
					</div>
					<div class="col-sm-6 col text-right">
						<input type="checkbox" id="rememberme" name="rememberme">
						<label for="rememberme">Se souvenir de moi</label>
						<div>
							<a href="">Mot de passe oublié</a>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row mt-5">
					<div class="col-12">
						<button type="submit" name="submitButton" value="add"
							class="btn-height col-sm-12 btn btn-outline-dark btn-lg">Créer
							un compte</button>
					</div>
					<div class="container">
						<div class="row mt-5">
							<div class="text-danger">
								<c:if test="${erreur!=null }"><%=erreur%></c:if>
							</div>
						</div>
					</div>
					
				</div>
			</div>
		</div>
	</form>
</div>

<%@ include file="../../fragment/piedDePage.jspf"%>
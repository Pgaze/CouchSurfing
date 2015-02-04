

<!DOCTYPE html>
<html>
<%@ include file="entete.jsp"%>
<%@ include file="menu.jsp"%>
<body>
	<div id="containerRecherche">
		<h1>Recherche ton canapé</h1>
		<div id="formRecherche">
			<form id="leFormRecherche" method="post">
				<div id="contenuFormRecherche">
					<input id="inputCherche" type="text" name="ville"> <input
						class="date" type="text" name=""> <input class="date"
						type="text" name=""> <input type="submit" value="GO !"
						id="btCherche" name="btCherche">
				</div>
			</form>

		</div>
	</div>
	<div id="containerResultat">
		<p>${ erreur }</p>
		<form method="post">
		<c:forEach items="${lesOffres}" var="uneOffre">
		<div id="uneOffre">
			<div id="enTeteOffre"><h1 id="intituleEnTeteOffre"><c:out value="${ uneOffre.hebergeur}"/></h1></div>
				<div id="corpsOffre">
					<div id="critereAdresse" class="critereOffre">
						<h1 id="intituleCritere">Adresse: </h1><p id="valeurCritere"><c:out value="${ uneOffre.logement.adresse }"/></p>
						<input type="submit" name="${ uneOffre.logement.idLogement}" value="Postuler">					
					</div>
					
				</div>
			</div>
		</c:forEach>
		</form>
	</div>
</body>

<%@ include file="basdepage.jsp"%>
</html>


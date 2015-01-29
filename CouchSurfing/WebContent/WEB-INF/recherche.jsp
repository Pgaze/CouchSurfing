

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
						id="btCherche">
				</div>
			</form>

		</div>
	</div>
	<div id="containerResultat">
		<div id="uneOffre">
			<div id="enTeteOffre"><h1 id="intituleEnTeteOffre">${ nom} ${ prenom}LeNomDeTaMere</h1></div>
				<div id="corpsOffre">
					<div id="critereAdresse" class="critereOffre">
						<h1 id="intituleCritere">Adresse</h1><p id="valeurCritere">L'adresseDeTaMere</p>
					</div>
				</div>
		
			</div>
		</div>
</body>

<%@ include file="basdepage.jsp"%>
</html>


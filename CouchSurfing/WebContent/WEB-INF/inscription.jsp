<!DOCTYPE html>
<html>
<%@ include file="entete.jsp"%>
<%@ include file="menu.jsp"%>
<body>
	<div id="container">
		<form id="form_inscription" method="post" action="inscription">
			<h5>Merci de remplir ce formulaire !</h5>
			<div id="form_in_finscription">
				${ resultat }
				<div id="saisies_finscription">
					<label for="prenom">Prénom :</label><input placeholder="Prenom"
						required name="prenom" id="prenom" type="text"></input></br> <label
						for="nom">Nom :</label><input placeholder="Nom" required
						name="nom" id="nom" type="text"></input></br> <label for="pseudo">Pseudo
						:</label><input placeholder="pseudo" required name="pseudo" id="pseudo"
						type="text"></input></br> <label for="mail">Mail :</label><input
						placeholder="mail" required name="mail" id="mail" type="mail"></input></br>
					<label for="mdp">Mot de passe :</label><input placeholder="mdp"
						required name="mdp" id="mdp" type="password"></input></br> <label
						for="mdpC">Confirmer le mot de passe :</label><input
						placeholder="confirmer mdp" required name="mdpC" id="mailC"
						type="password"></input></br>
					<button id="valI" name="valI">Suite</button>
				</div>
			</div>
		</form>

	</div>
</body>
<%@ include file="basdepage.jsp"%>
</html>

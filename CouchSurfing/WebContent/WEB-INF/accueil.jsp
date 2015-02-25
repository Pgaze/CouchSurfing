
<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body>
        <div id="container">	        	
			<div class="contentAccueil" id="testImg">
				 <img class="img1_slide" src="${pageContext.request.contextPath}/ImageServlet" /> 
			</div>      	
			<div class="contentAccueil" id="presentation">
				<a href="evaluation"> Evaluation </a>
			</div>      	
			<div class="contentAccueil" id="connexion">
				<div id="formConnexion">
					<form action="accueil" method="post" id="formConnexion">
						<input required type="text" name="login" placeholder="Votre mail"/>
						<input required type="password" name="mdp" placeholder="Votre mot de passe"/>
						<input required type="Submit" name="valLogin"/>
					</form>
					<a href="inscription"> Vous n'avez pas de compte ? Inscrivez vous !</a>
				</div>
				${ resultat }
			</div>
        </div>
    </body>
    
	<%@ include file="basdepage.jsp" %>
</html>

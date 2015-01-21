<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body>
        <div id="container">
	        <div id="presentation" class="content-accueil">
	        </div>
	        <div id="explain" class="content-accueil">
	        	
	        </div>
		    <div id="connexion" class="content-accueil">
                <form id="form_connexion" action="traite_connexion.jsp" method="post">
		        	<input required name="login" id="login" type="text" placeholder="Votre login">
		        	<input required name="mdp" id="mdp" type="password" placeholder="Votre mot de passe">
		            <button id="valLogin" name="loginU">Login</button>
        			<p>Ou bien <a href="http://localhost:8080/clickAndSleep/incription">inscrivez-vous !</a></p>
        		</form>
				<div class="clear"></div>
        	</div>
        </div>
    </body>
    
	<%@ include file="basdepage.jsp" %>
</html>
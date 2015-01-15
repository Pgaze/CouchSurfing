<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="guest_menu.jsp" %>
    <body>
        <div id="container">
	        <div id="picture" class="content-accueil">
	        	
	        </div>
	        <div id="explain" class="content-accueil">
	        	
	        </div>
		    <div id="connection" class="content-accueil">
                <form id="form_connexion" action="index.php?vers_page=connexion" method="post">
		        	<input required name="login" id="login" type="text" placeholder="Votre login">
		        	<input required name="mdp" id="mdp" type="password" placeholder="Votre mot de passe">
		            <button id="val" name="loginU">Login</button>
        		</form>
<div class="clear"></div>
        </div>
        </div>
    </body>
    
	<%@ include file="basdepage.jsp" %>
</html>
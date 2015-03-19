
<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body style="background-image:url(${pageContext.request.contextPath}/ServletBackground)">
        <div id="container">
	        <h3>La ou je postule</h3>
	        	
			<div id="demandes">
			    <div id="infosDemandes">
			    <div id="ical"></div>
					<ol>
				<c:forEach begin="0" end="1">
						<li>
							<div class="uneDemande" id="">
								<div class="detailsAnnonce">
									
									<h3>Logement de Paul Dubois à Toulouse</h3>
									<div class="uneImg">Img ?</div>
									<div class="txt">Adresse: 31 Avenue de la raison </br>
															31000 Toulouse</br>
															Date: 31/01/2015-01/02/2015
									</div>
								</div>
							</div></li>
							</c:forEach>
						</ol>
			    </div>
			</div>
        </div>
    </body>
    
	<%@ include file="basdepage.jsp" %>
</html>

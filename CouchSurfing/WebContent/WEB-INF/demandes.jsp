
<!DOCTYPE html>
<html>
	<%@ include file="entete.jsp" %>
	<%@ include file="menu.jsp" %>
    <body style="background-image:url(${pageContext.request.contextPath}/ServletBackground)">
        <div id="container">
	        <h3>Demande envoy�</h3>
	        	
			<div id="demandes">
			    <div id="infosDemandes">
			    <div id="ical"></div>
				<ol>
					<c:forEach items="${demandeEnvoye }" var="postule">
							<li>
								<div class="uneDemande" id="">
									<div class="detailsAnnonce">
										
										<h3>Logement de ${postule.hebergeur } � ${postule.logement.adresse.ville }</h3>
								<!-- 		<div class="uneImg">Img ?</div>   -->
										<div class="txt">Adresse: ${postule.logement.adresse }</br>
																Date: 31/01/2015-01/02/2015
										</div>
									</div>
								</div>
							</li>
					</c:forEach>
				</ol>
			    </div>
			</div>
        </div>
              <div id="container">
	        <h3>Demande recus</h3>
	        	
			<div id="demandes">
			    <div id="infosDemandes">
			    <div id="ical"></div>
				<ol>
					<c:forEach items="${demandeRecu }" var="demande">
							<li>
								<div class="uneDemande" id="">
									<div class="detailsAnnonce">
										
										<h3>Demande de ${demande.postulant }</h3>
								<!-- 		<div class="uneImg">Img ?</div>   -->
										<div class="txt">
																Date: 31/01/2015-01/02/2015
										</div>
									</div>
								</div>
							</li>
					</c:forEach>
				</ol>
			    </div>
			</div>
        </div>
    </body>
    
	<%@ include file="basdepage.jsp" %>
</html>

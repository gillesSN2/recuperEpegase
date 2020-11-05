<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/erreurSysteme.jsp"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<h:panelGrid width="100%" columns="3" columnClasses="clos5c,clos40c,clos40c" border="0" style="text-align:center" >
    <h:column></h:column>
    <h:column>
        <h:panelGrid width="100%" columns="1" style="text-align:center;font-size:10px;background-color:transparent;border:solid 1px red;font-family:Verdana, Arial, sans-serif;">
            <h:column><h:outputText style="font-weight:bold;color:black" value="Société"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.connexion.var_societe}" id="idZone1" style="margin-left:10px;border:solid 1px red;" size="25" required="true" onkeyup="javascript:this.value=this.value.toUpperCase();"/></h:column>
            <h:column><h:outputText style="font-weight:bold;color:black" value="Login"/></h:column>
            <h:column><h:inputText value="#{bakingbeanepegase.connexion.var_login}" id="idZone2" style="margin-left:10px;border:solid 1px red;" size="25" required="true"/></h:column>
            <h:column ><h:outputText style="font-weight:bold;color:black" value="Password"/></h:column>
            <h:column><h:inputSecret value="#{bakingbeanepegase.connexion.var_pw}" redisplay="false" id="idZone3" style="margin-left:10px;border:solid 1px red;" size="25" required="true"/></h:column>
            <h:column><h:outputText value=""/></h:column>
            <h:column><h:outputText value=""/></h:column>
            <h:column>
                <h:commandButton style="cursor:pointer;color:red;" action="#{bakingbeanepegase.connection}" id="idBtn" value="connexion"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a4j:commandButton style="cursor:pointer;height:15px;width:15px" action="#{bakingbeanepegase.connecionEraser}" id="idBtnRaz" image="images/eraser.png" value="Effacement des informations de connexions" reRender="idZone1,idZone2,idZone3"/>
            </h:column>
            <h:column ><h:outputText value=""/></h:column>
            <h:column ><h:outputText value=""/></h:column>
        </h:panelGrid>
        <br>
        <h:panelGroup style="text-align:center">
            <center>
                <h:outputLink style="text-decoration:blink;" value="enquete/enquete.faces">
                    <img src="images/avis.png" alt="Donnez votre votre avis..." height="50" width="150" style="border:solid 1px red;"/>
                </h:outputLink>
            </center>
        </h:panelGroup>
    </h:column>
    <h:column>
        <h:panelGrid width="100%">
            <h:column>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==1}">
                    <img src="images/dateImportante/bonne_annee.gif" alt="Bonne Année" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==2}">
                    <img src="images/dateImportante/st_valentin.jpg" alt="St valentin" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==3}">
                    <img src="images/dateImportante/femme_jour.jpg" alt="Journée internationale de la femme" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==4}">
                    <img src="images/dateImportante/fete_mere.jpg" alt="Fêtes des mères" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==5}">
                    <img src="images/dateImportante/fete_pere.jpg" alt="Fêtes des pères" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==6}">
                    <img src="images/dateImportante/fete_france.jpg" alt="Fêtes de France" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==7}">
                    <img src="images/dateImportante/fete_gabon.jpg" alt="Fêtes du Gabon" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==8}">
                    <img src="images/dateImportante/fete_senegal.jpg" alt="Fêtes du Sénégal" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==9}">
                    <img src="images/dateImportante/fete_mali.jpg" alt="Fêtes du Mali" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==10}">
                    <img src="images/dateImportante/fete_cote_ivoire.jpg" alt="Fêtes de la Cote d'Ivoire" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==11}">
                    <img src="images/dateImportante/fete_1ermai.jpg" alt="1er Mai Fêtes du travail" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==12}">
                    <img src="images/dateImportante/fete_assomption.jpg" alt="Fêtes de l'assomption" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==13}">
                    <img src="images/dateImportante/fete_toussaints.jpg" alt="Fêtes de la Toussaints" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==14}">
                    <img src="images/dateImportante/fete_noel.jpg" alt="Fêtes de Noel" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==15}">
                    <img src="images/dateImportante/femme_africaine.jpg" alt="Journée de la Femme Africaine" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==16}">
                    <img src="images/dateImportante/femme_veuve.jpg" alt="Journée de la Veuve" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==17}">
                    <img src="images/dateImportante/femme_gabonaise.jpg" alt="Journée nationale de la Femme Gabonaise" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==18}">
                    <img src="images/dateImportante/femme_violence.jpg" alt="Journée de la lutte contre Les violences faites aux femmes" height="200" width="250"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==19}">
                    <img src="images/dateImportante/fsbo.jpg" alt="Fondation Sylvia Bongo Ondiba" height="200" width="200"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==20}">
                    <img src="images/dateImportante/croix_rouge.png" alt="Journée de la Croix Rouge" height="200" width="200"/>
                </h:panelGroup>
                <h:panelGroup rendered="#{bakingbeanepegase.dateImportante==21}">
                    <img src="images/dateImportante/journeeAfrique.jpg" alt="Journée mondiale de l'Afrique" height="200" width="200"/>
                </h:panelGroup>
            </h:column>
            <br>
            <center>
                <a href="https://web.facebook.com/e-P%C3%A9gase-190413784328927/" target="_blank"><img src="images/logo_facebook.png" alt="Facebook" height="30px" width="30px" title="Suivez nous sur Facebook"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="https://www.linkedin.com/company/10520888?trk=tyah&trkInfo=clickedVertical%3Acompany%2CentityType%3AentityHistoryName%2CclickedEntityId%3Acompany_10520888%2Cidx%3A0" target="_blank"><img src="images/logo_linkedIn.png" alt="Linkedin" height="30px" width="30px" title="Suivez nous sur Linkedin"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="http://www.viadeo.com/fr/company/epegase" target="_blank"><img src="images/logo_viadeo.png" alt="Viadéo" height="30px" width="30px" title="Suivez nous sur Viadéo"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="https://plus.google.com/collection/svYcsB" target="_blank"><img src="images/logo_googlePlus.png" alt="Google+" height="30px" width="30px" title="Suivez nous sur Google+"></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="https://www.youtube.com/channel/UCKUShSPEyINUI7EbYPvVM0g" target="_blank"><img src="images/logo_youtube.png" alt="Chaine Youtube" height="30px" width="40px" title="Chaine Youtube epegase"></a>
            </center>
            <br>
        </h:panelGrid>
    </h:column>
</h:panelGrid>

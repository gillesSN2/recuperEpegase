<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<c:if test="${(bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='')||(bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='accueil')||(bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='espaceClient')}" var="menu" scope="request">
    <rich:dataTable style="background:transparent;border:0px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.menudroitAccueilCtrl.dataModelMenudroitAccueilXmlList}" var="menuAccueil" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
        <rich:column style="border:0px;">
            <f:facet name="header"><h:outputText  styleClass="board_entete" value="A c c u e i l" style=";color:#bc0000"/></f:facet>
            <a4j:commandButton value="#{menuAccueil.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.accueilAction}" rendered="#{menuAccueil.libelle_FR!=null&&menuAccueil.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuAccueil.libelle_FR==null||menuAccueil.libelle_FR==''}"/>
        </rich:column>
    </rich:dataTable>
    <h:panelGrid>
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1}" var="goog">
            <script type="text/javascript" language=javascript>
                (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
                        (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
                ga('create', 'UA-70101324-1', 'auto');
                ga('send', 'pageview');
            </script>
        </c:if>
    </h:panelGrid>
    <br>
    <h:panelGrid width="100%" style="border:0px solid green;height:30px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strAddInto==0}">
        <center>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strAddInto==0}" var="ai">
                <!--a href="http://www.addinto.com/ai/?type=bkmk" onmouseover="ai2display_bkmk(this, '', '', '');" onmouseout="ai2close_bkmk();"><img src="http://www.addinto.com/logos/favoris_partage_v2.gif" alt="AddInto" border="0" /></a><script type="text/javascript" src="http://static.addinto.com/ai/ai2_bkmk.js"></script-->
            </c:if>
        </center>
    </h:panelGrid>
    <br>
    <h:panelGrid width="100%" style="border:0px solid green" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHangout==1}">
        <center>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHangout==1}" var="hg">
                <script src="https://apis.google.com/js/platform.js" async defer type="text/javascript" language=javascript></script>
                <div class="g-hangout" data-render="createhangout"
                     data-initial_apps="[{ app_id : 'AIzaSyBSQDBdEONFM9CSG-WFDFnStBB-FK6Bk9Q', start_data : 'dQw4w9WgXcQ', 'app_type' : 'ROOM_APP' }]">
                </div>
            </c:if>
        </center>
    </h:panelGrid>
    <br>
    <h:panelGrid width="100%" style="border:0px solid green" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strClusterMap==0}">
        <center>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.internetActif>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strClusterMap==0}" var="clmp">
                <script type="text/javascript" src="http://geoloc2.geovisite.ovh/private/geomap.js?compte=670636834784"></script>
                <noscript>
                    <a href="http://www.geovisites.com/fr/directory/informatique_logiciels.php?compte=670636834784"  target="_blank"><img src="http://geoloc2.geovisite.ovh/private/geomap.php?compte=670636834784" border="0" alt="logiciels"></a>
                </noscript>
            </c:if>
        </center>
    </h:panelGrid>
    <center>
        <!--%=request.getAttribute("idUser")%-->
    </center>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='tiers'}" var="tiers" scope="request">
    <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menudroitTiersCtrl.dataModelMenudroitTiersXmlList}" var="menuTiers" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
        <rich:column style="border:0px;">
            <f:facet name="header"><h:outputText  styleClass="board_entete" value="T i e r s" style=";color:#bc0000"/></f:facet>
            <a4j:commandButton value="#{menuTiers.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.tiersAction}" rendered="#{menuTiers.libelle_FR!=null&&menuTiers.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
            <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuTiers.libelle_FR==null||menuTiers.libelle_FR==''}"/>
        </rich:column>
    </rich:dataTable>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree=='free'}" var="free" scope="request">
    <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.menudroitFreeCtrl.dataModelMenudroitFreeXmlList}" var="menuFree" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
        <rich:column style="border:0px;">
            <f:facet name="header"><h:outputText  styleClass="board_entete" value="T r a v a i l" style=";color:#bc0000"/></f:facet>
            <a4j:commandButton value="#{menuFree.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionFree}" rendered="#{menuFree.libelle_FR!=null&&menuFree.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
            <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuFree.libelle_FR==null||menuFree.libelle_FR==''}"/>
        </rich:column>
    </rich:dataTable>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='office'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="office" scope="request">
    <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.menudroitOfficeCtrl.dataModelMenudroitOfficeXmlList}" var="menuOffice" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
        <rich:column style="border:0px;">
            <f:facet name="header"><h:outputText  styleClass="board_entete" value="O f f i c e" style=";color:#bc0000"/></f:facet>
            <a4j:commandButton value="#{menuOffice.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionOffice}" rendered="#{menuOffice.libelle_FR!=null&&menuOffice.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
            <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuOffice.libelle_FR==null||menuOffice.libelle_FR==''}"/>
        </rich:column>
    </rich:dataTable>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='compta'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="compta" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execpt_id==0}" var="vcpte0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execpt_id!=0}" var="vcpte1">
        <rich:dataTable  style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menudroitComptabiliteCtrl.dataModelMenudroitComptabiliteXmlList}" var="menuCompta" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="C o m p t a. : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exoselectionne.execpt_id}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton  value="#{menuCompta.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionComptabilite}" rendered="#{menuCompta.libelle_FR!=null&&menuCompta.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView,pboardb"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuCompta.libelle_FR==null||menuCompta.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='achats'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="achats" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.exoselectionne.exeachId==0}" var="vachs0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.exoselectionne.exeachId!=0}" var="vachs1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menudroitAchatsCtrl.dataModelMenudroitAchatsXmlList}" var="menuAchats" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="A c h a t s  : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.exoselectionne.exeachId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuAchats.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionAchats}" rendered="#{menuAchats.libelle_FR!=null&&menuAchats.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuAchats.libelle_FR==null||menuAchats.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='stock'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="stock" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.exoselectionne.exeachId==0}" var="vstks0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.exoselectionne.exeachId!=0}" var="vstks1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.menudroitStockCtrl.dataModelMenudroitStockXmlList}" var="menuStock" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="S t o c k s  : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.exoselectionne.exeachId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuStock.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionStock}" rendered="#{menuStock.libelle_FR!=null&&menuStock.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuStock.libelle_FR==null||menuStock.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='medical'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="medical" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.exoselectionne.exevteId==0}" var="vmedi0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.exoselectionne.exevteId!=0}" var="vmedi1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.menudroitMedicalCtrl.dataModelMenudroitMedicalXmlList}" var="menuMedical" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="M é d i c a l : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuMedical.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionMedical}" rendered="#{menuMedical.libelle_FR!=null&&menuMedical.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuMedical.libelle_FR==null||menuMedical.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='ventes'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="ventes" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId==0}" var="vvtes0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId!=0}" var="vvtes1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menudroitVentesCtrl.dataModelMenudroitVentesXmlList}" var="menuVentes" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.typeVente==806}">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="T r a n s p o r t  : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuVentes.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionVentes}" rendered="#{menuVentes.libelle_FR!=null&&menuVentes.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuVentes.libelle_FR==null||menuVentes.libelle_FR==''}"/>
            </rich:column>
            <rich:column style="border:0px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.typeVente!=806}">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="V e n t e s  : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuVentes.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionVentes}" rendered="#{menuVentes.libelle_FR!=null&&menuVentes.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuVentes.libelle_FR==null||menuVentes.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='ventesTicket'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="ventesTicket" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId==0}" var="vvtes2">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId!=0}" var="vvtes3">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menudroitVentesCtrl.dataModelMenudroitVentesXmlList}" var="menuVentes" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="V e n t e s  (T): #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuVentes.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionVentesTicket}" rendered="#{menuVentes.libelle_FR!=null&&menuVentes.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,pboardb,idSubView,menuVert,pGMenu"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuVentes.libelle_FR==null||menuVentes.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='ventesInterim'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="ventesInterim" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId==0}" var="vvtes4">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId!=0}" var="vvtes5">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menudroitVentesCtrl.dataModelMenudroitVentesXmlList}" var="menuVentes" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="I n t é r i m  : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuVentes.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionVentesInterim}" rendered="#{menuVentes.libelle_FR!=null&&menuVentes.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuVentes.libelle_FR==null||menuVentes.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='ventesRestaurant'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="restaurant" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId==0}" var="vvtes6">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId!=0}" var="vvtes7">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menudroitVentesCtrl.dataModelMenudroitVentesXmlList}" var="menuVentes" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="Restaurant  : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuVentes.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionRestaurant}" rendered="#{menuVentes.libelle_FR!=null&&menuVentes.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuVentes.libelle_FR==null||menuVentes.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='ventesHotelerie'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="hotelerie" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId==0}" var="vvtes8">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId!=0}" var="vvtes9">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.menudroitVentesCtrl.dataModelMenudroitVentesXmlList}" var="menuVentes" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="Hôtelerie  : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuVentes.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionHotelerie}" rendered="#{menuVentes.libelle_FR!=null&&menuVentes.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuVentes.libelle_FR==null||menuVentes.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='parcs'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="parcs" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.exoselectionne.exeprcId==0}" var="vprc0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.exoselectionne.exeprcId!=0}" var="vprc1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.menudroitParcCtrl.dataModelMenudroitParcsXmlList}" var="menuParcs" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="P a r c s  : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanParcs.exoselectionne.exeprcId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuParcs.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionParcs}" rendered="#{menuParcs.libelle_FR!=null&&menuParcs.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuParcs.libelle_FR==null||menuParcs.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='paye'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="paye" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.exoselectionne.exepayId==0}" var="vpay0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.exoselectionne.exepayId!=0}" var="vpay1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.menudroitPayeCtrl.dataModelMenudroitPayeXmlList}" var="menuPaye" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="P a y e  : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.exoselectionne.exepayId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuPaye.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionPaye}" rendered="#{menuPaye.libelle_FR!=null&&menuPaye.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuPaye.libelle_FR==null||menuPaye.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='caisse'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="caisse" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.exoselectionne.execaiId==0}" var="vcais0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.exoselectionne.execaiId!=0}" var="vcais1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menudroitCaisseCtrl.dataModelMenudroitCaisseXmlList}" var="menuCaisse" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="T r é s o. : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.exoselectionne.execaiId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuCaisse.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionCaisse}" rendered="#{menuCaisse.libelle_FR!=null&&menuCaisse.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuCaisse.libelle_FR==null||menuCaisse.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='education'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="education" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.exoselectionne.exevteId==0}" var="veduc0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.exoselectionne.exevteId!=0}" var="veduc1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.menudroitEducationCtrl.dataModelMenudroitEducationXmlList}" var="menuEducation" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="E d u c a t i o n : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanEducation.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuEducation.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionEducation}" rendered="#{menuEducation.libelle_FR!=null&&menuEducation.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuEducation.libelle_FR==null||menuEducation.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='immobilierLocation'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="immobilierLocation" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId==0}" var="vimmo0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId!=0}" var="vimmo1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menudroitLocationCtrl.dataModelMenudroitLocationXmlList}" var="menuLocation" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="L o c a t i o n : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuLocation.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionLocation}" rendered="#{menuLocation.libelle_FR!=null&&menuLocation.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuLocation.libelle_FR==null||menuLocation.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='immobilierSyndic'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="immobilierSyndic" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId==0}" var="vimmo2">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId!=0}" var="vimmo3">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menudroitSyndicCtrl.dataModelMenudroitSyndicXmlList}" var="menuSyndic" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="S y n d i c : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuSyndic.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionSyndic}" rendered="#{menuSyndic.libelle_FR!=null&&menuSyndic.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuSyndic.libelle_FR==null||menuSyndic.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='immobilierNegoce'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="immobilierNegoce" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId==0}" var="vimmo4">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId!=0}" var="vimmo5">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menudroitNegoceCtrl.dataModelMenudroitNegoceXmlList}" var="menuNegoce" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="N e g o c e : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuNegoce.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionNegoce}" rendered="#{menuNegoce.libelle_FR!=null&&menuNegoce.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuNegoce.libelle_FR==null||menuNegoce.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='immobilierPromoteur'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="immobilierPromoteur" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId==0}" var="vimmo6">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId!=0}" var="vimmo7">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.menudroitPromoteurCtrl.dataModelMenudroitPromoteurXmlList}" var="menuPromoteur" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="Promoteur : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanImmobilier.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuPromoteur.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionPromoteur}" rendered="#{menuPromoteur.libelle_FR!=null&&menuPromoteur.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuPromoteur.libelle_FR==null||menuPromoteur.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='temple'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="temple" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTemple.exoselectionne.exevteId==0}" var="vtmp0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTemple.exoselectionne.exevteId!=0}" var="vtmp1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTemple.menudroitTempleCtrl.dataModelMenudroitTempleXmlList}" var="menuTemple" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="T E M P L E : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTemple.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuTemple.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionTemple}" rendered="#{menuTemple.libelle_FR!=null&&menuTemple.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuTemple.libelle_FR==null||menuTemple.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='politburo'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="politburo" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPartiPolitique.exoselectionne.exevteId==0}" var="vpbu0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPartiPolitique.exoselectionne.exevteId!=0}" var="vpbu1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPartiPolitique.menudroitPartiPolitiqueCtrl.dataModelMenudroitPartiPolitiqueXmlList}" var="menuPolitburo" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="PolitBuro : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPartiPolitique.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuPolitburo.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionPolitBuro}" rendered="#{menuPolitburo.libelle_FR!=null&&menuPolitburo.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuPolitburo.libelle_FR==null||menuPolitburo.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='microfinance'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="politburo" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.exoselectionne.exevteId==0}" var="vpbu0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.exoselectionne.exevteId!=0}" var="vpbu1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.menudroitMicroFinanceCtrl.dataModelMenudroitMicroFinanceXmlList}" var="menuMicrofinance" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="Microfinance : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMicroFinance.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuMicrofinance.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionMicrofinance}" rendered="#{menuMicrofinance.libelle_FR!=null&&menuMicrofinance.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuMicrofinance.libelle_FR==null||menuMicrofinance.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='fondation'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="fondation" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.exoselectionne.exevteId==0}" var="vpbu0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.exoselectionne.exevteId!=0}" var="vpbu1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.menudroitFondationCtrl.dataModelMenudroitVentesXmlList}" var="menuFondation" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="Fondation : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuFondation.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionFondation}" rendered="#{menuFondation.libelle_FR!=null&&menuFondation.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuFondation.libelle_FR==null||menuFondation.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='foret'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="foret" scope="request">
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.exoselectionne.exevteId==0}" var="vpbu0">
        <jsp:include flush="true" page="/exerciceAbsent.jsp" />
    </c:if>
    <c:if scope="request" test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.exoselectionne.exevteId!=0}" var="vpbu1">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.menudroitForetCtrl.dataModelMenudroitForetXmlList}" var="menuForet" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="F o r e t : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanForet.exoselectionne.exevteId}" style=";color:#bc0000"/></f:facet>
                <a4j:commandButton value="#{menuForet.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionForet}" rendered="#{menuForet.libelle_FR!=null&&menuForet.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuForet.libelle_FR==null||menuForet.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
    </c:if>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='reporting'&&bakingbeanepegase.menuModuleHorizontalCtrl.moduleFree!='free'}" var="reporting" scope="request">
    <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanReporting.menudroitReportingCtrl.dataModelMenudroitReportingXmlList}" var="menuReporting" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
        <rich:column style="border:0px;">
            <f:facet name="header"><h:outputText  styleClass="board_entete" value="REPORTING" style=";color:#bc0000"/></f:facet>
            <a4j:commandButton value="#{menuReporting.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionReporting}" rendered="#{menuReporting.libelle_FR!=null&&menuReporting.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
            <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuReporting.libelle_FR==null||menuReporting.libelle_FR==''}"/>
        </rich:column>
    </rich:dataTable>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='guest'}" var="guest" scope="request">
    <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAccueil.menudroitGuestCtrl.dataModelMenudroitGuestXmlList}" var="menuGuest" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
        <rich:column style="border:0px;">
            <f:facet name="header"><h:outputText  styleClass="board_entete" value="G U E S T" style=";color:#bc0000"/></f:facet>
            <a4j:commandButton value="#{menuGuest.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionGuest}" rendered="#{menuGuest.libelle_FR!=null&&menuGuest.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"reRender="modAttente,idSubView"/>
            <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuGuest.libelle_FR==null||menuGuest.libelle_FR==''}"/>
        </rich:column>
    </rich:dataTable>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='admin'}" var="admin" scope="request">
    <h:panelGrid width="100%">
        <rich:dataTable styleClass="lienthaut" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menudroitAdministrationCtrl.dataModelMenudroitAdministrationXmlList}" var="menuAdmin" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="Administration" style=";color:#bc0000"/></f:facet>
                <h:commandButton value="#{menuAdmin.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.administrationAction}" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{menuAdmin.libelle_FR!=null&&menuAdmin.libelle_FR!=''&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet==0||bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet>=6}"/>
                <h:commandButton value="#{menuAdmin.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.administrationAction}" onclick="javascript:Richfaces.showModalPanel('panelBarUtil');" rendered="#{menuAdmin.libelle_FR!=null&&menuAdmin.libelle_FR!=''&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet>=1&&bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet<=5}"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuAdmin.libelle_FR==null||menuAdmin.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
        <h:commandButton value="RETOUR EXPLOITATION" styleClass="admin_lien_retour" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdmnistration}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
    </h:panelGrid>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='coadmin'}" var="coadmin" scope="request">
    <h:panelGrid width="100%">
        <rich:dataTable styleClass="lienthaut" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.menudroitCoAdministrationCtrl.dataModelMenudroitCoAdministrationXmlList}" var="menuCoAdmin" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="Co-Administration" style=";color:#bc0000"/></f:facet>
                <h:commandButton value="#{menuCoAdmin.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.coAdministrationAction}" rendered="#{menuCoAdmin.libelle_FR!=null&&menuCoAdmin.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuCoAdmin.libelle_FR==null||menuCoAdmin.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
        <h:commandButton value="RETOUR EXPLOITATION" styleClass="admin_lien_retour" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdmnistration}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
    </h:panelGrid>
</c:if>
<c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='systeme'}" var="systeme" scope="request">
    <h:panelGrid width="100%">
        <rich:dataTable style="background:transparent;border:0px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanSysteme.menudroitSystemCtrl.dataModelMenudroitSystemeXmlList}" var="menuSystem" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
            <rich:column style="border:0px;">
                <f:facet name="header"><h:outputText  styleClass="board_entete" value="S Y S T E M E" style=";color:#bc0000"/></f:facet>
                <h:commandButton value="#{menuSystem.libelle_FR}" styleClass="board_accueil_menu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.gestionSystem}" rendered="#{menuSystem.libelle_FR!=null&&menuSystem.libelle_FR!=''}" onclick="javascript:Richfaces.showModalPanel('panelBarSysteme');"/>
                <a4j:commandButton value="--------------------------------------------" styleClass="board_accueil_menu" rendered="#{menuSystem.libelle_FR==null||menuSystem.libelle_FR==''}"/>
            </rich:column>
        </rich:dataTable>
        <h:commandButton value="RETOUR EXPLOITATION" styleClass="admin_lien_retour" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.retourAdmnistration}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
    </h:panelGrid>
</c:if>
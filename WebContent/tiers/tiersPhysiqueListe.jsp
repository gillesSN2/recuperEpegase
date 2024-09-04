<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>

<f:subview id="tiersPhys">

    <a4j:form id="formTiersPhys"
              rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==0}">

        <center><h2><h:outputText styleClass="titre"
                                  value="GESTION : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.libelleSousMenu}"/></h2>
        </center>

        <h:panelGrid columns="1" width="100%" id="recherche" styleClass="recherche">
            <h:panelGrid columns="15" width="100%">
                <a4j:commandButton title="Plus de critères..." image="/images/rechercher.png"
                                   action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.moreSearch}"
                                   reRender="recherche"
                                   rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_more_search}"/>
                <a4j:commandButton title="Moins de critères..." image="/images/rechercher.png"
                                   action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.moreSearch}"
                                   reRender="recherche"
                                   rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_more_search}"/>
                <h:column><h:outputText value="Nom:"/></h:column>
                <h:column><h:inputText style="width:150px;"
                                       value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nomRec}"/></h:column>
                <h:column
                        rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='2'}"><h:outputText
                        value="Prénom:"/></h:column>
                <h:column
                        rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='2'}"><h:inputText
                        style="width:150px;"
                        value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.prenomRec}"/></h:column>
                <h:column><h:outputText value="Ville:"/></h:column>
                <h:column><h:inputText style="width:150px;"
                                       value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.villeRec}"/></h:column>
                <h:column>
                    <h:selectOneMenu id="paysItem"
                                     value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.paysRec}"
                                     style="width:130px;">
                        <f:selectItem itemLabel="Tous pays" itemValue="100"/>
                        <f:selectItems
                                value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesPaysItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="aciviteItem"
                                     value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.activitesRec}"
                                     style="width:130px;">
                        <f:selectItem itemLabel="Tous métiers" itemValue="100"/>
                        <f:selectItem itemLabel="Sans métier" itemValue="****"/>
                        <f:selectItems
                                value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesActivitesSocietesItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column
                        rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='2'}">
                    <h:selectOneMenu id="obsItem"
                                     value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.observationsRec}"
                                     style="width:130px;">
                        <f:selectItem itemLabel="Toutes observations" itemValue="100"/>
                        <f:selectItems
                                value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesObservationsItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="conseillersItem"
                                     value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.conseillersRec}"
                                     style="width:130px;">
                        <f:selectItem itemLabel="Tous conseillers" itemValue="0"/>
                        <f:selectItem itemLabel="Sans conseiller" itemValue="99999999"/>
                        <f:selectItems
                                value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesUserItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column
                        rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='2'}">
                    <h:selectOneMenu id="appreciationItem"
                                     value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.appreciationRec}"
                                     style="width:130px;">
                        <f:selectItem itemLabel="Toutes appréciations" itemValue="100"/>
                        <f:selectItems
                                value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesAppreciationsItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column
                        rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='2'}">
                    <h:selectOneMenu id="evenementItem"
                                     value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.evenementRec}"
                                     style="width:130px;">
                        <f:selectItem itemLabel="Hors événement" itemValue="100"/>
                        <f:selectItem itemLabel="Sans événement" itemValue="101"/>
                        <f:selectItems
                                value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesEvenementsItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER"
                                       action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.chargerLesTiers}"
                                       onclick="javascript:Richfaces.showModalPanel('modAttente');"
                                       oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                                       reRender="modAttente,btnTiers,scrollTable,tableTiers"/>
                    <rich:hotKey key="return" handler="#{rich:element('idValRecherche')}.click()"/>
                </h:column>
            </h:panelGrid>
            <h:panelGrid columns="13" width="100%"
                         rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_more_search}">
                <h:column>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='2'}"
                          var="lit1">
                        <h:selectOneMenu id="litigeItem"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.compteLitige}"
                                         style="width:130px;">
                            <f:selectItem itemLabel="Sans litige" itemValue="0"/>
                            <f:selectItem itemLabel="Compte à surveiller" itemValue="1"/>
                            <f:selectItem itemLabel="Compte bloqué" itemValue="2"/>
                            <f:selectItem itemLabel="Chèque interdit" itemValue="3"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='2'}"
                          var="lit2">
                        <h:selectOneMenu id="origineItem"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.origineRec}"
                                         style="width:130px;">
                            <f:selectItem itemLabel="Toutes origines" itemValue="100"/>
                            <f:selectItem itemLabel="Local" itemValue="0"/>
                            <f:selectItem itemLabel="Etranger" itemValue="1"/>
                        </h:selectOneMenu>
                    </c:if>
                </h:column>
                <h:column>
                    <h:selectOneMenu id="inactifItem"
                                     value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.inpInactif}"
                                     style="width:130px;">
                        <f:selectItem itemLabel="Actif" itemValue="0"/>
                        <f:selectItem itemLabel="Inactif (Gelé)" itemValue="1"/>
                        <f:selectItem itemLabel="Supprimer" itemValue="2"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='2'}"
                          var="cat1">
                        <h:selectOneMenu id="categorieItem"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.categorieRec}"
                                         style="width:130px;">
                            <f:selectItem itemLabel="Toutes catégories" itemValue="100"/>
                            <f:selectItems
                                    value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesCategoriesItems}"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='2'}"
                          var="cat2">
                        <h:selectOneMenu id="centreInteretItem"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.centreInteretRec}"
                                         style="width:130px;">
                            <f:selectItem itemLabel="Tous centres d`interet" itemValue="100"/>
                            <f:selectItems
                                    value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mesCentresIntereItems}"/>
                        </h:selectOneMenu>
                    </c:if>
                </h:column>
                <h:column>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers==0}">
                        <h:selectOneMenu id="familleItem1"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.familleRec}"
                                         style="width:130px;">
                            <f:selectItem itemLabel="Toutes familles" itemValue="100"/>
                            <f:selectItems
                                    value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesFamilleFournisseursItems}"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='2'}"
                          var="fam1">
                        <h:selectOneMenu id="familleItem2"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.familleRec}"
                                         style="width:130px;">
                            <f:selectItem itemLabel="Toutes familles" itemValue="100"/>
                            <f:selectItems
                                    value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesFamilleClientsItems}"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='2'}"
                          var="fam2">
                        <h:selectOneMenu id="sitMatItem"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.sitMatRec}"
                                         style="width:130px;">
                            <f:selectItem itemLabel="Toutes situations matrimonaiales" itemValue="100"/>
                            <f:selectItem itemLabel="Non renseigné" itemValue="0"/>
                            <f:selectItem itemLabel="Célibataire" itemValue="1"/>
                            <f:selectItem itemLabel="Marié(e)" itemValue="2"/>
                            <f:selectItem itemLabel="Concubin(e)" itemValue="3"/>
                            <f:selectItem itemLabel="Divorcé(e)" itemValue="4"/>
                            <f:selectItem itemLabel="Veuf(ve)" itemValue="5"/>
                        </h:selectOneMenu>
                    </c:if>
                </h:column>
                <h:column
                        rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.abnExist}">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='2'}"
                          var="pdv1">
                        <h:selectOneMenu id="pdvItem"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.pdvRec}"
                                         style="width:130px;">
                            <f:selectItem itemLabel="Tous PDV" itemValue="100"/>
                            <f:selectItems
                                    value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesPdvItems}"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='2'}"
                          var="pdv2">

                    </c:if>
                </h:column>
                <h:column
                        rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.abnExist}">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type!='2'}"
                          var="reg1">
                        <h:selectOneMenu id="regItem"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.regRec}"
                                         style="width:130px;">
                            <f:selectItem itemLabel="Toutes Régions" itemValue="100"/>
                            <f:selectItems
                                    value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.mesRegionsItems}"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='2'}"
                          var="reg2">

                    </c:if>
                </h:column>
                <h:column
                        rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='2'}"><h:outputText
                        value="Observation:"/></h:column>
                <h:column
                        rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ligneMenu.type=='2'}"><h:inputText
                        style="width:150px;"
                        value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.observationsDirectRec}"/></h:column>
                <h:column><h:outputText value="eMail:"/></h:column>
                <h:column><h:inputText style="width:150px;"
                                       value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.mailRec}"/></h:column>
                <h:column><h:outputText value="Téléphone:"/></h:column>
                <h:column><h:inputText style="width:150px;"
                                       value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.telRec}"/></h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid columns="15" width="550px" id="btnTiers" style="height:34">
            <a4j:commandButton image="/images/ajouter.png" title="Ajout fiche"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajouterTiers}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/modifier.png" title="Modifier fiche"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.modifierTiers}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/detail.png" title="Consulter fiche"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.consulterTiers}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/supprimer.png" title="Suppression fiche"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}"
                               onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false;javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="btnTiers,scrollTable,tableTiers,modAttente,supTiers"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.supprimerTiers}"/>
            <a4j:commandButton image="/images/print.png" title="Impression"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.initImpression}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption}"
                               reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
            <a4j:commandButton image="/images/mouvementstock.png" title="Documents commerciaux"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.accesDocuments}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers!='9'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/extrait.png" title="Extrait de compte"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.accesExtrait}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers!='9'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/calendrier.png" title="Planning"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.accesPlanning}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/mail.png" title="Messagerie/Courrier"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.accesMail}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,idSubView"/>
            <a4j:commandButton title="Geler la fiche sélectionnée" image="/images/geler.png"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieetat==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gelerTiers}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,tableTiers,btnTiers"/>
            <a4j:commandButton title="Réactiver la fiche sélectionnée" image="/images/degeler.png"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.newtiers.tieetat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.gestionTiers}"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.degelerTiers}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,tableTiers,btnTiers"/>
            <a4j:commandButton image="/images/campagne.png" title="Campagne"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.accesCampagne}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers=='3'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/cadeaux.png" title="Cadeaux"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.accesCadeaux}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption}"
                               onclick="javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,idSubView"/>
            <a4j:commandButton image="/images/parametre.png" title="Transfert en Personne Morale"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.transfererPesPhPersMor}"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers!='9'&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption}"
                               onclick="if (!confirm('Etes-vous sur de vouloir transférer cette personne en société?')) return false;javascript:Richfaces.showModalPanel('modAttente');"
                               oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                               reRender="modAttente,btnTiers,scrollTable,tableTiers"/>
            <a4j:commandButton title="Génération QRCODE" image="/images/qrcode.png" style="height:26px;width:26px"
                               oncomplete="javascript:Richfaces.showModalPanel('panelQrCode');"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.afficheButtOption}"/>
            <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png"
                               style="height:26px;width:26px"
                               rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}"
                               action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.memoriseConfigListeEntete}"
                               onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages"
                                       page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.pageIndex}"
                                       reRender="tableTiers" id="scrollTable" maxPages="20" align="left"
                                       for="tableTiers"/>
                    <rich:extendedDataTable
                            rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_nb_max}"
                            style="max-height:100%;" styleClass="bg" id="tableTiers" border="0" width="160%"
                            footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab"
                            rowClasses="rows1,rows2,rowsd"
                            value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.dataModelSociete}"
                            var="societe" activeRowKey="true" rowKeyVar="rkv"
                            selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.simpleSelectionEntete}"
                            sortMode="multi" selectionMode="single"
                            tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.configListeEntete}"
                            binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange"
                                     action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.selectionTiers}"
                                     onsubmit="javascript:Richfaces.showModalPanel('modAttente');"
                                     oncomplete="javascript:Richfaces.hideModalPanel('modAttente');"
                                     reRender="modAttente,btnTiers"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick"
                                     action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.visualisationTiers}"
                                     reRender="idSubView,btnTiers"/>

                        <rich:column label="Structure" sortable="true" sortBy="#{societe.nomGroupe}" width="80px"
                                     rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strmaitrecabinet=='2'}">
                            <f:facet name="header"><h:outputText value="STR."/></f:facet>
                            <h:outputText value="#{societe.nomGroupe}" style="#{societe.styleCouleur}"
                                          title="#{societe.nomGroupe}"/>
                        </rich:column>
                        <rich:column label="N° Compte" sortable="true" sortBy="#{societe.comptePrincipal}" width="100px"
                                     rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers!='1'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers!='2'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers!='9'}">
                            <f:facet name="header"><h:outputText value="Compte"/></f:facet>
                            <h:outputText value="#{societe.comptePrincipal}" style="#{societe.styleCouleur}"
                                          title="#{societe.comptePrincipal}"/>
                        </rich:column>
                        <rich:column label="Date de création" sortable="true" sortBy="#{societe.tiedatecreat}"
                                     width="80px"
                                     rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers=='2'}">
                            <f:facet name="header"><h:outputText value="Crée le"/></f:facet>
                            <h:outputText value="#{societe.tiedatecreat}" style="#{societe.styleCouleur}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Noms Conseillers" sortable="true" sortBy="#{societe.nomConseiller}"
                                     width="120px"
                                     rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers=='2'}">
                            <f:facet name="header"><h:outputText value="Conseillers"/></f:facet>
                            <h:outputText value="#{societe.nomConseiller}" style="#{societe.styleCouleur}"
                                          title="#{societe.nomConseiller}"/>
                        </rich:column>
                        <rich:column label="Catégorie des tiers" sortable="true" sortBy="#{societe.tiecategorie}"
                                     width="100px">
                            <f:facet name="header"><h:outputText value="Catégorie"/></f:facet>
                            <h:outputText value="#{societe.tiecategorie}" style="#{societe.styleCouleur}"
                                          title="#{societe.tiecategorie}"/>
                        </rich:column>
                        <rich:column label="Sigle" sortable="true" sortBy="#{societe.tiesigle}" width="100px"
                                     rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.chronoActif}">
                            <f:facet name="header"><h:outputText value="Sigle"/></f:facet>
                            <h:outputText value="#{societe.tiesigle}" style="#{societe.styleCouleur}"
                                          title="#{societe.tiesigle}"/>
                        </rich:column>
                        <rich:column label="Civilité" sortable="true" sortBy="#{societe.tiecivilite}" width="100px">
                            <f:facet name="header"><h:outputText value="Civilité"/></f:facet>
                            <h:outputText value="#{societe.tiecivilite}" style="#{societe.styleCouleur}"
                                          title="#{societe.tiecivilite}"/>
                        </rich:column>
                        <rich:column label="Nom" sortable="true" sortBy="#{societe.tieraisonsocialenom}" width="300px"
                                     sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText value="Nom"/></f:facet>
                            <h:outputText value="#{societe.tieraisonsocialenom}" style="#{societe.styleCouleur}"
                                          title="#{societe.tieraisonsocialenom}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{societe.tieprenom}" width="200px">
                            <f:facet name="header"><h:outputText value="Prénom"/></f:facet>
                            <h:outputText value="#{societe.tieprenom}" style="#{societe.styleCouleur}"
                                          title="#{societe.tieprenom}"/>
                        </rich:column>
                        <rich:column label="N° téléphone" sortable="true" sortBy="#{societe.tieburtel1}" width="100px">
                            <f:facet name="header"><h:outputText value="Téléphone"/></f:facet>
                            <h:outputText value="#{societe.tieburtel1}" style="#{societe.styleCouleur}"
                                          title="#{societe.tieburtel1}"/>
                        </rich:column>
                        <rich:column label="Ville" sortable="true" sortBy="#{societe.tieville}" width="100px">
                            <f:facet name="header"><h:outputText value="Ville"/></f:facet>
                            <h:outputText value="#{societe.tieville}" style="#{societe.styleCouleur}"
                                          title="#{societe.tieville}"/>
                        </rich:column>
                        <rich:column label="Pays" sortable="true" sortBy="#{societe.tienompays}" width="100px">
                            <f:facet name="header"><h:outputText value="Pays"/></f:facet>
                            <h:outputText value="#{societe.tienompays}" style="#{societe.styleCouleur}"
                                          title="#{societe.tienompays}"/>
                        </rich:column>
                        <rich:column label="Email" sortable="true" sortBy="#{societe.tiemail1}" width="200px">
                            <f:facet name="header"><h:outputText value="Mail"/></f:facet>
                            <h:outputText value="#{societe.tiemail1}" style="#{societe.styleCouleur}"
                                          title="#{societe.tiemail1}"/>
                        </rich:column>
                        <rich:column label="Observations" sortable="true" sortBy="#{societe.tieobservations}"
                                     width="300px">
                            <f:facet name="header"><h:outputText value="Observations"/></f:facet>
                            <h:outputText value="#{societe.tieobservations}" style="#{societe.styleCouleur}"
                                          title="#{societe.tieobservations}"/>
                        </rich:column>
                        <rich:column label="Famille" sortable="true" sortBy="#{societe.tienomfamille}" width="80px">
                            <f:facet name="header"><h:outputText value="Famille"/></f:facet>
                            <h:outputText value="#{societe.tienomfamille}" style="#{societe.styleCouleur}"
                                          title="#{societe.tienomfamille}"/>
                        </rich:column>
                        <rich:column label="Centre dintéret" sortable="true" sortBy="#{societe.tieinteret}"
                                     width="150px"
                                     rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers=='1'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.typeTiers=='2'}">
                            <f:facet name="header"><h:outputText value="Centres intérêts"/></f:facet>
                            <h:outputText value="#{societe.tieinteret}" style="#{societe.styleCouleur}"
                                          title="#{societe.tieinteret}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>

        <h:panelGroup>
            <center>
                <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Tiers sans incident" style="color:black;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Tiers à surveiller" style="color:blue;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Tiers bloqué ou chéque interdit" style="color:red;"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="Tiers désactivé ou supprimé" style="color:grey;"/>&nbsp;&nbsp;&nbsp;
            </center>
        </h:panelGroup>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent" id="panelImp" headerClass="headerPanel"
                     style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"
                     width="650" height="400" autosized="true"
                     showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalPanelPrint}"
              var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton
                            action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.closeImpression}"
                            image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <rich:hotKey key="return" handler="return false;"/>
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression" style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid width="100%">
                    <h:panelGrid id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc"
                                          value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_choix_modele}">
                            <f:selectItem itemLabel="Tiers séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste des tiers" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect,listeSelect"
                                         event="onchange"
                                         action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.listeDocImp}"/>
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nomModeleDocument}"
                                         rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.affListeDoc}">
                            <f:selectItems
                                    value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%"
                                         value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.nomModeleListe}"
                                         rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.affListeDoc}">
                            <f:selectItems
                                    value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid width="100%" style="border:solid 1px black;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid width="100%" columns="9" style="height:80px">
                            <h:panelGroup
                                    rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png"
                                                     onmouseover="this.src='images/imp_print_big.png'"
                                                     onmouseout="this.src='images/imp_print.png'" value="PRT"
                                                     title="Impression directe (Imprimantes serveur)"
                                                     action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerPRT}"
                                                     onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"
                                                     rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                                    <h:selectOneMenu id="impSelect"
                                                     value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems
                                                value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png"
                                             onmouseover="this.src='images/imp_apercu_big.png'"
                                             onmouseout="this.src='images/imp_apercu.png'" value="JRV"
                                             title="Aperçu avant impression"
                                             action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerJRV}"
                                             onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png"
                                             onmouseover="this.src='images/imp_reader_big.png'"
                                             onmouseout="this.src='images/imp_reader.png'" value="PDF"
                                             title="Format PDF"
                                             action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerPDF}"
                                             onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"
                                             rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png"
                                             onmouseover="this.src='images/imp_openOffice_big.png'"
                                             onmouseout="this.src='images/imp_openOffice.png'" value="ODT"
                                             title="Format OpenOffice"
                                             action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerODT}"
                                             onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"
                                             rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_excel.png"
                                             onmouseover="this.src='images/imp_excel_big.png'"
                                             onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur"
                                             action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerXLS}"
                                             onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"
                                             rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_word.png"
                                             onmouseover="this.src='images/imp_word_big.png'"
                                             onmouseout="this.src='images/imp_word.png'" value="DOC"
                                             title="Traitement de texte"
                                             action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerDOC}"
                                             onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"
                                             rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_html.png"
                                             onmouseover="this.src='images/imp_html_big.png'"
                                             onmouseout="this.src='images/imp_html.png'" value="HTML"
                                             title="Export HTML"
                                             action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerHTML}"
                                             onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"
                                             rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'"
                                             onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML"
                                             action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerXML}"
                                             onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"
                                             rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"/>
                            <h:commandButton image="/images/imp_mail.png"
                                             onmouseover="this.src='images/imp_mail_big.png'"
                                             onmouseout="this.src='images/imp_mail.png'" value="MAIL"
                                             title="Envoie MAIL"
                                             action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.envoieMAIL}"
                                             rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.menutiers.imp}"
                                             onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid width="100%" id="panelMail"
                                 rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.affMail}">
                        <h:panelGrid width="100%" style="border:solid 1px black;background-color:white;" columns="2"
                                     columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%"
                                                 value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impEmetteur}">
                                    <f:selectItems
                                            value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Destinataire:"
                                                    style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%"
                                                 value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impDestinataire}">
                                    <f:selectItems
                                            value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%"
                                                   value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%"
                                                   value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail"
                                             action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.imprimerMAIL}"
                                             rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.affMail}"
                                             id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" id="supTiers" headerClass="headerPanel" width="500" height="200"
                     style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"
                     showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalSupTiers}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.showModalSupTiers}"
              var="spt">
            <f:facet name="header"><h:outputText value="SUPPRESSION DU TIERS"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton
                            action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.fermerSupTiers}"
                            image="/images/close.gif" styleClass="hidelink" reRender="supTiers"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <h:outputText
                            value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.suppressionRejet}"/>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelQrCode"
                     style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"
                     width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionUserQrCode.jsp"/>
    </rich:modalPanel>

</f:subview>
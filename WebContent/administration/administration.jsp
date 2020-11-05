<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="config">

    <center>

        <h:panelGroup id="idChooseAdm">

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.moduleAffiche=='admin'&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixModule==''}" var="lien" scope="request">
                <a4j:form id="form1">
                    <center>
                        <h2>
                            <h:outputText value="ADMINISTRATION-PARAMETRAGE DES MODULES" style="color:green;"/><br>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}" style="color:green;"/>
                        </h2>
                        <rich:dataTable style="background:transparent;" headerClass="headConfig" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.dataModelMenuHorizontal}" var="liste" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                            <rich:column  width="100%">
                                <h:graphicImage url="/images/configuration.png" rendered="#{(menuHorizontal.alert!='')&&(liste.libelle!='Accueil')}"  style="margin-right:20px;margin-left:50px;"/>
                                <a4j:commandButton value="#{liste.libelle}" rendered="#{(menuHorizontal.alert!='')&&(liste.libelle!='Accueil')}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.aiguillageParametre}" style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" reRender="modAttente,idChooseAdm"/>
                            </rich:column>
                        </rich:dataTable>
                    </center>
                </a4j:form>
            </c:if>

            <c:choose>
                <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixModule=='module'}">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==0}" var="testexo0" scope="request">
                        <a4j:form id="form2">
                            <center>
                                <h2>
                                    <h:outputText style="color:green;" value="MODULE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.mods}  "/> <h:outputText rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.selectedExo!='0'}"  style="color:green;"  value=" (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.selectedExo})"/><br>
                                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}" style="color:green;"/>
                                </h2>
                                <rich:dataTable style="background:transparent;border:0px;"  headerClass="headConfig" cellpadding="0" cellspacing="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.dataModelModuleParam}" var="liste" onRowMouseOver="this.style.backgroundColor='#cccccc'" onRowMouseOut="this.style.backgroundColor='#{a4jSkin.tableBackgroundColor}'">
                                    <rich:column style="border:0px;">
                                        <h:graphicImage url="/images/configuration.png" style="margin-right:20px;margin-left:15px;"/>
                                        <a4j:commandButton value="#{liste.libelle}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.aiguillageLigneParam}" style="font-weight:bold;background-color:transparent;border:0px;cursor:pointer;" onclick="javascript:Richfaces.showModalPanel('modAttente');" reRender="modAttente,idChooseAdm"/>
                                    </rich:column>
                                </rich:dataTable>
                            </center>
                            <a4j:commandButton id="idCanMod" value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}" reRender="idChooseAdm"/>
                            <rich:hotKey key="esc" handler="#{rich:element('idCanMod')}.click()" />
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==1}" var="testexo1" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/gestionExercicesCompta.jsp"/>
                        <a4j:form id="formexo1">
                            <center>
                                <h:commandButton value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==2}" var="testexo2" scope="request">
                        <jsp:include flush="true" page="/achats/param/gestionExercicesAchats.jsp"/>
                        <a4j:form id="formexo2">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==3}" var="testexo3" scope="request">
                        <jsp:include flush="true" page="/ventes/param/gestionExercicesVentes.jsp"/>
                        <a4j:form id="formexo3">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==4}" var="testexo4" scope="request">
                        <jsp:include flush="true" page="/medical/param/gestionExercicesMedical.jsp"/>
                        <a4j:form id="formexo4">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==6}" var="testexo6" scope="request">
                        <jsp:include flush="true" page="/parc/param/gestionExercicesParc.jsp"/>
                        <a4j:form id="formexo6">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==7}" var="testexo7" scope="request">
                        <jsp:include flush="true" page="/caisse/param/gestionExercicesCaisse.jsp"/>
                        <a4j:form id="formexo7">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==8}" var="testexo8" scope="request">
                        <jsp:include flush="true" page="/paye/param/gestionExercicesPaye.jsp"/>
                        <a4j:form id="formexo8">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==9}" var="testexo9" scope="request">
                        <jsp:include flush="true" page="/education/param/gestionExercicesEducation.jsp"/>
                        <a4j:form id="formexo9">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==10}" var="testexo10" scope="request">
                        <jsp:include flush="true" page="/immobilier/param/gestionExercicesImmobilier.jsp"/>
                        <a4j:form id="formexo10">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==11}" var="testex11" scope="request">
                        <jsp:include flush="true" page="/interim/param/gestionExercicesInterim.jsp"/>
                        <a4j:form id="formex11">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==12}" var="testex12" scope="request">
                        <jsp:include flush="true" page="/microfinance/param/gestionExercicesMicrofinance.jsp"/>
                        <a4j:form id="formex12">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==13}" var="testex13" scope="request">
                        <jsp:include flush="true" page="/fondation/param/gestionExercicesFondation.jsp"/>
                        <a4j:form id="formex13">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==15}" var="testex15" scope="request">
                        <jsp:include flush="true" page="/foret/param/gestionExercicesForet.jsp"/>
                        <a4j:form id="formex15">
                            <center>
                                <h:commandButton  value="RETOUR" styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourAiguillage}"/>
                            </center>
                        </a4j:form>
                    </c:if>
                </c:when>

                <c:when test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixModule=='moduleLigne'}">
                    <!-- gestion OFFICE -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsOffice'}" var="testm1" scope="request">
                        <jsp:include flush="true" page="/office/param/optionsOffice.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosOffice'}" var="testm2" scope="request">
                        <jsp:include flush="true" page="/office/param/chronoOffice.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='gestionRepertoire'}" var="testm3" scope="request">
                        <jsp:include flush="true" page="/office/param/gestionRepertoire.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesCourrier'}" var="testm333" scope="request">
                        <jsp:include flush="true" page="/office/param/naturesCourrier.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesAffaire'}" var="testm334" scope="request">
                        <jsp:include flush="true" page="/office/param/naturesAffaires.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesRdv'}" var="testm3341" scope="request">
                        <jsp:include flush="true" page="/office/param/naturesRdv.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='sujetRdv'}" var="testm335" scope="request">
                        <jsp:include flush="true" page="/office/param/sujetRdv.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='lieuxRdv'}" var="testm336" scope="request">
                        <jsp:include flush="true" page="/office/param/lieuxRdv.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='budgetRdv'}" var="testm337" scope="request">
                        <jsp:include flush="true" page="/office/param/budgetRdv.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='apportRdv'}" var="testm338" scope="request">
                        <jsp:include flush="true" page="/office/param/apportRdv.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='modeFinRdv'}" var="testm339" scope="request">
                        <jsp:include flush="true" page="/office/param/modeFinRdv.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='delaisRdv'}" var="testm340" scope="request">
                        <jsp:include flush="true" page="/office/param/delaisRdv.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='actionRdv'}" var="testm341" scope="request">
                        <jsp:include flush="true" page="/office/param/actionRdv.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='conclusionRdv'}" var="testm342" scope="request">
                        <jsp:include flush="true" page="/office/param/conclusionRdv.jsp"/>
                    </c:if>
                    <!-- gestion TIERS -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosTiers'}" var="testm222" scope="request">
                        <jsp:include flush="true" page="/tiers/param/chronoTiers.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='devises'}" var="testm4" scope="request">
                        <jsp:include flush="true" page="/tiers/param/devises.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='familleClient'}" var="testm5" scope="request">
                        <jsp:include flush="true" page="/tiers/param/famillesClient.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='familleFournisseur'}" var="testm6" scope="request">
                        <jsp:include flush="true" page="/tiers/param/famillesFournisseur.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='typeReglement'}" var="testm7" scope="request">
                        <jsp:include flush="true" page="/tiers/param/typeReglement.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='reglementClient'}" var="testm8" scope="request">
                        <jsp:include flush="true" page="/tiers/param/reglementClient.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='reglementFournisseur'}" var="testm9" scope="request">
                        <jsp:include flush="true" page="/tiers/param/reglementFournisseur.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='appreciations'}" var="testm10" scope="request">
                        <jsp:include flush="true" page="/tiers/param/appreciations.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='civilites'}" var="testm11" scope="request">
                        <jsp:include flush="true" page="/tiers/param/civilites.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='sources'}" var="testm12" scope="request">
                        <jsp:include flush="true" page="/tiers/param/sourcesTiers.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='categorietiers'}" var="testm13" scope="request">
                        <jsp:include flush="true" page="/tiers/param/typeTiers.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='activitestiers'}" var="testm14" scope="request">
                        <jsp:include flush="true" page="/tiers/param/metiers.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='fonctions'}" var="testm15" scope="request">
                        <jsp:include flush="true" page="/tiers/param/fonctions.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='formesjuridiques'}" var="testm16" scope="request">
                        <jsp:include flush="true" page="/tiers/param/formesJuridiques.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='pays'}" var="testm17" scope="request">
                        <jsp:include flush="true" page="/tiers/param/pays.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='taches'}" var="testm18" scope="request">
                        <jsp:include flush="true" page="/tiers/param/taches.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='banques'}" var="testm171" scope="request">
                        <jsp:include flush="true" page="/tiers/param/banques.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='centreInteret'}" var="testm1712" scope="request">
                        <jsp:include flush="true" page="/tiers/param/centreInteret.jsp"/>
                    </c:if>
                    <!-- gestion ACHATS -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesAchats'}" var="testm19" scope="request">
                        <jsp:include flush="true" page="/achats/param/gestionExercicesAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsAchats'}" var="testm20" scope="request">
                        <jsp:include flush="true" page="/achats/param/optionAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsStocks'}" var="testm21" scope="request">
                        <jsp:include flush="true" page="/achats/param/optionStocks.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosAchats'}" var="testm22" scope="request">
                        <jsp:include flush="true" page="/achats/param/chronoAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='depotsAchats'}" var="testm23" scope="request">
                        <jsp:include flush="true" page="/achats/param/depotAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='taxesAchats'}" var="testm24" scope="request">
                        <jsp:include flush="true" page="/achats/param/taxeAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='positionTarifaire'}" var="testm25" scope="request">
                        <jsp:include flush="true" page="/commun/douanesPosition.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesAchats'}" var="testm26" scope="request">
                        <jsp:include flush="true" page="/achats/param/naturesFamillesProdAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='marques'}" var="testm27" scope="request">
                        <jsp:include flush="true" page="/commun/marques.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='couleur'}" var="testm28" scope="request">
                        <jsp:include flush="true" page="/commun/couleur.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='famillesAchats'}" var="testm29" scope="request">
                        <jsp:include flush="true" page="/achats/param/familleProdAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='suiviCommandesAchats'}" var="testm30" scope="request">
                        <jsp:include flush="true" page="/achats/param/suiviCommandeAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='incoterm'}" var="testm31" scope="request">
                        <jsp:include flush="true" page="/commun/incoterm.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='formulesAchats'}" var="testm32" scope="request">
                        <jsp:include flush="true" page="/achats/param/formuleAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='unites'}" var="testm33" scope="request">
                        <jsp:include flush="true" page="/commun/unite.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='conditionnements'}" var="testm34" scope="request">
                        <jsp:include flush="true" page="/commun/conditionnement.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='fraisTheoAchats'}" var="testm35" scope="request">
                        <jsp:include flush="true" page="/achats/param/fraisTheoAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='processAchats'}" var="testm36" scope="request">
                        <jsp:include flush="true" page="/achats/param/processAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='planBudgetairesAchats'}" var="testm971" scope="request">
                        <jsp:include flush="true" page="/achats/param/plansBudgetairesAchats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='impFournisseursAchats'}" var="testm37" scope="request">
                        <jsp:include flush="true" page="/commun/configImpression.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='habilitationsAchats'}" var="testm38" scope="request">
                        <jsp:include flush="true" page="/commun/habilitation.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='PlanningAvicultureAchats'}" var="testm381" scope="request">
                        <jsp:include flush="true" page="/achats/param/planningAviculture.jsp"/>
                    </c:if>
                    <!-- gestion VENTES -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesVentes'}" var="testm39" scope="request">
                        <jsp:include flush="true" page="/ventes/param/gestionExercicesVentes.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsVentes'}" var="testm40" scope="request">
                        <jsp:include flush="true" page="/ventes/param/optionsVentes.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsVentesCabinet'}" var="testm40" scope="request">
                        <jsp:include flush="true" page="/ventes/param/optionsVentesCabinet.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosVentes'}" var="testm42" scope="request">
                        <jsp:include flush="true" page="/ventes/param/chronoVentes.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosVentesTicket'}" var="testm43" scope="request">
                        <jsp:include flush="true" page="/ventes/param/chronoVentesTicket.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosVentesTransit'}" var="testm42" scope="request">
                        <jsp:include flush="true" page="/ventes/param/chronoVentesTransit.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosVentesCabinet'}" var="testm422" scope="request">
                        <jsp:include flush="true" page="/ventes/param/chronoVentesCabinet.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='taxesVentes'}" var="testm44" scope="request">
                        <jsp:include flush="true" page="/ventes/param/taxesVentes.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesVentes'}" var="testm45" scope="request">
                        <jsp:include flush="true" page="/ventes/param/naturesFamillesProduits.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='famillesVentes'}" var="testm46" scope="request">
                        <jsp:include flush="true" page="/ventes/param/famillesProduitsVentes.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='suiviLivraisonVentes'}" var="testm47" scope="request">
                        <jsp:include flush="true" page="/ventes/param/suiviLivraisonVentes.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='formulesVentes'}" var="testm48" scope="request">
                        <jsp:include flush="true" page="/ventes/param/formulesVentes.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='natureMissions'}" var="testm4825" scope="request">
                        <jsp:include flush="true" page="/ventes/param/naturesMissions.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='modeleVentes'}" var="testm49" scope="request">
                        <jsp:include flush="true" page="/ventes/param/modelesCourriers.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='modeleContrats'}" var="testm50" scope="request">
                        <jsp:include flush="true" page="/ventes/param/modelesContrats.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='modeleDevis'}" var="testm501" scope="request">
                        <jsp:include flush="true" page="/ventes/param/modelesDevis.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='impClientsVentes'}" var="testm51" scope="request">
                        <jsp:include flush="true" page="/commun/configImpression.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='habilitationsVentes'}" var="testm52" scope="request">
                        <jsp:include flush="true" page="/commun/habilitation.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='epublicationVentes'}" var="testm53" scope="request">
                        <jsp:include flush="true" page="/ventes/param/publicationProduits.jsp"/>
                    </c:if>
                    <!-- gestion MEDICAL -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesMedical'}" var="testm54" scope="request">
                        <jsp:include flush="true" page="/medical/param/gestionExercicesMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsMedical'}" var="testm55" scope="request">
                        <jsp:include flush="true" page="/medical/param/optionMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosMedical'}" var="testm56" scope="request">
                        <jsp:include flush="true" page="/medical/param/chronoMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='protocolesMedical'}" var="testm57" scope="request">
                        <jsp:include flush="true" page="/medical/param/protocolesMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='motifEntreeConsultMedical'}" var="testm58" scope="request">
                        <jsp:include flush="true" page="/medical/param/motifEntreeConsultMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='antecedentMedical'}" var="testm59" scope="request">
                        <jsp:include flush="true" page="/medical/param/antecedentCDA.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='taxesMedical'}" var="testm60" scope="request">
                        <jsp:include flush="true" page="/medical/param/taxesmedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesMedical'}" var="testm61" scope="request">
                        <jsp:include flush="true" page="/medical/param/naturesFamillesProduitsMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='famillesMedical'}" var="testm62" scope="request">
                        <jsp:include flush="true" page="/medical/param/familleProduitMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='produitsMedical'}" var="testm63" scope="request">
                        <jsp:include flush="true" page="/medical/param/produitsExamen.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='lettresMedical'}" var="testm64" scope="request">
                        <jsp:include flush="true" page="/medical/param/lettre.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='pathologieMedical'}" var="testm65" scope="request">
                        <jsp:include flush="true" page="/medical/param/pathologieMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='elementsInfirmerieMedical'}" var="testm651" scope="request">
                        <jsp:include flush="true" page="/medical/param/medicalElementInfirmerie.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='motifEntreeMedical'}" var="testm66" scope="request">
                        <jsp:include flush="true" page="/medical/param/medicalMotifEntree.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='provenancesMedical'}" var="testm67" scope="request">
                        <jsp:include flush="true" page="/medical/param/medicalProvenance.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='motifSortieMedical'}" var="testm68" scope="request">
                        <jsp:include flush="true" page="/medical/param/medicalMotifSortie.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='destinationsMedical'}" var="testm69" scope="request">
                        <jsp:include flush="true" page="/medical/param/medicalDestination.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='categorieExamens'}" var="testm699" scope="request">
                        <jsp:include flush="true" page="/medical/param/medicalCategorieExamen.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='specialitesdical'}" var="testm70" scope="request">
                        <jsp:include flush="true" page="/medical/param/specialitesMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='cmdMedical'}" var="testm71" scope="request">
                        <jsp:include flush="true" page="/medical/param/cmdMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='cimMedical'}" var="testm72" scope="request">
                        <jsp:include flush="true" page="/medical/param/cimMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='ccamMedical'}" var="testm73" scope="request">
                        <jsp:include flush="true" page="/medical/param/ccamMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='ngapMedical'}" var="testm74" scope="request">
                        <jsp:include flush="true" page="/medical/param/ngapMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='camMedical'}" var="testm75" scope="request">
                        <jsp:include flush="true" page="/medical/param/cmaMedical.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='medicamment'}" var="testm76" scope="request">
                        <jsp:include flush="true" page="/medical/param/medicamment.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='commissionsMedical'}" var="testm77" scope="request">
                        <jsp:include flush="true" page="/medical/param/commissionsMedecinsInit.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='tauxCnamgs'}" var="testm781" scope="request">
                        <jsp:include flush="true" page="/medical/param/tauxCnamgs.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='impMedical'}" var="testm78" scope="request">
                        <jsp:include flush="true" page="/commun/configImpression.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='habilitationsMedical'}" var="testm79" scope="request">
                        <jsp:include flush="true" page="/commun/habilitation.jsp"/>
                    </c:if>
                    <!-- gestion CAISSE -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesCaisse'}" var="testm80" scope="request">
                        <jsp:include flush="true" page="/caisse/param/gestionExercicesCaisse.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsCaisse'}" var="testm81" scope="request">
                        <jsp:include flush="true" page="/caisse/param/optionsCaisses.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosCaisse'}" var="testm82" scope="request">
                        <jsp:include flush="true" page="/caisse/param/chronoCaisses.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='listeCaisse'}" var="testm83" scope="request">
                        <jsp:include flush="true" page="/caisse/param/caissesCommerciales.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='listeOperations'}" var="testm84" scope="request">
                        <jsp:include flush="true" page="/caisse/param/caissesOperations.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='impCaisse'}" var="testm85" scope="request">
                        <jsp:include flush="true" page="/commun/configImpression.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='habilitationsCaisse'}" var="testm86" scope="request">
                        <jsp:include flush="true" page="/commun/habilitation.jsp"/>
                    </c:if>
                    <!-- gestion COMPTABILITE -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesCompta'}" var="testm87" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/gestionExercicesCompta.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsCompta'}" var="testm88" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/optionsComptabilite.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosCompta'}" var="testm89" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/chronoCompta.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='natureComptesCompta'}" var="testm90" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/natureCompte.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='natureJournauxCompta'}" var="testm91" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/natureJournauxComptable.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='racinesCompta'}" var="testm92" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/racinesComptable.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='planComptablesCompta'}" var="testm93" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/plansComptables.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='journauxComptablesCompta'}" var="testm94" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/journauxComptableList.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='localisationImmobilisation'}" var="testm941" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/localisationImmobilisationList.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='modelesEcritures'}" var="testm942" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/ecrituresModelesList.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='planAnalytiqueCompta'}" var="testm96" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/plansAnalytiques.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='planBudgetairesCompta'}" var="testm97" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/plansBudgetaires.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='planTresorerieCompta'}" var="testm98" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/plansTresorerieInit.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='etatFianciersCompta'}" var="testm99" scope="request">
                        <jsp:include flush="true" page="/comptabilite/param/etatFinancierConfigClient.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='impCompta'}" var="testm101" scope="request">
                        <jsp:include flush="true" page="/commun/configImpression.jsp"/>
                    </c:if>
                    <!-- gestion PARC -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesParc'}" var="testm102" scope="request">
                        <jsp:include flush="true" page="/parc/param/gestionExercicesParc.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsParc'}" var="testm103" scope="request">
                        <jsp:include flush="true" page="/parc/param/optionParc.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosParc'}" var="testm104" scope="request">
                        <jsp:include flush="true" page="/parc/param/chronoParc.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesParc'}" var="testm105" scope="request">
                        <jsp:include flush="true" page="/parc/param/natureParc.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='famillesParc'}" var="testm106" scope="request">
                        <jsp:include flush="true" page="/parc/param/famillesParcs.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='caracteristiquesParc'}" var="testm107" scope="request">
                        <jsp:include flush="true" page="/parc/param/caracteristiqueParc.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='motifEntreeParc'}" var="testm108" scope="request">
                        <jsp:include flush="true" page="/parc/param/motifEntreeParc.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='impParc'}" var="testm109" scope="request">
                        <jsp:include flush="true" page="/commun/configImpression.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='transitPortVentes'}" var="testm481" scope="request">
                        <jsp:include flush="true" page="/parc/param/transitPortVentes.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='transitLieuVentes'}" var="testm482" scope="request">
                        <jsp:include flush="true" page="/parc/param/transitLieuVentes.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesManifest'}" var="testm482" scope="request">
                        <jsp:include flush="true" page="/parc/param/natureManifest.jsp"/>
                    </c:if>
                    <!-- gestion PAYE -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesPaye'}" var="testm110" scope="request">
                        <jsp:include flush="true" page="/paye/param/gestionExercicesPaye.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsPaye'}" var="testm111" scope="request">
                        <jsp:include flush="true" page="/paye/param/optionPaye.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosPaye'}" var="testm112" scope="request">
                        <jsp:include flush="true" page="/paye/param/chronoPaye.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesSalarie'}" var="testm113" scope="request">
                        <jsp:include flush="true" page="/paye/param/natureSalarie.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='centresimpots'}" var="testm114" scope="request">
                        <jsp:include flush="true" page="/paye/param/centresImpots.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='centressecuritesociale'}" var="testm1142" scope="request">
                        <jsp:include flush="true" page="/paye/param/centresSecuriteSociale.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='classementagents'}" var="testm115" scope="request">
                        <jsp:include flush="true" page="/paye/param/classementsAgents.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='niveauxemplois'}" var="testm116" scope="request">
                        <jsp:include flush="true" page="/paye/param/niveauxEmplois.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='codesemplois'}" var="testm116" scope="request">
                        <jsp:include flush="true" page="/paye/param/codesEmplois.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='conventionscollectives'}" var="testm117" scope="request">
                        <jsp:include flush="true" page="/paye/param/conventionsCollectives.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='planPaye'}" var="testm118" scope="request">
                        <jsp:include flush="true" page="/paye/param/plansPayes.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='feuilleCalcul'}" var="testm119" scope="request">
                        <jsp:include flush="true" page="/paye/param/feuillesCalcul.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='modelePaye'}" var="testm120" scope="request">
                        <jsp:include flush="true" page="/paye/param/modelesCourriers.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='localisationSalarie'}" var="testm1222" scope="request">
                        <jsp:include flush="true" page="/paye/param/localisationSalarieList.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturePrets'}" var="testm1222" scope="request">
                        <jsp:include flush="true" page="/paye/param/naturePrets.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='natureRH'}" var="testm1227" scope="request">
                        <jsp:include flush="true" page="/paye/param/natureRH.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='etatBilanSocial'}" var="testm135" scope="request">
                        <jsp:include flush="true" page="/paye/param/bilanSocialConfClient.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='impPaye'}" var="testm121" scope="request">
                        <jsp:include flush="true" page="/commun/configImpression.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='habilitationsPaye'}" var="testm122" scope="request">
                        <jsp:include flush="true" page="/commun/habilitation.jsp"/>
                    </c:if>
                    <!-- gestion EDUCATION -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesEducation'}" var="testm123" scope="request">
                        <jsp:include flush="true" page="/education/param/gestionExercicesEducation.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsEducation'}" var="testm124" scope="request">
                        <jsp:include flush="true" page="/education/param/optionsEducation.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosEducation'}" var="testm125" scope="request">
                        <jsp:include flush="true" page="/education/param/chronoEducation.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='filieresEducation'}" var="testm125" scope="request">
                        <jsp:include flush="true" page="/education/param/filieresEducation.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='classementMediatheque'}" var="testm1256" scope="request">
                        <jsp:include flush="true" page="/education/param/classementMediatheque.jsp"/>
                    </c:if>
                    <!-- gestion IMMOBILIER -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesImmobilier'}" var="testm126" scope="request">
                        <jsp:include flush="true" page="/immobilier/param/gestionExercicesImmobilier.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsImmobilier'}" var="testm127" scope="request">
                        <jsp:include flush="true" page="/immobilier/param/optionsImmobilier.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosImmobilier'}" var="testm128" scope="request">
                        <jsp:include flush="true" page="/immobilier/param/chronoImmobilier.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesBiens'}" var="testm129" scope="request">
                        <jsp:include flush="true" page="/immobilier/param/naturesBiensImmobilier.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='impClientsImmobilier'}" var="testm130" scope="request">
                        <jsp:include flush="true" page="/commun/configImpression.jsp"/>
                    </c:if>
                    <!-- gestion INTERIM -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesInterim'}" var="testm131" scope="request">
                        <jsp:include flush="true" page="/interim/param/gestionExercicesInterim.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsInterim'}" var="testm132" scope="request">
                        <jsp:include flush="true" page="/interim/param/optionsInterim.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosInterim'}" var="testm133" scope="request">
                        <jsp:include flush="true" page="/interim/param/chronoInterim.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='naturesInterim'}" var="testm134" scope="request">
                        <jsp:include flush="true" page="/interim/param/naturesInterim.jsp"/>
                    </c:if>
                    <!-- gestion MICROFINANCE -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesMicrofinance'}" var="testm150" scope="request">
                        <jsp:include flush="true" page="/microfinance/param/gestionExercicesMicrofinance.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsMicrofinance'}" var="testm151" scope="request">
                        <jsp:include flush="true" page="/microfinance/param/optionMicrofinance.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosMicrofinance'}" var="testm152" scope="request">
                        <jsp:include flush="true" page="/microfinance/param/chronoMicrofinance.jsp"/>
                    </c:if>
                    <!-- gestion FONDATION -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesFondation'}" var="testm390" scope="request">
                        <jsp:include flush="true" page="/fondation/param/gestionExercicesFondation.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsFondation'}" var="testm391" scope="request">
                        <jsp:include flush="true" page="/fondation/param/optionsFondation.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosFondation'}" var="testm392" scope="request">
                        <jsp:include flush="true" page="/fondation/param/chronoFondation.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='natureDemande'}" var="testm901" scope="request">
                        <jsp:include flush="true" page="/fondation/param/natureDemande.jsp"/>
                    </c:if>
                    <!-- gestion FORET -->
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='exercicesForet'}" var="testm920" scope="request">
                        <jsp:include flush="true" page="/foret/param/gestionExercicesForet.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='optionsForet'}" var="testm921" scope="request">
                        <jsp:include flush="true" page="/foret/param/optionsForet.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chronosForet'}" var="testm922" scope="request">
                        <jsp:include flush="true" page="/foret/param/chronoForet.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='essencesForet'}" var="testm923" scope="request">
                        <jsp:include flush="true" page="/foret/param/essencesForet.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='classementsForet'}" var="testm924" scope="request">
                        <jsp:include flush="true" page="/foret/param/classementsForet.jsp"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.choixLigne=='chantiersForet'}" var="testm925" scope="request">
                        <jsp:include flush="true" page="/foret/param/chantiersForet.jsp"/>
                    </c:if>
                </c:when>
            </c:choose>
        </h:panelGroup>

    </center>


</f:subview>

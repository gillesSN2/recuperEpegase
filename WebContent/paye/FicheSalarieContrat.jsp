<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<h:panelGrid style="width:100%;" id="panContrat">

    <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

        <rich:tab id="tabContrat" label="Contrat">
            <h:panelGrid id="idConfig0" width="100%" >
                <h:panelGrid id="idConfig1" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                    <h:column><h:outputText value="Nature contrat:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType}" disabled="true" readonly="true">
                            <f:selectItem itemLabel="Sélectionnez type contrat" itemValue="100" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.recupererModelesItem}" reRender="panContrat,idModele,idConfig1,idConfig2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Feuille calcul:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idfeuille" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconFeuille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Feuille" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesFeuillesContratItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculeRubriqueContrat}" reRender="idValeurs0,idValeurs1,modMessageCommun"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Date début (JJ/MM/AAAA):"/></h:column>
                    <h:column>
                        <rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateDebut}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <h:selectOneMenu style="width:200px;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEssai}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Contrat normal" itemValue="0" />
                            <f:selectItem itemLabel="Période d`essai" itemValue="1" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Date fin  (JJ/MM/AAAA):" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='11'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='12'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='13'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='14'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='15'}"/></h:column>
                    <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   inputSize="8" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='11'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='12'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='13'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='14'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='15'}"/></h:column>
                    <h:column><h:outputText value="Fonction:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}" maxlength="50"/></h:column>
                    <h:column><h:outputText value="Code emploi:"/></h:column>
                    <h:column>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.afficheCodesEmplois==false}" var="empl1">
                            <h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconCodeEmploi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}" maxlength="10"/>
                        </c:if>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.afficheCodesEmplois==true}" var="empl2">
                            <h:selectOneMenu id="idcodeemploi" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconCodeEmploi}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <f:selectItem itemLabel="Sélectionnez Code emploi" itemValue="0" />
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesCodesEmploisItems}" />
                            </h:selectOneMenu>
                        </c:if>
                    </h:column>
                    <h:column><h:outputText value="Lieu travail:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconLieuTravail}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}" maxlength="50"/></h:column>
                    <h:column><h:outputText value="Nb heure mois (si vide alors heures convention)"/></h:column>
                    <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconNbHeureMois}"/></h:column>
                    <h:column><h:outputText value="Régime congés:"/></h:column>
                    <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconNbJourCp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/>&nbsp;&nbsp;<h:outputText value="(Nb jours congés par mois)"/></h:column>
                    <h:column><h:outputText value="Nb jours travail:"/></h:column>
                    <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconNbJourTr}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/>&nbsp;&nbsp;<h:outputText value="(Nb jour de travail par mois)"/></h:column>
                </h:panelGrid>
                <h:panelGrid id="idConfig2" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05'}">
                    <h:column><h:outputText value="Niveau emploi (cadre?):"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idniveau" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_niveau}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Niveau emploi" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNiveauxEmploisItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Classement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idclassement" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_classement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Classement" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClassementsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Centre Impôt:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idcentre" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_centre}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Centre impôt" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesCentresImpotsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Centre Sécurité Sociale:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1}"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idsecuriSoc" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_securite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strNumSecuMultiple==1}">
                            <f:selectItem itemLabel="Sélectionnez Centre sécurité sociale" itemValue="" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesCentresSecuritesItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Convention:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idconvention" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_convention}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Convention" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesConventionsItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.chargerGrille}" reRender="idConfig2,idgrille"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Catégorie salariale:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idgrille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_grille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Grille" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesGrillesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculGrille}" reRender="idConfig0,idConfig2,idgrille,idValeurs0,idValeurs1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='11'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='13'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='14'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='15'}" var="ctr0">
                    <h:panelGrid id="idValeurs0" columns="4" styleClass="fichefournisseur" columnClasses="clos35d,clos15,clos35d,clos15" width="100%">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_forfaitPrestataire}"><h:outputText value="Forfait:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_forfaitPrestataire}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconBase}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_redement}"><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_redement}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeRendement}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_responsbilite}"><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_responsbilite}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeResponsabilite}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_fonction}"><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_fonction}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeFonction}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>

                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_prm_transport}"><h:outputText value="Prime Transport:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_prm_transport}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeTransport}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_prm_logement}"><h:outputText value="Prime Logement:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_prm_logement}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeLogement}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>

                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_deplacement}"><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_deplacement}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteDeplacement}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_kilometre}"><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_kilometre}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteKilometrique}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_salissure}"><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_salissure}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteSalissure}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_representation}"><h:outputText value="Indemnité de représentation:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_representation}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteRepresentation}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_diverse}"><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_diverse}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteDiverse}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_indemResons}"><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_indemResons}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteResponsabilite}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nourriture}"><h:outputText value="Indemnité de nourriture:" style="text-align:right;"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nourriture}">
                            <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteNourriture}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='12'}" var="ctr1">
                    <h:panelGrid id="idValeurs1" styleClass="fichefournisseur" width="100%">
                        <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05'}"><h:outputText value="Base mensuelle conventionnée:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05'}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconBase}" disabled="true">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I'}"><h:outputText value="Base horaire conventionnée:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I'}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconBase}" disabled="true">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_sursalaire&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05')}"><h:outputText value="Sursalaire mensuel:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_sursalaire&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05')}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconSursalaire}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_sursalaire&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I')}"><h:outputText value="Sursalaire mensuel:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_sursalaire&&(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I')}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconSursalaire}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </h:column>  
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_forfaitHeureSup}"><h:outputText value="Forfait heures sup.:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_forfaitHeureSup}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconForfaitSup}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_outillage}"><h:outputText value="Prime outillage:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_outillage}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeOutillage}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_astreinte}"><h:outputText value="Prime d'astreinte:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_astreinte}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeAstreinte}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_redement}"><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_redement}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeRendement}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_responsbilite}"><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_responsbilite}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeResponsabilite}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_fonction}"><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_fonction}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeFonction}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_sujetion}"><h:outputText value="Prime Sujetion:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_sujetion}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeSujetion}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_exceptionnel}"><h:outputText value="Prime Exceptionnelle fixe:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_exceptionnel}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeExceptionnelle}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_caisse}"><h:outputText value="Indemnité Caisse:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_caisse}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteCaisse}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_transport}"><h:outputText value="Indemnité Transport:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_transport}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteTransport}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_logement}"><h:outputText value="Indemnité Logement:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_logement}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteLogement}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_deplacement}"><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_deplacement}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteDeplacement}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_kilometre}"><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_kilometre}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteKilometrique}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_salissure}"><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_salissure}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteSalissure}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_representation}"><h:outputText value="Indemnité de représentation:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_representation}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteRepresentation}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_diverse}"><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_diverse}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteDiverse}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_indemResons}"><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_indemResons}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteResponsabilite}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nourriture}"><h:outputText value="Indemnité de nourriture:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_nourriture}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteNourriture}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                        <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_logement}"><h:outputText value="Avt. nat. logement:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_logement}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnLogement}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_domesticite}"><h:outputText value="Avt. nat. Domesticité:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_domesticite}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnDomesticite}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_eau}"><h:outputText value="Avt. nat. Eau:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_eau}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnEau}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_electricite}"><h:outputText value="Avt. nat. Electricité:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_electricite}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnElectricite}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_nourriture}"><h:outputText value="Avt. nat. nourriture:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_nourriture}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnNourriture}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_vehicule}"><h:outputText value="Avt. nat. véhicule :" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_vehicule}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnVehicule}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_telephone}"><h:outputText value="Avt. nat. Téléphone:" style="text-align:right;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_avn_telephone}">
                                <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnTelephone}"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                </c:if>
            </h:panelGrid>
        </rich:tab>

        <rich:tab id="tabImput" label="Imputation">
            <h:panelGrid id="idConfig3" columns="2" styleClass="fichefournisseur" columnClasses="clos20,clos80" width="100%" >
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}"><h:outputText value="Société:" style="text-decoration:underline;"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.accesInterim}">
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_tiers}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Société" itemValue="0"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesTiersItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_service}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Service" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesServiceItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_activite}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Activité" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesActiviteItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelDecoupageActivtes}" var="saisieAnal">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.selectionAnalytique}"/>
                            <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                <h:selectOneMenu value="#{saisieAnal.zoneActivite}">
                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.laColonne1Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.valideColonne1}" />
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                <h:selectOneMenu value="#{saisieAnal.zoneAnal1}">
                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.laColonne2Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.valideColonne2}" />
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                <h:selectOneMenu value="#{saisieAnal.zoneAnal3}">
                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.laColonne3Items}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.valideColonne3}" />
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="%"  width="15%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                    <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.controleEcartAnalytique}" reRender="idTableAnal" />
                                </h:inputText>
                            </rich:column>
                            <rich:column label="Supprimer répartition"  width="5%" style="text-align:center;">
                                <a4j:commandButton eventsQueue="maQueue" immediate="true" image="/images/supprimer.png" style="width:17px;height:17px;" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.supprimerAnalytique}" reRender="idTableAnal"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:column>
                <h:column><h:outputText value="Localisation:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_localisation}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans localisation" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesLocalisationItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}"><h:outputText value="Projet:" style="text-decoration:underline;"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}">
                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_projet}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Projet" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesProjetItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Budget:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu id="idbuget" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_budget}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Budget" itemValue="100" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesBudgetItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu id="idcle1" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_cle1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Cle1" itemValue="100" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu id="idcle2" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_cle2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Cle2" itemValue="100" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Véhicule:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans véhicule" itemValue="0"/>
                        <f:selectItem itemLabel="Véhicule personnel au forfait" itemValue="1"/>
                        <f:selectItem itemLabel="Véhicule personnel au Km" itemValue="2"/>
                        <f:selectItem itemLabel="Véhicule entreprise" itemValue="3"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idConfig3,v0,v1,v2,v3,v4,v5,v6;v7"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column id="v0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==0}"></h:column>
                <h:column id="v1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==0}"></h:column>
                <h:column id="v3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==1}"><h:outputText value="Montant remboursé au forfait:"/></h:column>
                <h:column id="v4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==2}"><h:outputText value="Montant remboursé au Km:"/></h:column>
                <h:column id="v5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==3}"><h:outputText value="Parc N°:"/></h:column>
                <h:column id="v6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==2}">
                    <h:inputText style="width:50%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconRbmKms}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column id="v7" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==3}">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_option_parc}" var="pac1">
                        <h:selectOneMenu id="idparc" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconParc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesParcItems}" />
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_option_parc}" var="pac2">
                        <h:inputText id="idparc2" style="width:100%;" maxlength="20" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconParc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/>
                    </c:if>
                </h:column>
            </h:panelGrid>
        </rich:tab>

        <rich:tab name="simulation" label="Simulation">
            <h:panelGrid id="panSimulation" width="100%">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable rows="200" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelSimulationLigne}" enableContextMenu="false" var="plan" id="table" border="0" styleClass="bg" style="border:solid 1px green" width="100%" height="450px" footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " selectedClass="active-row">
                        <rich:column  width="10%" sortable="false">
                            <f:facet name="header"><h:outputText value="Nature" /></f:facet>
                            <h:outputText value= "#{plan.bulligNature} : #{plan.libNature}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="8%" sortable="true" sortBy="#{plan.bulligRubrique}" sortOrder="ASCENDING" >
                            <f:facet name="header"><h:outputText value="Code" /></f:facet>
                            <h:outputText value="#{plan.bulligRubrique}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="24%" sortable="false" >
                            <f:facet name="header"><h:outputText value="Libellé rubrique"/></f:facet>
                            <h:outputText value="#{plan.bulligLibelle}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="A-Calcul"/></f:facet>
                            <h:outputText value="#{plan.bulligValColA}" rendered="#{plan.bulligAffColA}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="B-Base"/></f:facet>
                            <h:outputText value="#{plan.bulligValColB}" rendered="#{plan.bulligAffColB}" style="#{plan.espaceFamille}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column width="8%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="C-Taux"/></f:facet>
                            <h:outputText value="#{plan.bulligValColC}" rendered="#{plan.bulligAffColC}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="8%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="D-Nb"/></f:facet>
                            <h:outputText value="#{plan.bulligValColD}" rendered="#{plan.bulligAffColD}" style="#{plan.espaceFamille}"/>
                        </rich:column>
                        <rich:column width="10%" sortable="false" style="text-align:right;">
                            <f:facet name="header"><h:outputText value="E-Résultat"/></f:facet>
                            <h:outputText value="#{plan.bulligValColE}" rendered="#{plan.bulligAffColE}" style="#{plan.espaceFamille}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </h:panelGrid>
        </rich:tab>

        <rich:tab id="tabSignature" label="Signature">
            <h:panelGrid columns="4" id="panFin" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                <h:column><h:outputText value="Fin contrat:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Contrat Actif" itemValue="0"/>
                        <f:selectItem itemLabel="Licenciement" itemValue="2"/>
                        <f:selectItem itemLabel="Démission" itemValue="3"/>
                        <f:selectItem itemLabel="Décés" itemValue="4"/>
                        <f:selectItem itemLabel="Retraite" itemValue="5"/>
                        <f:selectItem itemLabel="Fin de contrat" itemValue="6"/>
                        <f:selectItem itemLabel="Arrêt ou suspension" itemValue="7"/>
                        <f:selectItem itemLabel="Mutation" itemValue="8"/>
                        <f:selectItem itemLabel="Départ négocié" itemValue="10" />
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panFin"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column></h:column>
                <h:column></h:column>
                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I')&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><h:outputText value="Date fin:"/></h:column>
                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I')&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I')&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><h:outputText value="Observations:"/></h:column>
                <h:column rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I')&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconMotifSortie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
            </h:panelGrid>
            <h:panelGrid columns="4" styleClass="fichefournisseur1" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                <h:column><h:outputText value="Responsable:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconNomRepresentant}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                <h:column><h:outputText value="Qualité:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconQualite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                <h:column><h:outputText value="Date remise (JJ/MM/AAAA):"/></h:column>
                <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   inputSize="8"  locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateRemise}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                <h:column><h:outputText value="Date retour (JJ/MM/AAAA):"/></h:column>
                <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"    inputSize="8" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateRetour}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
            </h:panelGrid>
        </rich:tab>

        <rich:tab id="tabTexte" label="Texte">
            <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panTexte"/>
            <h:panelGrid  width="100%" id="panTexte">
                <h:panelGrid  width="100%">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconId==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.afficheTexteContrat}">
                        <h:selectOneMenu id="idModele" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_code_modele}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat!=3}">
                            <f:selectItem itemLabel="Sélectionnez modèle contrat" itemValue="100" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesModelesItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.rechercheTexteModeleContrat}" reRender="panTexte,panelTexteContrat"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid style="width:100%;" id="panelTexteContrat">
                    <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <jsp:include flush="true" page="../css/tdt.jsp"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculeTexte}" reRender="panTexte,panelTexteContrat"/>
                    </rich:editor>
                </h:panelGrid>
            </h:panelGrid>
        </rich:tab>

        <rich:tab id="tabScan" label="Scan contrats">
            <h:panelGrid width="100%" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0}">
                <f:facet name="header"><h:outputText value="CONTRAT PRINCIPAL SCANNE"/></f:facet>
                <br>
                <h:panelGrid id="panPdf" columns="2" columnClasses="clos50;clos50" width="100%">
                    <h:panelGroup>
                        <t:inputFileUpload id="filePdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.uploadedPDFFile}"/>
                        <h:commandButton  styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.submitPDFContrat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat>3}">
                            <a4j:support eventsQueue="maQueue"  immediate="true"/>
                        </h:commandButton>
                        <h:message for="filePdf" infoStyle="color: green;" errorStyle="color: red;" />
                    </h:panelGroup>
                    <h:panelGroup id="grp4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_affFicPdfContrat}">
                        <h:outputText value="Nom document:"/>&nbsp;&nbsp;&nbsp;
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDocument}" />&nbsp;&nbsp;&nbsp;
                        <h:commandButton image="/images/download.png" title="Télécharger le document" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.downloadPdfContrat}" />&nbsp;&nbsp;&nbsp;
                        <h:commandButton image="/images/detail.png" title="Lire le document" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.voirPdfContrat}"/>&nbsp;&nbsp;&nbsp;
                        <h:commandButton image="/images/annuler.gif" title="Supprimer le document" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.reInitPDFContrat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat!=3}"/>
                    </h:panelGroup>
                </h:panelGrid>
                <br>
            </h:panelGrid>

            <h:panelGrid width="100%" headerClass="headerTab" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.afficheAvenant}">
                <h:panelGrid id="panPdfAvn" width="100%" headerClass="headerTab">
                    <f:facet name="header"><h:outputText value="LISTE DES AVENANTS SCANNES"/></f:facet>
                    <br>
                    <a4j:region renderRegionOnly="false">
                        <h:panelGroup id="idScanGlobal" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat<=3}">
                            <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.ajouterAvenantScan}" reRender="panalAjoutAvenant"/>
                        </h:panelGroup>
                        <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelAvenants}" id="listeAvenant" var="document" >
                            <f:facet name="header"></f:facet>
                            <rich:column>
                                <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.lectureAvenant}" reRender="panalVisuPjAvenant"/>
                                <br>
                                <h:outputText value="#{document}"/>
                            </rich:column>
                        </rich:dataGrid>
                    </a4j:region>
                    <br>
                </h:panelGrid>
            </h:panelGrid>

        </rich:tab>

    </rich:tabPanel>

</h:panelGrid>

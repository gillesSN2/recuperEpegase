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

        <rich:tab id="tabContratActuel" label="Contrat Actuel">
            <h:panelGrid width="100%">
                <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                    <h:column><h:outputText value="Nature contrat:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType}" disabled="true" readonly="true">
                            <f:selectItem itemLabel="Sélectionnez type contrat" itemValue="100" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Feuille calcul:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconFeuille}" disabled="true" readonly="true">
                            <f:selectItem itemLabel="Sélectionnez Feuille" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesFeuillesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Date début (JJ/MM/AAAA):"/></h:column>
                    <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateDebut}" popup="true" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Date fin (JJ/MM/AAAA):" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='11'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='12'}"/></h:column>
                    <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateFin}" popup="true" disabled="true" readonly="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='05'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='11'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='12'}"/></h:column>
                    <h:column><h:outputText value="Fonction:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconFonction}" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Lieu travail:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconLieuTravail}" disabled="true" readonly="true"/></h:column>
                    <h:column><h:outputText value="Régime congés:"/></h:column>
                    <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconNbJourCp}" disabled="true" readonly="true"/>&nbsp;&nbsp;<h:outputText value="(Nb jours congés par mois)"/></h:column>
                    <h:column><h:outputText value="Nb jours travail:"/></h:column>
                    <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconNbJourTr}" disabled="true" readonly="true"/>&nbsp;&nbsp;<h:outputText value="(Nb jour de travail par mois)"/></h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='04'}">
                    <h:column><h:outputText value="Niveau emploi (cadre?):"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_niveau}" disabled="true" readonly="true">
                            <f:selectItem itemLabel="Sélectionnez Niveau emploi" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNiveauxEmploisItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Classement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_classement}" disabled="true" readonly="true">
                            <f:selectItem itemLabel="Sélectionnez Classement" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClassementsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Centre Impôt:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_centre}" disabled="true" readonly="true">
                            <f:selectItem itemLabel="Sélectionnez Centre impôt" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesCentresImpotsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column></h:column>
                    <h:column></h:column>
                    <h:column><h:outputText value="Convention:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_convention}" disabled="true" readonly="true">
                            <f:selectItem itemLabel="Sélectionnez Convention" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesConventionsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Catégorie salariale:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_grille}" disabled="true" readonly="true">
                            <f:selectItem itemLabel="Sélectionnez Grille" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesGrillesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos35d,clos15,clos35d,clos15" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='13'}">
                    <h:column><h:outputText value="Forfait:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconBase}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeRendement}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeResponsabilite}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeFonction}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Sujetion:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeSujetion}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteDeplacement}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteKilometrique}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteSalissure}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de Représentation:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteRepresentation}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteDiverse}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteResponsabilite}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de nourriture:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteNourriture}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos35d,clos15,clos35d,clos15" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='03I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconType=='04'}">
                    <h:column><h:outputText value="Base conventionnée:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconBase}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Sursalaire:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconSursalaire}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeRendement}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeResponsabilite}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeFonction}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Sujetion:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconPrimeSujetion}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Caisse:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteCaisse}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Transport:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteTransport}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Logement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteLogement}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteDeplacement}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteKilometrique}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteSalissure}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de Représentation:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteRepresentation}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteDiverse}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteResponsabilite}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de nourriture:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconIndemniteNourriture}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. logement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnLogement}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. Domesticité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnDomesticite}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. Eau:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnEau}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. Electricité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnElectricite}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. nourriture:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnNourriture}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. véhicule :" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnVehicule}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. Téléphone:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconAvnTelephone}" disabled="true" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </rich:tab>

        <rich:tab id="tabImputActuel" label="Imputation Actuelle">
            <h:panelGrid columns="2" styleClass="fichefournisseur" columnClasses="clos20,clos80" width="100%" >
                <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconActivite}" style="width:230px" disabled="true" readonly="true">
                        <f:selectItem itemLabel="Sans Activité" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesActiviteItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelDecoupageActivtes}" var="saisieAnal">
                            <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                                <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                <h:selectOneMenu value="#{saisieAnal.zoneActivite}" disabled="true" readonly="true">
                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.laColonne1Items}"/>
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                <h:selectOneMenu value="#{saisieAnal.zoneAnal1}" disabled="true" readonly="true">
                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.laColonne2Items}"/>
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                                <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                <h:selectOneMenu value="#{saisieAnal.zoneAnal3}" disabled="true" readonly="true">
                                    <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.laColonne3Items}"/>
                                </h:selectOneMenu>
                            </rich:column>
                            <rich:column label="%"  width="15%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px" disabled="true" readonly="true">
                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                </h:inputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}"><h:outputText value="Projet:" style="text-decoration:underline;"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}">
                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_projet}" style="width:230px" disabled="true" readonly="true">
                        <f:selectItem itemLabel="Sans Projet" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesProjetItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Budget:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_budget}" disabled="true" readonly="true">
                        <f:selectItem itemLabel="Sans Budget" itemValue="100" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesBudgetItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_cle1}" disabled="true" readonly="true">
                        <f:selectItem itemLabel="Sans Cle1" itemValue="100" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_cle2}" disabled="true" readonly="true">
                        <f:selectItem itemLabel="Sans Cle2" itemValue="100" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Véhicule:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule}" disabled="true" readonly="true">
                        <f:selectItem itemLabel="Sans véhicule" itemValue="0"/>
                        <f:selectItem itemLabel="Véhicule personnel au forfait" itemValue="1"/>
                        <f:selectItem itemLabel="Véhicule personnel au Km" itemValue="2"/>
                        <f:selectItem itemLabel="Véhicule entreprise" itemValue="3"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==0}"></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==0}"></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==1}"><h:outputText value="Montant remboursé au forfait:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==2}"><h:outputText value="Montant remboursé au Km:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==3}"><h:outputText value="Parc N°:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==2}">
                    <h:inputText style="width:50%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconRbmKms}" disabled="true" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconVehicule==3}">
                    <h:selectOneMenu style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconParc}" disabled="true" readonly="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesParcItems}" />
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
        </rich:tab>

        <rich:tab id="tabTexteActuel" label="Texte Actuel">
            <h:panelGrid  width="100%">
                <h:panelGrid style="width:100%;">
                    <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconTexte}" readonly="true">
                        <jsp:include flush="true" page="../css/tdt.jsp"/>
                    </rich:editor>
                </h:panelGrid>
            </h:panelGrid>
        </rich:tab>

        <rich:tab id="tabSignatureActuel" label="Signature Actuelle">
            <h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                <h:column><h:outputText value="Fin contrat:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat}" disabled="true" readonly="true">
                        <f:selectItem itemLabel="Contrat Actif" itemValue="0"/>
                        <f:selectItem itemLabel="Licenciement" itemValue="2"/>
                        <f:selectItem itemLabel="Démission" itemValue="3"/>
                        <f:selectItem itemLabel="Décés" itemValue="4"/>
                        <f:selectItem itemLabel="Retraite" itemValue="5"/>
                        <f:selectItem itemLabel="Fin de contrat" itemValue="6"/>
                        <f:selectItem itemLabel="Arrêt ou suspension" itemValue="7"/>
                        <f:selectItem itemLabel="Départ négocié" itemValue="10" />
                    </h:selectOneMenu>
                </h:column>
                <h:column></h:column>
                <h:column></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><h:outputText value="Date fin (JJ/MM/AAAA):"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateFin}" popup="true" disabled="true" readonly="true"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><h:outputText value="Observations:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconEtat!=0}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconMotifSortie}" disabled="true" readonly="true"/></h:column>
            </h:panelGrid>
            <h:panelGrid columns="4" styleClass="fichefournisseur1" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                <h:column><h:outputText value="Responsable:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconNomRepresentant}" disabled="true" readonly="true"/></h:column>
                <h:column><h:outputText value="Qualité:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconQualite}" disabled="true" readonly="true"/></h:column>
                <h:column><h:outputText value="Date remise (JJ/MM/AAAA):"/></h:column>
                <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateRemise}" popup="true" disabled="true" readonly="true"/></h:column>
                <h:column><h:outputText value="Date retour (JJ/MM/AAAA):"/></h:column>
                <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContrats.salconDateRetour}" popup="true" disabled="true" readonly="true"/></h:column>
            </h:panelGrid>
        </rich:tab>


        <rich:tab id="tabContratNouveau" label="Nouveau Contrat" style="color:red">
            <h:panelGrid id="idConfig0" width="100%" >
                <h:panelGrid id="idConfig1" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                    <h:column><h:outputText value="Nature contrat:"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez type contrat" itemValue="100" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNatureAgentItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.recupererModelesItemMuter}" reRender="panContrat,idModele,idConfig1,idConfig2,panTexte,idModele"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Feuille calcul:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idfeuille" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconFeuille}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Feuille" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesFeuillesItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Date début (JJ/MM/AAAA):"/></h:column>
                    <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconDateDebut}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                    <h:column><h:outputText value="Date 1ere enbauche (JJ/MM/AAAA):" /></h:column>
                    <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconDateEntreeInitial}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                    <h:column><h:outputText value="Fonction:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                    <h:column><h:outputText value="Lieu travail:"/></h:column>
                    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconLieuTravail}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                    <h:column><h:outputText value="Régime congés:"/></h:column>
                    <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconNbJourCp}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/>&nbsp;&nbsp;<h:outputText value="(Nb jours congés par mois)"/></h:column>
                    <h:column><h:outputText value="Nb jours travail:"/></h:column>
                    <h:column><h:inputText style="text-align:right;width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconNbJourTr}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/>&nbsp;&nbsp;<h:outputText value="(Nb jour de travail par mois)"/></h:column>
                </h:panelGrid>
                <h:panelGrid id="idConfig2" columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='03I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='04'}">
                    <h:column><h:outputText value="Niveau emploi (cadre?):"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idniveau" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_niveauMuter}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Niveau emploi" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesNiveauxEmploisItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Classement:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idclassement" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_classementMuter}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Classement" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClassementsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Centre Impôt:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idcentre" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_centreMuter}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Centre impôt" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesCentresImpotsItems}" />
                        </h:selectOneMenu>
                    </h:column>
                    <h:column></h:column>
                    <h:column></h:column>
                    <h:column><h:outputText value="Convention:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idconvention" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_conventionMuter}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Convention" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesConventionsItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.chargerGrilleMuter}" reRender="idConfig2,idgrille"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Catégorie salariale:"/></h:column>
                    <h:column>
                        <h:selectOneMenu id="idgrille" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_grilleMuter}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <f:selectItem itemLabel="Sélectionnez Grille" itemValue="0" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesGrillesItems}"/>
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculGrilleMuter}" reRender="idConfig0,idConfig2,idgrille,idValeurs0,idValeurs1"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="idValeurs0" columns="4" styleClass="fichefournisseur" columnClasses="clos35d,clos15,clos35d,clos15" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='13'}">
                    <h:column><h:outputText value="Forfait:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconBase}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconPrimeRendement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconPrimeResponsabilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconPrimeFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Sujetion:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconPrimeSujetion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteDeplacement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteKilometrique}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteSalissure}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de Représentation:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteRepresentation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteDiverse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteResponsabilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de nourriture:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteNourriture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="idValeurs1" columns="4" styleClass="fichefournisseur" columnClasses="clos35d,clos15,clos35d,clos15" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='01D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='01I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='02D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='02I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='03D'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='03I'||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconType=='04'}">
                    <h:column><h:outputText value="Base conventionnée:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconBase}" disabled="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Sursalaire:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconSursalaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Rendement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconPrimeRendement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Responsabilité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconPrimeResponsabilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Fonction:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconPrimeFonction}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Prime Sujetion:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconPrimeSujetion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Caisse:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteCaisse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Transport:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteTransport}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Logement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteLogement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Déplacement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteDeplacement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité Kilométrique:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteKilometrique}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de salissure:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteSalissure}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de Représentation:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteRepresentation}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité diverse:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteDiverse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de responsabilité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteResponsabilite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Indemnité de nourriture:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconIndemniteNourriture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. logement:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconAvnLogement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. Domesticité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconAvnDomesticite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. Eau:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconAvnEau}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. Electricité:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconAvnElectricite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. nourriture:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconAvnNourriture}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. véhicule :" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconAvnVehicule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Avt. nat. Téléphone:" style="text-align:right;"/></h:column>
                    <h:column>
                        <h:inputText style="width:200px;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconAvnTelephone}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                </h:panelGrid>
            </h:panelGrid>
        </rich:tab>

        <rich:tab id="tabImputNouvelle" label="Nouvelle Imputation" style="color:red">
            <h:panelGrid id="idConfig3" columns="2" styleClass="fichefournisseur" columnClasses="clos20,clos80" width="100%" >
                <h:column><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconActivite}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==3}">
                        <f:selectItem itemLabel="Sans Activité" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesActiviteItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.decoupageActivite}">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="200px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.dataModelDecoupageActivtesMuter}" var="saisieAnal">
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
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}"><h:outputText value="Projet:" style="text-decoration:underline;"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.accesProjet}">
                    <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_projetMuter}" style="width:230px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Projet" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesProjetItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Budget:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu id="idbuget" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_budgetMuter}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Budget" itemValue="100" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesBudgetItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu id="idcle1" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_cle1Muter}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Cle1" itemValue="100" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu id="idcle2" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_cle2Muter}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans Cle2" itemValue="100" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesClesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Véhicule:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconVehicule}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Sans véhicule" itemValue="0"/>
                        <f:selectItem itemLabel="Véhicule personnel au forfait" itemValue="1"/>
                        <f:selectItem itemLabel="Véhicule personnel au Km" itemValue="2"/>
                        <f:selectItem itemLabel="Véhicule entreprise" itemValue="3"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="idConfig3,v0,v1,v2,v3,v4,v5,v6;v7"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column id="v0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconVehicule==0}"></h:column>
                <h:column id="v1" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconVehicule==0}"></h:column>
                <h:column id="v3" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconVehicule==1}"><h:outputText value="Montant remboursé au forfait:"/></h:column>
                <h:column id="v4" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconVehicule==2}"><h:outputText value="Montant remboursé au Km:"/></h:column>
                <h:column id="v5" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconVehicule==3}"><h:outputText value="Parc N°:"/></h:column>
                <h:column id="v6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconVehicule==1||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconVehicule==2}">
                    <h:inputText style="width:50%;text-align:right;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconRbmKms}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column id="v7" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconVehicule==3}">
                    <h:selectOneMenu id="idparc" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconParc}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesParcItems}" />
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
        </rich:tab>

        <rich:tab id="tabTexteNouveau" label="Nouveau Texte" style="color:red">
            <a4j:support eventsQueue="maQueue" event="onlabelclick" reRender="panTexte"/>
            <h:panelGrid  width="100%" id="panTexte">
                <h:panelGrid  width="100%">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconId==0||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.afficheTexteContrat}">
                        <h:selectOneMenu id="idModele" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_code_modeleMuter}">
                            <f:selectItem itemLabel="Sélectionnez modèle contrat" itemValue="100" />
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.mesModelesItems}" />
                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.rechercheTexteModeleContratMuter}" reRender="panTexte,panelTexteContrat"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid style="width:100%;" id="panelTexteContrat">
                    <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconTexte}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <jsp:include flush="true" page="../css/tdt.jsp"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.calculeTexteMuter}" reRender="panTexte,panelTexteContrat"/>
                    </rich:editor>
                </h:panelGrid>
            </h:panelGrid>
        </rich:tab>

        <rich:tab id="tabSignatureNouveau" label="Nouvelle Signature" style="color:red">
            <h:panelGrid columns="4" id="panFin" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                <h:column><h:outputText value="Fin contrat:"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconEtat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}">
                        <f:selectItem itemLabel="Contrat Actif" itemValue="0"/>
                        <f:selectItem itemLabel="Licenciement" itemValue="2"/>
                        <f:selectItem itemLabel="Démission" itemValue="3"/>
                        <f:selectItem itemLabel="Départ négocié" itemValue="10"/>
                        <f:selectItem itemLabel="Décés" itemValue="4"/>
                        <f:selectItem itemLabel="Retraite" itemValue="5"/>
                        <f:selectItem itemLabel="Fin de contrat" itemValue="6"/>
                        <f:selectItem itemLabel="Arrêt ou suspension" itemValue="7"/>
                        <f:selectItem itemLabel="Départ négocié" itemValue="10" />
                        <a4j:support eventsQueue="maQueue" event="onchange" reRender="panFin"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column></h:column>
                <h:column></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconEtat!=0}"><h:outputText value="Date fin (JJ/MM/AAAA):"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconEtat!=0}"><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconEtat!=0}"><h:outputText value="Observations:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconEtat!=0}"><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconMotifSortie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
            </h:panelGrid>
            <h:panelGrid columns="4" styleClass="fichefournisseur1" columnClasses="clos15,clos35,clos15,clos35" width="100%" >
                <h:column><h:outputText value="Responsable:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconNomRepresentant}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                <h:column><h:outputText value="Qualité:"/></h:column>
                <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconQualite}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                <h:column><h:outputText value="Date remise (JJ/MM/AAAA):"/></h:column>
                <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconDateRemise}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
                <h:column><h:outputText value="Date retour (JJ/MM/AAAA):"/></h:column>
                <h:column><rich:calendar  enableManualInput="true" datePattern="dd/MM/yyyy"   locale="fr" style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesContratsMuter.salconDateRetour}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat==3}"/></h:column>
            </h:panelGrid>
        </rich:tab>

    </rich:tabPanel>

</h:panelGrid>

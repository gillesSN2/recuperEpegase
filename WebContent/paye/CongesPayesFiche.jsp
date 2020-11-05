<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="fichescp">

    <a4j:form>

        <center> <h2><h:outputText value="FICHE : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_lib_cp}" style="color:green;"/></h2></center>

        <h:panelGrid id="idPanGlobal" width="100%">
            <h:panelGrid id="idRecherche" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action==1}">
                <h:column><h:outputText value="Rechercher Agent:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText id="idSalarie" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nomSalarie}">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les salariés (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.rechercheSalarie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,tabPanelsalaries,tabPanelsalaries2,FichSalarie,panelListeSalaries,formModalListeSalaries,idSalarie,idRecherche,panelValide,idPanGlobal"/>
                    </h:inputText>
                </h:column>
                <h:column></h:column>
                <h:column></h:column>
            </h:panelGrid>

            <h:panelGrid id="FichSalarie" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salaries.salId!=0}">
                <jsp:include flush="true" page="/paye/CongesPayesCommun.jsp" />
            </h:panelGrid>

            <h:panelGrid width="100%" id="tabPanelsalaries" columns="8" styleClass="fichefournisseur" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salaries.salId!=0}">
                <h:column><h:outputText value="Nb jour Initial:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nbInit}"/></h:column>
                <h:column><h:outputText value="Nb jour Acquis:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nbAcquis}"/></h:column>
                <h:column><h:outputText value="Nb jour Pris:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nbPris}"/></h:column>
                <h:column><h:outputText value="Nb jour Restant:"/></h:column>
                <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.nbRestant}"/></h:column>
            </h:panelGrid>

            <h:panelGrid width="100%" id="tabPanelsalaries2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salaries.salId!=0}">
                <h:panelGrid style="width:100%;" id="panConges">
                    <h:panelGrid columns="2" id="idConges" styleClass="fichefournisseur1" columnClasses="clos30,clos70" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_nat_rec>=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_nat_rec<10}">
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature==0}"><h:outputText value="Sélection type congés:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature==0}">
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature}">
                                <f:selectItem itemLabel="Congés normaux (Solde total)" itemValue="1" />
                                <f:selectItem itemLabel="Congés normaux (Nb jours pris)" itemValue="6" />
                                <f:selectItem itemLabel="Bulletin de congés" itemValue="2" />
                                <f:selectItem itemLabel="Congés travaillés" itemValue="3" />
                                <f:selectItem itemLabel="Congés non calculés" itemValue="4"/>
                                <f:selectItem itemLabel="Congés de Maternité" itemValue="5" />
                                <f:selectItem itemLabel="Mise à disposition" itemValue="7" />
                                <f:selectItem itemLabel="Nombre de jours de rattrapage" itemValue="8" />
                                <f:selectItem itemLabel="Demande rejetée" itemValue="9" />
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Contrat:"/></h:column>
                        <h:column>
                            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngContrat}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}">
                                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.lesContratsActifsItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature!=8}"><h:outputText value="Date départ (JJ/MM/AAAA):"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature!=8}">
                            <rich:calendar enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngDateDebut}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}">
                                <a4j:support eventsQueue="maQueue" event="oninputblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.calculDureeConges}" reRender="idConges,idDuree,panelValide,idPanGlobal,modMessageCommun"/>
                            </rich:calendar>
                        </h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature!=8}"><h:outputText value="Date retour (JJ/MM/AAAA):"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature!=8}">
                            <rich:calendar enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"  inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngDateFin}" popup="true" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}">
                                <a4j:support eventsQueue="maQueue" event="oninputblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.calculDureeConges}" reRender="idConges,idDuree,panelValide,idPanGlobal,modMessageCommun"/>
                            </rich:calendar>
                        </h:column>
                        <h:column><h:outputText value="Durée:"/></h:column>
                        <h:column><h:inputText id="idDuree" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngDuree}" size="5" disabled="true"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature==6}"><h:outputText value="Nombre jours exclus:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNature==6}">
                            <h:inputText style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngNbJoursExclus}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}">
                                <a4j:support eventsQueue="maQueue" event="oninputblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.calculDureeConges}" reRender="idConges,idDuree,panelValide,idPanGlobal,modMessageCommun"/>
                            </h:inputText>&nbsp;&nbsp;
                            <h:outputText value="(Dimanches et jours fériés)"/>
                        </h:column>
                        <h:column><h:outputText value="Observations:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngObjet}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}"/></h:column>
                        <h:column><h:outputText value="Lieu congés:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngLieu}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}"/></h:column>
                        <h:column><h:outputText value="Responsable:"/></h:column>
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salariesConges.salcngResponsable}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action_conges==3}"/></h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </h:panelGrid>

            <h:panelGroup id="panelValide">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.annulerElementCp}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.saveConges}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.var_action!=3&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formConges.ctrlNbJour}"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

</f:subview>

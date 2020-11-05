<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="fichePrelevement">

    <center>
        <a4j:form enctype="multipart/form-data">
            <rich:hotKey key="return" handler="return false;"/>

            <center> <h2><h:outputText value="GESTION DU PRELEVEMENT" style="color:green;"/></h2></center>

            <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                <rich:tab id="tabdetPrel" label="Prélèvements">
                    <h:panelGrid id="idPanPrelevement" width="100%">

                        <jsp:include flush="true" page="/medical/LaboratoireCommun.jsp" />
                        <h:panelGrid id="idPanDescription" width="100%">
                            <h:panelGrid width="100%" styleClass="fichefournisseur1">
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="Motif entrée:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idMotif" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labEntree}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <f:selectItem itemLabel="Sélection Motif Entrée" itemValue="100"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesMotifEntreeItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_pathologie}"><h:outputText value="Type pathologie:" style="text-decoration:underline;"/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_pathologie}">
                                        <h:selectOneMenu id="idPathologie" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labPathologie}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <f:selectItem itemLabel="Sélection Pathologie" itemValue="100"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesPathologieItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_protocole}"><h:outputText value="Protocole:" style="text-decoration:underline;"/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_protocole}">
                                        <h:selectOneMenu id="idProtocole" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labProtocole}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <f:selectItem itemLabel="Sélection Protocole" itemValue="100"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.mesProtocoleItems}"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Service demandeur:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idService" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labService}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesServicesItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.optionMedical.choixLabo=='0'}"><h:outputText value="Laboratoire:" style="text-decoration:underline;"/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.optionMedical.choixLabo=='0'}">
                                        <h:selectOneMenu id="idLaboratoire" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labLaboratoire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesLaboratoiresItems}" />
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.calculMedecinActe}" reRender="idMedecin"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column><h:outputText value="Mèdecin:" style="text-decoration:underline;"/></h:column>
                                    <h:column>
                                        <h:selectOneMenu id="idMedecin" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_nom_medecin}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <f:selectItem itemLabel="Sélection Médecin" itemValue="0"/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.mesMedecinsItem}" />
                                            <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.verifValideLaboratoire}" reRender="prgtpAjt"/>
                                        </h:selectOneMenu>
                                    </h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_prescipteur}"><h:outputText value="Prescripteur:" style="text-decoration:underline;"/></h:column>
                                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_affiche_prescipteur}">
                                        <h:selectOneMenu id="idPrescripteur" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labPrescripteur}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                            <f:selectItem itemLabel="EXTERNE" itemValue=""/>
                                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.mesMedecinsItems}" />
                                        </h:selectOneMenu>
                                    </h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                    <h:column><h:outputText value="N° B.C.:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNumBc}" style="width:100%" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                    <h:column><h:outputText value="N° Feuille"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labFeuille}" style="width:100%" maxlength="20" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                    <h:column><h:outputText value="N° Hospitalisation:"/></h:column>
                                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labNumHospit}" style="width:100%" readonly="true"/></h:column>
                                </h:panelGrid>
                                <h:panelGrid width="100%" styleClass="fichefournisseur1">
                                    <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g" id="idpanQuestion">
                                        <h:column><h:outputText value="Date prélèvement:"/></h:column>
                                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDatePrelevement}"  inputSize="8" datePattern="dd/MM/yyyy HH:MM" locale="fr" style=" background-color:white;"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                        <h:column><h:outputText value="Lieu prélèvement:"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labLieuPrelevement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                                <f:selectItem itemLabel="Non renseigné" itemValue="0"/>
                                                <f:selectItem itemLabel="A domicile" itemValue="1"/>
                                                <f:selectItem itemLabel="Au laboratoire" itemValue="2"/>
                                                <f:selectItem itemLabel="Dans une unité de soin" itemValue="3"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Partenaire:"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labPartenaire}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                                <f:selectItem itemLabel="Non renseigné" itemValue="0"/>
                                                <f:selectItem itemLabel="Avec partenaire" itemValue="1"/>
                                                <f:selectItem itemLabel="Avec plusieurs partenaires" itemValue="2"/>
                                                <f:selectItem itemLabel="Sans partenaire" itemValue="3"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                        <h:column><h:outputText value="Date dernières règles:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDateRegles}"  inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                        <h:column><h:outputText value="Grossesse:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labGrossesse}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                        <h:column><h:outputText value="" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                        <h:column><h:outputText value="" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.patients.patSexe==0}"/></h:column>
                                        <h:column><h:outputText value="Diabète:"/></h:column>
                                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDiabete}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                        <h:column><h:outputText value="Immuno-Déprimé(e):"/></h:column>
                                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labImmunodepressif}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                        <h:column><h:outputText value=""/></h:column>
                                        <h:column><h:outputText value=""/></h:column>
                                        <h:column><h:outputText value="Traitement en cours:"/></h:column>
                                        <h:column>
                                            <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labTraitement}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                                <a4j:support eventsQueue="maQueue" event="onchange" reRender="idpanQuestion,idTrt1,idTrt2"/>
                                            </h:selectBooleanCheckbox>
                                        </h:column>
                                        <h:column><h:outputText id="idTrt1" value="Quel traitement?:" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labTraitement==true}"/></h:column>
                                        <h:column><h:inputText id="idTrt2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labLequel}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labTraitement==true}"/></h:column>
                                        <h:column><h:outputText value=""/></h:column>
                                        <h:column><h:outputText value=""/></h:column>
                                        <h:column><h:outputText value="Date résultat:" style="color:red"/></h:column>
                                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labDateResultat}"  inputSize="8" datePattern="dd/MM/yyyy HH:MM" locale="fr" style=" background-color:white;color:red"  disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}"/></h:column>
                                        <h:column><h:outputText value="Urgence:" style="color:red"/></h:column>
                                        <h:column>
                                            <h:selectOneMenu style="width:100%;color:red" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.laboratoireEntete.labUrgent}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action}">
                                                <f:selectItem itemLabel="Normal" itemValue="0"/>
                                                <f:selectItem itemLabel="Petite Urgence" itemValue="1"/>
                                                <f:selectItem itemLabel="Urgence" itemValue="2"/>
                                                <f:selectItem itemLabel="Extreme Urgence" itemValue="3"/>
                                            </h:selectOneMenu>
                                        </h:column>
                                    </h:panelGrid>
                                </h:panelGrid>
                            </h:panelGrid>
                        </h:panelGrid>

                    </h:panelGrid>
                    <h:panelGroup id="prgtpAjt">
                        <center>
                            <h:commandButton image="/images/annuler_big.png" id="linkanuAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.fermerPrelevement}"  />&nbsp;&nbsp;
                            <h:commandButton image="/images/valider_big.png" id="link8Ajt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.savePrelevement}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.var_aff_action&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.valideLaboratoire}" onclick="javascript:Richfaces.showModalPanel('modAttente');" />
                        </center>
                    </h:panelGroup>
                </rich:tab>

                <rich:tab id="tabdetExamen" label="Détail facture">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLigne" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.dataModelListeExamens}" var="acte" >
                            <rich:column  width="10%" sortable="true" sortBy="#{antec.labligLaboratoire}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.optionMedical.choixLabo=='1'}">
                                <f:facet name="header"><h:outputText  value="Labo."/></f:facet>
                                <h:outputText value="#{acte.labligLaboratoire}"/>
                            </rich:column>
                            <rich:column sortable="false" width="8%">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText  value="#{acte.labligProduit}"/>
                            </rich:column>
                            <rich:column sortable="false" width="40%">
                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                <h:inputTextarea rows="1" value="#{acte.labligLibelle}" readonly="true" style="width:95%"/>
                            </rich:column>
                            <rich:column label="Code lettre" sortable="false" style="text-align:right" width="12%" >
                                <f:facet name="header"><h:outputText  value="Lettre"/></f:facet>
                                <h:outputText value="#{acte.labligLettre}: #{acte.labligNb} * #{acte.labligValeur} (#{acte.labligCoef})" rendered="#{acte.labligNb!=0}"/>
                            </rich:column>
                            <rich:column sortable="false" style="text-align:right" width="5%" >
                                <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                <h:outputText value="#{acte.labligQte}" />
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </rich:tab>

            </rich:tabPanel>


        </a4j:form>
    </center>


</f:subview>

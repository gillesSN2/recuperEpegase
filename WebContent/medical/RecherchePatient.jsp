<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="tiersPatient">

    <a4j:form id="formTiersPatient">
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText style="color:green;text-transform:uppercase;" value="RECHERCHE DE PATIENTS" /></h2></center>

        <h:panelGrid  columns="1" width="100%" id="recherche" >
            <h:panelGrid  columns="10" styleClass="recherche" width="100%">
                <h:column><h:outputText value="Nom:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_nom}" /></h:column>
                <h:column><h:outputText value="Prénom:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_prenom}"/></h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}"><h:outputText value="Dossier entrée:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}"><h:outputText value="Dossier/Matricule:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_dossier}"/></h:column>
                <h:column><h:outputText value="Téléphone:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_telephone}"/></h:column>
                <h:column><h:outputText value="C.I./P.P./Sécu.:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_carteIdentite}"/></h:column>
                <h:column><h:outputText value="Société:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_societe}"/></h:column>
                <h:column><h:outputText value="Assurance/IPM:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_assurance}"/></h:column>
                <h:column><h:outputText value="Mutuelle/Complémentaire:"/></h:column>
                <h:column><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_complementaire}"/></h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}"><h:outputText value="N° Contrat/Mat.:"/></h:column>
                <h:column rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}"><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_contrat}"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}"><h:outputText value="Sité:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}"><h:inputText style="width:100px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.site}"/></h:column>
                <h:column><h:outputText value=""/></h:column>
                <h:column>
                    <a4j:commandButton id="idRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.moduleChargerLesPatients}" reRender="recherche,btnTiers,tableTiers,scrollTable,modAttente" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <rich:hotKey key="return" handler="#{rich:element('idRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGroup>
            <center>
                <h:panelGrid width="300px" id="btnTiers" style="height:34">
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==71}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajout nouveau patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.ajouterPatient}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/modifier.png" title="Modifier fiche patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.modifierPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/detail.png" title="Consulter fiche patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.consulterPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/actualiser.png" title="Effacer liste résultat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.effaceListe}" reRender="scrollTable,tableTiers"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/imp_word.png" style="height:26px;width:26px" title="Visualisation prise en charge, lettre de garantie ou fiche de droit d'assistance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.visualisationPriseEncharge}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelScanPec" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/mouvementstock.png" title="Activites médicales" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.moduleOuvrirActivites}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelActiviteMedicale"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==73}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajout nouveau patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.ajouterPatient}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/modifier.png" title="Modifier fiche patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.modifierPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/detail.png" title="Consulter fiche patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.consulterPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/actualiser.png" title="Effacer liste résultat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.effaceListe}" reRender="scrollTable,tableTiers"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/imp_word.png" style="height:26px;width:26px" title="Visualisation prise en charge, lettre de garantie ou fiche de droit d'assistance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.visualisationPriseEncharge}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelScanPec" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/mouvementstock.png" title="Activites médicales" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.moduleOuvrirActivites}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelActiviteMedicale"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==74}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajout nouveau patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.ajouterPatient}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/modifier.png" title="Modifier fiche patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.modifierPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/detail.png" title="Consulter fiche patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.consulterPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/actualiser.png" title="Effacer liste résultat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.effaceListe}" reRender="scrollTable,tableTiers"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/imp_word.png" style="height:26px;width:26px" title="Visualisation prise en charge, lettre de garantie ou fiche de droit d'assistance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.visualisationPriseEncharge}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelScanPec" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/mouvementstock.png" title="Activites médicales" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.moduleOuvrirActivites}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelActiviteMedicale"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==76}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajout nouveau patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.ajouterPatient}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/modifier.png" title="Modifier fiche patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.modifierPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/detail.png" title="Consulter fiche patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.consulterPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/actualiser.png" title="Effacer liste résultat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.effaceListe}" reRender="scrollTable,tableTiers"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/imp_word.png" style="height:26px;width:26px" title="Visualisation prise en charge, lettre de garantie ou fiche de droit d'assistance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.visualisationPriseEncharge}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelScanPec" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/mouvementstock.png" title="Activites médicales" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.moduleOuvrirActivites}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelActiviteMedicale"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==77}">
                        <a4j:commandButton image="/images/ajouter.png" title="Ajout nouveau patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.ajouterPatient}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/modifier.png" title="Modifier fiche patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.modifierPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/detail.png" title="Consulter fiche patient" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.consulterPatient}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/actualiser.png" title="Effacer liste résultat" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.effaceListe}" reRender="scrollTable,tableTiers"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/imp_word.png" style="height:26px;width:26px" title="Visualisation prise en charge, lettre de garantie ou fiche de droit d'assistance" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.visualisationPriseEncharge}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelScanPec" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/mouvementstock.png" title="Activites médicales" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.moduleOuvrirActivites}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelActiviteMedicale"/>
                    </h:column>
                </h:panelGrid>
            </center>

            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableTiers"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.optionMedical.nbLigneMax}" style="border:solid 0px green;" id="tableTiers" border="0" height="320px" width="100%" footerClass="bard" activeClass="active-row" noDataLabel=" " headerClass="headerTab" rowClasses="rows1,rows2,rowsd" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelPatients}" var="patient" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.simpleSelectionEntete}" sortMode="multi" selectionMode="single" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.moduleSelectionPatient}" reRender="btnTiers,validButton"/>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==71}" var="pat71">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.validerTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==73}" var="pat73">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.validerTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==74}" var="pat74">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.validerTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==76}" var="pat76">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.validerTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==77}" var="pat77">
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.validerTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                    </c:if>
                    <rich:column label="N° Dossier entrée" sortable="true" sortBy="#{patient.patDossier}" width="10%">
                        <f:facet name="header" ><h:outputText value="Dossier"/></f:facet>
                        <h:outputText value="#{patient.patDossier}"  style="#{patient.couleur}" title="#{patient.patDossier}"/>
                    </rich:column>
                    <rich:column label="Nature" sortable="true" sortBy="#{patient.patPorte}" width="10%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}">
                        <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                        <h:outputText value="#{patient.patPorte}"  style="#{patient.couleur}" title="#{patient.patPorte}"/>
                    </rich:column>
                    <rich:column label="Civilité" sortable="true" sortBy="#{patient.patCivilite}" width="5%">
                        <f:facet name="header" ><h:outputText value="Civilité"/></f:facet>
                        <h:outputText value="#{patient.patCivilite}"  style="#{patient.couleur}" title="#{patient.patCivilite}"/>
                    </rich:column>
                    <rich:column label="Nom et prénom" sortable="true" sortBy="#{patient.patNom} #{patient.patPrenom}" width="16%" sortOrder="ASCENDING">
                        <f:facet name="header" ><h:outputText value="Nom et Prénom"/></f:facet>
                        <h:outputText value="#{patient.patNom} #{patient.patPrenom}"  style="#{patient.couleur}" title="#{patient.patNom} #{patient.patPrenom}"/>
                    </rich:column>
                    <rich:column label="Date de naissance" sortable="true" sortBy="#{patient.patDateNaissance}" width="7%">
                        <f:facet name="header" ><h:outputText value="Né(e)"/></f:facet>
                        <h:outputText value="#{patient.patDateNaissance}"  style="#{patient.couleur}" title="#{patient.patDateNaissance}">
                            <f:convertDateTime pattern="dd/MM/yyyy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column label="N° C.I. ou N° Passport" sortable="true" sortBy="#{patient.cipasseport}" width="10%">
                        <f:facet name="header" ><h:outputText value="C.I./P.P."/></f:facet>
                        <h:outputText value="#{patient.cipasseport}" title="#{patient.cipasseport}" style="#{patient.couleur}"/>
                    </rich:column>
                    <rich:column label="N° téléphone domicile, mobile1, mobile2, mobile3" sortable="true" sortBy="#{patient.telephone}" width="7%">
                        <f:facet name="header" ><h:outputText value="Cellulaire"/></f:facet>
                        <h:outputText value="#{patient.telephone}"  style="#{patient.couleur}" title="#{patient.telephone}"/>
                    </rich:column>
                    <rich:column label="Adresse" sortable="true" sortBy="#{patient.patAdresse}" width="10%">
                        <f:facet name="header" ><h:outputText value="Adresse"/></f:facet>
                        <h:outputText value="#{patient.patAdresse}"  style="#{patient.couleur}" title="#{patient.patAdresse}"/>
                    </rich:column>
                    <rich:column label="Mode de Prise en charge" sortable="true" sortBy="#{patient.libelleFamille}" width="5%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}">
                        <f:facet name="header" ><h:outputText value="Pec."/></f:facet>
                        <h:outputText value="#{patient.libelleFamille}"  style="#{patient.couleur}" title="#{patient.libelleFamille}"/>
                    </rich:column>
                    <rich:column label="N° Contrat ou matricule" sortable="true" sortBy="#{patient.patNumContrat} #{patient.patImmatriculation}" width="10%">
                        <f:facet name="header" ><h:outputText value="Contrat/Matric."/></f:facet>
                        <h:outputText value="#{patient.patNumContrat}"  style="#{patient.couleur}" title="#{patient.patNumContrat}" rendered="#{patient.patNumContrat!=null}"/>
                        <h:outputText value="#{patient.patImmatriculation}"  style="#{patient.couleur}" title="#{patient.patImmatriculation}" rendered="#{patient.patImmatriculation!=null}"/>
                    </rich:column>
                    <rich:column label="Prise en charge Client Société" sortable="true" sortBy="#{patient.patSociete}" width="10%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}">
                        <f:facet name="header" ><h:outputText value="Société"/></f:facet>
                        <h:outputText value="#{patient.patSociete}"  style="#{patient.couleur}" title="#{patient.patSociete}"/>
                    </rich:column>
                    <rich:column label="Prise en charge Assurance/IPM" sortable="true" sortBy="#{patient.patAssurance}" width="10%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}">
                        <f:facet name="header" ><h:outputText value="Assurance/IPM"/></f:facet>
                        <h:outputText value="#{patient.patAssurance}"  style="#{patient.couleur}" title="#{patient.patAssurance}"/>
                    </rich:column>
                    <rich:column label="Prise en charge Mutuelle/Complémentaire" sortable="true" sortBy="#{patient.patComplementaire}" width="10%" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.infirmerie}">
                        <f:facet name="header" ><h:outputText value="Mutuelle/Complémentaire"/></f:facet>
                        <h:outputText value="#{patient.patComplementaire}"  style="#{patient.couleur}" title="#{patient.patComplementaire}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </h:panelGroup>

        <h:panelGroup id="validButton">
            <center>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==71}" var="patsel71">
                    <a4j:commandButton id="idCanTiers71" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.annulerTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers71" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formConsultationGene.validerTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==73}" var="patsel73">
                    <a4j:commandButton id="idCanTiers73" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.annulerTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers73" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.validerTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,idPharmacie"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton id="idValDivers73" value="Patient Divers" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.validerTiersDivers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPharmacie.patientDivers}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==74}" var="patsel74">
                    <a4j:commandButton id="idCanTiers74" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.annulerTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers74" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formLaboratoire.validerTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==76}" var="patsel76">
                    <a4j:commandButton id="idCanTiers76" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.annulerTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers76" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formHospitalisation.validerTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,modMessageCommun"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.nature==77}" var="patsel77">
                    <a4j:commandButton id="idCanTiers77" image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.annulerTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton id="idValTiers77" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formDevisMedical.validerTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectTiers}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,modMessageCommun"/>
                </c:if>
            </center>
        </h:panelGroup>

    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelScanPec" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="900" height="900" autosized="false" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelScan}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelScan}" var="trf">
            <f:facet name="header"><h:outputText value="Scan des prises en charges, des lettres de garanties ou des fihes de droit d'assistance pour #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patronyme}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.fermerVisualisationPriseEnCharge}" image="/images/close.gif" styleClass="hidelink" reRender="panelScanPec"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:extendedDataTable style="border:solid 0px green;" id="tablePec" border="0" width="100%" activeClass="active-row" noDataLabel="SANS SCAN DE PRISE EN CHARGE NI DE LETTRE DE GARANTIE NI DE FIHE DE DROIT D'ASSISTANCE" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.datamodelPec}" var="pec" >
                    <rich:column label="Scan Prise en charge" width="100%" sortable="false">
                        <h:graphicImage value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.urlIpProd}/epegase/imageServlet/structure#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}/photos/scanPriseEnCharge/#{pec}" alt="pho" height="800px" width="100%" style="text-align:center"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelActiviteMedicale" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="1200" height="900" autosized="false" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelActvites}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.showModalPanelActvites}" var="act">
            <f:facet name="header"><h:outputText value="Activités médicales pour  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patronyme}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.moduleFermerActivites}" image="/images/close.gif" styleClass="hidelink" reRender="panelActiviteMedicale"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid  id="cont1" width="100%" >

                    <h:panelGrid width="100%">
                        <h:panelGrid columns="8" styleClass="recherche" width="100%" >
                            <h:column> <h:outputText value="Nature:"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:150px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.choixDocument}" >
                                    <f:selectItem itemLabel="Sélectionnez documents" itemValue="99"/>
                                    <f:selectItem itemLabel="Consultation" itemValue="71"/>
                                    <f:selectItem itemLabel="Pharmacie" itemValue="73"/>
                                    <f:selectItem itemLabel="Laboratoire" itemValue="74"/>
                                    <f:selectItem itemLabel="Hospitalistion" itemValue="76"/>
                                    <f:selectItem itemLabel="Tous documents" itemValue="50"/>
                                    <f:selectItem itemLabel="Règlements + Avoirs" itemValue="60"/>
                                    <f:selectItem itemLabel="Devis" itemValue="77"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Du:"/></h:column>
                            <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDebut}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column><h:outputText value="Au:"/></h:column>
                            <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateFin}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                            <h:column><h:outputText value=""/></h:column>
                            <a4j:commandButton value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.rechercherLesDocuments}" reRender="docmentEntete,scrollTable1,elements,scrollTable2,modAttente,paneltotal" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>

                        <h:panelGrid width="100%" id="elements">
                            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">

                                <rich:tab id="tabDoc" label="Document">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable1" maxPages="20"align="left" for="docmentEntete"/>
                                        <rich:extendedDataTable rows="100" style="max-height:100%" styleClass="bg" id="docmentEntete" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelDocumentsEntete}" var="ent">
                                            <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.selectionDocument}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,elements"/>
                                            <rich:column width="5%" sortable="true" sortBy="#{ent.var_lib_nat}">
                                                <f:facet name="header" ><h:outputText value="Nature"/></f:facet>
                                                <h:outputText value="#{ent.var_lib_nat}" title="#{ent.var_lib_nat}"/>
                                            </rich:column>
                                            <rich:column width="5%" sortable="true" sortBy="#{ent.docDate}">
                                                <f:facet name="header" ><h:outputText value="Date"/></f:facet>
                                                <h:outputText value="#{ent.docDate}" title="#{ent.docDate}">
                                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column width="8%" sortable="true">
                                                <f:facet name="header" ><h:outputText value="N°"/></f:facet>
                                                <h:outputText value="#{ent.docNum}" title="#{ent.docNum}"/>
                                            </rich:column>
                                            <rich:column width="18%" sortable="true" sortBy="#{ent.docObject}">
                                                <f:facet name="header" ><h:outputText value="Motif entrée"/></f:facet>
                                                <h:outputText value="#{ent.docObject}" title="#{ent.docObject}"/>
                                            </rich:column>
                                            <rich:column width="11%" sortable="true" sortBy="#{ent.docNomContact}">
                                                <f:facet name="header" ><h:outputText value="Médecin"/></f:facet>
                                                <h:outputText value="#{ent.docNomContact}" title="#{ent.docNomContact}"/>
                                            </rich:column>
                                            <rich:column width="11%" sortable="true" sortBy="#{ent.docNomCaissier}">
                                                <f:facet name="header" ><h:outputText value="Service"/></f:facet>
                                                <h:outputText value="#{ent.docNomCaissier}" title="#{ent.docNomCaissier}"/>
                                            </rich:column>
                                            <rich:column width="11%" sortable="true" sortBy="#{ent.docNumBon}">
                                                <f:facet name="header" ><h:outputText value="N° BC"/></f:facet>
                                                <h:outputText value="#{ent.docNumBon}" title="#{ent.docNumBon}"/>
                                            </rich:column>
                                            <rich:column width="8%" sortable="true" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_total!=0}">
                                                <f:facet name="header" ><h:outputText value="Part Tiers"/></f:facet>
                                                <h:outputText value="#{ent.docTotHt}" rendered="#{ent.docTotHt!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column width="8%" sortable="true" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_total!=0}">
                                                <f:facet name="header" ><h:outputText value="Part Patient"/></f:facet>
                                                <h:outputText value="#{ent.docTotTtc}" rendered="#{ent.docTotTtc!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column width="8%" sortable="true" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_total!=0}">
                                                <f:facet name="header" ><h:outputText value="Réglement"/></f:facet>
                                                <h:outputText value="#{ent.docTotReglement}" rendered="#{ent.docTotReglement!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column width="8%" sortable="true" style="text-align:right;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_total!=0}">
                                                <f:facet name="header" ><h:outputText value="Solde Pat."/></f:facet>
                                                <h:outputText value="#{ent.docAPayer}" rendered="#{ent.docAPayer!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabAntecedent" label="Antécédent" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesAntecedent}">
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable id="tableAntecedent" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelAntecedent}" var="antec" >
                                            <rich:column  width="10%" sortable="true" sortBy="#{antec.patantCode}" >
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText value="#{antec.patantCode}" title="#{antec.patantCode}"/>
                                            </rich:column>
                                            <rich:column  width="30%" sortable="true" sortBy="#{antec.patantFamille}" >
                                                <f:facet name="header"><h:outputText  value="Famille"/></f:facet>
                                                <h:outputText value="#{antec.patantFamille}" title="#{antec.patantFamille}"/>
                                            </rich:column>
                                            <rich:column  width="10%" sortable="true" sortBy="#{antec.patantDate}" >
                                                <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                                <h:outputText value="#{antec.patantDate}" title="#{antec.patantDate}"/>
                                            </rich:column>
                                            <rich:column width="5%" sortable="true" sortBy="#{antec.patantEtat}">
                                                <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                                <h:outputText  value="#{antec.patantEtat}" title="#{antec.patantEtat}"/>
                                            </rich:column>
                                            <rich:column width="45%" sortable="true" sortBy="#{antec.patantObservation}">
                                                <f:facet name="header"><h:outputText  value="Observations"/></f:facet>
                                                <h:outputText  value="#{antec.patantObservation}" title="#{antec.patantObservation}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabAnamese" label="Anamèse" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesConsultation}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <h:panelGrid width="100%">
                                        <h:outputText value="Description de la plainte:" />
                                        <rich:editor theme="advanced" plugins="safari,spellchecker,pagebreak,style,layer,table,save,advhr,advimage,advlink,iespell,inlinepopups,insertdatetime,preview,media,searchreplace,print,contextmenu,paste,directionality,fullscreen,noneditable,visualchars,nonbreaking,xhtmlxtras,template" viewMode="visual" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgAnamese}" readonly="true">
                                            <jsp:include flush="true" page="../css/tdt.jsp"/>
                                        </rich:editor>
                                    </h:panelGrid>
                                </rich:tab>

                                <rich:tab id="tabInfirmerie" label="Infirmerie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesInfirmerie}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" id="idPanAT">
                                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                                            <f:facet name="header"><h:outputText value="Informations patient"/></f:facet>
                                            <h:column><h:outputText value="N° C.N.S.S.:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patSecu}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="N° C.N.A.M.G.S.:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.patients.patCnamgs}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Anciénneté:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccAnciennete}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Nombre salariés de l'entreprise:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccNbSalaries}" style="width:100%" readonly="true"/></h:column>
                                        </h:panelGrid>
                                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                                            <f:facet name="header"><h:outputText value="Accident"/></f:facet>
                                            <h:column><h:outputText value="Date accident:"/></h:column>
                                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_date_accident}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="true"/></h:column>
                                            <h:column><h:outputText value="Heure/minute accident:"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_heures}" size="2" readonly="true"/>&nbsp;&nbsp;
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_minutes}"  size="2" readonly="true"/>
                                            </h:column>
                                            <h:column><h:outputText value="Lieu:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccLieuAccident}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value=""/></h:column>
                                            <h:column><h:outputText value=""/></h:column>
                                            <h:column><h:outputText value="Nature des lésions"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccNatureLesion}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Siège lésions:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccSiegeLesion}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Causes accident:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccCause}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Horaires du salarié:"/></h:column>
                                            <h:column>
                                                <h:outputText value="de:"/>&nbsp;
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccHoraireDebut}" style="width:40%" readonly="true"/>&nbsp;&nbsp;
                                                <h:outputText value="à:"/>&nbsp;
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccHoraireFin}" style="width:40%" readonly="true"/>
                                            </h:column>
                                        </h:panelGrid>
                                        <h:panelGrid headerClass="headerTab" width="100%" styleClass="fichefournisseur">
                                            <f:facet name="header"><h:outputText value="Circonstances Accident"/></f:facet>
                                            <h:column><h:inputTextarea rows="4" style="width:100%;background:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccCirconstance}" readonly="true"/></h:column>
                                        </h:panelGrid>
                                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                                            <h:column><h:outputText value="Machine ou produit:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccMateriel}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Sécurité:"/></h:column>
                                            <h:column>
                                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccSecurite}" style="width:100%"  readonly="true">
                                                    <f:selectItem itemLabel="Sans matériel de sécurité" itemValue="0"/>
                                                    <f:selectItem itemLabel="Avec matériel de sécurité" itemValue="1"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column><h:outputText value="Type 1er sécours:"/></h:column>
                                            <h:column>
                                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccSecours}" style="width:100%"  readonly="true">
                                                    <f:selectItem itemLabel="Secouriste" itemValue="0"/>
                                                    <f:selectItem itemLabel="Infirmier" itemValue="1"/>
                                                    <f:selectItem itemLabel="Médecin" itemValue="2"/>
                                                    <f:selectItem itemLabel="Pompier" itemValue="3"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column><h:outputText value="Nom médecin:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccMedecin}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Suite probable:"/></h:column>
                                            <h:column>
                                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccSuite}" style="width:100%"  readonly="true">
                                                    <f:selectItem itemLabel="Sans arrêt" itemValue="0"/>
                                                    <f:selectItem itemLabel="Arrêt > 24 h" itemValue="1"/>
                                                    <f:selectItem itemLabel="Déces immédiat" itemValue="2"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column><h:outputText value=""/></h:column>
                                            <h:column><h:outputText value=""/></h:column>
                                        </h:panelGrid>
                                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur1">
                                            <f:facet name="header"><h:outputText value="Témoin"/></f:facet>
                                            <h:column><h:outputText value="Nom témoin:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccTemoin}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Adresse témoin:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccAdresseTemoin}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Rapport de police:"/></h:column>
                                            <h:column>
                                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccRapportPolice}" style="width:100%"  readonly="true">
                                                    <f:selectItem itemLabel="Non fait" itemValue="0"/>
                                                    <f:selectItem itemLabel="Etabli" itemValue="1"/>
                                                </h:selectOneMenu>
                                            </h:column>
                                            <h:column><h:outputText value="Par qui ?"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccNomPolice}" style="width:100%" readonly="true"/></h:column>
                                        </h:panelGrid>
                                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                                            <f:facet name="header"><h:outputText value="Risque causé par un tiers"/></f:facet>
                                            <h:column><h:outputText value="Nom reponsable:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccNomTiers}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Adresse responsable:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccAdresseTiers}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Assureur:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccAssuranceTiers}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="N° Assurance:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccNumTiers}" style="width:100%" readonly="true"/></h:column>
                                        </h:panelGrid>
                                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                                            <f:facet name="header"><h:outputText value="Salaire de référence"/></f:facet>
                                            <h:column><h:outputText value="Date bulletin:"/></h:column>
                                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccDatePaye}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="true"/></h:column>
                                            <h:column><h:outputText value="Période:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccPeriodePaye}" style="width:100%" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Salaire brut:"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccBrut}" style="text-align:right" readonly="true">
                                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column><h:outputText value="Heures Supp.:"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccHSup}" style="text-align:right" readonly="true">
                                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column><h:outputText value="Primes:"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccPrimes}" style="text-align:right" readonly="true">
                                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column><h:outputText value="Ration:"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccRation}" style="text-align:right" readonly="true">
                                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column><h:outputText value="Logement:"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccLogement}" style="text-align:right" readonly="true">
                                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column><h:outputText value="Divers:"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccDivers}" style="text-align:right" readonly="true">
                                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column><h:outputText value="Total:"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccTotal}" style="text-align:right" readonly="true">
                                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                                </h:inputText>
                                            </h:column>
                                        </h:panelGrid>
                                        <h:panelGrid headerClass="headerTab" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" styleClass="fichefournisseur">
                                            <f:facet name="header"><h:outputText value="Signature déclaration"/></f:facet>
                                            <h:column><h:outputText value="Date rédaction:"/></h:column>
                                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccDateDocument}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="true"/></h:column>
                                            <h:column><h:outputText value="Signature:"/></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationInfirmerie.cslaccSignataire}" style="width:100%" readonly="true"/></h:column>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </rich:tab>

                                <rich:tab id="tabConsExmenClinique" label="Examen clinique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesConsultation}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <h:panelGrid width="100%" >
                                        <h:panelGrid id="idExaCli" style="background-color:#DAEECB;" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                                            <h:column><h:outputText value="Poids (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_lib_poids}):" /></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgPoids}" style="text-align:right;" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Taille (cm):" /></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgTaille}" style="text-align:right;" readonly="true"/></h:column>
                                            <h:column><h:outputText value="IMC (P/T²):" /></h:column>
                                            <h:column>
                                                <h:inputText id="idIcm" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgImc}" style="text-align:right;" readonly="true">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:inputText>
                                            </h:column>
                                            <h:column><h:outputText value="Température (°c):" /></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgTemperature}" style="text-align:right;" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Fréquence cardiaque:" /></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgFreCar}" style="text-align:right;" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Fréquence respiratoire:" /></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgFreRes}" style="text-align:right;" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Diurèse (ml/H):" /></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgDiurese}" style="text-align:right;" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Tension bras gauche:" /></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgTension}" style="text-align:right;" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Tension bras droit:" /></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgTensionDroit}" style="text-align:right;" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Oeil gauche:" /></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgOeilGauche}" style="text-align:right;" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Oeil droit:" /></h:column>
                                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgOeilDroit}" style="text-align:right;" readonly="true"/></h:column>
                                            <h:column><h:outputText value="" /></h:column>
                                            <h:column><h:outputText value="" /></h:column>
                                        </h:panelGrid>
                                        <h:panelGrid width="100%">
                                            <h:outputText value="Résumé syndromique:" />
                                            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgExamClinique}" rows="5" style="width:100%" readonly="true"/>
                                        </h:panelGrid>
                                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" id="diag">
                                            <h:column><h:outputText value="Hypothèse diagnostic 1:" style="text-decoration:underline;"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgCodeDiag1}" style="width:100px" readonly="true"/>&nbsp;&nbsp;
                                                <h:inputText id="lib1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.lib_diag1}" style="width:80%" readonly="true"/>
                                            </h:column>
                                            <h:column><h:outputText value="Hypothèse diagnostic 2:" style="text-decoration:underline;"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgCodeDiag2}" style="width:100px" readonly="true"/>&nbsp;&nbsp;
                                                <h:inputText id="lib2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.lib_diag2}" style="width:80%" readonly="true"/>
                                            </h:column>
                                            <h:column><h:outputText value="Hypothèse diagnostic 3:" style="text-decoration:underline;"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgCodeDiag3}" style="width:100px" readonly="true"/>&nbsp;&nbsp;
                                                <h:inputText id="lib3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.lib_diag3}" style="width:80%" readonly="true"/>
                                            </h:column>
                                            <h:column><h:outputText value="Hypothèse diagnostic 4:" style="text-decoration:underline;"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgCodeDiag4}" style="width:100px" readonly="true"/>&nbsp;&nbsp;
                                                <h:inputText id="lib4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.lib_diag4}" style="width:80%" readonly="true"/>
                                            </h:column>
                                            <h:column><h:outputText value="Hypothèse diagnostic 5:" style="text-decoration:underline;"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgCodeDiag5}" style="width:100px" readonly="true"/>&nbsp;&nbsp;
                                                <h:inputText id="lib5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.lib_diag5}" style="width:80%" readonly="true"/>
                                            </h:column>
                                        </h:panelGrid>
                                        <h:panelGrid width="100%">
                                            <h:outputText value="Discussion:" />
                                            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgDiscution}" rows="2" style="width:100%" readonly="true"/>
                                        </h:panelGrid>
                                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" id="diag2" style="border:1px solid green;background-color:#FFF8D4;">
                                            <h:column><h:outputText value="Diagnostic positif:" style="text-decoration:underline;"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgCodeDiag11}" style="width:100px" readonly="true"/>&nbsp;&nbsp;
                                                <h:inputText id="lib11" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.lib_diag11}" style="width:80%" readonly="true"/>
                                            </h:column>
                                            <h:column><h:outputText value="Diagnostic retentissement:" style="text-decoration:underline;"/></h:column>
                                            <h:column>
                                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgCodeDiag12}" style="width:100px" readonly="true"/>&nbsp;&nbsp;
                                                <h:inputText id="lib12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.lib_diag12}" style="width:80%" readonly="true"/>
                                            </h:column>
                                            <h:column><h:outputText value="Hospitalisation:" /></h:column>
                                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgChoixHospit}" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Mise en observation:" /></h:column>
                                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgChoixObs}" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Référé:" /></h:column>
                                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgChoixRefere}" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Demande de visite pré-anesthésique:" /></h:column>
                                            <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgChoixVisitepa}" readonly="true"/></h:column>
                                            <h:column><h:outputText value="Date prochain rendez-vous:" /></h:column>
                                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgRdv}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                                        </h:panelGrid>
                                        <h:panelGrid width="100%">
                                            <h:outputText value="Evolution:" />
                                            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgEvolution}" rows="2" style="width:100%" readonly="true"/>
                                        </h:panelGrid>
                                        <h:panelGrid width="100%">
                                            <h:outputText value="Pronostic:" />
                                            <h:inputTextarea value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.consultationEnteteGene.csgPronostic}" rows="2" style="width:100%" readonly="true"/>
                                        </h:panelGrid>
                                    </h:panelGrid>
                                </rich:tab>

                                <rich:tab id="tabConsActesExamens" label="Actes et examens" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesConsActesLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLigne" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelConsActesLignes}" var="acte" >
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{acte.cslactProduit}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="22%">
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:inputTextarea rows="1" value="#{acte.cslactLibelle}" readonly="true" style="width:95%"/>
                                            </rich:column>
                                            <rich:column label="Code lettre" sortable="false" width="8%">
                                                <f:facet name="header"><h:outputText  value="Lettre"/></f:facet>
                                                <h:outputText value="#{acte.cslactLettre}: #{acte.cslactNb}*#{acte.cslactValeur}" rendered="#{acte.cslactNb!=0}"/>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right" width="5%" >
                                                <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                                <h:outputText value="#{acte.cslactQte}" />
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="P.U.ST."/></f:facet>
                                                <h:outputText value="#{acte.cslactPuRem}" rendered="#{acte.cslactPuRem!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{acte.cslactPuCnamgs!=0}">
                                                <f:facet name="header"><h:outputText value="P.U.CNAMGS"/></f:facet>
                                                <h:outputText value="#{acte.cslactPuCnamgs}" rendered="#{acte.cslactPuCnamgs!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="5%">
                                                <f:facet name="header"><h:outputText  value="Rem.%"/></f:facet>
                                                <h:outputText value="#{acte.cslactRemise}" rendered="#{acte.cslactRemise!=0}" />
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="P.U.Rem."/></f:facet>
                                                <h:outputText value="#{acte.cslactPuRem}" rendered="#{acte.cslactPuRem!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                                <h:outputText value="#{acte.cslactPatientHt}" rendered="#{acte.cslactPatientHt!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                                                <h:outputText value="#{acte.totalTiers}" rendered="#{acte.totalTiers!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabConsOrdonance" label="Ordonance" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesConsOrdoLigne}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableOrdo" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelConsOrdoLigne}" var="ordo" >
                                            <rich:column label="Code CIP" sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{ordo.cslordProduit}"/>
                                            </rich:column>
                                            <rich:column label="Spécialité du médicamment" sortable="false" width="30%">
                                                <f:facet name="header"><h:outputText  value="Spécialité"/></f:facet>
                                                <h:outputText value="#{ordo.cslordLibelle}"/>
                                            </rich:column>
                                            <rich:column label="Posologie" sortable="false" width="30%">
                                                <f:facet name="header"><h:outputText  value="Posologie"/></f:facet>
                                                <h:outputText value="#{ordo.cslordPoso}"/>
                                            </rich:column>
                                            <rich:column label="Observations" sortable="false" width="30%">
                                                <f:facet name="header"><h:outputText  value="Observations"/></f:facet>
                                                <h:outputText value="#{ordo.cslordObs}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabConsLaboratoire" label="Prescription laboratoire" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesConsLaboLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLabo" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelConsLaboLignes}" var="labo" >
                                            <rich:column label="Code" sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{labo.csllabProduit}"/>
                                            </rich:column>
                                            <rich:column label="Nom de l'examen" sortable="false" width="450%">
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:outputText value="#{labo.csllabLibelle}"/>
                                            </rich:column>
                                            <rich:column label="Observations" sortable="false" width="45%">
                                                <f:facet name="header"><h:outputText  value="Observations"/></f:facet>
                                                <h:outputText value="#{labo.csllabObs}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabConsPharmacie" label="Pharmacie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesConsMediLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tablePharmacie" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelConsMediLignes}" var="phar" >
                                            <rich:column label="Code CIP" sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{phar.phaligProduit}"/>
                                            </rich:column>
                                            <rich:column label="Spécialité du médicamment" sortable="false" width="30%">
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:outputText value="#{phar.phaligLibelle}"/>
                                            </rich:column>
                                            <rich:column label="Dépôt" sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Dépôt"/></f:facet>
                                                <h:outputText value="#{phar.phaligDepot}"/>
                                            </rich:column>
                                            <rich:column label="Unité" sortable="false" width="20%">
                                                <f:facet name="header"><h:outputText  value="Unité"/></f:facet>
                                                <h:outputText value="#{phar.var_lib_uni_condit}"/>
                                            </rich:column>
                                            <rich:column label="Quantité" sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                                <h:outputText value="#{phar.phaligQte}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabConsScan" label="Scan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesConsScan}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelConsScan}" var="document" >
                                            <f:facet name="header"></f:facet>
                                            <rich:column>
                                                <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.lectureDocConsultation}" reRender="panalVisuPjCons"/>
                                                <br>
                                                <h:outputText value="#{document}"/>
                                            </rich:column>
                                        </rich:dataGrid>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabConsReglement" label="Règlement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesConsRegLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date consultation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelConsRegLignes}"  var="recu"  sortMode="multi">
                                            <rich:column sortable="false" width="10%" sortOrder="DESCENDING" sortBy="#{recu.csgregDate}">
                                                <f:facet name="header"><h:outputText  value="Date reçu."/></f:facet>
                                                <h:outputText value="#{recu.csgregDate}">
                                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="N° reçu"/></f:facet>
                                                <h:outputText value="#{recu.csgregNumRecu}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                                <h:outputText  value="#{recu.csgregService}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%" style="text-align:right">
                                                <f:facet name="header"><h:outputText  value="Montant"/></f:facet>
                                                <h:outputText value="#{recu.csgregPatient}" rendered="#{recu.csgregPatient!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" width="18%">
                                                <f:facet name="header"><h:outputText  value="Caisse"/></f:facet>
                                                <h:outputText  value="#{recu.csgregCaisse}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="15%">
                                                <f:facet name="header"><h:outputText  value="Produit"/></f:facet>
                                                <h:outputText value="#{recu.csgregProduit} #{recu.csgregLibelle}" title="#{recu.csgregProduit} #{recu.csgregLibelle}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabPhaPharmacie" label="Pharmacie" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesPharmaciesLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro facture pharmacie:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date facture pharmacie:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLigne2" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelPharmaciesLignes}" var="pha" >
                                            <rich:column sortable="false" width="8%">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{pha.phaligProduit}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="22%">
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:inputTextarea rows="1" value="#{pha.phaligLibelle}" readonly="true" style="width:95%"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="5%" >
                                                <f:facet name="header"><h:outputText  value="Dépot"/></f:facet>
                                                <h:outputText value="#{pha.phaligDepot}"/>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right" width="5%" >
                                                <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                                <h:outputText value="#{pha.phaligQte}" />
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="P.U.HT"/></f:facet>
                                                <h:outputText value="#{pha.phaligPu}" rendered="#{pha.phaligPu!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%" rendered="#{pha.phaligPuCnamgs!=0}">
                                                <f:facet name="header"><h:outputText value="P.U.CNAMGS"/></f:facet>
                                                <h:outputText value="#{pha.phaligPuCnamgs}" rendered="#{pha.phaligPuCnamgs!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="5%">
                                                <f:facet name="header"><h:outputText  value="Rem.%"/></f:facet>
                                                <h:outputText value="#{pha.phaligRemise}" rendered="#{pha.phaligRemise!=0}" />
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="PRem.HT"/></f:facet>
                                                <h:outputText value="#{pha.phaligPuRem}" rendered="#{pha.phaligPuRem!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                                <h:outputText value="#{pha.phaligPatientHt}" rendered="#{pha.phaligPatientHt!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                                                <h:outputText value="#{pha.totalTiers}" rendered="#{pha.totalTiers!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabPhaReglement" label="Règlement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesPhaRegLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro facture pharmacie:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date facture pharmacie:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelPhaRegLignes}"  var="recu"  sortMode="multi">
                                            <rich:column sortable="false" width="10%" sortOrder="DESCENDING" sortBy="#{recu.pharegDate}">
                                                <f:facet name="header"><h:outputText  value="Date reçu."/></f:facet>
                                                <h:outputText value="#{recu.pharegDate}">
                                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="N° reçu"/></f:facet>
                                                <h:outputText value="#{recu.pharegNumRecu}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                                <h:outputText  value="#{recu.pharegService}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%" style="text-align:right">
                                                <f:facet name="header"><h:outputText  value="Montant"/></f:facet>
                                                <h:outputText value="#{recu.pharegPatient}" rendered="#{recu.pharegPatient!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" width="18%">
                                                <f:facet name="header"><h:outputText  value="Caisse"/></f:facet>
                                                <h:outputText  value="#{recu.pharegCaisse}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="15%">
                                                <f:facet name="header"><h:outputText  value="Produit"/></f:facet>
                                                <h:outputText value="#{recu.pharegProduit} #{recu.pharegLibelle}" title="#{recu.pharegProduit} #{recu.pharegLibelle}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabLabExamen" label="Examens" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesLabExamensLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro facture laboratoire:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date facture laboratoire:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLigne3" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelLabExamensLignes}" var="acte" >
                                            <rich:column  width="10%" sortable="true" sortBy="#{antec.labligLaboratoire}">
                                                <f:facet name="header"><h:outputText  value="Labo."/></f:facet>
                                                <h:outputText value="#{acte.labligLaboratoire}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="8%">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{acte.labligProduit}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="22%">
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:inputTextarea rows="1" value="#{acte.labligLibelle}" readonly="true" style="width:95%"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="5%">
                                                <f:facet name="header"><h:outputText  value="Taxe"/></f:facet>
                                                <h:outputText value="#{acte.labligCodeTva}"/>
                                            </rich:column>
                                            <rich:column label="Code lettre" sortable="false" style="text-align:right" width="12%" >
                                                <f:facet name="header"><h:outputText  value="Lettre"/></f:facet>
                                                <h:outputText value="#{acte.labligLettre}: #{acte.labligNb} * #{acte.labligValeur} (#{acte.labligCoef})" rendered="#{acte.labligNb!=0}"/>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right" width="5%" >
                                                <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                                <h:outputText value="#{acte.labligQte}" />
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="P.U.HT"/></f:facet>
                                                <h:outputText value="#{acte.labligPu}" rendered="#{acte.labligPu!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="5%">
                                                <f:facet name="header"><h:outputText  value="Rem.%"/></f:facet>
                                                <h:outputText value="#{acte.labligRemise}" rendered="#{acte.labligRemise!=0}" />
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="PRem.HT"/></f:facet>
                                                <h:outputText value="#{acte.labligPuRem}" rendered="#{acte.labligPuRem!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                                <h:outputText value="#{acte.labligPatientHt}" rendered="#{acte.labligPatientHt!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                                                <h:outputText value="#{acte.totalTiers}" rendered="#{acte.totalTiers!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabLabScan" label="Scan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesLabScan}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro facture laboratoire:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date facture laboratoire:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelLabScan}" var="document" >
                                            <f:facet name="header"></f:facet>
                                            <rich:column>
                                                <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.lectureDocLaboratoire}" reRender="panalVisuPjLab"/>
                                                <br>
                                                <h:outputText value="#{document}"/>
                                            </rich:column>
                                        </rich:dataGrid>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabLabReglement" label="Règlement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesLabRegLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro facture laboratoire:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date facture laboratoire:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelLabScan}"  var="recu"  sortMode="multi">
                                            <rich:column sortable="false" width="10%" sortOrder="DESCENDING" sortBy="#{recu.labregDate}">
                                                <f:facet name="header"><h:outputText  value="Date reçu."/></f:facet>
                                                <h:outputText value="#{recu.labregDate}">
                                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="N° reçu"/></f:facet>
                                                <h:outputText value="#{recu.labregNumRecu}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                                <h:outputText  value="#{recu.labregService}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%" style="text-align:right">
                                                <f:facet name="header"><h:outputText  value="Montant"/></f:facet>
                                                <h:outputText value="#{recu.labregPatient}" rendered="#{recu.csgregPatient!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" width="18%">
                                                <f:facet name="header"><h:outputText  value="Caisse"/></f:facet>
                                                <h:outputText  value="#{recu.labregCaisse}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="15%">
                                                <f:facet name="header"><h:outputText  value="Produit"/></f:facet>
                                                <h:outputText value="#{recu.labregProduit} #{recu.labregLibelle}" title="#{recu.labregProduit} #{recu.labregLibelle}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabHosSejour" label="Séjours" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesHosSejoursLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro hospitalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date entrée hositalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableSejour" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 1px green" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelHosSejoursLignes}" var="sejour">
                                            <rich:column label="Code" sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Entrée"/></f:facet>
                                                <h:outputText  value="#{sejour.hossejDateEntree}">
                                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Provenance" sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Provenance"/></f:facet>
                                                <h:outputText value="#{sejour.libelleProvenance}"/>
                                            </rich:column>
                                            <rich:column label="Nom de l'examen" sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Sortie"/></f:facet>
                                                <h:outputText value="#{sejour.hossejDateSortie}">
                                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Destination" sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Destination"/></f:facet>
                                                <h:outputText value="#{sejour.libelleDestination}"/>
                                            </rich:column>
                                            <rich:column label="Service" sortable="false" width="20%">
                                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                                <h:outputText value="#{sejour.hossejService}"/>
                                            </rich:column>
                                            <rich:column label="Cétégorie de lit" sortable="false" width="20%">
                                                <f:facet name="header"><h:outputText  value="Lit"/></f:facet>
                                                <h:outputText value="#{sejour.hossejLit}:#{sejour.hossejLibelle}"/>
                                            </rich:column>
                                            <rich:column label="Part Patient" sortable="false" width="10%" style="text-align:right;">
                                                <f:facet name="header"><h:outputText  value="P.Patient"/></f:facet>
                                                <h:outputText value="#{sejour.totalPatient}" style="text-align:right;">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column label="Part Tiers" sortable="false" width="10%" style="text-align:right;">
                                                <f:facet name="header"><h:outputText  value="P.Tiers"/></f:facet>
                                                <h:outputText value="#{sejour.totalTiers}" style="text-align:right;">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabHosActes" label="Examens" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesHosExmanesLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro hospitalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date entrée hositalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableActes" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 0px green;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelHosExmanesLignes}" var="acte" >
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                                <h:outputText value="#{acte.hosactService}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Médecin"/></f:facet>
                                                <h:outputText value="#{acte.hosactMedecin}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="8%">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{acte.hosactProduit}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="32%">
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:inputTextarea rows="1" value="#{acte.hosactLibelle}" readonly="true" style="width:95%"/>
                                            </rich:column>
                                            <rich:column label="Code lettre" sortable="false" style="text-align:right" width="15%" >
                                                <f:facet name="header"><h:outputText  value="Lettre"/></f:facet>
                                                <h:outputText value="#{acte.hosactLettre}: #{acte.hosactNb} * #{acte.hosactValeur} (#{acte.hosactCoef})" rendered="#{acte.hosactNb!=0}"/>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                                <h:outputText value="#{acte.totalPatient}" rendered="#{acte.totalPatient!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                                                <h:outputText value="#{acte.totalTiers}" rendered="#{acte.totalTiers!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="5%">
                                                <f:facet name="header"><h:outputText value="Nb"/></f:facet>
                                                <h:outputText value="#{acte.hosactQte}" rendered="#{acte.hosactQte!=0}">
                                                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabHosLaboratoire" label="Laboratoire" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesHosLaboLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro hospitalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date entrée hositalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableLabo2" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 0px green;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelHosLaboLignes}" var="labo" >
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                                <h:outputText value="#{labo.hoslabService}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Laboratoire"/></f:facet>
                                                <h:outputText value="#{labo.hoslabLaboratoire}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="8%">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{labo.hoslabProduit}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="32%">
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:inputTextarea rows="1" value="#{labo.hoslabLibelle}" readonly="true" style="width:95%"/>
                                            </rich:column>
                                            <rich:column label="Code lettre" sortable="false" style="text-align:right" width="15%" >
                                                <f:facet name="header"><h:outputText  value="Lettre"/></f:facet>
                                                <h:outputText value="#{labo.hoslabLettre}: #{labo.hoslabNb} * #{labo.hoslabValeur} (#{labo.hoslabCoef})" rendered="#{labo.hoslabNb!=0}"/>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                                <h:outputText value="#{labo.totalPatient}" rendered="#{labo.totalPatient!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                                                <h:outputText value="#{labo.totalTiers}" rendered="#{labo.totalTiers!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabHosMedicament" label="Médicament" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesHosMediLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro hospitalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date entrée hositalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tableMedi" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 0px green;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelHosMediLignes}" var="ordo" >
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                                <h:outputText value="#{ordo.hosmedService}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Médecin"/></f:facet>
                                                <h:outputText value="#{ordo.hosmedMedecin}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="8%">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{ordo.hosmedProduit}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="22%">
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:outputText value="#{ordo.hosmedLibelle}"/>
                                            </rich:column>
                                            <rich:column label="Dépot" sortable="false" width="12%" >
                                                <f:facet name="header"><h:outputText  value="Dépot"/></f:facet>
                                                <h:outputText value="#{ordo.hosmedDepot}"/>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right" width="5%" >
                                                <f:facet name="header"><h:outputText  value="Qté"/></f:facet>
                                                <h:outputText value="#{ordo.hosmedQte}" />
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                                <h:outputText value="#{ordo.totalPatient}" rendered="#{ordo.totalPatient!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                                                <h:outputText value="#{ordo.totalTiers}" rendered="#{ordo.totalTiers!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabPrestation" label="Autres prestations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesHosPrestLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro hospitalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date entrée hositalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable border="0" headerClass="headerTab" id="tablePrest" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" height="300px" width="100%" style="border:solid 0px green;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelHosPrestLignes}" var="prest" >
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                                <h:outputText value="#{prest.hoslabService}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="Médecin"/></f:facet>
                                                <h:outputText value="#{prest.hoslabMedecin}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="8%">
                                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                                <h:outputText  value="#{prest.hosprtProduit}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="32%">
                                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                                <h:inputTextarea rows="1" value="#{prest.hosprtLibelle}" readonly="true" style="width:95%"/>
                                            </rich:column>
                                            <rich:column label="Code lettre" sortable="false" style="text-align:right" width="15%" >
                                                <f:facet name="header"><h:outputText  value="Lettre"/></f:facet>
                                                <h:outputText value="#{prest.hosprtLettre}: #{prest.hosprtNb} * #{prest.hosprtValeur} (#{prest.hosprtCoef})" rendered="#{prest.hosprtNb!=0}"/>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Patient"/></f:facet>
                                                <h:outputText value="#{prest.totalPatient}" rendered="#{prest.totalPatient!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" style="text-align:right;" width="10%">
                                                <f:facet name="header"><h:outputText value="Tiers"/></f:facet>
                                                <h:outputText value="#{prest.totalTiers}" rendered="#{prest.totalTiers!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabHosScan" label="Scan" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesHosScan}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro hospitalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date entrée hositalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelHosScan}" var="document" >
                                            <f:facet name="header"></f:facet>
                                            <rich:column>
                                                <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.lectureDocHospitalisation}" reRender="panalVisuPjHos"/>
                                                <br>
                                                <h:outputText value="#{document}"/>
                                            </rich:column>
                                        </rich:dataGrid>
                                    </a4j:region>
                                </rich:tab>

                                <rich:tab id="tabHosReglement" label="Règlement" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.accesHosRegLignes}">
                                    <h:panelGrid width="100%" columns="4" styleClass="fichefournisseur">
                                        <h:outputText value="Numéro hospitalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.numeroDocument}" />
                                        <h:outputText value="Date entrée hositalisation:" />
                                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dateDocument}" />
                                    </h:panelGrid>
                                    <a4j:region renderRegionOnly="false">
                                        <rich:extendedDataTable height="200px" width="100%" border="0" headerClass="headerTab" activeClass="active-row" noDataLabel=" " style="margin-top:10px;border:solid 0px green;cursor:pointer;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.dataModelHosRegLignes}"  var="recu"  sortMode="multi">
                                            <rich:column sortable="false" width="10%" sortOrder="DESCENDING" sortBy="#{recu.hosregDate}">
                                                <f:facet name="header"><h:outputText  value="Date reçu."/></f:facet>
                                                <h:outputText value="#{recu.hosregDate}">
                                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%">
                                                <f:facet name="header"><h:outputText  value="N° reçu"/></f:facet>
                                                <h:outputText value="#{recu.hosregNumRecu}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="20%">
                                                <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                                <h:outputText  value="#{recu.hosregService}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="10%" style="text-align:right">
                                                <f:facet name="header"><h:outputText  value="Montant"/></f:facet>
                                                <h:outputText value="#{recu.hosregPatient}" rendered="#{recu.hosregPatient!=0}">
                                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                                </h:outputText>
                                            </rich:column>
                                            <rich:column sortable="false" width="20%">
                                                <f:facet name="header"><h:outputText  value="Caisse"/></f:facet>
                                                <h:outputText  value="#{recu.hosregCaisse}"/>
                                            </rich:column>
                                            <rich:column sortable="false" width="20%">
                                                <f:facet name="header"><h:outputText  value="Produit"/></f:facet>
                                                <h:outputText value="#{recu.hosregProduit}" title="#{recu.hosregProduit}"/>
                                            </rich:column>
                                        </rich:extendedDataTable>
                                    </a4j:region>
                                </rich:tab>

                            </rich:tabPanel>
                        </h:panelGrid>

                    </h:panelGrid>

                    <h:panelGrid id="paneltotal" columns="2" columnClasses="clos50d,clos50d" width="50%" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_total!=0}">
                        <h:column><h:outputText value="Total ventes (TTC):"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_total}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="Total règlements:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_total!=0}">
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_reglement}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                        <h:column><h:outputText value="Solde:"/></h:column>
                        <h:column>
                            <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formPatients.var_solde}" style="text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
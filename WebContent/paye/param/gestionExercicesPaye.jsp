<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="payeexo">

    <a4j:form>
        <center> <h2><h:outputText value="GESTION DES EXERCICES DE PAYE" style="color:green;"/></h2></center>
        <center>
            <h:panelGroup id="panButton">
                <a4j:commandButton title="Ajout d'excercice" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==8}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.creationExercicePaye}" oncomplete="javascript:Richfaces.showModalPanel('panelAjout');"  reRender="panelAjout,idFormAjout"/>&nbsp; &nbsp;&nbsp;
                <a4j:commandButton title="Modification d'excercice" image="/images/modifier.png" rendered="#{false&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.noExo&&((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayEtat==0)==true)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayId!=0}" oncomplete="javascript:Richfaces.showModalPanel('panelModif');"  reRender="panelModif"/>&nbsp;&nbsp;&nbsp;
                <h:commandButton title="Clôture d'excercice" image="/images/lock.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.noExo&&((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayEtat==0)==true)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayId!=0}" onclick="if (!confirm('Etes-vous sur de vouloir cloturer cet exercice ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.cloturer}"/>
            </h:panelGroup>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" border="0" activeClass="active-row" noDataLabel=" "align="center" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;cursor:pointer;background-color:white;" width="400px" headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.madatamodel}" var="exo">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.selectionLigneExercice}" reRender="panButton"/>
                    <rich:column >
                        <f:facet name="header"><h:outputText  value="Numéro"/></f:facet>
                        <h:outputText value="#{exo.indice}"/>
                    </rich:column>
                    <rich:column >
                        <f:facet name="header"><h:outputText  value="Date début"/></f:facet>
                        <h:outputText value="#{exo.exepayDateDebut}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header"><h:outputText  value="Date fin"/></f:facet>
                        <h:outputText value="#{exo.exepayDateFin}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                        <h:outputText value="#{exo.etat}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille!=8}"/>
            <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelAjout" width="400" height="300"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="NOUVEL EXERCICE DE PAYE"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hideAjout"/>
                <rich:componentControl for="panelAjout" attachTo="hideAjout" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form id="idFormAjout">
            <h:panelGrid border="0" columns="1" style="width:100%;text-align:left;">
                <h:panelGroup>
                    <h:outputText value="Date début (JJ/MM/AAAA):"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDateDebut}" locale="FR"  enableManualInput="true" datePattern="dd/MM/yyyy" ></rich:calendar>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Date de fin (JJ/MM/AAAA):"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDateFin}" locale="FR"  enableManualInput="true" datePattern="dd/MM/yyyy" ></rich:calendar>
                </h:panelGroup>
            </h:panelGrid>
            <br/> <br/>
            <center>
                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.miseAJourCreationPaye}">
                    <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelExcptAjout,table,panButton,menuHorizontal"/>
                </h:commandButton>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelModif" width="400" height="550"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="MODIFICATION DE L'EXERCICE DE PAYE"></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hideModif"/>
                <rich:componentControl for="panelModif" attachTo="hideModif" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <h:panelGrid border="0" columns="1" width="100%" style="text-align:left;">
                <rich:tabPanel switchType="client" immediate="true" id="tabPanelsalaries" style="border:0px;">
                    <rich:tab name="periode" label="Période">
                        <h:panelGroup>
                            <center>
                                <h:outputText value="Date de fin (JJ/MM/AAAA):"/>
                                <br><br>
                                <rich:calendar style="background-color:white;" id="dateExerctfinModif" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDateFin}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="false"/>
                            </center>
                        </h:panelGroup>
                    </rich:tab>
                    <rich:tab name="bordereau" label="Bordereau">
                        <h:panelGrid width="100%" columns="3" border="0">
                            <h:column><h:outputText value=""/></h:column>
                            <h:column><h:outputText value="N° Bordereaux"/></h:column>
                            <h:column><h:outputText value="Date Versement (JJ/MM/AAAA)"/></h:column>
                            <h:column><h:outputText value="Janvier"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd01}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd01}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Février"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd02}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd02}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Mars"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd03}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd03}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Avril"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd04}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd04}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Mai"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd05}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd05}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Juin"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd06}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd06}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Juillet"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd07}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd07}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Aout"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd08}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd08}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Septembre"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd09}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd09}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Octobre"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd10}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd10}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Novembre"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd11}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd11}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                            <h:column><h:outputText value="Décembre"/></h:column>
                            <h:column><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayNumBrd12}"/></h:column>
                            <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayDteBrd12}"  inputSize="8" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="true" style="background-color:white;"/></h:column>
                        </h:panelGrid>
                        <br>
                        <h:panelGrid width="100%" columns="2">
                            <h:column><h:outputText value="Commissions honoraires Redevances versées"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.exercicesPaye.exepayRedevance}" size="7" style="text-align:right;">
                                    <jsp:include flush="true" page="../../commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>
                </rich:tabPanel>
                <br/>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.modifier}"/>
                    </center>
                </h:panelGroup>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelCloture" headerClass="headerPanel" width="400" height="300" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="Clôture de l'exercice "></h:outputText></f:facet>
        <f:facet name="controls">
            <a4j:form>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hideCloture"/>
                <rich:componentControl for="panelCloture" attachTo="hideCloture" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form>
            <h:panelGrid border="0" columns="1" width="100%">
                <h:outputText value="La date de fin doit être après celle de début" style="color:red;"/>
                <h:panelGroup>
                    <h:outputText value="Date de fin de période"/>&nbsp;&nbsp;
                    <rich:calendar  style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.datecloture}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy" >
                    </rich:calendar>
                </h:panelGroup>
                <br><br>
                <center>
                    <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesPaye.cloturer}" image="/images/valider_big.png" title="Valider"/>
                </center>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>


</f:subview>
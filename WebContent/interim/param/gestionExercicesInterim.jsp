<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="ecritureex">

    <a4j:form id="form1" >
        <center> <h2><h:outputText value="GESTION DES EXERCICES INTERIM" style="color:green;"/></h2></center>
        <center>
            <h:panelGroup id="panButton">
                <a4j:commandButton title="Ajout d'excercice" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==11}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.creationExerciceInterim}" oncomplete="javascript:Richfaces.showModalPanel('panelExcptAjout');"  reRender="panelExcptAjout"/>&nbsp; &nbsp;&nbsp;
                <a4j:commandButton title="Modification d'excercice" image="/images/modifier.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.noExo&&((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.exercicesVentes.exevteEtat=='0')==true)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.exercicesVentes.exevteId!=0}" oncomplete="javascript:Richfaces.showModalPanel('panel2ModifyEx');"  reRender="panel2ModifyEx"/>&nbsp;&nbsp;&nbsp;
                <h:commandButton title="Clôture d'excercice" image="/images/lock.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.noExo&&((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.exercicesVentes.exevteEtat=='0')==true)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.exercicesVentes.exevteId!=0}" onclick="if (!confirm('Etes-vous sur de vouloir cloturer cet exercice ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.cloturer}"/>
            </h:panelGroup>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" border="0" activeClass="active-row" noDataLabel=" "align="center" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;cursor:pointer;background-color:white;" width="400px" headerClass="headerTab"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.madatamodel}" var="exo">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.selectionLigneExercice}" reRender="panButton"/>
                    <rich:column >
                        <f:facet name="header"><h:outputText  value="Numéro" /></f:facet>
                        <h:outputText value="#{exo.indice}" />
                    </rich:column>
                    <rich:column >
                        <f:facet name="header"><h:outputText  value="Date début"  /></f:facet>
                        <h:outputText value="#{exo.exevteDateDebut}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header"><h:outputText  value="Date fin" /></f:facet>
                        <h:outputText value="#{exo.exevteDateFin}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                        <h:outputText value="#{exo.etat}" />
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille!=3}"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelExcptAjout" width="400" height="300"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header">
            <h:outputText value="NOUVEL EXERCICE INTERIM"></h:outputText>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkModalEX"/>
                <rich:componentControl for="panelExcptAjout" attachTo="hidelinkModalEX" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form id="form2EX">
            <h:panelGrid border="0" columns="1" style="width:100%;text-align:left;" id="pgrd1EX">
                <h:panelGroup>
                    <h:outputText value="Date début:"/> &nbsp;&nbsp;  &nbsp;&nbsp;
                    <rich:calendar style=" background-color:white;" locale="FR"  id="dateExercicetdeb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.exercicesVentes.exevteDateDebut}" enableManualInput="true" datePattern="dd/MM/yyyy" >
                    </rich:calendar>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Date de fin:"/> &nbsp;&nbsp;  &nbsp;&nbsp;
                    <rich:calendar style=" background-color:white;" id="dateExercicetfin" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.exercicesVentes.exevteDateFin}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  >
                    </rich:calendar>
                </h:panelGroup>
            </h:panelGrid>
            <br/> <br/>
            <center>
                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.miseAJourCreationInterim}">
                    <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelExcptAjout,table,panButton,menuHorizontal"/>
                </h:commandButton>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panel2ModifyEx" width="400" height="400"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="MODIFICATION DE L'EXERCICE INTERIM"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink1modifyEx"/>
                <rich:componentControl for="panel2ModifyEx" attachTo="hidelink1modifyEx" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form>
            <h:panelGrid border="0" columns="1" width="100%" style="text-align:left;" id="pgrd2Exerc">
                <h:panelGroup>
                    <center>
                        <h:outputText value="Date de fin:"/>
                        <br><br>
                        <rich:calendar style="background-color:white;" id="dateExerctfinModif" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.exercicesVentes.exevteDateFin}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="false"/>
                    </center>
                </h:panelGroup>
                <br/> <br/>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.modifier}" >
                            <a4j:support eventsQueue="maQueue" event="onclick" reRender="panel2ModifyEx,table,panButton"/>
                        </h:commandButton>
                    </center>
                </h:panelGroup>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelcontrolExVte" headerClass="headerPanel" width="400" height="300" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="Clôture de l'exercice "></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup><a4j:form>
                    <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkExer"/>
                    <rich:componentControl for="panelcontrolExVte" attachTo="hidelinkExer" operation="hide" event="onclick"/>
                </a4j:form>
            </h:panelGroup>
        </f:facet>
        <a4j:form id="formcontrolExercVte">
            <h:panelGrid border="0" columns="1" width="100%"  id="pgrdAj">
                <h:outputText value="La date de fin doit être après celle de début" style="color:red;"/>
                <h:panelGroup>
                    <h:outputText value="Date de fin de période"/> &nbsp;&nbsp;
                    <rich:calendar  style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.datecloture}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy" >
                    </rich:calendar>
                </h:panelGroup>
                <br><br>
                <center>
                    <h:commandButton  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesInterim.cloturer}" image="/images/valider_big.png" title="Valider"/>
                </center>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>


</f:subview>
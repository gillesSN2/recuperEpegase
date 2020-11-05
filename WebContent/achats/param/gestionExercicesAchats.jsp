<%@page contentType="text/html" %>
<%@page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html" %>
<%@taglib prefix="rich" uri="http://richfaces.org/rich" %>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j" %>


<f:subview id="achatexo">

    <a4j:form id="form1">
        <center><h2><h:outputText value="GESTION DES EXERCICES DES ACHATS" style="color:green;"/></h2></center>
        <center>
            <h:panelGroup id="panButton">
                <a4j:commandButton title="Ajout d'excercie" image="/images/ajouter.png"
                                   rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==2}"
                                   action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.creationExerciceAchat}"
                                   oncomplete="javascript:Richfaces.showModalPanel('panelExcptAjout');"
                                   reRender="panelExcptAjout"/>&nbsp; &nbsp;&nbsp;
                <a4j:commandButton title="Modification d'excercie" image="/images/modifier.png"
                                   rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.noExo&&((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.exercicesAchats.exeachEtat=='0')==true)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.exercicesAchats.exeachId!=0}"
                                   oncomplete="javascript:Richfaces.showModalPanel('panel2ModifyEx');"
                                   reRender="panel2ModifyEx"/>&nbsp; &nbsp;&nbsp;
                <h:commandButton title="Clôture d'excercie" image="/images/lock.png"
                                 rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.noExo&&((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.exercicesAchats.exeachEtat=='0')==true)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.exercicesAchats.exeachId!=0}"
                                 onclick="if (!confirm('Etes-vous sur de vouloir cloturer cet exercice ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"
                                 action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.cloturer}"/>
            </h:panelGroup>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" border="0" activeClass="active-row" noDataLabel=" " align="center"
                                        rowClasses="rows1,rows2,rowsd" styleClass="bg"
                                        style="max-height:100%;border:solid 0px green;text-align:left;cursor:pointer;background-color:white;"
                                        width="400px" headerClass="headerTab"
                                        value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.madatamodel}"
                                        var="exo">
                    <a4j:support eventsQueue="maQueue" event="onRowClick"
                                 action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.selectionLigneExercice}"
                                 reRender="panButton"/>
                    <rich:column>
                        <f:facet name="header"><h:outputText value="Numéro"/></f:facet>
                        <h:outputText value="#{exo.indice}"/>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header"><h:outputText value="Date début"/></f:facet>
                        <h:outputText value="#{exo.exeachDateDebut}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header"><h:outputText value="Date fin"/></f:facet>
                        <h:outputText value="#{exo.exeachDateFin}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header"><h:outputText value="Etat"/></f:facet>
                        <h:outputText value="#{exo.etat}"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
            <br>
            <h:commandButton id="idCancel" value="RETOUR" styleClass="exp_lienmenu"
                             action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}"
                             rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille!=2}"/>
            <rich:hotKey key="esc" handler="#{rich:element('idCancel')}.click()"/>
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent" id="panelExcptAjout" width="400" height="300"
                     headerClass="headerPanel"
                     style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header">
            <h:outputText value="NOUVEL EXERCICE D'ACHAT"></h:outputText>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkModalEX"/>
                <rich:componentControl for="panelExcptAjout" attachTo="hidelinkModalEX" operation="hide"
                                       event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form id="form2EX">
            <h:panelGrid border="0" columns="1" style="width:100%;text-align:left;" id="pgrd1EX">
                <h:panelGroup>
                    <h:outputText value="Date début:"/> &nbsp;&nbsp; &nbsp;&nbsp;
                    <rich:calendar style=" background-color:white;" locale="FR" id="dateExercicetdeb"
                                   value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.exercicesAchats.exeachDateDebut}"
                                   enableManualInput="true" datePattern="dd/MM/yyyy">
                    </rich:calendar>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Date de fin:"/> &nbsp;&nbsp; &nbsp;&nbsp;
                    <rich:calendar style=" background-color:white;" id="dateExercicetfin"
                                   value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.exercicesAchats.exeachDateFin}"
                                   locale="FR" enableManualInput="true" datePattern="dd/MM/yyyy">
                    </rich:calendar>
                </h:panelGroup>
            </h:panelGrid>
            <br/> <br/>
            <center>
                <h:commandButton image="/images/valider_big.png"
                                 action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.miseAJourCreationAchat}">
                    <a4j:support eventsQueue="maQueue" event="onclick"
                                 reRender="panelExcptAjout,table,panButton,menuHorizontal"/>
                </h:commandButton>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panel2ModifyEx" width="400" height="400"
                     headerClass="headerPanel"
                     style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header">
            <h:panelGroup>
                <h:outputText value="MODIFICATION DE L'EXERCICE DES ACHATS"></h:outputText>
            </h:panelGroup>
        </f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelink1modifyEx"/>
                <rich:componentControl for="panel2ModifyEx" attachTo="hidelink1modifyEx" operation="hide"
                                       event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form>
            <h:panelGrid border="0" columns="1" width="100%" style="text-align:left;" id="pgrd2Exerc">
                <h:panelGroup>
                    <center>
                        <h:outputText value="Date de fin:"/>
                        <br><br>
                        <rich:calendar style="background-color:white;" id="dateExerctfinModif"
                                       value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.exercicesAchats.exeachDateFin}"
                                       locale="FR" enableManualInput="true" datePattern="dd/MM/yyyy" popup="false"/>
                    </center>
                </h:panelGroup>
                <br/> <br/>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png"
                                         action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.modifier}">
                            <a4j:support eventsQueue="maQueue" event="onclick"
                                         reRender="panel2ModifyEx,table,panButton"/>
                        </h:commandButton>
                    </center>
                </h:panelGroup>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" id="panelBarProg" headerClass="headerPanel"
                     style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"
                     width="600" height="80"
                     showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Cloture en cours..."/></f:facet>
        <a4j:form>
            <br>
            <a4j:outputPanel id="progressPanel">
                <rich:progressBar
                        value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.var_currentValue}"
                        style="width:100%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                    <h:outputText
                            value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.obm.texte} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.var_currentValue} / #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesAchats.var_valueMax}) "/>
                </rich:progressBar>
            </a4j:outputPanel>
        </a4j:form>
    </rich:modalPanel>


</f:subview>
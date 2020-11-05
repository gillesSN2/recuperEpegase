<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<script type="text/JavaScript" language="JavaScript">
    function verifForm(form2)
    {
        if(document.getElementById("form2:anneedeb").value >=document.getElementById("form2:anneefin").value){
            alert('Incohérence au niveau des dates: veuillez vérifier la date de fin  \!\!');
            exit(form2);
        }
        else
            form2.submit();
    }
</script>


<f:subview id="ecritureex">

    <a4j:form id="form1" >
        <center> <h2><h:outputText value="GESTION DES EXERCICES COMPTABLES" style="color:green;"/></h2></center>
        <center>
            <h:panelGroup id="panButton">
                <a4j:commandButton title="Ajout d'excercice" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.creationExerciceCompta}" oncomplete="javascript:Richfaces.showModalPanel('panelExcptAjout');"  reRender="panelExcptAjout"/>&nbsp; &nbsp;&nbsp;
                <a4j:commandButton title="Modification d'excercice" image="/images/modifier.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.noExo&&((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.exercicesComptable.execptEtat=='0')==true)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.exercicesComptable.execpt_id!=0}" oncomplete="javascript:Richfaces.showModalPanel('panel2ModifyEx');"  reRender="panel2ModifyEx"/>&nbsp; &nbsp;&nbsp;
                <a4j:commandButton title="Clôture d'excercice exercice sélectionné" image="/images/lock.png" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.noExo&&((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.exercicesComptable.execptEtat=='0')==true)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.exercicesComptable.execpt_id!=0}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.ouvrirCloture}" reRender="panelcontrolExVte"/>&nbsp; &nbsp;&nbsp;
                <h:commandButton title="Dé-Clôture d'excercice précédent" image="/images/unlock.png"  rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.noExo&&((bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.exercicesComptable.execptEtat=='0')==true)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.exercicesComptable.execpt_id!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.var_mode_anterieur}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.deCloture}" onclick="if (!confirm('Etes-vous sur de vouloir ANNULER LA CLOTURE de cet exercice ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
            </h:panelGroup>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:extendedDataTable id="table" border="0" activeClass="active-row" noDataLabel=" "align="center" rowClasses="rows1,rows2,rowsd" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;cursor:pointer;background-color:white;" width="400px" headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.madatamodel}" var="exo">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.selectionLigneExercice}" reRender="panButton"/>
                    <rich:column >
                        <f:facet name="header"><h:outputText  value="Numéro" /></f:facet>
                        <h:outputText value="#{exo.indice}" />
                    </rich:column>
                    <rich:column >
                        <f:facet name="header"><h:outputText  value="Date début"  /></f:facet>
                        <h:outputText value="#{exo.execptDateDebut}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column>
                        <f:facet name="header"><h:outputText  value="Date fin" /></f:facet>
                        <h:outputText value="#{exo.execptDateFin}">
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
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.taille!=1}"/>
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>



    <rich:modalPanel domElementAttachment="parent"  id="panelExcptAjout" width="400" height="300"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="NOUVEL EXERCICE COMPTABLE"></h:outputText></f:facet>
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
                    <rich:calendar style=" background-color:white;" locale="FR"  id="dateExercicetdeb" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.exercicesComptable.execptDateDebut}" enableManualInput="true" datePattern="dd/MM/yyyy" >
                    </rich:calendar>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Date de fin:"/> &nbsp;&nbsp;  &nbsp;&nbsp;
                    <rich:calendar style=" background-color:white;" id="dateExercicetfin" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.exercicesComptable.execptDateFin}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  >
                    </rich:calendar>
                </h:panelGroup>
            </h:panelGrid>
            <br/> <br/>
            <center>
                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.miseAJourCreationCompta}">
                    <a4j:support eventsQueue="maQueue" event="onclick" reRender="panelExcptAjout,table,panButton,menuHorizontal"/>
                </h:commandButton>
            </center>
        </a4j:form>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"  id="panel2ModifyEx" width="400" height="400"  headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);">
        <f:facet name="header"><h:outputText value="MODIFICATION DE L'EXERCICE COMPTABLE"></h:outputText></f:facet>
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
                        <rich:calendar style="background-color:white;" id="dateExerctfinModif" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.exercicesComptable.execptDateFin}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  popup="false"/>
                        <br>
                        <h:outputText value="Liasse cloturée:"/>
                        <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.exercicesComptable.execptLiasse}"/>
                        <br>
                    </center>
                </h:panelGroup>
                <br/> <br/>
                <h:panelGroup>
                    <center>
                        <h:commandButton image="/images/valider_big.png"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.modifier}" >
                            <a4j:support eventsQueue="maQueue" event="onclick" reRender="panel2ModifyEx,table,panButton"/>
                        </h:commandButton>
                    </center>
                </h:panelGroup>
            </h:panelGrid>
        </a4j:form>
    </rich:modalPanel>



    <rich:modalPanel domElementAttachment="parent"  id="panelcontrolExVte" headerClass="headerPanel" width="400" height="400" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.showModalPanelAssistant}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.showModalPanelAssistant}" var="ass">
            <f:facet name="header"><h:outputText value="Assistant de Clôture de l'exercice "></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.fermerCloture}" image="/images/close.gif" styleClass="hidelink" reRender="panelcontrolExVte"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formcontrolExercVte">
                <h:panelGrid width="100%">
                    <h:panelGrid columns="2" width="100%">
                        <h:outputText value="Date de fin de période"/>
                        <rich:calendar style=" background-color:white;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.datecloture}" locale="FR"   enableManualInput="true" datePattern="dd/MM/yyyy"  inputSize="8"/>                
                    </h:panelGrid>
                    <h:panelGrid columns="2" width="100%">
                        <h:outputText value="Mode de cloture"/>
                        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.var_mode_cloture}" layout="pageDirection" style="color:red">
                            <f:selectItem itemLabel="CLOTURE DEFINITIVE" itemValue="2"/>
                        </h:selectOneRadio>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid columns="2" columnClasses="clos70d,clos30" width="100%" border="0" headerClass="headerTab">
                        <f:facet name="header"><h:outputText value="Configuration de la cloture"/></f:facet>
                        <h:column rendered="false"><h:outputText  value = "Controles de la comptabilité:" /></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.optionComptabilite.clotureSansControle}" style="width:100px;">
                                <f:selectItem itemLabel="Désactivé" itemValue="0"/>
                                <f:selectItem itemLabel="Activé" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText  value = "Calcule rapprochements:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.optionComptabilite.clotureSansRappro}" style="width:100px;">
                                <f:selectItem itemLabel="Désactivé" itemValue="0"/>
                                <f:selectItem itemLabel="Activé" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText  value = "Efface Lettrage inutile lors de la cloture annuelle:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.optionComptabilite.clotureLettrageInutile}" style="width:100px;">
                                <f:selectItem itemLabel="Activé" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column rendered="false"><h:outputText  value = "Lettrage auto. lors de la cloture annuelle:" /></h:column>
                        <h:column rendered="false">
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.optionComptabilite.clotureLettrage}" style="width:100px;">
                                <f:selectItem itemLabel="Désactivé" itemValue="0"/>
                                <f:selectItem itemLabel="Activé" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText  value = "Backup avant cloture:" /></h:column>
                        <h:column>
                            <h:selectOneMenu value ="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.optionComptabilite.clotureBackup}" style="width:100px;">
                                <f:selectItem itemLabel="Désactivé" itemValue="0"/>
                                <f:selectItem itemLabel="Activé" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                    </h:panelGrid>
                    <br><br>
                    <h:panelGroup>
                        <center>
                            <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.cloturer}" image="/images/valider_big.png" title="Valider" onclick="if (!confirm('Etes-vous sur de vouloir cloturer cet exercice ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                            <br><br>
                            <h:outputText value="La date de fin doit être après celle de début" style="color:red;"/>
                        </center>
                    </h:panelGroup>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelBarProg" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Cloture en cours..."/></f:facet>
        <a4j:form>
            <br>
            <a4j:outputPanel id="progressPanel">
                <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.var_currentValue}" style="width:100%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.obm.texte} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.var_currentValue} / #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.var_valueMax}) "/>
                </rich:progressBar>
            </a4j:outputPanel>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelErreur" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.showModalPanelErreur}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.showModalPanelErreur}" var="err">
            <f:facet name="header"><h:outputText value="Erreur sur cloture."/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.fermerErreur}" image="/images/close.gif" styleClass="hidelink" reRender="panelErreur"/>
                </a4j:form>
            </f:facet>
            <a4j:form>
                <br>
                <center>
                    <img src="images/Warning.png" width="50px" height="50px" alt="erreur" style="margin-bottom:7px;"><br>
                    <br>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formExercicesComptables.obm.cat}" style="width:100%;color:red"/><br>
                </center>
                <br>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


</f:subview>
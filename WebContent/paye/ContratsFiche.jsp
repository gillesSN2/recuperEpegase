<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="fichescontrat">

    <a4j:form enctype="multipart/form-data">

        <center> <h2><h:outputText value="FICHE CONTRAT : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_lib_contrat}" style="color:green;"/></h2></center>

        <h:panelGrid id="idPanGlobal" width="100%">
            <h:panelGrid id="idRecherche" columns="4" columnClasses="clos15,clos35,clos15,clos35" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action==1}">
                <h:column><h:outputText value="Rechercher Agent:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:inputText id="idSalarie" style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nomSalarie}">
                        <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les salariés (puis tabuler)" style="background-color:#FFF8D4;"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.rechercheSalarie}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,tabPanelsalaries,FichSalarie,panelListeSalaries,formModalListeSalaries,idSalarie,idRecherche,panelValide,idPanGlobal"/>
                    </h:inputText>
                </h:column>
                <h:column></h:column>
                <h:column></h:column>
            </h:panelGrid>

            <h:panelGrid id="FichSalarie" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0}">
                <jsp:include flush="true" page="/paye/FicheSalarieCommun.jsp"/>
                <jsp:include flush="true" page="/paye/FicheSalarieContrat.jsp" />
            </h:panelGrid>

            <h:panelGroup id="panelValide">
                <center>
                    <h:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annulerElementContrat}"/>&nbsp;&nbsp;
                    <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.saveElementContrat}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.var_action_contrat!=3}"  onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPdf}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPdf}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du contrat PDF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerVisuPdf}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutAvenant" width="500" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelAjoutAvenant}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelAjoutAvenant}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER L'AVENANT DANS LE DOSSIER DU SALARIE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.annulerAvenantScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutAvenant"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:column>
                            <h:outputText value="N° Avenant" />&nbsp;&nbsp;&nbsp;
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.nomAvenant}" size="10" disabled="true" readonly="true"/>
                        </h:column>
                        <h:outputLabel for="idDoc" value="Ajoutez un avenant" />
                        <t:inputFileUpload id="idDoc" accept="application/pdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.uploadedPDFFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.validerAvenantScan}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPjAvenant" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPjAvenant}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.showModalPanelPjAvenant}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation de l'avenant PDF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.supprimerAvenantScan}" image="/images/supprimer.gif" style="width:20px;height:20px" styleClass="hidelink" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document?')) return false;;" reRender="panalVisuPjAvenant,panPdfAvn,listeAvenant"/>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fermerVisuAvenantScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPjAvenant"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>

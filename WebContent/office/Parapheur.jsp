<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="parapheur">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center> <h2><h:outputText value="Mon parapheur" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="panBouton" columns="3" width="100%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                <h:panelGrid id="panP1" columns="3" width="100%" styleClass="recherche">
                    <h:selectOneMenu  style="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.etatRqt}">
                        <f:selectItem itemLabel="En cours" itemValue="0" />
                        <f:selectItem itemLabel="Validé" itemValue="1" />
                        <f:selectItem itemLabel="Gelé" itemValue="2" />
                        <f:selectItem itemLabel="Rejeté" itemValue="3" />
                        <f:selectItem itemLabel="Correction" itemValue="4" />
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.lesParapheurs}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panBouton,panP1,panP2,panP3,table,scrollTable"/>
                    </h:selectOneMenu>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.etatRqt!='0'}">
                        <h:outputText value="Du:"/>
                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.dateDebut}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.etatRqt!='0'}">
                        <h:outputText value="Au:"/>
                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.dateFin}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;">
                            <a4j:support eventsQueue="maQueue" event="oninputblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.lesParapheurs}" reRender="modAttente,panBouton,panP1,panP2,panP3,table,scrollTable"/>
                        </rich:calendar>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid id="panP2" columns="2" width="100%" styleClass="recherche">
                    <a4j:commandButton title="Indisponibilités" value="Indisponibilités" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.modifAbsence}" reRender="panelIndispo"/>
                    <h:selectOneMenu style="width:200px" id="idMesUserIndisponibles">
                        <f:selectItem itemLabel="Les utilisateurs indisponibles" itemValue="0" />
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.mesUsersIndisponiblesItems}"/>
                    </h:selectOneMenu>
                </h:panelGrid>
                <h:panelGrid id="panP3" columns="7" width="100%" styleClass="recherche">
                    <h:commandButton title="Visualiser document" value="Visualiser" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.panalVisualisation}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_affiche_bouton}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:80px;cursor:pointer;" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                    <h:commandButton title="Voir réponses" value="Voir réponses" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.voirReponses}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_affiche_bouton}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:100px;cursor:pointer;" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <h:commandButton title="Valider" value="Valider" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.modifierParapheurValider}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.etatRqt==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_affiche_bouton}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:80px;cursor:pointer;" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <h:commandButton title="Geler" value="Geler" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.modifierParapheurGeler}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.etatRqt==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_affiche_bouton}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:80px;cursor:pointer;" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <h:commandButton title="Correction" value="Rejeter correction" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.modifierParapheurCorrection}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.etatRqt==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_affiche_bouton}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:130px;cursor:pointer;" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <h:commandButton title="Rejeter" value="Rejeter définitif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.modifierParapheurRejeter}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.etatRqt==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_affiche_bouton}" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:120px;cursor:pointer;" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                    <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
                </h:panelGrid>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.pageIndex}" reRender="table" id="scrollTable" maxPages="20" align="left" for="table"/>
                <rich:extendedDataTable id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.datamodelParapheur}" var="phr" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.extDTable}">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.selectionParapheur}" reRender="panBouton"/>
                    <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.selectionParapheur}" reRender="panBouton"/>
                    <rich:column sortable="true" width="5%" sortBy="#{phr.phrNature}">
                        <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                        <h:outputText value="#{phr.phrNature}" />
                    </rich:column>
                    <rich:column sortable="true" width="10%" sortBy="#{phr.libNature}">
                        <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                        <h:outputText value="#{phr.libNature}"/>
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.phrNomTiers}">
                        <f:facet name="header"><h:outputText  value="Nom tiers"/></f:facet>
                        <h:outputText value="#{phr.phrNomTiers}" />
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.phrNum}">
                        <f:facet name="header"><h:outputText  value="N° Document"/></f:facet>
                        <h:outputText value="#{phr.phrNum}" />
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.phrDate}">
                        <f:facet name="header"><h:outputText  value="Date document"/></f:facet>
                        <h:outputText value="#{phr.phrDate}" />
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.libelleEtat1}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1Cat==2}">
                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                        <h:outputText value="#{phr.libelleEtat1}" />
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.libelleEtat2}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2Cat==2}">
                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                        <h:outputText value="#{phr.libelleEtat2}" />
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.libelleEtat3}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3Cat==2}">
                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                        <h:outputText value="#{phr.libelleEtat3}" />
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.libelleEtat4}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4Cat==2}">
                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                        <h:outputText value="#{phr.libelleEtat4}" />
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.libelleEtat5}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5Cat==2}">
                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                        <h:outputText value="#{phr.libelleEtat5}" />
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.libelleEtat6}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6Cat==2}">
                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                        <h:outputText value="#{phr.libelleEtat6}" />
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.phrUser1DteRep}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1Cat==2}">
                        <f:facet name="header"><h:outputText  value="Date réponse"/></f:facet>
                        <h:outputText value="#{phr.phrUser1DteRep}" >
                            <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.phrUser2DteRep}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2Cat==2}">
                        <f:facet name="header"><h:outputText  value="Date réponse"/></f:facet>
                        <h:outputText value="#{phr.phrUser2DteRep}" >
                            <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.phrUser3DteRep}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3Cat==2}">
                        <f:facet name="header"><h:outputText  value="Date réponse"/></f:facet>
                        <h:outputText value="#{phr.phrUser3DteRep}" >
                            <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.phrUser4DteRep}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4Cat==2}">
                        <f:facet name="header"><h:outputText  value="Date réponse"/></f:facet>
                        <h:outputText value="#{phr.phrUser4DteRep}" >
                            <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.phrUser5DteRep}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5Cat==2}">
                        <f:facet name="header"><h:outputText  value="Date réponse"/></f:facet>
                        <h:outputText value="#{phr.phrUser5DteRep}" >
                            <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" width="12%" sortBy="#{phr.phrUser6DteRep}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6Cat==2}">
                        <f:facet name="header"><h:outputText  value="Date réponse"/></f:facet>
                        <h:outputText value="#{phr.phrUser6DteRep}" >
                            <f:convertDateTime locale="fr" pattern="dd/MM/yyyy"/>
                        </h:outputText>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelVisualisation" width="800" height="650" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.showModalPanelVisualisation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.showModalPanelVisualisation}" var="visu">
            <f:facet name="header"><h:outputText value="VISUALISATION DOCUMENT : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.libellePhr}"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <h:commandButton id="idCanVisualisation" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.annuleVisualisation}" styleClass="hidelink"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanVisualisation')}.click()" />
                </a4j:form>
            </f:facet>
            <a4j:form id="formVisualisation">
                <rich:hotKey key="return" handler="return false;"/>

            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelIndispo" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="330" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.showModalPanelIndisponibilite}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.showModalPanelIndisponibilite}" var="ind">
            <f:facet name="header"><h:outputText value="INDISPONIBILITE"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.fermerAbsence}" image="/images/close.gif" styleClass="hidelink" reRender="panelIndispo,idMesUserIndisponibles"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <h:outputText value="Je suis absent pendant la période suivante..." style="color:red;"/>
                <br>
                <h:panelGrid width="100%" columns="2" columnClasses="clos30,clos70" styleClass="fichefournisseur">
                    <h:outputText value="Indisponible du:"/>
                    <a4j:outputPanel layout="block"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateDebutIndisponibilite}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/></a4j:outputPanel>
                    <h:outputText value="Au:"/>
                    <a4j:outputPanel layout="block"><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrDateFinIndisponibilite}"  inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;" /></a4j:outputPanel>
                </h:panelGrid>
                <br>
                <center>
                    <a4j:commandButton id="idValIndisponible" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.validerAbsence}" style="margin-top:10px;cursor:pointer;" reRender="panelIndispo,idMesUserIndisponibles"/>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelNot" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.showModalPanelNotation}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.showModalPanelNotation}" var="sta">
            <f:facet name="header"><h:outputText value="STATUT DOCUMENT N°: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrNum} ==> (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_statut})"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.annulerParapheur}" image="/images/close.gif" styleClass="hidelink" reRender="panelNot" id="bpanelfmtclients"/>
                    <rich:componentControl for="panelNot" attachTo="bpanelfmtclients" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>

                <rich:tabPanel switchType="client" immediate="true" id="idPan2" style="border:0px;background-color:white;">

                    <rich:tab label="Ma réponse">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80">
                            <h:outputText value="Explications:"/>
                            <h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.noter}"/>
                        </h:panelGrid>
                        <br>
                        <c:if test="${false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_etat==3}" var="cor">
                            <h:panelGrid width="40%" columns="2" style="margin-left:200px" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrNature==62}">
                                <h:outputText value="OPTIONS DE MODFICATION"/>
                                <h:outputText value=""/>
                                <h:outputText value="Modification Tiers:"/>
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_col01}"/>
                                <h:outputText value="Modification Montant:"/>
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_col02}"/>
                                <h:outputText value="Modification Analytique:"/>
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_col03}"/>
                                <h:outputText value="Modification Caisse Exécutrice:"/>
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_col04}"/>
                                <h:outputText value="Modification Banque/caisse destination:"/>
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_col05}"/>
                                <h:outputText value="Modification Mode Paiement:"/>
                                <h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.var_col06}"/>
                            </h:panelGrid>
                        </c:if>
                    </rich:tab>

                    <rich:tab label="Les autres réponses">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1Id!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.numeroEncCours!=1}">
                            <h:outputText value="Signataire N°1:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2Id!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.numeroEncCours!=2}">
                            <h:outputText value="Signataire N°2:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3Id!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.numeroEncCours!=3}">
                            <h:outputText value="Signataire N°3:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4Id!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.numeroEncCours!=4}">
                            <h:outputText value="Signataire N°4:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5Id!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.numeroEncCours!=5}">
                            <h:outputText value="Signataire N°5:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6Id!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.numeroEncCours!=6}">
                            <h:outputText value="Signataire N°6:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejeté" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>

                </rich:tabPanel>
                <br>
                <center>
                    <a4j:commandButton id="idValStatut" image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.saveParapheur}" style="margin-top:10px;cursor:pointer;" reRender="panelNot,table"/>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelReponses" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="500" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.showModalPanelReponse}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.showModalPanelReponse}" var="rep">
            <f:facet name="header"><h:outputText value="DOCUMENT N°: #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrNum}"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.annulerReponses}" image="/images/close.gif" styleClass="hidelink" reRender="panelReponses"/>
                </a4j:form>
            </f:facet>
            <a4j:form >
                <rich:hotKey key="return" handler="return false;"/>
                <rich:tabPanel switchType="client" immediate="true" id="idPan2" style="border:0px;background-color:white;">
                    <rich:tab label="Les réponses">
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1Id!=0}">
                            <h:outputText value="Signataire N°1:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejet" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication actuelle:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1Explication}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explications antérieures:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser1MemoExplication}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2Id!=0}">
                            <h:outputText value="Signataire N°2:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejet" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication actuelle:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2Explication}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explications antérieures:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser2MemoExplication}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3Id!=0}">
                            <h:outputText value="Signataire N°3:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejet" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication actuelle:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3Explication}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explications antérieures:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser3MemoExplication}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4Id!=0}">
                            <h:outputText value="Signataire N°4:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejet" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication actuelle:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4Explication}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explications antérieures:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser4MemoExplication}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5Id!=0}">
                            <h:outputText value="Signataire N°5:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejet" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication acteulle:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5Explication}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explications antérieures:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser5MemoExplication}" readonly="true"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid width="100%" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6Id!=0}">
                            <h:outputText value="Signataire N°6:"/>
                            <h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6Nom}" readonly="true"/>
                            <h:column><h:outputText value="Réponse:"/> </h:column>
                            <h:column>
                                <h:selectOneMenu style="width:300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6Etat}" disabled="true">
                                    <f:selectItem itemLabel="En cours" itemValue="0"/>
                                    <f:selectItem itemLabel="Validé" itemValue="1"/>
                                    <f:selectItem itemLabel="Gelé" itemValue="2"/>
                                    <f:selectItem itemLabel="Correction" itemValue="3"/>
                                    <f:selectItem itemLabel="Exécuté" itemValue="4"/>
                                    <f:selectItem itemLabel="Rejet" itemValue="5"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Date réponse:"/></h:column>
                            <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6DteRep}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explication actuelle:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6Explication}" readonly="true"/></h:column>
                            <h:column><h:outputText value="Explications antérieures:"/></h:column>
                            <h:column><h:inputTextarea rows="3" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanOffice.formParapheur.parapheur.phrUser6MemoExplication}" readonly="true"/></h:column>
                        </h:panelGrid>
                    </rich:tab>
                </rich:tabPanel>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="350" height="80" resizeable="false">
        <f:facet name="header"><h:outputText value="Calcul de l'état en cours, veuillez patienter..."/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <h:commandButton image="/images/close.gif" styleClass="hidelink" id="closeImp">
                    <rich:componentControl attachTo="closeImp" for="modAttenteImp" event="onclick" operation="hide" />
                </h:commandButton>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel><h:graphicImage style="width:20px;height:20px;" value="/images/attente.gif"/></a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>
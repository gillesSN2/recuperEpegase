<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="affairefiche">

    <a4j:form>
        <rich:hotKey key="return" handler="return false;"/>

        <center><h2><h:outputText value="GESTION DU PORTEFEUILLE D'AFFAIRES (SPANCO)" style="color:green;"/></h2></center>

        <h:panelGroup id="panelPage" >
            <rich:tabPanel switchType="client" immediate="true" id="panelGlobal" style="border:0px;background-color:white;">
                <rich:tab id="tabDescription" label="Description" >
                    <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g" styleClass="fichefournisseur">
                        <h:column><h:outputText value="N° d'affaire:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaCode}" style="width:150px" readonly="true" disabled="true"/></h:column>
                        <h:column><h:outputText value="Type:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dossierSelectionne}" style="width:300px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}">
                                <f:selectItem itemLabel="Sélectionnez le type d'affaire" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.mesNaturesAffaires}"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.controleSaisie}" reRender="panelValide"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="N° analytique:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAnalytique}" style="width:150px" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid id="panelTiers" width="100%" headerClass="headerTab" columns="2" columnClasses="clos12d,clos88">
                        <f:facet name="header"><h:outputText value="Client concerné"/></f:facet>
                        <h:column><h:outputText value="Nom client:" style="text-decoration:underline;width:100%"/></h:column>
                        <h:column>
                            <h:inputText style="width:90%" id="idTiers" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireNomClient}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_detail_tiers}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}" maxlength="100">
                                <rich:toolTip followMouse="true" direction="top-right" showDelay="1000" value="chaine = Recherche qui commence... / *chaine = Recherche qui contient... / * = Recherche tous les clients (puis tabuler)" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.rechercheTiers}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeTiers,formModalListeTiers,tabDoc,idResponsable,idTiers,panelPage,idSerie,idDevise,panelDate,idpanel1,panelTiers,panelTiersInformations,panelContact,panelValide,panelBoutonLigne,panelLigne,idTiersDivers,panelValide"/>
                            </h:inputText>&nbsp;
                            <a4j:commandButton  image="/images/detail.png" title="Fiche du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_detail_tiers}" reRender="idSubView,formModalDetailTiers,panelDetailTiers"/>&nbsp;
                            <a4j:commandButton  image="/images/modifier.png" title="Changer le tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modifTiers}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_detail_tiers&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}" reRender="panelTiers"/>
                        </h:column>
                    </h:panelGrid>
                    <h:panelGroup id="panelTiersInformations" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.informationsTiers!=null}">
                        <center>
                            <h:outputText value="Message :  #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.informationsTiers}" style="color:red;font-weight:bold;font-size:20px,text-decoration: blink;"/>
                        </center>
                    </h:panelGroup>
                    <h:panelGrid id="panelContact" width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                        <h:column><h:outputText value="Contact:" style="text-decoration:underline;"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idPanelContact" style="width:80%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_nom_contact}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.mesContactItem}"/>
                            </h:selectOneMenu>&nbsp;
                            <a4j:commandButton image="/images/detail.png" title="Gestion Contacts du tiers" style="height:15px;width:15px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.ajouterContact}" reRender="idSubView,panelContactTiers,formModalContactTiers" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/>
                        </h:column>
                        <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                        <h:column id="idResponsable">
                            <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_nom_responsable}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action)==true}">
                                <f:selectItem itemLabel="Sélectionnez responsable" itemValue="0"/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.mesUsersItem}" />
                            </h:selectOneMenu>
                        </h:column>
                        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.optionVentes.responsable!='0'}">
                            <h:column><h:outputText value="Commercial:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_nom_commercial}" disabled="#{(!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_verrou_comm||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action)==true}">
                                    <f:selectItem itemLabel="Sélectionnez commercial" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.mesCommercialItem}" />
                                    <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.calculeResponsableLie}" reRender="panelContact,idResponsable"/>
                                </h:selectOneMenu>
                            </h:column>
                        </c:if>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid width="100%" columns="4" headerClass="headerTab" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <f:facet name="header"><h:outputText value="Caractéristiques de l'affaire"/></f:facet>
                        <h:column><h:outputText value="Mode:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireMode}" style="width:300px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}">
                                <f:selectItem itemLabel="Tous modes" itemValue="99"/>
                                <f:selectItem itemLabel="Normal" itemValue="0"/>
                                <f:selectItem itemLabel="Urgent" itemValue="1"/>
                                <f:selectItem itemLabel="Tres urgent" itemValue="2"/>
                                <f:selectItem itemLabel="Appel offre" itemValue="3"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Objet:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaNomFr}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="TVA:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireExoTva}" style="width:300px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}">
                                <f:selectItem itemLabel="Avec TVA" itemValue="0"/>
                                <f:selectItem itemLabel="Exonéré TVA" itemValue="1"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Douanes:"/></h:column>
                        <h:column>
                            <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireExoDouane}" style="width:300px;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}">
                                <f:selectItem itemLabel="Avec Douane" itemValue="0"/>
                                <f:selectItem itemLabel="Exonéré Douane" itemValue="1"/>
                                <f:selectItem itemLabel="Douane réduite" itemValue="2"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date demande client:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireDateDemande}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Date limite envoie devis:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireDatelimite}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Nom Fournisseur:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaMissionProprietaire}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Source:"/></h:column>
                        <h:column>
                            <h:selectOneMenu  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaTierssource}" style="width:100%" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}">
                                <f:selectItem itemLabel="" itemValue=""/>
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.mesSourceItems}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Date cotation fournisseur:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireDateCotation}" inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date calcul PRP:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireDatePrp}" inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date commande fournisseur:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireDateCommande}" inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date réception marchandise:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireDateReception}" inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date livraison client:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireDateLivree}" inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true"/></h:column>
                        <h:column><h:outputText value="Date facture client:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireDateFacture}" inputSize="8" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" disabled="true"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid width="100%" headerClass="headerTab" columns="10" columnClasses="clos5c,clos5g,clos5c,clos5g,clos5c,clos5g,clos5c,clos5g,clos5c,clos5g"  styleClass="fichefournisseur">
                        <f:facet name="header"><h:outputText value="PRP souhaité(s)"/></f:facet>
                        <h:column><h:outputText value="Avion:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modeAvion}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Bateau:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modeBateau}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Express:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modeExpress}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Route:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modeRoute}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column><h:outputText value="Train:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modeTrain}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.frsPrp1}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.optionAchats.fraisPrp1}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.frsPrp1}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modeReachemin1}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.frsPrp2}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.optionAchats.fraisPrp2}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.frsPrp2}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modeReachemin2}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.frsPrp3}"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.optionAchats.fraisPrp3}:"/></h:column>
                        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.frsPrp3}"><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.modeReachemin3}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/></h:column>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabScan" label="Documents scannés" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaId!=0}">
                    <jsp:include flush="true" page="AffairesCommun.jsp"/>
                    <h:panelGrid width="100%" id="idPanScan">
                        <h:panelGrid width="100%" headerClass="headerTab">
                            <f:facet name="header"><h:outputText value="LISTE DES DOCUMENTS SCANNES"/></f:facet>
                            <br>
                            <a4j:region renderRegionOnly="false">
                                <h:panelGroup id="idScanGlobal" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}">
                                    <a4j:commandButton title="Ajouter document" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.ajouterDocumentScan}" reRender="panalAjoutFile"/>
                                </h:panelGroup>
                                <rich:dataGrid  style="background:transparent;border:0px;border:solid 1px green" width="100%" columns="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelDocumnts}" id="listeDoc" var="document" >
                                    <f:facet name="header"></f:facet>
                                    <rich:column>
                                        <a4j:commandButton  image="/images/imp_reader_big.png" value="#{document}" style="width:80px:height:80px" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.lectureDoc}" reRender="panalVisuPj"/>
                                        <br>
                                        <h:outputText value="#{document}"/>
                                    </rich:column>
                                </rich:dataGrid>
                            </a4j:region>
                        </h:panelGrid>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabMail" label="Courriers/Fax/Mails" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaId!=0}">

                </rich:tab>

                <rich:tab id="tabAch" label="Documents Achats" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaId!=0}">
                    <jsp:include flush="true" page="AffairesCommun.jsp"/>
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.razDocument}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos50g,clos50g" id="idPanelAchat">
                        <rich:tabPanel switchType="client" immediate="true" id="panelGlobalAchat" style="border:0px;background-color:white;">
                            <rich:tab id="tabCotationAch" label="Cotation" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableCotation" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelCotations}" var="cot" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailCotation}" reRender="tableDetailAchat"/>
                                    <rich:column label="Sélection" sortable="true" sortBy="#{cot.var_select_ligne}" width="50px">
                                        <f:facet name="header"><h:outputText  value="Sel."/></f:facet>
                                        <h:selectBooleanCheckbox value="#{cot.var_select_ligne}" title="#{cot.var_select_ligne}" rendered="#{cot.cotEtat==1&&cot.cotCoefPRP!=0}"/>
                                    </rich:column>
                                    <rich:column label="N° cotation" sortable="true" sortBy="#{cot.cotNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="COTATION"/></f:facet>
                                        <h:outputText value="#{cot.cotNum}" title="#{cot.cotNum}"/>
                                    </rich:column>
                                    <rich:column label="Date cotation" sortable="true" sortBy="#{cot.cotDate} #{cot.cotNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{cot.cotDate}" title="#{cot.cotDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{cot.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{cot.libelleEta}" title="#{cot.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Coef. PRP" sortable="true" sortBy="#{cot.cotCoefPRP}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="PRP"/></f:facet>
                                        <h:outputText  value="#{cot.cotCoefPRP}" rendered="#{cot.cotCoefPRP!=0}" title="#{cot.cotCoefPRP}">
                                            <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Fournisseur" sortable="true" sortBy="#{cot.cotNomTiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                        <h:outputText value="#{cot.cotNomTiers}" title="#{cot.cotNomTiers}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                                <center>
                                    <h:commandButton value="Transformer les cotations sélectionnées en Devis" title="Transformer les cotations sélectionnées en Devis" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.transformerCotationDevis}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                                </center>
                            </rich:tab>
                            <rich:tab id="tabCommandeAch" label="Commande" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableCommandeAch" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelCommandesAch}" var="bcm" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailCommandeAch}" reRender="tableDetailAchat"/>
                                    <rich:column label="N° commande" sortable="true" sortBy="#{bcm.cmdNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="COMMANDE"/></f:facet>
                                        <h:outputText value="#{bcm.cmdNum}" title="#{bcm.cmdNum}"/>
                                    </rich:column>
                                    <rich:column label="Date commande" sortable="true" sortBy="#{bcm.cmdDate} #{bcm.cmdNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{bcm.cmdDate}" title="#{bcm.cmdDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{bcm.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{bcm.libelleEta}" title="#{bcm.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{bcm.cmdSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{bcm.cmdSerie}" title="#{bcm.cmdSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{bcm.cmdTotTtc}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{bcm.cmdTotTtc}" rendered="#{bcm.cmdTotTtc!=0}" title="#{bcm.cmdTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Fournisseur" sortable="true" sortBy="#{bcm.cmdNomTiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                        <h:outputText value="#{bcm.cmdNomTiers}" title="#{bm.cmdNomTiers}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabReceptionVte" label="Réception" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableReception" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelReceptons}" var="rec" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailReception}" reRender="tableDetailAchat"/>
                                    <rich:column label="N° réception" sortable="true" sortBy="#{rec.recNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="RECEPTION"/></f:facet>
                                        <h:outputText value="#{rec.recNum}" title="#{rec.recNum}"/>
                                    </rich:column>
                                    <rich:column label="Date réception" sortable="true" sortBy="#{rec.recDate} #{rec.recNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{rec.recDate}" title="#{rec.recDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{rec.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{rec.libelleEta}" title="#{rec.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{rec.recSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{rec.recSerie}" title="#{rec.recSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{rec.recTotTtc}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{rec.recTotTtc}" rendered="#{rec.recTotTtc!=0}" title="#{rec.recTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Fournisseur" sortable="true" sortBy="#{rec.recNomTiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                        <h:outputText value="#{rec.recNomTiers}" title="#{rec.recNomTiers}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabRetourAch" label="Retour" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableRetourAch" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelRetoursAch}" var="brt" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailRetourAch}" reRender="tableDetailAchat"/>
                                    <rich:column label="N° retour" sortable="true" sortBy="#{brt.brfNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="RETOUR"/></f:facet>
                                        <h:outputText value="#{brt.brfNum}" title="#{brt.brfNum}"/>
                                    </rich:column>
                                    <rich:column label="Date retour" sortable="true" sortBy="#{brt.brfDate} #{brt.brfNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{brt.brfDate}" title="#{brt.brfDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{brf.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{brf.libelleEta}" title="#{brf.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{brt.brfSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{brt.brfSerie}" title="#{brt.brfSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{brt.brfTotTtc}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{brt.brfTotTtc}" rendered="#{brt.brfTotTtc!=0}" title="#{brt.brfTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Fournisseur" sortable="true" sortBy="#{brt.brfNomTiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                        <h:outputText value="#{brt.brfNomTiers}" title="#{brt.brfNomTiers}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabFactureAch" label="Facture" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableFactureAch" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelFacturesAch}" var="fac" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailFactureAch}" reRender="tableDetailAchat"/>
                                    <rich:column label="N° facture" sortable="true" sortBy="#{fac.fcfNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="FACTURE"/></f:facet>
                                        <h:outputText value="#{fac.fcfNum}" title="#{fac.fcfNum}"/>
                                    </rich:column>
                                    <rich:column label="Date facture" sortable="true" sortBy="#{fac.fcfDate} #{fac.fcfNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{fac.fcfDate}" title="#{fac.fcfDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{fac.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{fac.libelleEta}" title="#{fac.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{fac.fcfSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{fac.fcfSerie}" title="#{fac.fcfSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{fac.fcfTotTtc}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{fac.fcfTotTtc}" rendered="#{fac.fcfTotTtc!=0}" title="#{fac.fcfTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Fournisseur" sortable="true" sortBy="#{fac.fcfNomTiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                        <h:outputText value="#{fac.fcfNomTiers}" title="#{fac.fcfNomTiers}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabNoteDebitAch" label="Débit" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableNoteDebitAch" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelNotesDebitAch}" var="ndb" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailNoteDebitAch}" reRender="tableDetailAchat"/>
                                    <rich:column label="N° note débit" sortable="true" sortBy="#{ndb.ndfNum}"  width="80px">
                                        <f:facet name="header"><h:outputText  value="NOTE DEBIT"/></f:facet>
                                        <h:outputText value="#{ndb.ndfNum}" title="#{ndb.ndfNum}"/>
                                    </rich:column>
                                    <rich:column label="Date note débit" sortable="true" sortBy="#{ndb.ndfDate} #{ndb.ndfNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{ndb.ndfDate}" title="#{ndb.ndfDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{ndb.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{ndb.libelleEta}" title="#{ndb.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{ndb.ndfSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{ndb.ndfSerie}" title="#{ndb.ndfSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{ndb.ndfTotTtc}" style="text-align:right;"  width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{ndb.ndfTotTtc}" rendered="#{ndb.ndfTotTtc!=0}" title="#{ndb.ndfTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Fournisseur" sortable="true" sortBy="#{ndb.ndfNomTiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                        <h:outputText value="#{ndb.ndfNomTiers}" title="#{ndb.ndfNomTiers}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabAvoirAch" label="Avoir" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableAvoirAch" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelAvoirsAch}" var="avr" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailAvoirAch}" reRender="tableDetailAchat"/>
                                    <rich:column label="N° avoir" sortable="true" sortBy="#{avr.avfNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="AVOIR"/></f:facet>
                                        <h:outputText value="#{avr.avfNum}" title="#{avr.avfNum}"/>
                                    </rich:column>
                                    <rich:column label="Date avoir" sortable="true" sortBy="#{avr.avfDate} #{avr.avfNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{avr.avfDate}" title="#{avr.avfDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{avr.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{avr.libelleEta}" title="#{avr.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{avr.avfSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{avr.avfSerie}" title="#{avr.avfSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{avr.avfTotTtc}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{avr.avfTotTtc}" rendered="#{avr.avfTotTtc!=0}" title="#{avr.avfTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Fournisseur" sortable="true" sortBy="#{avr.avfNomTiers}" width="200px">
                                        <f:facet name="header"><h:outputText  value="Fournisseur"/></f:facet>
                                        <h:outputText value="#{avr.avfNomTiers}" title="#{avr.avfNomTiers}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                        </rich:tabPanel>
                        <rich:extendedDataTable styleClass="bg" id="tableDetailAchat" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelDetail}" var="detAch" >
                            <rich:column label="Code produit" sortable="true" sortBy="#{detAch.ligCode}">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText value="#{detAch.ligCode}" title="#{detAch.ligCode}"/>
                            </rich:column>
                            <rich:column label="Libellé" sortable="true" sortBy="#{detAch.ligLibelle}" width="70px">
                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                <h:outputText value="#{detAch.ligLibelle}" title="#{detAch.ligLibelle}"/>
                            </rich:column>
                            <rich:column label="Quantité" sortable="true" sortBy="#{detAch.ligQte}" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                <h:outputText value="#{detAch.ligQte}" title="#{detAch.ligQte}"/>
                            </rich:column>
                            <rich:column label="Prix unitaire" sortable="true" sortBy="#{detAch.ligPu}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="P.U."/></f:facet>
                                <h:outputText  value="#{detAch.ligPu}" rendered="#{detAch.ligPu!=0}" title="#{detAch.ligPu}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="MontantTotal" sortable="true" sortBy="#{detAch.ligPt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="P.T."/></f:facet>
                                <h:outputText  value="#{detAch.ligPt}" rendered="#{detAch.ligPt!=0}" title="#{detAch.ligPt}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="P.U.M.P." sortable="true" sortBy="#{detAch.ligPump}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="P.U.M.P"/></f:facet>
                                <h:outputText  value="#{detAch.ligPump}" rendered="#{detAch.ligPump!=0}" title="#{detAch.ligPump}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabVte" label="Documents Ventes" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaId!=0}">
                    <jsp:include flush="true" page="AffairesCommun.jsp"/>
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.razDocument}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos50g,clos50g" id="idPanelVente">
                        <rich:tabPanel switchType="client" immediate="true" id="panelGlobalVente" style="border:0px;background-color:white;">
                            <rich:tab id="tabDevisVte" label="Devis" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableDevis" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelDevis}" var="dvs" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailDevis}" reRender="tableDetailVente"/>
                                    <rich:column label="N° devis" sortable="true" sortBy="#{dvs.dvsNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="DEVIS"/></f:facet>
                                        <h:outputText value="#{dvs.dvsNum}" title="#{dvs.dvsNum}"/>
                                    </rich:column>
                                    <rich:column label="Date devis" sortable="true" sortBy="#{dvs.dvsDate} #{dvs.dvsNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{dvs.dvsDate}" title="#{dvs.dvsDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{dvs.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{dvs.libelleEta}" title="#{dvs.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{dvs.dvsSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{dvs.dvsSerie}" title="#{dvs.dvsSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{dvs.dvsTotTtc}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{dvs.dvsTotTtc}" rendered="#{dvs.dvsTotTtc!=0}" title="#{dvs.dvsTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabCommandeVte" label="Commande" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableCommande" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelCommandes}" var="bcm" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailCommandeVte}" reRender="tableDetailVente"/>
                                    <rich:column label="N° commande" sortable="true" sortBy="#{bcm.bcmNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="COMMANDE"/></f:facet>
                                        <h:outputText value="#{bcm.bcmNum}" title="#{bcm.bcmNum}"/>
                                    </rich:column>
                                    <rich:column label="Date commande" sortable="true" sortBy="#{bcm.bcmDate} #{bcm.bcmNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{bcm.bcmDate}" title="#{bcm.bcmDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{bcm.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{bcm.libelleEta}" title="#{bcm.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{bcm.bcmSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{bcm.bcmSerie}" title="#{bcm.bcmSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{bcm.bcmTotTtc}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{bcm.bcmTotTtc}" rendered="#{bcm.bcmTotTtc!=0}" title="#{bcm.bcmTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabLivraisonVte" label="Livraison" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableLivraison" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelLivraisons}" var="blv" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailLivraison}" reRender="tableDetailVente"/>
                                    <rich:column label="N° livraison" sortable="true" sortBy="#{blv.blvNum}"  width="80px">
                                        <f:facet name="header"><h:outputText  value="LIVRAISON"/></f:facet>
                                        <h:outputText value="#{blv.blvNum}" title="#{blv.blvNum}"/>
                                    </rich:column>
                                    <rich:column label="Date livraison" sortable="true" sortBy="#{blv.blvDate} #{blv.blvNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{blv.blvDate}" title="#{blv.blvDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{blv.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{blv.libelleEta}" title="#{blv.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{blv.blvSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{blv.blvSerie}" title="#{blv.blvSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{blv.blvTotTtc}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{blv.blvTotTtc}" rendered="#{blv.blvTotTtc!=0}" title="#{blv.blvTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabRetourVte" label="Retour" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableRetour" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelRetours}" var="brt" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailRetourVte}" reRender="tableDetailVente"/>
                                    <rich:column label="N° retour" sortable="true" sortBy="#{brt.brtNum}"  width="80px">
                                        <f:facet name="header"><h:outputText  value="RETOUR"/></f:facet>
                                        <h:outputText value="#{brt.brtNum}" title="#{brt.brtNum}"/>
                                    </rich:column>
                                    <rich:column label="Date retour" sortable="true" sortBy="#{brt.brtDate} #{brt.brtNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{brt.brtDate}" title="#{brt.brtDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{brt.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{brt.libelleEta}" title="#{brt.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{brt.brtSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{brt.brtSerie}" title="#{brt.brtSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{brt.brtTotTtc}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{brt.brtTotTtc}" rendered="#{brt.brtTotTtc!=0}" title="#{brt.brtTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabFactureVte" label="Facture" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableFacture" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelFactures}" var="fac" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailFactureVte}" reRender="tableDetailVente"/>
                                    <rich:column label="N° facture" sortable="true" sortBy="#{fac.facNum}"  width="80px">
                                        <f:facet name="header"><h:outputText  value="FACTURE"/></f:facet>
                                        <h:outputText value="#{fac.facNum}" title="#{fac.facNum}"/>
                                    </rich:column>
                                    <rich:column label="Date facture" sortable="true" sortBy="#{fac.facDate} #{fac.facNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{fac.facDate}" title="#{fac.facDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{fac.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{fac.libelleEta}" title="#{fac.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{fac.facSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{fac.facSerie}" title="#{fac.facSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{fac.facTotTtc}" style="text-align:right;"  width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{fac.facTotTtc}" rendered="#{fac.facTotTtc!=0}" title="#{fac.facTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabNoteDebitVte" label="Débit" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableNoteDebit" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelNotesDebit}" var="ndb" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailNoteDebitVte}" reRender="tableDetailVente"/>
                                    <rich:column label="N° note débit" sortable="true" sortBy="#{ndb.ndbNum}"  width="80px">
                                        <f:facet name="header"><h:outputText  value="NOTE DEBIT"/></f:facet>
                                        <h:outputText value="#{ndb.ndbNum}" title="#{ndb.ndbNum}"/>
                                    </rich:column>
                                    <rich:column label="Date note débit" sortable="true" sortBy="#{ndb.ndbDate} #{ndb.ndbNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{ndb.ndbDate}" title="#{ndb.ndbDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{ndb.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{ndb.libelleEta}" title="#{ndb.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{ndb.ndbSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{ndb.ndbSerie}" title="#{ndb.ndbSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{ndb.ndbTotTtc}" style="text-align:right;"  width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{ndb.ndbTotTtc}" rendered="#{ndb.ndbTotTtc!=0}" title="#{ndb.ndbTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabAvoirVte" label="Avoir" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableAvoir" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelAvoirs}" var="avr" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailAvoirVte}" reRender="tableDetailVente"/>
                                    <rich:column label="N° avoir" sortable="true" sortBy="#{avr.avrNum}"  width="80px">
                                        <f:facet name="header"><h:outputText  value="AVOIR"/></f:facet>
                                        <h:outputText value="#{avr.avrNum}" title="#{avr.avrNum}"/>
                                    </rich:column>
                                    <rich:column label="Date avoir" sortable="true" sortBy="#{avr.avrDate} #{avr.avrNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{avr.avrDate}" title="#{avr.avrDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Etat" sortable="true" sortBy="#{avr.libelleEta}" style="text-align:center;" width="50px">
                                        <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                                        <h:outputText value="#{avr.libelleEta}" title="#{avr.libelleEta}"/>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{avr.avrSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{avr.avrSerie}" title="#{avr.avrSerie}"/>
                                    </rich:column>
                                    <rich:column label="Montant T.T.C." sortable="true" sortBy="#{avr.avrTotTtc}" style="text-align:right;"  width="80px">
                                        <f:facet name="header"><h:outputText  value="T.T.C"/></f:facet>
                                        <h:outputText  value="#{avr.avrTotTtc}" rendered="#{avr.avrTotTtc!=0}" title="#{avr.avrTotTtc}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                        </rich:tabPanel>
                        <rich:extendedDataTable styleClass="bg" id="tableDetailVente" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelDetail}" var="detVte" >
                            <rich:column label="Code produit" sortable="true" sortBy="#{detVte.ligCode}">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText value="#{detVte.ligCode}" title="#{detVte.ligCode}"/>
                            </rich:column>
                            <rich:column label="Libellé" sortable="true" sortBy="#{detVte.ligLibelle}" width="70px">
                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                <h:outputText value="#{detVte.ligLibelle}" title="#{detVte.ligLibelle}"/>
                            </rich:column>
                            <rich:column label="Quantité" sortable="true" sortBy="#{detVte.ligQte}" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                <h:outputText value="#{detVte.ligQte}" title="#{detVte.ligQte}"/>
                            </rich:column>
                            <rich:column label="Prix unitaire" sortable="true" sortBy="#{detVte.ligPu}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="P.U."/></f:facet>
                                <h:outputText  value="#{detVte.ligPu}" rendered="#{detVte.ligPu!=0}" title="#{detVte.ligPu}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="MontantTotal" sortable="true" sortBy="#{detVte.ligPt}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="P.T."/></f:facet>
                                <h:outputText  value="#{detVte.ligPt}" rendered="#{detVte.ligPt!=0}" title="#{detVte.ligPt}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                            <rich:column label="P.U.M.P." sortable="true" sortBy="#{detVte.ligPump}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="P.U.M.P"/></f:facet>
                                <h:outputText  value="#{detVte.ligPump}" rendered="#{detVte.ligPump!=0}" title="#{detVte.ligPump}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabStk" label="Documents Stock" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaId!=0}">
                    <jsp:include flush="true" page="AffairesCommun.jsp"/>
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.razDocument}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos50g,clos50g" id="idPanelStock">
                        <rich:tabPanel switchType="client" immediate="true" id="panelGlobalStock" style="border:0px;background-color:white;">
                            <rich:tab id="tabBonEntree" label="Bon Entrée" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableBonEntree" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelBonEntrees}" var="bin" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailBonEntree}" reRender="tableDetailStock"/>
                                    <rich:column label="N° bon entrée" sortable="true" sortBy="#{bin.binNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="B.ENTREE"/></f:facet>
                                        <h:outputText value="#{bin.binNum}" title="#{bin.binNum}"/>
                                    </rich:column>
                                    <rich:column label="Date bon entrée" sortable="true" sortBy="#{bin.binDate} #{bin.binNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{bin.binDate}" title="#{bin.binDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{bin.binSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{bin.binSerie}" title="#{bin.binSerie}"/>
                                    </rich:column>
                                    <rich:column label="Total PUMP" sortable="true" sortBy="#{bin.binTotPump}" style="text-align:right;" width="80px">
                                        <f:facet name="header"><h:outputText  value="PUMP"/></f:facet>
                                        <h:outputText  value="#{bin.binTotPump}" rendered="#{bin.binTotPump!=0}" title="#{bin.binTotPump}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabBonSortie" label="Bon Sortie" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableBonSortie" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelBonSorties}" var="bou" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailBonSortie}" reRender="tableDetailStock"/>
                                    <rich:column label="N° bon sortie" sortable="true" sortBy="#{bou.bouNum}" width="70px">
                                        <f:facet name="header"><h:outputText  value="B.SORTIE"/></f:facet>
                                        <h:outputText value="#{bou.bouNum}" title="#{bou.bouNum}"/>
                                    </rich:column>
                                    <rich:column label="Date bon sortie" sortable="true" sortBy="#{bou.bouDate} #{bou.bouNum}" width="70px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{bou.bouDate}" title="#{bou.bouDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{bou.bouSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{bou.bouSerie}"/>
                                    </rich:column>
                                    <rich:column label="Total PUMP" sortable="true" sortBy="#{bou.bouTotPump}" style="text-align:right;" width="70px">
                                        <f:facet name="header"><h:outputText  value="PUMP"/></f:facet>
                                        <h:outputText  value="#{bou.bouTotPump}" rendered="#{bou.bouTotPump!=0}" title="#{bou.bouTotPump}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabCession" label="Cession" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableCession" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelCessions}" var="ces" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailCession}" reRender="tableDetailStock"/>
                                    <rich:column label="N° cession" sortable="true" sortBy="#{ces.cesNum}"  width="80px">
                                        <f:facet name="header"><h:outputText  value="CESSION"/></f:facet>
                                        <h:outputText value="#{ces.cesNum}" title="#{ces.cesNum}"/>
                                    </rich:column>
                                    <rich:column label="Date cession" sortable="true" sortBy="#{ces.cesDate} #{ces.cesNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{ces.cesDate}" title="#{ces.cesDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{ces.cesSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{ces.cesSerie}" title="#{ces.cesSerie}"/>
                                    </rich:column>
                                    <rich:column label="Total PUMP" sortable="true" sortBy="#{ces.cesTotPump}" style="text-align:right;"  width="80px">
                                        <f:facet name="header"><h:outputText  value="PUMP"/></f:facet>
                                        <h:outputText  value="#{ces.cesTotPump}" rendered="#{ces.cesTotPump!=0}" title="#{ces.cesTotPump}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                            <rich:tab id="tabProdution" label="Production" >
                                <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.effaceDetail}" reRender="tableDetailAchat,tableDetailVente,tableDetailStock"/>
                                <rich:extendedDataTable styleClass="bg" id="tableProduction" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelProductions}" var="fab" >
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.detailProduction}" reRender="tableDetailStock"/>
                                    <rich:column label="N° production" sortable="true" sortBy="#{fab.fabNum}"  width="80px">
                                        <f:facet name="header"><h:outputText  value="PRODUCTION"/></f:facet>
                                        <h:outputText value="#{fab.fabNum}" title="#{fab.fabNum}"/>
                                    </rich:column>
                                    <rich:column label="Date production" sortable="true" sortBy="#{fab.fabDate} #{fab.fabNum}" width="80px">
                                        <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                                        <h:outputText value="#{fab.fabDate}" title="#{fab.fabDate}">
                                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Série" sortable="true" sortBy="#{fab.fabSerie}" style="text-align:center;" width="40px">
                                        <f:facet name="header"><h:outputText  value="S."/></f:facet>
                                        <h:outputText value="#{fab.fabSerie}" title="#{fab.fabSerie}"/>
                                    </rich:column>
                                    <rich:column label="Total PUMP" sortable="true" sortBy="#{fab.fabTotPump}" style="text-align:right;"  width="80px">
                                        <f:facet name="header"><h:outputText  value="PUMP"/></f:facet>
                                        <h:outputText  value="#{fab.fabTotPump}" rendered="#{fab.fabTotPump!=0}" title="#{fab.fabTotPump}">
                                            <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </rich:tab>
                        </rich:tabPanel>
                        <rich:extendedDataTable styleClass="bg" id="tableDetailStock" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelDetail}" var="detStk" >
                            <rich:column label="Code produit" sortable="true" sortBy="#{detStk.ligCode}">
                                <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                                <h:outputText value="#{detStk.ligCode}" title="#{detStk.ligCode}"/>
                            </rich:column>
                            <rich:column label="Libellé" sortable="true" sortBy="#{detStk.ligLibelle}" width="150px">
                                <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                <h:outputText value="#{detStk.ligLibelle}" title="#{detStk.ligLibelle}"/>
                            </rich:column>
                            <rich:column label="Quantité" sortable="true" sortBy="#{detStk.ligQte}" style="text-align:center;" width="40px">
                                <f:facet name="header"><h:outputText  value="Qte"/></f:facet>
                                <h:outputText value="#{detStk.ligQte}" title="#{detStk.ligQte}"/>
                            </rich:column>
                            <rich:column label="P.U.M.P." sortable="true" sortBy="#{detStk.ligPump}" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="P.U.M.P"/></f:facet>
                                <h:outputText  value="#{detStk.ligPump}" rendered="#{detStk.ligPump!=0}" title="#{detStk.ligPump}">
                                    <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </h:panelGrid>
                </rich:tab>

                <rich:tab id="tabReg" label="Documents Reglements" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaId!=0}">
                    <jsp:include flush="true" page="AffairesCommun.jsp"/>
                    <rich:extendedDataTable styleClass="bg" id="tableReglement" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" height="300px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.dataModelReglements}" var="reg" >
                        <rich:column label="N° reçu" sortable="true" sortBy="#{reg.rglNum}">
                            <f:facet name="header"><h:outputText  value="B.RECU"/></f:facet>
                            <h:outputText value="#{reg.rglNum}"/>
                        </rich:column>
                        <rich:column label="Date règlement" sortable="true" sortBy="#{reg.rglDateReg} #{reg.rglNum}" width="70px">
                            <f:facet name="header"><h:outputText  value="Date"/></f:facet>
                            <h:outputText value="#{reg.rglDateReg}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{reg.rglSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S."/></f:facet>
                            <h:outputText value="#{reg.rglSerie}"/>
                        </rich:column>
                        <rich:column label="Dépense" sortable="true" sortBy="#{reg.rglDepense}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Dépense"/></f:facet>
                            <h:outputText  value="#{reg.rglDepense}" rendered="#{reg.rglDepense!=0}">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Recette" sortable="true" sortBy="#{reg.rglRecette}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Recette"/></f:facet>
                            <h:outputText  value="#{reg.rglRecette}" rendered="#{reg.rglRecette!=0}">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </rich:tab>

                <rich:tab id="tabCouts" label="Calcul des couts" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaId!=0}">
                    <jsp:include flush="true" page="AffairesCommun.jsp"/>
                    <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35" styleClass="fichefournisseur">
                        <h:column><h:outputText value="Cout théorique:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireCoutTheo}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Cout réelle:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireCoutReel}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="C.A. théorique:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireTheo}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="C.A. réelle:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireReel}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Marge théorique:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireMargeTheo}" disabled="true" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Marge Réelle:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaAffaireMargeReel}" disabled="true" style="text-align:right;">
                                <jsp:include flush="true" page="../commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="% marge:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.plansAnalytiques.anaTypeTauxDevise}" disabled="true" style="text-align:right;">
                                <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid width="100%" columns="2" columnClasses="clos50,clos50" styleClass="fichefournisseur">
                        <h:panelGroup>
                            <center>
                                <h:outputText value="Mode de calcul théorique:"/><br>
                                <h:outputText value="COUT THEORIQUE = PUMP des devis"/><br>
                                <h:outputText value="CA THEORIQUE : HT des devis"/><br>
                                <h:outputText value="MARGE THEORIQUE = CA théorique - COUT théorique"/><br><br>
                            </center>
                        </h:panelGroup>
                        <h:panelGroup>
                            <center>
                                <h:outputText value="Mode de calcul réel:"/><br>
                                <h:outputText value="COUT REEL = PUMP des factures + PUMP des notes de débit - PUMP des retours - DEPENSES"/><br>
                                <h:outputText value="CA REEL = HT factures + HT notes de débit - HT avoirs"/><br>
                                <h:outputText value="MARGE REEL = CA réel - COUT réel"/><br>
                                <h:outputText value="% MARGE = ((CA réel- COUT réel) / CA réel) * 100 "/><br><br>
                            </center>
                        </h:panelGroup>
                    </h:panelGrid>
                </rich:tab>

            </rich:tabPanel>

            <h:panelGroup id="panelValide">
                <center>
                    <br><br>
                    <a4j:commandButton image="/images/annuler_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.annule}" reRender="idSubView"/>&nbsp;&nbsp;
                    <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.save}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_valide_doc&&!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}" reRender="idSubView"/>
                </center>
            </h:panelGroup>
        </h:panelGroup>
    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  id="panalVisuPj" width="1100" height="600" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelPj}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelPj}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="Visualisation du fichier PDF"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce document ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.supprimerDocumentScan}" image="/images/supprimer.png" styleClass="hidelink" reRender="modAttente,panalVisuPj,listeDoc" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.var_aff_action}"/>&nbsp;&nbsp;
                    <h:column>
                        <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.fichierUrl}" target="_blank" title="Lire document"><img src="images/detail.png" alt="lecture"></a>
                    </h:column>&nbsp;&nbsp;
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.fermerVisuDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalVisuPj"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%">
                    <object data="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.fichierUrl}" type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.fichierMine}" width="100%" height="550">
                        <a href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.fichierUrl}"></a>
                    </object>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

    <rich:modalPanel domElementAttachment="parent"  id="panalAjoutFile" width="500" height="250" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelAjoutFile}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.showModalPanelAjoutFile}" var="ajtFil" >
            <f:facet name="header"><h:outputText value="UPLOADER DES DOCUMENTS DANS LE DOSSIER AFFAIRE"></h:outputText></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.annulerDocumentScan}" image="/images/close.gif" styleClass="hidelink" reRender="panalAjoutFile"/>
                </a4j:form>
            </f:facet>
            <a4j:form enctype="multipart/form-data">
                <rich:hotKey key="return" handler="return false;"/>
                <h:panelGrid width="100%" headerClass="headerTab" styleClass="panneau_accueil">
                    <h:panelGrid style="width:100%;">
                        <h:outputLabel value="Nom du document" />
                        <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.nomDocument}" maxlength="20"/></h:column>
                        <h:outputLabel for="idDoc" value="Ajoutez un document" />
                        <t:inputFileUpload id="idDoc" accept="application/pdf" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.uploadedPDFFile}"/>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:commandButton styleClass="exp_lienmenu" value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanVentes.formAffaires.validerDocumentScan}"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>

</f:subview>

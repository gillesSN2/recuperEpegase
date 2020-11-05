<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="docencours">

    <a4j:form>

        <center> <h2><h:outputText value="GESTION DES DOCUMENTS EN COURS" style="var.color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="document" >
            <h:panelGrid  columns="13" styleClass="recherche" width="100%" id="boutons">
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat}" style="width:100px;">
                        <f:selectItem itemLabel="A exécuter" itemValue="1"/>
                        <f:selectItem itemLabel="Reçus" itemValue="2"/>
                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.selectionElementRecu}" reRender="pangrpVisbt,table,document,idSelectionCaisseItems,pnlgrttotal" />
                    </h:selectOneMenu>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpNature}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==1}" style="width:130px;">
                        <f:selectItem itemLabel="Tous Documents" itemValue="100"/>
                        <f:selectItem itemLabel="Clients" itemValue="20"/>
                        <f:selectItem itemLabel="Fournisseurs" itemValue="10"/>
                        <f:selectItem itemLabel="Agents" itemValue="80"/>
                        <f:selectItem itemLabel="Bons de sortie" itemValue="62"/>
                        <f:selectItem itemLabel="Bons d'entrée" itemValue="63"/>
                        <f:selectItem itemLabel="Virements internes" itemValue="64"/>
                    </h:selectOneMenu>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpNature}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2}" style="width:130px;">
                        <f:selectItem itemLabel="Tous Documents" itemValue="100"/>
                        <f:selectItem itemLabel="Clients" itemValue="20"/>
                        <f:selectItem itemLabel="Fournisseurs" itemValue="10"/>
                        <f:selectItem itemLabel="Agents" itemValue="80"/>
                        <f:selectItem itemLabel="Virements internes" itemValue="60"/>
                        <f:selectItem itemLabel="Bordereau chèque de mouvement (caisse/caisse)" itemValue="202"/>
                        <f:selectItem itemLabel="Bordereau chèque de remise (caisse/banque)" itemValue="203"/>
                        <f:selectItem itemLabel="Bordereau espèce de remise (caisse/banque)" itemValue="206"/>
                        <f:selectItem itemLabel="Les recettes" itemValue="200"/>
                        <f:selectItem itemLabel="Les dépenses" itemValue="201"/>
                        <f:selectItem itemLabel="Saisie des encaissements des chèques remisés" itemValue="204"/>
                        <f:selectItem itemLabel="Saisie des encaissements des chèques encaissés/rejetés" itemValue="205"/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesModesReglementsRecItem}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column id="idSelectionCaisseItems">
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==1}" var="cexe">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpCaisse}" style="width:130px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesCaissesExecutriceItems}"/>
                        </h:selectOneMenu>
                    </c:if>
                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2}" var="crec">
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpCaisse}" style="width:130px;">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesCaissesRecusItems}"/>
                        </h:selectOneMenu>
                    </c:if>
                </h:column>
                <h:column>
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpService}" style="width:130px;">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesServiceItem}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2}" >
                    <h:outputText value="N° Reçu:"/><br>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.rechercheRecu}" size="5"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2}" >
                    <h:outputText value="Pièce origine:"/><br>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.recherchePiece}" size="5"/>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2}" >
                    <h:outputText value="Montant:"/><br>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.rechercheMontant}" size="5"  onkeypress="return scanToucheChiffre(event)" onblur="if(this.value=='')value=0;"></h:inputText>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat!=2}" >
                    <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.rechercheTiers}" style="width:130px;">
                        <f:selectItem itemLabel="Tous tiers" itemValue=""/>
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.mesTiersItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrRecusJour==0}"><h:outputText value="Du:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrRecusJour==0}"><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.dateDebut}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrRecusJour==0}"><h:outputText value="Au:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrRecusJour==0}"><rich:calendar inputSize="8" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.dateFin}" enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                <h:column>
                    <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.chargerFind}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pangrpVisbt,scrollTable,table,pnlgrttotal"/>
                    <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                </h:column>
            </h:panelGrid>
        </h:panelGrid>

        <h:panelGrid id="pangrpVisbt" width="100%">
            <h:panelGrid columns="13" styleClass="recherche" width="100%">
                <a4j:commandButton title="Exécuter la ligne sélectionnée" image="/images/dollar.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.ajoutDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.usersChrono.usrchrExecution==1}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <a4j:commandButton title="Consulter le document sélectionné" image="/images/detail.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.consultDocument}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView"/>
                <h:commandButton title="Consulter le document d'origine" image="/images/bulletin.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.consultDocumentOrigine}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.bonCaisse.bonCaisIdOrigine!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.visibiliteBton}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" />
                <a4j:commandButton title="Imprimer reçu" image="/images/print.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.initImpression}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                <a4j:commandButton title="Ajouter Recettes" value="Ajouter Recettes" styleClass="top" style="height:26px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.ajouterRecettes}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrCaissierRecette==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.optionCaisses.saisieRecette=='true'}"/>
                <a4j:commandButton title="Ajouter Dépenses" value="Ajouter Dépenses" styleClass="top" style="height:26px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.ajouterDepenses}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrCaissierDepense==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.optionCaisses.saisieDepense=='true'}"/>
                <a4j:commandButton title="Ajouter Transfert" value="Ajouter Transferts" styleClass="top" style="height:26px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.ajouterTransfert}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.add&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==1&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrCaissierTransfert==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.optionCaisses.saisieTransfert=='true'}"/>
                <a4j:commandButton title="Modifier le reçu sélectionné" value="Modifier Reçu" styleClass="top" style="height:26px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.modifierRegularisation}" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView" rendered="#{false&&bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrCaissierModif==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.optionCaisses.saisieRegularisation=='true'}"/>
                <a4j:commandButton title="Annuler le reçu sélectioné" value="Annuler Reçu" styleClass="top" style="height:26px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.annulerRecu}" onclick="if (!confirm('Etes-vous sur de vouloir annuler ce reçu ?')) return false" reRender="modAttente,modMessage,panelMotifAnnulation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrCaissierAnnule==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.optionCaisses.saisieAnnulation=='true'}"/>
                <a4j:commandButton title="Supprimer le reçu sélectioné" value="Supprimer Reçu" styleClass="top" style="height:26px;" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.supprimerRecu}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer ce reçu ?')) return false" reRender="modAttente,modMessage,panelMotifSuppression" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.sup&&bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrCaissierDelete==1&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.optionCaisses.saisieSuppression=='true'}"/>
                <a4j:commandButton title="Ajouter Encaissement/Rejet" value="Ajouter Encaissement/Rejet" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.ajoutEncaissement}" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpNature==204||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpNature==205)&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.maj}" reRender="panelEncaissement,formModalEncaissement"/>
                <a4j:commandButton title="Actualiser les tiers" image="/images/actualiser.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.maj&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.visibiliteBton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpEtat==2}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.actualiserTiers}" onclick="if (!confirm('Etes-vous sur de vouloir actualiser les tiers ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="table,pangrpVisbt"/>
                <a4j:commandButton title="Configuration présentation liste" image="/images/configuration.png" style="height:26px;width:26px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrConfigListe==1}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.memoriseConfigListeEntete}" onclick="if (!confirm('Etes-vous sur de vouloir enregistrer cette présentation ?')) return false"/>
            </h:panelGrid>
        </h:panelGrid>

        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_nb_max}" id="table" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="190%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" border="0" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.datamodelElement}" var="var" activeRowKey="true" rowKeyVar="rkv" selection="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.simpleSelectionEntete}" sortMode="multi" selectionMode="single" tableState="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.configListeEntete}" binding="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.extDTable}">
                        <a4j:support eventsQueue="maQueue" event="onselectionchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,pangrpVisbt"/>
                        <a4j:support eventsQueue="maQueue" event="onRowDblClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.visualisationLigne}" reRender="idSubView,pangrpVisbt"/>
                        <rich:column label="Nature" sortable="true" sortBy="#{var.var_lib_nat}" width="130px">
                            <f:facet name="header"><h:outputText  value="Nature"/></f:facet>
                            <h:outputText value="#{var.var_lib_nat}" title="#{var.var_lib_nat}"  style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Opération" sortable="true" sortBy="#{var.libelleOperation}" width="130px">
                            <f:facet name="header"><h:outputText  value="Opération" /></f:facet>
                            <h:outputText value="#{var.libelleOperation}" title="#{var.libelleOperation}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" sortBy="#{var.var_etat}" width="50px">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:graphicImage value="/images/error.gif" rendered="#{var.bonAnnuler}" title="Reçu Annulé ou supprimé"/>&nbsp;
                            <h:outputText value="#{var.var_etat}" title="#{var.var_etat}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="N°" sortable="true" sortBy="#{var.bonCaisNum}" width="120px" sortOrder="DESCENDING">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{var.bonCaisNum}" title="#{var.bonCaisNum}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="N° Origine" sortable="true" sortBy="#{var.bonCaisNumOrigine}" width="80px" >
                            <f:facet name="header"><h:outputText  value="N° Origine" /></f:facet>
                            <h:outputText value="#{var.bonCaisNumOrigine}" title="#{var.bonCaisNumOrigine}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{var.bonCaisDate}" width="70px" >
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{var.bonCaisDate}" title="#{var.bonCaisDate}" style="#{var.color}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{var.bonCaisSerie}" style="text-align:center;" width="40px">
                            <f:facet name="header"><h:outputText  value="S." /></f:facet>
                            <h:outputText value="#{var.bonCaisSerie}" title="#{var.bonCaisSerie}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Tiers (Clients/Fournisseurs/Patients...)" sortable="true" sortBy="#{var.bonCaisNomTiers}" width="200px" >
                            <f:facet name="header"><h:outputText  value="Tiers"  /></f:facet>
                            <h:outputText  value="#{var.bonCaisNomTiers}" title="#{var.bonCaisNomTiers}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Recette" sortable="true" sortBy="#{var.recette}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Recette"/></f:facet>
                            <h:outputText  value="#{var.recette}" rendered="#{var.recette!=0}" style="#{var.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Encaissement/Rejet" sortable="true" sortBy="#{var.bonCaisDateEncaissement}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Enc./Rej."/></f:facet>
                            <h:outputText  value="#{var.bonCaisDateEncaissement}" rendered="#{var.bonCaisDateEncaissement!=null}" style="#{var.color}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                            </h:outputText>
                            <h:outputText  value="#{var.bonCaisDateRejet}" rendered="#{var.bonCaisDateRejet!=null}" style="#{var.color}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Numéro de chèque" sortable="true" sortBy="#{var.bonCaisNumChqBdx}" width="200px" rendered="#{(bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpNature==204||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.inpNature==205)}">
                            <f:facet name="header"><h:outputText value="N° Chèque"  /></f:facet>
                            <h:outputText  value="#{var.bonCaisNumChqBdx}" title="#{var.bonCaisNumChqBdx}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Date à laquelle on peut encaisser le chèque" sortable="true" sortBy="#{var.bonCaisDateRemise}" width="70px">
                            <f:facet name="header"><h:outputText  value="Encais." style="color:red"/></f:facet>
                            <h:outputText value="#{var.bonCaisDateRemise}" title="#{var.bonCaisDateRemise}" style="#{var.color}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Dépense" sortable="true" sortBy="#{var.depense}" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Dépense"/></f:facet>
                            <h:outputText  value="#{var.depense}" rendered="#{var.depense!=0}" style="#{var.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Timbre" sortable="true" sortBy="#{var.timbre}" style="text-align:right;" width="80px">
                            <f:facet name="header"><h:outputText  value="Timbre"/></f:facet>
                            <h:outputText  value="#{var.timbre}" rendered="#{var.timbre!=0}" style="#{var.color}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Type règlement" sortable="true" sortBy="#{var.libelleTypeReg}" width="100px">
                            <f:facet name="header"><h:outputText  value="Type règlement"  /></f:facet>
                            <h:outputText  value="#{var.libelleTypeReg}" title="#{var.libelleTypeReg}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Libellé" sortable="true" sortBy="#{var.bonCaisLibelle}" width="200px">
                            <f:facet name="header"><h:outputText value="Descriptif/Destinataire"  /></f:facet>
                            <h:outputText  value="#{var.bonCaisLibelle}" title="#{var.bonCaisLibelle}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Caisse exécutrice" sortable="true" sortBy="#{var.bonCaisLibCaiss}" width="100px" >
                            <f:facet name="header"><h:outputText  value="Exécutrice"  /></f:facet>
                            <h:outputText  value="#{var.bonCaisLibCaiss}" title="#{var.bonCaisLibCaiss}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Banque Emettrice" sortable="true" sortBy="#{var.bonCaisLibBanqEmetteur}" width="100px" >
                            <f:facet name="header"><h:outputText  value="Emettrice"  /></f:facet>
                            <h:outputText  value="#{var.bonCaisLibBanqEmetteur}" title="#{var.bonCaisLibBanqEmetteur}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Banque Réceptrice" sortable="true" sortBy="#{var.bonCaisLibBanqRecepteur}" width="100px" >
                            <f:facet name="header"><h:outputText  value="Réceptrice"  /></f:facet>
                            <h:outputText  value="#{var.bonCaisLibBanqRecepteur}" title="#{var.bonCaisLibBanqRecepteur}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Activité(s) commerciale(s)" sortable="true" sortBy="#{var.lib_activite}" >
                            <f:facet name="header"><h:outputText value="Activité(s)"  /></f:facet>
                            <h:outputText  value="#{var.lib_activite}" title="#{var.lib_activite}" style="#{var.color}"/>
                        </rich:column>
                        <rich:column label="Caisse" sortable="true" sortBy="#{var.bonCaisLibCaiss}" width="200px" >
                            <f:facet name="header"><h:outputText value="Caisse"  /></f:facet>
                            <h:outputText  value="#{var.bonCaisLibCaiss}" title="#{var.bonCaisLibCaiss}" style="#{var.color}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
                <h:panelGrid id="pnlgrttotal" columns="4" cellspacing="1" styleClass="recherche"  width="100%">
                    <h:outputText value="Total Recettes:" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.totalRecette}" style="width:70%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                    <h:outputText value="Total Dépenses:" />
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.totalDepense}" style="width:70%;text-align:right;" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGrid>
            </div>
        </center>

        <br/>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalPanelPrint}">
        <center>
            <f:facet name="header"><h:outputText value="Impression"/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp">
                        <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                    </a4j:commandButton>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle et un format d'Impression"  style="var.color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid  width="100%">
                    <h:panelGrid  id="panchoixdoc" width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneRadio id="choixDoc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_choix_modele}" >
                            <f:selectItem itemLabel="Document séléctionné" itemValue="0"/>
                            <f:selectItem itemLabel="Liste de documents" itemValue="1"/>
                            <a4j:support eventsQueue="maQueue" reRender="panchoixdoc,docSelect" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.ListeDocImp}" />
                        </h:selectOneRadio>
                        <br>
                        <h:selectOneMenu id="docSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.nomModeleDocument}" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.documentImpressionItems}"/>
                        </h:selectOneMenu>
                        <h:selectOneMenu id="listeSelect" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.nomModeleListe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.affListeDoc}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.listeImpressionItems}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.localApplication&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}"/>
                            <a4j:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.envoieMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.menucaisse.imp}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="formModalImp,modAttente,panelMail"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px green;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelDetail" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="900" height="400" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalpanelDetail}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalpanelDetail}" var="det">
            <center>
                <f:facet name="header"><h:outputText value="Détail de la pièce" style="var.color:white;"/></f:facet>
                <f:facet name="controls">
                    <a4j:form >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.fermerDetailReglement}" image="/images/close.gif" styleClass="hidelink" reRender="panelDetail"/>
                    </a4j:form>
                </f:facet>
                <a4j:form id="formModalDet" >
                    <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Caisse exécutrice:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglCodeCaiss} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglLibCaiss}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Opération:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglOperation} #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.libelleOperation}" readonly="true"/></h:column>
                        <h:column><h:outputText value="Date opérations:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglDateReg}" inputSize="8"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"  readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme<=1}"/></h:column>
                        <h:column><h:outputText value="N°:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglNum}" readonly="true"/></h:column>
                    </h:panelGrid>
                    <h:panelGrid width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                        <h:column><h:outputText value="Mode règlement:"/></h:column>
                        <h:column>
                            <h:selectOneMenu id="idTypeReg" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.var_mode_reglement}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme<=1}">
                                <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.mesTypeReglementsClientItem}"/>
                            </h:selectOneMenu>
                        </h:column>
                        <h:column><h:outputText value="Montant encaissé:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglRecette}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme<=1}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column>
                            <h:outputText value="Montant timbre:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglTimbre}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme<=1}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Libellé:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglLibelle}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme<=1}"/></h:column>
                        <h:column><h:outputText value="Pièce origine:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglDocument}" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme<=1}"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrSysteme>=2}">
                        <center>
                            <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.majReglementJour}"/>
                        </center>
                    </h:panelGroup>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelEncaissement" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalPanelEncaissement}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalPanelEncaissement}" var="enc">
            <center>
                <f:facet name="header"><h:outputText value="Encaissement / Rejet" style="var.color:white;"/></f:facet>
                <f:facet name="controls">
                    <a4j:form >
                        <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.fermerEncaissement}" image="/images/close.gif" styleClass="hidelink" reRender="panelEncaissement"/>
                    </a4j:form>
                </f:facet>
                <a4j:form id="formModalEncaissement" >
                    <h:panelGrid width="100%" columns="2" columnClasses="clos15,clos35">
                        <h:column><h:outputText value="Date encaissement:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglDateEncaissement}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                        <h:column><h:outputText value="OU"/></h:column>
                        <h:column><h:outputText value=""/></h:column>
                        <h:column><h:outputText value="Date rejet:"/></h:column>
                        <h:column><rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglDateRejet}" inputSize="8"   enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGroup>
                        <center>
                            <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.validerEncaissement}"/>
                        </center>
                    </h:panelGroup>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="modAttenteImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="350" height="80" resizeable="false" >
        <f:facet name="header"><h:outputText value="Calcul de l'état en cours, veuillez patienter..."/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton image="/images/close.gif" styleClass="hidelink" id="closeImp" reRender="modAttenteImp">
                    <rich:componentControl attachTo="closeImp" for="modAttenteImp" event="onclick" operation="hide" />
                </a4j:commandButton>
            </a4j:form>
        </f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel><h:graphicImage style="width:20px;height:20px;" value="/images/attente.gif"/></a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="modMessage" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="500" height="200" resizeable="false" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalpanelMessage}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalpanelMessage}" var="msg">
            <f:facet name="header"><h:outputText value="Message..."/></f:facet>
            <f:facet name="controls">
                <a4j:form >
                    <a4j:commandButton id="idCanMessage" image="/images/close.gif" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.fermerMessage}" styleClass="hidelink" reRender="modMessage"/>
                    <rich:hotKey key="esc" handler="#{rich:element('idCanMessage')}.click()" />
                </a4j:form>
            </f:facet>
            <center>
                <a4j:form >
                    <br>
                    <a4j:outputPanel><h:graphicImage width="50px" height="50px" value="/images/Warning.png"/></a4j:outputPanel>
                    <br><br>
                    <h:inputTextarea rows="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.texteMessae}" style="width:100%" readonly="true"/>
                    <br><br>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelMotifAnnulation" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="false;" width="500" height="150" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalPanelMotifAnnuler}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalPanelMotifAnnuler}" var="man">
            <center>
                <f:facet name="header"><h:outputText value="Motif annulation du reçu N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglNum}" style="var.color:white;"/></f:facet>
                <a4j:form id="formMotifAnnulation" >
                    <h:panelGrid width="100%">
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglInfo10}" maxlength="100" style="width:100%">
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idvalAnnulation"/>
                            </h:inputText>
                        </h:column>
                        <br>
                        <h:panelGroup id="idvalAnnulation">
                            <center>
                                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.validationAnnulerRecu}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglInfo10!=null}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </center>
                        </h:panelGroup>
                    </h:panelGrid>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"  id="panelMotifSuppression" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalPanelMotifSupprimer}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.showModalPanelMotifSupprimer}" var="msu">
            <center>
                <f:facet name="header"><h:outputText value="Motif suppression du reçu N° #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglNum}" style="var.color:white;"/></f:facet>
                <a4j:form id="formMotifSupression" >
                    <h:panelGrid width="100%">
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglInfo10}" maxlength="100" style="width:100%">
                                <a4j:support eventsQueue="maQueue" event="onblur" reRender="idvalSuppression"/>
                            </h:inputText>
                        </h:column>
                        <br>
                        <h:panelGroup id="idvalSuppression">
                            <center>
                                <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.validationSupprimerRecu}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanCaisse.formRegCaisse.reglements.rglInfo10!=null}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                            </center>
                        </h:panelGroup>
                    </h:panelGrid>
                </a4j:form>
            </center>
        </c:if>
    </rich:modalPanel>


</f:subview>

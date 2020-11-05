<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="caisseCommerciale">

    <a4j:form>

        <center> <h2><h:outputText value="LISTE DES CAISSES COMMERCIALES" style="color:green;"/></h2></center>

        <center>
            <h:panelGrid id="pangrpVisbt" columns="4" width="250px">
                <a4j:commandButton title="Ajouter nouvelle caisse" image="/images/ajouter.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.ajouterCaisse}" reRender="panelCaisse"/>
                <a4j:commandButton title="Modifier la caisse sélectionnée" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.modifierCaisse}" reRender="panelCaisse"/>
                <a4j:commandButton title="Supprimer la caisse sélectionnée" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.visibiliteBton}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.supprimerCaisse}" onclick="if (!confirm('Etes vous sur de vouloir supprimer cet élément?')) return false" reRender="table,pangrpVisbt"/>
                <a4j:commandButton title="Imprimer les caisses" image="/images/print.png" oncomplete="javascript:Richfaces.showModalPanel('panelImp');"/>
            </h:panelGrid>
        </center>
        <br>
        <center>
            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable id="table" headerClass="headerTab"  activeClass="active-row" rowClasses="rows1,rows2,rowsd" border="0" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" width="150%" align="center" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.datamodelCaisse}" var="caisse">
                        <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.selectionCaisse}" reRender="pangrpVisbt"/>
                        <rich:column sortable="true" sortBy="#{caisse.caiCode}" sortOrder="ASCENDING">
                            <f:facet name="header"><h:outputText  value="Code"/></f:facet>
                            <h:outputText value="#{caisse.caiCode}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiNom}" width="200px">
                            <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                            <h:outputText  value="#{caisse.caiNom}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.libMode}" width="70px">
                            <f:facet name="header"><h:outputText  value="Mode"/></f:facet>
                            <h:outputText  value="#{caisse.libMode}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiTrfCaisse}">
                            <f:facet name="header"><h:outputText  value="Cais Inter."/></f:facet>
                            <h:outputText  value="#{caisse.caiTrfCaisse}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrEspece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspece}">
                            <f:facet name="header"><h:outputText  value="Jr.Espèces"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrEspece}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrEspece}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspeceST}">
                            <f:facet name="header"><h:outputText  value="Jr.Espèces ST"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrEspeceST}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrCheque}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCheque}">
                            <f:facet name="header"><h:outputText  value="Jr.Chèque"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrCheque}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrVirement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheVirement}">
                            <f:facet name="header"><h:outputText  value="Jr.Virement"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrVirement}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrTraite}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTraite}">
                            <f:facet name="header"><h:outputText  value="Jr.Traite"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrTraite}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrTpe}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTpe}">
                            <f:facet name="header"><h:outputText  value="Jr.TPE"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrTpe}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrTransfert}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTransfert}">
                            <f:facet name="header"><h:outputText  value="Jr.Transfert"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrTransfert}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrePaiement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheePaiement}">
                            <f:facet name="header"><h:outputText  value="Jr.ePaiement"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrePaiement}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrCredoc}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCredoc}">
                            <f:facet name="header"><h:outputText  value="Jr.Credoc"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrCredoc}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrFactor}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheFactor}">
                            <f:facet name="header"><h:outputText  value="Jr.Factor"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrFactor}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrCompense}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCompense}">
                            <f:facet name="header"><h:outputText  value="Jr.Compense"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrCompense}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrTerme}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTerme}">
                            <f:facet name="header"><h:outputText  value="Jr.Terme"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrTerme}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrLettreGarantie}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheLettreGarantie}">
                            <f:facet name="header"><h:outputText  value="Jr.Lett.Gar."/></f:facet>
                            <h:outputText  value="#{caisse.caiJrLettreGarantie}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrPrelevement}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_affichePrelevement}">
                            <f:facet name="header"><h:outputText  value="Jr.Prélèvement"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrPrelevement}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiJrAlcoin}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheAlcoin}">
                            <f:facet name="header"><h:outputText  value="Jr.Alcoin"/></f:facet>
                            <h:outputText  value="#{caisse.caiJrAlcoin}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiProjet}" width="200px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.projetActif}">
                            <f:facet name="header"><h:outputText  value="Projet"/></f:facet>
                            <h:outputText  value="#{caisse.caiProjet}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.caiNegatif}" width="50px" style="text-align:center">
                            <f:facet name="header"><h:outputText  value="Neg."/></f:facet>
                            <h:graphicImage value="/images/negatifInterdit.png" height="20px" width="20px" rendered="#{caisse.caiNegatif==1}"/>
                        </rich:column>
                        <rich:column sortable="true" sortBy="#{caisse.etat}" width="50px">
                            <f:facet name="header"><h:outputText  value="Etat"/></f:facet>
                            <h:commandButton image="#{caisse.etat}" rendered="#{caisse.afficheImag}"  onclick="if (!confirm('Voulez-vous réactiver cet élément ?')) return false" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.reactiverCaisse}">
                                <a4j:support eventsQueue="maQueue" reRender="table"/>
                            </h:commandButton>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </div>
        </center>
        <br>
        <center>
            <h:commandButton id="idCancel" value="RETOUR"styleClass="exp_lienmenu" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.retourLigne}" />
            <rich:hotKey key="esc"  handler="#{rich:element('idCancel')}.click()" />
        </center>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelCaisse" width="900" height="450" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.showModalPanelCaisse}">
        <f:facet name="header"><h:outputText value="GESTION DES CAISSES COMMERCIALES"/></f:facet>
        <f:facet name="controls">
            <a4j:form >
                <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.annule}" image="/images/close.gif" styleClass="hidelink" id="hidelink" reRender="panelCaisse"/>
                <rich:componentControl for="panelCaisse" attachTo="hidelink" operation="hide" event="onclick"/>
            </a4j:form>
        </f:facet>
        <a4j:form >
            <h:panelGroup  style="width:100%;">
                <h:panelGrid columns="4" styleClass="fichefournisseur" width="100%" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Code:"/></h:column>
                    <h:column>
                        <h:inputText id="inptcodAjt" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiCode}" onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiId!=0}" maxlength="20">
                            <a4j:support eventsQueue="maQueue" event="onchange" reRender="ppgrp,outptcode,btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.doublonCode}"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Libellé:"/></h:column>
                    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiNom}"  onkeypress="return scanToucheLettre(event)" style="width:100%;text-transform:uppercase" maxlength="100"/></h:column>
                    <h:column><h:outputText value="Liste Caissiers:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.idCaissier}">
                            <f:selectItem itemLabel="Liste des caissiers en accès" itemValue="0"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesCaissiersItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.projetActif}"><h:outputText value="Projet:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.projetActif}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiProjet}">
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesProjetsItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                </h:panelGrid>

                <h:panelGrid id="idJournaux" columns="5" width="100%" columnClasses="clos15,clos30,clos5c,clos15,clos35">
                    <h:column><h:outputText value="Caisse intermédiaire:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_trfCaisse}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesTrfCaisseItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column>
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportTrfCaisse}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspece}"><h:outputText value="Journal Espèces:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspece}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalEspece}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspece}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrEspece}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspece}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspece}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitEspece}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalEspece=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspeceST}"><h:outputText value="Journal Espèces sans timbre:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspeceST}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalEspeceST}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspeceST}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrEspece}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspeceST}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheEspeceST}"><h:outputText value=""/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCheque}"><h:outputText value="Journal Chèque:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCheque}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalCheque}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCheque}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrCheque}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCheque}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCheque}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitCheque}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalCheque=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheVirement}"><h:outputText value="Journal Virement:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheVirement}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalVirement}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheVirement}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrVirement}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheVirement}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheVirement}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitVirement}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalVirement=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTraite}"><h:outputText value="Journal Traites:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTraite}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalTraite}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTraite}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrTraite}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTraite}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTraite}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitTraite}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalTraite=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTpe}"><h:outputText value="Journal TPE:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTpe}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalTpe}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTpe}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrTpe}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTpe}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTpe}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitTpe}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalTpe=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTransfert}"><h:outputText value="Journal Transfert argent:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTransfert}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalTransfert}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTransfert}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrTrf}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTransfert}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTransfert}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitTransfert}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalTransfert=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheePaiement}"><h:outputText value="Journal ePaiement:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheePaiement}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalePaiement}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheePaiement}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrePaiement}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheePaiement}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheePaiement}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitePaiement}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalePaiement=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCredoc}"><h:outputText value="Journal Crédoc:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCredoc}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalCredoc}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCredoc}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrCredoc}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCredoc}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCredoc}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitCredoc}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalCredoc=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheFactor}"><h:outputText value="Journal Factor:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheFactor}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalFactor}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheFactor}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrFactor}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheFactor}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheFactor}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitFactor}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalFactor=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCompense}"><h:outputText value="Journal Compense:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCompense}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalCompense}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCompense}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrCompense}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCompense}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheCompense}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitCompense}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalCompense=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTerme}"><h:outputText value="Journal Terme:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTerme}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalTerme}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTerme}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrTerme}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTerme}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheTerme}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitTerme}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalTerme=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheLettreGarantie}"><h:outputText value="Journal Lettre garantie:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheLettreGarantie}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalLettreGarantie}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheLettreGarantie}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrLettreGarantie}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheLettreGarantie}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheLettreGarantie}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitLettreGarantie}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalLettreGarantie=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_affichePrelevement}"><h:outputText value="Journal Prélèvement:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_affichePrelevement}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalPrelevement}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_affichePrelevement}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrPrelevement}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_affichePrelevement}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_affichePrelevement}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitPrelevement}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalPrelevement=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheAlcoin}"><h:outputText value="Journal Alcoin:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheAlcoin}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalAlcoin}">
                            <f:selectItem itemLabel="Non autorisé" itemValue="100"/>
                            <f:selectItem itemLabel="TRF" itemValue="TRF:TRF"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                            <a4j:support event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.affichageMontantInit}" reRender="idJournaux"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheAlcoin}">
                        <h:selectBooleanCheckbox style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiExportJrAlcoin}"/>
                        <h:outputText value="Transfert"/>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheAlcoin}"><h:outputText value="Montant init.:"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_afficheAlcoin}">
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInitAlcoin}" style="width:50%;text-align:right;" readonly="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_journalAlcoin=='100'}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            <a4j:support event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.calculTotalInit}" reRender="idMontantTotal,idJournaux"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
                <h:panelGrid columns="4" width="100%" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35">
                    <h:column><h:outputText value="Date initial."/></h:column>
                    <h:column>
                        <rich:calendar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiDateInit}" inputSize="8" enableManualInput="true" datePattern="dd/MM/yyyy" locale="fr" style=" background-color:white;"/>
                    </h:column>
                    <h:column><h:outputText value="Montant initial."/></h:column>
                    <h:column>
                        <h:inputText id="idMontantTotal" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantInit}" readonly="true" style="width:50%;text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Compte vr. interne" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_compte}">
                            <f:selectItem itemLabel="Sélection Compte virement" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesPlansComptableItem}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Compte effet à encais." style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_compteEffet}">
                            <f:selectItem itemLabel="Sélection Compte effet à encaisser" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesPlansComptableItem}"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Mode caisse" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMode}">
                            <f:selectItem itemLabel="Mixte" itemValue="0"/>
                            <f:selectItem itemLabel="Les Dépenses" itemValue="1"/>
                            <f:selectItem itemLabel="Les Recettes" itemValue="2"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Banque par défaut" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.var_banqueDefaut}">
                            <f:selectItem itemLabel="Sans banque par défaut" itemValue="100"/>
                            <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.mesJouranuxCaisseItems}"/>
                        </h:selectOneMenu>
                    </h:column>               
                    <h:column><h:outputText value="Fond de caisse plancher"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantFondCaisse}" style="width:100%;text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Fond de caisse plafond"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantFondCaisseMax}" style="width:100%;text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Dépense maximale sans habilitation:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMontantMaxDepense}" style="width:100%;text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Mvt chèque en banque:" style="text-decoration:underline;"/></h:column>
                    <h:column>
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiMvtCheBnq}"  >
                            <f:selectItem itemLabel="Interdit" itemValue="0"/>
                            <f:selectItem itemLabel="Autorisé" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}"><h:outputText value="Réservé:" style="text-decoration:underline;"/></h:column>
                    <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrJrxReserve==0}">
                        <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiPrive}"  >
                            <f:selectItem itemLabel="Publique" itemValue="0"/>
                            <f:selectItem itemLabel="Privée" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Caisse négative:"/></h:column>
                    <h:column>
                        <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.caissesCommerciales.caiNegatif}" style="width:100%;">
                            <f:selectItem itemLabel="Autorisée" itemValue="0"/>
                            <f:selectItem itemLabel="Interdite" itemValue="1"/>
                        </h:selectOneMenu>
                    </h:column>
                    <h:column><h:outputText value="Caisse désactivée:"/></h:column>
                    <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.inactif}"/></h:column>
                </h:panelGrid>
                <h:panelGrid style="width:100%;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable  style="border:solid 0px green;" border="0" id="serieCaisse" width="100%" height="200px" footerClass="bard" activeClass="active-row" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" noDataLabel=" " value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.dataModelOperation}" var="ope">
                            <rich:column width="10%" sortable="true">
                                <f:facet name="header" >
                                    <a4j:commandButton image="/images/allSelect.png" title="Tout/Rien sélectionné" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.allSelect}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,serieCaisse"/>
                                </f:facet>
                                <h:selectBooleanCheckbox value="#{ope.select}"/>
                            </rich:column>
                            <rich:column width="10%" >
                                <f:facet name="header" ><h:outputText value="Code"/></f:facet>
                                <h:outputText value="#{ope.caiopeCode}"/>
                            </rich:column>
                            <rich:column width="60%" >
                                <f:facet name="header" ><h:outputText value="Nature opérations"/></f:facet>
                                <h:outputText value="#{ope.caiopeNom}"/>
                            </rich:column>
                            <rich:column width="10%" >
                                <f:facet name="header" ><h:outputText value="Mode"/></f:facet>
                                <h:outputText value="#{ope.libMode}"/>
                            </rich:column>
                            <rich:column width="10%" >
                                <f:facet name="header" ><h:outputText value="Type"/></f:facet>
                                <h:outputText value="#{ope.libType}"/>
                            </rich:column>
                            <a4j:support event="onchange" reRender="idPlaf"/>
                        </rich:extendedDataTable>
                    </a4j:region>
                </h:panelGrid>

            </h:panelGroup>

            <h:panelGroup id="ppgrp">
                <center>
                    <br><br>
                    <h:commandButton image="/images/valider_big.png" id="btvaldAjt" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.saveCaisse}"  rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.doublon}"/>
                </center>
                <center>
                    <h:outputText  id="outptcode" style="color:red;" value="Le code est obligatoire et doit être unique" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAdministration.formCaissesCommerciales.doublon}"/>
                </center>
            </h:panelGroup>

        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel" id="panelImp" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="550" height="200">
        <jsp:include flush="true" page="/commun/impressionParametre.jsp"/>
    </rich:modalPanel>

</f:subview>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="transfertComta">

    <a4j:form enctype="multipart/form-data">

        <center> <h2><h:outputText value="PREPARATION DU TRANSFERT DES ELEMENTS EN COMPTABILITE (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.balance})" styleClass="titre"/></h2></center>

        <rich:panel id="idPanel">

            <rich:tabPanel switchType="client" immediate="true" selectedTab="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.onglet}" style="border:0px;" width="100%">

                <rich:tab label="Eléments à transférer" id="idTab01" >
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.tab01}"/>
                    <h:panelGrid id="panelBouton" columns="5" width="350px">
                        <h:commandButton title="Transférer la liste en cours" image="/images/transferer.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.transfertCompta}" onclick="if (!confirm('Vouez-vous transférer les éléments en comptabilité ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_verif_transfert}"/>
                        <a4j:commandButton title="Exporter la liste en cours" image="/images/exporter.png" oncomplete="javascript:Richfaces.showModalPanel('modalPanelExport');" reRender="modalPanelExport" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_verif_transfert}"/>
                        <a4j:commandButton title="Imprimer la liste en cours" image="/images/print.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.initImpression}" reRender="panelImp,formModalImp,panchoixdoc,panelMail"/>
                        <h:commandButton title="Enlever les Ref1 identiques (entre le nouveau trf et les écritures déjà transférées)" image="/images/actualiser.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.filtreCompta}" onclick="if (!confirm('Vouez-vous enlever les pièces identiques (N° facture = N° Ref1) ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');"/>
                        <h:column id="idMessage" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_verif_transfert}"><h:outputText value="Le transfert est impossible..." style="color:red"/></h:column>
                    </h:panelGrid>
                    <br>

                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.balance==0}" var="bal0">
                        <div style="overflow:scroll;height:500px;width:100%;border:solid 0px green;">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20" align="left" for="tableids"/>
                                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " styleClass="bg" footerClass="bard" style="max-height:100%" headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.dataModelTransfertCompta}" var="table" id="tableids" rowClasses="rows1,rows2,rowsd" width="250%">
                                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton" />
                                    <rich:column label="Code journal comptable" width="80px" sortable="true" sortBy="#{table.trfCode}">
                                        <f:facet name="header"><h:outputText  value="Journal" /></f:facet>
                                        <h:outputText value="#{table.trfCode}"/>
                                    </rich:column>
                                    <rich:column label="Date écriture" sortable="true" sortBy="#{table.trfDateSaisie} #{table.trfPiece}" sortOrder="ASCENDING">
                                        <f:facet name="header"><h:outputText  value="Date"  /></f:facet>
                                        <h:outputText  value="#{table.trfDateSaisie}">
                                            <f:convertDateTime pattern="dd/MM/yyyy"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="N° pièce" sortable="true" sortBy="#{table.trfPiece}" >
                                        <f:facet name="header"><h:outputText  value="Pièce" /></f:facet>
                                        <h:outputText value="#{table.trfPiece}"/>
                                    </rich:column>
                                    <rich:column label="N° compte" sortable="true" sortBy="#{table.trfCompte}" >
                                        <f:facet name="header"><h:outputText  value="Compte"/></f:facet>
                                        <h:outputText value="#{table.trfCompte}"/>
                                    </rich:column>
                                    <rich:column label="Libellé écriture" width="300px" sortable="true" sortBy="#{table.trfLibelle}">
                                        <f:facet name="header"><h:outputText  value="Libelle "/></f:facet>
                                        <h:outputText value="#{table.trfLibelle}"/>
                                    </rich:column>
                                    <rich:column label="Libellé complémentaire" width="300px" sortable="true" sortBy="#{table.trfSuite}">
                                        <f:facet name="header"><h:outputText  value="Libelle complémentaire"/></f:facet>
                                        <h:outputText value="#{table.trfSuite}"/>
                                    </rich:column>
                                    <rich:column label="Lettrage" sortable="true" sortBy="#{table.trfLettre}">
                                        <f:facet name="header"><h:outputText  value="Let."/></f:facet>
                                        <h:outputText value="#{table.trfLettre}"/>
                                    </rich:column>
                                    <rich:column label="Référence 1 pièce" sortable="true" sortBy="#{table.trfReference1}">
                                        <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                                        <h:outputText value="#{table.trfReference1}"/>
                                    </rich:column>
                                    <rich:column label="Référence 2 pièce" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.trfReference2}">
                                        <f:facet name="header"><h:outputText  value="Réf.2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.optionComptabilite.testRef2Piece}"/></f:facet>
                                        <h:outputText value="#{table.trfReference2}"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.optionComptabilite.testRef2Piece}"/>
                                    </rich:column>
                                    <rich:column label="Débit" style="text-align:right;" sortable="true" sortBy="#{table.trfDebitSaisie}" >
                                        <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                                        <h:outputText   value="#{table.trfDebitSaisie}" rendered="#{table.trfDebitSaisie!=0}" >
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Crédit" style="text-align:right;" sortable="true" sortBy="#{table.trfCreditSaisie}" >
                                        <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                                        <h:outputText value="#{table.trfCreditSaisie}" rendered="#{table.trfCreditSaisie!=0}">
                                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Date échéance" sortable="true" sortBy="#{table.trfDateEcheance}"  >
                                        <f:facet name="header"><h:outputText  value="Echéance"  /></f:facet>
                                        <h:outputText value="#{table.trfDateEcheance}" >
                                            <f:convertDateTime pattern="dd/MM/yyyy"/>
                                        </h:outputText>
                                    </rich:column>
                                    <rich:column label="Clé1" width="80px" sortable="true" sortBy="#{table.trfRepartitionCle1}" >
                                        <f:facet name="header"><h:outputText  value="Clé1"/></f:facet>
                                        <h:outputText value="#{table.trfRepartitionCle1}" />
                                    </rich:column>
                                    <rich:column label="Clé2" width="80px" sortable="true" sortBy="#{table.trfRepartitionCle2}" >
                                        <f:facet name="header"><h:outputText  value="Clé2"/></f:facet>
                                        <h:outputText value="#{table.trfRepartitionCle2}" />
                                    </rich:column>
                                    <rich:column label="Activité commerciale" width="80px" >
                                        <f:facet name="header"><h:outputText  value="Activite" /></f:facet>
                                        <h:outputText  value="#{table.trfActivite}"/>
                                    </rich:column>
                                    <rich:column label="Site" width="80px" sortable="true" sortBy="#{table.trfSite}" >
                                        <f:facet name="header"><h:outputText  value="Site"/></f:facet>
                                        <h:outputText value="#{table.trfSite}" />
                                    </rich:column>
                                    <rich:column label="Département" width="80px" sortable="true" sortBy="#{table.trfDepartement}" >
                                        <f:facet name="header"><h:outputText  value="Dépt."/></f:facet>
                                        <h:outputText value="#{table.trfDepartement}"/>
                                    </rich:column>
                                    <rich:column label="Service" width="80px" sortable="true" sortBy="#{table.trfService}" >
                                        <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                        <h:outputText value="#{table.trfService}"  />
                                    </rich:column>
                                    <rich:column label="Région" width="80px" sortable="true" sortBy="#{table.trfRegion}" >
                                        <f:facet name="header"><h:outputText  value="Région"/></f:facet>
                                        <h:outputText value="#{table.trfRegion}"  />
                                    </rich:column>
                                    <rich:column label="Secteur" width="80px" sortable="true" sortBy="#{table.trfSecteur}" >
                                        <f:facet name="header"><h:outputText  value="Secteur"/></f:facet>
                                        <h:outputText value="#{table.trfSecteur}" />
                                    </rich:column>
                                    <rich:column label="Point de vente" width="80px" sortable="true" sortBy="#{table.trfPdv}" >
                                        <f:facet name="header"><h:outputText  value="PDV" /></f:facet>
                                        <h:outputText value="#{table.trfPdv}"/>
                                    </rich:column>
                                    <rich:column label="Parc" width="80px" sortBy="#{table.trfParc}">
                                        <f:facet name="header"><h:outputText  value="Parc"/></f:facet>
                                        <h:outputText value="#{table.trfParc}"  />
                                    </rich:column>
                                    <rich:column label="Dossier" width="80px" sortBy="#{table.trfDossier}">
                                        <f:facet name="header"><h:outputText  value="Dossier" /></f:facet>
                                        <h:outputText value="#{table.trfDossier}"  />
                                    </rich:column>
                                    <rich:column label="Budget" width="80px" sortable="true" sortBy="#{table.trfBudget}" >
                                        <f:facet name="header"><h:outputText  value="Budget" /></f:facet>
                                        <h:outputText  value="#{table.trfBudget}"/>
                                    </rich:column>
                                    <rich:column label="Type importation" width="80px" sortable="true" sortBy="#{table.trfTypeImport}" >
                                        <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                                        <h:outputText  value="#{table.trfTypeImport}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </div>
                    </c:if>

                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.balance==1}" var="bal1">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.pageIndex}" reRender="tableidsBalance" id="scrollTable1" maxPages="20" align="left" for="tableidsBalance"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " styleClass="bg" footerClass="bard" style="max-height:100%" headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.dataModelTransfertCompta}" var="table" id="tableidsBalance" rowClasses="rows1,rows2,rowsd" width="100%">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.selectionLigne}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBouton" />
                                <rich:column label="Code journal comptable" width="80px" sortable="true" sortBy="#{table.trfCode}">
                                    <f:facet name="header"><h:outputText  value="Journal" /></f:facet>
                                    <h:outputText value="#{table.trfCode}"/>
                                </rich:column>
                                <rich:column label="Date écriture" sortable="true" sortBy="#{table.trfDateSaisie} #{table.trfPiece}" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="Date"  /></f:facet>
                                    <h:outputText  value="#{table.trfDateSaisie}">
                                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="N° pièce" sortable="true" sortBy="#{table.trfPiece}" >
                                    <f:facet name="header"><h:outputText  value="Pièce" /></f:facet>
                                    <h:outputText value="#{table.trfPiece}"/>
                                </rich:column>
                                <rich:column label="N° compte" sortable="true" sortBy="#{table.trfCompte}" >
                                    <f:facet name="header"><h:outputText  value="Compte"/></f:facet>
                                    <h:outputText value="#{table.trfCompte}"/>
                                </rich:column>
                                <rich:column label="Libellé écriture" width="300px" sortable="true" sortBy="#{table.trfLibelle}">
                                    <f:facet name="header"><h:outputText  value="Libelle "/></f:facet>
                                    <h:outputText value="#{table.trfLibelle}"/>
                                </rich:column>
                                <rich:column label="Débit AN" style="text-align:right;" width="150px" sortable="true" sortBy="#{table.trfDebitSaisie}" >
                                    <f:facet name="header"><h:outputText  value="Débit AN" /></f:facet>
                                    <h:outputText   value="#{table.trfDebitSaisie}" rendered="#{table.trfDebitSaisie!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Crédit AN" style="text-align:right;" width="150px" sortable="true" sortBy="#{table.trfCreditSaisie}" >
                                    <f:facet name="header"><h:outputText  value="Crédit AN" /></f:facet>
                                    <h:outputText value="#{table.trfCreditSaisie}" rendered="#{table.trfCreditSaisie!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Débit MVTS" style="text-align:right;" width="150px" sortable="true" sortBy="#{table.trfDebitMvts}" >
                                    <f:facet name="header"><h:outputText  value="Débit MVTS" /></f:facet>
                                    <h:outputText   value="#{table.trfDebitMvts}" rendered="#{table.trfDebitMvts!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Crédit MVTS" style="text-align:right;" width="150px" sortable="true" sortBy="#{table.trfCreditMvts}" >
                                    <f:facet name="header"><h:outputText  value="Crédit MVTS" /></f:facet>
                                    <h:outputText value="#{table.trfCreditMvts}" rendered="#{table.trfCreditMvts!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Type importation" width="80px" sortable="true" sortBy="#{table.trfTypeImport}" >
                                    <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                                    <h:outputText  value="#{table.trfTypeImport}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </c:if>

                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.balance==2||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.balance==4}" var="bal24">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable2" maxPages="20" align="left" for="tableids"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " styleClass="bg" footerClass="bard" style="max-height:100%" headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.dataModelTransfertCompta}" var="table" id="tableids" rowClasses="rows1,rows2,rowsd" width="100%">
                                <rich:column label="Compte général" width="150px" sortable="true" sortBy="#{table.trfCompte}">
                                    <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                                    <h:outputText value="#{table.trfCompte}"/>
                                </rich:column>
                                <rich:column label="Compte de tiers Sage" width="150px" sortable="true" sortBy="#{table.trfCp}" >
                                    <f:facet name="header"><h:outputText  value="Tiers" /></f:facet>
                                    <h:outputText value="#{table.trfCp}"/>
                                </rich:column>
                                <rich:column label="Libellé compte" width="300px" sortable="true" sortBy="#{table.trfLibelle}">
                                    <f:facet name="header"><h:outputText  value="Libelle "/></f:facet>
                                    <h:outputText value="#{table.trfLibelle}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </c:if>

                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.balance==3}" var="bal3">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable3" maxPages="20" align="left" for="tableImmo"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " styleClass="bg" footerClass="bard" style="max-height:100%" headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.dataModelTransfertCompta}" var="table" id="tableImmo" rowClasses="rows1,rows2,rowsd" width="100%">
                                <rich:column label="N° immobilisation" width="150px" sortable="true" sortBy="#{table.trfCode}">
                                    <f:facet name="header"><h:outputText  value="Immobilisation" /></f:facet>
                                    <h:outputText value="#{table.trfCode}"/>
                                </rich:column>
                                <rich:column label="Date achat" sortable="true" sortBy="#{table.trfDateSaisie}" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="Date"  /></f:facet>
                                    <h:outputText  value="#{table.trfDateSaisie}">
                                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Compte immobilisation" width="150px" sortable="true" sortBy="#{table.trfCompte}">
                                    <f:facet name="header"><h:outputText  value="Cpt Immo" /></f:facet>
                                    <h:outputText value="#{table.trfCompte}"/>
                                </rich:column>
                                <rich:column label="Compte amortissement" width="150px" sortable="true" sortBy="#{table.trfCp}" >
                                    <f:facet name="header"><h:outputText  value="Cpt. Amo." /></f:facet>
                                    <h:outputText value="#{table.trfCp}"/>
                                </rich:column>
                                <rich:column label="Compte dotation" width="150px" sortable="true" sortBy="#{table.trfBudget}" >
                                    <f:facet name="header"><h:outputText  value="Cpt. Dot." /></f:facet>
                                    <h:outputText value="#{table.trfBudget}"/>
                                </rich:column>
                                <rich:column label="Libellé du bien" width="300px" sortable="true" sortBy="#{table.trfLibelle}">
                                    <f:facet name="header"><h:outputText  value="Libelle "/></f:facet>
                                    <h:outputText value="#{table.trfLibelle}"/>
                                </rich:column>
                                <rich:column label="Nb Année" style="text-align:right;" sortable="true" sortBy="#{table.trfDebitMvts}" >
                                    <f:facet name="header"><h:outputText  value="Durée" /></f:facet>
                                    <h:outputText value="#{table.trfDebitMvts}/#{table.trfCreditMvts}" rendered="#{table.trfDebitMvts!=0}"/>
                                </rich:column>
                                <rich:column label="Valeur Achat" style="text-align:right;" sortable="true" sortBy="#{table.trfDebitSaisie}" >
                                    <f:facet name="header"><h:outputText  value="Achat" /></f:facet>
                                    <h:outputText   value="#{table.trfDebitSaisie}" rendered="#{table.trfDebitSaisie!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Valeur résiduelle" style="text-align:right;" sortable="true" sortBy="#{table.trfCreditSaisie}" >
                                    <f:facet name="header"><h:outputText  value="Résiduel" /></f:facet>
                                    <h:outputText value="#{table.trfCreditSaisie}" rendered="#{table.trfCreditSaisie!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </c:if>

                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.balance==5}" var="bal5">
                        <a4j:region renderRegionOnly="false">
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable5" maxPages="20" align="left" for="tableids"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " styleClass="bg" footerClass="bard" style="max-height:100%" headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.dataModelTransfertCompta}" var="table" id="tableids" rowClasses="rows1,rows2,rowsd" width="100%">
                                <rich:column label="Code journal" width="150px" sortable="true" sortBy="#{table.trfCode}">
                                    <f:facet name="header"><h:outputText  value="Code" /></f:facet>
                                    <h:outputText value="#{table.trfCode}"/>
                                </rich:column>
                                <rich:column label="Compte de trésorerie" width="150px" sortable="true" sortBy="#{table.trfCp}" >
                                    <f:facet name="header"><h:outputText  value="Compte Tréso." /></f:facet>
                                    <h:outputText value="#{table.trfCp}"/>
                                </rich:column>
                                <rich:column label="Libellé journal" width="300px" sortable="true" sortBy="#{table.trfLibelle}">
                                    <f:facet name="header"><h:outputText  value="Libellé"/></f:facet>
                                    <h:outputText value="#{table.trfLibelle}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </c:if>

                    <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.balance==80||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.balance==81}" var="impvar">
                        <div style="overflow:scroll;height:500px;width:100%;border:solid 0px green;">
                            <a4j:region renderRegionOnly="false">
                                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" reRender="table" id="scrollTable" maxPages="20" align="left" for="table"/>
                                <rich:extendedDataTable rows="300" enableContextMenu="false" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="150%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.dataModelTransfertCompta}" var="doc">
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT00}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT01}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT02}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT03}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT04}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT05}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT06}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT07}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT08}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT09}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT10}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT11}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT12}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT13}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT14}"/>
                                    </rich:column>
                                    <rich:column sortable="false">
                                        <h:outputText value="#{doc.trfColT15}"/>
                                    </rich:column>
                                </rich:extendedDataTable>
                            </a4j:region>
                        </div>
                    </c:if>

                </rich:tab>

                <rich:tab label="Eléments en erreur" id="idTab02" style="color:red;" rendered="#{!bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_verif_transfert}">
                    <a4j:support eventsQueue="maQueue" event="onlabelclick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.tab02}"/>
                    <h:panelGrid id="panelBoutonErreur" columns="2" width="300px">
                        <a4j:commandButton value="Modifier Compte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.ouvrirmodifligne}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfDateSaisie!=null}" reRender="modalPanelMofif"/>
                        <a4j:commandButton value="Modifier Analytique" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.ouvrirmodifAnal}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfDateSaisie!=null}" reRender="modalPanelAnalytique"/>
                    </h:panelGrid>
                    <br>
                    <div style="overflow:scroll;height:500px;width:100%;border:solid 0px green;">
                        <a4j:region renderRegionOnly="false" >
                            <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.pageIndex}" reRender="tableidsErreur" id="scrollTableErreur" maxPages="20" align="left" for="tableidsErreur"/>
                            <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_nb_max}" border="0" activeClass="active-row" noDataLabel=" " styleClass="bg" footerClass="bard" style="max-height:100%" headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.dataModelTransfertErreur}" var="table" id="tableidsErreur" rowClasses="rows1,rows2,rowsd" width="200%">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.selectionLigneErreur}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonErreur" />
                                <rich:column label="Libellé erreur" width="150px" sortable="true" sortBy="#{table.trfErreur}">
                                    <f:facet name="header"><h:outputText  value="Erreur"/></f:facet>
                                    <h:outputText value="#{table.trfErreur}"/>
                                </rich:column>
                                <rich:column label="Code journal comptable" width="80px" sortable="true" sortBy="#{table.trfCode}">
                                    <f:facet name="header"><h:outputText  value="Journal" /></f:facet>
                                    <h:outputText value="#{table.trfCode}"/>
                                </rich:column>
                                <rich:column label="Date écriture" sortable="true" sortBy="#{table.trfDateSaisie} #{table.trfPiece}" sortOrder="ASCENDING">
                                    <f:facet name="header"><h:outputText  value="Date"  /></f:facet>
                                    <h:outputText  value="#{table.trfDateSaisie}">
                                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="N° pièce" sortable="true" sortBy="#{table.trfPiece}" >
                                    <f:facet name="header"><h:outputText  value="Pièce" /></f:facet>
                                    <h:outputText value="#{table.trfPiece}"/>
                                </rich:column>
                                <rich:column label="N° compte" sortable="true" sortBy="#{table.trfCompte}" >
                                    <f:facet name="header"><h:outputText  value="Compte"/></f:facet>
                                    <h:outputText value="#{table.trfCompte}"/>
                                </rich:column>
                                <rich:column label="Libellé écriture" width="300px" sortable="true" sortBy="#{table.trfLibelle}">
                                    <f:facet name="header"><h:outputText  value="Libelle "/></f:facet>
                                    <h:outputText value="#{table.trfLibelle}"/>
                                </rich:column>
                                <rich:column label="Référence 1 pièce" sortable="true" sortBy="#{table.trfReference1}">
                                    <f:facet name="header"><h:outputText  value="Réf.1"/></f:facet>
                                    <h:outputText value="#{table.trfReference1}"/>
                                </rich:column>
                                <rich:column label="Référence 2 pièce" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.optionComptabilite.testRef2Piece}" sortable="true" sortBy="#{table.trfReference2}">
                                    <f:facet name="header"><h:outputText  value="Réf.2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.optionComptabilite.testRef2Piece}"/></f:facet>
                                    <h:outputText value="#{table.trfReference2}"  rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.optionComptabilite.testRef2Piece}"/>
                                </rich:column>
                                <rich:column label="Débit" style="text-align:right;" sortable="true" sortBy="#{table.trfDebitSaisie}" >
                                    <f:facet name="header"><h:outputText  value="Débit" /></f:facet>
                                    <h:outputText   value="#{table.trfDebitSaisie}" rendered="#{table.trfDebitSaisie!=0}" >
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Crédit" style="text-align:right;" sortable="true" sortBy="#{table.trfCreditSaisie}" >
                                    <f:facet name="header"><h:outputText  value="Crédit" /></f:facet>
                                    <h:outputText value="#{table.trfCreditSaisie}" rendered="#{table.trfCreditSaisie!=0}">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Date échéance" sortable="true" sortBy="#{table.trfDateEcheance}"  >
                                    <f:facet name="header"><h:outputText  value="Echéance"  /></f:facet>
                                    <h:outputText value="#{table.trfDateEcheance}" >
                                        <f:convertDateTime pattern="dd/MM/yyyy"/>
                                    </h:outputText>
                                </rich:column>
                                <rich:column label="Clé1" width="80px" sortable="true" sortBy="#{table.trfRepartitionCle1}" >
                                    <f:facet name="header"><h:outputText  value="Clé1"/></f:facet>
                                    <h:outputText value="#{table.trfRepartitionCle1}" />
                                </rich:column>
                                <rich:column label="Clé2" width="80px" sortable="true" sortBy="#{table.trfRepartitionCle2}" >
                                    <f:facet name="header"><h:outputText  value="Clé2"/></f:facet>
                                    <h:outputText value="#{table.trfRepartitionCle2}" />
                                </rich:column>
                                <rich:column label="Activité commerciale" width="80px" >
                                    <f:facet name="header"><h:outputText  value="Activite" /></f:facet>
                                    <h:outputText  value="#{table.trfActivite}"/>
                                </rich:column>
                                <rich:column label="Site" width="80px" sortable="true" sortBy="#{table.trfSite}" >
                                    <f:facet name="header"><h:outputText  value="Site"/></f:facet>
                                    <h:outputText value="#{table.trfSite}" />
                                </rich:column>
                                <rich:column label="Département" width="80px" sortable="true" sortBy="#{table.trfDepartement}" >
                                    <f:facet name="header"><h:outputText  value="Dépt."/></f:facet>
                                    <h:outputText value="#{table.trfDepartement}"/>
                                </rich:column>
                                <rich:column label="Service" width="80px" sortable="true" sortBy="#{table.trfService}" >
                                    <f:facet name="header"><h:outputText  value="Service"/></f:facet>
                                    <h:outputText value="#{table.trfService}"  />
                                </rich:column>
                                <rich:column label="Région" width="80px" sortable="true" sortBy="#{table.trfRegion}" >
                                    <f:facet name="header"><h:outputText  value="Région"/></f:facet>
                                    <h:outputText value="#{table.trfRegion}"  />
                                </rich:column>
                                <rich:column label="Secteur" width="80px" sortable="true" sortBy="#{table.trfSecteur}" >
                                    <f:facet name="header"><h:outputText  value="Secteur"/></f:facet>
                                    <h:outputText value="#{table.trfSecteur}" />
                                </rich:column>
                                <rich:column label="Point de vente" width="80px" sortable="true" sortBy="#{table.trfPdv}" >
                                    <f:facet name="header"><h:outputText  value="PDV" /></f:facet>
                                    <h:outputText value="#{table.trfPdv}"/>
                                </rich:column>
                                <rich:column label="Parc" width="80px" sortBy="#{table.trfParc}">
                                    <f:facet name="header"><h:outputText  value="Parc"/></f:facet>
                                    <h:outputText value="#{table.trfParc}"  />
                                </rich:column>
                                <rich:column label="Dossier" width="80px" sortBy="#{table.trfDossier}">
                                    <f:facet name="header"><h:outputText  value="Dossier" /></f:facet>
                                    <h:outputText value="#{table.trfDossier}"  />
                                </rich:column>
                                <rich:column label="Budget" width="80px" sortable="true" sortBy="#{table.trfBudget}" >
                                    <f:facet name="header"><h:outputText  value="Budget" /></f:facet>
                                    <h:outputText  value="#{table.trfBudget}"/>
                                </rich:column>
                                <rich:column label="Type importation" width="80px" sortable="true" sortBy="#{table.trfTypeImport}" >
                                    <f:facet name="header"><h:outputText  value="Type" /></f:facet>
                                    <h:outputText  value="#{table.trfTypeImport}"/>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </div>
                </rich:tab>

            </rich:tabPanel>

        </rich:panel>
        <br>
        <h:panelGrid styleClass="recherche" id="idTotal"  width="100%" columns="4">
            <h:panelGroup>
                <h:outputText value="Total Debit:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.totalDeb}" style="text-align:right;">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:outputText>
            </h:panelGroup>
            <h:panelGroup>
                <h:outputText value="Total Credit:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.totalCred}" style="text-align:right;">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:outputText>
            </h:panelGroup>
            <h:panelGroup>
                <h:outputText value="Ecart:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.ecart}" style="text-align:right;">
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:outputText>
            </h:panelGroup>
            <h:panelGroup>
                <h:outputText value="Nb lignes:"/>&nbsp;&nbsp;&nbsp;
                <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.nbligne}" style="text-align:right;">
                    <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="0" maxFractionDigits="0"/>
                </h:outputText>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>


    <rich:modalPanel domElementAttachment="parent"  id="panelImp" headerClass="headerPanel" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="600" height="400" autosized="true" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.showModalPanelPrint}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.showModalPanelPrint}" var="prt">
            <f:facet name="header"><h:outputText value="Impression" style="color:white;"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.closeImpression}" image="/images/close.gif" styleClass="hidelink" reRender="panelImp" id="hideImp"/>
                    <rich:componentControl for="panelImp" attachTo="hideImp" operation="hide" event="onclick"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalImp" target="_blank">
                <center>
                    <h:outputText value="Choisissez un modèle, un format d'impression"  style="color:green;"/>
                    <br><br>
                </center>
                <h:panelGrid width="100%">
                    <h:panelGrid  width="100%" style="border:solid 1px green;">
                        <f:facet name="header"><h:outputText value="Modèle"/></f:facet>
                        <br>
                        <h:selectOneMenu id="idModele" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.nomRapport}">
                            <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.lesModelsimpression}"/>
                        </h:selectOneMenu>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%" style="border:solid 1px green;background-color:white;">
                        <f:facet name="header"><h:outputText value="Format"/></f:facet>
                        <br>
                        <h:panelGrid  width="100%" columns="9" style="height:80px">
                            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.imprimanteReseau}">
                                <center>
                                    <h:commandButton image="/images/imp_print.png" onmouseover="this.src='images/imp_print_big.png'" onmouseout="this.src='images/imp_print.png'" value="PRT" title="Impression directe (Imprimantes serveur)" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.imprimerPRT}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                                    <h:selectOneMenu id="impSelect" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.monImprimante}">
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.utilPrint.mesImprimantesServeurItems}"/>
                                    </h:selectOneMenu>
                                </center>
                            </h:panelGroup>
                            <h:commandButton image="/images/imp_apercu.png" onmouseover="this.src='images/imp_apercu_big.png'" onmouseout="this.src='images/imp_apercu.png'" value="JRV" title="Aperçu avant impression" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.imprimerJRV}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_reader.png" onmouseover="this.src='images/imp_reader_big.png'" onmouseout="this.src='images/imp_reader.png'" value="PDF" title="Format PDF" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.imprimerPDF}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_openOffice.png" onmouseover="this.src='images/imp_openOffice_big.png'" onmouseout="this.src='images/imp_openOffice.png'" value="ODT" title="Format OpenOffice" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.imprimerODT}"onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_excel.png" onmouseover="this.src='images/imp_excel_big.png'" onmouseout="this.src='images/imp_excel.png'" value="XLS" title="Tableur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.imprimerXLS}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_word.png" onmouseover="this.src='images/imp_word_big.png'" onmouseout="this.src='images/imp_word.png'" value="DOC" title="Traitement de texte" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.imprimerDOC}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_html.png" onmouseover="this.src='images/imp_html_big.png'" onmouseout="this.src='images/imp_html.png'" value="HTML" title="Export HTML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.imprimerHTML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_xml.png" onmouseover="this.src='images/imp_xml_big.png'" onmouseout="this.src='images/imp_xml.png'" value="XML" title="Export XML" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.imprimerXML}" onclick="javascript:Richfaces.showModalPanel('modAttenteImp');"/>
                            <h:commandButton image="/images/imp_mail.png" onmouseover="this.src='images/imp_mail_big.png'" onmouseout="this.src='images/imp_mail.png'" value="MAIL" title="Envoie MAIL" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.envoieMAIL}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>
                    <h:panelGrid  width="100%"  id="panelMail" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.affMail}">
                        <h:panelGrid  width="100%"  style="border:solid 1px black;background-color:white;" columns="2" columnClasses="clos20,clos80">
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Emetteur:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="idemetteur" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.impEmetteur}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.utilPrint.lesbalEmetteursItems}"/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column><h:outputText value="Destinataire:" style="text-decoration:underline;"/></h:column>
                            <h:column>
                                <h:selectOneMenu id="iddestinataire" style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.impDestinataire}" >
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.utilPrint.lesbalDestinatairesItems}"/>
                                    <f:selectItem itemLabel="" itemValue=""/>
                                </h:selectOneMenu >
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column><h:outputText value="Copie à (CC):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.impDestinataireCC}"/></h:column>
                            <h:column><h:outputText value="Copie cachée (CCI):"/></h:column>
                            <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.impDestinataireCCI}"/></h:column>
                        </h:panelGrid>
                        <h:panelGrid  width="100%" style="text-align:center;">
                            <h:commandButton image="/images/mail_envoie.png" title="Envoyer mail" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.imprimerMAIL}" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.affMail}" id="print" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:panelGrid>
                    </h:panelGrid>
                </h:panelGrid>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent"   headerClass="headerPanel"id="modalPanelExport" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="400" height="500">
        <f:facet name="header"><h:outputText value="EXPORTATION"/></f:facet>
        <f:facet name="controls">
            <h:panelGroup>
                <h:graphicImage value="/images/close.gif" styleClass="hidelink" id="hidelinkExport"/>
                <rich:componentControl for="modalPanelExport" attachTo="hidelinkExport" operation="hide" event="onclick"/>
            </h:panelGroup>
        </f:facet>
        <a4j:form id="formModalPExport">
            <center>
                <h:panelGrid>
                    <h:selectOneRadio layout="pageDirection" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.formatExport}" >
                        <f:selectItem itemLabel="Format Texte" itemValue="0"/>
                        <f:selectItem itemLabel="Format MAESTRIA" itemValue="1" itemDisabled="true"/>
                        <f:selectItem itemLabel="Format SAGE V 11" itemValue="2"/>
                        <f:selectItem itemLabel="Format SAGE V 16" itemValue="3"/>
                        <f:selectItem itemLabel="Format SAGE V I7" itemValue="4"/>
                        <f:selectItem itemLabel="Format SAGE V I8" itemValue="5"/>
                        <f:selectItem itemLabel="Format SAGE PNM" itemValue="6"/>
                        <f:selectItem itemLabel="Format SATTI" itemValue="7" itemDisabled="true"/>
                        <f:selectItem itemLabel="Format S2R" itemValue="8"/>
                        <f:selectItem itemLabel="Format GIN" itemValue="9"/>
                        <f:selectItem itemLabel="Format CIEL" itemValue="10" itemDisabled="true"/>
                        <f:selectItem itemLabel="Format XML" itemValue="11"/>
                        <f:selectItem itemLabel="Format XLS" itemValue="12"/>
                    </h:selectOneRadio>
                </h:panelGrid>
                <br>
                <h:panelGroup id="ppgrp">
                    <center>
                        <h:outputText value="Etape 1: validez le choix d'exportation."/>&nbsp;&nbsp;&nbsp;
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exportCompta}"  onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,ppgrp,idFichier"/>
                        <br>
                        <h:column id="idFichier" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.afficheFichierExport}">
                            <h:outputText value="Etape 2: télécharger le fichier d'exportation."/>&nbsp;&nbsp;&nbsp;
                            <a type="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.fichierMine}" href="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.fichierUrl}" download="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.nomFichier}" title="Télécharger document"><img src="images/download.png" alt="télécharger"></a>
                            <br><br>
                            <h:outputText value="Etape 3: mettez les information d'exportation à jour."/>&nbsp;&nbsp;&nbsp;
                            <h:commandButton image="/images/transferer.png" title="Mise à jour des enregistrements" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.exportComptaSuite}" onclick="javascript:Richfaces.showModalPanel('modAttente');"/>
                        </h:column>
                    </center>
                </h:panelGroup>
            </center>
        </a4j:form>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="modalPanelMofif" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="350" height="200" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.showModalPanelModif}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.showModalPanelModif}" var="mdf">
            <f:facet name="header"><h:outputText value="MODIFICATION COMPTE"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.annuleModifLigne}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelMofif"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalPModif">
                <center>
                    <br><br>
                    <h:panelGrid width="100%" columns="2">
                        <h:column><h:outputText value="N° Compte:" styleClass="textAligneOutTable"/></h:column>
                        <h:column>
                            <h:inputText id="idCompte" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfCompte}" size="10">
                                <rich:toolTip id="tooladd" followMouse="true" direction="top-right" showDelay="1000" value="Saisissez le début d'un numéro de compte ou d'un libellé de compte" style="background-color:#FFF8D4;"/>
                                <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.recherchePlanComptableErreur}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="idSubView,panCtrl,pgrd1,panelListePlanComptable,formModalListePlanComptable,idCompte"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Appliquer partout:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.changerPartout}"/></h:column>
                    </h:panelGrid>
                    <br>
                    <h:panelGroup id="ppgrp">
                        <center>
                            <h:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.miseajourLigne}" onclick="javascript:Richfaces.showModalPanel('modAttente')"/>
                        </center>
                    </h:panelGroup>
                </center>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="modalPanelAnalytique" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);" width="800" height="450" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.showModalPanelAnalytique}">
        <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.showModalPanelAnalytique}" var="anal">
            <f:facet name="header"><h:outputText value="MODIFICATION ANALYTIQUE"/></f:facet>
            <f:facet name="controls">
                <a4j:form>
                    <a4j:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.annuleModifAnal}" image="/images/close.gif" styleClass="hidelink" reRender="modalPanelAnalytique"/>
                </a4j:form>
            </f:facet>
            <a4j:form id="formModalPAnal">
                <rich:tabPanel switchType="client" immediate="true" id="idPan2" style="border:0px;background-color:white;">
                    <rich:tab id="idImputActivite" label="Axes Activités" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.decoupageActivite}">
                        <a4j:region renderRegionOnly="false">
                            <rich:extendedDataTable id="idTableAnal" border="0" enableContextMenu="false" activeClass="active-row" noDataLabel=" " footerClass="bard" headerClass="headerTab" rowClasses="rows1,rows2,rowsd" width="100%" height="300px" style="border: solid 1px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.dataModelDecoupageActivtes}" var="saisieAnal">
                                <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.selectionAnalytique}"/>
                                <rich:column label="Activité" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.decoupageActivite}">
                                    <f:facet name="header"><h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib1}" /></f:facet>
                                    <h:selectOneMenu value="#{saisieAnal.zoneActivite}">
                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.laColonne1Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.valideColonne1}" />
                                    </h:selectOneMenu>
                                </rich:column>
                                <rich:column label="Analytique1" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.decoupageActivite}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib2}" /></f:facet>
                                    <h:selectOneMenu value="#{saisieAnal.zoneAnal1}">
                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.laColonne2Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.valideColonne2}" />
                                    </h:selectOneMenu>
                                </rich:column>
                                <rich:column label="Analytique3" width="25%" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.decoupageActivite}">
                                    <f:facet name="header"><h:outputText  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strLib3}" /></f:facet>
                                    <h:selectOneMenu value="#{saisieAnal.zoneAnal3}">
                                        <f:selectItem itemLabel="Sélectionnez un élément" itemValue=""/>
                                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.laColonne3Items}"/>
                                        <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.valideColonne3}" />
                                    </h:selectOneMenu>
                                </rich:column>
                                <rich:column label="pourcentage"  width="8%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="%" /></f:facet>
                                    <h:inputText value="#{saisieAnal.ecranaPourcentage}" style="text-align:right;width:90%;height:20px">
                                        <f:convertNumber groupingUsed="true" locale="FR" minFractionDigits="2" maxFractionDigits="2"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.calculPourcentage}" reRender="idRepartitionAnal,idTableAnal" focus="idRepartitionAnal"/>
                                    </h:inputText>
                                </rich:column>
                                <rich:column label="Montant"  width="15%" style="text-align:right;">
                                    <f:facet name="header"><h:outputText  value="Montant" /></f:facet>
                                    <h:inputText id="idRepartitionAnal" value="#{saisieAnal.ecranaMontantSaisie}" style="text-align:right;width:90%;height:20px">
                                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                        <a4j:support eventsQueue="maQueue" event="onblur" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.controleEcartAnalytique}" reRender="idTableAnal" />
                                    </h:inputText>
                                </rich:column>
                            </rich:extendedDataTable>
                        </a4j:region>
                    </rich:tab>
                    <rich:tab id="idImputAnalytique" label="Axes Analytiques">
                        <h:panelGrid columns="2" columnClasses="clos20,clos80" width="100%" id="idImputation">
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strSite}"><h:outputText value="Site:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strSite}">
                                <h:selectOneMenu id="idSite" style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfSite}">
                                    <f:selectItem itemLabel="Sélectonnez site" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesSitesItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.chargerDepartement}" reRender="panFiltre,idDepartement,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strSite}"><h:outputText value="Département:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strSite}">
                                <h:selectOneMenu id="idDepartement" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfDepartement}">
                                    <f:selectItem itemLabel="Sélectionnez département" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.mesDepartementsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.chargerService}" reRender="panFiltre,idService" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strSite}"><h:outputText value="Service:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strSite}">
                                <h:selectOneMenu id="idService" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfService}">
                                    <f:selectItem itemLabel="Sélectionnez service" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.mesServicesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRegion}"><h:outputText value="Région:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRegion}">
                                <h:selectOneMenu id="idRegion" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfRegion}">
                                    <f:selectItem itemLabel="Sélectionnez région" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesRegionsItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.chargerSecteur}" reRender="panFiltre,idSecteur,idPdv" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRegion}"><h:outputText value="Secteur:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRegion}">
                                <h:selectOneMenu id="idSecteur" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfSecteur}">
                                    <f:selectItem itemLabel="Sélectionnez secteur" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.mesSecteursItems}"/>
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.chargerPdv}" reRender="panFiltre,idPdv" />
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRegion}"><h:outputText value="Point de vente:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strRegion}">
                                <h:selectOneMenu id="idPdv" style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfPdv}">
                                    <f:selectItem itemLabel="Sélectionnez point de vente" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.mesPdvItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column></h:column>
                            <h:column></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.decoupageActivite==false}"><h:outputText value="Activité:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strActivite&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.decoupageActivite==false}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfActivite}">
                                    <f:selectItem itemLabel="Sélectionnez activité" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesActivitesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strDossier!=0}"><h:outputText value="Dossier:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strDossier!=0}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfDossier}">
                                    <f:selectItem itemLabel="Sélectionnez dossier" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesDossiersItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCles}"><h:outputText value="Clé 1 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCles}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfRepartitionCle1}">
                                    <f:selectItem itemLabel="Sélectionnez clé" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCles}"><h:outputText value="Clé 2 répartition:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strCles}">
                                <h:selectOneMenu style="width:100%;"value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfRepartitionCle2}">
                                    <f:selectItem itemLabel="Sélectionnez clé" itemValue="0"/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.mesClesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strParc}"><h:outputText value="Parc:" style="text-decoration:underline;"/></h:column>
                            <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strParc}">
                                <h:inputText id="idParc" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.transfertErreur.trfParc}">
                                    <a4j:support eventsQueue="maQueue" event="onchange" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.rechercheParc}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,idSubView,panelListeParc,formModalListeParc,idParc"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </rich:tab>
                </rich:tabPanel>
                <h:panelGroup id="ppgrpanal">
                    <center>
                        <a4j:commandButton image="/images/valider_big.png" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.miseajourAnal}" onclick="javascript:Richfaces.showModalPanel('modAttente')" oncomplete="javascript:Richfaces.hideModalPanel('modAttente')" reRender="modAttente,tableids,tableidsErreur,modalPanelAnalytique,panelBouton,panelBoutonErreur,idPanel"/>
                    </center>
                </h:panelGroup>
            </a4j:form>
        </c:if>
    </rich:modalPanel>


    <rich:modalPanel domElementAttachment="parent" headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_showBarProg}">
        <f:facet name="header"><h:outputText value="Traitement en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formTransfertCompta.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>


</f:subview>

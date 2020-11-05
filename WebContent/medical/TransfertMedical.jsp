<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="trfmedcial">

    <a4j:form>

        <center> <h2><h:outputText value="TRANSFERT DU MEDICAL EN COMPTABILITE" style="color:green;"/></h2></center>

        <h:panelGrid  columns="1" width="100%" id="panGene">
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.balance==0}" var="odpaye">
                <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
                    <h:panelGrid columns="11" width="100%">
                        <h:column><h:outputText value="Du:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.inpDu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="Au:"/></h:column>
                        <h:column><rich:calendar inputStyle="width:100px" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.inpAu}"  enableManualInput="true" datePattern="dd/MM/yyyy"  locale="fr" style=" background-color:white;" /></h:column>
                        <h:column><h:outputText value="De la pièce:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.inpPieceDeb}" size="10"/></h:column>
                        <h:column><h:outputText value="A la pièce:"/></h:column>
                        <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.inpPieceFin}" size="10"/></h:column>
                        <h:column><h:outputText value="Documents jamais transférés:"/></h:column>
                        <h:column><h:selectBooleanCheckbox value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.inpDocNonTrf}" /></h:column>
                        <h:column>
                            <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panGene,modAttente,scrollTable,table,panelBoutonTrf"/>
                            <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                        </h:column>
                    </h:panelGrid>
                </h:panelGrid>
                <br>
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.balance==1}" var="odmedical">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.datamodelDocument}" var="doc">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.selectionLigne}"/>
                        <rich:column label="Selection" sortable="true" sortBy="#{doc.docSelect}" width="5%">
                            <f:facet name="header" ><h:outputText  value="Sel." /></f:facet>
                            <h:selectBooleanCheckbox value="#{doc.docSelect}"/>
                        </rich:column>
                        <rich:column label="Nature document" sortable="true" sortBy="#{doc.var_lib_nat}" width="10%">
                            <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                            <h:outputText value="#{doc.var_lib_nat}"/>
                        </rich:column>
                        <rich:column label="N° document" sortable="true" sortBy="#{doc.docNum}" width="10%">
                            <f:facet name="header"><h:outputText  value="N°" /></f:facet>
                            <h:outputText value="#{doc.docNum}"/>
                        </rich:column>
                        <rich:column label="Série" sortable="true" sortBy="#{doc.docNum}" width="5%">
                            <f:facet name="header"><h:outputText  value="Série" /></f:facet>
                            <h:outputText value="#{doc.docSerie}"/>
                        </rich:column>
                        <rich:column label="Date" sortable="true" sortBy="#{doc.docDate}" width="10%">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{doc.docDate}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Compte Tiers" sortable="true" sortBy="#{doc.numComptetier}" width="10%">
                            <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                            <h:outputText value="#{doc.numComptetier}"/>
                        </rich:column>
                        <rich:column label="Nom du tiers" sortable="true" sortBy="#{doc.docNomTiers}" width="20%">
                            <f:facet name="header"><h:outputText  value="Tiers" /></f:facet>
                            <h:outputText value="#{doc.docNomTiers}"/>
                        </rich:column>
                        <rich:column label="Total HT" sortable="true" sortBy="#{doc.docTotHt}" width="10%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="H.T." /></f:facet>
                            <h:outputText value="#{doc.docTotHt}" rendered="#{doc.docTotHt!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Total TVA" sortable="true" sortBy="#{doc.docTotTva}" width="10%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="TVA" /></f:facet>
                            <h:outputText value="#{doc.docTotTva}" rendered="#{doc.docTotTva!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Total TTC" sortable="true" sortBy="#{doc.docTotTtc}" width="10%" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="T.T.C." /></f:facet>
                            <h:outputText value="#{doc.docTotTtc}" rendered="#{doc.docTotTtc!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.balance==2}" var="salarieePegase">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.pageIndex}" reRender="table2" id="scrollTable2" maxPages="20"align="left" for="table2"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_nb_max}" style="max-height:100%" styleClass="bg" id="table2" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.datamodelDocument}" var="doc">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.selectionLigne}"/>
                        <rich:column label="Selection" sortable="true" sortBy="#{doc.Select_agent}" width="5%">
                            <f:facet name="header" ><h:outputText  value="Sel." /></f:facet>
                            <h:selectBooleanCheckbox value="#{doc.Select_agent}"/>
                        </rich:column>
                        <rich:column label="Nature document" sortable="true" sortBy="#{doc.salMatricule}" width="10%">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{doc.salMatricule}"/>
                        </rich:column>
                        <rich:column label="N° document" sortable="true" sortBy="#{doc.salNom}" width="10%">
                            <f:facet name="header"><h:outputText  value="Nom et prénom" /></f:facet>
                            <h:outputText value="#{doc.salNom}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.balance==3}" var="salarieImport">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.pageIndex}" reRender="table3" id="scrollTable3" maxPages="20"align="left" for="table3"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_nb_max}" style="max-height:100%" styleClass="bg" id="table3" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.datamodelDocument}" var="doc">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.selectionLigne}"/>
                        <rich:column label="Matricule" sortable="true" sortBy="#{doc.trfColT01}">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{doc.trfColT01}" title="#{doc.trfColT01}"/>
                        </rich:column>
                        <rich:column label="Nom" sortable="true" sortBy="#{doc.trfColT02}">
                            <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                            <h:outputText value="#{doc.trfColT02}" title="#{doc.trfColT02}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{doc.trfColT03}">
                            <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                            <h:outputText value="#{doc.trfColT03}" title="#{doc.trfColT03}"/>
                        </rich:column>
                        <rich:column label="Genre" sortable="true" sortBy="#{doc.trfColT04}" width="50px">
                            <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                            <h:outputText value="#{doc.trfColT04}" title="#{doc.trfColT04}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" sortBy="#{doc.trfColT05}">
                            <f:facet name="header"><h:outputText  value="Date naissance" /></f:facet>
                            <h:outputText value="#{doc.trfColT05}" title="#{doc.trfColT05}"/>
                        </rich:column>
                        <rich:column label="Date naissance" sortable="true" sortBy="#{doc.trfColT06}">
                            <f:facet name="header"><h:outputText  value="Date embauche" /></f:facet>
                            <h:outputText value="#{doc.trfColT06}" title="#{doc.trfColT06}"/>
                        </rich:column>
                        <rich:column label="Date embauche" sortable="true" sortBy="#{doc.trfColT07}">
                            <f:facet name="header"><h:outputText  value="Nationnalité" /></f:facet>
                            <h:outputText value="#{doc.trfColT07}" title="#{doc.trfColT07}"/>
                        </rich:column>
                        <rich:column label="Nationnalité" sortable="true" sortBy="#{doc.trfColT08}">
                            <f:facet name="header"><h:outputText  value="Profession" /></f:facet>
                            <h:outputText value="#{doc.trfColT08}" title="#{doc.trfColT08}"/>
                        </rich:column>
                        <rich:column label="Fonction" sortable="true" sortBy="#{doc.trfColT09}" width="50px">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{doc.trfColT09}" title="#{doc.trfColT09}"/>
                        </rich:column>
                        <rich:column label="Adresse" sortable="true" sortBy="#{doc.trfColT10}">
                            <f:facet name="header"><h:outputText  value="Adressse" /></f:facet>
                            <h:outputText value="#{doc.trfColT10}" title="#{doc.trfColT10}"/>
                        </rich:column>
                        <rich:column label="Téléphne fixe" sortable="true" sortBy="#{doc.trfColT11}">
                            <f:facet name="header"><h:outputText  value="Tel.fixe" /></f:facet>
                            <h:outputText value="#{doc.trfColT11}" title="#{doc.trfColT11}"/>
                        </rich:column>
                        <rich:column label="Téphone mobile" sortable="true" sortBy="#{doc.trfColT12}">
                            <f:facet name="header"><h:outputText  value="Tel.Mob." /></f:facet>
                            <h:outputText value="#{doc.trfColT12}" title="#{doc.trfColT12}"/>
                        </rich:column>
                        <rich:column label="Mail" sortable="true" sortBy="#{doc.trfColT13}">
                            <f:facet name="header"><h:outputText  value="Mail" /></f:facet>
                            <h:outputText value="#{doc.trfColT13}" title="#{doc.trfColT13}"/>
                        </rich:column>
                        <rich:column label="Site" sortable="true" sortBy="#{doc.trfColT14}">
                            <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                            <h:outputText value="#{doc.trfColT14}" title="#{doc.trfColT14}"/>
                        </rich:column>
                        <rich:column label="Département" sortable="true" sortBy="#{doc.trfColT15}">
                            <f:facet name="header"><h:outputText  value="Département" /></f:facet>
                            <h:outputText value="#{doc.trfColT15}" title="#{doc.trfColT15}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{doc.trfColT16}">
                            <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                            <h:outputText value="#{doc.trfColT16}" title="#{doc.trfColT16}"/>
                        </rich:column>
                        <rich:column label="Equipe" sortable="true" sortBy="#{doc.trfColT17}">
                            <f:facet name="header"><h:outputText  value="Equipe" /></f:facet>
                            <h:outputText value="#{doc.trfColT17}" title="#{doc.trfColT17}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.balance==4}" var="salarieImport">
                <a4j:region renderRegionOnly="false">
                    <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.pageIndex}" reRender="table3" id="scrollTable3" maxPages="20"align="left" for="table3"/>
                    <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_nb_max}" style="max-height:100%" styleClass="bg" id="table3" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.datamodelDocument}" var="doc">
                        <a4j:support eventsQueue="maQueue"  event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.selectionLigne}"/>
                        <rich:column label="Matricule" sortable="true" sortBy="#{doc.trfColT01}">
                            <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                            <h:outputText value="#{doc.trfColT01}" title="#{doc.trfColT01}"/>
                        </rich:column>
                        <rich:column label="Nom" sortable="true" sortBy="#{doc.trfColT02}">
                            <f:facet name="header"><h:outputText  value="Nom" /></f:facet>
                            <h:outputText value="#{doc.trfColT02}" title="#{doc.trfColT02}"/>
                        </rich:column>
                        <rich:column label="Prénom" sortable="true" sortBy="#{doc.trfColT03}">
                            <f:facet name="header"><h:outputText  value="Prénom" /></f:facet>
                            <h:outputText value="#{doc.trfColT03}" title="#{doc.trfColT03}"/>
                        </rich:column>
                        <rich:column label="Genre" sortable="true" sortBy="#{doc.trfColT04}" width="50px">
                            <f:facet name="header"><h:outputText  value="Genre" /></f:facet>
                            <h:outputText value="#{doc.trfColT04}" title="#{doc.trfColT04}"/>
                        </rich:column>
                        <rich:column label="Etat" sortable="true" sortBy="#{doc.trfColT05}" width="50px">
                            <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                            <h:outputText value="#{doc.trfColT05}" title="#{doc.trfColT05}"/>
                        </rich:column>
                        <rich:column label="Date naissance" sortable="true" sortBy="#{doc.trfColT06}">
                            <f:facet name="header"><h:outputText  value="Date naissance" /></f:facet>
                            <h:outputText value="#{doc.trfColT06}" title="#{doc.trfColT06}"/>
                        </rich:column>
                        <rich:column label="Date embauche" sortable="true" sortBy="#{doc.trfColT07}">
                            <f:facet name="header"><h:outputText  value="Date enbauche" /></f:facet>
                            <h:outputText value="#{doc.trfColT07}" title="#{doc.trfColT07}"/>
                        </rich:column>
                        <rich:column label="Nationnalité" sortable="true" sortBy="#{doc.trfColT08}">
                            <f:facet name="header"><h:outputText  value="Nationnalité" /></f:facet>
                            <h:outputText value="#{doc.trfColT08}" title="#{doc.trfColT08}"/>
                        </rich:column>
                        <rich:column label="Fonction" sortable="true" sortBy="#{doc.trfColT09}">
                            <f:facet name="header"><h:outputText  value="Fonction" /></f:facet>
                            <h:outputText value="#{doc.trfColT09}" title="#{doc.trfColT09}"/>
                        </rich:column>
                        <rich:column label="Adresse" sortable="true" sortBy="#{doc.trfColT10}">
                            <f:facet name="header"><h:outputText  value="Adressse" /></f:facet>
                            <h:outputText value="#{doc.trfColT10}" title="#{doc.trfColT10}"/>
                        </rich:column>
                        <rich:column label="Téléphne fixe" sortable="true" sortBy="#{doc.trfColT11}">
                            <f:facet name="header"><h:outputText  value="Tel.fixe" /></f:facet>
                            <h:outputText value="#{doc.trfColT11}" title="#{doc.trfColT11}"/>
                        </rich:column>
                        <rich:column label="Téphone mobile" sortable="true" sortBy="#{doc.trfColT12}">
                            <f:facet name="header"><h:outputText  value="Tel.Mob." /></f:facet>
                            <h:outputText value="#{doc.trfColT12}" title="#{doc.trfColT12}"/>
                        </rich:column>
                        <rich:column label="Mail" sortable="true" sortBy="#{doc.trfColT13}">
                            <f:facet name="header"><h:outputText  value="Mail" /></f:facet>
                            <h:outputText value="#{doc.trfColT13}" title="#{doc.trfColT13}"/>
                        </rich:column>
                        <rich:column label="Site" sortable="true" sortBy="#{doc.trfColT14}">
                            <f:facet name="header"><h:outputText  value="Site" /></f:facet>
                            <h:outputText value="#{doc.trfColT14}" title="#{doc.trfColT14}"/>
                        </rich:column>
                        <rich:column label="Département" sortable="true" sortBy="#{doc.trfColT15}">
                            <f:facet name="header"><h:outputText  value="Département" /></f:facet>
                            <h:outputText value="#{doc.trfColT15}" title="#{doc.trfColT15}"/>
                        </rich:column>
                        <rich:column label="Service" sortable="true" sortBy="#{doc.trfColT16}">
                            <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                            <h:outputText value="#{doc.trfColT16}" title="#{doc.trfColT16}"/>
                        </rich:column>
                        <rich:column label="Equipe" sortable="true" sortBy="#{doc.trfColT17}">
                            <f:facet name="header"><h:outputText  value="Equipe" /></f:facet>
                            <h:outputText value="#{doc.trfColT17}" title="#{doc.trfColT17}"/>
                        </rich:column>
                        <rich:column label="Date départ congés" sortable="true" sortBy="#{doc.trfColT18}">
                            <f:facet name="header"><h:outputText  value="Dte Cp" /></f:facet>
                            <h:outputText value="#{doc.trfColT18}" title="#{doc.trfColT18}"/>
                        </rich:column>
                        <rich:column label="Date de retour congés" sortable="true" sortBy="#{doc.trfColT19}">
                            <f:facet name="header"><h:outputText  value="Dte Cp" /></f:facet>
                            <h:outputText value="#{doc.trfColT19}" title="#{doc.trfColT19}"/>
                        </rich:column>
                        <rich:column label="Numero CNSS" sortable="true" sortBy="#{doc.trfColT20}">
                            <f:facet name="header"><h:outputText  value="Numero CNSS" /></f:facet>
                            <h:outputText value="#{doc.trfColT20}" title="#{doc.trfColT20}"/>
                        </rich:column>
                    </rich:extendedDataTable>
                </a4j:region>
            </c:if>
            <br>
            <h:panelGroup id="panelBoutonTrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.var_affiche_bouton}">
                <center>
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.selectionAll}" value="Tout sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.balance==1}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.deSelectionAll}" value="Tout dé-sélectionner" onclick="javascript:Richfaces.showModalPanel('modAttente');" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.balance==1}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir transférer les éléments sélectionnés en médical ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.transfertPatient}" value="Transférer les patients" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.balance==3}"/>&nbsp;&nbsp;&nbsp;&nbsp;
                    <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir transférer les éléments sélectionnés en comptabilité ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertComptaMedical}" value="Transférer en comptabilité" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanMedical.formTransfertMedical.balance==1}"/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

    </a4j:form>

</f:subview>


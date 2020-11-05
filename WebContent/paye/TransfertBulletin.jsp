<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="trfbulletin">

    <a4j:form>

        <center> <h2><h:outputText value="TRANSFERT DES BULLETINS EN COMPTABILITE ou IMPORTATION DES ELEMENTS DE PAYE" style="color:green;"/></h2></center>

            <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px black;">
                
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==0}" var="odpaye">
                    <h:panelGrid id="panCtrl"  styleClass="recherche" width="100%">
                        <h:panelGrid columns="5" width="100%">
                            <h:column><h:outputText value="N° Feuille:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.numFeuille}" id="idFeuille" >
                                    <f:selectItem itemLabel="Toutes les feuilles" itemValue=""/>
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.lesFeuillesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column><h:outputText value="Période:"/></h:column>
                            <h:column>
                                <h:selectOneMenu value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.periode}" id="idPeriode">
                                    <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.lesPeriodesItems}"/>
                                </h:selectOneMenu>
                            </h:column>
                            <h:column>
                                <a4j:commandButton id="idValRecherche" value="RECHERCHER" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.executerRequete}" onclick="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="panGene,modAttente,scrollTable,table,panelBoutonTrf"/>
                                <rich:hotKey key="return"  handler="#{rich:element('idValRecherche')}.click()" />
                            </h:column>
                        </h:panelGrid>
                    </h:panelGrid>
                    <br>

                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.datamodelDocument}" var="doc">
                            <rich:column label="Selection" sortable="true" sortBy="#{doc.docSelect}" width="5%">
                                <f:facet name="header" ><h:outputText  value="Sel." /></f:facet>
                                <h:selectBooleanCheckbox value="#{doc.docSelect}" disabled="true"/>
                            </rich:column>
                            <rich:column label="Nature document" sortable="true" sortBy="#{doc.var_lib_nat}" width="10%">
                                <f:facet name="header"><h:outputText  value="Nature" /></f:facet>
                                <h:outputText value="#{doc.var_lib_nat}"/>
                            </rich:column>
                            <rich:column label="Matricule" sortable="true" sortBy="#{doc.docNum}" width="10%">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText value="#{doc.docNum}"/>
                            </rich:column>
                            <rich:column label="Feuille" sortable="true" sortBy="#{doc.docNum}" width="5%">
                                <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                                <h:outputText value="#{doc.docSerie}"/>
                            </rich:column>
                            <rich:column label="Date" sortable="true" sortBy="#{doc.docDate}" width="10%">
                                <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                                <h:outputText value="#{doc.docDate}">
                                    <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                                </h:outputText>
                            </rich:column>
                            <rich:column label="Compte Net à payer" sortable="true" sortBy="#{doc.numComptetier}" width="10%">
                                <f:facet name="header"><h:outputText  value="Compte" /></f:facet>
                                <h:outputText value="#{doc.numComptetier}"/>
                            </rich:column>
                            <rich:column label="Nom du Salarié" sortable="true" sortBy="#{doc.docNomTiers}" width="40%">
                                <f:facet name="header"><h:outputText  value="Salarié" /></f:facet>
                                <h:outputText value="#{doc.docNomTiers}"/>
                            </rich:column>
                            <rich:column label="Net à payer" sortable="true" sortBy="#{doc.docTotHt}" width="10%" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Net à payer" /></f:facet>
                                <h:outputText value="#{doc.docTotHt}" rendered="#{doc.docTotHt!=0}">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:outputText>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </c:if>

                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==1}" var="impvar">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="280%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.datamodelDocument}" var="doc">
                            <rich:column label="Nom feuille" sortable="true" sortBy="#{doc.trfNomFeuille}" width="100px">
                                <f:facet name="header"><h:outputText  value="Feuille" /></f:facet>
                                <h:outputText value="#{doc.trfNomFeuille}" title="#{doc.trfNomFeuille}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Période" sortable="true" sortBy="#{doc.trfPeriode}" width="80px">
                                <f:facet name="header"><h:outputText  value="Période" /></f:facet>
                                <h:outputText value="#{doc.trfPeriode}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Activite" sortable="true" sortBy="#{doc.trfColT00}" width="50px">
                                <f:facet name="header"><h:outputText  value="Activité" /></f:facet>
                                <h:outputText value="#{doc.trfColT00}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Service" sortable="true" sortBy="#{doc.trfColT01}" width="50px">
                                <f:facet name="header"><h:outputText  value="Service" /></f:facet>
                                <h:outputText value="#{doc.trfColT01}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Localisation" sortable="true" sortBy="#{doc.trfColT02}" width="50px">
                                <f:facet name="header"><h:outputText  value="Localisation" /></f:facet>
                                <h:outputText value="#{doc.trfColT02}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Matricule" sortable="true" sortBy="#{doc.trfColT03}" width="80px">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText value="#{doc.trfColT03}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Nom et Prénom" sortable="true" sortBy="#{doc.trfColT04}" width="200px">
                                <f:facet name="header"><h:outputText  value="Nom et Prénom" /></f:facet>
                                <h:outputText value="#{doc.trfColT04}" title="#{doc.trfColT04}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Etat" sortable="true" sortBy="#{doc.libelleEtat}" width="50px" style="text-align:center;">
                                <f:facet name="header"><h:outputText  value="Etat" /></f:facet>
                                <h:outputText value="#{doc.libelleEtat}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col01" sortable="true" sortBy="#{doc.trfColN06}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col01" /></f:facet>
                                <h:outputText value="#{doc.trfColT06}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN06}" rendered="#{doc.trfColN06!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col03" sortable="true" sortBy="#{doc.trfColN07}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col02" /></f:facet>
                                <h:outputText value="#{doc.trfColT07}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN07}" rendered="#{doc.trfColN07!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col04" sortable="true" sortBy="#{doc.trfColN08}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col03" /></f:facet>
                                <h:outputText value="#{doc.trfColT08}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN08}" rendered="#{doc.trfColN08!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col05" sortable="true" sortBy="#{doc.trfColN09}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col04" /></f:facet>
                                <h:outputText value="#{doc.trfColT09}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN09}" rendered="#{doc.trfColN09!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col06" sortable="true" sortBy="#{doc.trfColN10}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col05" /></f:facet>
                                <h:outputText value="#{doc.trfColT10}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN10}" rendered="#{doc.trfColN10!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col07" sortable="true" sortBy="#{doc.trfColN11}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col06" /></f:facet>
                                <h:outputText value="#{doc.trfColT11}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN11}" rendered="#{doc.trfColN11!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col08" sortable="true" sortBy="#{doc.trfColN12}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col07" /></f:facet>
                                <h:outputText value="#{doc.trfColT12}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN12}" rendered="#{doc.trfColN12!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col09" sortable="true" sortBy="#{doc.trfColN13}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col08" /></f:facet>
                                <h:outputText value="#{doc.trfColT13}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN13}" rendered="#{doc.trfColN13!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col10" sortable="true" sortBy="#{doc.trfColN14}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col09" /></f:facet>
                                <h:outputText value="#{doc.trfColT14}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN14}" rendered="#{doc.trfColN14!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col11" sortable="true" sortBy="#{doc.trfColN15}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col10" /></f:facet>
                                <h:outputText value="#{doc.trfColT15}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN15}" rendered="#{doc.trfColN15!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col12" sortable="true" sortBy="#{doc.trfColN16}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col11" /></f:facet>
                                <h:outputText value="#{doc.trfColT16}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN16}" rendered="#{doc.trfColN16!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col13" sortable="true" sortBy="#{doc.trfColN17}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col12" /></f:facet>
                                <h:outputText value="#{doc.trfColT17}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN17}" rendered="#{doc.trfColN17!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col14" sortable="true" sortBy="#{doc.trfColN18}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col13" /></f:facet>
                                <h:outputText value="#{doc.trfColT18}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN18}" rendered="#{doc.trfColN18!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col15" sortable="true" sortBy="#{doc.trfColN19}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col14" /></f:facet>
                                <h:outputText value="#{doc.trfColT19}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN19}" rendered="#{doc.trfColN19!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col16" sortable="true" sortBy="#{doc.trfColN20}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col15" /></f:facet>
                                <h:outputText value="#{doc.trfColT20}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN20}" rendered="#{doc.trfColN20!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col17" sortable="true" sortBy="#{doc.trfColN21}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col16" /></f:facet>
                                <h:outputText value="#{doc.trfColT21}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN21}" rendered="#{doc.trfColN21!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col18" sortable="true" sortBy="#{doc.trfColN22}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col17" /></f:facet>
                                <h:outputText value="#{doc.trfColT22}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN22}" rendered="#{doc.trfColN22!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col19" sortable="true" sortBy="#{doc.trfColN23}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col18" /></f:facet>
                                <h:outputText value="#{doc.trfColT23}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN23}" rendered="#{doc.trfColN23!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col20" sortable="true" sortBy="#{doc.trfColN24}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col19" /></f:facet>
                                <h:outputText value="#{doc.trfColT24}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN24}" rendered="#{doc.trfColN24!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Col20" sortable="true" sortBy="#{doc.trfColN25}" width="80px" style="text-align:right;">
                                <f:facet name="header"><h:outputText  value="Col20" /></f:facet>
                                <h:outputText value="#{doc.trfColT25}" style="#{doc.stylePolice}" rendered="#{doc.trfNomFeuille=='RUBRIQUE'}"/>
                                <h:outputText value="#{doc.trfColN25}" rendered="#{doc.trfColN25!=0}" style="#{doc.stylePolice}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </c:if>

                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==2}" var="erreurs">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.datamodelDocument}" var="doc">
                            <rich:column label="Description erreur" sortable="true" sortBy="#{doc.trfNomFeuille}" width="100%">
                                <f:facet name="header"><h:outputText  value="Erreur" /></f:facet>
                                <h:outputText value="#{doc.trfNomFeuille}" title="#{doc.trfNomFeuille}" style="#{doc.stylePolice}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </c:if>

                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==4}" var="impvar">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_nb_max}" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="280%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.datamodelDocument}" var="doc">
                            <rich:column label="Matricule" sortable="true" sortBy="#{doc.trfColT00}" width="100px">
                                <f:facet name="header"><h:outputText  value="Matricule" /></f:facet>
                                <h:outputText value="#{doc.trfColT00}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column label="Rubrique" sortable="true" sortBy="#{doc.trfColT01}" width="100px" style="text-align:right">
                                <f:facet name="header"><h:outputText  value="Rubrique" /></f:facet>
                                <h:outputText value="#{doc.trfColT01}" style="#{doc.stylePolice};text-align:right"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </c:if>

                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==6||bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==7}" var="impvar">
                    <a4j:region renderRegionOnly="false">
                        <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" page="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.pageIndex}" reRender="table" id="scrollTable" maxPages="20"align="left" for="table"/>
                        <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_nb_max}" enableContextMenu="false" style="max-height:100%" styleClass="bg" id="table" rowClasses="rows1,rows2,rowsd" footerClass="bard" headerClass="headerTab" activeClass="active-row" noDataLabel=" " border="0" width="300%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.datamodelDocument}" var="doc">
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT00}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT01}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT02}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT03}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT04}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT05}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT06}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT07}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT08}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT09}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT10}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT11}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT12}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT13}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT14}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT15}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT16}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT17}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT18}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT19}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT20}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT21}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT22}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT23}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT24}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT25}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT26}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT27}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT28}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT29}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT30}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT31}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT32}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT33}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT34}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT35}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT36}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT37}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT38}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT39}" style="#{doc.stylePolice}"/>
                            </rich:column>
                            <rich:column sortable="false">
                                <h:outputText value="#{doc.trfColT40}" style="#{doc.stylePolice}"/>
                            </rich:column>
                        </rich:extendedDataTable>
                    </a4j:region>
                </c:if>

            </div>

            <br>
            <h:panelGroup id="panelBoutonTrf" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                <center>
                    <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir transférer les éléments sélectionnés en comptabilité ?')) return false;javascript:Richfaces.showModalPanel('modAttente');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertComptaPaye}" value="Transférer en comptabilité" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==0}"/>
                    <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir transférer les éléments sélectionnés en paye ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertVariablePaye}" value="Transférer les variables" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==1}"/>
                    <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir importer la rubrique en paye ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertRubriquePaye}" value="Transférer les rubriques" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==4}"/>
                    <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir importer ces informations ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertImportLibre}" value="Import libre" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==6}"/>
                    <h:commandButton onclick="if (!confirm('Etes-vous sur de vouloir importer les pointages d`OMEGA ?')) return false;javascript:Richfaces.showModalPanel('panelBarProg');" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.transfertImportPointageOmega}" value="Import Pointage-OMEGA" style="color:white;background-color:green;margin:3px 3px 3px 3px;width:200px;" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_affiche_bouton&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.balance==7}"/>
                </center>
            </h:panelGroup>

    </a4j:form>

    <rich:modalPanel domElementAttachment="parent"  headerClass="headerPanel" id="panelBarProg" style="border:solid 1px black;background-color:white;border-radius:10px;box-shadow: 10px 10px 2px 1px rgba(0,0,0,0.5);"  width="700" height="80" showWhenRendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_showBarProgMaj}">
        <f:facet name="header"><h:outputText value="Traitement des utilitaires en cours..."/></f:facet>
        <center>
            <a4j:form >
                <br>
                <a4j:outputPanel id="progressPanel">
                    <rich:progressBar value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_currentValue}" style="width:90%" interval="300" enabled="true" minValue="-1" maxValue="100" id="barprg" mode="ajax" ajaxSingle="true" eventsQueue="maQueueProgress" limitToList="true" reRenderAfterComplete="panelBarProg,progressPanel">
                        <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_info} (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formTransfertBulletin.var_currentValue} %)"/>
                    </rich:progressBar>
                </a4j:outputPanel>
            </a4j:form>
        </center>
    </rich:modalPanel>

</f:subview>


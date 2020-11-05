
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="Rppsm">

    <a4j:form id="form1">

        <center> <h2><h:outputText value="RAPPROCHEMENT BANCAIRE ANTERIEUR" styleClass="titre"/></h2></center>

        <h:panelGrid  columns="2"  width="100%" >
            <h:panelGrid id="pnlgrdfrm" style="border:1px solid black;width:100%;background-color:#FFF8D4;height:85px;" >
                <h:panelGroup>
                    <h:outputText value="Journal:" style="font-weight:bold;"/> <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.journauxActif.pljCode} : #{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.journauxActif.pljLibelleFr} _ (#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.devise})" style = "margin-left:20;"/>
                </h:panelGroup>
                <h:panelGroup>
                    <h:outputText value="Période:" style="font-weight:bold;"/> <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.jrperiode_ante}" style = "margin-left:20;"/>
                </h:panelGroup>
                <h:panelGroup>
                    <h:commandButton value="FERMER L'ANTERIEUR"  action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.fermerLeJournalAnterieur}"  style="color:white;background-color:green;margin:3px 3px 3px 3px;width:180px;cursor:pointer;"  tabindex="0" styleClass="hidelink" id="hidelink9"/>&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton title="Ajouter ligne" image="/images/ajouter.png" styleClass="BoutonLnk" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.addligneAnte}" reRender="pgrsld,richpanlisteECR" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.add}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton title="Supprimer ligne" image="/images/supprimer.png"  styleClass="BoutonLnk" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.deleteAnterieur}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer la ligne sélectionnée?')) return false"  reRender="pgrsld,richpanlisteECR" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.sup}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <a4j:commandButton title="Regénérer les antérieurs à partir de N-1" image="/images/actualiser.png"  styleClass="BoutonLnk" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.regenererAnterieur}" onclick="if (!confirm('Etes-vous sur de vouloir regénérer les antérieurs avec le mois antérieur?')) return false"  reRender="pgrsld,richpanlisteECR,tableids" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.menucompta.maj}"/>
                </h:panelGroup>
            </h:panelGrid>
            <h:panelGrid  id="pgrsld"  columns="3" style="border:1px solid green;width:100%;background-color:#FFF8D4;height:85px;">
                <h:column id="tDebit">
                    <h:column><h:outputText value="Total débit:" style="font-weight:bold;"/></h:column>&nbsp;&nbsp;
                    <h:column>
                        <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.totalMvtsdebit}"  style="text-align:right;" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:column>
                <h:column id="tCredit">
                    <h:column><h:outputText value="Total crédit:" style="font-weight:bold;"/></h:column>&nbsp;&nbsp;
                    <h:column>
                        <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.totalMvtscredit}" style="text-align:right;" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:column>
               <h:column id="tVide"></h:column>
                <h:column  id="sFinal">
                    <h:column><h:outputText value="Solde:" style="font-weight:bold;"/></h:column>&nbsp;&nbsp;
                    <h:column>
                        <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.soldeAnterieur}" style="text-align:right;" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:column>
                <h:column  id="sRelAnt">
                    <h:column><h:outputText value="Solde Relevé:" style="font-weight:bold;"/></h:column>&nbsp;&nbsp;
                    <h:column>
                        <h:inputText size="12" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.releveAnte}" style="text-align:right;">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:column>
                <h:column id="tVide2"></h:column>
            </h:panelGrid>
        </h:panelGrid>
        <br>
        <rich:panel style="border:0px;width:100%;text-align:center;" id="richpanlisteECR">
            <h:panelGrid columns="7" id="pgrdsaisie" styleClass="recherche"  width="100%" >
                <h:panelGroup id="pgpNP">
                    <h:outputText value="N° de pièce:"/><br>
                    <h:inputText tabindex="1" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantPiece}" size="14" id="ecrPieceid" maxlength="20"/>
                </h:panelGroup>
                <h:panelGroup id="pgpref" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.testRef1Piece}">
                    <h:outputText value="Référence1:"/><br>
                    <h:inputText tabindex="2" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantReference1}" size="13" maxlength="30"/>
                </h:panelGroup>
                <h:panelGroup id="pgpref2" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.testRef2Piece}">
                    <h:outputText value="Référence2:"/><br>
                    <h:inputText tabindex="3" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantReference2}" size="13" maxlength="30"/>
                </h:panelGroup>
                <h:panelGroup id="pgpdeb">
                    <h:outputText value="Débit:"/><br>
                    <h:inputText tabindex="4" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantDebitSaisie}" style="text-align:right" size="13" onkeypress="return scanToucheChiffre(event)">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="pgpcred">
                    <h:outputText value="Crédit:"/><br>
                    <h:inputText tabindex="5" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantCreditSaisie}"  style="text-align:right" size="14" onkeypress="return scanToucheChiffre(event)">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:panelGroup>
                <h:panelGroup id="pgplib">
                    <h:outputText value="Libellé:"/><br>
                    <h:inputText tabindex="6" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.ecrituresAnterieur.ecrantLibelle}" size="40" />
                </h:panelGroup>
                <h:panelGroup id="pngMaj" >
                    <h:commandButton tabindex="7"  image="/images/valider_big.png" styleClass="BoutonLnk" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.saveAnterieur}" />
                </h:panelGroup>
            </h:panelGrid>
            <br>
            <a4j:region renderRegionOnly="false">
                <rich:datascroller renderIfSinglePage="false" pageIndexVar="pageIndex" pagesVar="pages" id="scrollTable" maxPages="20"align="left" for="tableids"/>
                <rich:extendedDataTable rows="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.var_nb_max}" border="0" footerClass="bard" headerClass="headerTab" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.datamodelAnte}" var="ante" id="tableids" activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" style="max-height:100%;text-align:left;border:solid 1px" align="center">
                    <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.formRapprochement.selectionAnte}" reRender="pgrdsaisie"/>
                    <rich:column sortable="true">
                        <f:facet name="header"><h:outputText value="Date" /></f:facet>
                        <h:outputText value="#{ante.ecrantDate}">
                            <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true">
                        <f:facet name="header"><h:outputText value="N° de pièce" /></f:facet>
                        <h:outputText value="#{ante.ecrantPiece}" />
                    </rich:column>
                    <rich:column sortable="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.testRef1Piece}">
                        <f:facet name="header"><h:outputText  value="Référence1"/></f:facet>
                        <h:outputText value="#{ante.ecrantReference1}"/>
                    </rich:column>
                    <rich:column sortable="true" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanComptabilite.optionComptabilite.testRef2Piece}">
                        <f:facet name="header"><h:outputText value="Référence2"/></f:facet>
                        <h:outputText value="#{ante.ecrantReference2}"/>
                    </rich:column>
                    <rich:column sortable="true" style="text-align:right;">
                        <f:facet name="header"><h:outputText value="Débit" /></f:facet>
                        <h:outputText   value="#{ante.ecrantDebitSaisie}" rendered="#{ante.ecrantDebitSaisie!=0}" >
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true" style="text-align:right;">
                        <f:facet name="header"><h:outputText value="Crédit" /></f:facet>
                        <h:outputText value="#{ante.ecrantCreditSaisie}" rendered="#{ante.ecrantCreditSaisie!=0}">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:outputText>
                    </rich:column>
                    <rich:column sortable="true">
                        <f:facet name="header"><h:outputText value="Rapproché" /></f:facet>
                        <h:outputText value="#{ante.ecrantRapprochement}" />
                    </rich:column>
                    <rich:column sortable="true" width="340px" >
                        <f:facet name="header"><h:outputText value="Libellé" /></f:facet>
                        <h:outputText value="#{ante.ecrantLibelle}" style="width:100px;"/>
                    </rich:column>
                </rich:extendedDataTable>
            </a4j:region>
        </rich:panel>
    </a4j:form>

</f:subview>


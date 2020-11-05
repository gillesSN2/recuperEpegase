<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid style="width:100%;" id="panMonepargne">

    <a4j:form>

        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay==2}">
            <center><h2><h:outputText value="MON EPARGNE (#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPatronyme})" style="color:green;" /></h2></center>
        </h:column>

        <h:panelGrid id="panCapitalisation" width="100%">
            <jsp:include flush="true" page="/paye/PretCommun.jsp" />
            <h:panelGroup>
                <h:panelGrid width="150px" id="panelBoutonCapitalisation" columns="3" style="height:34px" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay!=2&&bakingbeanepegase.menuModuleHorizontalCtrl.rw}">
                    <a4j:commandButton title="Ajouter une nouvelle capitalisation" image="/images/ajouter.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesCapitalisation.salcapId==0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_ajt}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.ajouterCapitalisation}" reRender="panCapitalisation,panelCapitalisation,idlisteCapitalisation"/>
                    <a4j:commandButton title="Modifier la capitalisation" image="/images/modifier.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesCapitalisation.salcapId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_mod}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.modifierCapitalisation}" reRender="panCapitalisation,panelCapitalisation,idlisteCapitalisation"/>
                    <a4j:commandButton title="Supprimer la capitalisation" image="/images/supprimer.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesCapitalisation.salcapId!=0&&bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.var_sup}" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.supprimerCapitalisation}" onclick="if (!confirm('Etes-vous sur de vouloir supprimer cet élément?')) return false" reRender="panelBoutonCapitalisation,panelCapitalisation,tableCapitalisation,panCapitalisation,idlisteCapitalisation"/>
                </h:panelGrid>
                <h:panelGrid width="100%" columns="6" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesCapitalisation.salcapId!=0}">
                    <h:column><h:outputText value="Montant initial:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesCapitalisation.salcapInitial}" size="5" style="text-align:right" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                    <h:column><h:outputText value="Montant Versement:"/></h:column>
                    <h:column>
                        <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesCapitalisation.salcapMontant}" size="5" style="text-align:right" readonly="true">
                            <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                        </h:inputText>
                    </h:column>
                </h:panelGrid>
            </h:panelGroup>
            <h:panelGroup id="idlisteCapitalisation" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.salariesCapitalisation.salcapId!=0}">
                <a4j:region renderRegionOnly="false">
                    <rich:extendedDataTable border="0" enableContextMenu="false" id="tableCapitalisation" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="100%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.dataModelCapitalisation}" var="cap">
                        <rich:column label="Date opération (JJ/MM/AAAA)" sortable="false" width="100px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Date" /></f:facet>
                            <h:outputText value="#{cap.bulletinSalaire.bulsalDateDebut}">
                                <f:convertDateTime pattern="dd/MM/yy" locale="fr" />
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant versement" sortable="false" width="120px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Versements" /></f:facet>
                            <h:outputText value="#{cap.recette}" rendered="#{cap.recette!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                        <rich:column label="Montant retrait" sortable="false" width="120px" style="text-align:right;">
                            <f:facet name="header"><h:outputText  value="Retraits" /></f:facet>
                            <h:outputText value="#{cap.depense}" rendered="#{cap.depense!=0}">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:outputText>
                        </rich:column>
                    </rich:extendedDataTable>
                    <h:panelGrid columns="6" width="100%" id="idTotalCapitalisation" style="height:35px">
                        <h:column><h:outputText value="Total versement:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.total_versement}" readonly="true" style="width:100px;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Total retrait:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.total_retrait}" readonly="true" style="width:100px;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                        <h:column><h:outputText value="Solde:"/></h:column>
                        <h:column>
                            <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.solde_capitalisation}" readonly="true" style="width:100px;text-align:right;">
                                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                            </h:inputText>
                        </h:column>
                    </h:panelGrid>
                </a4j:region>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</h:panelGrid>


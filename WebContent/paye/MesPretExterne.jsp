<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid style="width:100%;" id="panPreExterne">

    <a4j:form>

        <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.groupe.grpModulePay==2}">
            <center><h2><h:outputText value="MES PRETS EXTERNES (#{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPatronyme})" style="color:green;" /></h2></center>
        </h:column>

        <jsp:include flush="true" page="/paye/PretCommun.jsp" />
        <br>
        <h:panelGrid id="panPretExt" width="100%" columns="2" columnClasses="clos50d,clos50g">
            <h:panelGroup>
                <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tablePretsExternes" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="230%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.dataModelPrets}" var="prInt">
                            <a4j:support eventsQueue="maQueue" event="onRowClick" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.selectionPret}" onsubmit="javascript:Richfaces.showModalPanel('modAttente');" oncomplete="javascript:Richfaces.hideModalPanel('modAttente');" reRender="modAttente,panelBoutonPretsExternes,tablePretsExternesLignes,idTotalExterne,panelBoutonPretsExternesLignes"/>
                            <jsp:include flush="true" page="/paye/FicheSalariePretEnteteCommun.jsp"/>
                        </rich:extendedDataTable>
                        <br>
                        <h:panelGroup>
                            <center>
                                <h:outputText value="LEGENDE DES COULEURS:"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Prêts non soldés" style="color:red;"/>&nbsp;&nbsp;&nbsp;
                                <h:outputText value="Prêts soldés" style="color:black"/>
                            </center>
                        </h:panelGroup>
                        <br>
                    </a4j:region>
                </div>
            </h:panelGroup>
            <h:panelGroup>
                <div style="overflow:scroll;max-height:100%;width:100%;border:solid 0px green;">
                    <a4j:region renderRegionOnly="false">
                        <rich:extendedDataTable border="0" enableContextMenu="false" id="tablePretsExternesLignes" headerClass="headerTab"  activeClass="active-row" noDataLabel=" " rowClasses="rows1,rows2,rowsd" footerClass="bard" width="150%" styleClass="bg" style="max-height:100%;border:solid 0px green;text-align:left;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.dataModelPretsLignes}" var="prLig1">
                            <jsp:include flush="true" page="/paye/FicheSalariePretLigneCommun.jsp"/>
                        </rich:extendedDataTable>
                        <h:panelGrid columns="6" width="100%" id="idTotalExterne" style="height:45px">
                            <h:column><h:outputText value="Total prêt:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.total_pret}" readonly="true" style="width:100px;text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Total remboursé:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.total_rmb}" readonly="true" style="width:100px;text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                            <h:column><h:outputText value="Reste dû:"/></h:column>
                            <h:column>
                                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formPrets.solde_pret}" readonly="true" style="width:100px;text-align:right;">
                                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                                </h:inputText>
                            </h:column>
                        </h:panelGrid>
                    </a4j:region>
                </div>
            </h:panelGroup>
        </h:panelGrid>
    </a4j:form>

</h:panelGrid>


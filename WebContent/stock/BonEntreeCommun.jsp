<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<h:panelGrid style="background-color:#DAEECB;" width="100%">
    <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
        <h:panelGrid width="100%" style="background-color:#DAEECB;height:80px">
            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.bonEntreeEntete.binDate}" readonly="true"/></h:column>
                <h:column><h:outputText value="N°:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.bonEntreeEntete.binNum}" readonly="true"/></h:column>
                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.bonEntreeEntete.binSerie}" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Dépôt:" style="text-decoration:underline;width:100%"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.bonEntreeEntete.binDepot}" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesDepotAchItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.bonEntreeEntete.binNomResponsable}" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesResponsablesItems}" />
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Objet:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.bonEntreeEntete.binObject}" readonly="true" /></h:column>
            </h:panelGrid>
        </h:panelGrid>
        <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80">
            <h:column><h:outputText value="Valorisation:"/></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formBonEntree.bonEntreeEntete.binTotPump}" style="text-align:right;width:100%"  readonly="true" >
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:column>
        </h:panelGrid>
    </h:panelGrid>
</h:panelGrid>

<br>

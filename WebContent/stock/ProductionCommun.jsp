<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<h:panelGrid style="background-color:#DAEECB;" width="100%">
    <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
        <h:panelGrid width="100%" style="background-color:#DAEECB;height:80px">
            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabDate}" readonly="true"/></h:column>
                <h:column><h:outputText value="N°:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabNum}" readonly="true"/></h:column>
                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabSerie}" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Process:" style="text-decoration:underline;width:100%"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.var_process}" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesProcessItems}"/>
                    </h:selectOneMenu>
                </h:column>
                <h:column><h:outputText value="Quart production:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabQuart}" disabled="true"/></h:column>
                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabNomResponsable}" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesResponsablesItems}" />
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
        </h:panelGrid>
        <h:panelGrid width="100%" style="background-color:#DAEECB;height:110px" columns="2" columnClasses="clos20,clos80" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.affichagePump}">
            <h:column><h:outputText value="Valorisation:"/></h:column>
            <h:column>
                <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.fabricationEnteteAchats.fabTotPump}" style="text-align:right;width:100%"  readonly="true" >
                    <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                </h:inputText>
            </h:column>
        </h:panelGrid>
    </h:panelGrid>
</h:panelGrid>

<br>

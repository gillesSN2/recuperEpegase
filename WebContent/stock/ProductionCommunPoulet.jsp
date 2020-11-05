<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<h:panelGrid style="background-color:#DAEECB;" width="100%">
    <h:panelGrid width="100%" columns="2" columnClasses="clos80,clos20">
        <h:panelGrid width="100%" style="background-color:#DAEECB;height:70px">
            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recDate}" disabled="true"/></h:column>
                <h:column><h:outputText value="N°:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recNum}" disabled="true"/></h:column>
                <h:column><h:outputText value="Série:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recSerie}" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesSerieUserItem}"/>
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Lot production:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recProduction}" disabled="true"/></h:column>
                <h:column><h:outputText value="Commentaire:" style="text-decoration:underline;width:100%"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recCommentaire}" disabled="true"/></h:column>
                <h:column><h:outputText value="Responsable:" style="text-decoration:underline;"/></h:column>
                <h:column>
                    <h:selectOneMenu style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formProduction.receptionEnteteAchats.recNomResponsable}" disabled="true">
                        <f:selectItems value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.mesResponsablesItems}" />
                    </h:selectOneMenu>
                </h:column>
            </h:panelGrid>
        </h:panelGrid>
    </h:panelGrid>
</h:panelGrid>

<br>

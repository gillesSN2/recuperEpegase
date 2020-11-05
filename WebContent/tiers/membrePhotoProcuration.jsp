<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="membrePhotoProcuration">

    <h:panelGrid  style="background-color:#DAEECB;" id="phot1" width="750px"columnClasses="cols" >

        <h:panelGrid id="panPhoto" columns="2" style="height:150px" width="100%" styleClass="top" headerClass="headerTab">
            <f:facet name="header"><h:outputText value="Photo"/></f:facet>
            <h:panelGroup rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conPhoto==null}">
                <t:inputFileUpload id="file" storage="file" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.uploadedFile}"/>
                <h:commandButton  styleClass="exp_lienmenu"value="Sauvegarder" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.ajoutPhotoProcuration}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}">
                    <a4j:support eventsQueue="maQueue"  immediate="true" reRender="grp3"/>
                </h:commandButton>
                <h:message for="file" infoStyle="color: green;" errorStyle="color: red;" />
            </h:panelGroup>
            <br/>
            <h:panelGroup  id="grp3" style="width:90px;height:90px;" >
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conPhoto!=null}">
                    <img alt="" src="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.urlIpProd}/epegase/imageServlet/${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.urlphotoProcuration}" width="100px" height="100px"/>&nbsp;
                    <h:commandButton image="/images/annuler.gif"title="supprimer photo" action="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.reInitPhotoProcuration}" disabled="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.var_action==3}"/>
                </c:if>
                <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanTiers.formTiers.contactsProcuration.conPhoto==null}">
                    <img alt="" src="images/no_image.jpeg" width="100px" height="100px" />
                </c:if>
            </h:panelGroup>
        </h:panelGrid>

    </h:panelGrid>

</f:subview>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<h:panelGrid styleClass="fichefournisseur" width="100%">
    <h:panelGrid  width="100%" columns="2" columnClasses="clos60g,clos40">
        <h:column>
            <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemDate}" readonly="true"/></h:column>
                <h:column><h:outputText value="N°:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemNum}" readonly="true"/></h:column>
                <h:column><h:outputText value="Série:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemSerie}" readonly="true"/></h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" columns="2" columnClasses="clos12d,clos88">
                <h:column><h:outputText value="Client:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemNomTiers}" readonly="true"/></h:column>
            </h:panelGrid>
        </h:column>
        <h:column>
            <h:panelGrid  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="Demandé:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTotDemande}" style="text-align:right;width:100%"  readonly="true" >
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Accordé:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTotAccorde}" style="text-align:right;width:100%" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Règlement:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.fondemTotReglement}" style="text-align:right;width:100%"  readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Solde:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanFondation.formDemandeFondation.fondationDemande.var_reliquat}" style="text-align:right;width:100%"  readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
            </h:panelGrid>
        </h:column>
    </h:panelGrid>
</h:panelGrid>

<br>

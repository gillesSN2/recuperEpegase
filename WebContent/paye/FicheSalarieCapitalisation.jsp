<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid style="width:100%;">
    <h:panelGrid columns="2" id="idCapitalisation" styleClass="fichefournisseur1" columnClasses="clos30,clos70" width="100%" >
        <h:column><h:outputText value="Contrat:"/></h:column>
        <h:column>
            <h:selectOneMenu style="width:200px;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesCapitalisation.salcapContrat}">
                <f:selectItems  value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.lesContratsActifsItems}"/>
            </h:selectOneMenu>
        </h:column>
        <h:column><h:outputText value="Montant Initial:"/></h:column>
        <h:column>
            <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesCapitalisation.salcapInitial}" style="text-align:right;">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:inputText>
        </h:column>
        <h:column><h:outputText value="Montant Versement:"/></h:column>
        <h:column>
            <h:inputText size="10" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salariesCapitalisation.salcapMontant}" style="text-align:right;">
                <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
            </h:inputText>
        </h:column>
    </h:panelGrid>
</h:panelGrid>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<h:panelGrid columns="4" styleClass="fichefournisseur" columnClasses="clos15,clos35,clos15,clos35" width="100%">
    <h:column><h:outputText style="border:0px;color:red;text-decoration:underline;" value="Nature:"/></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNature}:#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.lib_nature}" disabled="true"/></h:column>
    <h:column><h:outputText style="border:0px;color:red" value="Matricule:"/></h:column>
    <h:column>
        <h:inputText style="border:0px;color:red;width:70%;text-align:center" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salMatricule}" readonly="true"/>&nbsp;&nbsp;&nbsp;
        <h:graphicImage value="/images/cadenas_op.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salProtege==0}"/>
        <h:graphicImage value="/images/cadenas_cl.png" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salProtege==1}"/>
    </h:column>
    <h:column><h:outputText style="text-decoration:underline;" value="Civilité:"/></h:column>
    <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salCivilite}" disabled="true" /></h:column>
    <h:column><h:outputText value="Genre:"/></h:column>
    <h:column>
        <h:selectOneRadio value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salGenre}" disabled="true">
            <f:selectItem itemLabel="Femme" itemValue="0"/>
            <f:selectItem itemLabel="Homme" itemValue="1"/>
        </h:selectOneRadio>
    </h:column>
    <h:column><h:outputText value="Nom:"/></h:column>
    <h:column><h:inputText style="width:100%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salNom}" disabled="true"/></h:column>
    <h:column><h:outputText value="Prénom:"/></h:column>
    <h:column><h:inputText style="width:95%;" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanPaye.formFicheSalarie.salaries.salPrenom}" disabled="true"/></h:column>
</h:panelGrid>
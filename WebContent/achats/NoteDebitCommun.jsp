<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h:panelGrid styleClass="fichefournisseur" width="100%">
    <h:panelGrid  width="100%" columns="2" columnClasses="clos60g,clos40">
        <h:column>
            <h:panelGrid  width="100%" columns="6" columnClasses="clos12d,clos21g,clos12d,clos21g,clos12d,clos21g">
                <h:column><h:outputText value="Date:"/></h:column>
                <h:column><h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.noteDebitEnteteAchats.ndfDate}" readonly="true"/></h:column>
                <h:column><h:outputText value="N°:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.noteDebitEnteteAchats.ndfNum}" readonly="true"/></h:column>
                <h:column><h:outputText value="Série:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.noteDebitEnteteAchats.ndfSerie}" readonly="true"/></h:column>
            </h:panelGrid>
            <h:panelGrid width="100%" columns="2" columnClasses="clos12d,clos88">
                <h:column><h:outputText value="Fournisseur:"/></h:column>
                <h:column><h:inputText style="width:100%" value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.noteDebitEnteteAchats.ndfNomTiers}" readonly="true"/></h:column>
            </h:panelGrid>
        </h:column>
        <h:column>
            <h:panelGrid  width="100%" columns="4" columnClasses="clos15,clos35,clos15,clos35">
                <h:column><h:outputText value="H.T.:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.noteDebitEnteteAchats.ndfTotHt}" style="text-align:right;width:100%"  readonly="true" >
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="T.T.C.:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.noteDebitEnteteAchats.ndfTotTtc}" style="text-align:right;width:100%" readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.verrouRemise}"><h:outputText value="Remise:"/></h:column>
                <h:column rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.verrouRemise}">
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.noteDebitEnteteAchats.ndfTotRabais}" style="text-align:right;width:100%"  readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
                <h:column><h:outputText value="Solde:"/></h:column>
                <h:column>
                    <h:inputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.formBakingBeanAchats.formNoteDebitAchats.noteDebitEnteteAchats.var_reliquat}" style="text-align:right;width:100%"  readonly="true">
                        <jsp:include flush="true" page="/commun/formatNombreStructure.jsp"/>
                    </h:inputText>
                </h:column>
            </h:panelGrid>
        </h:column>
    </h:panelGrid>
</h:panelGrid>

<br>

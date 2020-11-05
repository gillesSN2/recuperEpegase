<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<f:subview id="visioconference">

    <form method = "post" target="_blank" action = "RedirectingPage.jsp">

        <center> <h2 style="color:green;font-size:18px;">Visio Conférence</h2></center>

        <h:panelGrid width="100%" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHangout==0}">
            <h:panelGroup id="p1">
                <center>
                    <br/><br/>
                    <img src="images/lock.png" alt="work"/>
                    <br/><br/><br/>
                    <h:outputText value="Cette fonction n'a pas été activée au niveau de l'entête de la société." style="width:100%;text-align:center;font-size:20px"/>
                    <br/><br/><br/><br/>
                </center>
            </h:panelGroup>
        </h:panelGrid>

        <h:panelGrid width="100%" border="0" rendered="#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHangout!=0}">
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHangout==1}">
                <center> <h3 style="color:green;font-size:18px;">HANGOUTS</h3></center>
                <h:outputLink id="lien1" value="https://hangouts.google.com/" target="blank" onclick="true" style="text-align:center;text-decoration:none;">
                    <h:outputText value="Démarrer la session HANGOUTS" style="text-align:center;text-decoration:none;"/>
                </h:outputLink>
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHangout==2}">
                <center> <h3 style="color:green;font-size:18px;">JITSI MEET</h3></center>
                <h:outputLink id="lien1" value="https://meet.jit.si/#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strid}-#{bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strraisonsociale}" target="blank" onclick="true" style="text-align:center;text-decoration:none;">
                    <h:outputText value="Démarrer la session JITSIT MEET" style="text-align:center;text-decoration:none;"/>
                </h:outputLink>
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHangout==3}">
                <center> <h3 style="color:green;font-size:18px;">GOOGLE MEET</h3></center>
                <h:outputLink id="lien2" value="https://meet.google.com/_meet?authuser=1" target="blank" onclick="true" style="text-align:center;text-decoration:none;">
                    <h:outputText value="Démarrer la session GOOGLE MEET" style="text-align:center;text-decoration:none;"/>
                </h:outputLink>
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHangout==4}">
                <center> <h3 style="color:green;font-size:18px;">U-MEETING</h3></center>
                <h:outputLink id="lien3" value="https://u.cyberlink.com/products/umeeting" target="blank" onclick="true" style="text-align:center;text-decoration:none;">
                    <h:outputText value="Démarrer la session U-MEETING" style="text-align:center;text-decoration:none;"/>
                </h:outputLink>
            </c:if>
            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.structureLog.strHangout==5}">
                <center> <h3 style="color:green;font-size:18px;">SKYPE</h3></center>
                <h:outputLink id="lien4" value="https://www.skype.com/fr/free-conference-call/" target="blank" onclick="true" style="text-align:center;text-decoration:none;">
                    <h:outputText value="Démarrer la session SKYPE" style="text-align:center;text-decoration:none;"/>
                </h:outputLink>
            </c:if>
        </h:panelGrid>

    </form>

</f:subview>


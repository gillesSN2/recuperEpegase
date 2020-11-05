<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="infos">

    <form method = "post" action = "RedirectingPage.jsp">

        <center> <h2 style="color:green;font-size:18px;">Les dernières news...</h2></center>

        <h:panelGrid width="100%" border="0">

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.urlProtocole=='https'}"var="ac1">
                <rich:tabPanel switchType="client" id="panelGlobal" style="border:0px;background-color:white;">
                    <rich:tab id="tabEuronews" label="Euronews">
                        <iframe width="100%" height="600px" src="https://fr.euronews.com/" frameborder="0" allowfullscreen></iframe>
                    </rich:tab>
                </rich:tabPanel>
            </c:if>

            <c:if test="${bakingbeanepegase.menuModuleHorizontalCtrl.urlProtocole=='http'}"var="ac1">
                <rich:tabPanel switchType="client" id="panelGlobal" style="border:0px;background-color:white;">
                    <rich:tab id="tabLCI" label="LCI">
                        <iframe width="100%" height="600px" src="http://lci.tf1.fr/" frameborder="0" allowfullscreen></iframe>
                    </rich:tab>
                    <rich:tab id="tabFInfo" label="France Infos">
                        <iframe width="100%" height="600px" src="http://www.francetvinfo.fr/" frameborder="0" allowfullscreen></iframe>
                    </rich:tab>
                    <rich:tab id="tabParisien" label="Le Parisien">
                        <iframe width="100%" height="600px" src="http://www.leparisien.fr/" frameborder="0" allowfullscreen></iframe>
                    </rich:tab>
                    <rich:tab id="tabTfm" label="TFM">
                        <iframe width="100%" height="600px" src="http://www.centraltv.fr/" frameborder="0" allowfullscreen></iframe>
                    </rich:tab>
                </rich:tabPanel>
            </c:if>

        </h:panelGrid>

    </form>

</f:subview>

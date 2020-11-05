<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<f:subview id="VideAdministration">

    <a4j:form >
        <h:column >
            <center>
                <h2>
                    <h:outputText value="ADMINISTRATION D'Horus l'Intégrale (Version 3.7.05-425 du 01/05/20)" style="color:green;"/><br>
                    <h:outputText value="#{bakingbeanepegase.menuModuleHorizontalCtrl.baseLog}" style="color:green;"/>
                </h2>
            </center>
        </h:column>
    </a4j:form>


</f:subview>

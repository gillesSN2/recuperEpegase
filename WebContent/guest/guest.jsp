<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>

<f:subview id="tiersguest">

    <center><h2><h:outputText value="Bonjour #{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrPrenom}, bienvenue dans votre compte de #{bakingbeanepegase.menuModuleHorizontalCtrl.usersLog.usrNomTiersGuest} !" styleClass="entete_accueil"/></h2></center>

    <a4j:form id="accl" >

        <h:inputHidden id="valUrl4" value="#{bakingbeanepegase.urlDocument}"/>

        <h:panelGrid style="height:500px;" width="100%">

       

        </h:panelGrid>


    </a4j:form>


</f:subview>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="t" uri="http://myfaces.apache.org/tomahawk"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="erreuroffice" >

     <center> <h2><h:outputText value="PROBLEME DROIT D'ACCES" style="color:green;"/></h2></center>

    <h:panelGrid width="100%" border="0">

        <h:panelGrid id="p1" width="100%" >

            <center>
                <br/><br/>
                <img src="images/lock.png" alt="work"/>
                <br/><br/>
                Vous n'avez pas le droit d'accéder à cette page car l'utilisateur en cours n'a pas de série affectée à la fonction en cours.....
                <br/><br/>
            </center>

        </h:panelGrid>

    </h:panelGrid>

</f:subview>
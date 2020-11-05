<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>


<h:panelGrid  id="radisson" border="0" width="100%" style="text-align:center;">

    <div style="text-align:center;">e-Pégase - RADISSON BLU</div>

    <br><br><br>
    <center>
        <h:panelGroup>
            <h:commandButton style="cursor:pointer;color:green;" action="#{bakingbeanepegase.connection}" value="Les cartes"/><br><br>

            <h:commandButton style="cursor:pointer;color:green;" action="#{bakingbeanepegase.connection}" value="Les évenements"/><br><br>

            <h:commandButton style="cursor:pointer;color:green;" action="#{bakingbeanepegase.connection}" value="Le livre d'Or"/><br><br><br><br>
        </h:panelGroup>
    </center>

</h:panelGrid>



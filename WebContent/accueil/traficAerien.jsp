<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="testInfoPc">

    <form method = "post" target="_blank">

        <center> <h2 style="color:green;font-size:18px;">Trafic Aérien</h2></center>

        <h:panelGrid width="100%" border="0">

            <c:redirect url="https://www.flightradar24.com/25.92,23.22/3" context="_blank"/>

        </h:panelGrid>

    </form>

</f:subview>

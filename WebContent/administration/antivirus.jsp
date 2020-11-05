<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="quickScan">

    <form method = "post" action = "RedirectingPage.jsp">

        <center> <h2 style="color:green;font-size:18px;">QuickScan - Analyse antivirus</h2></center>

        <h:panelGrid width="100%" border="0">

            <iframe
                name="test" frameborder=0 width=100% height=640 scrolling=yes src="http://quickscan.bitdefender.com/fr/">
            </iframe>

        </h:panelGrid>

    </form>

</f:subview>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@taglib prefix="a4j" uri="http://richfaces.org/a4j"%>

<f:subview id="testInternet">

    <form method = "post" action = "RedirectingPage.jsp">

        <center> <h2 style="color:green;font-size:18px;">Test bande passante</h2></center>

        <h:panelGrid width="100%" border="0">

            <rich:tabPanel switchType="client" immediate="true" style="border:0px;">

                <rich:tab label="Test Connexion">
                    <iframe
                        name="test" frameborder=0 width=100% height=640 scrolling=yes src="http://test-connexion.com/bande_passante.php">
                    </iframe>
                </rich:tab>

                 <rich:tab label="Test SpeedTest">
                    <iframe
                        name="test" frameborder=0 width=100% height=640 scrolling=yes src="http://www.speedtest.net/fr">
                    </iframe>
                </rich:tab>
                
            </rich:tabPanel>


        </h:panelGrid>

    </form>

</f:subview>
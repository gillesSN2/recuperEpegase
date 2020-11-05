<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Grapheur epegase</title>

        <script type="text/javascript" src="../css/highCharts/js/jquery.min.js"></script>
        <script type="text/javascript">
            $(function () {

                Highcharts.setOptions({
                    lang: {
                        decimalPoint: ',',
                        thousandsSep: ' '
                    },
                    global: {
                        useUTC: true
                    }
                });

                var listeDatas = document.getElementById('idListedatas').value;
                //alert('datas= ' + listeDatas);
                
                var titre = document.getElementById('idTitre').value;
                var sousTitre = document.getElementById('idSousTitre').value;
                var unite = document.getElementById('idUnite').value;
                var devise = document.getElementById('idDevise').value;
                var nbDec = document.getElementById('idNbDec').value;
                var datas = eval('('+ listeDatas +')');
                //alert('datas ' + datas);

                // Create the chart
                $('#container').highcharts( {
                    chart: {
                        plotBackgroundColor: null,
                        plotBorderWidth: null,
                        plotShadow: false,
                        type: 'pie'
                    },
                    title : {
                        text : titre,
                        x: -20 //center
                    },
                    subtitle : {
                        text : sousTitre,
                        x: -20 //center
                    },
                    exporting: {
                        enabled: true
                    },
                    tooltip: {
                        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                    },
                    plotOptions: {
                        pie: {
                            allowPointSelect: true,
                            cursor: 'pointer',
                            dataLabels: {
                                enabled: true,
                                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                                style: {
                                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                                }
                            }
                        }
                    },
                    series: [{
                            name: 'Brands',
                            colorByPoint: true,
                            data: datas
                        }]
                });
            });
        </script>
    </head>
    <body>
        <script type="text/javascript" src="../css/highCharts/js/highcharts.js"></script>
        <script type="text/javascript" src="../css/highCharts/js/themes/grid.js"></script>
        <script type="text/javascript" src="../css/highCharts/js/modules/exporting.js"></script>

        <input id='idTitre' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.texteTitre}"/>
        <input id='idSousTitre' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.texteSousTitre}"/>
        <input id='idUnite' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.unite}"/>
        <input id='idDevise' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.devise}"/>
        <input id='idNbDec' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.nbDec}"/>
        <input id='idTimeDecoupage' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.timeDecoupage}"/>
        <input id='idListedatas' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.listeDatasCamembert}"/>

        <div id="container" style="min-width: 310px; height: 500px; margin: 0 auto"></div>

    </body>
</html>
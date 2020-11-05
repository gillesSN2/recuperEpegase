<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Grapheur HORUS L'INTEGRALE</title>

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
                var timeDecoupage = document.getElementById('idTimeDecoupage').value;
                //alert('decoupage' + timeDecoupage);
                var decoupage = "1";
                var nbDecoupage = 0;
                if (timeDecoupage==0){
                    decoupage = ['01', '02', '03', '04', '05', '06','07', '08', '09', '10', '11', '12','13', '14', '15', '16', '17', '18','19', '20', '21', '22', '23', '24','25', '26', '27', '28', '29', '30','31']
                    nbDecoupage = 12;
                } else if (timeDecoupage==1){
                    decoupage = ['Janvier', 'Fevrier', 'Mars', 'Avril', 'Mai', 'Juin','Juillet', 'Aout', 'Septembre', 'Octobre', 'Novembre', 'Decembre']
                    nbDecoupage = 30;
                } else if (timeDecoupage==2){
                    decoupage = ['1er trimestre', '2eme trimestre', '3eme trimestre', '4eme trimestre']
                    nbDecoupage = 90;
                } else if (timeDecoupage==3){
                    decoupage = ['1er semestre', '2eme semestre']
                    nbDecoupage = 180;
                } else if (timeDecoupage==4){
                    decoupage = ['Annee']
                    nbDecoupage = 360;
                } else if (timeDecoupage==5){
                    decoupage = ['01', '02', '03', '04', '05', '06','07', '08', '09', '10', '11', '12','13', '14', '15', '16', '17', '18','19', '20', '21', '22', '23', '24']
                    nbDecoupage = 24;
                } else if (timeDecoupage==6){
                    decoupage = ['2009', '2010', '2011', '2012', '2013', '2014','2015', '2016', '2017', '2018', '2019', '2020']
                     nbDecoupage = 12;
                }
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
                        renderTo: 'container',
                        polar: true,
                        height: '500'
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
                    pane: {
                        startAngle: 0,
                        endAngle: 360
                    },
                    xAxis: {
                        tickInterval: nbDecoupage,
                        min: 0,
                        max: 360
                    },
                    yAxis: {
                        min: 0
                    },
                    plotOptions: {
                        series: {
                            pointStart: 0,
                            pointInterval: 30
                        },
                        column: {
                            pointPadding: 0,
                            groupPadding: 0
                        }
                    },
                    legend: {
                        layout: 'vertical',
                        align: 'right',
                        verticalAlign: 'middle',
                        borderWidth: 0
                    },
                    tooltip : {
                        valueDecimals : nbDec,
                        valueSuffix: devise
                    },
                    series : datas
                });
            });
        </script>
    </head>
    <body>
        <script type="text/javascript" src="../css/highCharts/js/highcharts.js"></script>
        <script type="text/javascript" src="../css/highCharts/js/highcharts-more.js"></script>
        <script type="text/javascript" src="../css/highCharts/js/themes/grid.js"></script>
        <script type="text/javascript" src="../css/highCharts/js/modules/exporting.js"></script>

        <input id='idTitre' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.texteTitre}"/>
        <input id='idSousTitre' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.texteSousTitre}"/>
        <input id='idUnite' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.unite}"/>
        <input id='idDevise' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.devise}"/>
        <input id='idNbDec' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.nbDec}"/>
        <input id='idTimeDecoupage' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.timeDecoupage}"/>
        <input id='idListedatas' type="hidden" value="${bakingbeanepegase.menuModuleHorizontalCtrl.listeDatas}"/>

        <div id="container" style="min-width: 310px; height: 500px; margin: 0 auto"></div>

    </body>
</html>
//
// Dynamsoft JavaScript Library for Basic Initiation of Dynamic Web TWAIN
// More info on DWT: http://www.dynamsoft.com/Products/WebTWAIN_Overview.aspx
//
// Copyright 2017, Dynamsoft Corporation 
// Author: Dynamsoft Team
// Version: 13.1
//
/// <reference path="dynamsoft.webtwain.initiate.js" />
var Dynamsoft = Dynamsoft || { WebTwainEnv: {} };

Dynamsoft.WebTwainEnv.AutoLoad = false;

///
Dynamsoft.WebTwainEnv.Containers = [{ContainerId:'dwtcontrolContainer', Width:400, Height:350}];

/// If you need to use multiple keys on the same server, you can combine keys and write like this 
/// Dynamsoft.WebTwainEnv.ProductKey = 'key1;key2;key3';
Dynamsoft.WebTwainEnv.ProductKey = '2648C24F4339F154C1E6C26AE2218A3DEE969E389B13759931E1B4C26FB49F2F2B9F690208BFB491E67245777FEA2ECB2B9F690208BFB4919E4C08B6CE26DF74EE969E389B1375993361ACB5BC42F8BF40000000;t0068WQAAAAh1VBrcPyfrD5/aG2pgoj/mCoZrODMBcSgv1JgpXhMW9AXadqFYuzh2Iqx16pD3sbN3JJYH+zbQuvAlvtlX9T4=';

///
Dynamsoft.WebTwainEnv.Trial = true;

///
Dynamsoft.WebTwainEnv.ActiveXInstallWithCAB = false;

///
Dynamsoft.WebTwainEnv.ResourcesPath = 'css/webtwain';

/// All callbacks are defined in the dynamsoft.webtwain.install.js file, you can customize them.
// Dynamsoft.WebTwainEnv.RegisterEvent('OnWebTwainReady', function(){
// 		// webtwain has been inited
// });


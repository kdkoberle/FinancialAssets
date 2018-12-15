<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10/24/18
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar navbar-expand navbar-dark bg-dark static-top">

<!-- Navbar -->
    <!-- TradingView Widget BEGIN -->
    <div class="tradingview-widget-container">
        <div class="tradingview-widget-container__widget"></div>
        <div class="tradingview-widget-copyright"><a href="https://www.tradingview.com" rel="noopener" target="_blank"><span class="blue-text">Quotes</span></a> by TradingView</div>
        <script type="text/javascript" src="https://s3.tradingview.com/external-embedding/embed-widget-tickers.js" async>
            {
                "symbols": [
                {
                    "title": "S&P 500",
                    "proName": "INDEX:SPX"
                },
                {
                    "title": "Nasdaq 100",
                    "proName": "INDEX:IUXX"
                },
                {
                    "description": "Gold",
                    "proName": "TVC:GOLD"
                },
                {
                    "description": "Silver",
                    "proName": "TVC:SILVER"
                },
                {
                    "description": "WTI Crude",
                    "proName": "TVC:USOIL"
                },
                {
                    "description": "Copper",
                    "proName": "OANDA:XCUUSD"
                }
            ],
                "locale": "en"
            }
        </script>
    </div>
    <!-- TradingView Widget END -->

</nav>

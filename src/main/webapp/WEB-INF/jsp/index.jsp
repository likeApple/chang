<%--
  Created by IntelliJ IDEA.
  User: chang
  Date: 2018/8/8
  Time: 10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Use correct character set. -->
    <meta charset="utf-8">
    <!-- Tell IE to use the latest, best version. -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Make the application on mobile take up the full browser screen and disable user scaling. -->
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no">
    <title>Hello World</title>
    <script src="${pageContext.request.contextPath}/static/cesium/Cesium.js"></script>
    <style>
        @import url(${pageContext.request.contextPath} /static/cesium/Widgets/widgets.css);

        html, body, #cesiumContainer {
            width: 100%;
            height: 100%;
            margin: 0;
            padding: 0;
            overflow: hidden;
        }
    </style>
</head>
<body>
<div id="cesiumContainer" class="fullSize"></div>
</div>
<script>
    var viewer = new Cesium.Viewer('cesiumContainer', {
        navigationHelpButton: false,
        infoBox: false,
        selectionIndicator: false,
        shadows: true,
        shouldAnimate: true
    });

    function createModel(url, height) {
        viewer.entities.removeAll();

        var position = Cesium.Cartesian3.fromDegrees(-123.0744619, 44.0503706, height);
        var heading = Cesium.Math.toRadians(135);
        var pitch = 0;
        var roll = 0;
        var hpr = new Cesium.HeadingPitchRoll(heading, pitch, roll);
        var orientation = Cesium.Transforms.headingPitchRollQuaternion(position, hpr);

        var entity = viewer.entities.add({
            name: url,
            position: position,
            orientation: orientation,
            model: {
                uri: url,
                minimumPixelSize: 128,
                maximumScale: 20000
            }
        });
        viewer.trackedEntity = entity;
    }

    createModel('../../static/cesium/SampleData/models/CesiumAir/Cesium_Air.glb', 5000.0)
</script>
</body>
</html>

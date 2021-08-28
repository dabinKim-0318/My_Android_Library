package     Android_UI


//안드로이드에서 화면을 그리는 방법
//-XML을 이용한다
//-XML? DSL(domain Specific Language) 언어
//도메인이라는 것은 범주를 말하는데 어떤 범주에 특화된 언어라는 것인데
//DSL언어는 여러가지가 있고 그중에서 XML이라는 언어로 화면을 구성하게 됨
//즉 안드로이드 UI를 그리기 위해 특화된 언어

//핸드폰마다 화면 크기가 다 다른데 어떻게 화면을 그려야 할까?
//-픽셓, dpi,dp단위
//-dpi(dot per inch):1cm화면에 픽셀 갯수 몇개?
//    -ldpi->120(1인치에 120픽셀, 가장 작은단위)
//    -mdpi->160
//    -hdpi->240
//    -xhdpi->320
//    -xxhdpi->480
//    -xxxhdpi->640
//-dp(Density Independent Pixcel):픽셀 독립적인 단위
//픽셀단위 대신 dp단위로 사용하면 어느 기종(해상도)에서나 UI가 동일하게 보임
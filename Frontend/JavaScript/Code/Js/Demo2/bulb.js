light = false;  // 初始是关闭的



function control() {
    var bulb = document.getElementById("bulb");
    if (!light) {  // 关闭 -> 点亮
        bulb.src = "../img/bulb_on.png";
        light = true;
    } else {
        bulb.src = "../img/bulb_off.jpg";
        light = false;
    }
}
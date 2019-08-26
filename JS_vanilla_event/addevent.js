window.onload=function(){

    const title = document.querySelector('#title');
    const resizeTag = document.querySelector('#resizeWindow');

    const BASE_COLOR = "rgba(255, 255, 255, 0.9)";
    const OTHER_COLOR = "rgba(0, 150, 0, 0.9)";

    function init(){
        title.style.color = BASE_COLOR;
        title.addEventListener('click', handleClick);
        allStyle(title);
        spanNumbering();

        title.className = 'shadowTag';
    }
    
    function handleClick() {
        const currentColor = title.style.color;
        if (currentColor === BASE_COLOR) {
            title.style.color = OTHER_COLOR;
        } else {
            title.style.color = BASE_COLOR;
        }
    };
    
    function resizeWindowTag(event) {
        resizeTag.innerHTML = '<BR>'+Date(event.timeStamp);
        console.dir(event);
    }
    
    window.addEventListener('resize', resizeWindowTag);

    function spanNumbering() {
    
        const spanChild = document.querySelectorAll('.spanChild');
        for (let index = 1; index <= spanChild.length; index++) {
            const textColor = `rgb(${Math.round(Math.random()*250)}, ${Math.round(Math.random()*250)}, ${Math.round(Math.random()*250)})`
            const backColor = `rgb(${Math.round(Math.random()*250)}, ${Math.round(Math.random()*250)}, ${Math.round(Math.random()*250)})`
            spanChild[index-1].innerHTML = index;
            spanChild[index-1].style.color = textColor;
            spanChild[index-1].style.cursor = 'pointer';
            spanChild[index-1].style.backgroundColor = backColor;
            spanChild[index-1].addEventListener('click',spanNumbering);
        }

    }


    function allStyle(querytag) {
    const query = querytag.style;
        query.transition = '1s all';
        query.position = 'fixed'
        query.animationName = 'shot';
        query.animationDuration = '1s';
        query.left = '25vw';
        query.top = '0';
    }
    
    init();
}

const clockContainer = document.querySelector('.js-clock');
const clockTitle = document.querySelector('h1');
// const clockTitle = clockContainer.querySelector('h1');

function getTime() {
    const date = new Date();
    const minutes = date.getMinutes();
    const hours = date.getHours();
    const seconds = date.getSeconds();
    clockTitle.innerHTML = `${zerofill(hours)}:${zerofill(minutes)}:${zerofill(seconds)}`
}
function zerofill(time) {
    if (time<10) {
        time = `0${time}`;
    }
    return time;
}

function init() {
    getTime();
    setInterval(getTime,500);
}

init();

function hi(){
	console.log('hi')
}
function bye(){
	console.log('bye')
}
window.addEventListener('online',hi);
window.addEventListener('offline',bye);

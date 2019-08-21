$(document).ready(function() {
    var menuLink = $('.burger');
    var menu = $('.menu');
    var close = $('.btn-close');
    var navLink = $('ul li a');
    var content = $('.content');

    menuLink.click(function() {
        menu.toggleClass('menu_active');
    });

    close.click(function() {
        menu.toggleClass('menu_active');
    });

    navLink.on('click', function(event) {
        event.preventDefault();
        var target = $(this).attr('href');        
        var top = $(target).offset().top;        
        $('html, body').animate({scrollTop: top}, 500);
        menu.toggleClass('menu_active');
    });

    content.click(function() {
        menu.toggleClass('menu_active');
    });
});

// let menuLink = document.querySelector('.burger'),
//     menu = document.querySelector('.menu'),
//     close = document.querySelector('.btn-close'),
//     navLink = document.getElementsByTagName('a');

// window.addEventListener('DOMContentLoaded', function() {
    
//     menuLink.addEventListener('click', () => {
//         menu.classList.add('menu_active');
//     });

//     close.addEventListener('click', () => {
//         menu.classList.remove('menu_active');
//     });   
// });
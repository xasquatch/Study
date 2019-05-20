/* 북마크 추가 함수 */
function CreateBookmarkLink(url, title) {
    if (window.sidebar && window.sidebar.addPanel) {   // FF ver 23 이하.
        window.sidebar.addPanel(title, url, '');
    } else {
        if (window.external && ('AddFavorite' in window.external)) {    // IE
            window.external.AddFavorite(url, title);
        } else {    // Others
            alert('주소창에서 <Ctrl+D>를 누르시면 즐겨찾기에 등록됩니다.');
        }
    }
}

function viewXsheild() {
    window.open("/html/xsheild.html","xsheild","height=460,width=400,scrollbars=no");
}

function viewsafeshop() {
    window.open("/html/safeshop.html","safe","height=215,width=350,scrollbars=no");
}
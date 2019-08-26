const toDoForm = document.querySelector('#insertToDo-form');
const toDoList = document.querySelector('#insertToDo-listGroup');
const newToDo = document.querySelector('#toDoSomething');
const saveList = document.querySelector('.saveList');


function formEvent(event) {
    
    let complatedList = new Array();
    
    event.preventDefault();

    if (localStorage.getItem('toDoListKey')) {
        const toDos = JSON.parse(localStorage.getItem('toDoListKey'));
        complatedList = toDos.concat(newToDo.value);
        createToDos(toDos.length,newToDo.value);
    } else {
        complatedList.push(newToDo.value);
        createToDos(0,newToDo.value);
    }
    console.log(complatedList);
    localStorage.setItem('toDoListKey',JSON.stringify(complatedList));
    
    newToDo.value = '';
}

function createToDos(index, toDoValue) {

    const deleteTag = document.createElement('span');
    const toDoContent = document.createElement('span');
    const li = document.createElement('li');
    
    deleteTag.innerText = 'X';
    deleteTag.classList.add('deleteIcon')
    deleteTag.classList.add('pointer');
    deleteTag.id = `${index}`
    deleteTag.addEventListener('click',deleteToDos);

    toDoContent.innerText = `${toDoValue} `;
    
    li.classList.add('ToDosList-noneDeco');
    li.appendChild(toDoContent);
    li.appendChild(deleteTag);
    
    toDoList.appendChild(li);
} 

function deleteToDos(event) {

    this.parentNode.remove();
    let toDos = JSON.parse(localStorage.getItem('toDoListKey'));
    toDos.splice(this.id,1)
    localStorage.setItem('toDoListKey',JSON.stringify(toDos));
    
    let listIndex = document.querySelectorAll('.deleteIcon');
    for (let index = 0; index < listIndex.length; index++) {
        listIndex[index].id = index;
    }
    
    // showingSavebtn();
}

// function showingSavebtn(){
//     saveList.classList.remove('noneDisplay');
//     saveList.classList.add('visible');
//     saveList.classList.add('pointer');

    
// }

// function SaveCurrentList(){

//     let toDos = JSON.parse(localStorage.getItem('toDoListKey'));
//     toDos.splice(this.id,1)
//     localStorage.setItem('toDoListKey',JSON.stringify(toDos));

// }


function showingToDos() {
    
    if (localStorage.getItem('toDoListKey')) {
        const toDos = JSON.parse(localStorage.getItem('toDoListKey'));

        for (let index = 0; index < toDos.length; index++) {
            createToDos(index, toDos[index]);
        }
    }
}
    
    
    function init() {
        toDoForm.addEventListener('submit',formEvent);
        showingToDos();
    }

init();

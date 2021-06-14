//Sometimes, two or more elements can be clicked simultaneously
//if both of these elemnts respond to being clicked, which one happnes
//first?
//Event Propegation is the process by which we can determine the order
//of events occuring
//
//The two types of event prepegation are bubbling and capturing
//bubbling occurs when the events occur from innermost element to the
//outermost element
//capturing is when the outermost element occurs first and then
//the will occur in order inwards
//by default, bubbling will occur

let capturing = true;
let bubbling = false;

//when you add an event listener, there is a third (optional) parameter
//that you may provide. If it is true, the event will propegate according
//to capturing. If it is false, it will propegate via bubbling.


document.getElementById("inner").addEventListener("click",function(e){
    alert("INNER - bubbling");
    // e.stopImmediatePropagation();// stops all event propegation
}, bubbling);

document.getElementById("middle").addEventListener("click",function(){
    alert("MIDDLE - bubbling");
}, bubbling);

document.getElementById("outer").addEventListener("click",function(){
    alert("OUTER - bubbling");
}, bubbling);

document.getElementById("inner").addEventListener("click",function(){
    alert("INNER - capturing");
}, capturing);

document.getElementById("middle").addEventListener("click",function(e){
    alert("MIDDLE - capturing");
    // e.stopPropagation(); //only stops the cascade to the next bubbling
    // or capturing listener
    // e.stopImmediatePropagation();
    //stop all propegation, including other listeners on the same element
}, capturing);

document.getElementById("middle").addEventListener("click",function(){
    alert("MIDDLE - capturing-again");
    
},capturing)

document.getElementById("outer").addEventListener("click",function(){
    alert("OUTER - capturing");
}, capturing);




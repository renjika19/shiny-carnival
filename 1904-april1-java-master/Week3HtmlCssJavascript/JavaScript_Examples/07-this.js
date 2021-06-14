/*
    Now, will will discuss the 'this' keyword in JS.
    so, there are 3 main situations where the 'this' keyword
    will act in 3 completely diffent ways:

    -when used alone, it refers to the global window object
    -when used in the context of an object, it refers to the
    caller's property
    -when we use it with event handlers, it refers to the html
    element that is the recipient of the event
*/
//the 'this' keyword used alone:
var windowObject = this; //the value of windowObject variable is indeed,
//the window
console.log(windowObject);

//'this' used within a funciton:
var bigFoot = "Bigfoot is real.";
function aFunc(){
    var bigFoot = "Bigfoot is a myth.";
    console.log(this.bigFoot);
}
console.log(bigFoot);
aFunc();

//used wihtin an event handler (within an HTML file), the 'this' keyword
//will refer to the element that it is attached to
//<button onclick="this.style.display='none'">This Is Button Text</button>
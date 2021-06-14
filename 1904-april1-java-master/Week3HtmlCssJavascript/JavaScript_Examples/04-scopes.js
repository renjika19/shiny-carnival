'use strict'; // use stric is a "mode" in javascript that basically enforces certain
//good coding habits
//for example, now, if you were to do x = 24 by itself, this would throw an error
var x=24;
//note that you can also 'use strict' within a funciton,
//and it will only affect that function (because of scopes)
/*
    There are two "main scopes" in javascript: global and functional scope
    scope determiens the accessibility of variables
    global scope is the most general scope and is available everywhere
    
    variables declared outside of functions using the var keyword
    are in the "global scope"
    if you do not explicitly use the 'var' keyword to declare,
    it will just be done implicitly for you
*/
//for example, the following is in global scope:
var a = 10;


funScope();
function funScope(){
    //functional scope is where the variable is available within
    //just the function in which it was declared
    //also accomplished with the var keyword
    console.log(c); //undefined
    var c =7;
    console.log(c);// 7

    /*
        Now let's talk about something called 'hoisting'
        if you declare a varibale with var, its declaration will get hoisted
        to the top of it's scope. Hoisting is when you move the declaration
        at runtime.
        JS will hoist all object declarations to the top of its own scope
        (funcitonal or global)
    */
}

/*
    Lexical scoping was introduced in ES6
    it allows for block scoping (same as lexical scoping)
    we will talk more about ES6 later
*/
blockScope();
function blockScope(){
    if(true){
        //console.log(b);// this will give you an error since b is not yet declared
        //you can utilize block scoping with the let and the const keywords
        //they both allow for block scoping
        //let may not be redeclared
        //const may not be redeclared or redefined
        let d =10;
        const e = 10;//this creates a constant
        //one thing to note, is that these two keywords do not get hoisted
        //let d = 11; //can't do this becasue you can only declare let once
        //e = 12;// can't do this because you can't reassign a const
    }
    //console.log(d);// these two will give an error because you don't have
                    //access to these outside of the block that they were
                    //declared
    //console.log(e);
}
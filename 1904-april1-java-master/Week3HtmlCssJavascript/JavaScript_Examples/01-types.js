//A JavaScript function is a block of JavaScript code that can be executed when called for
function logType(input){
    console.log('input is: ' + input + ' \n\tand is type of: ' +typeof(input));
}

/*
    There are several dataypes in JS(that we will tlak about)
    number
    string
    boolean
    null*
    undefined
    object
*/
//JavaScript does have types but the variables are dynamically or loosely typed
//Dynamic typing means that the same variable can hold different datatypes:
// var x; //at this point, x is of type undefined
// x = 5; //now, x is a number
// x = "john" // now x is a string
//The fact that you can cause a variable to accept different types is called: type coercion
var a = "hello"; //you can use ' or " for strings
logType(a);
logType(5);
logType(5.5);
logType(true);
logType({}); //js objects are written within curly braces
            //object properties are written as name:value pairs separated by commas
logType([1,2,3]); //array
logType(null); //null is something we have to assign that means "nothing"
                //nulls are "typeof" Object...but this is supposed to be considered a "bug"
logType(undefined); //undefined menas the variable has literally never been assigned
                    //compared to null which is an assignment of something ... to nothing
var f; //will be undefined
logType(f);

logType(NaN);
logType(5/'a');
logType(5/0);
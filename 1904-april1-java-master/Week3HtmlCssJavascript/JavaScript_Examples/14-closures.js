/*
    What are Closures?
    Closures:
    1) Allow an inner function to access an enclosing function's variables
    2) Allow an inner function to preserve (closure) an enclosing function's
    scope chain when this enclosing function is executed

    basically.... it is the way that encapsulation is perfomred in JS
*/

function cake(){
        var flour = true;
        var cornMill = false;
        var cupsSugar =1;

        function bake(){
            var heat = 350;
            console.log("Bake that cake at "+heat+"!");
            console.log(`Flour: ${flour}`);
            console.log(`cornMill: ${cornMill}`);
            console.log(`Cups of Sugar: ${cupsSugar}`);

            heat++;
            flour = !flour;
            cornMill = !cornMill;
            cupsSugar++;
        }
        return bake;
}
var x = cake();
/*
    So our inner function bake has the following scope chains:
    1)It has access to its own scope (the variable 'heat' in this case)
    2)It has access to the enclosing funciton's variables (so 'flour',
    'cornMill', 'sugar') because it encloses them when the outer function
    is exectued
    3)It has access to any globally scoped variables that are defined.
*/

//Notice that the function above returns a function. This means that
//the value of x is the function bake(), making x a function. As a result,
//we can write x() to execute bake().

//It is also worth noting that the value of x is not the execution of
// the bake function but rather the function itself

//So.... let's do this thing
console.log("===========")
x();
console.log("===========")
x();
console.log("===========")
x();

/*
    1st Run:
    Bake that cake at 350!
    Flour: true
    cornMill: false
    Cups of Sugar: 1

    So the value of heat, which is defined in the inner function is 350.
    The value of flour, which has been preserved from our outer funciton
    is true.
    The value of cornMill is false
    the value of cupsSugar is 1
*/

/*
    2nd Run:
    Bake that cake at 350!
    Flour: false
    cornMill: true
    Cups of Sugar: 2

    note that the value of heat has not changed. That is because the
    heat's scope is the inner function. As a result, it is redeclared
    each time the inner function is run, so its value is not preserved.

    The rest behave "as you would expect"
*/

//ANOTHER example....
function William(){
    var name = "william";
    var hobby = "working";
    var mood = "?";
    return {
        getName:function(){
            return name;
        },
        setName:function(n){
            name = n;
        }
    }
}


let me = new William(); //instantiate a new William
//or
//let me = William();
console.log(me.getName());
me.setName("notWilliam");
console.log(me.getName());
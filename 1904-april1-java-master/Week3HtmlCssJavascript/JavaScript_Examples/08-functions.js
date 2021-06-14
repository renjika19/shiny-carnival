function add(a=0,b=0){// you can give params default values
    return a + b;
}
//note that you can call functions with any number of parameters:
console.log(add(10,20)); //normal
console.log(add(5)); // supplies 0 for b since not specified
console.log(add());// supplies 0 for a and 0 for b
console.log(add(10,20,30,40,800,9001)); //ignores additional inputs

//arrow functions or arrow notation was introduced int ES6
//the are similar to lambdas... but arguably easier
let OtherAdd = (one,two) =>{
    return one + two;
}

console.log(OtherAdd(1,2));

//note that if you have exactly one parameter, you dont need ()
//if you do not add the curly braces, it will automatically return
/*
    The destructuring assignment syntax is a JavaScript expression
    that makes it possible to unpack values from arrays, or properties form objects
    into distinct variables
*/

var a, b, rest;
[a,b] = [10,20];
console.log(a);
console.log(b);

[a,b, ...rest] = [10, 20, 30, 40, 50];
console.log(rest);
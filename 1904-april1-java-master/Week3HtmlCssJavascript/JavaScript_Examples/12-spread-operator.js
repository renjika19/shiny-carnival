//the spread operator '...' allows you to iterate through an existing object
//this is not varags!... this is also not java btw
function sum(x,y,z){
    return x + y + z;
}

const numbers = [1,2,3];

console.log(sum(...numbers));
console.log(sum(1,2,3));//note that this is equal to the line above
console.log(sum.apply(null,numbers));// don't worry about this one too much

let a ={
    f1:5,
    f2:2,
    f3:'test',
    f4:true,
    f5:[1,3,10,2,1]
}

let b = {
    ...a,
    f2:1000,
    f5:[... a.f5,6]
}

console.log(b);